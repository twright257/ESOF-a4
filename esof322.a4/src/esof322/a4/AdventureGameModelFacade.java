package esof322.a4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class AdventureGameModelFacade {

    // some private fields to reference current location,
    // its description, what I'm carrying, etc.
    //
    // These methods and fields are left as exercises.
	private ArrayList<String> loadInfo; 
    private Player thePlayer;
    private String interText = ""; //interaction info
    private CaveFactory f; 
    private boolean gameEnd = false; 

    AdventureGameModelFacade(int type, ArrayList<String> loadInfo) { // we initialize
    	this.loadInfo = loadInfo; 
        thePlayer = new Player();
        if (type == 2) {
        	this.f = new FactoryCreator(Integer.valueOf(loadInfo.get(0))).createFactory(); 
        	Adventure theCave = new Adventure(f, loadInfo.get(1)); 
        	Room startRm = theCave.createAdventure(); 
        	thePlayer.setRoom(startRm);
        } else {
        	this.f = new FactoryCreator(type).createFactory(); 
        	Adventure theCave = new Adventure(f, "outside");
            Room startRm = theCave.createAdventure();
            thePlayer.setRoom(startRm);
        }
        
    }
    
    //return it game has ended
    public boolean gameEnd() {
    	return gameEnd; 
    }

    //Moves player "up" a room
    public void goUp() {
        interText = thePlayer.go(4);
    }

    //Moves player "down" a room
    public void goDown() {
        interText = thePlayer.go(5);
    }

    //Moves player "north" a room
    public void goNorth() {
        interText = thePlayer.go(0);
    }

    //Moves player "south" a room
    public void goSouth() {
        interText = thePlayer.go(1);
    }

    //Moves player "east" a room
    public void goEast() {
        interText = thePlayer.go(2);
    }

    //Moves player "west" a room
    public void goWest() {
        interText = thePlayer.go(3);
    }

    // You need to finish these getView and getItems methods.
    public String getView() {
        return thePlayer.look();
    }

    //Returns a string of items that the player is holding
    public String getItems() {
        return thePlayer.showMyThings();
    }

    //return interaction info 
    public String getWallFlag() {
    	if (thePlayer.getHealth() <= 0) {
    		gameOver(); 
    		return "Game Over"; 
    	}
        return "Health: " + thePlayer.getHealth() + "\n" + interText;
    }

    //pickup item 1 or 2 
    public void pickUpItem(int item) {
        pickUpItem(item, thePlayer);
    }

    //check if item exists, add to inventory and remove from room 
    public void pickUpItem(int itemNum, Player p) {
        Item[] contentsArray = (p.getLoc()).getRoomContents(); //array of room contents

        if (thePlayer.handsFull()) { //inventory full 
            interText += "Your hands are full.\n";
        } else if ((thePlayer.getLoc()).roomEmpty()) { //nothing in room 
            interText += "The room is empty.\n";
        } else if (itemNum <= contentsArray.length) { //item choice exists in room 
            Item itemToGrab = contentsArray[itemNum - 1];
            thePlayer.pickUp(itemToGrab);
            (thePlayer.getLoc()).removeItem(itemToGrab);
            interText += "Item picked up.\n";
        }
    }

    //Drops item overloaded method
    public void dropItem(int item) {
        dropItem(item, thePlayer);

    }

    //Drops items by calling player.drop()
    public void dropItem(int item, Player p) {
        if (p.handsEmpty()) { //Make sure inventory is not empty
            interText += "Drop what? Your hands?\n";
        }
        else if (p.numItemsCarried() == 1 && item == 2){ //Make sure that you're holding the item in the correct hand
            interText += "That item is in your other hand.\n";
        } else {
            p.drop(item);
        }
    }
    
    //called if health runs out
    public void gameOver() {
    	interText = "Game Over";
    	thePlayer.getLoc().setDesc("Game Over");
    	gameEnd = true; 
    }
    
    
    //method for saving game
    public void save(String saveName) {
    	String fullSave = ""; 
    	String location = thePlayer.getLoc().getRoomName();
    	String things = thePlayer.showMyThings(); 
    	String type= ""; 
    	if (f.getClass().getSimpleName().equals("Level0Factory")) {
    		type = "0"; 
    	} else {
    		type = "1"; 
    	}
    	fullSave = type + "\r\n" + location + "\r\n" + things; 
    	String fileName = "SaveStuff/" + saveName + ".txt"; 
    	PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	writer.println(fullSave);
    	writer.close();

    }
    
    //method for loading game 
    public void load() {
    	
    }
    
}