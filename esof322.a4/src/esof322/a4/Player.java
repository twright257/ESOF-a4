package esof322.a4;



/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 *
 * To compile: javac AdventureGame.java To run: java AdventureGame
 *
 * The main routine is AdventureGame.main
 *
 *
 */
public class Player {

    private Room myLoc;

    private Item[] myThings = new Item[2];

    private int itemCount = 0;
    private int health = 100; 

    public void setRoom(Room r) {
        myLoc = r;
    }

    public String look() {
        return myLoc.getDesc();
    }

    public String go(int direction) {
        return myLoc.exit(direction, this);
    }

    //add to contents and remove from room 
    public void pickUp(Item i) {
        if (itemCount < 2) {
            if (i.getDesc().equals("A first aid kit")) { //do not add health kit to items
            	health = 100; 
            	if (myLoc != null) {
            		myLoc.removeItem(i); 
            	}
            } else {	//add all others 
                myThings[itemCount] = i;
                itemCount++;
                if (myLoc != null) {
            		myLoc.removeItem(i); 
            	}
            }
        }
    }

    public boolean haveItem(Item itemToFind) {
        for (int n = 0; n < itemCount; n++) {
            if (myThings[n] == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public void drop(int itemNum) {
        if (itemNum > 0 & itemNum <= itemCount) {
            switch (itemNum) {
                case 1: {
                    myLoc.addItem(myThings[0]);
                    myThings[0] = myThings[1];
                    itemCount--;
                    break;
                }
                case 2: {
                    myLoc.addItem(myThings[1]);
                    itemCount--;
                    break;
                }
            }
        }
    }

    public void setLoc(Room r) {
        myLoc = r;
    }

    public Room getLoc() {
        return myLoc;
    }

    public String showMyThings() {
        String outString = "";
        for (int n = 0; n < itemCount; n++) {
            outString = outString + Integer.toString(n + 1) + ": "
                    + myThings[n].getDesc() + "\r\n";
        }
        return outString;
    }

    public boolean handsFull() {
        return itemCount == 2;
    }

    public boolean handsEmpty() {
        return itemCount == 0;
    }

    public int numItemsCarried() {
        return itemCount;
    }
    
    public void setHealth(int h) {
    	health -= h; 
    }
    
    public int getHealth() {
    	return health; 
    }
    

}