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
	static int[][] MOT_DOUBLE = {{1,1}, {2,2}, {3,3}, {4,4}, {1,13}, {2,12}, {3,11}, {4,10}};
	static int[][] LETTRE_DOUBLE = {{0,3}, {0,11}, {2,6}, {2,8}, {3,0}, {3,7}, {3,14}, {6,6}, {6,8},{6,2},{7,3},{8,2}};
	static int[][] MOT_TRIPLE = {{0,0}, {0,7}, {0,14}, {7,0}, {7,7}, {7,14}, {14,0}, {14,7}, {14,14}};
	static int[][] LETTRE_TRIPLE = {{1,5}, {1,9}, {5,1}, {5,5}, {5,9}, {5,13}};
	
	String[] nombre = {"1", "2", "3", "4"};	
	Joueur[] joueur;
	
	public Vue() {
		super("Sccrable");
	    	
	    int nombreJoueur = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
	    	      "Veuillez selectionner le nombre de joueur :",
	    	      "Scrabble",
	    	      JOptionPane.QUESTION_MESSAGE,
	    	      null,
	    	      nombre,
	    	      nombre[0]));
	    
	    joueur = new Joueur[nombreJoueur];
	    for (int i = 1; i<=nombreJoueur; i++) {
	        joueur[i-1] = new Joueur(JOptionPane.showInputDialog(null, "Entrez le nom pour le joueur " + i + " :", "Scrabble", JOptionPane.QUESTION_MESSAGE));
	    }
		
		this.setLayout(new BorderLayout());
	    this.setResizable(false);
	    
	    Modele modele = new Modele(joueur.length);
	    
	    PlateauDeJeu plateau = new PlateauDeJeu();
	    this.add(plateau, BorderLayout.WEST);
	      
	    vueJeu vueDuJeu = new vueJeu(joueur);
	    this.add(vueDuJeu, BorderLayout.CENTER);
	    
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args){
	    
		JFrame test = new Vue();
	}
}
