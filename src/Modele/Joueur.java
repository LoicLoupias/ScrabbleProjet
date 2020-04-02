package Modele;

import java.util.ArrayList;

public class Joueur {
	
	public String nom;
	public int point;
	public ArrayList<Character> lettre;
	
	public Joueur(String name) {
		
		nom = name;
		point = 0;
		lettre = new ArrayList<Character>();
		
	}
	
}
