import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	Rocketship r;
	ObjectManager(Rocketship s){
	r= s;
}
	ArrayList<Alien> aliens = new ArrayList<Alien>();
void addAlien(){
	aliens.add(new Alien(random.nextInt(LeagueInvaders.W),1,50,50));
}

void addProjectile(){
	projectiles.add(new Projectile(r.x,r.y,35,35));
}
void update() {
	r.update();


	for(Alien x: aliens) {
		x.update();
		if(x.y > GamePanel.HEIGHT ) {
			x.isActive = false;
		}
	}
}
void draw(Graphics g) {
	r.draw(g);
	for(Alien x: aliens) {
		x.draw(g);
	}
	for(Projectile x: projectiles) {
		x.draw(g);
	}
}
void purgeObjects() {
	for(Alien x: aliens) {
	if(x.isActive = false) {
		aliens.remove(x);
	}
	}
	for(Projectile x: projectiles) {
		if(x.isActive = false) {
			projectiles.remove(x);
		}
	}
}
void checkCollision() {
	for(Alien x: aliens ) {
		if((x.collisionBox.x >= r.collisionBox.x)&&(x.collisionBox.y <= r.collisionBox.y)) {
			
		}
	}
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
}
