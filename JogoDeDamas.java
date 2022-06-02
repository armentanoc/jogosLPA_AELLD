package br.ucsal;

import java.util.Scanner;

public class JogoDeDamas {

	public static void main(String[] args, String nomeJogador) {

		Print.p("\nJOGO DE DAMAS");

		Print.p("\n");

		String [][] tabuleiroInicial = tabuleiro();

		Print.tabDamas(tabuleiroInicial);

		jogoON(tabuleiroInicial);

		Print.p("\n");

		Play.obterEscolhaJogo(nomeJogador);

	}

	public static String [] [] tabuleiro() {

		int l = 9, c = 9;

		String [] [] tabuleiro = new String [l] [c];

		for (int il = 0; il < tabuleiro.length - 1; il++) {
			for (int ic = 0; ic < tabuleiro[il].length - 1; ic++) {

				tabuleiro [il] [ic] = "|_|";

				if (il == 0) {
					if (ic % 2 == 0) {
						tabuleiro[il][ic] = "|○|";
					} 
				} else if (il == 1) {
					if (ic % 2 != 0) {
						tabuleiro[il][ic] = "|○|";
					} 
				} else if (il == 2) {
					if (ic % 2 == 0) {
						tabuleiro[il][ic] = "|○|";
					} 
				}

				if (il == 5) {
					if (ic % 2 != 0) {
						tabuleiro[il][ic] = "|●|";
					} 
				} else if (il == 6) {
					if (ic % 2 == 0) {
						tabuleiro[il][ic] = "|●|";
					} 
				} else if (il == 7 ) {
					if (ic % 2 != 0) {
						tabuleiro[il][ic] = "|●|";
					} 
				}

			}

			int numeroCasa= 0;

			while(numeroCasa < 8) {

				tabuleiro[8][numeroCasa] = "|"+ numeroCasa + "|";
				tabuleiro[numeroCasa][8] = "|"+ numeroCasa + "|";
				numeroCasa++;

			}

		}

		tabuleiro[8][8] = "|#|";

		return tabuleiro;

	}

	public static String [][] jogoON(String [][] tabuleiro) {

		String corPreto = "○", corBranco = "●";
		String pecaPreto = "|○|", pecaBranco = "|●|";
		int rodada = 1;

		do { 

			tabuleiro = jogada(tabuleiro, corBranco, pecaBranco, rodada);

			Print.tabDamas(tabuleiro);


			Print.p("\n");

			tabuleiro = jogada(tabuleiro, corPreto, pecaPreto, rodada);

			Print.tabDamas(tabuleiro);
			rodada++;

		} while (rodada < 5);

		//(vitoria == false && empate == false);
		//criar metodo para testar vitoria e metodo para testar empate

		return tabuleiro;

	}

	public static String [][] jogada (String [][] tabuleiro, String corPeca, String tipoPeca, int rodada) {

		int colunaSeguinte, linhaSeguinte, colunaOrigem, linhaOrigem, ptsPreto = 0, ptsBranco = 0;
		boolean validar = false;
		String pecaPreta = "○", pecaBranca = "●";

		Scanner sc = new Scanner(System.in);

		do { Print.p("\n"
				+ "Rodada " + rodada + " - Jogada de " + corPeca + ":"
				+ "\nPts. " + pecaBranca +  " = " + ptsBranco + " | Pts. " + pecaPreta + " = " + ptsPreto
				+"\n"
				+ "\nQual a linha da peça que deseja mover? (0 a 7)");

		linhaOrigem = sc.nextInt();

		Print.p("Qual a coluna da peça que deseja mover? (0 a 7)");

		colunaOrigem = sc.nextInt();

		} while (tabuleiro[linhaOrigem][colunaOrigem] != tipoPeca);

		//verificando se o local de origem tem peca

		do {

			Print.p("\n"
					+ "Para qual linha deseja mover essa peça? (0 a 7)");

			linhaSeguinte = sc.nextInt();

			Print.p("Para qual coluna deseja mover essa peça? (0 a 7)");

			colunaSeguinte = sc.nextInt();

			validar = validarJogada(linhaOrigem, linhaSeguinte, colunaOrigem, colunaSeguinte, tabuleiro, tipoPeca, ptsBranco, ptsPreto);

			//verificando se é possível mover a peça pra o local desejado

		} while (validar == false);

		return tabuleiro;

	}

	public static boolean validarJogada(int linhaOrigem, int linhaSeguinte, int colunaOrigem, int colunaSeguinte, String[][] tabuleiro, String tipoPeca, int ptsBranco, int ptsPreto) {

		boolean validar = false;
		int subLinha = linhaSeguinte - linhaOrigem, subCol = colunaSeguinte - colunaOrigem, linhaSegComeu = 0, colSegComeu = 0;

		String pecaPreta = "|○|", pecaBranca = "|●|", vazio = "|_|", pecaOposta = "|_|", linhaIntermed, colunaIntermed;

		if (tipoPeca == pecaPreta) {
			pecaOposta = pecaBranca;
		} else if (tipoPeca == pecaBranca) {
			pecaOposta = pecaPreta;

		}

		if (subLinha == 2) {
			linhaSegComeu = 1;
		} else if (subLinha == -2) {
			linhaSegComeu = -1;
		}

		if (subCol == 2) {
			colSegComeu = 1;
		} else if (subCol == -2) {
			colSegComeu = -1;

		}

		if (tabuleiro[linhaSeguinte][colunaSeguinte] == vazio) {

			if ((linhaSeguinte == linhaOrigem + 1 || linhaSeguinte == linhaOrigem - 1) && colunaSeguinte == colunaOrigem + 1 || colunaSeguinte == colunaOrigem - 1) {
				
				validar = true;
				tabuleiro[linhaSeguinte][colunaSeguinte] = tipoPeca;
				//preenchendo com a peça a linha e coluna seguinte
				tabuleiro[linhaOrigem][colunaOrigem] = vazio;
				//apagando onde a peça estava anteriormente

			} else {	
					
					if ((tabuleiro[linhaOrigem+linhaSegComeu][colunaOrigem+linhaSegComeu] == pecaOposta) && (linhaSeguinte == linhaOrigem+subLinha) && (colunaSeguinte == colunaOrigem+subCol)) {
					
					validar = true;
					tabuleiro[linhaSeguinte][colunaSeguinte] = tipoPeca;
					tabuleiro[linhaOrigem+linhaSegComeu][colunaOrigem+colSegComeu] = vazio;
					//apagando a peça comida
					tabuleiro[linhaOrigem][colunaOrigem] = vazio;
					//apagando onde a peça estava anteriormente
					tabuleiro[linhaSeguinte][colunaSeguinte] = tipoPeca;
					//preenchendo com a peça a linha e coluna seguintes
					
					if(tipoPeca == pecaPreta) {
						ptsPreto++;
					} else if (tipoPeca == pecaBranca) {
						ptsBranco++;
					}

					} 
				}

			}

		return validar;

	}

	/*
	 *DAMA: ◉  ◎
	 *
	 * 1. Repetir método jogadaPreto para jogadaBranco - DONE;
	 * 2. Criar lógica de validação de jogada: só é válida se for na diagonal (linha +1 ou -1 && coluna +1 ou -1) - DONE;
	 * 2.a. Escanear se existe pedra na jogada validada e não existe na jogada validada +1 ou -1) - DONE;
	 * 3. Criar lógica para "comer pedra" (a pedra contrária +1 ou -1) e acumular pontos (Branco++, Preto++) - DONE;
	 * 3. Criar lógica de promoção à dama (se for preta e chegar a ultima linha ou se for branca e chegar a primeira linha)
	 * 4. Criar lógica de vitória: escanear o tabuleiro para verificar se ainda existe |○| ou |●| - IN PROGRESS;
	 * 4.1. Regras de empate (docs)
	 * 5. Criar movimento especial da dama (várias pedras)
	 */


}
