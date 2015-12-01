package esof322.a4;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BreezySwing.*;

/**
 * Tyler Wright
 * Nov. 30, 2015
 * Initial window for choosing game difficulty as well as loading saved game 
 *
 */


public class WelcomeView extends GBFrame{
	private ArrayList loadInfo; 
	JLabel welcomeLabel = addLabel(	"                           New Game Difficulty", 1, 5, 1, 1);
	JButton easyButton = addButton("Easy", 11, 5, 1, 1); // choose easy difficulty
	JButton hardButton = addButton("Hard", 15, 5, 1, 1); // choose hard difficulty
	JButton loadButton = addButton("Load Game", 21, 5, 1, 1); // choose load game 
	
	JLabel separator1 = addLabel("------------------------------------------------------------------------", 20, 5, 1, 1);

	
	public WelcomeView() {
		setTitle("Adventure Game"); 
	}
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == easyButton) {
			JFrame view = new AdventureGameView(0, loadInfo);	//begin creating level 0 game 
			view.setSize(900, 800); /* was 400, 250 */
			view.setVisible(true);
			this.dispose();
		}else if (buttonObj == hardButton) {
			JFrame view = new AdventureGameView(1, loadInfo);	//begin creating level 1 game 
			view.setSize(900, 800); /* was 400, 250 */
			view.setVisible(true);
			this.dispose();
		}else if (buttonObj == loadButton) {	//load 
			loadWindow(); 
		}

	}
	
	//populate array with info from load 
	public void setLoadInfo(ArrayList info) {
		this.loadInfo = info; 
	}
	
	//called from load info to create view and close welcome view 
	public void close() {
		JFrame view = new AdventureGameView(2, loadInfo); 
		view.setSize(900, 800); /* was 400, 250 */
		view.setVisible(true);
		this.dispose(); 
	}
	
	//open load game window 
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

