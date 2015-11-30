package esof322.a4;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BreezySwing.*;

public class WelcomeView extends GBFrame{
	private ArrayList loadInfo; 
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
			JFrame view = new AdventureGameView(0, loadInfo);
			view.setSize(900, 800); /* was 400, 250 */
			view.setVisible(true);
			this.dispose();
		}else if (buttonObj == hardButton) {
			JFrame view = new AdventureGameView(1, loadInfo);
			view.setSize(900, 800); /* was 400, 250 */
			view.setVisible(true);
			this.dispose();
		}else if (buttonObj == loadButton) {
			loadWindow(); 
		}

	}
	public void setLoadInfo(ArrayList info) {
		this.loadInfo = info; 
	}
	
	public void close() {
		JFrame view = new AdventureGameView(2, loadInfo); 
		view.setSize(900, 800); /* was 400, 250 */
		view.setVisible(true);
		this.dispose(); 
	}
	
	private void loadWindow() {
		JFrame view = new LoadView(this); 
		view.setSize(300, 200);
		view.setVisible(true);
		view.setResizable(false);
	}
	
	public static void main(String[] args) {
		JFrame welcome = new WelcomeView(); 
		welcome.setSize(300, 200); 
		welcome.setVisible(true);
		welcome.setResizable(false); 
	}
}

