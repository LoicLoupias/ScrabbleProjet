package Modele;

public class Joueur {
	
	public String nom;
	public int point;
	public char[] lettre;
	
	public Joueur(String name) {
		
		nom = name;
		point = 0;
		lettre = new char[7];
		
	}
	
}
