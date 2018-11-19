import java.util.Scanner;

public class Sudoku2 {

    public static void main(String[] args) {
        int[][] quadricula = gq();
        imprimirQD(quadricula);
        System.out.println(" ");
        System.out.println(validadeDaQuadricula(quadricula));
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
     * Gera uma quadrícula de 9x9 preenchidada com números de 1 a 9
     * @return quadrícula inserida numa matriz
     */
    public static int[][] gq () {
    int [][] quadricula = new int[9][9]; 
    for(int i = 0; i < quadricula.length; i++) {
        for(int o = 0; o < quadricula.length; o++)
            quadricula[i][o] = (i / 3 + 3 * (i % 3) + o) % 9 + 1;
    }
    return quadricula;
    }

    /**
     * Verifica se um vetor tem 9 elementos e se contem os valores de um a 9
     * @param vetor vetor a ser analizado
     * @return true se o vetor for válido, false se não o for
     */
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
    }
}
