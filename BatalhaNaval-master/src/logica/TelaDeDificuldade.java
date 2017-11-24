package logica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import telas.Botao;

public class TelaDeDificuldade extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9187982162579278053L;
	
	private JPanel painelCentral = new JPanel();
	private Botao facil = new Botao("Fácil");
	private Botao medio = new Botao("Médio");
	private Botao dificil = new Botao("Dificil");
	
	public TelaDeDificuldade() {
		super("Dificuldade");
		Layout();
		//Acoesmenu();
		IniciaTela();
		
	}
	public static void main(String[] args) {
		new TelaDeDificuldade();
	}
	private void Layout(){
		this.painelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		getContentPane().add(painelCentral, BorderLayout.CENTER);
		this.painelCentral.add(facil);
		this.painelCentral.add(medio);
		this.painelCentral.add(dificil);
	}
	private void IniciaTela() {
		setSize(150, 156);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
