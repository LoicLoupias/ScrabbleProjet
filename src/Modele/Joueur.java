package Modele;

import java.util.ArrayList;

public class Joueur {
	
	public String nom;
	public int point;
	public static ArrayList<Character> lettre;
	public int passerTour;
	
	public Joueur(String name, ArrayList<Character> hand) {
		this.passerTour = 0;
		this.nom = name;
		this.point = 0;
		this.lettre = hand;
		
	}
	public void passTour() {
		this.passerTour ++;
	}
	
}
