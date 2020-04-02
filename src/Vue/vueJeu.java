package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Modele.Joueur;

public class vueJeu extends JPanel {
	
	Joueur[] joueur;
	
	public vueJeu (Joueur[] jou) {
		
		super();
		
		joueur = jou;
		
		this.setLayout(new BorderLayout());
		
		vuePoints points = new vuePoints(joueur);
		//points.setSize(new Dimension(this.getWidth(), 150));
	    this.add(points, BorderLayout.NORTH);
	    
	    vueHistorique historique = new vueHistorique();
	    //historique.setSize(new Dimension(this.getWidth(), 500));
	    this.add(historique, BorderLayout.CENTER);
	    
	    vueLettre main = new vueLettre(joueur[0]);
	    //main.setSize(new Dimension(this.getWidth(), 50));
	    this.add(main, BorderLayout.SOUTH);
		
	}
	
}
