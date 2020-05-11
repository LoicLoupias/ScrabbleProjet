package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Modele.*;
import Vue.*;

@SuppressWarnings("deprecation")
public class Controleur implements ContainerListener, ActionListener, ItemListener {

	public Controleur(Modele modele, vueJeu vueDuJeu, PlateauDeJeu plateau) {

		// while (modele.etat == modele.etat.EN_COURS) {

		// }

	}

public static boolean verification(Integer[] coord, boolean m_i) {
		
		Integer[] coordVerif = coord.clone();
		ArrayList<String> motjoueVerif = new ArrayList<String>();
		motjoueVerif = (ArrayList<String>) PlateauDeJeu.motjoue.clone();
		
		String mot = new String();
		boolean correct = Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {7, 7});
		
		boolean extremiteMot = false;
		boolean mot_initial = m_i;
		
		if (coordVerif[2] == -1) {
			if (coordVerif[0]-1 >= 0) {if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {System.out.println("t1");coordVerif[2] = 0;} }
			else if (coordVerif[0]+1 <= 14) {if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1) {System.out.println("t2");coordVerif[2] = 0;} }
			else if (coordVerif[1]-1 >= 0) {if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {System.out.println("t3");coordVerif[2] = 1;}}
			else if (coordVerif[1]+1 <= 14) {if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1) {System.out.println("t3");coordVerif[2] = 1;}}
			else {coordVerif[2] = 0;System.out.println();}
		}
		System.out.println("axe fixe " + coordVerif[2]);
		if (coordVerif[2] == 0) {
			while (coordVerif[1]-1 >= 0 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {coordVerif[1] -= 1;} // Obtention de la position de départ
				else {extremiteMot = true;}
			}
			extremiteMot = false;
			
		}
		else {
			while (coordVerif[0]-1 >= 0 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1 && !extremiteMot) {coordVerif[0] -= 1;} // Obtention de la position de départ
				else {extremiteMot = true;}
			}
			extremiteMot = false;
		}
		
		System.out.println(coord[0]+""+coord[1]);
		if (!mot_initial) { // On ne parcourt pas tous les mots accolés si ce n'est pas le mot initial
			if (coordVerif[2] == 0) {
				while (coordVerif[1] <= 14 && !extremiteMot) {
					if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) { // Tant que lettre posé
						if (!motjoueVerif.isEmpty()) {motjoueVerif.remove(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase());}
						mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
						coordVerif[1] += 1;
					}
					else {extremiteMot = true;}	
				}
				extremiteMot = false;
			}
			else {
				while (coordVerif[0] <= 14 && !extremiteMot) {
					if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) { // Tant que lettre posé
						if (!motjoueVerif.isEmpty()) {motjoueVerif.remove(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase());}
						mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
						coordVerif[0] += 1;
					}
					else {extremiteMot = true;}	
				}
				extremiteMot = false;
			}
			System.out.println("mot externe: " + mot);
			return Modele.DICTIONNAIRE.containsKey(mot);
		}
		
		else if (coordVerif[2] == 0) { // Cas du mot initial
			
			
			while (coordVerif[1] <= 14 && !extremiteMot) {
				
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) { // Tant que lettre posé
					if (!motjoueVerif.isEmpty()) {motjoueVerif.remove(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase());}
					mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
					
					// *** Verfication des mots à côtés ***
					if (coordVerif[0]-1 >= 0) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {
							System.out.println(coordVerif[0] +" "+coordVerif[1]);
							System.out.println("d1");
							System.out.println(PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText());
							correct = Controleur.verification(new Integer[]{coordVerif[0]-1, coordVerif[1], 1}, false);
						}
					}
					if (coordVerif[0]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1) {
							System.out.println("d2");
							System.out.println(PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText());
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1], 1}, false);
						}
					}
					coordVerif[1] += 1;
				}
				else {extremiteMot = true;}	
			}
			extremiteMot = false;
		}
				  
		else {
			
			while (coordVerif[0] <= 14 && !extremiteMot) {
				
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) { // Tant que lettre posé
					if (!motjoueVerif.isEmpty()) {motjoueVerif.remove(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase());}
					mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
					
					// *** Verfication des mots à côtés *
					if (coordVerif[1]-1 >= 0) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1]-1, 0}, false);
						}
					}
					if (coordVerif[1]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]+1].getText().length() == 1) {
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1], 0}, false);
						}
					}
					coordVerif[0] += 1;
				}
				else {extremiteMot = true;}		
			}
			extremiteMot = false;
		}
				
				// *** Fin de verfication des mots à coté
		extremiteMot = false;	
		if (!Modele.DICTIONNAIRE.containsKey(mot) || !motjoueVerif.isEmpty()) {return false;}
		else {if (mot_initial) {Modele.joueurs[Modele.tour].mot = mot;}}
		return correct;
		
	}
	
	public static Integer compterPoint(Integer[] coord, boolean mot_initial) {
		
		Integer[] coordVerif = coord.clone();
		int point = 0;
		int coef = 1;
		int mot = 0;
		boolean extremiteMot = false;
		
		if (PlateauDeJeu.motjoue.size() == 7 && point == 0) {point += 50;} // SCRABBLE!
		
		if (coordVerif[2] == 0 || coordVerif[2] == -1) {
			while (coordVerif[1]-1 >= 0 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {coordVerif[1] -= 1;} // Obtention de la position de départ
				else {extremiteMot = true;}
			}
			extremiteMot = false;
			
			while (coordVerif[1] <= 14 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
					if (Controleur.estDansLeTab(Vue.MD, coordVerif)) {
						coef += 1;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
						Controleur.retirerDuTab(Vue.MD, coordVerif);
					} 
					else if (Controleur.estDansLeTab(Vue.MT, coordVerif)) {
						coef += 2;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
						Controleur.retirerDuTab(Vue.MT, coordVerif);
					}
					else if (Controleur.estDansLeTab(Vue.LD, coordVerif)) {
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*2;
						Controleur.retirerDuTab(Vue.LD, coordVerif);
					}
					else if (Controleur.estDansLeTab(Vue.LT, coordVerif)) {
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*3;
						Controleur.retirerDuTab(Vue.LT, coordVerif);
					}
					else {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];}
					
					if (coordVerif[0]-1 >= 0) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]}) 
								&& mot_initial) {
							point += Controleur.compterPoint(new Integer[]{coordVerif[0]-1, coordVerif[1], 1}, false);
						}
					}
					else if (coordVerif[0]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]})
								&& mot_initial) {
							point += Controleur.compterPoint(new Integer[]{coordVerif[0], coordVerif[1], 1}, false);
						}
					}
					coordVerif[1] += 1;
				}
				else {extremiteMot = true;}
			}
			extremiteMot = false;
			
		}
		
		else {
			while (coordVerif[0]-1 >= 0 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1 && !extremiteMot) {coordVerif[0] -= 1;} // Obtention de la position de départ
				else {extremiteMot = true;}
			}
			extremiteMot = false;


			
			while (coordVerif[0] <= 14 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
					
					if (Controleur.estDansLeTab(Vue.MD, coordVerif)) {
						coef += 1;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
						Controleur.retirerDuTab(Vue.MD, coordVerif);
					}
					else if (Controleur.estDansLeTab(Vue.MT, coordVerif)) {
						coef += 2;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
						Controleur.retirerDuTab(Vue.MT, coordVerif);
					}
					else if (Controleur.estDansLeTab(Vue.LD, coordVerif)) {
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*2;
						Controleur.retirerDuTab(Vue.LD, coordVerif);
					}
					else if (Controleur.estDansLeTab(Vue.LT, coordVerif)) {
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*3;
						Controleur.retirerDuTab(Vue.LT, coordVerif);
					}
					else {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];}
					
					if (coordVerif[1]-1 >= 0) {
						if (PlateauDeJeu.boutonTab[coordVerif[1]-1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]})
								&& mot_initial) {
							point += Controleur.compterPoint(new Integer[]{coordVerif[1]-1, coordVerif[1], 1}, false);
						}
					}
					else if (coordVerif[1]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[1]+1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]})
								&& mot_initial) {
							point += Controleur.compterPoint(new Integer[]{coordVerif[0], coordVerif[1], 1}, false);
						}
					}
					
					coordVerif[0] += 1;
				}
				else {extremiteMot = true;}
			}
		}
		
		point += mot*coef;
		
		return point; 
	}
	
	public static boolean estDansLeTab (int[][] matrix, Integer[] tab) {
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == tab[0] && matrix[i][1] == tab[1]) {return true;}
		}
		return false;
	}
	
	public static boolean estDansLeTab (ArrayList<Integer[]> matrix, Integer[] tab) {
	
		Iterator<Integer[]> itr = matrix.iterator();
		Integer[] test;
		while (itr.hasNext()) {
			test = itr.next();
			if (test[0] == tab[0] && test[1] == tab[1]) {return true;}
		}
		return false;
		
	}
	
	public static void retirerDuTab (int[][] matrix, Integer[] tab) {
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == tab[0] && matrix[i][1] == tab[1]) {matrix[i] = new int[] {-1,-1};}
		}
	}
	

	public static void passer() {
		Vue.vueDuJeu.points.enlevebord(Modele.tour);
	
		Modele.tour = (Modele.tour + 1) % Modele.nbrJoueur;
		Vue.vueDuJeu.mainbouton.main.afficheMain(Modele.tour);
		Vue.vueDuJeu.points.bord(Modele.tour);	

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub

	}

}