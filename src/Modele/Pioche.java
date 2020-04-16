package Modele;

import java.util.ArrayList;
import java.util.Collections;
import com.sun.tools.javac.util.ArrayUtils;



public class Pioche {
	
	static ArrayList<Character> lettrePioche;
	
	public Pioche() {
		
		this.lettrePioche = new ArrayList<Character>();
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < Modele.LETTRES.get((char)('A' + i))[1]; j++) {
				lettrePioche.add((char)('A' + i));
			}
		}
		Collections.shuffle(this.lettrePioche);
		
	}
	

		
		
	}


