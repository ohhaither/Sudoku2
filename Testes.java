public class Testes {
    public static void main(String[] arg) {

            int [][] quadricula = Sudoku2.gq();
            Sudoku2.imprimirQD(quadricula);
            System.out.println(" ");
            blocos(quadricula);
            
    }

   public static void blocos (int [][] matriz) {
        int [] vetor = new int[9]; 
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
                for (int k = 0; k < vetor.length; k++)
                    System.out.print(vetor[k] + " ");
                System.out.println();
            }
            linhaDeBlocos++;
        }
   }
}