package esof322.a4;

/**
 * Tyler Wright
 * Oct. 26, 2015
 * PlayerTest class tests methods in player class 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import esof322.a4.Item;
import esof322.a4.Player;
import esof322.a4.Level0Room;

public class PlayerTest {
	Player p; 
	Item item; 
	Level0Room r1; 
	
	@Before
	public void setUp() throws Exception {
		p = new Player(); 
		item = new Item(); 
		item.setDesc("key");
		r1 = new Level0Room(""); 
	}
	
    /**
     * Test of getLocation method, of class Player.
     */
    @Test
    public void testGetLocation() {
        System.out.println("get location");
        //location null
        assertNull(p.getLoc()); 
    }
	
    /**
     * Test of setLocation method, of class Player.
     */
    @Test
    public void testSetLocation() {
        System.out.println("set location");
        //location null
        assertNull(p.getLoc()); 
        p.setLoc(r1);
        //location equal to r1
        assertEquals("location = r1", r1, p.getLoc()); 
    }

    /**
     * Test of go method, of class Player.
     */
    @Test
    public void testGo() {
        System.out.println("go");
        int direction = 0;
        p.setLoc(r1);
        Level0Room r2 = new Level0Room(""); 
        r1.setSide(0, r2);
        p.go(direction);
        //test that player now in location corresponding to direction 
        assertEquals("new location r2", r2, p.getLoc()); 
        //test go in wall direction 
        p.go(1);
        assertEquals("player did not move from r2", r2, p.getLoc()); 
    }

    /**
     * Test of showMyThings method, of class Player.
     */
    @Test
    public void testShowMyThings() {
        System.out.println("show my things");
        assertEquals("no items", "", p.showMyThings()); 
    }
    
    /**
     * Test of pickUp method, of class Player.
     */
    @Test
    public void testPickUp() {
        System.out.println("pickUp");
        r1.addItem(item);
        p.setLoc(r1);
        assertEquals("no items", "", p.showMyThings()); 
        //1 item picked up
        p.pickUp(item);
        assertEquals("key in items", "1: key ", p.showMyThings()); 
        //2 items picked up
        p.pickUp(item);
        assertEquals("two keys in items", "1: key 2: key ", p.showMyThings()); 
        //3rd pickup attempt
        p.pickUp(item);
        assertEquals("two keys in items", "1: key 2: key ", p.showMyThings()); 
    }



    /**
     * Test of drop method, of class Player.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        p.setLoc(r1);
        r1.addItem(item);
        //drop with no items
        p.drop(0);
        p.drop(1);
        assertEquals("no items", "", p.showMyThings()); 
        //drop with 1 item 
        p.pickUp(item);
        assertEquals("key in items", "1: key ", p.showMyThings()); 
        p.drop(2);
        assertEquals("key in items", "1: key ", p.showMyThings()); 
        p.drop(1);
        assertEquals("key not in items", "", p.showMyThings()); 
        //drop with 2 items
        p.pickUp(item);
        p.pickUp(item);
        assertEquals("2 key in items", "1: key 2: key ", p.showMyThings()); 
        p.drop(2);
        assertEquals("key in items", "1: key ", p.showMyThings()); 
        p.drop(1);
        assertEquals("key not in items", "", p.showMyThings()); 
    }
    


}
