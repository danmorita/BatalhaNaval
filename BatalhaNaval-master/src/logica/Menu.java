package logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.TelaPrincipal.Acoes;
import telas.Botao;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Botao playerVSnpc = new Botao("Player VS NPC");
	private Botao playerVSplayer = new Botao("Player VS Player");
	private JPanel painelPrincipal = new JPanel();
	
	public Menu(){
		super ("Menu Batalha Naval");
		Layout();
		Acoesmenu();
		IniciaTela();
	}
	
	public static void main(String[] args) {
		new Menu();
	}
	
	private void Layout(){
		painelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.add(playerVSnpc);
		painelPrincipal.add(playerVSplayer);
		//painelPrincipal.setBackground("art naval.jpg");
	}
	private void IniciaTela() {
		setSize(300, 80);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void Acoesmenu() {
		playerVSnpc.addActionListener(new Acoes());
		playerVSplayer.addActionListener(new Acoes());
	}
	private class Acoes implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			

			Botao b = (Botao) e.getSource();
			if (b.getParent() == painelPrincipal) {
				if (b == playerVSnpc) {
					new TelaPrincipal();
				}
		}
	}
}
}
