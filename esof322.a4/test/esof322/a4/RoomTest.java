package esof322.a4;

/**
 * Tyler Wright
 * Oct. 26, 2015
 * RoomTest method tests methods in Room class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import esof322.a4.Item;
import esof322.a4.Player;
import esof322.a4.Level0Room;

public class RoomTest {
	Player p; 
	Item item; 
	Level0Room room; 

	@Before
	public void setUp() throws Exception {
		p = new Player(); 
		item = new Item(); 
		room = new Level0Room(""); 
		p.setLoc(room);
	}
	
	/**
	 * Test of setSide method, of class Room.
	 */
	@Test
	public void testSetSide() {
		System.out.println("set side"); 
		Level0Room r2 = new Level0Room(""); 
		Level0Room r3 = new Level0Room(""); 
		room.setSide(0, r2); 
		room.setSide(1,  r3); 
		room.exit(0, p);
		assertEquals("location = r2", r2, p.getLoc()); 
		room.exit(1, p);
		assertEquals("location = r3", r3, p.getLoc()); 
	}
	
	/**
	 * Test of getRoomContents method, of class Room.
	 */
	@Test
	public void testGetRoomContents() {
		System.out.println("get room contents"); 
		Item[] contents = room.getRoomContents(); 
		assertEquals("contents empty", 0, contents.length); 
	}

    /**
     * Test of addItem method, of class Room.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        //room empty
        Item[] c = room.getRoomContents(); 
        assertEquals("room empty", 0, c.length); 
        //test on 1 item 
        room.addItem(item);
        Item[] contents = room.getRoomContents(); 
        assertEquals("first item matches expected", item, contents[0]); 
        //test on 2 items
        room.addItem(item); 
        Item[] contents2 = room.getRoomContents(); 
        assertEquals("second item matches expected", item, contents2[1]); 
    }

    /**
     * Test of removeItem method, of class Room.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        //first, add 2 items
        room.addItem(item);
        room.addItem(item);
        //remove first item 
        room.removeItem(item);
        Item[] contents = room.getRoomContents(); 
        assertEquals("only 1 item in contents,", 1, contents.length); //check that size is 1
        //remove second item 
        room.removeItem(item);
        contents = room.getRoomContents(); 
        assertEquals("contents empty", 0, contents.length); //check that size is 0
        //test removal on empty
        room.removeItem(item);
    }


    /**
     * Test of enter method, of class Room.
     */
    @Test
    public void testEnter() {
        System.out.println("enter");
        p.setLoc(null); 
        assertEquals("location null", null, p.getLoc()); 
        room.enter(p);
        assertEquals("room set to new location", room, p.getLoc()); 
    }

    /**
     * Test of exit method, of class Room.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        int direction = 0;
        p.setLoc(room); 
        assertEquals("room", room, p.getLoc()); 
        Level0Room r2 = new Level0Room(""); 
        room.setSide(direction, r2);
        room.exit(direction, p);
        assertEquals("successfully exit", r2, p.getLoc());
    }    
}



