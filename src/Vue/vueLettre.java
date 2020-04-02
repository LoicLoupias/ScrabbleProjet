package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Joueur;

public class vueLettre extends JPanel{
	
	Joueur joueur;
	JButton[] lettres;
	
	public vueLettre(Joueur jou) {
	
		super();
		
		joueur = jou;
		
		this.setLayout(new FlowLayout());
		
		lettres = new JButton[7];
		
		for (int i = 0; i<7; i++) {
			lettres[i] = new JButton();
			lettres[i].setPreferredSize(new Dimension(50,50));
			lettres[i].setBackground(new Color(0,200,0));
			lettres[i].setText(Character.toString(joueur.lettre.get(i)));
			lettres[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.add(lettres[i]);
		}
	}


	public void changeMain(int nbr) {
		
		for (int i = 0; i<7; i++) {
			lettres[i].setText(Character.toString(joueur.lettre.get(i)));
		}
		
	}

}
