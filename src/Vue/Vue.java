package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modele.Joueur;
import Modele.Modele;


public class Vue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static int SIZE = 15;
	static int[][] MD = {{1,1}, {2,2}, {3,3}, {4,4}, {13,1}, {12,2}, {11,3}, {10,4}, {1,13}, {2,12}, {3,11}, {4,10}, {10,10}, {11,11}, {12,12}, {13,13}, {7,7}};
	static int[][] LD = {{0,3}, {0,11}, {2,6}, {2,8}, {3,0}, {3,7}, {3,14}, {6,2}, {6,6}, {6,8}, {6,12}, {7,3}, {7,11}, {8,2}, {8,6}, {8,8}, {8,12}, {11,0}, {11,7}, {11,14}, {12,6}, {12,8}, {14,3}, {14,11}};
	static int[][] MT = {{0,0}, {0,7}, {0,14}, {7,0}, {7,14}, {14,0}, {14,7}, {14,14}};
	static int[][] LT = {{1,5}, {1,9}, {5,1}, {5,5}, {5,9}, {5,13}, {9,1}, {9,5}, {9,9}, {9,13}, {13,5}, {13,9}};
	
	public Vue() {
		super("Sccrable");
	    	
		this.setLayout(new BorderLayout());
	    this.setResizable(false);
	    
	    Modele modele = new Modele();
	    
	    PlateauDeJeu plateau = new PlateauDeJeu();
	    this.add(plateau, BorderLayout.WEST);
	      
	    vueJeu vueDuJeu = new vueJeu(modele);
	    this.add(vueDuJeu, BorderLayout.CENTER);
	    
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args){
	    
		JFrame test = new Vue();
	}
}
