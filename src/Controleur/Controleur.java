package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		Integer[] coordVerif = coord.clone(); 
		ArrayList<String> motjoueVerif = new ArrayList<String>();
		motjoueVerif = (ArrayList<String>) PlateauDeJeu.motjoue.clone();
		
		if (coordVerif[2] == -1) {coordVerif[2] = 0;}
		
		String mot = new String();
		
		boolean correct = true;
		
		if (coordVerif[2] == 0) {
			try {
				while (coordVerif[1] > 0 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {coordVerif[1] -= 1;} // Obtention de la position de départ
			} catch (Exception e) {System.out.println("Position de départ WEST");}
		}
		else {
			try {
				while (coordVerif[0] > 0 && PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {coordVerif[0] -= 1;} // Obtention de la position de départ
			} catch (Exception e) {System.out.println("Position de départ EAST");};
		}
	
		if (!deepsearch) { // On ne parcourt pas tous les mots accolés si ce n'est pas le mot initial
			if (coordVerif[2] == 0) {
				while (coordVerif[1] < 15 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
					
					mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
					coordVerif[1] += 1;
				}
			}
			else {
				while (coordVerif[0] < 15 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) {
					coordVerif[0] += 1;
					mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
				}
			}
			System.out.println("deepseach");
			return Modele.DICTIONNAIRE.containsKey(mot);
		}
		
		else if (coordVerif[2] == 1) { // Cas du mot initial
			
			
			while (coordVerif[1] < 15 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1 && correct) { // Tant que lettre posé
				
				if (!motjoueVerif.isEmpty()) {motjoueVerif.remove(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase());}
				mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
				
				// *** Verfication des mots à côtés ***
				try {
					if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {
						System.out.println("1");
						correct = Controleur.verification(new Integer[]{coordVerif[0]-1, coordVerif[1], 1}, false);
					}
				} catch (Exception e) {System.out.println("Bord du plateau SUD");}
				try {
					if (PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1) {
						System.out.println(PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText());
						correct = Controleur.verification(new Integer[]{coordVerif[0]+1, coordVerif[1], 1}, false);
					}
				} catch (Exception e) {System.out.println("Bord du plateau NORD");}
				coordVerif[1] += 1;
			}
		}
				
		else {
			
			while (coordVerif[0] < 15 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1 && correct) { // Tant que lettre posé
				
				if (!motjoueVerif.isEmpty()) {motjoueVerif.remove(PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase());}
				mot += PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().toLowerCase();
				
				// *** Verfication des mots à côtés *
				try {
					if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {
						correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1]-1, 1}, false);
					}
				} catch (Exception e) {System.out.println("Bord du plateau WEST");}
				try {
					if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]+1].getText().length() == 1) {
							correct = Controleur.verification(new Integer[]{coordVerif[0], coordVerif[1]+1, 1}, false);
					}
				} catch (Exception e) {System.out.println("Bord du plateau EAST");}
				coordVerif[0] += 1;
			}			
		}
				
				// *** Fin de verfication des mots à coté
				
		if (!Modele.DICTIONNAIRE.containsKey(mot) || !motjoueVerif.isEmpty()) {correct = false;}
		
		return correct;
		
	}
	
	public static Integer compterPoint(Integer[] coord) {
		
		Integer[] coordVerif = coord.clone();
		int point = 0;
		int coef = 1;
		int mot = 0;
			
		if (PlateauDeJeu.motjoue.size() == 7) {point += 50;} // SCRABBLE!
		
		if (PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1 || PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]+1].getText().length() == 1) {
			
			System.out.println("cas 1");
			
			while (coordVerif[1] > 0 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]-1].getText().length() == 1) {coordVerif[1] -= 1;}
			while (coordVerif[1] < 15 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) { // Tant que lettre posé
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
				coordVerif[1] += 1;
			
			}
		
		}
		
		point += mot*coef;
		
		coordVerif = coord.clone();
		coef = 1;
		mot = 0;
		
		if (PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1 || PlateauDeJeu.boutonTab[coordVerif[0]+1][coordVerif[1]].getText().length() == 1) {
			
			System.out.println("cas 2");
			
			while (coordVerif[0] > 0 && PlateauDeJeu.boutonTab[coordVerif[0]-1][coordVerif[1]].getText().length() == 1) {coordVerif[0] -= 1;}
			while (coordVerif[0] < 15 && PlateauDeJeu.boutonTab[coordVerif[0]][coordVerif[1]].getText().length() == 1) { // Tant que lettre posé
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
				
				coordVerif[0] += 1;
			}
			
			point += mot*coef;
		}
		
		return point; 
	}
	
	public static boolean estDansLeTab (int[][] matrix, Integer[] tab) {
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == tab[0] && matrix[i][1] == tab[1]) {return true;}
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