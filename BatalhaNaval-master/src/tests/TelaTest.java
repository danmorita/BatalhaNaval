package tests;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaTest {
	
	private JFrame frame;
	private JPanel painel1, painel2;
	private JButton botoes1[][];
	private JButton botoes2[][];
	
	public TelaTest() {
		frame = new JFrame();
		painel1 = new JPanel();
		painel2 = new JPanel();
		
		botoes1 = new JButton[10][10];
		botoes2 = new JButton[10][10];
		
		for (int i = 0; i < botoes1.length; i++) {
			for (int j = 0; j < botoes1[i].length; j++) {
				botoes1[i][j] = new JButton();
				botoes2[i][j] = new JButton();
			}
		}
		
		frame.setLayout(new BorderLayout());
		painel1.setLayout(new GridLayout(10, 10));
		painel2.setLayout(new GridLayout(10, 10));
		
		frame.add(painel1, BorderLayout.EAST);
		frame.add(painel2, BorderLayout.WEST);
		
		for (int i = 0; i < botoes1.length; i++) {
			for (int j = 0; j < botoes1[i].length; j++) {
				painel1.add(botoes1[i][j]);
				painel2.add(botoes2[i][j]);
			}
		}
		
		
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TelaTest();
			}
		});

	}

}
