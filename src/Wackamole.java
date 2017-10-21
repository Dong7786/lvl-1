import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Wackamole implements ActionListener{
	static int l;
	static JButton buttons[] = new JButton[84];

public static void main(String[] args) {
	
Wackamole w = new Wackamole();
w.drawButtons();
	
}//main
void drawButtons() {
	 JFrame frame = new JFrame();
	 JPanel panel = new JPanel();
	Random random = new Random();
	
	frame.setVisible(true);
	
	frame.add(panel);
	panel.setVisible(true);
	for(int i = 0; i < buttons.length; i ++) {
		
		buttons[i] = new JButton();
		panel.add(buttons[i]);
		buttons[i].setVisible(true);
		buttons[i].addActionListener(this);
}
	frame.setSize(500, 500);
int number = random.nextInt(buttons.length);
l = number;
buttons[number].setText("Mole!");
}//drawButtons
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == buttons[l]) {
		System.out.println("c");
		speak("Whack!");
	}else {
		System.out.println("w");
		speak("Dork!");
	}
}
void speak(String words) {
try {
Runtime.getRuntime().exec("say " + words).waitFor();
} catch (Exception e) {
e.printStackTrace();
}
}

}//class