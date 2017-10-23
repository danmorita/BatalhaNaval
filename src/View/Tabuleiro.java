package View;

import java.util.Scanner;

public class Tabuleiro {
	static int tabuleiroTamanho,quantidadeDeNavios;
	static String tabuleiroNPC[][], tabuleiroJogador[][];

	public static void TamanhoDosTabuleiros() {
		Scanner leitor = new Scanner(System.in);
		for (;;) {
			System.out.println("Entre com o tamanho do tabuleiro : ");
			tabuleiroTamanho = leitor.nextInt();
			if (tabuleiroTamanho > 10)
				break;
		}
	}

	private static void IniciaTabuleiro() {
		tabuleiroNPC = new String[tabuleiroTamanho][tabuleiroTamanho];
		tabuleiroJogador = new String[tabuleiroTamanho][tabuleiroTamanho];
	}
	
	private static void MaximoDeNavios() {
		quantidadeDeNavios = (tabuleiroTamanho*tabuleiroTamanho)/7;
		quantidadeDeNavios /= 3;
		System.out.println("Subimarino "+quantidadeDeNavios+".");
		System.out.println("Porta avioes "+quantidadeDeNavios+".");
		System.out.println("Bombardeiro "+quantidadeDeNavios+".");
	}

	public static void main(String[] args) {
		TamanhoDosTabuleiros();
		MaximoDeNavios();
		IniciaTabuleiro();
		Scanner leitor = new Scanner(System.in);
		for(int cont = 0;cont<quantidadeDeNavios ;cont++) {
		System.out.println("Entre com a posicao dos submarinos: ");
		
		}
		for(int cont = 0;cont<quantidadeDeNavios ;cont++) {
			System.out.println("Entre com a posicao dos bombardeiros");
			String posicao = leitor.nextLine();
		}
		for(int cont = 0;cont<quantidadeDeNavios ;cont++) {
			System.out.println("Enre com a posicao dos porta avioes: ");
		}
		
		
	}
}

// public String[][] tabuleiro;

/*
 * public Tabuleiro(String[][] tabuleiro) { this.tabuleiro = tabuleiro; }
 * 
 * // define a posicao na matrz e retorna a posicao para comparacao futura
 * public boolean posicionarBarco(String posicao) {
 * 
 * return false; // so pra tirar o erro... }
 * 
 * // dentro deste metodo define se eh horizontal ou vertical e verifica se esta
 * // vazio ou se exista a posicao desejada // eh um metodo para se chamar
 * dentro do metodo posicionarBarco() public boolean verificarPosicao() {
 * 
 * return false; // so pra tirar o erro... }
 * 
 * public void imprimirTabuleiro() { int lin = 0; int col = 0; for (lin = 0; lin
 * < 11; lin++) { for (col = 0; col < 12; col++) {
 * System.out.print(tabuleiro[lin][col]); } System.out.println(""); } }
 */
