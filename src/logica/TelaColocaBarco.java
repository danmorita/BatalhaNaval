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

public class TelaColocaBarco {

	/**
	 * Atributos da tela principal
	 */
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

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TelaColocaBarco();
	}

	/**
	 * Construtor publico
	 */
	public TelaColocaBarco() {
		inicializaAtributos();
		configuraComponentes();
		CG();
		defineLayouts();
		adicionaComponentes();
		Componentes();
		adicionaAcoes();
		inicializaParametros();
	}

	/**
	 * adiciona acoes dos botoes
	 */
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

	private void CG() {
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
				
				/*
				 * Posição do botão clicado
				 */
				System.out.println("Posição " + x + "-" + y);
				int conteudo = jogo.joga(x, y);
				System.out.println(conteudo);
				System.out.println("idx" + idx);
				switch (idx) {
				case 2:
					ContadorBarco1++;
					if(ContadorBarco1 > 1) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					b.setIcon(new ImageIcon("submarino.jpg"));
					break;
				case 3:
					ContadorBarco2++;
					if(ContadorBarco2 > 2) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					if (y == 9)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("navegador1H.jpg"));
						tabuleiro[x][y + 1].setIcon(new ImageIcon("navegador2H.jpg"));
					}
					break;
				case 4:
					ContadorBarco2++;
					if(ContadorBarco2 > 2) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					if (x == 9)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("navegador1V.jpg"));
						tabuleiro[x + 1][y].setIcon(new ImageIcon("navegador2V.jpg"));
					}
					break;
				case 5:
					ContadorBarco3++;
					if(ContadorBarco3 > 3) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					if (y == 8 || y == 9)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("cruzador1H.jpg"));
						tabuleiro[x][y + 1].setIcon(new ImageIcon("cruzador2H.jpg"));
						tabuleiro[x][y + 2].setIcon(new ImageIcon("cruzador3H.jpg"));
					}
					break;
				case 1:
					
					ContadorBarco3++;
					System.out.println("Cont "+ContadorBarco3);
					if(ContadorBarco3 > 3) {
						b.setIcon(new ImageIcon("agua1.jpg"));
					}else
					if (x == 8 || x == 9)
						b.setIcon(new ImageIcon("agua1.jpg"));
					else {
						b.setIcon(new ImageIcon("cruzador1V.jpg"));
						tabuleiro[x + 1][y].setIcon(new ImageIcon("cruzador2V.jpg"));
						tabuleiro[x + 2][y].setIcon(new ImageIcon("cruzador3V.jpg"));
					}
					break;
				}

			}

		}

	}

}
