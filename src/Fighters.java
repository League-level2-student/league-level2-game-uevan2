import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fighters {
	
	int xPos;
	int yPos = 300;
	int width;
	int height;
	int speed = 10;
	int health;
	Rectangle collisionBox;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Fighters(int xPos, int width, int height, int health, int speed) {
		this.xPos = xPos;
		this.width = width;
		this.height = height;
		this.health = health;
		collisionBox = new Rectangle(xPos, yPos, width, height);
		
		if (needImage) {
		    loadImage ("Fighter.jpg");
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
	
	void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, xPos, yPos, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(xPos, yPos, width, height);
        }
	}
	
	void update() {
		 collisionBox.setBounds(xPos, yPos, width, height);
	}
	
	void left() {
		xPos-=speed;
	}
	
	void right() {
		xPos+=speed;
	}
	
	void jump() {
		for(int velocity = 20; velocity >= -20; velocity--) {
			yPos=yPos-velocity;
			System.out.println(yPos);
		}
	}
	
}
