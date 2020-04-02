package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlateauDeJeu extends JPanel implements WindowListener {
    
	JButton[][] boutonTab;
	
	@SuppressWarnings("deprecation")
	public PlateauDeJeu() {
		
		this.setPreferredSize(new Dimension(50*15, 50*15));
		FlowLayout layout = new FlowLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);
		
		boutonTab = new JButton[Vue.SIZE][Vue.SIZE];
		
		//Define new buttons
		for (int i = 0; i<Vue.SIZE; i++) {
			for(int j=0; j<Vue.SIZE; j++) {
				boutonTab[i][j] = new JButton();
				boutonTab[i][j].setPreferredSize(new Dimension(50,50));
				boutonTab[i][j].setBackground(new Color(0,200,0));
				boutonTab[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(boutonTab[i][j]);
			}
		}
		
		
		//System.out.println(Vue.md.length);
		
		
		for (int n=0; n<Vue.MD.length;n++) {
			boutonTab[Vue.MD[n][0]][Vue.MD[n][1]].setBackground(Color.PINK);
			boutonTab[Vue.MD[n][0]][Vue.MD[n][1]].setText("MD");
		}
		for (int n=0; n<Vue.LD.length;n++) {
			boutonTab[Vue.LD[n][0]][Vue.LD[n][1]].setBackground(Color.CYAN);
			boutonTab[Vue.LD[n][0]][Vue.LD[n][1]].setText("LD");
		}
		for (int n=0; n<Vue.MT.length;n++) {
			boutonTab[Vue.MT[n][0]][Vue.MT[n][1]].setBackground(Color.RED);
			boutonTab[Vue.MT[n][0]][Vue.MT[n][1]].setText("MT");
			
		}
		for (int n=0; n<Vue.LT.length;n++) {
			boutonTab[Vue.LT[n][0]][Vue.LT[n][1]].setBackground(Color.BLUE);
			boutonTab[Vue.LT[n][0]][Vue.LT[n][1]].setText("LT");
		}
		
	
		
	}
	
	/*
		colonne = new Column[15];
		
		for (int i = 0; i<15; i++) {
			this.colonne[i] = new Column();
			//this.colonne[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
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
	*/

	
	/*
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
				boutonTab[i] = new JButton("case vide");
				boutonTab[i].setPreferredSize(new Dimension(100, 100));
				boutonTab[i].setBackground(new Color(0,200,0));
				this.boutonTab[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(boutonTab[i]);
			}
		}
	}
	*/


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