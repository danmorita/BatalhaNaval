package Model;

import java.util.Random;
import java.util.Scanner;

import Model.Barco;
import View.Tabuleiro;

public class Jogador {
	Random random = new Random();
	Scanner input = new Scanner(System.in);
	String[][] tabu = { { "  ", "\t", "1", "\t2", "\t3", "\t4", "\t5", "\t6", "\t7", "\t8", "\t9\n" },
			{ "A", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "B", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "C", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "D", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "E", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "F", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "G", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "H", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "I", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "J", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t\n" },

			{ "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "� <- acertos\t", "P","L","A", "Y", "E","R\n\n" } };
	String pos,vertical;
	String posicao;

	Tabuleiro tabuleiro = new Tabuleiro(tabu);
	
	Barco submarino = new Barco(1);
	Barco navio1 = new Barco(2);
	Barco navio2 = new Barco(2);
	Barco encruzador1 = new Barco(3);
	Barco encruzador2 = new Barco(3);
	
	public void jogador() {	

		System.out.println("-Batalha NAVAL-");
		System.out.println("\t-Voce tem 5 Barcos representados pela letra N na tabela");
		System.out.println("\t\t -1 Submarino");
		System.out.println("\t\t -2 Navios");
		System.out.println("\t\t -2 Encruzadores");
		System.out.println("\n");
		System.out.println("Submarino Ocupa 1 de espaco");
		System.out.println("navio ocupa 2 de espaco");
		System.out.println("encruzador ocupa 3 de espaco");
		System.out.println("\n");

		System.out.println("pressione ENTER para continuar...");
		input.nextLine();

		tabuleiro.imprimirTabuleiro();
		System.out.println("\n");
		System.out.println("OBS: Escolha a primeira posicao e a ultima caso o espaco do barco for maior de 1");
		System.out.println("Dica: Pode escolher a posicao do barco em horizontal ou vertical...");
		System.out.println("\n");

		// SUBMARINO
		// loop para verificar posicao repetido na lista que usa para/ comparacao de acertos
		do {
			System.out.println("Escolha a posicao do Submarino: \n");
			pos = input.nextLine().trim();

                        System.out.println("Vertical ou Horizontal");
                        vertical = input.nextLine().trim();
                        
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		tabuleiro.addPosicaoLista(pos,vertical);

		
		submarino.addPosicao(pos);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		// NAVIO 1
		do {
			System.out.println("Escolha a primeira posicao do Navio 1: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));

		tabuleiro.addPosicaoLista(pos,vertical);

		navio1.addPosicao(pos);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		do {
			System.out.println("Escolha a segunda posicao do Navio 1: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		navio1.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);

		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		// NAVIO 2
		do {
			System.out.println("Escolha a primeira posicao do Navio 2: \n");
			pos = input.nextLine().trim();
                       System.out.println("Vertical ou Horizontal");
                       vertical = input.nextLine().trim().substring(0);
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		navio2.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos, vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
                tabuleiro.posicionaHoriVert(pos,vertical);
                pos = null;

		do {
			System.out.println("Escolha a primeira posicao do Navio 2: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		navio2.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		// ENCRUZADOR 1
		do {
			System.out.println("Escolha a primeira posicao do Encruzador 1: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		encruzador1.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		do {
			System.out.println("Escolha a segunda posicao do Encruzador 1: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		encruzador1.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		do {
			System.out.println("Escolha a terceira posicao do Encruzador 1: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		encruzador1.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		// ENCRUZADOR 2
		do {
			System.out.println("Escolha a primeira posicao do Encruzador 2: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		encruzador2.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		do {
			System.out.println("Escolha a segunda posicao do Encruzador 2: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		encruzador2.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		pos = null;

		do {
			System.out.println("Escolha a terceira posicao do Encruzador 2: \n");
			pos = input.nextLine().trim();
		} while ((tabuleiro.verificaLista(pos) == false) || (tabuleiro.verificarPosicao(pos) == false));
		encruzador2.addPosicao(pos);
		tabuleiro.addPosicaoLista(pos,vertical);
		tabuleiro.posicionarBarco(pos, "N");
		tabuleiro.imprimirTabuleiro();
		System.out.println("ultima acao do jogador...");
		
	}
	public boolean escolherPosicao(){
		boolean acertou = false;
		System.out.println("Aguarde o bot... \n");
		System.out.println("pressione ENTER para continuar...");
		input.nextLine();
		pos = (random.nextInt(9)+1)+""+(random.nextInt(9)+1);
		acertou = tabuleiro.verificaLista(pos);
		if(acertou == true){
			acertou = tabuleiro.verificaMatriz(pos);
		}
		if(acertou==false){
			tabuleiro.posicionarBarco(pos, "�");
			acertou=true;
		}else if(acertou==true){
			tabuleiro.posicionarBarco(pos, "X");
			acertou=false;
		}
		return acertou;
	}
	public boolean proximaPosicao(){
		boolean acertou = false;
		System.out.println("Aguarde o bot... \n");
		tabuleiro.imprimirTabuleiro();
		
		System.out.println("pressione ENTER para continuar...");
		input.nextLine();
		
		acertou = tabuleiro.verificaLista(pos);
		if(acertou==false){
			tabuleiro.posicionarBarco(pos, "�");
			acertou=true;
		}else if(acertou==true){
			tabuleiro.posicionarBarco(pos, "X");
			acertou=false;
		}

		return acertou;
	}
        
}
