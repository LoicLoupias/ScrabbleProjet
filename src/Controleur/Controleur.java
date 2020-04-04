package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

import Modele.Modele;
import Vue.PlateauDeJeu;
import Vue.vueJeu;

@SuppressWarnings("deprecation")
public class Controleur implements ContainerListener, ActionListener, ItemListener, Observer {
	
	public Controleur(Modele modele, vueJeu vueDuJeu, PlateauDeJeu plateau) {
		
		//while (modele.etat == modele.etat.EN_COURS) {
			
		//}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
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