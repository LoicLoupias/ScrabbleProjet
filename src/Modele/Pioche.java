package Modele;

import java.util.ArrayList;
import java.util.Collections;



public class Pioche {
	
	static ArrayList<Character> lettrePioche;
	
	public Pioche() {
		
		this.lettrePioche = new ArrayList<Character>();
		
		//ajout des jetons dans la pioche suivant le nombre de fois qu'il y a de caractère
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < Modele.LETTRES.get((char)('A' + i))[1]; j++) {
				lettrePioche.add((char)('A' + i));
			}
		}
		Collections.shuffle(this.lettrePioche);
		
	}
	

		
		
	}


