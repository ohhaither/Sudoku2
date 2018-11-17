public class Testes {
    public static void main(String[] arg) {
        int[][] matriz = Sudoku2.gq();
        Sudoku2.imprimirQD(matriz);
        System.out.println(verificar(matriz));

    }
    /**
     * Este método consegue por enquanto, verificar apenas a validade das linhas
     * @param matriz
     * @return
     */
    public static boolean verificar(int[][] matriz) {
        for (int v = 1; v <= matriz.length; v++) {
            for (int i = 0; i < matriz.length; i++) { // Em cada linha
                boolean encontradoNaLinha = false;
                for (int j = 0; j < matriz.length; j++) { // Em cada coluna da linha
                    if (v == matriz[i][j]) { // Se o valor desta posição for igual ao número
                        encontradoNaLinha = true; // O número está presente nesta linha
                        break;
                    }
                }
                if (encontradoNaLinha == false) {
                    System.out.printf("linha %d não contém %d\n", i, v);
                    return false;
                }
            }
        }
        return true;
    }
}