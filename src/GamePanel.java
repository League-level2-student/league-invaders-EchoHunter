import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;	
	public static boolean gotImage = false;	
	Timer frameDraw;
int kills = 0;
	Rocketship r = new Rocketship(250,700, 50,50);
	ObjectManager m = new ObjectManager(r);	
	Timer alienSpawn;
	GamePanel(){
		 titleFont = new Font("Arial", Font.PLAIN, 48);
		 lowerFont = new Font("Arial", Font.PLAIN, 25);
		 frameDraw = new Timer(50/3, this);
		 frameDraw.start();
	}
	Font titleFont;
	Font lowerFont;
	@Override
	public void paintComponent(Graphics g){
		
	
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 void updateMenuState() {}
	 void updateGameState() { m.update(); }
	 void updateEndState()  {  }
	 void drawMenuState(Graphics g) {
		 
		 g.setColor(Color.BLUE);
	 g.fillRect(0, 0, LeagueInvaders.W, LeagueInvaders.H); 
	 g.setFont(titleFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("League Invaders", 55,70 );
	 
	 g.setFont(lowerFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Press ENTER to start", 55, 400 );
	 g.setFont(lowerFont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Press Space to see instructions", 55, 650 );
	 
	 }
	 void drawGameState(Graphics g) {
		
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.W, LeagueInvaders.H);
	 
	 loadImage("SPAECE.jpg");
	 g.drawImage(image,0,0,LeagueInvaders.W, LeagueInvaders.H, null);
	 m.draw(g);
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
	 void drawEndState(Graphics g)  {
		 System.out.println("end");
		 g.setColor(Color.RED);
	 g.fillRect(0, 0, LeagueInvaders.W, LeagueInvaders.H); 
	 g.setFont(titleFont);
	 g.setColor(Color.BLACK);
	 g.drawString("FAILURE", 55,70 );
	 
	 g.setFont(lowerFont);
	 g.setColor(Color.BLACK);
	 g.drawString("You got "+ kills+" Kills", 55, 400 );
	 g.setFont(lowerFont);
	 g.setColor(Color.BLACK);
	 g.drawString("Press Enter to Restart", 55, 650 );
	 
	 }
	 final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == END) {
				currentState = MENU;
			}
			else if(currentState == MENU) {
				currentState++;
				startGame();
			}
			else if (currentState == GAME) {
				currentState++;
				endGame();
			}
		}
		if (arg0.getKeyCode()==KeyEvent.VK_UP) {
		    r.up();
		}
		if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		    r.down();
		}
		if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
		    r.right();
		}
		if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
		    r.left();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
			m.addProjectile();
		}
	repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		r.xSpeed = 0;
		r.ySpeed = 0;
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void startGame() {
		 alienSpawn = new Timer(1000 , m);
		 alienSpawn.start();
		
	}
	void endGame() {
		alienSpawn.stop();
	}
}

