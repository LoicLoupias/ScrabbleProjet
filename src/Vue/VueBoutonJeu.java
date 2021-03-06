package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.Iterator;

import Controleur.Controleur;
import Modele.*;
import Modele.Modele.Etat;

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
		valider.setPreferredSize(new Dimension(150, 35));
		valider.setBorder(BorderFactory.createRaisedBevelBorder());
		valider.addMouseListener(new LettreListener());
		this.add(valider);

		passer = new JButton("PASSER");
		passer.setBackground(new Color(245, 245, 220));
		passer.setPreferredSize(new Dimension(150, 35));
		passer.setBorder(BorderFactory.createRaisedBevelBorder());
		passer.addMouseListener(new LettreListener());
		this.add(passer);

		changer = new JButton("CHANGER LETTRES");
		changer.setBackground(new Color(245, 245, 220));
		changer.setPreferredSize(new Dimension(150, 35));
		changer.setBorder(BorderFactory.createRaisedBevelBorder());
		changer.addMouseListener(new LettreListener());
		this.add(changer);

		annuler = new JButton("ANNULER");
		annuler.setBackground(new Color(245, 245, 220));
		annuler.setPreferredSize(new Dimension(150, 35));
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
				if (Controleur.verification(PlateauDeJeu.coord, true)) {
					int p = Controleur.compterPoint(PlateauDeJeu.coord, true);
					Modele.joueurs[Modele.tour].point += p;
					Vue.vueDuJeu.historique.ajoutHistorique(
							"Joueur " + Modele.tour + " a jou� le mot : " + Modele.joueurs[Modele.tour].mot
									+ " ! Ce mot lui rapporte " + p + " points !");
					System.out.println(
							Modele.joueurs[Modele.tour].nom + "nb de points : " + Modele.joueurs[Modele.tour].point);
					Vue.vueDuJeu.points.actualiserpoints();

					if (Pioche.lettrePioche.size() > 0) {
						Modele.joueurs[Modele.tour].piocher();
					}

					else if (Modele.joueurs[Modele.tour].lettre.size() == 0) {
						Modele.etat = Etat.FINI;
					}

					Integer[] c = new Integer[2];

					while (PlateauDeJeu.coordPourAnnuler.size() > 0) {
						c = PlateauDeJeu.coordPourAnnuler.remove(0);
						System.out.println(c[0] + "" + c[1]);
						Modele.joueurs[Modele.tour].lettre
								.remove((Character) PlateauDeJeu.boutonTab[c[0]][c[1]].getText().charAt(0));
					}

					PlateauDeJeu.coord = new Integer[] { -1, -1, -1 };
					PlateauDeJeu.motjoue = new ArrayList<String>();

					Controleur.passer();
					Vue.vueDuJeu.historique.ajoutHistorique("C'est � joueur " + Modele.tour + " de jouer !");

				} else {
					Vue.vueDuJeu.historique.ajoutHistorique("Mot invalide !");
					action = annuler;
				}

			}

			if (action == passer) {

				Vue.vueDuJeu.historique.ajoutHistorique("Le joueur " + Modele.tour + " d�cide de passer son tour !");
				Controleur.passer();
				Vue.vueDuJeu.historique.ajoutHistorique("C'est � joueur " + Modele.tour + " de jouer !");
				// System.out.println(Modele.tour);
				// Modele.tour suit le num�ro de joueur comme il faut mais manque � afficher la
				// main du joueur correspondant
			}

			else if (action == changer) {

				indicelettrechange = new ArrayList<Integer>();
				nblettrechange = -1;

				while (indicelettrechange.size() != nblettrechange) { // tant que la liste des indices de lettres �
																		// changer n'est pas �gale au nombre de lettres
																		// qu'on souhaite changer, on tourne

					indiceachanger = -1;// On r�initialise indiceachanger pour les doublons
					indicelettrechange.clear(); // on r�initialise la liste des indices des lettres � changer

					// On demande le nombre de lettres que le joueur souhaite changer
					nblettrechange = (Integer) JOptionPane.showInputDialog(null, "Nombre de lettres � changer:",
							"Scrabble", JOptionPane.QUESTION_MESSAGE, null, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 },
							0);

					// Si le joueur entre 0 lettres � changer, soit c'est une erreur missclick, soit
					// il veut simplement passer son tour
					if (nblettrechange == 0) {
						int retour = JOptionPane.showConfirmDialog(null,
								"Vous avez indiqu� vouloir changer aucune lettre, voulez-vous passer votre tour ?",
								"Scrabble", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (retour == 0) { // Cas ou le joueur demande � passer son tour
							// ATTENTION
							// A FAIRE
							// PASSER LE TOUR
							// ATTENTION

							// ATTENTION
							// A FAIRE
							// PASSER LE TOUR
							// ATTENTION

						} else {// Cas o� le joueur s'est tromp� en entrant le nombre de lettres � changer
							JOptionPane.showMessageDialog(null,
									"Veuillez saisir le nombre de lettres que vous souhaitez changer dans la fen�tre suivante",
									"Scrabble", JOptionPane.INFORMATION_MESSAGE);
							indicelettrechange.add(0);// on ajoute un �l�ment pour que la taille de la liste soit
														// diff�rente de nblettrechange deja �gal � z�ro
							// pour retourner dans le while. Ajouter cet �l�ment n'est pas g�nant car la
							// liste est r�initialis�e de toute mani�re
						}
					} else {// Cas o� le joueur souhaite changer des lettres

						// Boucle pour conna�tre les indices des lettres � changer
						for (int i = 1; i <= nblettrechange; i++) {
							indicelettrechange.add((Integer) JOptionPane.showInputDialog(null,
									"Indice de lettre � changer :", "Scrabble", JOptionPane.QUESTION_MESSAGE, null,
									new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, 1));
						}

						Collections.sort(indicelettrechange);// On trie l'arraylist de mani�re croissante

						// Double boucle qui parcourt l'arraylist des indices � la recherche de
						// doublons. Si un ou plusieurs doublons sont d�tect�s
						// la saisie des indices n'est pas valide, indiceachanger prend la valeur de
						// l'indice d'un des doublons
						for (int i = 0; i < nblettrechange; i++) {
							for (int j = 0; j < nblettrechange; j++) {
								if (indicelettrechange.get(i) == indicelettrechange.get(j) && i != j) {
									indiceachanger = j;
								}
							}
						}

						// Si indiceachanger a une valeur diff�rente que celle du d�but de boucle, alors
						// un doublons a �t� d�tect� au-dessus donc on supprime
						// l'�l�ment de l'arraylist pour qu'elle n'ait plus la bonne taille et qu'on
						// retourne dans le while
						if (indiceachanger != -1) {
							indicelettrechange.remove(indiceachanger);
						}

						// Ce if a la m�me condition que le while. Si cette condition est v�rifi�e, le
						// message en-dessous s'affiche et on retourne dans le while
						if (indicelettrechange.size() != nblettrechange) {
							JOptionPane.showMessageDialog(null,
									"Vous avez renseign� plusieurs fois le m�me indice de lettre, veuillez r�essayer",
									"Scrabble", JOptionPane.WARNING_MESSAGE);

						} else {// Sinon, la saisie est correcte, les lettres sont chang�es
							JOptionPane.showMessageDialog(null, "Changement des lettres", "Scrabble",
									JOptionPane.INFORMATION_MESSAGE);

							for (int i = 0; i < indicelettrechange.size(); i++) {
								char temporaire = Modele.joueurs[Modele.tour].lettre.get(indicelettrechange.get(i) - 1);
								// System.out.println(Modele.joueurs[Modele.tour].lettre);
								// System.out.println("Lettre a changer :" +temporaire);
								// System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								Modele.joueurs[Modele.tour].lettre.set((indicelettrechange.get(i) - 1),
										Pioche.lettrePioche.remove(0));
								// System.out.println(Modele.joueurs[i].lettre);
								// System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								Pioche.lettrePioche.add(temporaire);
								// System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
								Collections.shuffle(Pioche.lettrePioche);
								// System.out.println("Etat de la pioche :" +Pioche.lettrePioche);
							}

							Vue.vueDuJeu.historique
									.ajoutHistorique("Le joueur " + Modele.tour + " a d�cid� de changer ses lettres !");
							Controleur.passer();
							Vue.vueDuJeu.historique.ajoutHistorique("C'est � joueur " + Modele.tour + " de jouer !");
						}
					}
				}

			}

			else if (action == annuler) {
				Integer[] c = new Integer[2];
				for (int i = 0; i < PlateauDeJeu.coordPourAnnuler.size(); i++) {
					c[0] = PlateauDeJeu.coordPourAnnuler.get(i)[0];
					c[1] = PlateauDeJeu.coordPourAnnuler.get(i)[1];
					PlateauDeJeu.boutonTab[c[0]][c[1]].setFont(new Font("Bold", Font.BOLD, 12));
					if (Controleur.estDansLeTab(Vue.MD, c)) {
						PlateauDeJeu.boutonTab[c[0]][c[1]].setText("MD");
						PlateauDeJeu.boutonTab[c[0]][c[1]].setBackground(Color.PINK);
					} else if (Controleur.estDansLeTab(Vue.LD, c)) {
						PlateauDeJeu.boutonTab[c[0]][c[1]].setText("LD");
						PlateauDeJeu.boutonTab[c[0]][c[1]].setBackground(Color.CYAN);
					} else if (Controleur.estDansLeTab(Vue.MT, c)) {
						PlateauDeJeu.boutonTab[c[0]][c[1]].setText("MT");
						PlateauDeJeu.boutonTab[c[0]][c[1]].setBackground(Color.RED);
						PlateauDeJeu.boutonTab[c[0]][c[1]].setForeground(Color.WHITE);
					} else if (Controleur.estDansLeTab(Vue.LT, c)) {
						PlateauDeJeu.boutonTab[c[0]][c[1]].setText("LT");
						PlateauDeJeu.boutonTab[c[0]][c[1]].setBackground(Color.BLUE);
						PlateauDeJeu.boutonTab[c[0]][c[1]].setForeground(Color.WHITE);
					} else {
						PlateauDeJeu.boutonTab[c[0]][c[1]].setText(null);
						PlateauDeJeu.boutonTab[c[0]][c[1]].setBackground(new Color(0, 200, 0));
					}
				}
				PlateauDeJeu.coord = new Integer[] { -1, -1, -1 };
				PlateauDeJeu.coordPourAnnuler = new ArrayList<Integer[]>();
				PlateauDeJeu.motjoue = new ArrayList<String>();

				Vue.vueDuJeu.mainbouton.main.afficheMain(Modele.tour);

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
