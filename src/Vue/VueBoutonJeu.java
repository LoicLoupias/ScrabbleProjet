package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Modele;

public class VueBoutonJeu extends JPanel {
	
	public VueBoutonJeu(Modele modele) {
		
		super();
		FlowLayout layoutvueBoutonJeu = new FlowLayout();
		this.setLayout(layoutvueBoutonJeu);
		layoutvueBoutonJeu.setHgap(20);
		layoutvueBoutonJeu.setVgap(15);
		this.setBackground(new Color(0,200,0));
		
		JButton valider = new JButton("VALIDER");
		valider.setBackground(new Color(245,245,220));
		valider.setPreferredSize(new Dimension(200,35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(valider);
		JButton passer = new JButton("PASSER");
		passer.setBackground(new Color(245,245,220));
		passer.setPreferredSize(new Dimension(200,35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(passer);
		JButton changer = new JButton("CHANGER LETTRES");
		changer.setBackground(new Color(245,245,220));
		changer.setPreferredSize(new Dimension(200,35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(changer);
		JButton annuler = new JButton("ANNULER");
		changer.setBackground(new Color(245,245,220));
		changer.setPreferredSize(new Dimension(200,35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(annuler);
		
	}

}
