import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	Rocketship r;
	ObjectManager(Rocketship s){
	r= s;
}
	ArrayList<Alien> aliens = new ArrayList<Alien>();
void addAlien(){
	aliens.add(new Alien(random.nextInt(GamePanel.WIDTH),0,50,50));
}
void update() {
	r.update();
	for(Alien x: aliens) {
		x.update();
		if(x.y < GamePanel.HEIGHT ) {
			x.isActive = false;
		}
	}
}
void draw(Graphics g) {
	r.draw(g);
	for(Alien x: aliens) {
		x.draw();
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
}
