import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	Rocketship r;
	int score = 0;
	int alienSpawned = 0;
	
	ObjectManager(Rocketship s) {
		r = s;
	}

	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<AlienBoss> bigalien = new ArrayList<AlienBoss>();
	void addAlien() {
		alienSpawned++;
		if(alienSpawned%20==4) {
			bigalien.add(new AlienBoss(random.nextInt(LeagueInvaders.W), 1, 100, 100));
		}
		else{
		aliens.add(new Alien(random.nextInt(LeagueInvaders.W), 1, 50, 50));
		
		}
	}
	void addProjectile() {
		projectiles.add(new Projectile(r.x, r.y, 35, 35));
	}

	void update() {
		r.update();
		for (AlienBoss x : bigalien) {
			x.update();
			if (x.y > LeagueInvaders.H) {
				x.x= random.nextInt(LeagueInvaders.W);
				x.y=1;

			}
		}
		for (Alien x : aliens) {
			x.update();
			if (x.y > LeagueInvaders.H) {
				//x.isActive = false;
				x.y = 1;

			}
		}
		for (Projectile c : projectiles) {
			System.out.println(projectiles.size());
			c.update();
			if(c.y < 0) {
				c.isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		r.draw(g);
		for (Alien x : aliens) {
			x.draw(g);
		}
		for (AlienBoss x : bigalien) {
			x.draw(g);
		}
		for (Projectile x : projectiles) {
			x.draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
				
			}
		}
		for (int i = 0; i < bigalien.size(); i++) {
			if (bigalien.get(i).isActive == false) {
				bigalien.remove(i);
				
			}
		}
		for (int c = 0; c < projectiles.size(); c++) {
			if (projectiles.get(c).isActive == false) {
				projectiles.remove(c);
			}
		}
		if (r.isActive == false) {

		}
	}

	void checkCollision() {
		for (Alien x : aliens) {
			for (Projectile f : projectiles) {
				if (f.collisionBox.intersects(x.collisionBox)) {
					f.isActive = false;
					x.isActive = false;
					score++;
					System.out.println("checkCollision");
				}	
			}
			if (r.collisionBox.intersects(x.collisionBox)) {
				r.isActive = false;
				x.isActive = false;
				
				
				
			}
		}
		for (AlienBoss x : bigalien) {
			for (Projectile f : projectiles) {
				if (f.collisionBox.intersects(x.collisionBox)) {
					f.isActive = false;
					if(x.health<=0) {
						x.isActive = false;
						score += 50;
					}
					
				}	
			}
			if (r.collisionBox.intersects(x.collisionBox)) {
				r.isActive = false;
				x.health--;
				if(x.health<=0) {
					x.isActive = false;
					score++;
				}
				
				
			}
		}
	}
	public int getScore() {
		return score;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
