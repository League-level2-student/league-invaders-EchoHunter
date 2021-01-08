import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	GameObject(int a, int b, int c, int d) {
		this.x = a;
		this.y = b;
		this.width = c;
		this.height = d;
		collisionBox = new Rectangle(a, b, c, d);
	}

	int speed = 0;
	boolean isActive = true;

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
}
