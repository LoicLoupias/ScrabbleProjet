package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class vueHistorique extends JPanel {
	
	public ArrayList<JLabel> historique; 
	
	public vueHistorique() {
		
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.historique = new ArrayList<JLabel>();
		historique.add(new JLabel("HISTORIQUE"));
		this.add(historique.get(0));
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		//this.setPreferredSize(new Dimension(500, 100));
		
		
		
	}
	
	public void ajoutHistorique(String mot) {
		
		this.historique.add(new JLabel(mot));
		this.add(this.historique.get(this.historique.size() - 1));
		
		
	}
}
