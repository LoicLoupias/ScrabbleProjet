//Tests poour liste défilante de l'historique

/*package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class vueHistorique extends JPanel {
	
	public ArrayList<JLabel> historique; 
	public JList listehistorique;
	
	public vueHistorique() {
		
		super();
		historique = new ArrayList();
		listehistorique = new JList(historique.toArray());
		
		JLabel titrehistorique = new JLabel("HISTORIQUE DU JEU : ");
		Font fonthistorique = new Font("Arial", Font.BOLD,25);
		titrehistorique.setAlignmentX(CENTER_ALIGNMENT);
		titrehistorique.setFont(fonthistorique);
		
		listehistorique.setBackground(Color.LIGHT_GRAY);
		listehistorique.add(titrehistorique);
		this.add(listehistorique);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.historique = new ArrayList<JLabel>();
		
		
		
		
		
		
		//this.add(historique.get(0));
		//this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	public void ajoutHistorique(String mot) {
		JLabel motjoue = new JLabel(mot);
		Font fontmotjoue = new Font("Arial", Font.PLAIN, 18);
		motjoue.setAlignmentX(CENTER_ALIGNMENT);
		motjoue.setFont(fontmotjoue);
		this.listehistorique.add(motjoue);
		//this.add(this.listehistorique.get(this.listehistorique.size() - 1));
		this.updateUI();//actualise l'affichage de la frame
		
		
	}
}
*/

//Bonne version temporaire 

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