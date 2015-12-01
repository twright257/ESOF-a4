package esof322.a4;

import java.util.ListIterator;

/**
 * Tyler Wright
 * Nov. 30, 2015
 * abstract class that is extended by the level0 and level1 rooms 
 *
 */

public abstract class Room implements CaveSite{
	 abstract void setDesc(String d);
	 
	 abstract void setSide(int direction, CaveSite m);

	 abstract void addItem(Item i);

	 abstract void removeItem(Item theItem);

	 abstract boolean roomEmpty();

	 abstract Item[] getRoomContents();

	 public String enter(Player p) {
	     p.setLoc(this);
	     return "";
	 }

	 abstract String exit(int direction, Player p);

	 abstract String getDesc();
	 
	 abstract String getRoomName();

}
