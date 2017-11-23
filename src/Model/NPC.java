package Model;

import java.util.Random;
import java.util.Scanner;
<<<<<<< HEAD
//radom para o bot acerta o barco,criar um vetor onde o bot testa se ele acerta ou erra se
//for <7 ele erra(facil),se for <5 erra (medio),se for <3 erra(hard)
import View.Tabuleiro;
//fazer o bot acerta navios
=======

import View.Tabuleiro;

>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "ï¿½ <- acertos\t", "B","O", "T\n\n" } };
=======
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "Ñ <- acertos\t", "B","O", "T\n\n" } };
>>>>>>> refs/remotes/origin/master
	
	
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
<<<<<<< HEAD
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "ï¿½ <- acertos\t", "B","O", "T\n\n" } };
=======
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "Ñ <- acertos\t", "B","O", "T\n\n" } };
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
			tabuleiroBotView.posicionarBarco(posicao, "ï¿½");
=======
			tabuleiroBotView.posicionarBarco(posicao, "Ñ");
>>>>>>> refs/remotes/origin/master
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
