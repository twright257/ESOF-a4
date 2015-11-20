package esof322.a4;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/

//class Door
public class Door implements CaveSite {

 /**
  * In this implementation doors are always locked. A player must have the
  * correct key to get through a door. Doors automatically lock after a
  * player passes through.
  */

 private Key myKey;

 /**
  * The door's location.
  */
 private CaveSite outSite;
 private CaveSite inSite;

 /**
  * We can construct a door at the site.
  */
 Door(CaveSite out, CaveSite in, Key k) {
     outSite = out;
     inSite = in;
     myKey = k;
 }

 /**
  * A player will need the correct key to enter.
  */
 public String enter(Player p) {
     String works = "Your key works! The door creaks open,\n" + "and slams behind you after you pass through.\n";
     String doesnt = "You don't have the key for this door!\n" + "Sorry\n"; 
     if (p.haveItem(myKey)) {
         
//         System.out.println(works);
         if (p.getLoc() == outSite) {
             inSite.enter(p);
         } else if (p.getLoc() == inSite) {
             outSite.enter(p);
         }
         return works; 
     } else {
//         System.out.println(doesnt);
         return doesnt; 
     }
 }

}