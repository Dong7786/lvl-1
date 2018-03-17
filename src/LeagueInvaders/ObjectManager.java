package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectiles> projectiles = new ArrayList<Projectiles>();

	ObjectManager(Rocketship rs) {
		rocket = rs;

	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void addProjectile(Projectiles p) {
		projectiles.add(p);
	}
}
