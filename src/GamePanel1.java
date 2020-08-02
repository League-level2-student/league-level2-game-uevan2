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
    
    int whatImage = 0;
    int whatImage1 = 0;
    
    int currentState = MENU;
    
    int fWidth = 200;
    int fHeight = 200;
    int fWidth1 = 200;
    int fHeight1 = 200;
    
    final int STILL = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    
    final int STILL1 = 0;
    final int LEFT1 = 1;
    final int RIGHT1 = 2;
    
    Fighters T1 = new Fighters(200, 200, fWidth, fHeight, 10);
    
    Fighters Yassuo = new Fighters(600, 200, fWidth1, fHeight1, 10);
    
    Font titleFont;
    Font normalFont;
    
    Timer frameDraw;
    
    Boolean ifJump = false;
    Boolean ifJump1 = false;
    
	boolean knocked0 = false;
	boolean knocked1 = false;
	boolean knocked2 = false;
	boolean knocked3 = false;
    
    int velocity = 20;
    int velocity1 = 20;
    int velocity2 = 0;
    int velocity3 = 0;
    
    boolean ifPunch0 = false;
    boolean ifPunch1 = false;
  
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
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("Untitled2.1.png");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==2) {
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("T1 Fighting.png");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==3) {
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("Fighter.jpg");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==4) {
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("T1Punch2.png");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==5) {
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("T1Punch.png");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
			
		 if(whatImage1==1) {
			 Yassuo.needImage = true;
			 Yassuo.gotImage = false;
			 Yassuo.loadImage("Yassuo Still.png");
			 Yassuo.width=fWidth1;
			 Yassuo.height=fHeight1;
			 Yassuo.draw(g);
		 }
		 
		 if(whatImage1==2) {
			 Yassuo.needImage = true;
			 Yassuo.gotImage = false;
			 Yassuo.loadImage("Yassuomoving2.png");
			 Yassuo.width=fWidth1;
			 Yassuo.height=fHeight1;
			 Yassuo.draw(g);
		 }
		 
		 if(whatImage1==3) {
			 Yassuo.needImage = true;
			 Yassuo.gotImage = false;
			 Yassuo.loadImage("Yassuomoving.png");
			 Yassuo.width=fWidth1;
			 Yassuo.height=fHeight1;
			 Yassuo.draw(g);
		 }
		 
		 if(whatImage1==4) {
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("moePunch2.jpg");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(whatImage==4) {
			 T1.needImage = true;
			 T1.gotImage=false;
			 T1.loadImage("moePunch.jpg");
			 T1.width=fWidth;
			 T1.height=fHeight;
			 T1.draw(g);
		 }
		 
		 if(ifJump == true) {
			 T1.jump(g, velocity);
			 velocity=velocity-2;
			 if(velocity<-20) {
				 ifJump=false;
				 velocity=20;
			 }
		 }
		 
		 if(ifJump1 == true) {
			 Yassuo.jump(g, velocity1);
			 velocity1=velocity1-2;
			 if(velocity1<-20) {
				 ifJump1=false;
				 velocity1=20;
			 }
		 }
		 
		 if(ifPunch0==true) {
			 punch("T1", g);
			 ifPunch0=false;
		 }
		 
		 if(ifPunch1==true) {
			 punch("Yassuo", g);
			 ifPunch1=false;
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
		 
		 if(T1.direction==STILL) {
			 whatImage = 3;
		 }
		 
		 if(T1.direction==LEFT) {
			 whatImage = 1;
		 }
		 
		 if(T1.direction==RIGHT) {
			 whatImage = 2;
		 }
		 
		 if(Yassuo.direction==STILL1) {
			 whatImage1 = 1;
		 }
		 
		 if(Yassuo.direction==RIGHT1) {
			 whatImage1 = 2;
		 }
		 
		 if(Yassuo.direction==LEFT1) {
			 whatImage1 = 3;
		 }
		 
		 if(ifPunch0 == true&&T1.direction==LEFT) {
			 whatImage = 4;
		 }
		 
		 if(ifPunch0 = true&&T1.direction==RIGHT) {
			 whatImage = 5;
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
					 T1.direction=LEFT;
				 }
			 }

			 if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				 if(T1.xPos<1500-T1.width) {
					 T1.right();
					 T1.direction=RIGHT;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_UP) {
				 if(T1.yPos>=0) {
					 ifJump = true;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_W) {
				 if(Yassuo.yPos>=0) {
					 ifJump1 = true;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_A) {
				 if(T1.yPos>=0) {
					 Yassuo.left();
					 Yassuo.direction=LEFT1;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_D) {
				 if(T1.yPos>=0) {
					 Yassuo.right();
					 Yassuo.direction=RIGHT1;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				 if(checkColision()==true) {
					 ifPunch0 = true;
				 }
			 }
			 
			 if (e.getKeyCode()==KeyEvent.VK_SPACE) {
				 if(checkColision()==true) {
					 ifPunch1 = true;
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
			T1.direction=STILL;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			T1.direction=STILL;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_A) {
			Yassuo.direction=STILL;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_D) {
			Yassuo.direction=STILL;
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
	
	boolean checkColision() {
		if(T1.xPos+T1.width>Yassuo.xPos&&Yassuo.xPos+Yassuo.width>T1.xPos) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	void punch(String fighter, Graphics g) {
		if(fighter.equals("T1")) {
			Yassuo.health=Yassuo.health-200;
			if(Yassuo.xPos<T1.xPos){
				knockLeft(1, g);
			}
			else {
				knockRight(1, g);
			}
		}
		
		if(fighter.equals("Yassuo")) {
			T1.health=T1.health-100;
			if(T1.xPos<Yassuo.xPos){
				knockLeft(0, g);
			}
			else {
				knockRight(0, g);
			}
		}
	}
	
	void knockLeft(int fighter, Graphics g) {
		if(fighter == 0) {
			knocked0=true;
			if(knocked0 = true) {			
				T1.knock(g, velocity2);
				T1.xPos-=velocity2;
			}
			if(velocity2>=0) {
				knocked0=false;
			}
		}
		
		if(fighter == 1) {
			knocked1=true;
			if(knocked1 = true) {
				Yassuo.knock(g, velocity3);
				Yassuo.xPos-=velocity3;
			}
			if(velocity3>=0) {
				knocked1=false;
			}
		}
	}
	
	void knockRight(int fighter, Graphics g) {
		if(fighter == 0) {
			knocked2=true;
			if(knocked2 = true) {
				T1.knock(g, velocity2);
				T1.xPos+=velocity2;
			}
			if(velocity2>=0) {
				knocked2=false;
			}
		}
		
		if(fighter == 1) {
			knocked3=true;
			if(knocked3 = true) {
				Yassuo.knock(g, velocity3);
				Yassuo.xPos+=velocity3;
			}
			if(velocity3>=0) {
				knocked3=false;
			}
		}
	}
}