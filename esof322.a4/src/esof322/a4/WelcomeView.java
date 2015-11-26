package esof322.a4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BreezySwing.*;

public class WelcomeView extends GBFrame{
	JLabel welcomeLabel = addLabel(	"                           New Game Difficulty", 1, 5, 1, 1);
	JButton easyButton = addButton("Easy", 11, 5, 1, 1); // choose easy difficulty
	JButton hardButton = addButton("Hard", 15, 5, 1, 1); // choose to grab first item 
	JButton loadButton = addButton("Load Game", 21, 5, 1, 1); // choose to grab first item 
	
	JLabel separator1 = addLabel("-------------------------------------", 20, 5, 1, 1);

	
	public WelcomeView() {
		setTitle("Adventure Game"); 
	}
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == easyButton) {
			JFrame view = new AdventureGameView(0);
			view.setSize(900, 800); /* was 400, 250 */
			view.setVisible(true);
			this.dispose();
		}else if (buttonObj == hardButton) {
			JFrame view = new AdventureGameView(1);
			view.setSize(900, 800); /* was 400, 250 */
			view.setVisible(true);
			this.dispose();
		}else if (buttonObj == loadButton) {
			
		}

	}
	
	public static void main(String[] args) {
		JFrame welcome = new WelcomeView(); 
		welcome.setSize(300, 200); 
		welcome.setVisible(true);
		welcome.setResizable(false); 
	}
}

