import java.awt.BorderLayout;

import javax.swing.JPanel;

public class vueJeu extends JPanel {
	
	Joueur[] joueur;
	
	public vueJeu (Joueur[] jou) {
		
		super();
		
		joueur = jou;
		
		this.setLayout(new BorderLayout());
		
		vuePoints points = new vuePoints(joueur);
	    this.add(points, BorderLayout.NORTH);
	    
	    vueHistorique historique = new vueHistorique();
	    this.add(historique, BorderLayout.CENTER);
	    
	    vueLettre main = new vueLettre(joueur);
	    this.add(main, BorderLayout.SOUTH);
		
	}
	
}
