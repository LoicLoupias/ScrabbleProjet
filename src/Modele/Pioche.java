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
		
		System.out.println(this.lettre.toString());
		Collections.shuffle(lettre);
		System.out.println(this.lettre.toString());
		
	}
	
	public ArrayList<Character> piocher(ArrayList<Character> lettreJou, Integer nbr) {
		
		for (int i = 0; i<this.lettre.size() && i<nbr; i++) {
			lettreJou.add(this.lettre.remove(0));
		}
		return lettreJou;
		
	}

}
