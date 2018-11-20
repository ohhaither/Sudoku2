import java.util.Scanner;

public class Sudoku2 {

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
        int[] base = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int contador = 0; // o número de equivalencias encontradas
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if (base[i] == vetor[j]) {
                    contador++;
                    break;
                }
            }
        }
        return (contador == base.length && vetor.length == base.length);
    }

    /**
     * Verifica se cada linha, cada coluna e cada bloco da quadrícula contem todos os dígitos de um a nove
     * @param matriz matriz a ser analizada
     * @return {@code true} se for válida, {@code false} se não
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
}
