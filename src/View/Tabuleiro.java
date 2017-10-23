package View;

import java.util.ArrayList;

public class Tabuleiro {
	private String[][] tabuleiro;
	ArrayList<String> posicaoLista = new ArrayList();

	public Tabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	//posiciona na matriz o valor desejado, primeiro parametro para posicao ex: A2, segundo parametro a leganda ex: N, Ñ, X para aparecer na tabela
	public void posicionarBarco(String posicao,String valor) {
		String[] col = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		for(i=0; i<col.length; i++) {
			if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
				linha = i + 1;
			}
		}
		for(i=0; i<lin.length; i++) {
			if(lin[i].equalsIgnoreCase("" + posicao.charAt(1))){
				coluna = i+1;
			}
		}
		if (linha != 0) {
			this.tabuleiro[linha][coluna + 1] = valor+"\t";
		}
		System.out.println(linha + "/" + coluna);
	}
	
	public void verificaHoriVert(String posicao){
		String[] col = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		for(i=0; i<col.length; i++) {
			if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
				linha = i + 1;
			}
		}
		for(i=0; i<lin.length; i++) {
			if(lin[i].equalsIgnoreCase("" + posicao.charAt(1))){
				coluna = i+1;
			}
		}
//		if(this.pegaPosicaoLista(posicaoLista.size()).charAt(0)){
//			
//		}
		
	}

	//metodo que tratamento de erros.. 
	public boolean verificarPosicao(String posicao) {
		boolean erro = true;
		String[] col = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		if ((posicao.length() > 2) || (posicao.length() < 2)) {// verificacao pelo tamanho da posicao
			erro = false;
			System.out.println("\nInsira somentes dois valor, sendo primeiro um letra e segunda um numero 1 a 10");
		} else {
			for (i = 0; i < col.length; i++) {
				if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {// verifica se contem no vetor col, se nao houver erro=false 
					linha = i + 1;
				}
			}
			for (i = 0; i < lin.length; i++) {
				if (lin[i].equalsIgnoreCase("" + posicao.charAt(1))) {// verifica se contem no vetor lin, se nao houver erro=false 
					coluna = i + 1;
				}
			}
			if ((linha == 0) || (coluna == 0)) {
				erro = false;
				System.out.println("Insira as posicoes corretas, tente outra vez..");
			}
		}
		return erro;
	}

	//metodo para verificar se a posicao escolhida ja esta no tabuleiro...obs pode ser usado para verificar se acertou, caso retorne false, acertou
	public boolean verificaLista(String posicao) {
		boolean erro = true;

		for (String i : posicaoLista) { // se a posicao for igual retorna falso
										// e entra no loop no menu
			if (posicao.equals(i)) {
				erro = false;
				System.out.println("Posicao repetido, escolha outro...");
			}
		}

		if (posicao.equals("")) { // posicao com espaco retorna falso
			erro = false;
		}

		return erro;
	}

	public void addPosicaoLista(String posicao) {
		this.posicaoLista.add(posicao);
	}
	public String pegaPosicaoLista(int index){
		return this.posicaoLista.get(index);
	}

	public void imprime() {
		for (String i : this.posicaoLista) {
			System.out.println(i);
		}
	}

	public void imprimirTabuleiro() {
		int lin = 0;
		int col = 0;
		for (lin = 0; lin < 12; lin++) {
			for (col = 0; col < 11; col++) {
				System.out.print(tabuleiro[lin][col]);
			}
			System.out.println("");
		}
	}


}
