import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int xSpeed = 0;
	int ySpeed = 0;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImage("da funny.png");
		}
		speed = 3;
	}

	void draw(Graphics g) {

		if (gotImage) {
			g.drawImage(image, x, y-10, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}

	void up() {
		ySpeed = -speed;
	}

	void down() {
		ySpeed = speed;
	}

	void left() {
		xSpeed = -speed;
	}

	void right() {
		xSpeed = speed;
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

	void update() {
		x += xSpeed;
		y += ySpeed;
		super.update();
	}

	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}
}
