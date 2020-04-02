package Modele;

public class Modele {
	
	Joueur[] joueurs;
	
	enum Etat {
		EN_COURS, GAGNE, PERDU
	};

	public Etat etat;

	public Modele(int nombreJoueur) {
		
		this.etat = Etat.EN_COURS;
		
	}
	
}
