
package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

	Ocean ocean;
	Ship ship;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	
	//Tests length of Battleship
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());
  }
	//Tests length of EmptySea
	void testGetLength() {
		ship = new EmptySea();
		assertEquals(1, ship.getLength());
  }
	//Tests length of Cruiser
	void testGetLength() {
		ship = new EmptySea();
		assertEquals(3, ship.getLength());
  }
	//Tests length of Destroyer
	void testGetLength() {
		ship = new EmptySea();
		assertEquals(2, ship.getLength());
	}

	@Test
	
	//Tests GetBowRow for EmptySea
	void testGetBowRow() {
		Ship emptysea = new EmptySea();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, emptysea.getBowRow());
  }
	
	//Tests GetBowRow for Battleship
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
  }
  
  //Tests GetBowRow for Cruiser
	void testGetBowRow() {
		Ship cruiser = new Cruiser();
		int row = 0;
		int column = 3;
		boolean horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, cruiser.getBowRow());
  }

  //Tests GetBowRow for Destroyer
	void testGetBowRow() {
		Ship destroyer = new Destroyer();
		int row = 0;
		int column = 2;
		boolean horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, destroyer.getBowRow());
	}

	@Test
  
  //Tests GetBowColumn for Battleship
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());	
		
	}
  
  //Tests GetBowColumn for EmptySea
	void testGetBowColumn() {
		Ship emptysea = new EmptySea();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		emptysea.setBowColumn(column);
		assertEquals(column, emptysea.getBowColumn());	
		
	}
  
  //Tests GetBowColumn for Cruiser
	void testGetBowColumn() {
		Ship cruiser = new Cruiser();
		int row = 0;
		int column = 3;
		boolean horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		crusier.setBowColumn(column);
		assertEquals(column, cruiser.getBowColumn());	
		
	}
  
  //Tests GetBowColumn for Destroyer
	void testGetBowColumn() {
		Ship destroyer = new Destroyer();
		int row = 0;
		int column = 2;
		boolean horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		destroyer.setBowColumn(column);
		assertEquals(column, destroyer.getBowColumn());	
		
	}


	@Test
	
  //Tests GetHit on Battleship
  void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

	}
  
  //Tests GetHit on Destroyer
  void testGetHit() {
		ship = new Destroyer();
		boolean[] hits = new boolean[2];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

	}

  //Tests GetHit on Cruiser
  void testGetHit() {
		ship = new Cruiser();
		boolean[] hits = new boolean[3];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

	}
  
  //Tests GetHit on Submarine
  void testGetHit() {
		ship = new Cruiser();
		boolean[] hits = new boolean[1];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

	}

	@Test
  
  //Test whether the ship is aligned horizontally
	void testIsHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());
    
  }
  
   //Test whether the ship is aligned horizontally
   void testIsHorizontal() {
		Ship emptySea = new EmptySea();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		assertTrue(emptysea.isHorizontal());
     
   }
     
   //Test whether Empty Sea is aligned horizontally. Should return False.
   void testIsHorizontal() {
		Ship emptysea = new EmptySea();
		int row = 1;
		int column = 0;
		boolean horizontal = false;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		assertFalse(emptysea.isHorizontal());
     
   }
  
     
   //Test whether the ship is aligned horizontally. Should return False.
   void testIsHorizontal() {
		Ship destroyer = new Destroyer();
		int row = 2;
		int column = 0;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertFalse(destroyer.isHorizontal());
			
	}

	@Test
     
  //Test to see whether whether GetShipType returns the correct type. 
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());
		
	}
     
  //Test to see whether whether GetShipType returns the correct type. 
	void testGetShipType() {
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());
		
	}
     
  //Test to see whether whether GetShipType returns the correct type. 
	void testGetShipType() {
		ship = new Cruiser();
		assertEquals("cruiser", ship.getShipType());
		
	}     

  //Test to see whether whether GetShipType returns the correct type. 
	void testGetShipType() {
		ship = new EmptySea();
		assertEquals("EmptySea", ship.getShipType());
		
	}  
     

	@Test
     
  //Test to see whether the SetBowRow function goes to the proper row. 
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowRow(row);
		assertEquals(row, battleship.getBowRow());
		
	}
  //Test to see whether the SetBowRow function goes to the proper row. 
	void testSetBowRow() {
		Ship cruiser = new Cruiser();
		int row = 1;
		int column = 3;
		boolean horizontal = true;
		cruiser.setBowRow(row);
		assertEquals(row, cruiser.getBowRow());
		
  }

  //Test to see whether the SetBowRow function goes to the proper row. 
	void testSetBowRow() {
		Ship emptysea = new EmptySea();
		int row = 5;
		int column = 1;
		boolean horizontal = true;
		emptysea.setBowRow(row);
		assertEquals(row, emptysea.getBowRow());
		
	}
     
  //Test to see whether the SetBowRow function goes to the proper row. 
	void testSetBowRow() {
		Ship submarine = new Battleship();
		int row = 3;
		int column = 2;
		boolean horizontal = true;
		submarine.setBowRow(row);
		assertEquals(row, submarine.getBowRow());
		
	}

	@Test
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int row = 1;
		int column = 2;
		boolean horizontal = true;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());
		
	}
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
	void testSetBowColumn() {
		Ship submarine = new Submarine();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		submarine.setBowColumn(column);
		assertEquals(column, submarine.getBowColumn());
    
  }
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
	void testSetBowColumn() {
		Ship cruiser = new Cruiser();
		int row = 0;
		int column = 3;
		boolean horizontal = true;
		cruiser.setBowColumn(column);
		assertEquals(column, cruiser.getBowColumn());
    
  }
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
	void testSetBowColumn() {
		Ship destroyer = new Destroyer();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		destroyer.setBowColumn(column);
		assertEquals(column, destroyer.getBowColumn());
    
  }

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());
		
		//TODO
		//More tests
	}

	@Test
	void testOkToPlaceShipAt() {
		
		//test when other ships are not in the ocean
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");
		
		//TODO
		//More tests
	}
	
	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {
		
		//test when other ships are in the ocean
		
		//place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		//test second ship
		Battleship battleship2 = new Battleship();
		row = 1;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");
		
		//TODO
		//More tests
	}

	@Test
	void testPlaceShipAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);
		

		//TODO
		//More tests
	}

	@Test
	void testShootAt() {
		
		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = {false, false, false, false};
		assertArrayEquals(hitArray0, battleship.getHit());
		
		//TODO
		//More tests
	}
	
	@Test
	void testIsSunk() {
		
		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());
		
		//TODO
		//More tests
		
	}

	@Test
	void testToString() {
		
		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());
		
		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());
		
		//TODO
		//More tests
	}

}