package br.ucsal;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {

		Print.p("\n"
				+ "JOGO DA VELHA, DAMAS & CHARADA"
				+ "\n"	
				+ "\nOlá! Informe seu nome:");

		Scanner sc = new Scanner(System.in);
		String nomeJogador = sc.nextLine();

		
		obterEscolhaJogo(nomeJogador);

	}

	public static void obterEscolhaJogo(String nomeJogador) {
		
		Scanner sc = new Scanner(System.in);
		
		int escolha;
		
		do {
			
			Print.p("\n"
					+ "Qual jogo você quer jogar, " + nomeJogador + "?"
					+ "\n(1) Jogo da Velha;"
					+ "\n(2) Jogo de Damas;"
					+ "\n(3) Charada;"
					+ "\n(4) Sair.");
			
			escolha = sc.nextInt();
			
			if (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4) {
				
				Print.p("Não temos essa opção, tente novamente.");
				
			}
			
		} while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4);
		
		switch (escolha) {

		case 1: 
			JogoDaVelha.main(null, nomeJogador);
			break;

		case 2: 
			JogoDeDamas.main(null, nomeJogador);
			break;
			
		case 3: 
			Charada.main(null, nomeJogador);
			break;
			
		case 4:
			Print.p("Certo! Podemos jogar de outra vez.");
			break;

		default:
			Print.p("Erro inesperado.");

		}

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
