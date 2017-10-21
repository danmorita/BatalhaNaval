package Control;

import java.util.Scanner;

import Model.Barco;
import View.Tabuleiro;

public class MainMenu {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String [][]tabu = {{"  ","\t","1","\t2","\t3","\t4","\t5","\t6","\t7","\t8","\t9","\t10\n"},
				 {"A","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"B","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"C","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"D","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"E","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"F","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"G","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"H","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"I","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				 {"J","\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t","~\t "},
				};
		
		Tabuleiro tabuleiro = new Tabuleiro(tabu);	
		
	
		Barco submarino = new Barco(1);
		Barco navio1 = new Barco(2);
		Barco navio2 = new Barco(2);
		Barco encruzador1 = new Barco(3);
		Barco encruzador2 = new Barco(3);
		
		String []posicaoLista = new String[11];
		
		System.out.println("-Batalha NAVAL-");
		System.out.println("\tVoce tera 5 Barcos");
		System.out.println("\t\t 1 Submarino");
		System.out.println("\t\t 2 Navios");
		System.out.println("\t\t 2 Encruzadores");
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
		System.out.println("Escolha a posicao do Submarino: ");
		submarino.setTamanho(1);
		submarino.setPosicao(input.nextLine());
		posicaoLista[0] = submarino.getPosicao();
		
		System.out.println("Escolha a posicao inicial  do Navio: ");
		
		
		navio1.setTamanho(2);
		navio1.setPosicao(input.nextLine());
		posicaoLista[1] = navio1.getPosicao();
		
		System.out.println("Escolha a posicao do Navio: ");
		navio2.setTamanho(2);
		navio2.setPosicao(input.nextLine());
		posicaoLista[2] = navio2.getPosicao();
		
	}
}
