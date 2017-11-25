package logica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


import telas.Botao;

public class Copia {

	/**
	 * Atributos da tela principal
	 */
	public int posicaoBarco[][];//posição dos bacos
	private JFrame frame;
	private Botao tabuleiro[][];
	private Botao btBarco2H;
	private Botao btBarco2V;
	private Botao btBarco3H;
	private Botao btBarco3V;
	private Botao btBarco1HV;
	private Botao sair, reiniciar, btTrocaBarco;
	private JPanel painelBarco2H;
	private JPanel painelBarco2V;
	private JPanel painelBarco3H;
	private JPanel painelBarco3V;
	private JPanel painelBarco1HV;
	private JPanel painelCentral;
	private JPanel painelTBJogador;
	private JPanel painelNorte;
	private JPanel painelSul;
	private CardLayout card;
	private Jogo jogo;
	private int idx;
	private int ContadorBarco1 = 0;
	private int ContadorBarco3 = 0;
	private int ContadorBarco2 = 0;
	private int ContaBarco = 0;
	private TelaPrincipal principal;

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Copia();
	}

	/**
	 * Construtor publico
	 */
	public Copia() {
		inicializaAtributos();
		configuraComponentes();
		ConponentesMenusinho();
		defineLayouts();
		adicionaComponentes();
		Componentes();
		adicionaAcoes();
		inicializaParametros();
	}


	private void adicionaAcoes() {
		sair.addActionListener(new Acoes());

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j].addActionListener(new Acoes());
			}
		}

		btTrocaBarco.addActionListener(e -> {
			card.show(painelCentral, idx++ + "");
			System.out.println(idx);
			if (idx == 6)
				idx = 1;
		});
	}

	/**
	 * adiciona componentes nos paineis
	 */
	private void Componentes() {
		frame.getContentPane().add(painelTBJogador, BorderLayout.WEST);
		frame.getContentPane().add(painelNorte, BorderLayout.NORTH);
		frame.getContentPane().add(painelCentral, BorderLayout.CENTER);

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				painelTBJogador.add(tabuleiro[i][j]);
				tabuleiro[i][j].setIcon(new ImageIcon("agua1.jpg"));
				tabuleiro[i][j].setPreferredSize(new Dimension(50, 50));
			}
		}
		this.painelNorte.add(sair);
		this.painelNorte.add(reiniciar);

	}
	/*
	 * 
	 * Atribue imagem aos botoes da escolha de barcos menusinho a esquerda do tabuleiro
	 * */
	private void configuraComponentes() {
		this.btBarco1HV.setIcon(new ImageIcon("Barco1HV.jpg"));
		this.btBarco1HV.setEnabled(false);
		this.btBarco1HV.setDisabledIcon(new ImageIcon("Barco1HV.jpg"));

		this.btBarco2H.setIcon(new ImageIcon("Barco2H.jpg"));
		this.btBarco2H.setEnabled(false);
		this.btBarco2H.setDisabledIcon(new ImageIcon("Barco2H.jpg"));

		this.btBarco2V.setIcon(new ImageIcon("Barco2V.jpg"));
		this.btBarco2V.setEnabled(false);
		this.btBarco2V.setDisabledIcon(new ImageIcon("Barco2V.jpg"));

		this.btBarco3H.setIcon(new ImageIcon("Barco3H.jpg"));
		this.btBarco3H.setEnabled(false);
		this.btBarco3H.setDisabledIcon(new ImageIcon("Barco3H.jpg"));

		this.btBarco3V.setIcon(new ImageIcon("Barco3V.jpg"));
		this.btBarco3V.setEnabled(false);
		this.btBarco3V.setDisabledIcon(new ImageIcon("Barco3V.jpg"));
	}
	/*
	 * 
	 * inicializa os conponentes dos menusinhos
	 * */
	private void ConponentesMenusinho() {
		this.frame.setLayout(new BorderLayout());
		this.painelSul.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.painelCentral.setLayout(this.card);
		this.painelBarco1HV.setLayout(new BorderLayout());
		this.painelBarco2H.setLayout(new BorderLayout());
		this.painelBarco2V.setLayout(new BorderLayout());
		this.painelBarco3H.setLayout(new BorderLayout());
		this.painelBarco3V.setLayout(new BorderLayout());
	}

	/**
	 * define os layouts dos paineis
	 */
	private void defineLayouts() {
		this.painelTBJogador.setLayout(new GridLayout(10, 10));
		this.painelNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
/*
 * Adiciona os componentes alem do menusinho
 * */
	private void adicionaComponentes() {
		this.painelSul.add(btTrocaBarco);
		this.frame.add(painelCentral, BorderLayout.CENTER);
		this.frame.add(painelSul, BorderLayout.SOUTH);
		this.painelBarco1HV.add(btBarco1HV, BorderLayout.CENTER);
		this.painelBarco2H.add(btBarco2H, BorderLayout.CENTER);
		this.painelBarco2V.add(btBarco2V, BorderLayout.CENTER);
		this.painelBarco3H.add(btBarco3H, BorderLayout.CENTER);
		this.painelBarco3V.add(btBarco3V, BorderLayout.CENTER);
		this.painelCentral.add(painelBarco1HV, 1 + "");
		this.painelCentral.add(painelBarco2H, 2 + "");
		this.painelCentral.add(painelBarco2V, 3 + "");
		this.painelCentral.add(painelBarco3H, 4 + "");
		this.painelCentral.add(painelBarco3V, 5 + "");
	}

	/**
	 * inicializa os atributos da classe
	 */
	private void inicializaAtributos() {
		posicaoBarco = new int[10][10];
		tabuleiro = new Botao[10][10];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = new Botao();
				tabuleiro[i][j].x = i;
				tabuleiro[i][j].y = j;
			}
		}
		frame = new JFrame("Batalha naval");
		painelTBJogador = new JPanel();
		painelNorte = new JPanel();
		sair = new Botao("Sair");
		reiniciar = new Botao("Resetar");
		jogo = new Jogo();
		btBarco2H = new Botao();
		btBarco2V = new Botao();
		btBarco3H = new Botao();
		btBarco3V = new Botao();
		btBarco1HV = new Botao();
		btTrocaBarco = new Botao("Troca barco");
		painelBarco2H = new JPanel();
		painelBarco2V = new JPanel();
		painelBarco3H = new JPanel();
		painelBarco3V = new JPanel();
		painelBarco1HV = new JPanel();
		painelCentral = new JPanel();
		painelSul = new JPanel();
		card = new CardLayout();
		idx = 2;
	}

	/**
	 * set os parametros principais da tela
	 */
	private void inicializaParametros() {
		frame.setSize(675, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * classe que trata acoes dos botoes
	 * 
	 * @author jadermcg
	 *
	 */
	private class Acoes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Botao b = (Botao) e.getSource();

			if (b.getParent() == painelNorte) {
				if (b == sair) {
					System.exit(0);
				}
			} else if (b.getParent() == painelTBJogador) {
				int x = b.x;
				int y = b.y;
				
				
				System.out.println("Posição " + x + "-" + y);
				int conteudo = jogo.joga(x, y);
				System.out.println(conteudo);
				switch (idx) {
				case 2:
					
					if(ContadorBarco1 >= 1) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else {
					b.setIcon(new ImageIcon("submarino.jpg"));
					tabuleiro[x][y].setEnabled(false);
					tabuleiro[x][y].setDisabledIcon(new ImageIcon("submarino.jpg"));
					posicaoBarco[x][y] = 1;
					ContaBarco++;
					ContadorBarco1++;
					if(ContaBarco == 6) {
						principal = new TelaPrincipal();
						principal.setTabuleiro(tabuleiro);
						frame.setVisible(false);
					}
					}
					break;
				case 3:
					
					if(ContadorBarco2 >= 2) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					if (y == 9 || posicaoBarco[x][y+1]!=0)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("navegador1H.jpg"));
						tabuleiro[x][y + 1].setIcon(new ImageIcon("navegador2H.jpg"));
						tabuleiro[x][y].setEnabled(false);
						tabuleiro[x][y+1].setEnabled(false);
						tabuleiro[x][y].setDisabledIcon(new ImageIcon("navegador1H.jpg"));
						tabuleiro[x][y+1].setDisabledIcon(new ImageIcon("navegador2H.jpg"));
						posicaoBarco[x][y] = 21;
						posicaoBarco[x + 1][y] = 21;
						ContaBarco++;
						ContadorBarco2++;
						if(ContaBarco == 6) {
							principal = new TelaPrincipal();
							principal.setTabuleiro(tabuleiro);
							frame.setVisible(false);
						}
					}
					break;
				case 4:
					
					if(ContadorBarco2 >= 2) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else {
					if (x == 9 || posicaoBarco[x+1][y]!=0)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("navegador1V.jpg"));
						tabuleiro[x + 1][y].setIcon(new ImageIcon("navegador2V.jpg"));
						tabuleiro[x][y].setEnabled(false);
						tabuleiro[x + 1][y].setEnabled(false);
						tabuleiro[x][y].setDisabledIcon(new ImageIcon("navegador1V.jpg"));
						tabuleiro[x + 1][y].setDisabledIcon(new ImageIcon("navegador2V.jpg"));
						posicaoBarco[x][y] = 22;
						posicaoBarco[x + 1][y] = 22;
						ContaBarco++;
						ContadorBarco2++;
						if(ContaBarco == 6) {
							principal = new TelaPrincipal();
							principal.setTabuleiro(tabuleiro);
							frame.setVisible(false);
						}
					}
					}
					break;
				case 5:
					
					if(ContadorBarco3 >= 3) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else {
					if (y == 8 || y == 9 || posicaoBarco[x][y+1]!=0 || posicaoBarco[x][y+2] != 0)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("cruzador1H.jpg"));
						tabuleiro[x][y + 1].setIcon(new ImageIcon("cruzador2H.jpg"));
						tabuleiro[x][y + 2].setIcon(new ImageIcon("cruzador3H.jpg"));
						tabuleiro[x][y].setEnabled(false);
						tabuleiro[x][y+1].setEnabled(false);
						tabuleiro[x][y+2].setEnabled(false);
						tabuleiro[x][y].setDisabledIcon(new ImageIcon("cruzador1H.jpg"));
						tabuleiro[x][y+1].setDisabledIcon(new ImageIcon("cruzador2H.jpg"));
						tabuleiro[x][y+2].setDisabledIcon(new ImageIcon("cruzador3H.jpg"));
						posicaoBarco[x][y] = 31;
						posicaoBarco[x][y+1] = 31;
						posicaoBarco[x][y+2] = 31;
						ContaBarco++;
						ContadorBarco3++;
						if(ContaBarco == 6) {
							principal = new TelaPrincipal();
							principal.setTabuleiro(tabuleiro);
							frame.setVisible(false);
						}
					}
					}
					
					break;
				case 1:
					
					if(ContadorBarco3 >= 3) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					if (x == 8 || x == 9 || posicaoBarco[x+1][y] != 0 || posicaoBarco[x+2][y] != 0)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("cruzador1V.jpg"));
						tabuleiro[x + 1][y].setIcon(new ImageIcon("cruzador2V.jpg"));
						tabuleiro[x + 2][y].setIcon(new ImageIcon("cruzador3V.jpg"));
						tabuleiro[x][y].setEnabled(false);
						tabuleiro[x][y+1].setEnabled(false);
						tabuleiro[x][y+2].setEnabled(false);
						tabuleiro[x][y].setDisabledIcon(new ImageIcon("cruzador1H.jpg"));
						tabuleiro[x][y+1].setDisabledIcon(new ImageIcon("cruzador2H.jpg"));
						tabuleiro[x][y+2].setDisabledIcon(new ImageIcon("cruzador3H.jpg"));
						posicaoBarco[x][y] = 32;
						posicaoBarco[x + 1][y] = 32;
						posicaoBarco[x + 2][y] = 32;
						ContaBarco++;
						ContadorBarco3++;
						if(ContaBarco == 6) {
							principal = new TelaPrincipal();
							principal.setTabuleiro(tabuleiro);
							frame.setVisible(false);
						}
					}
					break;
				}

			}

		}

	}

}
