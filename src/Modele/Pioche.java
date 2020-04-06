package Modele;

import java.util.ArrayList;
import java.util.Collections;

import com.sun.tools.javac.util.ArrayUtils;



public class Pioche {
	
	ArrayList<Character> lettre;
	
	public Pioche() {
		
		this.lettre = new ArrayList<Character>();
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < Modele.LETTRES.get((char)('A' + i))[1]; j++) {
				lettre.add((char)('A' + i));
			}
		}
		Collections.shuffle(this.lettre);
		
	}
	
	public ArrayList<Character> piocher(ArrayList<Character> mainJoueur) {
		
		ArrayList<Character> main = mainJoueur;
		
		while (this.lettre.size() > 0 && main.size() < 7 ) {
			main.add(this.lettre.remove(0));
		}
		
		return main;
		
	}

}
