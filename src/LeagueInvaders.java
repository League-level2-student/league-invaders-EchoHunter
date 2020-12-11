import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LeagueInvaders {
	static JFrame j;
	JPanel panel = new JPanel();
	GamePanel g = new GamePanel();
	public static void main(String[] args) {
	j = new JFrame();
	
LeagueInvaders l = new LeagueInvaders();
l.setup();
	}
	public void setup() {
		j.add(g);
		j.addKeyListener(g);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(W,H);
		j.setVisible(true);
		
	}
	
	public final static int W = 500;
	public final static int H = 800;
}
