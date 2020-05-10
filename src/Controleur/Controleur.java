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

import Modele.Modele;
import Vue.PlateauDeJeu;
import Vue.Vue;
import Vue.vueJeu;

@SuppressWarnings("deprecation")
public class Controleur implements ContainerListener, ActionListener, ItemListener{
	
	public Controleur(Modele modele, vueJeu vueDuJeu, PlateauDeJeu plateau) {
		
		
		
		// pour mettre en place un jeton, on peut créer un objet de type char et en gros dès qu'on clique sur la pioche et que cet objet est vide
		//alors on rajoute ce chart dans l'objet puis tant qu'il est pas vide alors on peut plus en ajouter, puis si le clic est sur un boutton du platteau
		// alors on verifie s'il n'y a pas de lettre dans le boutton du plateau, s'il y en a pas alors on pop le charet on l'ajoute au bouton.
		
		
		
		
		
		//while (modele.etat == modele.etat.EN_COURS) {
			
		//}
		
	}
	
	public static boolean verification(Integer[] coord, boolean deepsearch) {
		
		Integer[] coordVerif = coord.clone();; 
		ArrayList<String> motjoueVerif = new ArrayList<String>();
		motjoueVerif = (ArrayList<String>) PlateauDeJeu.motjoue.clone();
		
		String mot = new String();
		boolean correct = Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {7, 7});

		System.out.println(correct);
		
		boolean extremiteMot = false;
		
		if (coordVerif[2] == -1) {coordVerif[2] = 0;}
		
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
		
		
		if (!deepsearch) { // On ne parcourt pas tous les mots accolés si ce n'est pas le mot initial
			if (coordVerif[2] == 0) {
				while (coordVerif[1] <= 14 && !extremiteMot) {
					if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
						mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
						coordVerif[1] += 1;
					}
					else {extremiteMot = true;}
				}
				extremiteMot = false;
			}
			else {
				while (coordVerif[0] <= 14  && !extremiteMot) {
					if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
						coordVerif[0] += 1;
						mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
					}
					else {extremiteMot = true;}
				}
				extremiteMot = false;
			}
			System.out.println("deepseach");
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
							correct = Controleur.verification(new Integer[]{coordVerif[0]-1, coordVerif[1], 0}, false);
						}
					}
					if (coordVerif[0]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1) {
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1], 0}, false);
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
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1]-1, 1}, false);
						}
					}
					if (coordVerif[1]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]+1].getText().length() == 1) {
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1], 1}, false);
						}
					}
					coordVerif[0] += 1;
				}
				else {extremiteMot = true;}		
			}
			extremiteMot = false;
		}
				
				// *** Fin de verfication des mots à coté
				
		if (!Modele.DICTIONNAIRE.containsKey(mot) || !motjoueVerif.isEmpty()) {correct = false;}
		
		return correct;
		
	}
	
	public static Integer compterPoint(Integer[] coord, boolean deepsearch) {
		
		Integer[] coordVerif = coord.clone();
		int point = 0;
		int coef = 1;
		int mot = 0;
		boolean extremiteMot = false;
		
		if (PlateauDeJeu.motjoue.size() == 7 && point == 0) {point += 50;} // SCRABBLE!
		
		System.out.println(point);
		
		if (coordVerif[2] == 0 || coordVerif[2] == -1) {
			while (coordVerif[1]-1 >= 0 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {coordVerif[1] -= 1;} // Obtention de la position de départ
				else {extremiteMot = true;}
			}
			extremiteMot = false;
			
			while (coordVerif[1] <= 14 && !extremiteMot) {
				System.out.println("cas 1");
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
					if (Controleur.estDansLeTab(Vue.MD, coordVerif)) {
						coef += 1;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
					}
					else if (Controleur.estDansLeTab(Vue.MT, coordVerif)) {
						coef += 2;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
					}
					else if (Controleur.estDansLeTab(Vue.LD, coordVerif)) {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*2;}
					else if (Controleur.estDansLeTab(Vue.LT, coordVerif)) {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*3;}
					else {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];}
					
					if (coordVerif[0]-1 >= 0) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]}) 
								&& deepsearch) {
							point += Controleur.compterPoint(new Integer[]{coordVerif[0]-1, coordVerif[1], 1}, false);
						}
					}
					else if (coordVerif[0]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]})
								&& deepsearch) {
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

			while (coordVerif[0]-1 >= 0 && !extremiteMot) {
				if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {coordVerif[0] -= 1;} // Obtention de la position de départ
				else {extremiteMot = true;}
			}
			extremiteMot = false;
			
			while (coordVerif[0] <= 14 && !extremiteMot) {
				System.out.println("cas 2");
				if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
					
					if (Controleur.estDansLeTab(Vue.MD, coordVerif)) {
						coef += 1;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
					}
					else if (Controleur.estDansLeTab(Vue.MT, coordVerif)) {
						coef += 2;
						mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];
					}
					else if (Controleur.estDansLeTab(Vue.LD, coordVerif)) {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*2;}
					else if (Controleur.estDansLeTab(Vue.LT, coordVerif)) {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0]*3;}
					else {mot += Modele.LETTRES.get(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().charAt(0))[0];}
					
					if (coordVerif[1]-1 >= 0) {
						if (PlateauDeJeu.boutonTab[coordVerif[1]-1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]})
								&& deepsearch) {
							point += Controleur.compterPoint(new Integer[]{coordVerif[1]-1, coordVerif[1], 1}, false);
						}
					}
					if (coordVerif[1]+1 <= 14) {
						if (PlateauDeJeu.boutonTab[coordVerif[1]+1][coordVerif[1]].getText().length() == 1 
								&& Controleur.estDansLeTab(PlateauDeJeu.coordPourAnnuler, new Integer[] {coordVerif[0], coordVerif[1]})
								&& deepsearch) {
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