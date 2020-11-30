package battleship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Java tests for the Javacript game.
 * Tests proper game initiation, board setup, and functioning of ships. 
 * First iteration of variables is unnumbnered then it is 1... after. 
 */ 
class OceanTest {
	
	Ocean ocean;
	static int NUM_BATTLESHIPS = 1;
	static int NUM_CRUISERS = 2;
	static int NUM_DESTROYERS = 3;
	static int NUM_SUBMARINES = 4;
	static int OCEAN_SIZE = 10;
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}
	
	/**
	 * Iterates over all of the grid locations to ensure they are empty at the start of the game. 
	 * Each of the grid lcoations should be equal to "empty" which is the EmptySea's "getShipType" override. 
	 */
	@Test
	void testEmptyOcean() {
		
		//tests that all locations in the ocean are "empty"
		
		Ship[][] ships = ocean.getShipArray();
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				
				assertEquals("empty", ship.getShipType());
			}
		}
		
		assertEquals(0, ships[0][0].getBowRow());
		assertEquals(0, ships[0][0].getBowColumn());
		
		assertEquals(5, ships[5][5].getBowRow());
		assertEquals(5, ships[5][5].getBowColumn());
		
		assertEquals(9, ships[9][0].getBowRow());
		assertEquals(0, ships[9][0].getBowColumn());
	}
	
	/**
	 * Iterates over all of the grid locations to determine if the correct number of each type of ships have been placed on the game board.
	 * Once ships are identified the ship variables (ints) are incremented. 
	 * This test checks the ship count against the ship variables to ensure there are the proper amount.  
	 */
	@Test
	void testPlaceAllShipsRandomly() {
		
		//tests that the correct number of each ship type is placed in the ocean
		
		ocean.placeAllShipsRandomly();

		Ship[][] ships = ocean.getShipArray();
		ArrayList<Ship> shipsFound = new ArrayList<Ship>();
		
		/**
		 * Value representing the number of Battleships in the game. 
		 */
		int numBattlehips = 0;
		
		/**
		 * Value representing the number of Cruisers in the game. 
		 */
		int numCruisers = 0;
		
		/**
		 * Value representing the number of Destroyers in the game. 
		 */
		int numDestroyers = 0;
		
		/**
		 * Value representing the number of Submarines in the game. 
		 */
		int numSubmarines = 0;
		
		/**
		 * Value representing the number of EmptySea space in the game.
		 */
		int numEmptySeas = 0;
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				if (!shipsFound.contains(ship)) {
					shipsFound.add(ship);
				}
			}
		}
		
		for (Ship ship : shipsFound) {
			if ("battleship".equals(ship.getShipType())) {		
				numBattlehips++;
			} else if ("cruiser".equals(ship.getShipType())) {
				numCruisers++;
			} else if ("destroyer".equals(ship.getShipType())) {
				numDestroyers++;
			} else if ("submarine".equals(ship.getShipType())) {
				numSubmarines++;
			} else if ("empty".equals(ship.getShipType())) {
				numEmptySeas++;
			}
		}
		
		assertEquals(NUM_BATTLESHIPS, numBattlehips);
		assertEquals(NUM_CRUISERS, numCruisers);
		assertEquals(NUM_DESTROYERS, numDestroyers);
		assertEquals(NUM_SUBMARINES, numSubmarines);
		
		//calculate total number of available spaces and occupied spaces
		/**
		 * Determines the total size of the game space by multiplying the ocean size variable by itself. 
		 */
		int totalSpaces = OCEAN_SIZE * OCEAN_SIZE; 
		
		/**
		 * Determined by addding the number of spaces occupied by the dum of the length of ships in play. 
		 */
		int occupiedSpaces = (NUM_BATTLESHIPS * 4)
				+ (NUM_CRUISERS * 3)
				+ (NUM_DESTROYERS * 2)
				+ (NUM_SUBMARINES * 1);
		
		//test number of empty seas, each with length of 1
		assertEquals(totalSpaces - occupiedSpaces, numEmptySeas);
	}

	/**
	 * Test to determine if ship placement works correctly. 
	 * Places a destroyer at 1,5 and checks to see whether it is there. 
	 * Places a submarine at 0,0
	 */
	@Test
	void testIsOccupied() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.isOccupied(1, 5));
		
		//TODO
		//More tests
	}
	
	/**
	 * Tests to ensure the ShootAt method is functioning properly. 
	 * Places a Destroyer at a particular grid location
	 * Then places an EmptySea
	 * Then places a submarine that can be sunk in one shot
	 * Then tests another cruiser that should not be sunk
	 */
	@Test
	void testShootAt() {
		
		//Tests whether a destroyer is hit - but not sunk after one hit
		assertFalse(ocean.shootAt(0, 1));
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		
		//Tests ShootAt overides on Empty Sea
		assertFalse(ocean.shootAt(6, 6));
		
		EmptySea emptysea = new EmptySea();
		int row1 = 2;
		int column1 = 6;
		boolean horizontal1 = false;
		emptysea.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertFalse(ocean.shootAt(2, 6));
		assertFalse(emptysea.isSunk());
		assertFalse(ocean.shootAt(1, 5));
		
		//Tests ShootAt works and sinks Submarine
		assertFalse(ocean.shootAt(7, 1));
		
		Submarine submarine = new Submarine();
		int row2 = 7;
		int column2 = 1;
		boolean horizontal2 = false;
		submarine.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(7, 1));
		assertTrue(submarine.isSunk());
		assertTrue(ocean.shootAt(7, 1));
		
		//Tests ShootAt works and doesn't sink Cruiser
		assertFalse(ocean.shootAt(0, 1));
		
		Cruiser cruiser = new Cruiser();
		int row3 = 0;
		int column3 = 1;
		boolean horizontal3 = false;
		cruiser.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(0, 1));
		assertFalse(cruiser.isSunk());
		assertTrue(ocean.shootAt(0, 5));
	}
	
	/**
	 * Tests whether the shots fired method consistenly returns false before ships are placed.
	 * Next a Destroyer is placed on the game board and the test whether the GetShotsFired method returns True when called against a grid location with a ship.
	 */
	@Test
	void testGetShotsFired() {
		
		//should be all false - no ships added yet
		assertFalse(ocean.shootAt(0, 1));
		assertFalse(ocean.shootAt(1, 0));
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(9, 9));
		assertEquals(4, ocean.getShotsFired());
		
		//Destroyer placed. Shots with the destoyer return True. 
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		//Submarine placed. Shots with the destoyer return True. 
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		//EmptySea placed. Shots with EmptySea return False. 
		Ship emptysea = new EmptySea();
		row = 9;
		column = 9;
		horizontal = false;
		emptysea.placeShipAt(row, column, horizontal, ocean);
		
		//Destroyer Tests
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(6, ocean.getShotsFired());
		
		//Submarine Tests
		assertTrue(ocean.shootAt(0, 0));
		assertTrue(submarine.isSunk());
		
		//WHAT DOES THIS 7 REPRESENT? TOTAL SHOTS?
		assertEquals(7, ocean.getShotsFired());
		
		//EmptySea Tests
		assertTrue(ocean.shootAt(9, 9));
		assertFalse(emptysea.isSunk());
		assertEquals(8, ocean.getShotsFired());
		
		
	}
	/**
	 * Test to determine whether the appropriate number of hits are attributed to a particular ship. 
	 */
	@Test
	void testGetHitCount() {
		
		//Testing one hit on a destroyer
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		
		//Testing two hits on a battleship
		Battleship battleship = new Battleship();
		int row1 = 6;
		int column1 = 6;
		boolean horizontal1 = false;
		battleship.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.shootAt(6, 6));
		assertTrue(ocean.shootAt(7, 6));
		assertFalse(battleship.isSunk());
		assertEquals(3, ocean.getHitCount());
		
		//Testing one hit on emptysea. It shoudn't increment.
		EmptySea emptysea = new EmptySea();
		int row2 = 7;
		int column2 = 7;
		boolean horizontal2 = false;
		emptysea.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(7, 7));
		assertFalse(emptysea.isSunk());
		assertEquals(3, ocean.getHitCount());
		
		//Testing one hit on submarine. Should sink
		Submarine submarine = new Submarine();
		int row3 = 5;
		int column3 = 5;
		boolean horizontal3 = false;
		submarine.placeShipAt(row3, column3, horizontal3, ocean);
		
		assertTrue(ocean.shootAt(5, 5));
		assertFalse(submarine.isSunk());
		assertEquals(3, ocean.getHitCount());
	}
	/**
	 * Test to confirm whether the GestShipsSunk method works properly. 
	 * Creates a destroyer than runs the method shootAt against a portion of the destroyer.
	 * Should return False after running the isSunk method.
	 * Should return the appropriate hit count after running the getHitCount method. 
	 */
	@Test
	void testGetShipsSunk() {
		
		//Testing one hit on a Destroyer. Should be zero ships sunk
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());
	
		//Testing one hit on submarine. Should sink
		Submarine submarine = new Submarine();
		int row1 = 5;
		int column1 = 5;
		boolean horizontal1 = false;
		submarine.placeShipAt(row1, column1, horizontal1, ocean);
		
		assertTrue(ocean.shootAt(5, 5));
		assertFalse(submarine.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
		
		//Testing one hit on EmptySea. Nothing sinks, no increment on hit count. 
		EmptySea emptysea = new EmptySea();
		int row2 = 6;
		int column2 = 6;
		boolean horizontal2 = false;
		emptysea.placeShipAt(row2, column2, horizontal2, ocean);
		
		assertTrue(ocean.shootAt(5, 5));
		assertFalse(emptysea.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
		
		//Testing three hits on Cruiser. Cruiser sinks, increment of 3 on hit count. 
		Cruiser cruiser  = new Cruiser();
		int row3 = 7;
		int column3 = 7;
		boolean horizontal3 = false;
		cruiser.placeShipAt(row3, column3, horizontal3, ocean);
		
		assertTrue(ocean.shootAt(7, 7));
		assertTrue(ocean.shootAt(7, 8));
		assertTrue(ocean.shootAt(7, 9));
		assertTrue(cruiser.isSunk());
		assertEquals(5, ocean.getHitCount());
		assertEquals(2, ocean.getShipsSunk());
	}
	
	/**
	 * Tests to determine the array value or placementof a particular ship
	 */
	@Test
	void testGetShipArray() {
		
		Ship[][] shipArray = ocean.getShipArray();
		assertEquals(OCEAN_SIZE, shipArray.length);
		assertEquals(OCEAN_SIZE, shipArray[0].length);
		
		assertEquals("empty", shipArray[0][0].getShipType());
		
		//More tests ---What are we testing here?
	}

}
