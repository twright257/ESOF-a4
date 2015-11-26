package esof322.a4;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
     
     Update August 2010: refactored Vector contents into ArrayList<Item> contents.
      This gets rid of the use of obsolete Vector and makes it type safe.
				    
**/

// class Room


import java.util.ArrayList;
import java.util.ListIterator;

//class Room
import java.util.ArrayList;
import java.util.ListIterator;

public class Level0Room extends Room {

 private String description;

 private CaveSite[] side = new CaveSite[6];

 private ArrayList<Item> contents = new ArrayList<Item>();
 	private String roomName; 
 
 Level0Room(String name) {
     side[0] = new Wall();
     side[1] = new Wall();
     side[2] = new Wall();
     side[3] = new Wall();
     side[4] = new Wall();
     side[5] = new Wall();
     roomName = name; 
 }

 @Override
 public void setDesc(String d) {
     description = d;
 }

 @Override
 public void setSide(int direction, CaveSite m) {
     side[direction] = m;
 }

 @Override
 public void addItem(Item theItem) {
     contents.add(theItem);
 }

 @Override
 public void removeItem(Item theItem) {
     contents.remove(theItem);
 }

 @Override
 public boolean roomEmpty() {
     return contents.isEmpty();
 }

 @Override
 public Item[] getRoomContents() {
     Item[] contentsArray = new Item[contents.size()];
     contentsArray = contents.toArray(contentsArray);
     return contentsArray;
 }

 @Override
 public String enter(Player p) {
     p.setLoc(this);
     return "";
 }

 @Override
 public String exit(int direction, Player p) {
     return side[direction].enter(p);
 }

 @Override
 public String getDesc() {
     ListIterator<Item> roomContents = contents.listIterator();
     String contentString = "";
     while (roomContents.hasNext()) {
         contentString
                 = contentString + (roomContents.next()).getDesc() + " ";
     }

     return description + '\n' + '\n'
             + "Room Contents: " + contentString + '\n';
 }
 
 public String getRoomName () {
	 return roomName; 
 }

}