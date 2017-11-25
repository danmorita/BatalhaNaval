package logica;

import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

import logica.Copia;
import View.Tabuleiro;
import static logica.Copia.posicaoBarco;
import telas.Botao;
public class NPC {
	Scanner input = new Scanner(System.in);
	static Random random = new Random();
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
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "� <- acertos\t", "B","O", "T\n\n" } };
	
	
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
			{ "\n-", "-", "-", "Legenda:  ", "~ <- oceano\t", "N <- barcos\t", "X <- erros\t", "� <- acertos\t", "B","O", "T\n\n" } };
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
			tabuleiroBotView.posicionarBarco(posicao, "�");
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
    public static int randomatk(){
        int i;
            int[] vetacerto;
            vetacerto = new int[10];
           for(i = 0;i<vetacerto.length;i++){
               if(i<7){
                   vetacerto[i] = 1;
               }
               else{
                   vetacerto[i] = 0;
               }
           }
    
           i = random.nextInt(10);
           int acerto = vetacerto[i];
           return acerto;
       }  
    public static void npcatk() {
    	if(randomatk() == 1) {
    		for(int i =0; i<10; i++) {
    			for (int j = 0; j<10; j++) {
    				if(Copia.posicaoBarco[i][j] != 1) {
    					Copia.tabuleiro[i][j].setIcon(new ImageIcon("agua.jpg"));
    				}
    			}
    		}
    	}
     }
}
