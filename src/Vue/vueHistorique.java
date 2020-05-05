package Vue;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;



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
		this.updateUI();//actualise l'affichage de la frame
		
		
	}
}
