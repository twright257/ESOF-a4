package esof322.a4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class AdventureGameModelFacade {

    // some private fields to reference current location,
    // its description, what I'm carrying, etc.
    //
    // These methods and fields are left as exercises.
    private Player thePlayer;
    private String interText = ""; //interaction info
    private CaveFactory f; 

    AdventureGameModelFacade(int type) { // we initialize
        thePlayer = new Player();
        this.f = new FactoryCreator(type).createFactory(); 
        Adventure theCave = new Adventure(f);
        Room startRm = theCave.createAdventure();
        thePlayer.setRoom(startRm);
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
        return interText;
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
    
    public void save(String saveName) {
    	String fullSave = ""; 
    	String location = thePlayer.getLoc().getRoomName();
    	String things = thePlayer.showMyThings(); 
    	fullSave = saveName + "\n" + f.getClass().getSimpleName() + "\n" + location + "\n" + things; 
    	PrintWriter writer = null;
		try {
			writer = new PrintWriter("SaveStuff/TESTING.txt", "UTF-8");
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
    
    public void load() {
    	
    }
    
}