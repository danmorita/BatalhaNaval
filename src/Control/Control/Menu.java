package Control;


import java.util.Scanner;

import Model.Jogador;
import Model.NPC;

public class Menu {
	public static void main(String[] args) {
		
		Jogador jogador = new Jogador();
		jogador.jogador();
		NPC npc = new NPC();
		npc.npc();
		
		
		int numero=0;
		Scanner input = new Scanner(System.in);
		
		 int count = 1000000;
		 int i=0;
		 int opt=0;
		 int player = 0;
		 int bot = 0;
		 String vencedor="playing...";
		 boolean acertosPlayer;
		 boolean acertosBot;
		 
		 for(i=0; i<count; i++){
			 opt=i%2;
			 switch(opt){
				 case 0:
					 System.out.println("sua vez...");
					 
					 do{	
						 acertosPlayer = npc.escolherPosicao();
						 if(acertosPlayer==true){
							 player ++;
						 }
					 }while(acertosPlayer == true);
					 if(player == 11){
						 vencedor = "Parabens!! voce ganhou da maquina!";
						 opt = 3;
					 }
					 break;
				 case 1:
					 System.out.println("vez do bot...");
					 acertosBot = jogador.escolherPosicao();
					 do{
						 if(acertosBot==true){
							 acertosBot = jogador.proximaPosicao();
							 bot ++;
						 }
					 }while(acertosBot == true);
					 if(bot == 11){
						 vencedor = "Vitoria do bot!!";
						 opt = 3;
					 }
					 break;
				 case 3:
					 System.out.println(vencedor);
				 default:
			 }
		 }
		
	}
}
