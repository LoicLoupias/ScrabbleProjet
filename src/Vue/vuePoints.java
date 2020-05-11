package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Modele.Joueur;
import Modele.Modele;

public class vuePoints extends JPanel {

	Joueur[] joueur;
	public JPanel[] pointJoueur;

	public vuePoints(Joueur[] jou) {

		super();

		joueur = jou;
		this.setBackground(new Color(0, 200, 0));
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		pointJoueur = new JPanel[joueur.length];
		for (int i = 0; i < joueur.length; i++) {
			pointJoueur[i] = new JPanel();
			pointJoueur[i].setLayout(new BoxLayout(pointJoueur[i], BoxLayout.Y_AXIS));
			pointJoueur[i].setPreferredSize(new Dimension(100, 50));

			JLabel nomJ = new JLabel(joueur[i].nom);
			Font fontnomJ = new Font("Arial", Font.BOLD, 16);
			nomJ.setAlignmentX(CENTER_ALIGNMENT);
			nomJ.setFont(fontnomJ);

			JLabel pointJ = new JLabel(Integer.toString(joueur[i].point));
			Font fontpointJ = new Font("Arial", Font.BOLD, 16);
			pointJ.setFont(fontpointJ);
			pointJ.setAlignmentX(CENTER_ALIGNMENT);
			pointJoueur[i].add(nomJ);

			pointJoueur[i].add(pointJ);
			if (i == 0) {
				pointJoueur[i].setBackground(new Color(231, 62, 1));
				pointJoueur[i].setBorder(BorderFactory.createLineBorder(Color.white, 5));
			} else if (i == 1) {
				pointJoueur[i].setBackground(new Color(15, 157, 232));
			} else if (i == 2) {
				pointJoueur[i].setBackground(Color.pink);
			} else {
				pointJoueur[i].setBackground(Color.ORANGE);
			}
			

		}

		JPanel pointTab = new JPanel();
		pointTab.setBackground(new Color(0, 200, 0));
		pointTab.setLayout(new FlowLayout());
		pointTab.add(Box.createRigidArea(new Dimension(25, 10)));
		for (int i = 0; i < pointJoueur.length; i++) {
			pointTab.add(pointJoueur[i]);
			pointTab.add(Box.createRigidArea(new Dimension(60, 10)));
		}
		BoxLayout layoutvuePoints = new BoxLayout(this, BoxLayout.Y_AXIS);
		// layoutvuePoints.setVgap(5);
		this.setLayout(layoutvuePoints);

		JLabel titre = new JLabel("JOUEURS :");
		Font font = new Font("Arial", Font.BOLD, 25);
		titre.setAlignmentX(CENTER_ALIGNMENT);
		titre.setFont(font);

		this.add(titre);
		this.add(pointTab);

	}
	public void enlevebord(int i) {
		pointJoueur[i].setBorder(BorderFactory.createLineBorder(Color.black, 0)); 
		pointJoueur[i].setSize(100, 50);
		

	}
	public void bord(int i) {
		
		
		pointJoueur[i].setBorder(BorderFactory.createLineBorder(Color.white, 5));
		
	}

}
