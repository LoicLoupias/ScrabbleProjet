package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modele.Joueur;
import Modele.Modele;

public class VueBoutonJeu extends JPanel {
	int nblettrechange;
	ArrayList<Integer> indicelettrechange;
	public JButton action, valider, passer, changer, annuler;
	String mot;

	public VueBoutonJeu(Modele modele) {

		super();
		FlowLayout layoutvueBoutonJeu = new FlowLayout();
		this.setLayout(layoutvueBoutonJeu);
		layoutvueBoutonJeu.setHgap(20);
		layoutvueBoutonJeu.setVgap(15);
		this.setBackground(new Color(0, 200, 0));

		//initialisation des bouttons de jeu 
		valider = new JButton("VALIDER");
		valider.setBackground(new Color(245, 245, 220));
		valider.setPreferredSize(new Dimension(200, 35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		valider.addMouseListener(new LettreListener());
		this.add(valider);

		passer = new JButton("PASSER");
		passer.setBackground(new Color(245, 245, 220));
		passer.setPreferredSize(new Dimension(200, 35));
		passer.setBorder(BorderFactory.createRaisedBevelBorder());
		passer.addMouseListener(new LettreListener());
		this.add(passer);

		changer = new JButton("CHANGER LETTRES");
		changer.setBackground(new Color(245, 245, 220));
		changer.setPreferredSize(new Dimension(200, 35));
		changer.setBorder(BorderFactory.createRaisedBevelBorder());
		changer.addMouseListener(new LettreListener());
		this.add(changer);

		annuler = new JButton("ANNULER");
		annuler.setBackground(new Color(245, 245, 220));
		annuler.setPreferredSize(new Dimension(200, 35));
		annuler.setBorder(BorderFactory.createRaisedBevelBorder());
		annuler.addMouseListener(new LettreListener());
		this.add(annuler);

	}

	class LettreListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			// boutton activer affiche le mot dans l'historique (pour le moment)
			action = (JButton) e.getSource();
			if (action == valider) {
				mot = new String();
				
				/*
				for (String ch : PlateauDeJeu.nouvMot) {
					mot += ch;
				}
				*/
				
				Vue.vueDuJeu.historique.ajoutHistorique(mot);
				Modele.tour = (Modele.tour + 1) % Modele.nbrJoueur;
			}

			else if (action == passer) {

				Modele.tour = (Modele.tour + 1) % Modele.nbrJoueur;
				Vue.vueDuJeu.mainbouton.main.afficheMain(Modele.tour);
				System.out.println(Modele.tour);
				//Modele.tour suit le numéro de joueur comme il faut mais manque à afficher la main du joueur correspondant
			}
			
			else if (action == changer) {
				
				
				nblettrechange = (Integer) JOptionPane.showInputDialog(null, "Nombre de lettres à changer:", "toto", JOptionPane.QUESTION_MESSAGE, null,new Integer[] {0,1,2,3,4,5,6,7}, 0);
				indicelettrechange = new ArrayList<Integer>();
				for (int i=1; i<=nblettrechange; i++) {
					indicelettrechange.add((Integer) JOptionPane.showInputDialog(null, "Indice de lettre à changer :", "toto", JOptionPane.QUESTION_MESSAGE, null,new Integer[] {1,2,3,4,5,6,7}, 1));
				}
				Collections.sort(indicelettrechange);
				//ATTENTION CONVENTION A DEFINIR AVEC THOMAS ET LOIC : SI DEUX FOIS LE MEME INDICE POUR CHANGER DE LETTRE, QUE FAIRE? EX :
				//SI DEMANDE DE CHANGER 3 LETTRES ET INDICES FOURNIT SONT 1,3,3 FAUT IL :
				// 1- CHANGER 1 ET 3 ET C'EST TOUT?
				// PROBLEME DE CETTE SOLUTION : SI LA PERSONNE VOULAIT CHANGER 3 LETTRES ET A MISSCLICK POUR LES INDICES ELLE N'EN CHANGE QUE DEUX
				// 2- RECREER UNE FENETRE POUR REDEMANDER (ET AINSI DE SUITE CREER UNE BOUCLE TANT QUE LA TAILLE DE L'ARRAYLIST DES INDICES
				// N'EST PAS EGALE AU NB DE LETTRES A CHANGER ON DEMANDE
				// PROBLEME DE CETTE SOLUTION : SI LA PERSONNE A MISSCLICK AU DEPART SUR LE NOMBRE DE LETTRES A CHANGER QU'ELLE VOULAIT 2 MAIS A CLICK SUR 3
				// ELLE DOIT OBLIGATOIREMENT EN CHANGER 3
				// SOLUTION ANNEXE ? AJOUT D'UN BOUTON ANNULER POUR FERMER LA FENETRE ? LE BOUTON 'cancel' CREE ERREUR
				//A FAIRE : SI LA PERSONNE SELECTIONNE '0' EN LETTRE A CHANGER -> COPIER/COLLER CODE BOUTON 'passer'
				
			}
			
			else if (action==annuler){
				
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
