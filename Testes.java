public class Testes {
    public static void main(String[] arg) {

            int [][] quadricula = Sudoku2.gq();
            Sudoku2.imprimirQD(quadricula);
            permutarColunas(quadricula, 1,2);
            System.out.println(" ");
            Sudoku2.imprimirQD(quadricula);
            
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
     */
    public static void permutarColunas(int[][] matriz, int coluna1, int coluna2) {
        int auxiliar; // recebe o valor de matriz[coluna1][i] antes que este seja substituído
        for (int i = 0; i < matriz.length; i++) {
            auxiliar = matriz[i][coluna1];
            matriz[i][coluna1] = matriz[i][coluna2];
            matriz[i][coluna2] = auxiliar;
        }
    }
}