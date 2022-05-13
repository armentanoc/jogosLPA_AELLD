package br.ucsal;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {

		Print.p("\n"
				+ "JOGO DA VELHA & DAMAS"
				+ "\n"	
				+ "\nOlá! Informe seu nome:");

		Scanner sc = new Scanner(System.in);
		String nomeJogador = sc.nextLine();

		
		obterEscolhaJogo(nomeJogador);

	}

	public static void obterEscolhaJogo(String nomeJogador) {
		
		Scanner sc = new Scanner(System.in);
		
		Print.p("\n"
				+ "Qual jogo você quer jogar, " + nomeJogador + "?"
				+ "\n(1) Jogo da Velha;"
				+ "\n(2) Jogo de Damas;"
				+ "\n(3) Sair.");

		int escolha = sc.nextInt();
		
		switch (escolha) {

		case 1: 
			JogoDaVelha.main(null, nomeJogador);
			break;

		case 2: 
			JogoDeDamas.main(null, nomeJogador);
			break;

		case 3:
			Print.p("Certo! Podemos jogar de outra vez.");
			break;

		default:
			Print.p("Não temos essa opção, tente novamente.");

		}

	}

}
