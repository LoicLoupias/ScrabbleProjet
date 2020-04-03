package Modele;

import java.util.Map;

import javax.swing.JOptionPane;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;


public class Modele {
	
	public Joueur[] joueurs;
	public Pioche pioche;
	public ArrayList<String> historique;
	String[] nombre = {"1", "2", "3", "4"};	

	
	public static Map<Character, Integer[]> LETTRES = Map.ofEntries(
			entry('A', new Integer[] {1, 9}),	entry('B', new Integer[] {3, 2}), entry('C', new Integer[] {3, 2}),
			entry('D', new Integer[] {2, 3}), entry('E', new Integer[] {1, 15}), entry('F', new Integer[] {4, 2}), entry('G', new Integer[] {2, 2}),
			entry('H', new Integer[] {4, 2}), entry('I', new Integer[] {1, 8}),	entry('J', new Integer[] {8, 1}), entry('K', new Integer[] {10, 1}),
			entry('L', new Integer[] {1, 5}), entry('M', new Integer[] {2, 3}), entry('N', new Integer[] {1, 6}), entry('O', new Integer[] {1, 6}),
			entry('P', new Integer[] {3, 2}), entry('Q', new Integer[] {8, 1}), entry('R', new Integer[] {1, 6}), entry('S', new Integer[] {1, 6}),
			entry('T', new Integer[] {1, 6}), entry('U', new Integer[] {1, 6}), entry('V', new Integer[] {4, 2}), entry('W', new Integer[] {10, 1}),
			entry('X', new Integer[] {10, 1}), entry('Y', new Integer[] {10, 1}), entry('Z', new Integer[] {10, 1}), entry('*', new Integer[] {0, 2}));
			
	
	enum Etat {EN_COURS, GAGNE, PERDU};

	public Etat etat;

	public Modele() {
		
		
		
		int nombreJoueur = Integer.parseInt((String) JOptionPane.showInputDialog(null, 
	    	      "Veuillez selectionner le nombre de joueur :",
	    	      "Scrabble",
	    	      JOptionPane.QUESTION_MESSAGE,
	    	      null,
	    	      nombre,
	    	      nombre[0]));
	    
	    joueurs = new Joueur[nombreJoueur];
	    for (int i = 1; i<=nombreJoueur; i++) {
	        joueurs[i-1] = new Joueur(JOptionPane.showInputDialog(null, "Entrez le nom pour le joueur " + i + " :", "Scrabble", JOptionPane.QUESTION_MESSAGE));
	    }
	    
		this.etat = Etat.EN_COURS;
		
		this.pioche = new Pioche();
		this.historique = new ArrayList<String>(Arrays.asList(("HISTORIQUE")));
		
		for (int i = 0; i < joueurs.length; i++) {
			joueurs[i].lettre.addAll(pioche.piocher(7));
		}	
		
	}
	
}