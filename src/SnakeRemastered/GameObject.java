package SnakeRemastered;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;

	GameObject(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		
	}

	void draw(Graphics g) {

	}

}
