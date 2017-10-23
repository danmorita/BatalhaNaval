import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Barco;
import View.Tabuleiro;

public class Principal {
	public static void main(String[] args){
	
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
		tabuleiro.imprimirTabuleiro();
	
		Barco submarino = new Barco(1);
		Barco navio = new Barco(2);
		Barco encruzador = new Barco(3);

			
	}
}
