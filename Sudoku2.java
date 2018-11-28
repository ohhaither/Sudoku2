
import java.util.Scanner;
import java.util.Random;
/**
 * @author Tomás Marques,fc52794
 * @author Fábio Furtado,fc53456
 */
public class Sudoku2 {
    
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner scan = new Scanner(System.in);
        start(ran, scan);
    }
    
    /**
     * Gera uma quadrícula 9x9 preenchidada com números de 1 a 9 e insere-a num vetor bidimensional
     * @return matriz bidimencional com a quadrícula gerada
     */
    public static int[][] gq () {
        int [][] quadricula = new int[9][9]; 
        for(int i = 0; i < quadricula.length; i++) {
            for(int j = 0; j < quadricula.length; j++)
                quadricula[i][j] = (i / 3 + 3 * (i % 3) + j) % 9 + 1;
        }
        return quadricula;
    }

    /**
     * imprime matrizes no terminal
     * @param matriz matriz a ser imprimida
     * @requires {@code matriz !=null}
    */
    public static void imprimirQD(int[][] matriz) {
        int l = 0; // índice da linha
        for (int g = 0; g < matriz.length / 3; g++) { // por cada faixa
            System.out.println("-------------------------");
            for (int i = 0; i < matriz.length / 3; i++) { // por cada linha
                for (int j = 0; j < matriz.length; j++) { // por cada coluna
                    if (j == 0|| j == 3 || j == 6)
                        System.out.print("| ");
                    System.out.print(matriz[l][j] + " "); // impressão linha da célula
                }
                System.out.print("|");
                System.out.println();
                l++; // linha
            }
        }
        System.out.println("-------------------------");
    }
    
    /**
     * Lê uma quadrícula inserida no terminal. Os seus valores devem ser inseridos
     * separados por espaços, por mudânça de linha ou ambos.
     * @param scan leitor
     * @return quadrícula inserida numa matriz
     */
    public static int[][] lerQuadricula(Scanner scan) {
        int[][] quadricula = new int[9][9];
        for (int i = 0; i < quadricula.length; i++) {
            for (int j = 0; j < quadricula[0].length; j++) {
                quadricula[i][j] = scan.nextInt();
            }
        }
        return quadricula;
    }

    /**
     * Faz a leitura de um número inteiro no terminal  e certifica que este encontre-se no intervalo 
     * indicado, apresentando uma mensagem de erro caso não se encontre
     * @param scan leitor
     * @param inicio início do intervalo
     * @param fim do intervalo
     * @param msgErro mensagem apresentada caso o número inserido não se encontre no intervalo
     * @return número depois depois de ser aceite
     */
    public static int lerNumeroNoIntervalo(Scanner scan, int inicio, int fim, String msgErro) {
        int num;
        do {
            num = scan.nextInt();
            if (num < inicio || num > fim)
                System.out.println(msgErro);
        } while (num < inicio || num > fim);
        return num;
    }

    /**
     * Verifica se um vetor tem tamanho 9 e contém todos os números de um a nove
     * @param vetor vetor a ser analizado
     * @return true se o vetor for válido, false se não for
     */
    public static boolean validadeDoVetor(int[] vetor) {
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // valores a comparar
        boolean validade = true; // validadde do vetor
        if (vetor.length == 9) {
            for (int i = 0; i < valores.length; i++) { // por cada elemento em valores
                boolean estaPresente = false;
                for (int j = 0; j < vetor.length; j++) { // por cada elemento em vetor
                    if (valores[i] == vetor[j])
                        estaPresente = true;
                }
                if (!estaPresente) {
                    validade = false;
                    break;
                }
            }
        }
        else // Se vetor.length for != 9 a invalidade é imediatamente comprovada
            validade = false;
        return validade;
    }
    
    /**
     * Verifica se todas as linhas, colunas e blocos de uma matriz contêm
     * os núemeros de 1 a 9
     * @param matriz matriz a ser analizada
     * @requires {@code matriz != null}  
     * @return true se a matriz for válida, false se não
     */
    public static boolean validadeDaQuadricula(int[][] matriz) {
	boolean validade = true;
        int[] vetor = new int[matriz[0].length]; // recebe a linha/coluna/bloco a ser verfificado
        for (int i = 0; i < matriz.length; i++) {
            // linhas
            for (int j = 0; j < matriz.length; j++)
                vetor[j] = matriz[i][j]; // o vetor recebe uma linha da matriz por vez para verificação
            if (!validadeDoVetor(vetor)) { // verificação da validade do vetor
                validade = false;
                break;
            }
            // colunas
            for (int j = 0; j < matriz.length; j++)
                vetor[j] = matriz[j][i]; // o vetor recebe uma coluna da matriz por vez para verificação
            if (!validadeDoVetor(vetor)) { // verificação da validade do vetor
                validade = false;
                break;
            }
        }
        // blocos
        int linhaDeBlocos = 0;
        for (int q = 0; q < vetor.length / 3; q++) { // para cada linha de blocos
            int colunaDeBlocos = 0;
            for (int p = 0; p < vetor.length / 3; p++) { // para cada coluna de blocos 
                int o = 0; // índice para o vetor
                // bloco
                int cont = 0;
                for (int i = linhaDeBlocos * 3; cont < 3; i++) { // para cada linha do bloco
                    int cont2 = 0;
                    for (int j = colunaDeBlocos * 3; cont2 < 3; j++) { // para cada coluna do bloco
                        vetor[o] = matriz[i][j];
                        o++;
                        cont2++;
                    }
                    cont++;
                }
                colunaDeBlocos++;
                if (!validadeDoVetor(vetor))
                    validade = false;
            }
            linhaDeBlocos++;
        }
        return validade;
    }

     /**
     * Faz a permutação dos valores de duas linhas escolhidas numa matriz
     * Obs: Ter em conta que o índice das linhas começa em 0
     * @param matriz matriz a ser modificada
     * @param linha1 primeira linha a permutar
     * @param linha2 segunda linha a permutar
     * @requires {@code matriz != null}
     * @requires {@code (linha1 => 0 && linha1 <= 8) && (linha2 => 0 && linha2 <= 8)}
     */
    public static void permutarLinhas(int[][] matriz, int linha1, int linha2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[linha1][i];
            matriz[linha1][i] = matriz[linha2][i];
            matriz[linha2][i] = auxiliar;
        }
    }
    
    /**
     * Faz a permutação dos valores de duas colunas escolhidas numa matriz
     * Obs: Ter em conta que o índice das colunas começa em 0
     * @param matriz matriz a ser modificada
     * @param linha1 primeira coluna a permutar
     * @param linha2 segunda coluna a permutar
     * @requires {@code matriz != null}
     * @requires {@code (coluna1 => 0 && coluna1 <= 8) && (coluna2 => 0 && coluna2 <= 8)}
     */
    public static void permutarColunas(int[][] matriz, int coluna1, int coluna2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[i][coluna1];
            matriz[i][coluna1] = matriz[i][coluna2];
            matriz[i][coluna2] = auxiliar;
        }
    }
    
    /**
     * Faz a permutação dos valores de duas faixa horizontais escolhidas numa matriz de 9x9.
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a ser permutar
     * @param faixa2 segunda faixa a ser permutar
     * @requires {@code matriz != null}
     * @requires {@code (faixa1 >= 0 && faixa1 <= 2) && (faixa2 >= 0 && faixa2 <= 2)}
     */
    public static void permutarFaixasHorizontais(int[][] matriz, int faixa1, int faixa2) {
        int linha1 = faixa1 * 3, linha2 = faixa2 * 3; // linhas de iníco
        // Faz a permutação linha por linha
        for (int i = 0; i < matriz.length/3; i++) {
            permutarLinhas(matriz, linha1, linha2);
            linha1++;
            linha2++;
        }
    }

    /**
     * Faz a permutação dos valores de duas faixa verticais escolhidas numa matriz de 9x9
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a permutar
     * @param faixa2 segunda faixa a permutar
     * @requires {@code matriz != null}
     * @requires {@code (faixa1 >= 0 && faixa1 <= 2) && (faixa2 >= 0 && faixa2 <= 2)}
     */
    public static void permutarFaixasVerticais(int[][] matriz, int faixa1, int faixa2) {
        int coluna1 = faixa1 * 3, coluna2 = faixa2 * 3; // colunas de início
        // Faz a permutação coluna por coluna
        for (int i = 0; i < matriz.length/3; i++) {
            permutarColunas(matriz, coluna1, coluna2);
            coluna1++;
            coluna2++;
        }
    }

    /* n1 e n2 serão gerados aleatoriamente no métoto main para que possam 
       ser reutilizados para dizer ao usuáio quais números foram alterados 
       por exemplo */
    /**
     * Dados n1 e n2, procura todas as ocorencias de n1 numa matriz e substirui 
     * por n2 e vice-versa
     * @param matriz matriz a ser modificada
     * @param n1 primeiro número a permutar
     * @param n2 segundo número a permutar
     * @requires {@code matriz != null}
     */
    public static void permutarNumeros(int[][] matriz, int n1, int n2) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j] == n1)
                    matriz[i][j] = n2;
                else if(matriz[i][j] == n2)
                    matriz[i][j] = n1;
            }
        }
    }

    /**
     * O conteúdo da linha {@code i} passa a ser o da linha {@code matriz.length - 1 - i} 
     * e vice-versa.
     * @param matriz matriz a ser modificada
     * @requires {@code matriz != null}
     */
    public static void reflexaoHorizontal(int[][] matriz) {
        for (int i = 0; i < matriz.length / 2; i++) { // linhas
            for (int j = 0; j < matriz.length; j++) { //colunas
                int auxiliar = matriz[i][j];
                matriz[i][j] = matriz[matriz.length - 1 - i][j];
                matriz[matriz.length - 1 - i][j] = auxiliar;
            }
        }
    }
    
    /**
     * O conteúdo da coluna {@code j} passa a ser o da linha {@code matriz[0].length - 1 - j} 
     * e vice-versa.
     * @param matriz matriz a ser modificada
     * @requires {@code matriz != null}
     */
    public static void reflexaoVertical(int[][] matriz) {
        for (int j = 0; j < matriz.length / 2; j++) {
            for (int i = 0; i < matriz.length; i++) {
                int auxiliar = matriz[i][j];
                matriz[i][j] = matriz[i][matriz.length - 1 - j];
                matriz[i][matriz.length - 1 - j] = auxiliar;
            }
        }
    }

    // Trabalha com números de 1 a 9
    /** 
     * Restringe o valor de e2 de acordo com o valor de e1, garantindo que ambos encontram-se
     * na mesma faixa da quadrícula, sendo que e1 e e2 representam índices de linhas ou colunas.
     * Recebe e1 com indexagem de 0 a 8 e retorna e2 com indexagem de 1 a 9.
     * @param scan leitor
     * @param msgErro mensagem apresentada caso os e1 e e2 não se encontrem na mesma faixa
     * @param e1 número que restringe o valor introduzido pelo scanner
     * @requires {@code e1 >=0 && e1 <= 8} 
     * @ensures {@code \result >= 1 && <= 9}
     * @return um valor válido para a segunda faixa   
     */
    public static int validarPermutacao(Scanner scan, String msgErro, int e1) {
        int e2 = 0;
        if (e1 >= 0 && e1 <= 2)
            do {
                e2 = scan.nextInt();
                if (e2 < 1 || e2 > 3)
                    System.out.println(msgErro);
            } while (e2 < 1 || e2 > 4);
        else if (e1 >= 3 && e1 <= 5) {
            do {
                e2 = scan.nextInt();
                if (e2 < 4 || e2 > 6)
                System.out.println(msgErro);
            } while (e2 < 4 || e2 > 6);
        }
        else if (e1 >= 6 && e1 <= 8)
            do {
                e2 = scan.nextInt();
                if (e2 < 7 || e2 > 9)
                    System.out.println(msgErro);
            } while (e2 < 7 || e2 > 9);
        return e2;
    }

    /** 
     * Imprime e executa as opções de acordo com a opção do utilizador
     * @param ran randomizador
     * @param scan número introduzido pelo utilizador de forma a inicializar e executar as funções
     */
    public static void start(Random ran, Scanner scan) {
        String[] opcoes = { 
            "0 - Sair",
            "1 - Aplicar permutação de dois numeros aleatórios",
            "2 - Aplicar permutação de duas linhas de uma mesma faixa horizontal",
            "3 - Aplicar permutação de duas colunas de uma mesma faixa vertical",
            "4 - Aplicar permutação de duas faixas horizontais", 
            "5 - Aplicar permutação de duas faixas verticais",
            "6 - Aplicar reflexão horizontal",
            "7 - Aplicar reflexão vertical",
            "8 - Indicar quadricula" }; // menu
            
        int[][] sudoku = gq();
        int opcao = 1;
        do {
            System.out.println(" ");
            System.out.println("Quadrícula corente: ");
            imprimirQD(sudoku);
            System.out.println(" ");
            // Imprime as opções
            for (int i = 0; i < opcoes.length; i++)
                System.out.println(opcoes[i]);
            opcao = lerNumeroNoIntervalo
            (scan, 0, 9, "Opção inválida: insira um valor entre 1 e 9"); // escolha da opção
            switch (opcao) {
                case 1: // Permutação de números
                    int n1 = ran.nextInt(9) + 1, n2 = n1;
                    while (n2 == n1) // de modo a evitar n1 e n2 iguais
                        n2 = ran.nextInt(9) + 1;
                    permutarNumeros(sudoku, n1, n2);
                    System.out.printf("Foram permutados os valores %d e %d%n", n1, n2);
                    break;
                case 2: // Permutação de linhas
                    System.out.print("Insira a primeira linha (1 a 9): ");
                    int linha1 = lerNumeroNoIntervalo(scan, 1, 9,
                    "Valor inválido: insira um valor entre 1 e 9") - 1;
                    System.out.print("Insira a segunda linha: ");
                    int linha2 = validarPermutacao
                    (scan, "Inválido: As linhas têm de estar na mesma faixa", linha1) - 1;
                    permutarLinhas(sudoku, linha1, linha2);
                    break;
                case 3: // Permutação de colunas
                    System.out.print("Insira a primeira coluna: ");
                    int coluna1 = lerNumeroNoIntervalo(scan, 1, 9,
                    "Valor inválido: Insira um valor entre 1 e 9") - 1;
                    System.out.print("Insira a segunda coluna: ");
                    int coluna2 = validarPermutacao
                    (scan, "Erro: As colunas têm de estar na mesma faixa", coluna1) - 1;
                    permutarColunas(sudoku, coluna1, coluna2);
                    break;
                case 4: // Permutação de faixas horizontais
                    System.out.print("Insira a primeira faixa: ");
                    int faixaH1 = lerNumeroNoIntervalo
                    (scan, 1, 3, "Valor inválido\nInsira um valor entre 1 e 3") - 1;
                    System.out.print("Insira a segunda faixa: ");
                    int faixaH2 = lerNumeroNoIntervalo
                    (scan, 1, 3, "Valor inválido\nInsira um valor entre 1 e 3") - 1;
                    permutarFaixasHorizontais(sudoku, faixaH1, faixaH2);
                    break;
                case 5: // Permutação de faixas Verticais
                    System.out.print("Insira a primeira faixa: ");
                    int faixaV1 = lerNumeroNoIntervalo
                    (scan, 1, 3, "Valor inválido: Insira um valor entre 1 e 3") - 1;
                    System.out.print("Insira a segunda faixa: ");
                    int faixaV2 = lerNumeroNoIntervalo
                    (scan, 1, 3, "Valor inválido: Insira um valor entre 1 e 3") - 1;
                    permutarFaixasVerticais(sudoku, faixaV1, faixaV2);
                    break;
                case 6: // Reflexão horizontal
                    reflexaoHorizontal(sudoku);
                    System.out.println("Foi aplicada a reflexão horizontal");
                    break;
                case 7: // Reflexão vertical
                    reflexaoVertical(sudoku);
                    System.out.println("Foi aplicada a reflexão vertical");
                    break;
                case 8: // inserção de quadrícula
                    /* Convém que a leitura da quadrícula tenha o seu próprio Scanner de
                    forma a eitar bugs na eventualidade da inserção de valores excessivos */
                    Scanner scanQuad = new Scanner(System.in);
                    int[][] quadricula = lerQuadricula(scanQuad);
                    if (validadeDaQuadricula(quadricula)) {
                        sudoku = quadricula;
                        System.out.println("Quadrícula válida");
                    }
                    else
                        System.out.println("Quadrícula inválida");
                    break;
            }
        } while (opcao != 0);
        System.out.println(" ");
        System.out.println("Até à próxima! :)");
    }
}
