package esof322.a4;

import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;

public class AdventureGameView extends GBFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList loadInfo; 
	
	// Window objects --------------------------------------
	JLabel welcomeLabel = addLabel(
			"Welcome to the Adventure Game " + "(inspired by an old game called the Colossal Cave Adventure)."
					+ " Java implementation Copyright (c) 1999-2012 by James M. Bieman",
			1, 1, 5, 1);

	JLabel viewLable = addLabel("Your View: ", 2, 1, 1, 1);
	JTextArea viewArea = addTextArea("Start", 3, 1, 4, 3);

	JLabel carryingLable = addLabel("You are carying: ", 6, 1, 1, 1);
	JTextArea carryingArea = addTextArea("Nothing", 7, 1, 4, 3);

	JLabel activityLabel = addLabel("Interaction Info", 2, 5, 1, 1); // third text box label

	JTextArea activityArea = addTextArea("", 3, 4, 2, 2); // third text box

	JLabel separator1 = addLabel("-----------------------------------------------------------------", 10, 1, 4, 1);

	JLabel choiceLabel = addLabel("Choose a direction, pick-up, or drop an item", 11, 1, 5, 1);

	JButton saveButton = addButton("Save Game", 8, 5, 1, 1); // button for
																// saving
	JButton loadButton = addButton("Load Game", 9, 5, 1, 1); // button for
																// loading

	JButton grabButton1 = addButton("Grab Item 1", 11, 5, 1, 1); // choose to grab first item 

	JButton grabButton2 = addButton("Grab Item 2", 12, 5, 1, 1); // choose to grab second item

	JButton dropButton1 = addButton("Drop Item 1", 13, 5, 1, 1); // choose to drop first item

	JButton dropButton2 = addButton("Drop Item 2", 14, 5, 1, 1);

	JButton northButton = addButton("North", 12, 2, 1, 1);
	JButton southButton = addButton("South", 14, 2, 1, 1);
	JButton eastButton = addButton("East", 13, 3, 1, 1);
	JButton westButton = addButton("West", 13, 1, 1, 1);
	JButton upButton = addButton("Up", 12, 3, 1, 1);
	JButton downButton = addButton("Down", 14, 3, 1, 1);

	AdventureGameModelFacade model;
	private String save = ""; 

	// Constructor-----------------------------------------------

	public AdventureGameView(int type, ArrayList loadInfo) {
		this.loadInfo = loadInfo; 
		setTitle("Adventure Game");
		model = new AdventureGameModelFacade(type, loadInfo);

		viewArea.setEditable(false);
		carryingArea.setEditable(false);
		activityArea.setEditable(false); 
		displayCurrentInfo();
	}

	// buttonClicked method--------------------------------------

	public void buttonClicked(JButton buttonObj) {
		if (!model.gameEnd()) {
			if (buttonObj == upButton)
				model.goUp();
	
			else if (buttonObj == downButton)
				model.goDown();
	
			else if (buttonObj == northButton)
				model.goNorth();
	
			else if (buttonObj == southButton)
				model.goSouth();
	
			else if (buttonObj == eastButton)
				model.goEast();
	
			else if (buttonObj == westButton)
				model.goWest();
	
			else if (buttonObj == grabButton1)
				grab(1);
	
			else if (buttonObj == grabButton2)
				grab(2);
	
			else if (buttonObj == dropButton1)
				drop(1);
	
			else if (buttonObj == dropButton2)
				drop(2);
			else if (buttonObj == saveButton)
				  saveWindow(); 
			else if (buttonObj == loadButton)
				//loadWindow();
				System.out.println("");
		} else {
			if (buttonObj == loadButton) {
				model.load(); 
			}
		}

		displayCurrentInfo();
	}

	//set save name and call model save
	public void save(String s) {
		save = s; 
		model.save(save);
	}

	// Private methods-------------------------------------------

	// print to text areas
	private void displayCurrentInfo() {
		viewArea.setText(model.getView());
		carryingArea.setText(model.getItems());
		activityArea.setText(model.getWallFlag());
	}

	// call to pickup item
	private void grab(int item) {
		model.pickUpItem(item);
	}

	// Left as an exercise.
	private void drop(int item) {
		model.dropItem(item);
	}
	
	//open save game window
	private void saveWindow() { 
		JFrame view = new SaveView(this); 
		view.setSize(300, 200);
		view.setVisible(true);
		view.setResizable(false);
		
	}
	
/*	private void loadWindow() {
		JFrame view = new LoadView(this); 
		view.setSize(300, 200);
		view.setVisible(true);
		view.setResizable(false);
	}*/
	

}


