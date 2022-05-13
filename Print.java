package br.ucsal;

public class Print {

	public static void p (double dbl) {
		System.out.printf("%.2f", dbl);
	}

	public static void p (int vlr) {
		System.out.println(vlr);
	}

	public static void p (String str) {
		System.out.println(str);
	}
	
	public static void p (String [] vetor) {
		System.out.print(vetor);
	}

	public static void tab(String[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print(tabuleiro[i][j] +	" ");}
			System.out.println(" ");
		}
		
	}

}
