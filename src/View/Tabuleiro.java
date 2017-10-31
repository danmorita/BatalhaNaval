package View;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {
	private String[][] tabuleiro;
	ArrayList<String> posicaoLista = new ArrayList();
	Random rnd = new Random();

	public Tabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	// posiciona na matriz o valor desejado, primeiro parametro para posicao ex:
	// A2, segundo parametro a leganda ex: N, Ñ, X para aparecer na tabela
	public void posicionarBarco(String posicao, String valor) {
		String[] col = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		for (i = 0; i < col.length; i++) {
			if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
				linha = i + 1;
			}
		}
		for (i = 0; i < lin.length; i++) {
			if (lin[i].equalsIgnoreCase("" + posicao.charAt(1))) {
				coluna = i + 1;
			}
		}
		if (linha != 0) {
			this.tabuleiro[linha][coluna + 1] = valor + "\t";
		}
		System.out.println(linha + "/" + coluna);
	}

	public void verificaHoriVert(String posicao) {
		String[] col = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		for (i = 0; i < col.length; i++) {
			if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
				linha = i + 1;
			}
		}
		for (i = 0; i < lin.length; i++) {
			if (lin[i].equalsIgnoreCase("" + posicao.charAt(1))) {
				coluna = i + 1;
			}
		}
		if (this.pegaPosicaoLista(posicaoLista.size()).charAt(0) == posicao.charAt(0)) {

		}

	}

	// metodo de tratamento de erros..
	public boolean verificarPosicao(String posicao) {
		boolean erro = true;
		String[] col = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		// verificacao pelo tamanho da posicao
		if ((posicao.length() > 2) || (posicao.length() < 2)) {
			erro = false;
			System.out.println("\nInsira somentes dois valor, sendo primeiro um letra e segunda um numero 1 a 9");
		} else {
			for (i = 0; i < col.length; i++) {
				// verifica se contem no vetor col, se nao houver erro=false
				if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
					linha = i + 1;
				}
			}
			for (i = 0; i < lin.length; i++) {
				// verifica se contem no vetor lin, se nao houver erro=false
				if (lin[i].equalsIgnoreCase("" + posicao.charAt(1))) {
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

	// metodo para verificar se a posicao escolhida ja esta no tabuleiro...obs
	// pode ser usado para verificar se acertou, caso retorne false, acertou
	public boolean verificaLista(String posicao) {
		boolean erro = true;
		// se a posicao for igual retorna falso e entra no loop no menu
		//QUANDO FOR REUTILIZAR ESSE METODO PARA VERIFICAR, CUIDADO COM O RETORNO.. SE ACHAR VAI RETORNAR FALSO.
		for (String i : posicaoLista) {
			if (posicao.equals(i)) {
				erro = false;
				System.out.println("Posicao repetido, escolha outro...");
			}
		}
		// posicao com espaco retorna falso
		if (posicao.equals("")) {
			erro = false;
		}

		return erro;
	}

	public void addPosicaoLista(String posicao) {
		this.posicaoLista.add(posicao);
	}

	public String pegaPosicaoLista(int index) {
		return this.posicaoLista.get(index);
	}

	public boolean verificaMatriz(String posicao){
		boolean acertou = false;
		String[] col = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] lin = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		for (i = 0; i < col.length; i++) {
			if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
				linha = i + 1;
			}
		}
		for (i = 0; i < lin.length; i++) {
			if (lin[i].equalsIgnoreCase("" + posicao.charAt(1))) {
				coluna = i + 1;
			}
		}
		if(tabuleiro[linha][coluna]=="Ñ"){
			System.out.println("posicao repetido!");
			acertou = true;
		}
		return acertou;
	}
	
	public void imprime() {
		for (String i : this.posicaoLista) {
			System.out.println(i);
		}
	}

	public void imprimirTabuleiro() {
		int lin = 0;
		int col = 0;
		for (lin = 0; lin < 11; lin++) {
			for (col = 0; col < 11; col++) {
				System.out.print(tabuleiro[lin][col]);
			}
			System.out.println("");
		}
	}

	// metodos do bot
	public boolean posicaoSequencial(String posicao, String valor, int tamanho) {

		final int vertical = 1;
		String[] col = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] lin = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int i = 0;
		int coluna = 0;
		int linha = 0;
		boolean achou = true;
		for (i = 0; i < col.length; i++) {
			if (col[i].equalsIgnoreCase("" + posicao.charAt(0))) {
				linha = i + 1;
			}
		}
		for (i = 0; i < lin.length; i++) {
			if (lin[i].equalsIgnoreCase("" + posicao.charAt(1))) {
				coluna = i + 1;
			}
		}
		// System.out.println("linha " + (linha));
		// System.out.println("coluna: " + (coluna));
		if (rnd.nextInt(2) == vertical) {
			if (posicaoLista.isEmpty()) {
				achou = false;
			} else {
				for (String j : posicaoLista) {
					if (coluna == 8) {
						if ((posicao != j) || (linha + "" + (coluna + 1) != j) || (linha + "" + (coluna - 1) != j)) {
							achou = false;
						}
					} else if ((posicao != j) || (linha + "" + (coluna + 1) != j) || (linha + "" + (coluna + 2) != j)) {
						achou = false;
					}
				}
			}
			if (achou == false) {
				// posiciona o valor verificando as bordas, troca de coluna
				for (i = coluna; i < coluna + tamanho; i++) {
					if ((coluna == 8) && (i == 10)) {
						this.tabuleiro[linha][i - 2] = valor + "\t";
						this.posicaoLista.add(linha+""+(i-2));
					} else if ((coluna == 9) && (i == 10)) {
						this.tabuleiro[linha][8] = valor + "\t";
						this.posicaoLista.add(linha+""+8);
						this.tabuleiro[linha][7] = valor + "\t";
						this.posicaoLista.add(linha+""+7);
						break;
					} else {
						this.tabuleiro[linha][i + 1] = valor + "\t";
						this.posicaoLista.add(linha+""+i);
					}
				}
			} else {
				for (String j : posicaoLista) {
					if (linha == 8) {
						if ((posicao != j) || ((linha + 1) + "" + coluna != j) || ((linha - 1) + "" + coluna != j)) {
							achou = false;
						}
					} else if ((posicao != j) || ((linha + 1) + "" + coluna != j) || ((linha + 2) + "" + coluna != j)) {
						achou = false;
					}
				}
				if (achou == false) {
					// posiciona o valor verificando as bordas, troca de linha
					for (i = linha; i < linha + tamanho; i++) {
						if ((linha == 8) && (i == 10)) {
							this.tabuleiro[i - 3][coluna + 1] = valor + "\t";
							this.posicaoLista.add((i-3)+""+(coluna));
						} else if ((linha == 9) && (i == 10)) {
							this.tabuleiro[8][coluna + 1] = valor + "\t";
							this.posicaoLista.add(8+""+(coluna));
							this.tabuleiro[7][coluna + 1] = valor + "\t";
							this.posicaoLista.add(7+""+(coluna));
							break;
						} else {
							this.tabuleiro[i][coluna + 1] = valor + "\t";
							this.posicaoLista.add(i+""+coluna);
						}
					}
				}
			}
		} else {
			if (posicaoLista.isEmpty()) {
				achou = false;
			} else {
				for (String j : posicaoLista) {
					if (linha == 8) {
						if ((posicao != j) || (linha + "" + (coluna + 1) != j) || (linha + "" + (coluna - 1) != j)) {
							achou = false;
						}
					} else if ((posicao != j) || (linha + "" + (coluna + 1) != j) || (linha + "" + (coluna + 2) != j)) {
						achou = false;
					}
				}
			}
			if (achou == false) {
				// posiciona o valor verificando as bordas, troca de coluna
				for (i = linha; i < linha + tamanho; i++) {
					if ((linha == 8) && (i == 10)) {
						this.tabuleiro[i - 3][coluna + 1] = valor + "\t";
						this.posicaoLista.add((i-3)+""+(coluna));
					} else if ((linha == 9) && (i == 10)) {
						this.tabuleiro[8][coluna + 1] = valor + "\t";
						this.posicaoLista.add(8+""+(coluna));
						this.tabuleiro[7][coluna + 1] = valor + "\t";
						this.posicaoLista.add(7+""+(coluna));
						break;
					} else {
						this.tabuleiro[i][coluna + 1] = valor + "\t";
						this.posicaoLista.add(i+""+coluna);
					}
				}
			} else {
				for (String j : posicaoLista) {
					if (coluna == 8) {
						if ((posicao != j) || ((linha + 1) + "" + coluna != j) || ((linha - 1) + "" + coluna != j)) {
							achou = false;
						}
					} else if ((posicao != j) || ((linha + 1) + "" + coluna != j) || ((linha + 2) + "" + coluna != j)) {
						achou = false;
					}
				}
				if (achou == false) {
					// posiciona o valor verificando as bordas, troca de linha
					for (i = coluna; i < coluna + tamanho; i++) {
						if ((coluna == 8) && (i == 10)) {
							this.tabuleiro[linha][i - 3] = valor + "\t";
							this.posicaoLista.add(linha+""+(i-3));
						} else if ((coluna == 9) && (i == 10)) {
							this.tabuleiro[linha][8] = valor + "\t";
							this.posicaoLista.add(linha+""+8);
							this.tabuleiro[linha][7] = valor + "\t";
							this.posicaoLista.add(linha+""+7);
							break;
						} else {
							this.tabuleiro[linha][i + 1] = valor + "\t";
							this.posicaoLista.add(linha+""+i);
						}
					}
				}
			}
		}
		return achou;
	}

}
