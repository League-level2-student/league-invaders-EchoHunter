import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Projectile(int a, int b, int c, int d) {
		super(a, b, c, d);
		if (needImage) {
		    loadImage ("pew.png");
		}
		speed = 10;
	}
	void update(Graphics g) {
	    g.setColor(Color.RED);
	    g.fillRect(x, y, width, height);
	}
	void draw(Graphics g) {
		y-=speed;
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
