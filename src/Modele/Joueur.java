package Modele;

import java.util.ArrayList;

public class Joueur {

	//initialisation des propriétés du joueur
	public String nom;
	public int point;
	public static ArrayList<Character> lettre;
	public int passerTour;

	//création du constructeur joueur
	public Joueur(String name, ArrayList<Character> hand) {
		this.passerTour = 0;
		this.nom = name;
		this.point = 0;
		this.lettre = hand;

	}

	
	public void passTour() {
		this.passerTour++;
	}

	public void piocher() {

		//piocher ssi il reste des lettres dans la pioche et s'il nous en manque dans notre main
		while (Pioche.lettrePioche.size() > 0 && Joueur.lettre.size() < 7) {
			Joueur.lettre.add(Pioche.lettrePioche.remove(0));
		}

	}
}
