package esof322.a4;

	import java.util.ArrayList;
	import java.util.ListIterator;

	//class Room
	import java.util.ArrayList;
	import java.util.ListIterator;

	public class Level1Room extends Room {

	 private String description;

	 private CaveSite[] side = new CaveSite[6];

	 private ArrayList<Item> contents = new ArrayList<Item>();
	 private String roomName; 

	 Level1Room(String name) {
	     side[0] = new Wall();
	     side[1] = new Wall();
	     side[2] = new Wall();
	     side[3] = new Wall();
	     side[4] = new Wall();
	     side[5] = new Wall();
	     roomName = name; 
	 }

	 public void setDesc(String d) {
	     description = "DANGER! Spikes are coming down from the ceiling!\n" + "Get out in the next 5 Seconds!\n\n" + d;
	 }

	 public void setSide(int direction, CaveSite m) {
	     side[direction] = m;
	 }

	 public void addItem(Item theItem) {
	     contents.add(theItem);
	 }

	 public void removeItem(Item theItem) {
	     contents.remove(theItem);
	 }

	 public boolean roomEmpty() {
	     return contents.isEmpty();
	 }

	 public Item[] getRoomContents() {
	     Item[] contentsArray = new Item[contents.size()];
	     contentsArray = contents.toArray(contentsArray);
	     return contentsArray;
	 }

	 public String enter(Player p) {
	     p.setLoc(this);
	     return "";
	 }

	 public String exit(int direction, Player p) {
	     return side[direction].enter(p);
	 }

	 public String getDesc() {
	     ListIterator<Item> roomContents = contents.listIterator();
	     String contentString = "";
	     while (roomContents.hasNext()) {
	         contentString
	                 = contentString + (roomContents.next()).getDesc() + " ";
	     }
	     System.out.println(contentString); 

	     return description + '\n' + '\n'
	             + "Room Contents: " + contentString + '\n';
	 }
	 
	 public String getRoomName () {
		 return roomName; 
	 }
}
