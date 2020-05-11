package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Modele.Joueur;
import Modele.Modele;

public class vueLettre extends JPanel {

	static Joueur[] joueur;
	static JButton[] lettres;
	public static JButton boutonajouer;
	public static String lettreajouer;

	public vueLettre(Modele modele) {

		super();

		joueur = modele.joueurs;
		FlowLayout layoutvueLettre = new FlowLayout();
		this.setLayout(layoutvueLettre);
		layoutvueLettre.setHgap(30);
		layoutvueLettre.setVgap(15);

		this.setBackground(new Color(0, 200, 0));
		TitledBorder bordure = new TitledBorder("VOS LETTRES :   ");
		Font fonttitre = new Font("Arial", Font.BOLD, 15);
		bordure.setTitleFont(fonttitre);
		this.setBorder(bordure);

		String lettreajouer = new String("test");

		this.lettres = new JButton[7];

		for (int i = 0; i < 7; i++) {
			this.lettres[i] = new JButton("test");
			this.lettres[i].setPreferredSize(new Dimension(50, 50));
			this.lettres[i].setBackground(new Color(245, 245, 220));
			this.lettres[i].setBorder(BorderFactory.createRaisedBevelBorder());
			this.lettres[i].addMouseListener(new LettreListener());
			this.lettres[i].setVisible(false);
			this.add(lettres[i]);
		}
	}

	public  void afficheMain(int numeroJ) {

		for (int i = 0; i < this.joueur[numeroJ].lettre.size(); i++) {
			this.lettres[i].setText(Character.toString(joueur[numeroJ].lettre.get(i)));
			this.lettres[i].setFont(new Font("Arial", Font.PLAIN, 36));
			this.lettres[i].setForeground(Color.BLACK);
			this.lettres[i].setVisible(true);
		}
		
		vueJeu.mainbouton.updateUI();
		

	}
	
	

	public String getLettre() {
		return lettreajouer;
	}

	class LettreListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			// on peut utiliser la lettre de la main ssi elle est activé
			boutonajouer = (JButton) e.getSource();
			if (boutonajouer.isEnabled()) {
				lettreajouer = boutonajouer.getText();
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
