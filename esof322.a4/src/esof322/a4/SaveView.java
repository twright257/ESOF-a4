package esof322.a4;


import javax.swing.*;

import BreezySwing.*;

public class SaveView extends GBFrame{

	
	private static final long serialVersionUID = 1L;
	private AdventureGameView a; 
	JTextArea saveText = addTextArea("Enter save name", 1, 1, 1, 1);
	JButton accept = addButton("OK", 2, 1, 1, 1); 
	
	public SaveView(AdventureGameView a) {
		saveText.setEditable(true);
		this.a = a; 
	}
	
	//when accept button clicked, save text field info 
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == accept) {
			a.save(saveText.getText());
			this.dispose();
		}
	}
}
