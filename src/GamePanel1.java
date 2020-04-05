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
    
    int currentState = MENU;
    
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
		 if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			 if(currentState==MENU) {
				 JOptionPane.showMessageDialog(null, "League Fighters is a two player fighting game. \n Each player chooses a fishter at the start to battle with. \n The first person to get their enemies health down to zero wins");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
