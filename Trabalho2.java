import java.util.Random;
import java.util.Scanner;

public class Trabalho2
{

    public static void main(String[] args)
    {
	imprimirQD(GQ());
	imprimirMenu(opcoes);
    }

    public static void imprimirQD(int[][] matriz)
    {
	for (int i = 0; i < matriz.length; i++)
	{ // linha
	    for (int j = 0; j < matriz.length; j++) // coluna
		System.out.print(matriz[i][j] + " ");
	    System.out.println();
	}
    }

    public static int[][] GQ()
    {
	int[][] quadricula = new int[9][9];
	for (int l = 0; l < quadricula.length; l++)
	{
	    for (int c = 0; c < quadricula.length; c++)
	    {
		quadricula[l][c] = (l / 3 + 3 * (l % 3) + c) % 9 + 1;
	    }
	}
	return quadricula;
    }
    
    public static int[][] permutacaonumeros(int[][] n){
	Random rand1= new Random();
	Random rand2= new Random();
	int n1=rand1.nextInt(9)+1;
	int n2=rand2.nextInt(9)+1;
	for (int i = 0; i < n.length; i++)
	{
	    for (int j = 0; j < n.length; j++)
	    {
		if(n[i][j]==n1)
		  n[i][j]=0;
		if(n[i][j]==n2)
		    n[i][j]=n1;
		if(n[i][j]==0)
		    n[i][j]=n2;
	    }
	}
	return n;
    }

    public static int[][] reflexaoVertical(int[][] n)
    {
	int comprimento = n.length;
	int temp;
	for (int i = 0; i < comprimento / 2; i++)
	{
	    for (int j = 0; j < comprimento; j++)
	    {
		temp = n[i][j];
		n[i][j] = n[comprimento - 1 - i][j];
		n[comprimento - 1 - i][j] = temp;
	    }
	}
	return n;
    }

    public static int[][] reflexaoHorizontal(int[][] n)
    {
	int comprimento = n.length;
	int temp;
	for (int i = 0; i < comprimento; i++)
	{
	    for (int j = 0; j < comprimento / 2; j++)
	    {
		temp = n[i][j];
		n[i][j] = n[i][comprimento - 1 - j];
		n[i][comprimento - 1 - j] = temp;
	    }
	}
	return n;
    }

    public static int[][] permutacaoLinhas(int[][] sudoku, int n1, int n2)
    {
	
	int temp;
	for(int c=0;c<sudoku.length;c++) {
	    temp=sudoku[n1-1][c];
	    sudoku[n1-1][c]=sudoku[n2-1][c];
	    sudoku[n2-1][c]=temp;
	}
	
	return sudoku;
    }
    

    
    public static int[][] permutacaoColunas(int[][] sudoku, int n1, int n2)
    {
	
	int temp;
	for(int c=0;c<sudoku.length;c++) {
	    temp=sudoku[c][n1-1];
	    sudoku[c][n1-1]=sudoku[c][n2-1];
	    sudoku[c][n2-1]=temp;
	}
	
	
	
	
	return sudoku;
    }
    
    public static int[][] permutacaoFaixasV(int[][] sudoku, int n1, int n2){


	for (int i = 0; i < 3; i++) {
	    sudoku = permutacaoColunas(sudoku, (n1*3)-i, (n2*3)-i);	    
	}
	    
	
	return sudoku;
    }
    
    public static int[][] permutacaoFaixasH(int[][] sudoku, int n1, int n2){


	for (int i = 0; i < 3; i++) {
	    sudoku = permutacaoLinhas(sudoku, (n1*3)-i, (n2*3)-i);	    
	}
	    
	
	return sudoku;
    }

    public static String[] opcoes =
    { // menu
	    "0 - Sair", "1 - Aplicar permutacao de dois numeros",
	    "2 - Aplicar permutacao de duas linhas de uma mesma faixa horizontal",
	    "3 - Aplicar permutação de duas colunas de uma mesma faixa vertical",
	    "4 - Aplicar permutacao de duas faixas horizontais", "5 - Aplicar permutacao de duas faixas verticais",
	    "6 - Aplicar reflexao horizontal", "7 - Aplicar reflexao vertical", "8 - Indicar quadricula" };

    public static void imprimirMenu(String[] s)
    {
	int[][] sudoku = GQ();
	for (int i = 0; i < s.length; i++)
	    System.out.println(s[i]);

	Scanner numero = new Scanner(System.in);
	System.out.print(s);
	// char d =
	char d;
	do
	{
	    d = numero.next().charAt(0);

	    switch (d)
	    {
	    case '1':
		sudoku= permutacaonumeros(sudoku);
		break;
	    case '2':
		sudoku = permutacaoLinhas(sudoku, Character.getNumericValue(numero.next().charAt(0)), Character.getNumericValue(numero.next().charAt(0)));
		break;
	    case '3':
		sudoku = permutacaoColunas(sudoku, Character.getNumericValue(numero.next().charAt(0)), Character.getNumericValue(numero.next().charAt(0)));
		break;
	    case '4':
		sudoku = permutacaoFaixasH(sudoku, Character.getNumericValue(numero.next().charAt(0)), Character.getNumericValue(numero.next().charAt(0)));
		break;
	    case '5':
		sudoku = permutacaoFaixasV(sudoku, Character.getNumericValue(numero.next().charAt(0)), Character.getNumericValue(numero.next().charAt(0)));
		break;
	    case '6':
		sudoku = reflexaoHorizontal(sudoku);
		break;
	    case '7':
		sudoku = reflexaoVertical(sudoku);
		break;
	    case '0':
		return;
		
	    }
	    imprimirQD(sudoku);
		for (int i = 0; i < s.length; i++)
		    System.out.println(s[i]);
	} while (d != '0');

    }

}
