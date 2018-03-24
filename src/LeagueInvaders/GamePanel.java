package LeagueInvaders;

import javax.swing.Timer;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font titleStart;
	Font titleInstructions;
	int points = 0;
	Font endFont;
	Font endKilled;
	Font restart;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(ship);

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
manager.checkCollision();
manager.purgeObjects();
if(ship.isAlive == false) {
	currentState = END_STATE;
}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 30, 200);
		g.setFont(titleStart);
		g.drawString("Press ENTER to start", 140, 350);
		g.drawString("Press SPACE for instructions", 90, 500);
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		manager.draw(g);
		if (ship.x >= 450) {
			ship.x = 450;
		} else if (ship.x <= 0) {
			ship.x = 0;

		}
		if (ship.y >= 730) {
			ship.y = 725;

		} else if (ship.y <= 0) {
			ship.y = 0;
		}
		manager.manageEnemies();
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(endFont);
		g.drawString("Game Over", 140, 200);
		g.setFont(endKilled);
		g.drawString("You killed " + points + " enemies", 150, 350);
		g.setFont(restart);
		g.drawString("Press ENTER to restart", 130, 500);
	}

	Timer timer;

	// GameObject object;
	GamePanel() {
		titleFont = new Font("Arial", Font.BOLD, 48);
		titleStart = new Font("Arial", Font.BOLD, 24);
		titleInstructions = new Font("Arial", Font.BOLD, 24);
		endFont = new Font("Arial", Font.TRUETYPE_FONT, 48);
		endKilled = new Font("Arial", Font.BOLD, 24);
		restart = new Font("Arial", Font.BOLD, 24);
		timer = new Timer(1000 / 60, this);
		// object = new GameObject(0,0,20,20);
	}

	@Override

	public void paintComponent(Graphics g) {
		// object.draw(g);
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		// object.update();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// object.x = object.x + 20;
			// ship.x = ship.x + ship.speed;
			ship.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// object.x = object.x - 20;
			// ship.x = ship.x - ship.speed;
			ship.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// object.y = object.y + 20;
			ship.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// object.y = object.y - 20;
			ship.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}

		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectile(new Projectiles(ship.x + 25, ship.y + 25, 1, 20));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.down = false;
		}
	}

}