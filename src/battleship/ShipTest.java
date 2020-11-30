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

		//Tests length of Cruiser length 3
		ship = new Cruiser();
		assertEquals(3, ship.getLength());

		//Tests length of Destroyer length 2
		ship = new Destroyer();
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
		int row1 = 0;
		int column1 = 4;
		boolean horizontal1 = true;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		assertEquals(row1, battleship.getBowRow());

		//Tests GetBowRow for Cruiser
		Ship cruiser = new Cruiser();
		int row2 = 0;
		int column2 = 3;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		assertEquals(row2, cruiser.getBowRow());

		//Tests GetBowRow for Destroyer
		Ship destroyer = new Destroyer();
		int row3 = 0;
		int column3 = 2;
		boolean horizontal3 = true;
		destroyer.placeShipAt(row3, column3, horizontal3, ocean);
		assertEquals(row3, destroyer.getBowRow());
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
		int row1 = 0;
		int column1 = 1;
		boolean horizontal1 = true;
		emptysea.placeShipAt(row1, column1, horizontal1, ocean);
		emptysea.setBowColumn(column1);
		assertEquals(column1, emptysea.getBowColumn());

		//Tests GetBowColumn for Cruiser
		Ship cruiser = new Cruiser();
		int row2 = 0;
		int column2 = 3;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		cruiser.setBowColumn(column2);
		assertEquals(column2, cruiser.getBowColumn());


		//Tests GetBowColumn for Destroyer
		Ship destroyer = new Destroyer();
		int row3 = 0;
		int column3 = 2;
		boolean horizontal3 = true;
		destroyer.placeShipAt(row3, column3, horizontal3, ocean);
		destroyer.setBowColumn(column3);
		assertEquals(column3, destroyer.getBowColumn());

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
		boolean[] hits1 = new boolean[2];
		assertArrayEquals(hits1, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

		//Tests GetHit on Cruiser
		ship = new Cruiser();
		boolean[] hits2 = new boolean[3];
		assertArrayEquals(hits2, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);

		//Tests GetHit on Submarine
		ship = new Cruiser();
		boolean[] hits3 = new boolean[1];
		assertArrayEquals(hits3, ship.getHit());
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
		int row1 = 0;
		int column1 = 1;
		boolean horizontal1 = true;
		emptySea.placeShipAt(row1, column1, horizontal1, ocean);
		assertTrue(emptySea.isHorizontal());

		//Test whether Empty Sea is aligned horizontally. Should return False.
		Ship emptysea = new EmptySea();
		int row2 = 1;
		int column2 = 0;
		boolean horizontal2 = false;
		emptysea.placeShipAt(row2, column2, horizontal2, ocean);
		assertFalse(emptysea.isHorizontal());

		//Test whether the ship is aligned horizontally. Should return False.
		Ship destroyer = new Destroyer();
		int row3 = 2;
		int column3 = 0;
		boolean horizontal3 = false;
		destroyer.placeShipAt(row3, column3, horizontal3, ocean);
		assertFalse(destroyer.isHorizontal());

	}

	@Test

		//Test to see whether whether GetShipType returns the correct type.
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("Battleship", ship.getShipType());

		//Test to see whether whether GetShipType returns the correct type.
		ship = new Destroyer();
		assertEquals("Destroyer", ship.getShipType());

		//Test to see whether whether GetShipType returns the correct type.
		ship = new Cruiser();
		assertEquals("Cruiser", ship.getShipType());

		//Test to see whether whether GetShipType returns the correct type.
		ship = new EmptySea();
		assertEquals("empty", ship.getShipType());
		
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
		int row1 = 0;
		int column1 = 1;
		boolean horizontal1 = true;
		submarine.setBowColumn(column1);
		assertEquals(column1, submarine.getBowColumn());
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
		Ship cruiser = new Cruiser();
		int row2 = 0;
		int column2 = 3;
		boolean horizontal2 = true;
		cruiser.setBowColumn(column2);
		assertEquals(column2, cruiser.getBowColumn());
    
  //Test to see whether the SetBowColumn function goes to the proper column. 
		Ship destroyer = new Destroyer();
		int row3 = 0;
		int column3 = 4;
		boolean horizontal3 = true;
		destroyer.setBowColumn(column3);
		assertEquals(column3, destroyer.getBowColumn());
    
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
			int row1 = 0;
			int column1 = 0;
			boolean horizontal1 = false;
			submarine.setHorizontal(horizontal1);
			assertFalse(submarine.isHorizontal());
			
			//Tests whether placing the ship off the gameboard returns False for isHorizontal
			Ship destroyer = new Destroyer();
			int row2 = -1;
			int column2 = 0;
			boolean horizontal2 = false;
			destroyer.setHorizontal(horizontal2);
			assertFalse(destroyer.isHorizontal());
			
			//Tests whether changing the setting to False works for isHorizontal
			Ship submarine1 = new Submarine();
			int row3 = 0;
			int column3 = 0;
			boolean horizontal3 = false;
			submarine1.setHorizontal(horizontal3);
			assertFalse(submarine1.isHorizontal());

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

			//test whether method determines EmptySea is a ship for the purpose of placement
			Ship emptysea = new EmptySea();
			int row1 = 0;
			int column1 = 0;
			boolean horizontal1 = true;
			boolean ok1 = emptysea.okToPlaceShipAt(row1, column1, horizontal1, ocean);
			assertTrue(ok1, "OK to place ship here.");
			
			//test whether method prevents placing ships off the gameboard
			Ship cruiser = new Cruiser();
			int row2 = 9;
			int column2 = 9;
			boolean horizontal2 = true;
			boolean ok2 = cruiser.okToPlaceShipAt(row2, column2, horizontal2, ocean);
			assertFalse(ok2, "OK to place ship here.");
			
			//test whether method prevents placing ships off the gameboard
			Ship battleship2 = new Battleship();
			int row3 = 9;
			int column3 = 8;
			boolean horizontal3 = true;
			boolean ok3 = battleship2.okToPlaceShipAt(row3, column3, horizontal3, ocean);
			assertFalse(ok3, "OK to place ship here.");
		}

		@Test
		void testOkToPlaceShipAtAgainstOtherShipsOneBattleship () {

			//test when other ships are in the ocean

			//place first ship
			Battleship battleship1 = new Battleship();
			int row = 0;
			int column = 4;
			boolean horizontal = true;
			boolean ok = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
			assertTrue(ok, "OK to place ship here.");
			battleship1.placeShipAt(row, column, horizontal, ocean);

			//test second ship
			Battleship battleship2 = new Battleship();
			int row1 = 1;
			int column1 = 4;
			boolean horizontal1 = true;
			boolean ok1 = battleship2.okToPlaceShipAt(row1, column1, horizontal1, ocean);
			assertFalse(ok1, "Not OK to place ship vertically adjacent below.");
			
			//test third ship
			Battleship battleship3 = new Battleship();
			int row2 = 1;
			int column2 = 8;
			boolean horizontal2 = true;
			boolean ok2 = battleship3.okToPlaceShipAt(row2, column2, horizontal2, ocean);
			assertFalse(ok2, "Not OK to place ship diagonally adjacent below.");
			
			//test fourth ship
			Battleship battleship4 = new Battleship();
			int row3 = 0;
			int column3 = 8;
			boolean horizontal3 = true;
			boolean ok3 = battleship4.okToPlaceShipAt(row3, column3, horizontal3, ocean);
			assertFalse(ok3, "Not OK to place ship horizontally adjacent below.");
			

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
			Ship submarine = new Submarine();
			int row1 = 5;
			int column1 = 4;
			boolean horizontal1 = true;
			submarine.placeShipAt(row1, column1, horizontal1, ocean);
			assertEquals(row1, submarine.getBowRow());
			assertEquals(column1, submarine.getBowColumn());
			assertTrue(submarine.isHorizontal());

			assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
			assertEquals(submarine, ocean.getShipArray()[5][4]);
			
			//Test method doesn't work when trying to place at edge of grid. 
			Ship battleship2 = new Battleship();
			int row2 = 9;
			int column2 = 9;
			boolean horizontal2 = true;
			battleship2.placeShipAt(row2, column2, horizontal2, ocean);
			assertEquals(row2, battleship2.getBowRow());
			assertEquals(column2, battleship2.getBowColumn());
			assertTrue(battleship2.isHorizontal());

			assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
			assertEquals(battleship2, ocean.getShipArray()[9][9]);
			
			//Test method doesn't work when trying to place battleship on edge of gameboard
			Ship battleship3 = new Battleship();
			int row3 = 9;
			int column3 = 9;
			boolean horizontal3 = true;
			battleship3.placeShipAt(row3, column3, horizontal3, ocean);
			assertEquals(row3, battleship3.getBowRow());
			assertEquals(column3, battleship3.getBowColumn());
			assertTrue(battleship3.isHorizontal());

			assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
			assertEquals(battleship3, ocean.getShipArray()[9][9]);

		}

		@Test
		void testShootAt () {

			//Tests whethere complete misses are properly detected. 
			Ship battleship = new Battleship();
			int row1 = 0;
			int column1 = 9;
			boolean horizontal1 = true;
			battleship.placeShipAt(row1, column1, horizontal1, ocean);

			assertFalse(battleship.shootAt(1, 9));
			boolean[] hitArray1 = {false, false, false, false};
			assertArrayEquals(hitArray1, battleship.getHit());

			//Tests whether emptysea override on ShootAt works.
			Ship emptysea = new EmptySea();
			int row2 = 1;
			int column2 = 1;
			boolean horizontal2 = true;
			emptysea.placeShipAt(row2, column2, horizontal2, ocean);

			assertFalse(emptysea.shootAt(1, 1));
			boolean[] hitArray2 = {false};
			assertArrayEquals(hitArray2, emptysea.getHit());
			
			//Tests whether ShootAt works on submarine.
			Ship submarine = new Submarine();
			int row3 = 2;
			int column3 = 2;
			boolean horizontal3 = true;
			submarine.placeShipAt(row3, column3, horizontal3, ocean);

			assertTrue(emptysea.shootAt(1, 1));
			boolean[] hitArray3 = {true};
			assertArrayEquals(hitArray3, emptysea.getHit());
			
			//Tests whethere single hits are properly detected on Cruiser. 
			Ship cruiser = new Cruiser();
			int row4 = 5;
			int column4 = 1;
			boolean horizontal4 = true;
			cruiser.placeShipAt(row4, column4, horizontal4, ocean);

			assertFalse(cruiser.shootAt(5, 1));
			boolean[] hitArray4 = {true, false, false};
			assertArrayEquals(hitArray4, battleship.getHit());


		}

		@Test
		void testIsSunk () {

			//Tests whether IsSunk method returns false when a submarine is not hit. 
			Ship submarine = new Submarine();
			int row1 = 3;
			int column1 = 3;
			boolean horizontal1 = true;
			submarine.placeShipAt(row1, column1, horizontal1, ocean);

			assertFalse(submarine.isSunk());
			assertFalse(submarine.shootAt(5, 2));
			assertFalse(submarine.isSunk());

			//Tests whether EmptySea override rturns false when isSunk is runs.
			Ship emptysea = new EmptySea();
			int row2 = 2;
			int column2 = 2;
			boolean horizontal2 = true;
			emptysea.placeShipAt(row2, column2, horizontal2, ocean);

			assertFalse(emptysea.isSunk());
			assertFalse(emptysea.shootAt(2, 2));
			assertFalse(emptysea.isSunk());
			
			//Tests whether IsSunk method returns True when a submarine is hit. 
			Ship submarine1 = new Submarine();
			int row3 = 4;
			int column3 = 4;
			boolean horizontal3 = true;
			submarine1.placeShipAt(row3, column3, horizontal3, ocean);

			assertFalse(submarine.isSunk());
			assertTrue(submarine1.shootAt(4, 4));
			assertTrue(submarine1.isSunk());
			
			//Tests whether a Batleship that is hit returns False on is sunk,
			Ship battleship = new Battleship();
			int row4 = 6;
			int column4 = 6;
			boolean horizontal4 = true;
			battleship.placeShipAt(row4, column4, horizontal4, ocean);

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

			int row1 = 5;
			int column1 = 5;
			boolean horizontal1 = false;
			submarine.placeShipAt(row1, column1, horizontal1, ocean);
			submarine.shootAt(5, 5);
			assertEquals("s", submarine.toString());
			
			//Test if a hit cruiser overrides method and returns "x"
			Ship cruiser = new Cruiser();
			assertEquals("x", submarine.toString());

			int row2 = 2;
			int column2 =7;
			boolean horizontal2 = false;
			cruiser.placeShipAt(row2, column2, horizontal2, ocean);
			cruiser.shootAt(2, 7);
			assertEquals("x", cruiser.toString());
		
			//Test if I hit empty sea overrides method and returns "empty"
			Ship emptysea = new EmptySea();
			assertEquals("s", submarine.toString());

			int row3 = 8;
			int column3 = 8;
			boolean horizontal3 = false;
			emptysea.placeShipAt(row3, column3, horizontal3, ocean);
			emptysea.shootAt(5, 5);
			assertEquals("empty", emptysea.toString()); 
		}
 
	}