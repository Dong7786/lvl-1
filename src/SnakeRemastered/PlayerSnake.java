package SnakeRemastered;

import java.awt.Graphics;

public class PlayerSnake extends GameObject {
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	PlayerSnake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
	}

	void update() {
		super.update();
		if (down == true) {
			y = y + speed;
		}
		if (up == true) {
			y = y - speed;
		}
		if (left == true) {
			x = x - speed;
		}
		if (right == true) {
			x = x + speed;
		}
	}
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
