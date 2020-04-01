import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Plateau_De_Jeu extends JPanel {
    
	public Plateau_De_Jeu() {
		// Set the panel to add buttons
		super();
		
		// Set the BoxLayout to be X_AXIS: from left to right		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		// Set border for the panel
		//this.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		//panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));     
		
		// Define new buttons
		JButton [] boutonTab = new JButton[15];
		for (int i = 0; i<15; i++) {
			boutonTab[i] = new JButton(Integer.toString(i));
			boutonTab[i].setSize(50, 50);
			this.add(boutonTab[i]);
		}
     
    // Add buttons to the frame (and spaces between buttons)
    //panel.add(Box.createRigidArea(new Dimension(0, 60)));     

     
    // Set size for the frame
    //frame.setSize(300, 300);
     
    // Set the window to be visible as the default to be false

	}
}

