import java.util.Scanner;

public class Sudoku2 {

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
    // Se inserir espaçoes entre os dígitos haverá um erro
    /**
     * Lê uma quadrícula inserida linha por linha no terminal
     * @param scan instancia da classe Scanner usada para ler no teminal
     */
<<<<<<< HEAD
    public static void lerQuadricula(Scanner scan) {
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
                    ("A linha deve ter pelos menos 9 dígitos\nSe tiver mais o exesso será excluído.\nTente novamente!");
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
=======
    public static boolean validadeDoVetor(int[] vetor) {
        int produto = 1, tamanho = 0;
        for (int i = 0; i < vetor.length; i++) {
            produto *= vetor[i];
            tamanho++;
        }
        return ((produto == 1*2*3*4*5*6*7*8*9) && (tamanho == 9))? true : false;
    }

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
        return validade;
>>>>>>> parent of 42cab60... adicionada fuincionalidade de verficação de blocos ao método validadeDaQuadricula (editado)
    }
}
