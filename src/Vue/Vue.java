package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controleur.Controleur;
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
	    //this.setResizable(false);
	    
		
		
		
		
	    // pour adapter le plateau à la fenetre il faudrait faire un if avec comme condition le fait que
		// while(largeur du plateau< hauteur de fenetre && largeur-partie pour historique) comme ca la fenetre s'adapter à la taille de la fenetre
	    
		
		
		
		
		PlateauDeJeu plateau = new PlateauDeJeu();
	    this.add(plateau, BorderLayout.WEST);
	    
	    Modele modele = new Modele();
	    
	    vueJeu vueDuJeu = new vueJeu(modele);
	    this.add(vueDuJeu, BorderLayout.CENTER);
	   
	    Controleur control = new Controleur(modele, vueDuJeu, plateau);
	    
	    /*
	    vuePoints points = new vuePoints(modele.joueurs);
	    //points.setSize(new Dimension(this.getWidth(), 150));
	    this.add(points, BorderLayout.NORTH);
	    
	    vueHistorique historique = new vueHistorique();
	    //historique.setSize(new Dimension(this.getWidth(), 500));
	    this.add(historique, BorderLayout.CENTER);
	    
	    vueLettre main = new vueLettre(modele);
	    main.afficheMain(0);
	    //main.setSize(new Dimension(this.getWidth(), 50));
	    this.add(main, BorderLayout.SOUTH);
	    */
	      
	    
	    
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JOptionPane.showMessageDialog(null, "Joueur suivant", "Scrabble", JOptionPane.NO_OPTION);
	    vueDuJeu.historique.ajoutHistorique("test");
	    vueDuJeu.main.afficheMain(0);
	}
	
	public static void main(String [] args){
	    
		JFrame test = new Vue();
	}
}
