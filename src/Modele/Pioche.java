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
	
	public ArrayList<Character> piocher(Integer nbr) {
		
		ArrayList<Character> lettrePioché = new ArrayList<Character>();
		
		for (int i = 0; i<this.lettre.size() && i<nbr; i++) {
			lettrePioché.add(this.lettre.remove(0));
		}
		
		return lettrePioché;
		
	}

}
