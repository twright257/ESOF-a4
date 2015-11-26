package esof322.a4;

/**
 * Tyler Wright
 * Oct. 26, 2015
 * DoorTest method tests methods in Door class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import esof322.a4.Door;
import esof322.a4.Key;
import esof322.a4.Player;
import esof322.a4.Level0Room;
import esof322.a4.Wall;

public class DoorTest {
    Level0Room r1; 
    Level0Room r2; 
    Wall w1; 
    Key k1; 
    Player p; 

	@Before
	public void setUp() throws Exception {
	    r1 = new Level0Room(""); 
	    r2 = new Level0Room(""); 
	    w1 = new Wall(); 
	    k1 = new Key(); 
	    p = new Player(); 
	}

    /**
     * Test of enter method, of class Door.
     */
    @Test
    public void testEnter() {
        System.out.println("enter");
        r1.addItem(k1);
        p.setLoc(r1);
        //player without key r1 to r2
        Door instance = new Door(r1, r2, k1);
        instance.enter(p);
        assertEquals("did not go through door", r1, p.getLoc()); 
        //player with key r1 to r2
        p.pickUp(k1);
        instance.enter(p);
        assertEquals("go through door", r2, p.getLoc());
        
        r2.addItem(k1);
        p.drop(1);
        p.setLoc(r2);
        //player without key r2 to r1
        instance.enter(p);
        assertEquals("did not go through door", r2, p.getLoc());
        //player with key r2 to r1
        p.pickUp(k1);
        instance.enter(p);
        assertEquals("go through door", r1, p.getLoc()); 
    }

}
