package br.ucsal;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args, String nomeJogador) {

		Print.p("Obs.: jogo em desenvolvimento");

		Print.p("\nJOGO DA VELHA");

		tabuleiro();

		String [] [] tabuleiro = tabuleiro();
		imprimirTabuleiro(tabuleiro);

		char escolhaPeca = pecaInicial(nomeJogador);
		int ordem = primeiraJogada(escolhaPeca);
		
		jogoON(ordem, tabuleiro);
		
		
		//parei em ordem 1 quando come�a com x e ordem 2 quando come�a com 0, que j� est� retornando
		
	}

	public static String [] [] tabuleiro() {

		String [] [] tabuleiro = {

				{"-", "-", "-", "-", "-", "-", "-"},
				{"|", " ", "|", " ", "|", " ", "|"},

				//campos jog�veis [1][1], [1][3], [1][5]

				{"-", "-", "-", "-", "-", "-", "-"},
				{"|", " ", "|", " ", "|", " ", "|"},

				//campos jog�veis [3][1], [3][3], [3][5]

				{"-", "-", "-", "-", "-", "-", "-"},
				{"|", " ", "|", " ", "|", " ", "|"},

				//campos jog�veis [5][1], [5][3], [5][5]

				{"-", "-", "-", "-", "-", "-", "-"},
		};	

		return tabuleiro;

	}

	public static void imprimirTabuleiro(String [] [] tabuleiro) { 

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print(tabuleiro[i][j] +	" ");}
			System.out.println(" ");
		}
	}

	public static char pecaInicial(String nomeJogador) {

		char escolhaPeca;

		do {

			Print.p("\n" + nomeJogador + ", quem come�a, 'X' ou 'O'?");
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

	public static int primeiraJogada(char escolhaPeca) {

		int ordem = 0;

		switch (escolhaPeca) {
		case 'X': 
			ordem = 1;
			break;

		case 'O':
			ordem = 2;
			break;

		default:
			Print.p("Erro inesperado");
		}

		return ordem;

	}
	
	public static String [] [] jogoON(int ordem, String [] [] tabuleiro) {
		
		//ordem 1 come�a por 'X' e ordem 2 come�a por 'O'
		
		/*
		escolhaLinha();
		escolhaColuna();
		*/
		
	return tabuleiro;
		
	}
}
