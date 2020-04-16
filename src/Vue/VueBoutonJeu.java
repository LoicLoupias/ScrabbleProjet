package Vue;

import java.awt.Color;
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
		layoutvueBoutonJeu.setHgap(10);
		this.setBackground(new Color(0,200,0));
		
		JButton valider = new JButton("VALIDER");
		valider.setBackground(new Color(245,245,220));
		this.add(valider);
		JButton passer = new JButton("PASSER");
		passer.setBackground(new Color(245,245,220));
		this.add(passer);
		JButton changer = new JButton("CHANGER LETTRES");
		changer.setBackground(new Color(245,245,220));
		this.add(changer);
		
	}

}
