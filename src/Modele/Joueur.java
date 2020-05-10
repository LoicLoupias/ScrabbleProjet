package Modele;

import java.util.ArrayList;

public class Joueur {

	//initialisation des propri�t�s du joueur
	public String nom;
	public int point;
	public ArrayList<Character> lettre;
	public int passerTour;

	//cr�ation du constructeur joueur
	public Joueur(String name, ArrayList<Character> hand) {
		this.passerTour = 0;
		this.nom = name;
		this.point = 0;
		this.lettre = hand;

	}

	


	public void piocher() {

		//piocher ssi il reste des lettres dans la pioche et s'il nous en manque dans notre main
		while (Pioche.lettrePioche.size() > 0 && this.lettre.size() < 7) {
			this.lettre.add(Pioche.lettrePioche.remove(0));
		}
		

	}
}
