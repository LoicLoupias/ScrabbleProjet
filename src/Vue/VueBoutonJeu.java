package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Modele;
import Modele.Pioche;
public class VueBoutonJeu extends JPanel implements MouseListener {
	public JButton action;
	public JButton valider;
	public JButton passer;
	public JButton changer;
	public JButton annuler;
	
	public VueBoutonJeu(Modele modele) {
		
		super();
		FlowLayout layoutvueBoutonJeu = new FlowLayout();
		this.setLayout(layoutvueBoutonJeu);
		layoutvueBoutonJeu.setHgap(20);
		layoutvueBoutonJeu.setVgap(15);
		this.setBackground(new Color(0,200,0));
		
		valider = new JButton("VALIDER");
		valider.setBackground(new Color(245,245,220));
		valider.setPreferredSize(new Dimension(200,35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(valider);
		
		passer = new JButton("PASSER");
		passer.setBackground(new Color(245,245,220));
		passer.setPreferredSize(new Dimension(200,35));
		passer.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(passer);
		
		changer = new JButton("CHANGER LETTRES");
		changer.setBackground(new Color(245,245,220));
		changer.setPreferredSize(new Dimension(200,35));
		changer.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(changer);
		
		annuler = new JButton("ANNULER");
		annuler.setBackground(new Color(245,245,220));
		annuler.setPreferredSize(new Dimension(200,35));
		annuler.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(annuler);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		action = (JButton) e.getSource();
		if (action == valider) {
			StringBuilder mot = new StringBuilder(); 
			for (String ch : PlateauDeJeu.nouvMot) { 
	            mot.append(ch); 
	        }
			System.out.println(mot);
			
			
			
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
