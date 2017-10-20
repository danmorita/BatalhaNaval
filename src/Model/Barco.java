package Model;

//private static int submarino = 1;
//private static int navio = 2;
//private static int encruzador = 3;

public class Barco {
//rrrrrrrrrefsdgsfgf
	private int tamanho;
	private String posicao;
	private boolean linha;	
	
	public Barco(int tamanho, String posicao, boolean linha){
		
		this.tamanho = tamanho;
		this.posicao = posicao;
		this.linha = linha;
	}
	public Barco(int i){
		
		this.tamanho = i;
	}
	
	public String getPosicao() {
		return posicao;
	}
	public int getTamanho() {
		return tamanho;
	}
	public boolean getLinha(){
		return linha;
	}
	public void setLinha(boolean linha) {
		this.linha = linha;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	
	public boolean colocarBarco(){
		return false;
	}
	
}
