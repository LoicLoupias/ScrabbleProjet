package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class vueHistorique extends JPanel {
	
	public ArrayList<JLabel> historique; 
	JLabel titre;
	
	public vueHistorique(ArrayList<String> hst) {
		
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Iterator<String> it = hst.iterator();
		while (it.hasNext()) {
			historique.add(new JLabel(it.next()));
		}
		
		this.titre.setHorizontalAlignment(SwingConstants.CENTER);
		
		//this.setPreferredSize(new Dimension(500, 100));
		
		this.add(titre);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		this.add(this.historique.get(this.historique.size()));
		
	}

}
