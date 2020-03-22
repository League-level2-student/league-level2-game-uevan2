import javax.swing.JFrame;

public class LeagueFighters {
	
	JFrame leagueFightersJFrame;
	GamePanel1 GP = new GamePanel1();
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 800;
	
	LeagueFighters(){
		leagueFightersJFrame = new JFrame();
	}
	
	public static void main(String[] args) {
		LeagueFighters LF = new LeagueFighters();
		
		LF.setup();
	}
	
	void setup() {
		
		leagueFightersJFrame.setSize(WIDTH, HEIGHT);
		leagueFightersJFrame.setVisible(true);
		leagueFightersJFrame.add(GP);
		
		leagueFightersJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
