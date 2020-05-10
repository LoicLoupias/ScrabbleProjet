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


import Modele.*;

public class VueBoutonJeu extends JPanel {
	int nblettrechange;
	int indiceachanger;
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

		// initialisation des boutons de jeu
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
				 * for (String ch : PlateauDeJeu.nouvMot) { mot += ch; }
				 */

				Vue.vueDuJeu.historique.ajoutHistorique("Joueur "+Modele.tour+" a joué le mot : "+mot+" ! Ce mot lui rapporte "+ /*indiquer nb points*/ " points !");
				Modele.tour = (Modele.tour + 1) % Modele.nbrJoueur;
				Vue.vueDuJeu.historique.ajoutHistorique("C'est à joueur "+Modele.tour+" de jouer !");
			}

			else if (action == passer) {
				
				Vue.vueDuJeu.historique.ajoutHistorique("Le joueur "+Modele.tour+" décide de passer son tour !");
				Modele.tour = (Modele.tour + 1) % Modele.nbrJoueur;
				Vue.vueDuJeu.mainbouton.main.afficheMain(Modele.tour);
				Vue.vueDuJeu.historique.ajoutHistorique("C'est à joueur "+Modele.tour+" de jouer !");
				System.out.println(Modele.tour);
				// Modele.tour suit le numéro de joueur comme il faut mais manque à afficher la
				// main du joueur correspondant
			}

			else if (action == changer) {
				
				indicelettrechange = new ArrayList<Integer>();
				nblettrechange = -1;
				
				while (indicelettrechange.size() != nblettrechange) { //tant que la liste des indices de lettres à changer n'est pas égale au nombre de lettres qu'on souhaite changer, on tourne
					
					indiceachanger = -1;//On réinitialise indiceachanger pour les doublons
					indicelettrechange.clear(); //on réinitialise la liste des indices des lettres à changer
					
					//On demande le nombre de lettres que le joueur souhaite changer
					nblettrechange = (Integer) JOptionPane.showInputDialog(null, "Nombre de lettres à changer:",
							"Scrabble", JOptionPane.QUESTION_MESSAGE, null, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 },
							0);
					
					//Si le joueur entre 0 lettres à changer, soit c'est une erreur missclick, soit il veut simplement passer son tour
					if (nblettrechange == 0) {
						int retour = JOptionPane.showConfirmDialog(null,
								"Vous avez indiqué vouloir changer aucune lettre, voulez-vous passer votre tour ?",
								"Scrabble", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if (retour==0) { //Cas ou le joueur demande à passer son tour
							// ATTENTION
							// A FAIRE
							//PASSER LE TOUR
							//ATTENTION
							
							// ATTENTION
							// A FAIRE
							//PASSER LE TOUR
							//ATTENTION
						
						} else {//Cas où le joueur s'est trompé en entrant le nombre de lettres à changer
							JOptionPane.showMessageDialog(null,
									"Veuillez saisir le nombre de lettres que vous souhaitez changer dans la fenêtre suivante",
									"Scrabble", JOptionPane.INFORMATION_MESSAGE);
							indicelettrechange.add(0);//on ajoute un élément pour que la taille de la liste soit différente de nblettrechange deja égal à zéro
							//pour retourner dans le while. Ajouter cet élément n'est pas gênant car la liste est réinitialisée de toute manière
						}
					} else {//Cas où le joueur souhaite changer des lettres
						
						//Boucle pour connaître les indices des lettres à changer
						for (int i = 1; i <= nblettrechange; i++) {
							indicelettrechange.add((Integer) JOptionPane.showInputDialog(null,
									"Indice de lettre à changer :", "Scrabble", JOptionPane.QUESTION_MESSAGE, null,
									new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, 1));
						}
						
						Collections.sort(indicelettrechange);//On trie l'arraylist de manière croissante
						
						//Double boucle qui parcourt l'arraylist des indices à la recherche de doublons. Si un ou plusieurs doublons sont détectés
						//la saisie des indices n'est pas valide, indiceachanger prend la valeur de l'indice d'un des doublons
						for (int i = 0; i < nblettrechange; i++) {
							for (int j = 0; j < nblettrechange; j++) {
								if (indicelettrechange.get(i) == indicelettrechange.get(j) && i != j) {
									indiceachanger = j;
								}
							}
						}
						
						//Si indiceachanger a une valeur différente que celle du début de boucle, alors un doublons a été détecté au-dessus donc on supprime
						//l'élément de l'arraylist pour qu'elle n'ait plus la bonne taille et qu'on retourne dans le while
						if (indiceachanger != -1) {
							indicelettrechange.remove(indiceachanger);
						}
						
						//Ce if a la même condition que le while. Si cette condition est vérifiée, le message en-dessous s'affiche et on retourne dans le while
						if (indicelettrechange.size() != nblettrechange) {
							JOptionPane.showMessageDialog(null,
									"Vous avez renseigné plusieurs fois le même indice de lettre, veuillez réessayer",
									"Scrabble", JOptionPane.WARNING_MESSAGE);
						
						} else {//Sinon, la saisie est correcte, les lettres sont changées
							JOptionPane.showMessageDialog(null, "Changement des lettres", "Scrabble",
									JOptionPane.INFORMATION_MESSAGE);
							for(int i=0;i<indicelettrechange.size();i++) {
								char temporaire = Modele.joueurs[Modele.tour].lettre.get(indicelettrechange.get(i)-1);
								//System.out.println(Modele.joueurs[Modele.tour].lettre);
								//System.out.println("Lettre a changer :" +temporaire);
								//System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								Modele.joueurs[Modele.tour].lettre.set((indicelettrechange.get(i)-1), Pioche.lettrePioche.remove(0));
								//System.out.println(Modele.joueurs[i].lettre);
								//System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								Pioche.lettrePioche.add(temporaire);
								//System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								Collections.shuffle(Pioche.lettrePioche);
								//System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								
								
								//ATTENTION
								//MANQUE A ACTUALISER LA FENETRE
							}
							Vue.vueDuJeu.historique.ajoutHistorique("Le joueur "+Modele.tour+" a décidé de changer ses lettres !");
							Modele.tour = (Modele.tour + 1) % Modele.nbrJoueur;
							Vue.vueDuJeu.historique.ajoutHistorique("C'est à joueur "+Modele.tour+" de jouer !");
						}
					}
				}
			}

			else if (action == annuler) {

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
