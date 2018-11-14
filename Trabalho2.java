import java.util.Scanner;

public class Trabalho2
{
public static void main(String[] args) {
    jogo= new int[9][9]; 
    for(int i=0;i<jogo.length;i++){
	for(int o=0;o<jogo.length;o++) {
	    jogo[i][o]=(i/3+3*(i%3)+o)%9+1;
	System.out.print(jogo[i][o] + " ");
	}
	System.out.println();
    }
    Scanner numero=new Scanner(System.in);
    int n=numero.nextInt();
    while(n !=0 || permutacao(9, 9)==false) {
	
    }
}
public static int[][]jogo;

public static boolean permutacao(int n,int m) {
    int contadorLinha=0;
    int contadorColuna=0;
    
    for(int i=0;i<jogo.length;i++) {
	for(int j=0;j<jogo.length;j++) {
	contadorLinha += jogo[i][i];
	contadorColuna += jogo[j][j];
	}
    }
    if(contadorLinha !=45 && contadorColuna !=45)
	return false;
    return true;
    
}

private static final String[]opcoes={
"0 - Sair",
"1 - Aplicar permutacao de dois numeros",
"2 - Aplicar permutacao de duas linhas de uma mesma faixa horizontal",
"3 - Aplicar permutação de duas colunas de uma mesma faixa vertical",
"4 - Aplicar permutacao de duas faixas horizontais",
"5 - Aplicar permutacao de duas faixas verticais",
"6 - Aplicar reflexao horizontal",
"7 - Aplicar reflexao vertical",
"8 - Indicar quadricula"};{
for(int i=0;i<opcoes.length;i++)
    System.out.println();
}

}