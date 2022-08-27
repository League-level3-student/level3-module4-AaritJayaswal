package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JLabel label = new JLabel();
Stack<Character> characters = new Stack<Character>();

void start() {
	frame.add(panel);
	panel.add(label);
	frame.setTitle("notepad");
frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.addKeyListener(this);
	label.setVisible(true);
	
}

public static void main(String[] args) {
	_02_TextUndoRedo runner = new _02_TextUndoRedo();
	runner.start();
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
	Character c = e.getKeyChar();
	if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		String s = label.getText();
		characters.add(s.charAt(s.length()-1));
		s = s.substring(0, s.length()-1);
		label.setText(s);
	}
	
	
	else {
		
		label.setText(label.getText()+c);
	
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
