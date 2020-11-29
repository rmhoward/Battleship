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

		//Tests length of EmptySea
		ship = new EmptySea();
		assertEquals(1, ship.getLength());

		//Tests length of Cruiser
		ship = new EmptySea();
		assertEquals(3, ship.getLength());

		//Tests length of Destroyer
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

		//Tests GetBowRow for Battleship
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());

		//Tests GetBowRow for Cruiser
		Ship cruiser = new Cruiser();
		int row = 0;
		int column = 3;
		boolean horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, cruiser.getBowRow());

		//Tests GetBowRow for Destroyer
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


		//Tests GetBowColumn for EmptySea
		Ship emptysea = new EmptySea();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		emptysea.setBowColumn(column);
		assertEquals(column, emptysea.getBowColumn());

		//Tests GetBowColumn for Cruiser
		Ship cruiser = new Cruiser();
		int row = 0;
		int column = 3;
		boolean horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		crusier.setBowColumn(column);
		assertEquals(column, cruiser.getBowColumn());


		//Tests GetBowColumn for Destroyer
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

		//Tests GetHit on Destroyer
		ship = new Destroyer();
		boolean[] hits = new boolean[2];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

		//Tests GetHit on Cruiser
		ship = new Cruiser();
		boolean[] hits = new boolean[3];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

		//Tests GetHit on Submarine
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

		//Test whether the ship is aligned horizontally
		Ship emptySea = new EmptySea();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		assertTrue(emptysea.isHorizontal());

		//Test whether Empty Sea is aligned horizontally. Should return False.
		Ship emptysea = new EmptySea();
		int row = 1;
		int column = 0;
		boolean horizontal = false;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		assertFalse(emptysea.isHorizontal());

		//Test whether the ship is aligned horizontally. Should return False.
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

		//Test to see whether whether GetShipType returns the correct type.
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());

		//Test to see whether whether GetShipType returns the correct type.
		ship = new Cruiser();
		assertEquals("cruiser", ship.getShipType());

		//Test to see whether whether GetShipType returns the correct type.
		ship = new EmptySea();
		assertEquals("EmptySea", ship.getShipType());
		
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
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
		Ship submarine = new Submarine();
		int row = 0;
		int column = 1;
		boolean horizontal = true;
		submarine.setBowColumn(column);
		assertEquals(column, submarine.getBowColumn());
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
		Ship cruiser = new Cruiser();
		int row = 0;
		int column = 3;
		boolean horizontal = true;
		cruiser.setBowColumn(column);
		assertEquals(column, cruiser.getBowColumn());
    
  //Test to see whether the SetBowColumn function goes to the proper column. 
		Ship destroyer = new Destroyer();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		destroyer.setBowColumn(column);
		assertEquals(column, destroyer.getBowColumn());
    
  }
	
  //Test to see whether the ship is aligned horizontally.
	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());
		
		Ship submarine = new Submarine();
		int row = 1;
		int column = 1;
		boolean horizontal = true;
		submarine.setHorizontal(horizontal);
		assertTrue(submarine.isHorizontal());
    
 		Ship cruiser = new Cruiser();
		int row = 3;
		int column = 0;
		boolean horizontal = false;
		cruiser.setHorizontal(horizontal);
		assertFalse(cruiser.isHorizontal());  
    
    Ship cruiser = new Destroyer();
		int row = 3;
		int column = 5;
		boolean horizontal = true;
		cruiser.setHorizontal(horizontal);
		assertTrue(cruiser.isHorizontal());   
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
		
    Ship submarine = new Submarine();
		int row = 0;
		int column = 0;
		boolean horizontal = true;
		boolean ok = submarine.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");

    Ship destroyer = new Destroyer();
		int row = 0;
		int column = 2;
		boolean horizontal = true;
		boolean ok = destroyer.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");

    Ship cruiser = new Cruiser();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		boolean ok = cruiser.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok, "OK to place ship here.");

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
    
    //test third ship
		Cruiser cruiser1 = new Cruiser();
		row = 7;
		column = 4;
		horizontal = true;
		boolean ok1 = cruiser1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		cruiser1.placeShipAt(row, column, horizontal, ocean);
    
    //test EmptySea
		Emptysea emptysea = new EmptySea();
		row = 2;
		column = 4;
		horizontal = true;
    boolean ok1 = emptysea.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		emptysea.placeShipAt(row, column, horizontal, ocean);
		
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
		
		Ship submarine = new Submarine();
		int row = 0;
		int column = 8;
		boolean horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, submarine.getBowRow());
		assertEquals(column, submarine.getBowColumn());
		assertTrue(submarine.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(submarine, ocean.getShipArray()[0][1]);
    
    Ship destroyer = new Destroyer();
		int row = 9;
		int column = 9;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, destroyer.getBowRow());
		assertEquals(column, destroyer.getBowColumn());
		assertTrue(destroyer.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(submarine, ocean.getShipArray()[0][1]);

    Ship emptysea = new EmptySea();
		int row = 7;
		int column = 5;
		boolean horizontal = false;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, emptysea.getBowRow());
		assertEquals(column, emptysea.getBowColumn());
		assertTrue(emptysea.isHorizontal());
		
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(semptysea, ocean.getShipArray()[0][1]);
	}


		@Test

		//Test to see whether the SetBowColumn function goes to the proper column.
		void testSetBowColumn () {
			Ship battleship = new Battleship();
			int row = 1;
			int column = 2;
			boolean horizontal = true;
			battleship.setBowColumn(column);
			assertEquals(column, battleship.getBowColumn());

			//Test to see whether the SetBowColumn function goes to the proper column.
			Ship submarine = new Submarine();
			int row = 0;
			int column = 1;
			boolean horizontal = true;
			submarine.setBowColumn(column);
			assertEquals(column, submarine.getBowColumn());

			//Test to see whether the SetBowColumn function goes to the proper column.
			Ship cruiser = new Cruiser();
			int row = 0;
			int column = 3;
			boolean horizontal = true;
			cruiser.setBowColumn(column);
			assertEquals(column, cruiser.getBowColumn());

			//Test to see whether the SetBowColumn function goes to the proper column.
			Ship destroyer = new Destroyer();
			int row = 0;
			int column = 4;
			boolean horizontal = true;
			destroyer.setBowColumn(column);
			assertEquals(column, destroyer.getBowColumn());

		}

		@Test
		void testSetHorizontal () {
			Ship battleship = new Battleship();
			int row = 0;
			int column = 4;
			boolean horizontal = true;
			battleship.setHorizontal(horizontal);
			assertTrue(battleship.isHorizontal());

			//Tests whether changing the setting to False works for isHorizontal
			Ship submarine = new Submarine();
			int row = 0;
			int column = 0;
			boolean horizontal = false;
			submarine.setHorizontal(horizontal);
			assertFalse(submarine.isHorizontal());
			
			//Tests whether placing the ship off the gameboard returns False for isHorizontal
			Ship destroyer = new Destroyer();
			int row = -1;
			int column = 0;
			boolean horizontal = false;
			destoyer.setHorizontal(horizontal);
			assertFalse(destroyer.isHorizontal());
			
			//Tests whether changing the setting to False works for isHorizontal
			Ship submarine = new Submarine();
			int row = 0;
			int column = 0;
			boolean horizontal = false;
			submarine.setHorizontal(horizontal);
			assertFalse(submarine.isHorizontal());

		}

		@Test
		void testOkToPlaceShipAt () {

			//test when other ships are not in the ocean
			Ship battleship = new Battleship();
			int row = 0;
			int column = 4;
			boolean horizontal = true;
			boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
			assertTrue(ok, "OK to place ship here.");

			//test whether method determines EmptySea is a ship for the purpsoes of placement
			Ship emptysea = new EmptySea();
			int row = 0;
			int column = 0;
			boolean horizontal = true;
			boolean ok = emptysea.okToPlaceShipAt(row, column, horizontal, ocean);
			assertTrue(ok, "OK to place ship here.");
			
			//test whether method prevents placing ships off the gameboard
			Ship cruiser = new Cruiser();
			int row = 9;
			int column = 9;
			boolean horizontal = true;
			boolean ok = cruiser.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok, "OK to place ship here.");
			
			//test whether method prevents placing ships off the gameboard
			Ship battleship = new Battleship();
			int row = 9;
			int column = 8;
			boolean horizontal = true;
			boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok, "OK to place ship here.");
		}

		@Test
		void testOkToPlaceShipAtAgainstOtherShipsOneBattleship () {

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
			
			//test third ship
			Battleship battleship2 = new Battleship();
			row = 1;
			column = 8;
			horizontal = true;
			boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok2, "Not OK to place ship diagonally adjacent below.");
			
			//test fourth ship
			Battleship battleship2 = new Battleship();
			row = 0;
			column = 8;
			horizontal = true;
			boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok2, "Not OK to place ship horizontally adjacent below.");
			

		}

		@Test
		void testPlaceShipAt () {

			//Tests methods properly places ships on grid. 
			Ship battleship = new Battleship();
			int row = 0;
			int column = 4;
			boolean horizontal = true;
			battleship.placeShipAt(row, column, horizontal, ocean);
			assertEquals(row, battleship.getBowRow());
			assertEquals(column, battleship.getBowColumn());
			assertTrue(battleship.isHorizontal());
			
			//Tests methods properly places ships on grid. 
			Ship submarine = new submarine();
			int row = 5;
			int column = 4;
			boolean horizontal = true;
			submarine.placeShipAt(row, column, horizontal, ocean);
			assertEquals(row, submarine.getBowRow());
			assertEquals(column, submarine.getBowColumn());
			assertTrue(submarine.isHorizontal());

			assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
			assertEquals(submarine, ocean.getShipArray()[0][1]);
			
			//Test method doesn't work when trying to place ships off grid. 
			Ship battleship = new Battleship();
			int row = 11;
			int column = 11;
			boolean horizontal = true;
			battleship.placeShipAt(row, column, horizontal, ocean);
			assertEquals(row, battleship.getBowRow());
			assertEquals(column, battleship.getBowColumn());
			assertTrue(battleship.isHorizontal());

			assertFalse("empty", ocean.getShipArray()[0][0].getShipType());
			assertFalse(battleship, ocean.getShipArray()[0][1]);
			
			//Test method doesn't work when trying to place battleship on edge of gameboard
			Ship battleship = new Battleship();
			int row = 9;
			int column = 9;
			boolean horizontal = true;
			battleship.placeShipAt(row, column, horizontal, ocean);
			assertEquals(row, battleship.getBowRow());
			assertEquals(column, battleship.getBowColumn());
			assertTrue(battleship.isHorizontal());

			assertFalse("empty", ocean.getShipArray()[0][0].getShipType());
			assertFalse(battleship, ocean.getShipArray()[0][1]);

		}

		@Test
		void testShootAt () {

			//Tests whethere complete misses are properly detected. 
			Ship battleship = new Battleship();
			int row = 0;
			int column = 9;
			boolean horizontal = true;
			battleship.placeShipAt(row, column, horizontal, ocean);

			assertFalse(battleship.shootAt(1, 9));
			boolean[] hitArray0 = {false, false, false, false};
			assertArrayEquals(hitArray0, battleship.getHit());

			//Tests whether emptysea override on ShootAt works.
			Ship emptysea = new EmptySea();
			int row = 1;
			int column = 1;
			boolean horizontal = true;
			emptysea.placeShipAt(row, column, horizontal, ocean);

			assertFalse(emptysea.shootAt(1, 1));
			boolean[] hitArray0 = {false};
			assertArrayEquals(hitArray0, emptysea.getHit());
			
			//Tests whether ShootAt works on submarine.
			Ship submarine = new Submarine();
			int row = 2;
			int column = 2;
			boolean horizontal = true;
			submarine.placeShipAt(row, column, horizontal, ocean);

			assertTrue(emptysea.shootAt(1, 1));
			boolean[] hitArray0 = {true};
			assertArrayEquals(hitArray0, emptysea.getHit());
			
			//Tests whethere single hits are properly detected on Cruiser. 
			Ship cruiser = new Cruiser();
			int row = 5;
			int column = 1;
			boolean horizontal = true;
			cruiser.placeShipAt(row, column, horizontal, ocean);

			assertFalse(cruiser.shootAt(5, 1));
			boolean[] hitArray0 = {true, false, false};
			assertArrayEquals(hitArray0, battleship.getHit());


		}

		@Test
		void testIsSunk () {

			//Tests whether IsSunk method returns false when a submarine is not hit. 
			Ship submarine = new Submarine();
			int row = 3;
			int column = 3;
			boolean horizontal = true;
			submarine.placeShipAt(row, column, horizontal, ocean);

			assertFalse(submarine.isSunk());
			assertFalse(submarine.shootAt(5, 2));
			assertFalse(submarine.isSunk());

			//Tests whether EmptySea override rturns false when isSunk is runs.
			Ship emptysea = new EmptySea();
			int row = 2;
			int column = 2;
			boolean horizontal = true;
			emptysea.placeShipAt(row, column, horizontal, ocean);

			assertFalse(emptysea.isSunk());
			assertFalse(emptysea.shootAt(2, 2));
			assertFalse(emptysea.isSunk());
			
			//Tests whether IsSunk method returns True when a submarine is hit. 
			Ship submarine = new Submarine();
			int row = 4;
			int column = 4;
			boolean horizontal = true;
			submarine.placeShipAt(row, column, horizontal, ocean);

			assertFalse(submarine.isSunk());
			assertrue(submarine.shootAt(4, 4));
			assertrue(submarine.isSunk());
			
			//Tests whether a Batleship that is hit returns False on is sunk,
			Ship battleship = new Battleship();
			int row = 6;
			int column = 6;
			boolean horizontal = true;
			battleship.placeShipAt(row, column, horizontal, ocean);

			assertFalse(battleship.isSunk());
			assertTrue(battleship.shootAt(6, 6));
			assertFalse(battleship.isSunk());

		}

		@Test
		
		//
		void testToString () {

			//test whether hit battleship overrides method and returns "s".
			Ship battleship = new Battleship();
			assertEquals("x", battleship.toString());

			int row = 9;
			int column = 1;
			boolean horizontal = false;
			battleship.placeShipAt(row, column, horizontal, ocean);
			battleship.shootAt(9, 1);
			assertEquals("x", battleship.toString());
			
			//Test if a hit submarine overrides method and returns "s"
			Ship submarine = new Submarine();
			assertEquals("s", submarine.toString());

			int row = 5;
			int column = 5;
			boolean horizontal = false;
			submarine.placeShipAt(row, column, horizontal, ocean);
			submarine.shootAt(5, 5);
			assertEquals("s", submarine.toString());
			
			//Test if a hit cruiser overrides method and returns "x"
			Ship cruiser = new Cruiser();
			assertEquals("x", submarine.toString());

			int row = 2;
			int column =7;
			boolean horizontal = false;
			cruiser.placeShipAt(row, column, horizontal, ocean);
			cruiser.shootAt(2, 7);
			assertEquals("x", cruiser.toString());
		
			//Test if I hit empty sea overrides method and returns "empty"
			Ship emptysea = new EmptySea();
			assertEquals("s", submarine.toString());

			int row = 8;
			int column = 8;
			boolean horizontal = false;
			emptysea.placeShipAt(row, column, horizontal, ocean);
			emptysea.shootAt(5, 5);
			assertEquals("empty", emptysea.toString()); 
		}

	}