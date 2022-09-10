package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel label2;
	String current;
	String display;
	Utilities getter;
	int lives = 10;
	ArrayDeque<String> list = new ArrayDeque<String>();

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label2 = new JLabel();
		frame.add(panel);
		frame.setTitle("Hangman");
		frame.setVisible(true);
		frame.addKeyListener(this);
		current = "";
		display = "";
		label2.setText("Lives left: " + lives);
		getter = new Utilities();

		String plays = JOptionPane.showInputDialog(null, "How many words do you want to guess? (1 - 100)");
		int words = Integer.parseInt(plays);

		for (int i = 0; i < words; i++) {
			String undupe = getter.readRandomLineFromFile("dictionary.txt");
			if (!list.contains(undupe)) {
				list.add(undupe);
			} else {
				i--;
			}
		}

		current = list.pop();
		for (int i = 0; i < current.length(); i++) {
			display += "_";
		}
		label.setText(display);
		frame.pack();

	}

	public static void main(String[] args) {

		Hangman hangman = new Hangman();
		hangman.setup();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (current.contains(e.getKeyChar() + "")) {
			if (!display.contains(e.getKeyChar() + "")) {
				StringBuilder setter = new StringBuilder(display);
				for (int i = 0; i < current.length(); i++) {
					if (current.charAt(i) == e.getKeyChar()) {
						setter.setCharAt(i, e.getKeyChar());
					}
				}
				display = setter.toString();
				label.setText(display);
				if (display.equals(current)) {
					if (list.size() - 1 > 0) {
						current = list.pop();
						for (int i = 0; i < current.length(); i++) {
							display += "_";
						}
						label.setText(display);
					} else {
						Hangman reset2 = new Hangman();
						JOptionPane.showMessageDialog(null, "You Win!");
						String retry = JOptionPane.showInputDialog("Would You Like To Play Again?(Yes/No)");
						if (retry.equalsIgnoreCase("Yes")) {
							reset2.setup();
						} else {
							System.exit(0);
						}
					}
				}
			}
		} else {
			lives--;
			Hangman reset = new Hangman();
			if (lives <= 0) {
				JOptionPane.showMessageDialog(null, "Game Over!");
				String retry = JOptionPane.showInputDialog("Would You Like To Play Again?(Yes/No)");
				if (retry.equalsIgnoreCase("Yes")) {
					reset.setup();
				} else {
					System.exit(0);
				}
			}
			label2.setText("Lives Left: " + lives);
		}

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
