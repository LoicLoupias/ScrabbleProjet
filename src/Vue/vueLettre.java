package Vue;

import java.awt.BorderLayout;
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
		FlowLayout layoutvueLettre = new FlowLayout();
		this.setLayout(layoutvueLettre);
		layoutvueLettre.setHgap(10);
		this.setBackground(new Color(0,200,0));
		this.lettres = new JButton[7];
		
		for (int i = 0; i<7; i++) {
			this.lettres[i] = new JButton("test");
			this.lettres[i].setPreferredSize(new Dimension(50,50));
			this.lettres[i].setBackground(new Color(245,245,220));
			this.lettres[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.lettres[i].addActionListener(new LettreListener());
			this.lettres[i].setVisible(false);
			this.add(lettres[i]);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void update(Observable o, Object arg) {
	}

	
	public void afficheMain(int numeroJ) {
		
		for (int i = 0; i < this.joueur[numeroJ].lettre.size(); i++) {
			this.lettres[i].setText(Character.toString(this.joueur[numeroJ].lettre.get(i)));
			this.lettres[i].setVisible(true);
		}
		
	}
	
	class LettreListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).getText();
			
			
		}
	}
	
}
