package Control;


import java.util.Scanner;

import Model.Jogador;

public class MainMenu {
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
		 boolean acertos;
		 
		 for(i=0; i<count; i++){
			 opt=i%2;
			 switch(opt){
				 case 0:
					 System.out.println("player 1");
					 
					 do{	
						 acertos = npc.escolherPosicao();
						 if(acertos==true){
							 player ++;
						 }
					 }while(acertos == true);
					 if(player == 11){
						 vencedor = "Parabens!! voce ganhou da maquina!";
						 opt = 3;
					 }
					 break;
				 case 1:
					 System.out.println("bot");
					 acertos = npc.escolherPosicao();
					 do{
						 if(acertos==true){
							 acertos = jogador.proximaPosicao();
							 bot ++;
						 }
					 }while(acertos == true);
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
