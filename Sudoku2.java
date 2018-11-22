import java.util.Scanner;
import java.util.Random;

public class Sudoku2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] quad = gq();
        imprimirQD(quad);
        System.out.println();
        permutarNumeros(quad, 8, 6);
        System.out.println();
        imprimirQD(quad);
    }
    
    /**
     * Gera uma quadrícula 9x9 preenchidada com números de 1 a 9
     * @return quadrícula inserida numa matriz
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
     * imprime uma matriz no terminal
     * @param matriz matriz a ser impriida
    */
    public static void imprimirQD(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) { // linha
            for (int j = 0; j < matriz.length; j++) // coluna
                System.out.print(matriz[i][j] + " ");
            System.out.println();
        }
    }
        
    /**
     * Faz a leitura de um número inteiro no terminal  e certifica que este encontre-se no intervalo 
     * indicado, apresentando uma mensagem de erro caso não se encontre
     * @param scan instancia da classe Scanner para que se faça a leitura
     * @param inicio início do intervalo
     * @param fim do intervalo
     * @param msgErro mensagem apresentada caso o número inserido não encontre-se no intervalo
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

    // Se adicionar espaços entre os intervalos haverá erro
    /**
     * Lê uma quadrícula inserida linha por linha no terminal
     * @param scan instancia da classe Scanner usada para ler no teminal
     */
    public static int[][] lerQuadricula(Scanner scan) {
        int[][] quadricula = new int [9][9];
        for (int i = 0; i < 9; i++) { // para cada linha da matriz
            int cont = 0;
            do {
                int linha = scan.nextInt(); // linha inserida pelo usuário
                int j = 8; // contador dos dígitos de num e indice para as colunas respetivamente
                while (linha > 0) {
                    cont++;
                    quadricula[i][j] = linha % 10;
                    linha /= 10;
                    j--;
                }
                if (cont < 9) {
                    System.out.println
                    ("A linha deve ter pelos menos 9 dígitos" 
                    + "\nSe tiver mais o exesso será excluído.\nTente novamente!");
                    cont = 0;
                }
            } while (cont < 9);
        }
        System.out.println();
        for (int i = 0; i < quadricula.length; i++) {
            for (int j = 0; j < quadricula.length; j++)
                System.out.print(quadricula[i][j]);
            System.out.println();
        }
        return quadricula;
    }

    /**
     * Verifica se um vetor contém todos os números de um a nove
     * @param vetor vetor a ser analizado
     * @return true se f«o vetor for válido, false se não for
     */
    public static boolean validadeDoVetor(int[] vetor) {
        int produto = 1, tamanho = 0;
        for (int i = 0; i < vetor.length; i++) {
            produto *= vetor[i];
            tamanho++;
        }
        return ((produto == 1*2*3*4*5*6*7*8*9) && (tamanho == 9))? true : false;
    }
    
    /**
     * Verifica se todas as linhas, colunas e blocos de uma matriz contêm os núemeros de 1 a 9
     * @param matriz matriz a ser analizada
     * @return true se a matriz for válidade, false se não
     */
    public static boolean validadeDaQuadricula(int[][] matriz) {
        boolean validade = true;
        int[] vetor = new int[matriz.length]; // recebe a linha/coluna/bloco a ser verfificado
        for (int i = 0; i < matriz.length; i++) {
            // linhas
            for (int j = 0; j < matriz.length; j++)
                vetor[j] = matriz[i][j]; // o vetor recebe uma linha da matriz por vez para verificação
            if (!validadeDoVetor(vetor)) {// verificação da validade do vetor
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
            // faixa de blocos
            for (int p = 0; p < vetor.length / 3; p++) { // para cada coluna de blocos 
                int o = 0; // repetições para o vetor
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
     */
    public static void permutarLinhas(int[][] matriz, int linha1, int linha2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        if(validarPermutacao(sudoku,linha1,linha2)==true){
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[linha1][i];
            matriz[linha1][i] = matriz[linha2][i];
            matriz[linha2][i] = auxiliar;
        }
      }else
            System.out.println("Permutação inválida. Por favor tente de novo.")
    }
    
    /**
     * Faz a permutação dos valores de duas colunas escolhidas numa matriz
     * Obs: Ter em conta que o índice das colunas começa em 0
     * @param matriz matriz a ser modificada
     * @param linha1 primeira coluna a permutar
     * @param linha2 segunda coluna a permutar
     */
    public static void permutarColunas(int[][] matriz, int coluna1, int coluna2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        if(validarPermutacao(sudoku,coluna1,coluna2)==true){
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[i][coluna1];
            matriz[i][coluna1] = matriz[i][coluna2];
            matriz[i][coluna2] = auxiliar;
        }
      }else
            System.out.println("Permutação inválida. Por favor tente de novo.")
    }
    
    /**
     * Faz a permutação dos valores de duas faixa horizontais escolhidas numa matriz de 9x9.
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a ser permutar
     * @param faixa2 segunda faixa a ser permutar
     * @requires {@code (faixa1 >= 0 && faixa1 <= 2) && (faixa2 >= 0 && faixa2 <= 2)}
     */
    public static void permutarFaixasHorizontais(int[][] matriz, int faixa1, int faixa2) {
        int linha1 = faixa1 * 3, linha2 = faixa2 * 3;
        if(validarPermutacaoFaixas(sudoku,faixa1,faixa2)==true){
        for (int i = 0; i < matriz.length/3; i++) {
            permutarLinhas(matriz, linha1, linha2);
            linha1++;
            linha2++;
        }
      }else
            System.out.println("permutação inválida. Tente novamente.");
    }

    /**
     * Faz a permutação dos valores de duas faixa verticais escolhidas numa matriz de 9x9
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a permutar
     * @param faixa2 segunda faixa a permutar
     * @requires {@code (faixa1 >= 1 && faixa1 <= 3) && (faixa2 >= 1 && faixa2 <=)}
     */
    public static void permutarFaixasVerticais(int[][] matriz, int faixa1, int faixa2) {
        int coluna1 = faixa1 * 3, coluna2 = faixa2 * 3;
        if(validarPermutacaoFaixas(sudoku,faixa1,faixa2)==true){
        for (int i = 0; i < matriz.length/3; i++) {
            permutarColunas(matriz, coluna1, coluna2);
            coluna1++;
            coluna2++;
        }
      }else
            System.out.println("permutação inválida. Tente novamente.");
    }

    /* n1 e n2 serão gerados aleatoriamente no métoto main para que possam ser reutilizados
    para dizer ao usuáio quais números foram alterados por exemplo */
    /**
     * Dados n1 e n2, procura todas as ocorencias de n1 numa matriz e substirui por n2 e vice-versa
     * @param matriz matriz a ser modificada
     * @param n1 primeiro número a permutar
     * @param n2 segundo número a permutar
     */
    public static void permutarNumeros(int[][] matriz, int n1, int n2) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j] == n1)
                    matriz[i][j] = 0;
                if(matriz[i][j] == n2)
                    matriz[i][j] = n1;
                if(matriz[i][j] == 0)
                    matriz[i][j] = n2;
            }
        }
    }
    /**
     * O conteúdo da linha {@code i} passa a ser o da linha {@code matriz.length - 1 - i} 
     * e vice-versa.
     * @param matriz matriz a ser modificada
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
     * O conteúdo da coluna {@code j} passa a ser o da linha {@code matriz.length - 1 - j} 
     * e vice-versa.
     * @param matriz matriz a ser modificada
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
    public static boolean validarPermutacao(int[][]n, int i,int m) {
	    boolean validar = false;
	    if(i>=1 && i<=3 && m>=1 && m<=3)
	        validar=true;
	    if(i>=4 && i<=6 && m>=4 && m<=6)
	        validar=true;
	    if(i>=7 && i<=9 && m>=7 && m<=9)
	        validar=true;
	    return validar;
    }
    public static boolean validarPermutacaoFaixas(int[][]n,int i,int m) {
	    boolean validar=false;
	    if(i>=1 && i<=3 && m>=1 && m<=3)
	        validar=true;
	    return validar;
    }

}
