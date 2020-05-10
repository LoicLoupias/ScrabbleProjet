//Tests pour liste défilante de l'historique

package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class vueHistorique extends JPanel {

	public JScrollPane historique;
	public JTextArea historiquetexte;
	public JTextArea titrehistorique;
	String jeu;
	String titre;
	String texte;

	public vueHistorique() {

		super();
		titre = "                                     HISTORIQUE DU JEU : ";//Adapter le nombre d'espaces en fonction de celui qui fait la vidéo
		jeu = " ";

		titrehistorique = new JTextArea();

		historiquetexte = new JTextArea();
		historiquetexte.setEditable(false);
		historique = new JScrollPane(historiquetexte, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.add(titrehistorique);
		this.add(historique);

		Font fonttitrehistorique = new Font("Arial", Font.BOLD, 25);
		Font fonthistorique = new Font("Arial", Font.PLAIN, 18);

		titrehistorique.setFont(fonttitrehistorique);
		historiquetexte.setFont(fonthistorique);

		titrehistorique.setBackground(Color.LIGHT_GRAY);
		historiquetexte.setBackground(Color.LIGHT_GRAY);

		titrehistorique.setText(titre);
		historiquetexte.setText(jeu);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}

	public void ajoutHistorique(String mot) {
		if (mot.charAt(0) == 'C') {
			jeu = jeu + mot + "\n \n";
		} else {
			jeu = jeu + mot + " \n";
		}
		this.historiquetexte.setText(jeu);
		this.updateUI();// actualise l'affichage de la frame

	}
}

//Bonne version temporaire 

/*
 * package Vue;
 * 
 * import java.awt.Color; import java.util.ArrayList; import
 * javax.swing.BorderFactory; import javax.swing.BoxLayout; import
 * javax.swing.JLabel; import javax.swing.JPanel;
 * 
 * 
 * 
 * public class vueHistorique extends JPanel {
 * 
 * public ArrayList<JLabel> historique;
 * 
 * public vueHistorique() {
 * 
 * super();
 * 
 * this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); this.historique = new
 * ArrayList<JLabel>(); historique.add(new JLabel("HISTORIQUE"));
 * this.add(historique.get(0)); this.setBackground(Color.LIGHT_GRAY);
 * this.setBorder(BorderFactory.createRaisedBevelBorder());
 * 
 * //this.setPreferredSize(new Dimension(500, 100));
 * 
 * 
 * 
 * }
 * 
 * public void ajoutHistorique(String mot) {
 * 
 * this.historique.add(new JLabel(mot));
 * this.add(this.historique.get(this.historique.size() - 1));
 * this.updateUI();//actualise l'affichage de la frame
 * 
 * 
 * } }
 */