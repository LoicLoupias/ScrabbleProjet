import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Plateau_De_Jeu extends JPanel implements WindowListener {
    
	Column[] colonne;
	
	public Plateau_De_Jeu(int taille) {
		
		this.setPreferredSize(new Dimension(50*taille, 50*taille));
		
		colonne = new Column[taille];
		
		for (int i = 0; i<taille; i++) {
			this.colonne[i] = new Column();
			this.colonne[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			this.add(colonne[i]);
		}
	    for(int i = 0; i<Vue.MOT_DOUBLE.length; i++) {
	    	colonne[Vue.MOT_DOUBLE[i][0]].getComponent(Vue.MOT_DOUBLE[i][1]).setBackground(Color.ORANGE);
	    	colonne[14 - Vue.MOT_DOUBLE[i][0]].getComponent(14 - Vue.MOT_DOUBLE[i][1]).setBackground(Color.ORANGE);
	    }
	    for(int i = 0; i<Vue.LETTRE_DOUBLE.length; i++) {
	    	colonne[Vue.LETTRE_DOUBLE[i][0]].getComponent(Vue.LETTRE_DOUBLE[i][1]).setBackground(Color.CYAN);
	    	colonne[14 - Vue.LETTRE_DOUBLE[i][0]].getComponent(14 - Vue.LETTRE_DOUBLE[i][1]).setBackground(Color.CYAN);
	    }
	    for(int i = 0; i<Vue.MOT_TRIPLE.length; i++) {
	    	colonne[Vue.MOT_TRIPLE[i][0]].getComponent(Vue.MOT_TRIPLE[i][1]).setBackground(Color.RED);
	    	colonne[14 - Vue.MOT_TRIPLE[i][0]].getComponent(14 - Vue.MOT_TRIPLE[i][1]).setBackground(Color.RED);
	    }
	    for(int i = 0; i<Vue.LETTRE_TRIPLE.length; i++) {
	    	colonne[Vue.LETTRE_TRIPLE[i][0]].getComponent(Vue.LETTRE_TRIPLE[i][1]).setBackground(Color.BLUE);
	    	colonne[14 - Vue.LETTRE_TRIPLE[i][0]].getComponent(14 -Vue.LETTRE_TRIPLE[i][1]).setBackground(Color.BLUE);
	    }
	}


	public class Column extends JPanel {
		
		JButton [] boutonTab = new JButton[Vue.SIZE];
		
		public Column() {
			
			// Set the panel to add buttons
			super();
					
			// Set the BoxLayout to be X_AXIS: from left to right		
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
					
			// Set size for the frame
			this.setPreferredSize(new Dimension(50, 50*Vue.SIZE));
					
			// Define new buttons
			for (int i = 0; i<Vue.SIZE; i++) {
				boutonTab[i] = new JButton(Integer.toString(i));
				boutonTab[i].setPreferredSize(new Dimension(100, 100));
				boutonTab[i].setBackground(new Color(249,228,183));
				this.boutonTab[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(boutonTab[i]);
			}
		}
	}


	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}		