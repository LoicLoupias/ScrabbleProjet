package Modele;

import java.util.ArrayList;

public class Joueur {
	
	public String nom;
	public int point;
	public ArrayList<Character> lettre;
	public int passerTour;
	
	public Joueur(String name) {
		this.passerTour = 0;
		this.nom = name;
		this.point = 0;
		this.lettre = new ArrayList<Character>();
		
	}
	public void passTour() {
		this.passerTour ++;
	}
	
}
