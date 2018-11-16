import java.util.Scanner;

public class Sudoku2 {

public static void main(String[] args) {
    int[][] quadricula = gq();
    imprimirQD(quadricula);

Scanner numero = new Scanner(System.in);
int n = numero.nextInt();

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
 */public static int[][] gq () {
    int [][] quadricula = new int[9][9]; 
    for(int i = 0; i < quadricula.length; i++) {
        for(int o = 0; o < quadricula.length; o++)
            quadricula[i][o] = (i / 3 + 3 * (i % 3) + o) % 9 + 1;
        System.out.println();
    }
    return quadricula;
}
/*public static int[][] lerQuadricula() {
    for (int i = 1; i <= 9; i++) {
        System.out.println("insira a primeira linha");
    }
}*/

public static boolean permutacao(int n,int m, int[][] matriz) { // verifica se o jogo está completo.Em progresso
    int contadorLinha = 0;
    int contadorColuna = 0;
    
    for(int i = 0;i < matriz.length; i++) {
	for(int j = 0;j < matriz.length; j++) {
	contadorLinha += matriz[i][i];
	contadorColuna += matriz[j][j];
	}
    }
    if(contadorLinha != 45 && contadorColuna != 45)
	return false;
    return true;
}

private static final String[]opcoes={ //menu
"0 - Sair",
"1 - Aplicar permutacao de dois numeros",
"2 - Aplicar permutacao de duas linhas de uma mesma faixa horizontal",
"3 - Aplicar permutação de duas colunas de uma mesma faixa vertical",
"4 - Aplicar permutacao de duas faixas horizontais",
"5 - Aplicar permutacao de duas faixas verticais",
"6 - Aplicar reflexao horizontal",
"7 - Aplicar reflexao vertical",
"8 - Indicar quadricula"};{
for(int i = 0;i < opcoes.length; i++)
    System.out.println();
}

}
