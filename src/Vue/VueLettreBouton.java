package Vue;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import Modele.Joueur;
import Modele.Modele;

public class VueLettreBouton extends JPanel {
	
	Joueur[] joueur;
	vueLettre main;
	VueBoutonJeu bouton; 
	
	public VueLettreBouton (Modele modele) {
		
		super();
		
		joueur = modele.joueurs;
		
		
		BorderLayout layoutVueLettreBouton = new BorderLayout();
		layoutVueLettreBouton.setVgap(0);
		this.setLayout(layoutVueLettreBouton);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		main = new vueLettre(modele);
		this.add(main,layoutVueLettreBouton.SOUTH);
		
		bouton = new VueBoutonJeu(modele);
		this.add(bouton,layoutVueLettreBouton.NORTH);
	}

}
