package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.Box;
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
		pointTab.setLayout(new BoxLayout(pointTab,BoxLayout.X_AXIS));
		pointTab.add(Box.createRigidArea(new Dimension(75,10)));
		for (int i = 0; i<pointJoueur.length; i++) {
			pointTab.add(pointJoueur[i]);
			pointTab.add(Box.createRigidArea(new Dimension(150,10)));
		}
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel titre = new JLabel("JOUEURS");
		titre.setHorizontalAlignment(titre.CENTER);
		
		this.add(titre);
		this.add(pointTab);
		
		
		
	}
		
}
