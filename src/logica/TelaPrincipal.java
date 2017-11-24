package logica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import telas.Botao;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2875856536877113449L;

	/**
	 * Atributos da tela principal
	 */
	
	public Botao tabuleiro1[][], tabuleiro2[][];
	private JPanel painelTBJogador,painelTBNPC ;
	private JPanel painelBotoes;
	private Botao sair, reiniciar;
	private Jogo jogo;

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TelaPrincipal();
	}

	/**
	 * Construtor publico
	 */
	public TelaPrincipal() {
		super("Batalha Naval");
		inicializaAtributos();
		defineLayouts();
		adicionaComponentes();
		adicionaAcoes();
		inicializaParametros();
	}

	/**
	 * adiciona acoes dos botoes
	 */
	private void adicionaAcoes() {
		sair.addActionListener(new Acoes());

		for (int i = 0; i < tabuleiro1.length; i++) {
			for (int j = 0; j < tabuleiro1[i].length; j++) {
				tabuleiro1[i][j].addActionListener(new Acoes());
			}
		}
	}

	/**
	 * adiciona componentes nos paineis
	 */
	private void adicionaComponentes() {
		getContentPane().add(painelTBJogador, BorderLayout.WEST);
		getContentPane().add(painelTBNPC, BorderLayout.CENTER);
		
		for (int i = 0; i < tabuleiro1.length; i++) {
			for (int j = 0; j < tabuleiro1[i].length; j++) {
				painelTBJogador.add(tabuleiro1[i][j]);
				tabuleiro1[i][j].setIcon(new ImageIcon("agua1.jpg"));
				tabuleiro1[i][j].setPreferredSize(new Dimension(50, 50));
			}
		}
		
		for (int i = 0; i < tabuleiro2.length; i++) {
			for (int j = 0; j < tabuleiro2[i].length; j++) {
				painelTBNPC.add(tabuleiro2[i][j]);
				tabuleiro2[i][j].setIcon(new ImageIcon("agua1.jpg"));
				tabuleiro2[i][j].setPreferredSize(new Dimension(50, 50));
			}
		}
		
		getContentPane().add(painelBotoes, BorderLayout.NORTH);
		painelBotoes.add(sair);
		painelBotoes.add(reiniciar);

	}

	/**
	 * define os layouts dos paineis
	 */
	private void defineLayouts() {
		getContentPane().setLayout(new BorderLayout());
		painelTBJogador.setLayout(new GridLayout(10, 10));
		painelTBNPC.setLayout(new GridLayout(10, 10));
		painelBotoes.setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	/**
	 * inicializa os atributos da classe
	 */
	private void inicializaAtributos() {
		tabuleiro1 = new Botao[10][10];
		tabuleiro2 = new Botao[10][10];
		for (int i = 0; i < tabuleiro1.length; i++) {
			for (int j = 0; j < tabuleiro1[i].length; j++) {
				tabuleiro1[i][j] = new Botao();
				tabuleiro1[i][j].x = i;
				tabuleiro1[i][j].y = j;
				
				tabuleiro2[i][j] = new Botao();
				tabuleiro2[i][j].x = i;
				tabuleiro2[i][j].y = j;
			}
		}

		painelTBJogador = new JPanel();
		painelTBNPC = new JPanel();
		painelBotoes = new JPanel();
		sair = new Botao("Sair");
		reiniciar = new Botao("Resetar");
		jogo = new Jogo();
	}

	/**
	 * set os parametros principais da tela
	 */
	private void inicializaParametros() {
		setSize(1050, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * classe que trata acoes dos botoes
	 * 
	 * @author jadermcg
	 *
	 */
	public class Acoes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Botao b = (Botao) e.getSource();

			if (b.getParent() == painelBotoes) {
				if (b == sair) {
					System.exit(0);
				}
			} else if (b.getParent() == painelTBJogador) {
				int x = b.x;
				int y = b.y;
				System.out.println(x+"-"+y);
				int conteudo = jogo.joga(x, y);
				System.out.println(conteudo);
				if (conteudo == 0)
					b.setIcon(new ImageIcon("agua.jpg"));
				else if (conteudo == 1)
					b.setIcon(new ImageIcon("submarino.jpg"));
			}
			 else if (b.getParent() == painelTBNPC) {
					int x = b.x;
					int y = b.y;
					int conteudo = jogo.joga(x, y);
					System.out.println(conteudo);
					if (conteudo == 0)
						b.setIcon(new ImageIcon("agua.jpg"));
					else if (conteudo == 1)
						b.setIcon(new ImageIcon("barco.png"));
				}

		}

	}

}
