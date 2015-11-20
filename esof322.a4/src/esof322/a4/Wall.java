package esof322.a4;

//Michael Shihrer
//Andrew Mueller
//Tyler Wright

package esof322.a2;

/**
* Adventure Game Program Code Copyright (c) 1999 James M. Bieman
*
* To compile: javac AdventureGame.java To run: java AdventureGame
*
* The main routine is AdventureGame.main
*
*
*/
//class Wall
public class Wall implements CaveSite {

  public String enter(Player p) {
      String isWall = "Ouch! That hurts.\n";
//      System.out.println(isWall);
      return isWall;
  }

}