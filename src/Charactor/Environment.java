package Charactor;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.lang.Thread;

public class Environment {
		public int x;
		public int y;
		public int startX;
		public int speed;
		public int eType;
		public static int CLOUD = 0,BUILDING=1;
		public Environment(int x,int y,JPanel page,int eType,int speed) {
			this.x = x;
			this.y = y;
			this.startX = x;
			this.speed = speed;
			this.eType = eType;
			this.move(page);
		}
		
		public void move(JPanel page) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					while(true){
						try{
							if(x+400<0) {
								x = startX;
							}
							x -= speed;
							page.repaint(); 
							Thread.sleep(20);
						}catch(Exception e){};
					}
				}
			});
			thread.start();
		}
		
		// public void stop() {
		// 	this.timeMove.stop();
		// }

		
		public String getEvType(int eType){
			 String[] name = new String[] {"cloud.png"};
			 return name[eType];
		}
		
		public BufferedImage getImage() {
			BufferedImage image = null;
			try {
				 image = ImageIO.read(new File("img\\"+getEvType(this.eType)));
				 return image;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
}
