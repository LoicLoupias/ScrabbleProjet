package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Modele.Joueur;
import Modele.Modele;

public class vueJeu extends JPanel {
	
	Joueur[] joueur;
	vuePoints points;
	vueHistorique historique;
	vueLettre main;
	
	public vueJeu (Modele modele) {
		
		super();
		
		joueur = modele.joueurs;
		
		this.setLayout(new BorderLayout());
		
		points = new vuePoints(joueur);
		//points.setSize(new Dimension(this.getWidth(), 150));
	    this.add(points, BorderLayout.NORTH);
	    
	    historique = new vueHistorique();
	    //historique.setSize(new Dimension(this.getWidth(), 500));
	    this.add(historique, BorderLayout.CENTER);
	    
	    main = new vueLettre(modele);
	    //main.setSize(new Dimension(this.getWidth(), 50));
	    //main.afficheMain(0);
	    this.add(main, BorderLayout.SOUTH);
		
	}
	
}
