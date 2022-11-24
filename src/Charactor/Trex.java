package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Trex{
	public int x ;
	public int y;
	public int health=180;
	public static int jumpHight=90;
	
	public Trex() {
		
	}
	
	public Trex(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void jump(JPanel page) {
		this.y -= jumpHight;
		page.repaint();
		//--- fall ---
		Timer timer =new Timer(450,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					y += jumpHight;
					page.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("img\\Trex.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}
