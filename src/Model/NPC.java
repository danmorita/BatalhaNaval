package Model;

import java.util.Random;
import java.util.Scanner;

import View.Tabuleiro;

public class NPC {
	Scanner input = new Scanner(System.in);
	Random random = new Random();
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
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "Ñ <- acertos\t", "B","O", "T\n\n" } };
	
	
	String posicao; 
	
	Tabuleiro tabuleiroBot = new Tabuleiro(tabu);
	String[][] tabuView = { { "  ", "\t", "1", "\t2", "\t3", "\t4", "\t5", "\t6", "\t7", "\t8", "\t9\n" },
			{ "A", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "B", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "C", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "D", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "E", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "F", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "G", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "H", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "I", "\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t", "~\t" },
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "Ñ <- acertos\t", "B","O", "T\n\n" } };
	Tabuleiro tabuleiroBotView = new Tabuleiro(tabuView);
	public void npc() {
	
		posicao = (random.nextInt(9)+1)+""+(random.nextInt(9)+1);
		tabuleiroBot.posicaoSequencial(posicao, "N",1);
//		tabuleiroBot.imprimirTabuleiro();
		
		do{
			posicao = (random.nextInt(9)+1)+""+(random.nextInt(9)+1);
		}while(tabuleiroBot.verificaLista(posicao)==false);
		tabuleiroBot.posicaoSequencial(posicao, "N",2);
		
		do{
			posicao = (random.nextInt(9)+1)+""+(random.nextInt(9)+1);
		}while(tabuleiroBot.verificaLista(posicao)==false);
		tabuleiroBot.posicaoSequencial(posicao, "N",2);
		
		do{
			posicao = (random.nextInt(9)+1)+""+(random.nextInt(9)+1);
		}while(tabuleiroBot.verificaLista(posicao)==false);
		tabuleiroBot.posicaoSequencial(posicao, "N",3);
		
		do{
			posicao = (random.nextInt(9)+1)+""+(random.nextInt(9)+1);
		}while(tabuleiroBot.verificaLista(posicao)==false);
		tabuleiroBot.posicaoSequencial(posicao, "N",3);
		

	}
	
	
	public boolean escolherPosicao(){
		boolean errou = false;
		String posicao;
		System.out.println("\nTabela bot\n");
		tabuleiroBot.imprimirTabuleiro();
		System.out.println("\nTabela bot View\n");
		tabuleiroBotView.imprimirTabuleiro();
		System.out.println("Sua vez, escolha uma posicao: \n");
		posicao = input.next();
		errou = tabuleiroBot.verificaLista(posicao);
		System.out.println("entrou aqui "+errou);
		if(errou==false){
			tabuleiroBotView.posicionarBarco(posicao, "Ñ");
			errou=true;
		}else if(errou==true){
			tabuleiroBotView.posicionarBarco(posicao, "X");
			errou=false;
			
		}
		if(errou == false){
			errou = tabuleiroBotView.verificaMatriz(posicao);
			
		}
		return errou;
	}

}
