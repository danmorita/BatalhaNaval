import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		int x=0;
		int y=0;
		int lin=0;
		int col=0;
		int count = 0;
		
		
//		String [][]tabuleiro  = new String[10][10];
		
		String [][]tabuleiro = {{"  "," ","A","\tB","\tC","\tD","\tE","\tF","\tG","\tH","\tI\t","J"},
								{"","   ","-","\t-","\t-","\t-","\t-","\t-","\t-","\t-","\t-\t","-"},
								{"01","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"02","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"03","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"04","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"05","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"06","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"07","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"08","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"09","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{"10","| ","\t","\t","\t","\t","\t","\t","\t","\t","\t ","|"},
								{" "," ","-","\t-","\t-","\t-","\t-","\t-","\t-","\t-","\t-\t","-"}
								};
		
		
		for(lin=0; lin<13; lin++){
			for(col=0; col<12; col++){
				System.out.print(tabuleiro[lin][col]);
			}
			System.out.println("");
		}
//		
//		tabuleiro[2][2]="N\t";
//		tabuleiro[3][2]="N\t";
		System.out.println("");
		System.out.println("");
		System.out.println("");
		for(lin=0; lin<13; lin++){
			for(col=0; col<12; col++){
				System.out.print(tabuleiro[lin][col]);
			}
			System.out.println("");
		}
		
		
			
	}
}
