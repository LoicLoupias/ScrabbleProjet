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

import com.sun.tools.javac.code.Attribute.Array;

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
	
	public static boolean verification(ArrayList<Integer> coord, boolean deepsearch) {
		
		Integer[] c = {coord.get(0), coord.get(1)};

		if (coord.size() == 2) {return Modele.DICTIONNAIRE.containsKey(PlateauDeJeu.boutonTab[c[0]][c[1]].getText().toLowerCase());}

		Integer axefixe = coord.get(2);
		
		String mot = new String();
		
		boolean correct = true;
		
		while (c[1-axefixe] > 0 && PlateauDeJeu.boutonTab[c[0]][c[1]].getText().length() == 1) {c[1-axefixe] -= 1;System.out.println("test");} // Obtention de la position de départ
		
	
		if (!deepsearch) { // On ne parcourt pas tous les mots accolés si ce n'est pas le mot initial
			while (c[1-axefixe] < 15 && PlateauDeJeu.boutonTab[c[0]][c[1]].getText().length() == 1) {
				mot += PlateauDeJeu.boutonTab[c[0]][c[1]].getText();
				c[1-axefixe] += 1;
			}
			System.out.println("test1"+mot);
			return Modele.DICTIONNAIRE.containsKey(mot);
		}
		
		else { // Cas du mot initial
			
			ArrayList<Character> motAverif = new ArrayList<Character>();
			for (char x: PlateauDeJeu.motjoue.toCharArray()) {motAverif.add(x);}

			while (c[1-axefixe] < 15 && PlateauDeJeu.boutonTab[c[0]][c[1]].getText().length() == 1 && correct) { // Tant que lettre posé
				
				if (!motAverif.isEmpty()) {motAverif.remove(PlateauDeJeu.boutonTab[c[0]][c[1]].getText());
				mot += PlateauDeJeu.boutonTab[c[0]][c[1]].getText();
				
				// *** Verfication des mots à côtés ***
				
				if (axefixe == 0) {
					if (PlateauDeJeu.boutonTab[c[0]-1][c[1]].getText().length() == 1) {
						ArrayList<Integer> nouvCoord = new ArrayList<Integer>(Arrays.asList(c[0]-1,c[1],1)); 
						correct = Controleur.verification(nouvCoord, false);
					}
					else if (PlateauDeJeu.boutonTab[c[0]+1][c[1]].getText().length() == 1) {
						ArrayList<Integer> nouvCoord = new ArrayList<Integer>(Arrays.asList(c[0]+1,c[1],1)); 
						correct = Controleur.verification(nouvCoord, false);
					}
				}
				else {
					if (PlateauDeJeu.boutonTab[c[0]][c[1]-1].getText().length() == 1) {
						ArrayList<Integer> nouvCoord = new ArrayList<Integer>(Arrays.asList(c[0],c[1]-1,0)); 
						correct = Controleur.verification(nouvCoord, false);
					}
					else if (PlateauDeJeu.boutonTab[c[0]][c[1]+1].getText().length() == 1) {
						ArrayList<Integer> nouvCoord = new ArrayList<Integer>(Arrays.asList(c[0],c[1]+1,0)); 
						correct = Controleur.verification(nouvCoord, false);
					}
				}
				
				// *** Fin de verfication des mots à coté
				
				c[1-axefixe] += 1;
			}
			
			if (!Modele.DICTIONNAIRE.containsKey(mot.toLowerCase()) || !motAverif.isEmpty()) {correct = false;}
			
			}
		}
		System.out.println("test2"+mot);
		return correct;
		
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