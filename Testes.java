import java.util.Scanner;
public class Testes {
    public static void main(String[] arg) {
<<<<<<< HEAD
        Scanner scan = new Scanner(System.in);
        int[] vetor = new int[3];
        vetor = scan.nextInt();
    }

=======

            int [][] quadricula = Sudoku2.gq();
            Sudoku2.imprimirQD(quadricula);
            permutarFaixasVerticais(quadricula, 1, 3);
            System.out.println(" ");
            Sudoku2.imprimirQD(quadricula);
            
    }

    /**
     * Faz a permutação dos valores de duas faixa horizontais escolhidas numa matriz de 9x9.
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a ser permutar
     * @param faixa2 segunda faixa a ser permutar
     * @requires {@code (faixa1 >= 1 && faixa1 <= 3) && (faixa2 >= 1 && faixa2 <=)}
     */
    public static void permutarFaixasHorizontais(int[][] matriz, int faixa1, int faixa2) {
        int auxiliarm, linha1 = 0, coluna2 = 0;
        switch (faixa1) {
            case 2:
                linha1 = 3;
                break;
            case 3:
                linha1 = 6;
                break;
        }
        switch (faixa2) {
            case 2:
                linha2 = 3;
                break;
            case 3:
                linha2 = 6;
                break;
        }
        for (int i = 0; i < matriz.length/3; i++) {
            for (int o = 0; o < matriz.length; o++) {
                auxiliar = matriz[linha1][o];
                matriz[linha1][o] = matriz[linha2][o]; 
                matriz[linha2][o] = auxiliar;
            }
            linha1++;
            linha2++;
        }
    }

    /**
     * Faz a permutação dos valores de duas faixa verticais escolhidas numa matriz de 9x9
     * @param matriz matriz a ser modificada
     * @param faixa1 primeira faixa a permutar
     * @param faixa2 segunda faixa a permutar
     * @requires {@code (faixa1 >= 1 && faixa1 <= 3) && (faixa2 >= 1 && faixa2 <=)}
     */
    public static void permutarFaixasVerticais(int[][] matriz, int faixa1, int faixa2) {
        int auxiliar, coluna1 = 0, coluna2 = 0;
        switch (faixa1) {
            case 2:
                coluna1 = 3;
                break;
            case 3:
                coluna1 = 6;
                break;
        }
        switch (faixa2) {
            case 2:
                coluna2 = 3;
                break;
            case 3:
                coluna2 = 6;
                break;
        }
        for (int i = 0; i < matriz.length/3; i++) {
            for (int o = 0; o < matriz.length; o++) {
                auxiliar = matriz[o][coluna1];
                matriz[o][coluna1] = matriz[o][coluna2]; 
                matriz[o][coluna2] = auxiliar;
            }
            coluna1++;
            coluna2++;
        }
    }
>>>>>>> parent of 42cab60... adicionada fuincionalidade de verficação de blocos ao método validadeDaQuadricula (editado)
}