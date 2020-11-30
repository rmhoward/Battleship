/*
  Written by: Rachael Howard (82772985), Benjamin Thanyawatpokin (52147828),
  and Christian Pearson (86344425)
  Sources: Recitation, office hours, and Piazza posts.
 */

package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of all ship-related classes
 * @author ben
 *
 */
class ShipTest {

	Ocean ocean;
	Ship ship;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test

		//Tests length of ALL ships (included emptySea) - included here instead of making other test files
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
		
		//Tests length of Submarine is 1
		ship = new Submarine();
		assertEquals(1, ship.getLength());
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

		//Tests GetHit on Destroyer with one hit box
		Ship destroyer = new Destroyer();
		int row = 4;
		int column = 4;
		boolean horizontal = true;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		destroyer.shootAt(4, 4);
		
		boolean[] hits1 = new boolean[4];
		hits1[0] = true;
		assertArrayEquals(hits1, destroyer.getHit());
		assertTrue(destroyer.getHit()[0]);
		assertFalse(destroyer.getHit()[1]);

		//Tests GetHit on Cruiser
		Ship cruiser = new Cruiser();
		row = 6;
		column = 6;
		horizontal = true;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		cruiser.shootAt(6, 6);
		cruiser.shootAt(6, 5);
		
		boolean[] hits2 = new boolean[4];
		hits2[0] = true;
		hits2[1] = true;
		assertArrayEquals(hits2, cruiser.getHit());
		assertTrue(cruiser.getHit()[0]);
		assertTrue(cruiser.getHit()[1]);
		assertFalse(cruiser.getHit()[2]);
		assertFalse(cruiser.getHit()[3]);

		//Tests GetHit on Submarine with one hit (one that is sunk)
		Ship submarine = new Submarine();
		row = 9;
		column = 9;
		horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);
		submarine.shootAt(9, 9);
		
		boolean[] hits3 = new boolean[4];
		hits3[0] = true;
		assertArrayEquals(hits3, submarine.getHit());
		assertTrue(submarine.getHit()[0]);
		assertFalse(submarine.getHit()[1]);
		assertFalse(submarine.getHit()[2]);
		assertFalse(submarine.getHit()[3]);
		
		//testing a sunk battleship's array
		Ship battleship = new Battleship();
		row = 5;
		column = 0;
		horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(5, 0);
		battleship.shootAt(4, 0);
		battleship.shootAt(3, 0);
		battleship.shootAt(2, 0);
		
		boolean[] hits4 = new boolean[4];
		hits4[0] = true;
		hits4[1] = true;
		hits4[2] = true;
		hits4[3] = true;
		assertArrayEquals(hits4, battleship.getHit());
		assertTrue(battleship.getHit()[0]);
		assertTrue(battleship.getHit()[1]);
		assertTrue(battleship.getHit()[2]);
		assertTrue(battleship.getHit()[3]);
		
		
		

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

		//Test ship type for ALL SHIPS - included here to avoid making more test files
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
		assertEquals("empty", ship.getShipType());
		
		//Test to see whether whether GetShipType returns the correct type.
		ship = new Submarine();
		assertEquals("submarine", ship.getShipType());
		
	}
	
	@Test
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int column = 2;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());
  
  //Test to see whether the SetBowColumn function goes to the proper column. 
		Ship submarine = new Submarine();
		int column1 = 1;
		submarine.setBowColumn(column1);
		assertEquals(column1, submarine.getBowColumn());
  
  //Test to see whether the SetBowColumn function goes to the proper column. - edge 0 column
		Ship cruiser = new Cruiser();
		int column2 = 0;
		cruiser.setBowColumn(column2);
		assertEquals(column2, cruiser.getBowColumn());
    
  //Test to see whether the SetBowColumn function goes to the proper column. - edge 9 column
		Ship destroyer = new Destroyer();
		int column3 = 9;
		destroyer.setBowColumn(column3);
		assertEquals(column3, destroyer.getBowColumn());
    
  }

		@Test
		void testSetHorizontal () {
			Ship battleship = new Battleship();
			boolean horizontal = true;
			battleship.setHorizontal(horizontal);
			assertTrue(battleship.isHorizontal());

			//Tests whether changing the setting to False works for isHorizontal
			Ship submarine = new Submarine();
			boolean horizontal1 = false;
			submarine.setHorizontal(horizontal1);
			assertFalse(submarine.isHorizontal());
			
			//Tests whether placing the ship off the game board returns False for isHorizontal
			Ship destroyer = new Destroyer();
			boolean horizontal2 = false;
			destroyer.setHorizontal(horizontal2);
			assertFalse(destroyer.isHorizontal());
			
			//Tests whether changing the setting to true works for isHorizontal
			Ship submarine1 = new Submarine();
			boolean horizontal3 = true;
			submarine1.setHorizontal(horizontal3);
			assertTrue(submarine1.isHorizontal());

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
			
			//test whether method prevents placing ships off the gameboard - edge case bottom right of the grid
			Ship cruiser = new Cruiser();
			int row2 = 9;
			int column2 = 9;
			boolean horizontal2 = false;
			boolean ok2 = cruiser.okToPlaceShipAt(row2, column2, horizontal2, ocean);
			assertTrue(ok2, "OK to place ship here.");
			
			//edge case - off-board orientation
			
			//test whether method prevents placing ships off the gameboard - edge case Bottom left of the grid
			Ship battleship2 = new Battleship();
			int row3 = 9;
			int column3 = 0;
			boolean horizontal3 = true;
			boolean ok3 = battleship2.okToPlaceShipAt(row3, column3, horizontal3, ocean);
			assertFalse(ok3, "NOT OK to place ship here.");
			
			//edge case - false orientations at top right
			Ship battleship3 = new Battleship();
			row = 0;
			column = 9;
			horizontal = false;
			ok = battleship3.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok, "NOT OK to place ship here.");
			
			//edge case - false orientations at top left
			Ship battleship4 = new Battleship();
			row = 0;
			column = 0;
			horizontal = false;
			ok = battleship4.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok, "NOT OK to place ship here.");
			
			//edge case - false orientations in mid-left
			Ship battleship5 = new Battleship();
			row = 5;
			column = 0;
			horizontal = true;
			ok = battleship5.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok, "NOT OK to place ship here.");
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
			//First, place a ship in an area where we can put a ship vertically above and to the left of it
			Battleship battleship = new Battleship();
			row = 5;
			column = 6;
			horizontal = true;
			ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
			assertTrue(ok1, "OK to place ship here.");
			battleship.placeShipAt(row, column, horizontal, ocean);
			
			Battleship battleship3 = new Battleship();
			int row2 = 4;
			int column2 = 6;
			boolean horizontal2 = false;
			boolean ok3 = battleship3.okToPlaceShipAt(row2, column2, horizontal2, ocean);
			assertFalse(ok3, "Not OK to place ship diagonally adjacent above.");
			
			//test fourth ship
			Battleship battleship4 = new Battleship();
			int row3 = 4;
			int column3 = 4;
			boolean horizontal3 = true;
			boolean ok4 = battleship4.okToPlaceShipAt(row3, column3, horizontal3, ocean);
			assertFalse(ok4, "Not OK to place ship horizontally adjacent above.");
			
			//testing fifth ship - vertical at the stern of the ship
			Cruiser cruiser2 = new Cruiser();
			row = 5;
			column = 2;
			horizontal = false;
			boolean ok5 = cruiser2.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok5, "Not OK to place ship vertically at the end of another ship.");
			
			//testing near the top
			//First, place a ship in an area where we can put a ship vertically above it
			Battleship battleship5 = new Battleship();
			row = 1;
			column = 9;
			horizontal = true;
			ok1 = battleship5.okToPlaceShipAt(row, column, horizontal, ocean);
			assertTrue(ok1, "OK to place ship here.");
			battleship5.placeShipAt(row, column, horizontal, ocean);
			
			Cruiser cruiser3 = new Cruiser();
			row = 0;
			column = 8;
			horizontal = true;
			boolean ok = cruiser3.okToPlaceShipAt(row, column, horizontal, ocean);
			assertFalse(ok, "Not OK to place ship horizontally adjacent above.");
			

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
			
			//Edge case - on the edge of the board - bottom right vertically placed
			Ship battleship2 = new Battleship();
			int row2 = 9;
			int column2 = 9;
			boolean horizontal2 = false;
			battleship2.placeShipAt(row2, column2, horizontal2, ocean);
			assertEquals("battleship", ocean.getShipArray()[9][9].getShipType());
			assertEquals("battleship", ocean.getShipArray()[8][9].getShipType());
			assertEquals("battleship", ocean.getShipArray()[7][9].getShipType());
			assertEquals("battleship", ocean.getShipArray()[6][9].getShipType());
			assertEquals(battleship2, ocean.getShipArray()[9][9]);
			
			//Edge case - on the edge of the board - bottom right horizontally place
			Ship battleship3 = new Battleship();
			int row3 = 9;
			int column3 = 9;
			boolean horizontal3 = true;
			battleship3.placeShipAt(row3, column3, horizontal3, ocean);

			assertEquals("battleship", ocean.getShipArray()[9][9].getShipType());
			assertEquals("battleship", ocean.getShipArray()[9][8].getShipType());
			assertEquals("battleship", ocean.getShipArray()[9][7].getShipType());
			assertEquals("battleship", ocean.getShipArray()[9][6].getShipType());
			assertEquals(battleship3, ocean.getShipArray()[9][9]);
			
			//Edge case - on the edge of the board - top left placement vertically
			Ship battleship4 = new Battleship();
			row = 4;
			column = 0;
			horizontal = false;
			battleship4.placeShipAt(row, column, horizontal, ocean);

			assertEquals("battleship", ocean.getShipArray()[4][0].getShipType());
			assertEquals("battleship", ocean.getShipArray()[3][0].getShipType());
			assertEquals("battleship", ocean.getShipArray()[2][0].getShipType());
			assertEquals("battleship", ocean.getShipArray()[1][0].getShipType());
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

			//as emptySea will always return false, it HAS NO hit array
			assertFalse(emptysea.shootAt(1, 1));
			
			
			//Tests whether ShootAt works on submarine.
			Ship submarine = new Submarine();
			int row3 = 2;
			int column3 = 2;
			boolean horizontal3 = true;
			submarine.placeShipAt(row3, column3, horizontal3, ocean);

			assertTrue(submarine.shootAt(2, 2));
			boolean[] hitArray3 = {true, false, false, false};
			assertArrayEquals(hitArray3, submarine.getHit());
			
			//Tests whether single hits are properly detected on Cruiser. Fully sunk cruiser
			Ship cruiser = new Cruiser();
			int row4 = 8;
			int column4 = 8;
			boolean horizontal4 = true;
			cruiser.placeShipAt(row4, column4, horizontal4, ocean);

			//this should not hit the cruiser
			assertFalse(cruiser.shootAt(8, 9));
			
			cruiser.shootAt(8, 8);
			cruiser.shootAt(8, 7);
			cruiser.shootAt(8, 6);
			boolean[] hitArray4 = {true, true, true, false};
			assertArrayEquals(hitArray4, cruiser.getHit());

			//Edge case - test a battleship that has been sunk 
			Ship battleship1 = new Battleship();
			int row = 9;
			int column = 0;
			boolean horizontal = false;
			battleship1.placeShipAt(row, column, horizontal, ocean);
			
			battleship1.shootAt(9, 0);
			battleship1.shootAt(8, 0);
			battleship1.shootAt(7, 0);
			battleship1.shootAt(6, 0);
			
			boolean[] hitArray5 = {true, true, true, true};
			
			assertArrayEquals(hitArray5, battleship1.getHit());
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

			assertFalse(submarine1.isSunk());
			assertTrue(submarine1.shootAt(4, 4));
			assertTrue(submarine1.isSunk());
			
			//Tests whether a Batleship that is hit twice returns False on is sunk,
			Ship battleship = new Battleship();
			int row4 = 6;
			int column4 = 6;
			boolean horizontal4 = true;
			battleship.placeShipAt(row4, column4, horizontal4, ocean);

			assertFalse(battleship.isSunk());
			assertTrue(battleship.shootAt(6, 6));
			assertFalse(battleship.isSunk());
			
			//testing a sunk cruiser
			Ship cruiser = new Cruiser();
			int row = 9;
			int column = 9;
			boolean horizontal = false;
			cruiser.placeShipAt(row, column, horizontal, ocean);

			assertFalse(cruiser.isSunk());
			cruiser.shootAt(9, 9);
			cruiser.shootAt(9, 8);
			cruiser.shootAt(9, 7);
			assertFalse(cruiser.isSunk());
			
			//check a battleship that has been hit in all places but one = not sunk
			Ship battleship1 = new Battleship();
			row = 9;
			column = 0;
			horizontal = false;
			battleship1.placeShipAt(row, column, horizontal, ocean);
			
			assertFalse(battleship1.isSunk());
			
			battleship1.shootAt(9, 0);
			battleship1.shootAt(8, 0);
			battleship1.shootAt(7, 0);
			
			assertFalse(battleship1.isSunk());

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
			row = 1;
			column = 1;
			horizontal = false;
			submarine.placeShipAt(row, column, horizontal, ocean);
			submarine.shootAt(1, 1);
			assertNotEquals("x", submarine.toString());

			int row1 = 5;
			int column1 = 5;
			boolean horizontal1 = false;
			submarine.placeShipAt(row1, column1, horizontal1, ocean);
			submarine.shootAt(5, 5);
			assertEquals("s", submarine.toString());
			
			//Test if a hit cruiser overrides method and returns "x".
			Ship cruiser = new Cruiser();
			row = 4;
			column = 7;
			horizontal = true;
			cruiser.placeShipAt(row, column, horizontal, ocean);
			cruiser.shootAt(4, 7);
			assertEquals("x", cruiser.toString());

			int row2 = 2;
			int column2 =7;
			boolean horizontal2 = false;
			cruiser.placeShipAt(row2, column2, horizontal2, ocean);
			cruiser.shootAt(2, 7);
			assertEquals("x", cruiser.toString());
		
			//Test if I hit empty sea overrides method and returns "empty"
			Ship emptysea = new EmptySea();
			assertEquals("-", emptysea.toString());

			//tests if a shot at emptysea will still make the - symbol
			int row3 = 8;
			int column3 = 8;
			boolean horizontal3 = false;
			emptysea.placeShipAt(row3, column3, horizontal3, ocean);
			emptysea.shootAt(5, 5);
			assertEquals("-", emptysea.toString()); 
			
			//Minor edge case - tests transformation of X to S
			Ship battleship1 = new Battleship();
			row = 9;
			column = 9;
			horizontal = true;
			battleship1.placeShipAt(row, column, horizontal, ocean);
			battleship1.shootAt(9, 9);
			assertEquals("x", battleship1.toString());
			battleship1.shootAt(9, 8);
			assertEquals("x", battleship1.toString());
			battleship1.shootAt(9,7);
			assertEquals("x", battleship1.toString());
			battleship1.shootAt(9,6);
			assertEquals("s", battleship1.toString());
		}
 
	}