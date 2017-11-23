package Model;

import java.util.ArrayList;

//private static int submarino = 1;
//private static int navio = 2;
//private static int encruzador = 3;


public class Barco {


	private int tamanho;
	private boolean linha;
	ArrayList<String> posicao = new ArrayList();
	
	public Barco(int tamanho, String posicao, boolean linha){
		
		this.tamanho = tamanho;
		this.posicao.add(posicao);
		this.linha = linha;
	}
	public Barco(int i){
		
		this.tamanho = i;
	}
	
	public String getPosicao(int index) {
		return this.posicao.get(index);
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
	public void setPosicao(int index, String posicao) {
		this.posicao.set(index, posicao);
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public void addPosicao(String posicao){
		this.posicao.add(posicao);
	}
	
	
	public String toString(){
		return this.posicao.get(0)+"/"+this.posicao.get(1);
	}
	
	public boolean colocarBarco(){
		return false;
	}
	
}
