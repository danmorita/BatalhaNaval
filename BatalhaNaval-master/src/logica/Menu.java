package logica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.TelaPrincipal.Acoes;
import telas.Botao;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Botao Imagem = new Botao("");
	private Botao playerVSnpc = new Botao("Player VS NPC");
	private Botao playerVSplayer = new Botao("Player VS Player");
	private JPanel painelPrincipal = new JPanel();
	private JPanel painelImagem = new JPanel();
	
	public Menu(){
		super ("Menu Batalha Naval");
		Layout();
		Acoesmenu();
		IniciaTela();
	}
	
	public static void main(String[] args) {
		new Menu();
	}
	/*
	 * define o Layout
	 * */
	private void Layout(){
		this.painelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.painelImagem.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(painelPrincipal, BorderLayout.SOUTH);
		getContentPane().add(painelImagem, BorderLayout.CENTER);
		this.painelPrincipal.add(playerVSnpc);
		this.painelPrincipal.add(playerVSplayer);
		this.painelImagem.add(Imagem);
		this.Imagem.setIcon(new ImageIcon("Imagem.jpg"));
		this.Imagem.setPreferredSize(new Dimension(500, 300));
		this.Imagem.setEnabled(false);
		this.Imagem.setDisabledIcon(new ImageIcon("Imagem.jpg"));
	}
	/*
	 * Inicializa a tela
	 * */
	private void IniciaTela() {
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * Atribue a ação ao botao
	 * */
	private void Acoesmenu() {
		playerVSnpc.addActionListener(new Acoes());
		playerVSplayer.addActionListener(new Acoes());
	}
	/*
	 * Cria Ação
	 * */
	private class Acoes implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			

			Botao b = (Botao) e.getSource();
			if (b.getParent() == painelPrincipal) {
				if (b == playerVSnpc) {
					new Copia();
					setVisible(false);
				}
		}
	}
}
}
