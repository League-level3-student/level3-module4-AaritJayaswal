package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
JFrame frame;
JPanel panel;

	
	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setTitle("Hangman");
		frame.setVisible(true);
		frame.addKeyListener(this);
		
		
	String plays = JOptionPane.showInputDialog(null,"How many words do you want to guess? (1 - 100)");
	int words = Integer.parseInt(plays);
	
	
	}
	public static void main(String[] args) {
		
	Hangman runner = new Hangman();
	Hangman.setup();
		
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
