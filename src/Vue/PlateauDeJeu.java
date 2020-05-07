package Vue;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PlateauDeJeu extends JPanel {
    
	public static JButton[][] boutonTab;
	JButton caseajouer;
	public static String motjoue;
	ArrayList<Integer> coord ;
	
	public PlateauDeJeu() {
		
		this.setPreferredSize(new Dimension(50*15, 50*15));
		
		GridLayout layoutPlateauDeJeu = new GridLayout(15,15);
		this.setLayout(layoutPlateauDeJeu);
		
		boutonTab = new JButton[Vue.SIZE][Vue.SIZE];
		
		coord = new ArrayList<Integer>();
		motjoue = new String();
		
		//Define new buttons
		for (int i = 0; i<Vue.SIZE; i++) {
			
			for(int j=0; j<Vue.SIZE; j++) {
				boutonTab[i][j] = new JButton();
				boutonTab[i][j].setPreferredSize(new Dimension(50,50));
				boutonTab[i][j].setBackground(new Color(0,200,0));
				boutonTab[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				boutonTab[i][j].addMouseListener(new BoutonListener());
				this.add(boutonTab[i][j]);
			}
		}
		
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
			boutonTab[Vue.MT[n][0]][Vue.MT[n][1]].setForeground(Color.WHITE);
			
		}
		for (int n=0; n<Vue.LT.length;n++) {
			boutonTab[Vue.LT[n][0]][Vue.LT[n][1]].setBackground(Color.BLUE);
			boutonTab[Vue.LT[n][0]][Vue.LT[n][1]].setText("LT");
			boutonTab[Vue.LT[n][0]][Vue.LT[n][1]].setForeground(Color.WHITE);
		}
		
	}
	
	class BoutonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getSource());
			caseajouer = (JButton) e.getSource();
			
			//on place le jeton ssi on a une lettre en main et que la case est disponible
			if (vueLettre.lettreajouer != null && caseajouer.isEnabled()) {
				
				Integer[] c = {e.getComponent().getX()/50, e.getComponent().getY()/50, (int) vueLettre.lettreajouer.toCharArray()[0] - 64};
				
				if (coord.size() == 0) {
					coord.add(c[0]);
					coord.add(c[1]);
				}
				else if (coord.size() == 2) {
					if (coord.get(0) != c[0] && coord.get(1) != c[1]) {
						System.out.println("Pas Bien!");
						return;
					}
					else if (coord.get(0) == c[0]) {coord.add(0);}
					else {coord.add(1);}
				}
				else if (coord.size() == 3) {
					if (coord.get(coord.get(2)) != c[coord.get(2)]) {
						System.out.println("Pas Bien!");
						return;
					}
					else {
						if (coord.get(1-coord.get(2)) > c[1-coord.get(2)]) {
							coord.set(0, c[0]);
							coord.set(1, c[1]);
						}
					} 
				}				
				motjoue += vueLettre.lettreajouer;
				caseajouer.setText(vueLettre.lettreajouer);		
				caseajouer.setFont(new Font("Arial", Font.PLAIN, 40));
				caseajouer.setBackground(Color.yellow);//mis en vu du jeton posé

				vueLettre.lettreajouer = null;//réinitialisation de lettreajouer pour les prochains jetons à placer
				vueLettre.boutonajouer.setEnabled(false);//on rend le jeton jouer inaccessible une fois utilise
				caseajouer.removeMouseListener(this);//rend la case inutilisable après avoir placé un jeton dessus
				
				System.out.println(Controleur.Controleur.verification(coord, true));
				
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}		