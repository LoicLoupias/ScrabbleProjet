package Vue;

import java.awt.BorderLayout;
import java.awt.Color;

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
		this.setLayout(layoutVueLettreBouton);
		layoutVueLettreBouton.setVgap(0);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		main = new vueLettre(modele);
		this.add(main,layoutVueLettreBouton.SOUTH);
		
		bouton = new VueBoutonJeu(modele);
		this.add(bouton,layoutVueLettreBouton.NORTH);
	}

}
