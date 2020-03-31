package Modele;
public class Modele {
	enum Etat {
		EN_COURS, GAGNE, PERDU
	};

	public Etat etat;

	public Modele() {
		this.etat = Etat.EN_COURS;
	}
}
