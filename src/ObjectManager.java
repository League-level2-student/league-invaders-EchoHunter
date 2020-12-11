import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Random random = new Random();
	Rocketship r;
	ObjectManager(Rocketship s){
	r= s;
}
	ArrayList<Alien> aliens = new ArrayList<Alien>();
void addAlien(){
	aliens.add(new Alien(random.nextInt(GamePanel.WIDTH),0,50,50));
}
void update() {
	for(Alien x: aliens) {
		x.update();
		if(x.y < GamePanel.HEIGHT ) {
			x.isActive = false;
		}
	}
}
}
