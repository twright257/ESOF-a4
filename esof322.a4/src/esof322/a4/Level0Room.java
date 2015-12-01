package esof322.a4;

/**  
	Easy difficulty room maintains normal adventure game function 
				    
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
 private ArrayList<Item> contents = new ArrayList<Item>();	//items in room 
 private String roomName; //name of room 
 
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
 //remove item from room if item is in room 
 public void removeItem(Item theItem) {
	 if (contents.contains(theItem)) {
		 contents.remove(theItem);
	 }
 }

 @Override
 public boolean roomEmpty() {
     return contents.isEmpty();
 }

 @Override
 //return contents of room 
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
 //return description of room and contents
 public String getDesc() {
     ListIterator<Item> roomContents = contents.listIterator();
     String contentString = "";
     while (roomContents.hasNext()) {
         contentString
                 = contentString + (roomContents.next()).getDesc() + "\n";
     }

     return description + '\n' + '\n'
             + "Room Contents: " + contentString + '\n';
 }
 
 //return name of room 
 public String getRoomName () {
	 return roomName; 
 }
 
 

}