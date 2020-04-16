package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
			Font fontnomJ = new Font("Arial", Font.BOLD,16);
			JLabel pointJ = new JLabel(Integer.toString(joueur[i].point));
			Font fontpointJ = new Font("Arial", Font.BOLD,16);
			nomJ.setFont(fontnomJ);
			pointJ.setFont(fontpointJ);
			pointJoueur[i].add(nomJ);
			pointJoueur[i].add(pointJ);
		}
		
		JPanel pointTab = new JPanel();
		pointTab.setLayout(new FlowLayout());
		pointTab.add(Box.createRigidArea(new Dimension(75,10)));
		for (int i = 0; i<pointJoueur.length; i++) {
			pointTab.add(pointJoueur[i]);
			pointTab.add(Box.createRigidArea(new Dimension(150,10)));
		}
		BoxLayout layoutvuePoints = new BoxLayout(this, BoxLayout.Y_AXIS);
		//layoutvuePoints.setVgap(5);
		this.setLayout(layoutvuePoints);
		
		JLabel titre = new JLabel("JOUEURS");
		Font font = new Font("Arial", Font.BOLD,20);
		titre.setFont(font);
		titre.setHorizontalAlignment(titre.CENTER);
		
		this.add(titre);
		this.add(Box.createRigidArea(new Dimension(0,15)));
		this.add(pointTab);
		
		
		
	}
		
}
