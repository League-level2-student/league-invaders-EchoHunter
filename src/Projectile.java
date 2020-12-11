import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	Projectile(int a, int b, int c, int d) {
		super(a, b, c, d);
		speed = 10;
	}
	void update(Graphics g) {
	    g.setColor(Color.RED);
	    g.fillRect(x, y, width, height);
	}
	void draw() {
		y-=speed;
	}
}
