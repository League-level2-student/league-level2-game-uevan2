import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel1 extends JPanel implements KeyListener, ActionListener{
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    final int STILL = 0;
    final int LEFT = 1;
    final int RIGHT= 2;
    
    int whatImage = 0;
    
    int currentState = MENU;
    
    int direction = STILL;
    
    int fWidth = 200;
    int fHeight = 200;
    
    Fighters T1 = new Fighters(200, 200, fWidth, fHeight, 10);
    
    Fighters Yassuo = new Fighters(200, 200, 300, 500, 10);
    
    Font titleFont;
    Font normalFont;
    
    Timer frameDraw;
  
    GamePanel1(){
	    titleFont = new Font("Impact", Font.PLAIN, 48);
	    normalFont = new Font("Arial", Font.PLAIN, 18);
	    
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
    }
    
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
	
	 void drawMenuState(Graphics g) { 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueFighters.WIDTH, LeagueFighters.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.WHITE);
		 g.drawString("LEAGUE FIGHTERS", 650, 100);
   
		 g.setFont(normalFont);
		 g.drawString("Press ENTER to start", 718, 350);
		    
		 g.drawString("Press SPACE for instructions", 680, 500);
	 }
	 void drawGameState(Graphics g) { 
		 g.setColor(Color.WHITE);
		 g.fillRect(0, 0, LeagueFighters.WIDTH, LeagueFighters.HEIGHT);
		 
		 if(whatImage==0) {
			 T1.draw(g);
		 }
		 
		 if(whatImage==1) {
			 Fighters.needImage = true;
			 Fighters.gotImage=false;
			 T1.loadImage("Untitled2.1.png");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==2) {
			 Fighters.needImage = true;
			 Fighters.gotImage=false;
			 T1.loadImage("T1 Fighting.png");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==3) {
			 Fighters.needImage = true;
			 Fighters.gotImage=false;
			 T1.loadImage("Fighter.jpg");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueFighters.WIDTH, LeagueFighters.HEIGHT);
		 
		 g.setColor(Color.WHITE);
		 g.setFont(titleFont);
		 g.drawString("Game Over", 700, 200);
		 
		 g.setFont(normalFont);
		 g.drawString("_____ Won", 750, 350);
	 }
	
	 void updateMenuState() { 
		 
	 }
	 
	 void updateGameState() { 
		 T1.update();
		 
		 
		 if(direction==STILL) {
			 whatImage = 3;
		 }
		 
		 if(direction==LEFT) {
			 
			 whatImage = 1;
		 }
		 
		 if(direction==RIGHT) {
			 whatImage = 2;
		 }
	 }
	 void updateEndState()  { 
		 
	 }
	 @Override
	 public void keyPressed(KeyEvent e) {
		 if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			 if(currentState==MENU) {
				 currentState++;
			 }
			 else if(currentState==GAME) {
				 currentState++;
			 }
			 else if(currentState==END) {
				 currentState=0;
			 }
		 }
		 
		 if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			 if(currentState==MENU) {
				 JOptionPane.showMessageDialog(null, "League Fighters is a two player fighting game. \n Each player chooses a fishter at the start to battle with. \n The first person to get their enemies health down to zero wins");
			 }
		 }
	
		 if(currentState==GAME) {
			 
			 if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				 if(T1.xPos>0) {
					 T1.left();
					 direction=LEFT;
				 }
			 }

			 if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				 if(T1.xPos<1500-T1.width) {
					 T1.right();
					 direction=RIGHT;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_SPACE) {
				 if(T1.yPos>=300) {
					 T1.jump();
				 }
			 }
		 }
	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			direction=STILL;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			direction=STILL;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
	
}
