import javax.swing.*;

public class Vue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vue(String titre) {
		super(titre);
	    this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	    
	    JPanel[] panel = new Plateau_De_Jeu[15];
	    for (int i = 0; i<15; i++) {
			panel[i] = new Plateau_De_Jeu();
			//panel[i].setSize(500, 50);
			this.add(panel[i]);
		}
	    
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args){
	
		JFrame test = new Vue("Test");
	
	}
}
