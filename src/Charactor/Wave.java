package Charactor;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.lang.Thread;

public class Wave {
		public int speed;
		public int x;
		public int y;
		public Wave(int x,int y,int speed,JPanel page) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.move(page);
		}
		
		public void move(JPanel page) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							if(x<=0) {
								x = (int) (1000+(300+Math.random()*1000));
							}
							x -= 30;
							page.repaint();
							Thread.sleep(speed);
						} catch (Exception e) {}
					}
				}
			});
			thread.start();
		}
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\rock.png"));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
}
