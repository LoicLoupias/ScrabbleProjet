package Modele;

import java.util.Map;

import javax.swing.JOptionPane;

import Vue.VueBoutonJeu;

import static java.util.Map.entry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;



public class Modele {
	
	public static Joueur[] joueurs;
	public Pioche pioche;
	public static Integer nbrJoueur;
	public static Integer tour;
	public static HashMap<String, Integer> DICTIONNAIRE;
	
	public static Map<Character, Integer[]> LETTRES = Map.ofEntries(
			// initialisation des lettres de la picohe par { point, nombre de jeton dans la pioche}
			entry('A', new Integer[] {1, 9}),	entry('B', new Integer[] {3, 2}), entry('C', new Integer[] {3, 2}),
			entry('D', new Integer[] {2, 3}), entry('E', new Integer[] {1, 15}), entry('F', new Integer[] {4, 2}), entry('G', new Integer[] {2, 2}),
			entry('H', new Integer[] {4, 2}), entry('I', new Integer[] {1, 8}),	entry('J', new Integer[] {8, 1}), entry('K', new Integer[] {10, 1}),
			entry('L', new Integer[] {1, 5}), entry('M', new Integer[] {2, 3}), entry('N', new Integer[] {1, 6}), entry('O', new Integer[] {1, 6}),
			entry('P', new Integer[] {3, 2}), entry('Q', new Integer[] {8, 1}), entry('R', new Integer[] {1, 6}), entry('S', new Integer[] {1, 6}),
			entry('T', new Integer[] {1, 6}), entry('U', new Integer[] {1, 6}), entry('V', new Integer[] {4, 2}), entry('W', new Integer[] {10, 1}),
			entry('X', new Integer[] {10, 1}), entry('Y', new Integer[] {10, 1}), entry('Z', new Integer[] {10, 1}), entry('*', new Integer[] {0, 2}));
			
	
	public enum Etat {EN_COURS, FINI};

	public static Etat etat;

	public Modele() {
		DICTIONNAIRE = new HashMap<>();
		float t = Float.parseFloat(new SimpleDateFormat("ss.SSS").format(new Date()));
		try { 
			File file = new File("src\\Modele\\dico_a-g.txt"); 
		    BufferedReader br = new BufferedReader(new FileReader(file)); 
		    String st; 
		    
		    while ((st = br.readLine()) != null) {
		    	DICTIONNAIRE.put(st, 0); 
		    }
		    
		    file = new File("src\\Modele\\dico_h-z.txt"); 
		    br = new BufferedReader(new FileReader(file)); 

		    while ((st = br.readLine()) != null) {
		    	DICTIONNAIRE.put(st, 1); 
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Float.parseFloat(new SimpleDateFormat("ss.SSS").format(new Date())) - t + "s pour créer le dictionnaire");
		System.out.println(DICTIONNAIRE.size());
		
		//debut du jeu 
		
		this.etat = Etat.EN_COURS;
		this.pioche = new Pioche();
		

		// demande du nombre de joueur
		nbrJoueur = (Integer) JOptionPane.showInputDialog(null, 
	    	      "Veuillez selectionner le nombre de joueur :",
	    	      "Scrabble",
	    	      JOptionPane.QUESTION_MESSAGE,
	    	      null,
	    	      new Integer[] {1,2,3,4}, 2);
	    

	
		// nom des joueurs
	    joueurs = new Joueur[nbrJoueur];
	    
	    for (int i = 1; i<=nbrJoueur; i++) {
	        joueurs[i-1] = new Joueur(JOptionPane.showInputDialog(null, "Entrez le nom pour le joueur " + i + " :", "Scrabble", JOptionPane.QUESTION_MESSAGE ), new ArrayList<Character>());
	        joueurs[i-1].piocher();
	        System.out.println(joueurs[i-1].lettre);
	        System.out.println(joueurs[0].lettre);
	        
	    }
	    
	    System.out.println(Modele.joueurs[0].lettre);
	    System.out.println(Modele.joueurs[1].lettre);

		this.tour = 0;

			
		

	
		
	}

	
}
