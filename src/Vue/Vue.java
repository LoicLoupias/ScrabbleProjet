import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Vue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static int SIZE = 15;
	static int[][] MOT_DOUBLE = {{1,1}, {2,2}, {3,3}, {4,4}, {1,13}, {2,12}, {3,11}, {4,10}};
	static int[][] LETTRE_DOUBLE = {{0,3}, {0,11}, {2,6}, {2,8}, {3,0}, {3,7}, {3,14}, {6,6}, {6,8}};
	static int[][] MOT_TRIPLE = {{0,0}, {7,7}, {0,14}, {14,14}, {0,7}, {0,7}};
	static int[][] LETTRE_TRIPLE = {{1,5}, {1,9}, {5,1}, {5,5}, {5,9}, {5,13}};
	
	
	public Vue(String titre) {
		super(titre);
	    this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	    setResizable(false);
	    
	    /* Plateau de jeu
	    JPanel[] panel = new Plateau_De_Jeu[SIZE];
	    for (int i = 0; i<SIZE; i++) {
			panel[i] = new Plateau_De_Jeu();
			panel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			this.add(panel[i]);
		}
	    for(int i = 0; i<MOT_DOUBLE.length; i++) {
	    	panel[MOT_DOUBLE[i][0]].getComponent(MOT_DOUBLE[i][1]).setBackground(Color.ORANGE);
	    	panel[14 - MOT_DOUBLE[i][0]].getComponent(14 - MOT_DOUBLE[i][1]).setBackground(Color.ORANGE);
	    }
	    for(int i = 0; i<LETTRE_DOUBLE.length; i++) {
	    	panel[LETTRE_DOUBLE[i][0]].getComponent(LETTRE_DOUBLE[i][1]).setBackground(Color.CYAN);
	    	panel[14 - LETTRE_DOUBLE[i][0]].getComponent(14 - LETTRE_DOUBLE[i][1]).setBackground(Color.CYAN);
	    }
	    for(int i = 0; i<MOT_TRIPLE.length; i++) {
	    	panel[MOT_TRIPLE[i][0]].getComponent(MOT_TRIPLE[i][1]).setBackground(Color.RED);
	    	panel[14 - MOT_TRIPLE[i][0]].getComponent(14 - MOT_TRIPLE[i][1]).setBackground(Color.RED);
	    }
	    for(int i = 0; i<LETTRE_TRIPLE.length; i++) {
	    	panel[LETTRE_TRIPLE[i][0]].getComponent(LETTRE_TRIPLE[i][1]).setBackground(Color.BLUE);
	    	panel[14 - LETTRE_TRIPLE[i][0]].getComponent(14 - LETTRE_TRIPLE[i][1]).setBackground(Color.BLUE);
	    }
	    */
	    Plateau_De_Jeu plateau = new Plateau_De_Jeu(SIZE);
	    this.add(plateau);
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args){
	
		JFrame test = new Vue("Test");
	
	}
}
