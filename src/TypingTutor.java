import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener{
	KeyEvent e;
	char currentLetter = generateRandomLetter();
public static void main(String[] args) {
	
	

}
static char generateRandomLetter() {
	Random r = new Random();
	return (char) (r.nextInt(26) + 'a');
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyChar() == currentLetter) {
		System.out.println("Correct!");
		System.out.println("You typed: " + currentLetter);
		
	}else {
		System.out.println("Wrong");
	}
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	currentLetter = generateRandomLetter();
	
}
void stuff() {
	
	String letter = Character.toString(currentLetter);
	JFrame frame = new JFrame();
	JPanel panel= new JPanel();
	JLabel label = new JLabel();
	frame.setTitle("Type or Die");
	label.setFont(label.getFont().deriveFont(100.0f));
	label.setHorizontalAlignment(label.CENTER);
	frame.add(panel);
	panel.add(label);
	frame.setSize(400, 200);
	frame.setVisible(true);
	label.setText(letter);
	frame.addKeyListener(this);
	label.updateUI();
if(e.getKeyChar() == currentLetter) {
		frame.getContentPane().setBackground(Color.GREEN);
	}else {
		frame.getContentPane().setBackground(Color.RED);
	}
}
}
