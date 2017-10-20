package View;

public class Tabuleiro {
	private String [][]tabuleiro;
	
	public Tabuleiro(String [][]tabuleiro){
		this.tabuleiro = tabuleiro;
	}
	
	//define a posicao na matrz e retorna a posicao para comparacao futura
	public boolean posicionarBarco(String posicao){
		
		return false; //so pra tirar o erro...
	}
	
	//dentro deste metodo define se eh horizontal ou vertical e verifica se esta vazio ou se exista a posicao desejada
	//eh um metodo para se chamar dentro do metodo posicionarBarco()
	public boolean verificarPosicao(){
		
		return false; //so pra tirar o erro...
	}
	public void imprimirTabuleiro(){
		int lin=0;
		int col=0;
		for(lin=0; lin<11; lin++){
			for(col=0; col<12; col++){
				System.out.print(tabuleiro[lin][col]);
			}
			System.out.println("");
		}
	}
}
