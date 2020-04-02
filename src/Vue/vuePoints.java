package Vue;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Joueur;


public class vuePoints extends JPanel {
	
	Joueur[] joueur;
	
	public vuePoints(Joueur[] jou) {
		
		super();
		
		joueur = jou;
		
		//this.setPreferredSize(new Dimension(500, 100));
		
		JPanel[] pointJoueur = new JPanel[joueur.length];
		for (int i = 0; i<joueur.length; i++) {
			pointJoueur[i] = new JPanel();
			pointJoueur[i].setLayout(new BoxLayout(pointJoueur[i], BoxLayout.Y_AXIS));
			JLabel nomJ = new JLabel(joueur[i].nom);
			JLabel pointJ = new JLabel(Integer.toString(joueur[i].point));
			pointJoueur[i].add(nomJ);
			pointJoueur[i].add(pointJ);
		}
		
		JPanel pointTab = new JPanel();
		pointTab.setLayout(new FlowLayout());
		for (int i = 0; i<pointJoueur.length; i++) {
			pointTab.add(pointJoueur[i]);
		}
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Joueur"));
		this.add(pointTab);
		
		
		
	}
		
}
