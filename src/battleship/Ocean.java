package battleship;

import java.util.Random;

/**
 * The Ocean class represents the game board for Battleship 
 * Ocean holds the variables for the game including the ocean size, number of battleships, number of cruisers, number of destroyers, and number of submarines. 
 * Zeros out constructors.
 */
public class Ocean {

	//static vars
	
    static final int OCEAN_SIZE = 10;
    static final int NUM_BATTLESHIPS = 1;
    static final int NUM_CRUISERS = 2;
    static final int NUM_DESTROYERS = 3;
    static final int NUM_SUBMARINES = 4;

    //private vars
    
    private Ship[][]ships = new Ship[Ocean.OCEAN_SIZE + 1][Ocean.OCEAN_SIZE];
    
    private int shotsFired;

    private int hitCount;

    private int shipsSunk;
    
    private boolean horizontal;

    //constructors
    
    public Ocean() {
        this.populateEmptyOcean();
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
    }

    //private methods
    
    //Create ocean with no shots
    /**
     * Adds emptysea (a subclass of Ship) to the Ocean
     */
    private void populateEmptyOcean() {
        for (int i = 0; i < this.ships.length; i++) {
            for (int j = 0; j < this.ships[i].length; j++) {
                Ship ship = new EmptySea();
                ship.placeShipAt(i, j, true, this);
            }
        }
    }
    
    
    //public methods
    
    /**
     * Randomly places all ships in the Ocean/GameBoard. 
     */
    void placeAllShipsRandomly() {

        Random rand = new Random();
        
        int row;
        
        int column;

        //place battleships
        for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
            Ship battleship = new Battleship(4);
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            battleship.placeShipAt(row, column, horizontal, this);
        }

        //place cruisers
        
        for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
            Ship cruiser = new Cruiser(3);
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            cruiser.placeShipAt(row, column, horizontal, this);
        }
        
        for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
            Ship cruiser2 = new Cruiser(3);
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!cruiser2.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            cruiser2.placeShipAt(row, column, horizontal, this);
        }

        //place destroyers
        for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
            Ship destroyer = new Destroyer(2);
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            destroyer.placeShipAt(row, column, horizontal, this);
        }

        //place submarines
        for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
            Ship submarine = new Submarine(1);
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            submarine.placeShipAt(row, column, horizontal, this);
        }
        
        

    }
    
    /**
     * Determines whether there os currently a ship on a particular grid location. 
     * Function in support of random ship placement and hit detection of ships
     * @return whether the grid location is empty. 
     */
    boolean isOccupied(int row, int column) {
    	Ship[][] shipArray = this.getShipArray();

    	return !("empty".equals(shipArray[row][column].getShipType()));
    }

    /**
     * Method for shooting at a ship. 
     * flags if shot is taken out of game space
     * Adds a hit counter to a ship if a ship is hit and not sunk. 
     * If a ship is sunk the isSunk method is called. 
     * @return returnVal (whether a ship was hit)
     */
    boolean shootAt(int row, int column) {
    	
    	boolean returnVal = false;

    	//row or col out of bounds
        Ship[][] shipArray = this.getShipArray();
        Ship ship = shipArray[row][column];

        //if not sunk
        if (!ship.isSunk()) {
            if (ship.shootAt(row, column)) {
                this.hitCount++;

                if (ship.isSunk()) {
                    this.shipsSunk++;
                }
            }
            //if ship
            if (this.isOccupied(row, column)) {
                returnVal = true;
            }
        }
        //increase shots fired total
        this.shotsFired++;

        return returnVal;
    }

    
    //getters/setters
    
    /**
     * Hold the shots fired by a player. 
     */
    int getShotsFired() {
    	return this.shotsFired;
    }
    /**
     * Hold the number of hits a ship has taken. 
     */
    int getHitCount() {
    	return this.hitCount;
    }
    
    /**
     * holds the list of ships sunk. 
     * @return ships sunk. 
     */
    int getShipsSunk() {
    	return this.shipsSunk;
    }

    //check if game is over (all ships sunk)
    /**
     * Determines if the game is over by checking to see if all of the ships have been sunk. 
     * @return boolean of whether ships sunk is greater than or equal to the number of ocean grid locations. 
     */
    boolean isGameOver() {
        return this.getShipsSunk() >= Ocean.OCEAN_SIZE;
    }

    //return ship array
    /**
     * Prints the remaining ships. 
     * @return an array of the remaining ships. 
     */
    Ship[][] getShipArray() {
    	return this.ships;
    }

    void print() {
		for (int i = 0; i <= 10; i++) {
			if (i == 0) {
				System.out.print(" ");
			} else if (i == 1) {
				System.out.print(0);
			} else {
				System.out.print(i-1);
			}
			for (int j = 0; j < 10; j++) {
				if (i == 0) {
					System.out.print(j);
				} else {
					System.out.print(ships[i][j]);
				}
				
				
			}
			System.out.println(' ');
		}
    }

}
