package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Joueur;
import Modele.Modele;

public class vueLettre extends JPanel{
	
	Joueur[] joueur;
	JButton[] lettres;
	
	public vueLettre(Modele modele) {
	
		super();
		
		joueur = modele.joueurs;
		
		this.setLayout(new FlowLayout());
		
		this.lettres = new JButton[7];
		
		for (int i = 0; i<7; i++) {
			this.lettres[i] = new JButton();
			this.lettres[i].setPreferredSize(new Dimension(50,50));
			this.lettres[i].setBackground(new Color(245,245,220));
			this.lettres[i].setText(Character.toString(this.joueur.lettre.get(i)));
			this.lettres[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.lettres[i].addActionListener(new LettreListener());
			this.add(lettres[i]);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void update(Observable o, Object arg) {
	}

	
	public void changeMain(int nbr) {
		
		for (int i = 0; i<7; i++) {
			this.lettres[i].setText(Character.toString(this.joueur.lettre.get(i)));
		}
		
	}
	
	class LettreListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).getText();
			
			
		}
	}
	
}
