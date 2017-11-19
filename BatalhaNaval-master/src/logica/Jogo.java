package logica;

public class Jogo {

	/**
	 * atributos
	 */
	private int tabuleiro[][];
	private boolean jogador;

	/**
	 * construtor publico
	 */
	public Jogo() {
		tabuleiro = new int[10][10];
		jogador = true;
		tabuleiro[0][0] = 1;
		tabuleiro[1][0] = 1;
		tabuleiro[2][0] = 1;
		tabuleiro[3][0] = 1;
		tabuleiro[4][0] = 1;
		tabuleiro[5][0] = 1;
	}

	/**
	 * efetua jogada
	 * 
	 * @param x
	 * @param y
	 */
	public int joga(int x, int y) {
		jogador = !jogador;
		return tabuleiro[x][y];
	}

	/**
	 * verifica se jogo terminou
	 * 
	 * @return
	 */
	public boolean terminou() {
		return false;
	}

	/**
	 * imprime tabuleiro
	 */
	public void imprimeTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("-----------------------------------------------");
	}

}
