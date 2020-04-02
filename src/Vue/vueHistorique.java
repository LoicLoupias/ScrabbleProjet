package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
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
	JLabel titre;
	
	public vueHistorique() {
		
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		historique = new ArrayList<JLabel>();
		
		this.titre = new JLabel("HISTORIQUE");
		this.titre.setHorizontalAlignment(titre.CENTER);
		
		//this.setPreferredSize(new Dimension(500, 100));
		
		this.add(titre);
		
		
	}

}
