package esof322.a4;

import java.util.ArrayList;

/**
 * Tyler Wright
 * Nov. 30, 2015
 */




/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman
     To compile: javac AdventureGame.java
     To run:     java AdventureGame
     The main routine is AdventureGame.main
                
**/

/**  Adventure Game  Program Code
Copyright (c) 1999-2012 James M. Bieman
The Adventure game is based on the "Colossal Cave Adventure" originally
designed by Will Crowther and implemented by Will Crowther
and Don Wood in Fortran in 1975 and 1976.
This micro-version is a variant of the original cave system and is implemented in Java
with just a few rooms and with a much more limited vocabulary.
Updated August 2010, January 2012
- Code is put into package cs314.a2 to match current CS314 coding standards.
Updated January 2012
- Renamed as the "Adventure Game"
To compile: javac cs314.a2.AdventureGame.java
To run:     java cs314.a2.AdventureGame
The main routine is AdventureGame.main
			    
			    **/

/** class Adventure: Primary method, createCave, creates the cave system.
        It eventually be replaced with a more flexible mechanism
        to support input and output from devices other than
        an ASCII terminal.
		Room descriptions are followed by a room identifier,
		to ease debugging and testing.  These would be removed
		to help confuse the user, which is our ultimate aim.
		I haven't added all of the room descriptions.  They
		will be done later.
		
		In this version all I/O is through standard I/O;
		I/O is to and from the console. 
*/

public class Adventure {
	private ArrayList<String> loadInfo; //load info array 
	private String start; //starting room 
  private CaveFactory f; 
  private Room entrance;
  private Player player; 
  
  public Adventure(CaveFactory f, ArrayList<String> loadInfo, Player p) {
	  this.loadInfo = loadInfo; 
	 this.f = f; 
	 this.player = p; 
	 if (loadInfo != null) {	//loading saved game 
		 this.start = loadInfo.get(1); 
	 } else {
		 this.start = "outside"; 
	 }
  }
  
  public Room createAdventure(){
    // The outside: 
      Room  outside = f.createRoomType1("outside");
      outside.setDesc(
        "You are standing outside, on the edge of a cliff,\n" +
	" A creek runs alongside the cliff.\n" + 
	"a cave opens straight down (outside).");
   
   // Room 1:
      Room r1 = f.createRoomType1("r1");
      r1.setDesc(
	 "The darkness is pierced by a bright light overhead.\n"
	 + "There is a narrow, dark passage to the east (r1)." );

   // Connect the outside to Room 1:
      outside.setSide(5,r1);
      r1.setSide(4,outside);
      entrance = outside;

   // Room 2:
      Room r2 = f.createRoomType1("r2");
      r2.setDesc(
	"You are in a gloomy oval shaped room with grey walls.\n" + 
	 "There is a dim light to the west, and a narrow\n" +
	 "dark hole to the east only about 18 inches high (r2).");

  // Room 3:
     Room r3 = f.createRoomType2("r3");
     r3.setDesc("It is pitch black. You are likely to be eaten by a grue.\n"+
		"There is a wide passage that quickly narrows\n"
		+"to the west, a bright opening to the east,\n"
		+ "and a deep hole that appears to have no bottom\n"
		+ "in the middle of the room (r3).");

  // Connect Rooms 1, 2, & 3:
     r1.setSide(2,r2);
     r2.setSide(3,r1);
     r2.setSide(2,r3);
     r3.setSide(3,r2);

  // Room 4:
     Room r4 = f.createRoomType1("r4");
     r4.setDesc("There is what looks like a giant grizzly bear\n"
		+ "skull in a corner.  A passage leads to the west,\n"
		+ "another one to the north, and a slippery route\n"
		+ "goes down steeply. You can hear the shrieks of bats (r4).");

  // Room 5:
     Room r5 = f.createRoomType2("r5");
     r5.setDesc("There is a dim light from above and the shrieks\n"
    		    + "are clearly coming from a passageway to the east (r5).");

  // Room 6:
     Room r6 = f.createRoomType1("r6");
     r6.setDesc("The ceiling is full of bats.\n"
    		     + "You should put your hat on your head (r6).");
     HealthKit kit1 = new HealthKit();
     kit1.setDesc("A first aid kit");
     r6.addItem(kit1);

  // Room 7:
     Room r7 = f.createRoomType1("r7");
     r7.setDesc("This room is very damp. There are puddles on the floor\n" +
     		"and a steady dripping from above (r7).");
     HealthKit kit2 = new HealthKit();
     kit2.setDesc("A first aid kit");
     r7.addItem(kit2);

  // Connect rooms 3, 4, 5, 6, & 7.
     r3.setSide(2,r4);
     r3.setSide(5,r5);
     r4.setSide(3,r3);
     r4.setSide(5,r7);
     r5.setSide(4,r3);
     r5.setSide(2,r6);
     r6.setSide(3,r5);
     r7.setSide(4,r4);

  // Room 8:
     Room r8 = f.createRoomType1("r8");
     r8.setDesc("A lizard scampers past you, or is it a snake?\n" +
     		"a narrow passage runs to the east and an evin narrower one\n" +
     		"runs to the west (r8).");

  // Room 9:
     Room r9 = f.createRoomType2("r9");
     r9.setDesc("This room is dimly lit from a flickering candle.\nDoesn't seem to be anything of interest in here (r9).");

  // Room 10:
     Room r10 = f.createRoomType1("r10");
     r10.setDesc("It looks like someone has been here.\n" +
     		"There is a pile of candy wrappers on the floor,\n" +
     		"and maybe something else. \n" +
     		"Wait, there is a trap door on the floor,\n" +
     		"but it is locked (r10).");

 // Room 11:
    Room r11 = f.createRoomType1("r11");
    r11.setDesc("This room is very dark. You can just barely see (r11).");
    Treasure theTreasure = new Treasure();
    theTreasure.setDesc("A bag filled with gold bars.");
    r11.addItem(theTreasure);

 // Lets connect them:
    r4.setSide(0,r8);
    r8.setSide(1,r4);
    r8.setSide(3,r9);
    r8.setSide(2,r10);
    r9.setSide(2,r8);
    r10.setSide(3,r8);

 // Create a key and put it in r6:
    Key theKey = new Key();
    theKey.setDesc("A shiny gold key.");
    r6.addItem(theKey);

 // We add a door between r10 and r11: 
    Door theDoor = new Door(r10,r11,theKey);
    r10.setSide(5,theDoor);
    r11.setSide(4,theDoor);

    //configure loaded settings
    if (loadInfo != null) {	
    	if (loadInfo.size() == 3) {	//no items 
    		player.setHealth(100 - Integer.valueOf(loadInfo.get(2)));
    	} else if (loadInfo.size() == 4) {	//1 item 
    		player.setHealth(100 - Integer.valueOf(loadInfo.get(3)));
    		if (loadInfo.get(2).equals("1: A shiny gold key.")) {	//first item is key 
    			player.pickUp(theKey);
    			r6.removeItem(theKey);
    		} else {
    			player.pickUp(theTreasure);
    			r11.removeItem(theTreasure);
    		}
    	} else if (loadInfo.size() == 5) {	//2 items
    		player.setHealth(100 - Integer.valueOf(loadInfo.get(4)));
    		if (loadInfo.get(2).equals("1: A shiny gold key.")) {	//first item slot is key 
    			player.pickUp(theKey);
    			player.pickUp(theTreasure);
    		} else {
    			player.pickUp(theTreasure);
    			player.pickUp(theKey);
    		}
    		r6.removeItem(theKey);
    		r11.removeItem(theTreasure);
    	}
    }
    
    
 // Now return the entrance:
    if (start.equals("outside"))
    	entrance = outside; 
    else if (start.equals("r1"))
    	entrance = r1; 
    else if (start.equals("r2"))
    	entrance = r2;
    else if (start.equals("r3"))
    	entrance = r3;
    else if (start.equals("r4"))
    	entrance = r4;
    else if (start.equals("r5"))
    	entrance = r5;
    else if (start.equals("r6"))
    	entrance = r6;
    else if (start.equals("r7"))
    	entrance = r7;
    else if (start.equals("r8"))
    	entrance = r8;
    else if (start.equals("r9"))
    	entrance = r9;
    else if (start.equals("r10"))
    	entrance = r10;
    else if (start.equals("r11"))
    	entrance = r11;
    
    
    return entrance;

  }
}
