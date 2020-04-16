package Modele;

import java.util.ArrayList;
import Modele.Pioche;
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
		this.passerTour++;
	}

	public void piocher() {

		while (Pioche.lettrePioche.size() > 0 && Joueur.lettre.size() < 7) {
			Joueur.lettre.add(Pioche.lettrePioche.remove(0));
		}

	}
}
