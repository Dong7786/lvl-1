import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wackamole {
	static JFrame frame = new JFrame();
static JPanel panel = new JPanel();
public static void main(String[] args) {
	frame.setSize(500, 500);
	frame.setVisible(true);
	frame.add(panel);
	
	
}
void drawButtons() {
	JButton buttons[] = new JButton[24];
	for(int i = 0; i < buttons.length; i ++) {
		buttons[i] = new JButton();
		panel.add(buttons[i]);
		buttons[i].setVisible(true);
}
}
}