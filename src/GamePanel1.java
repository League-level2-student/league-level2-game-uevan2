import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel1 extends JPanel implements KeyListener{
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    int currentState = MENU;
    
    Font titleFont;
    Font normalFont;
  
    GamePanel1(){
	    titleFont = new Font("Impact", Font.PLAIN, 48);
	    normalFont = new Font("Arial", Font.PLAIN, 18);
    }
    
	@Override
	public void paintComponent(Graphics g){
		System.out.println(currentState);
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
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueFighters.WIDTH, LeagueFighters.HEIGHT);
	 }
	
	 void updateMenuState() { 
		 
	 }
	 void updateGameState() { 
		 
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
	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
