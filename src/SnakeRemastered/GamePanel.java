package SnakeRemastered;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
Timer timer;
PlayerSnake snake1 = new PlayerSnake(960, 486, 20, 20);
ObjectsManager manager = new ObjectsManager(snake1);
void updateGameState() {
	manager.update();
	System.out.println("yes");
}
void drawGameState(Graphics g) {
	
	manager.draw(g);
	if (snake1.x >= 1900) {
		snake1.x = 1900;
	} else if (snake1.x <= 0) {
		snake1.x = 0;

	}
	if (snake1.y >= 952) {
		snake1.y = 950;

	} else if (snake1.y <= 0) {
		snake1.y = 0;
	}
}

GamePanel(){
	timer = new Timer(1000/60, this);
	
}
void startGame() {
	timer.start();
}
@Override

public void paintComponent(Graphics g){

             
g.fillRect(0, 0, 1920, 972);
g.setColor(Color.white);

drawGameState(g);
        }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
updateGameState();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// object.x = object.x + 20;
			// snake1.x = snake1.x + snake1.speed;
			snake1.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// object.x = object.x - 20;
			// snake1.x = snake1.x - snake1.speed;
			snake1.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// object.y = object.y + 20;
			snake1.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// object.y = object.y - 20;
			snake1.up = true;
		}

}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			snake1.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			snake1.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			snake1.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			snake1.down = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
