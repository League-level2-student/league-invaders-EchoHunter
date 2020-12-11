import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	Alien(int a, int b, int c, int d) {
		super(a, b, c, d);
		
	speed = 1;
	}
void update(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, width, height);
}
void draw() {
	y+=speed;
}
}
