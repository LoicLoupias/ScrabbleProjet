package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import Modele.Modele;
import Vue.PlateauDeJeu;
import Vue.vueJeu;

@SuppressWarnings("deprecation")
public class Controleur implements ContainerListener, ActionListener, ItemListener{
	
	public Controleur(Modele modele, vueJeu vueDuJeu, PlateauDeJeu plateau) {
		
		
		
		// pour mettre en place un jeton, on peut créer un objet de type char et en gros dès qu'on clique sur la pioche et que cet objet est vide
		//alors on rajoute ce chart dans l'objet puis tant qu'il est pas vide alors on peut plus en ajouter, puis si le clic est sur un boutton du platteau
		// alors on verifie s'il n'y a pas de lettre dans le boutton du plateau, s'il y en a pas alors on pop le charet on l'ajoute au bouton.
		
		
		
		
		
		//while (modele.etat == modele.etat.EN_COURS) {
			
		//}
		
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}