package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class vueHistorique extends JPanel {
	
	ArrayList<JLabel> historique; 
	
	public vueHistorique() {
		
		super();
		
		historique = new ArrayList<JLabel>();
		historique.add(new JLabel("HISTORIQUE"));
		
		//this.setPreferredSize(new Dimension(500, 100));
		
	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(historique.get(0));
		
		
	}

}
