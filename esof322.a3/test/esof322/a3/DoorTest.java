package esof322.a3;

/**
 * Tyler Wright
 * Oct. 26, 2015
 * DoorTest method tests methods in Door class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoorTest {
    Room r1; 
    Room r2; 
    Wall w1; 
    Key k1; 
    Player p; 

	@Before
	public void setUp() throws Exception {
	    r1 = new Room(); 
	    r2 = new Room(); 
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
