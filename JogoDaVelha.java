package br.ucsal;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args, String nomeJogador) {

		Print.p("\nJOGO DA VELHA");

		tabuleiro();

		String [] [] tabuleiro = tabuleiro();
		Print.tab(tabuleiro);

		char escolhaPeca = pecaInicial(nomeJogador);
		
		jogoON(escolhaPeca, tabuleiro, nomeJogador);

	}

	public static String [] [] tabuleiro() {

		String [] [] tabuleiro = {

				{"-", "1", "-", "2", "-", "3", "-"},
				{"1", " ", "|", " ", "|", " ", "|"},

				//campos jogáveis [1][1], [1][3], [1][5]

				{"-", "-", "-", "-", "-", "-", "-"},
				{"2", " ", "|", " ", "|", " ", "|"},

				//campos jogáveis [3][1], [3][3], [3][5]

				{"-", "-", "-", "-", "-", "-", "-"},
				{"3", " ", "|", " ", "|", " ", "|"},

				//campos jogáveis [5][1], [5][3], [5][5]

				{"-", "-", "-", "-", "-", "-", "-"},
		};	

		return tabuleiro;

	}

	public static char pecaInicial(String nomeJogador) {

		char escolhaPeca;

		do {

			Print.p("\n" + nomeJogador + ", quem começa, 'X' ou 'O'?");
			Scanner sc = new Scanner(System.in);
			escolhaPeca = sc.next().charAt(0);

		} while (escolhaPeca != 'x' && escolhaPeca	!= 'X' && escolhaPeca != 'o' && escolhaPeca	!= 	'O');

		if (escolhaPeca == 'x') {
			escolhaPeca = 'X';
		} else if (escolhaPeca == 'o') {
			escolhaPeca = 'O';		
		}

		return escolhaPeca;
	}

	public static String [] [] jogoON(char escolhaPeca, String [] [] tabuleiro, String nomeJogador) {

		int coluna, linha;
		boolean vitoria = false;
		boolean ninguemGanha = false;		

		do {
			if (escolhaPeca == 'X') {

				do {
					linha = jogadaLinhaX(tabuleiro);
					coluna = jogadaColunaX(tabuleiro);

				} while (validarJogada(tabuleiro, linha, coluna) == false);

				tabuleiro[linha][coluna] = "X";
				Print.tab(tabuleiro);

				vitoria = vitoria(tabuleiro, nomeJogador, linha, coluna);
				ninguemGanha = ninguemGanha(tabuleiro, nomeJogador);

				if(vitoria == false && ninguemGanha == false) {

					do {
						linha = jogadaLinhaO(tabuleiro);
						coluna = jogadaColunaO(tabuleiro);
					} while (validarJogada(tabuleiro, linha, coluna) == false);

					tabuleiro[linha][coluna] = "O";

					Print.tab(tabuleiro);

					vitoria = vitoria(tabuleiro, nomeJogador, linha, coluna);
					ninguemGanha = ninguemGanha(tabuleiro, nomeJogador);
				}

			} else if (escolhaPeca == 'O') {

				do {
					linha = jogadaLinhaO(tabuleiro);
					coluna = jogadaColunaO(tabuleiro);
				} while (validarJogada(tabuleiro, linha, coluna) == false);

				tabuleiro[linha][coluna] = "O";

				Print.tab(tabuleiro);

				vitoria = vitoria(tabuleiro, nomeJogador, linha, coluna);
				ninguemGanha = ninguemGanha(tabuleiro, nomeJogador);

				if(vitoria == false && ninguemGanha == false) {

					do {
						linha = jogadaLinhaX(tabuleiro);
						coluna = jogadaColunaX(tabuleiro);

					} while (validarJogada(tabuleiro, linha, coluna) == false);

					tabuleiro[linha][coluna] = "X";
					Print.tab(tabuleiro);

					vitoria = vitoria(tabuleiro, nomeJogador, linha, coluna);
					ninguemGanha = ninguemGanha (tabuleiro, nomeJogador);

				}
			}  	

		} while (vitoria == false && ninguemGanha (tabuleiro, nomeJogador) == false);

		return tabuleiro;		 

	}

	public static boolean validarJogada(String [][] tabuleiro, int linha, int coluna) {

		boolean validarJogada = false;

		if(tabuleiro[linha][coluna] == " ") {
			
			//tabuleiro[linha][coluna] = "X";
			//validarJogada = true;
			/*} else if (tabuleiro[linha][coluna] == " ") {
			tabuleiro[linha][coluna] = "X";*/
			
			validarJogada = true;
		}

		return validarJogada;
	}

	public static boolean vitoria(String [] [] tabuleiro, String nomeJogador, int linha, int coluna) {

		boolean vitoria = false;

		if 		(tabuleiro[1][1] == tabuleiro[1][3] && tabuleiro[1][1] == tabuleiro[1][5] && tabuleiro[1][1] == "X"  || 
				tabuleiro[3][1] == tabuleiro[3][3] && tabuleiro[3][1] == tabuleiro[3][5] && tabuleiro[3][1] == "X" ||
				tabuleiro[5][1] == tabuleiro[5][3] && tabuleiro[5][1] == tabuleiro[5][5] && tabuleiro[5][1] == "X" ||

				tabuleiro[1][1] == tabuleiro[3][1] && tabuleiro[1][1] == tabuleiro[5][1] && tabuleiro[1][1] == "X"  || 
				tabuleiro[1][3] == tabuleiro[3][3] && tabuleiro[1][3] == tabuleiro[5][3] && tabuleiro[1][3] == "X"  || 
				tabuleiro[1][5] == tabuleiro[3][5] && tabuleiro[1][5] == tabuleiro[5][5] && tabuleiro[1][5] == "X" || 

				tabuleiro[1][1] == tabuleiro[3][3] && tabuleiro[1][1] == tabuleiro[5][5] && tabuleiro[1][1] == "X"  || 
				tabuleiro[5][1] == tabuleiro[3][3] && tabuleiro[5][1] == tabuleiro[1][5] && tabuleiro[5][1] == "X")

		{	
			vitoria = true;
			Print.p("Parabéns! Vitória de 'X'!");
			aindaQuerJogar(nomeJogador);

		} else if 	(tabuleiro[1][1] == tabuleiro[1][3] && tabuleiro[1][1] == tabuleiro[1][5] && tabuleiro[1][1] == "O"  || 
				tabuleiro[3][1] == tabuleiro[3][3] && tabuleiro[3][1] == tabuleiro[3][5] && tabuleiro[3][1] == "O" ||
				tabuleiro[5][1] == tabuleiro[5][3] && tabuleiro[5][1] == tabuleiro[5][5] && tabuleiro[5][1] == "O" ||

				tabuleiro[1][1] == tabuleiro[3][1] && tabuleiro[1][1] == tabuleiro[5][1] && tabuleiro[1][1] == "O"  || 
				tabuleiro[1][3] == tabuleiro[3][3] && tabuleiro[1][3] == tabuleiro[5][3] && tabuleiro[1][3] == "O"  || 
				tabuleiro[1][5] == tabuleiro[3][5] && tabuleiro[1][5] == tabuleiro[5][5] && tabuleiro[1][5] == "O" || 

				tabuleiro[1][1] == tabuleiro[3][3] && tabuleiro[1][1] == tabuleiro[5][5] && tabuleiro[1][1] == "O"  || 
				tabuleiro[5][1] == tabuleiro[3][3] && tabuleiro[5][1] == tabuleiro[1][5] && tabuleiro[5][1] == "O")
		{

			vitoria = true;
			Print.p("Parabéns! Vitória de 'O'!");
			aindaQuerJogar(nomeJogador);

		}

		return vitoria;
	}

	public static int jogadaLinhaX(String [] [] tabuleiro) {

		int linha;
		Scanner sc = new Scanner(System.in);

		do {

			Print.p("Jogada de 'X':"
					+ "\nEm qual linha você deseja inserir 'X'?");
			linha = sc.nextInt();

			switch (linha) {

			case 1: 
				linha = 1;
				break;

			case 2: 
				linha = 3;
				break;

			case 3: 
				linha = 5;
				break;

			default:
				Print.p("Erro inesperado");
			}
		}

		while (linha != 1 && linha != 3 && linha != 5);

		return linha;

	}

	public static int jogadaColunaX(String [] [] tabuleiro) {

		int coluna;
		Scanner sc = new Scanner(System.in);

		do {

			Print.p("\nEm qual coluna você deseja inserir 'X'?");

			coluna = sc.nextInt();

			switch (coluna) {

			case 1: 
				coluna = 1;
				break;

			case 2: 
				coluna = 3;
				break;

			case 3: 
				coluna = 5;
				break;

			default: Print.p("Erro inesperado");

			}

		}

		while (coluna != 1 && coluna != 3 && coluna != 5);

		return coluna;

	}

	public static int jogadaLinhaO(String [] [] tabuleiro) {

		int linha;
		Scanner sc = new Scanner(System.in);

		do {

			Print.p("Jogada de 'O':"
					+ "\nEm qual linha você deseja inserir 'O'?");
			linha = sc.nextInt();

			switch (linha) {

			case 1: 
				linha = 1;
				break;

			case 2: 
				linha = 3;
				break;

			case 3: 
				linha = 5;
				break;

			default:
				Print.p("Erro inesperado");

			}
		}

		while (linha != 1 && linha != 3 && linha != 5);

		return linha;

	}

	public static int jogadaColunaO(String [] [] tabuleiro) {

		int coluna;
		Scanner sc = new Scanner(System.in);

		do {

			Print.p("\nEm qual coluna você deseja inserir 'O'?");

			coluna = sc.nextInt();

			switch (coluna) {

			case 1: 
				coluna = 1;
				break;

			case 2: 
				coluna = 3;
				break;

			case 3: 
				coluna = 5;
				break;

			default: Print.p("Erro inesperado");

			}

		}

		while (coluna != 1 && coluna != 3 && coluna != 5);

		return coluna;

	}

	public static boolean ninguemGanha (String [][] tabuleiro, String nomeJogador) {

		boolean ninguemGanha = false;

		if (tabuleiro[1][1] != " " && tabuleiro[1][3] != " " && tabuleiro[1][5] != " " &&
				tabuleiro[3][1] != " " && tabuleiro[3][3] != " " && tabuleiro[3][5] != " " &&
				tabuleiro[5][1] != " " && tabuleiro[5][3] != " " && tabuleiro[5][5] != " ") {
			ninguemGanha = true;
			
			Print.p("Empate!");
			aindaQuerJogar(nomeJogador);
		}

		return ninguemGanha;
	}
	
	public static void aindaQuerJogar(String nomeJogador) {

		int aindaQuerJogar;

		do {

			Print.p("Você ainda quer jogar, " + nomeJogador + "?"
					+ "\n(1) Sim;"
					+ "\n(2) Não;");

			Scanner sc = new Scanner (System.in);
			aindaQuerJogar = sc.nextInt();

		} while (aindaQuerJogar != 1 && aindaQuerJogar != 2);

		if (aindaQuerJogar == 1) {
			Play.obterEscolhaJogo(nomeJogador);
		} else {
			Print.p("Certo! Nos vemos de outra vez.");
		}

	}
}