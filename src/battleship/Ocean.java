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

    private final Ship[][] ships = new Ship[Ocean.OCEAN_SIZE + 1][Ocean.OCEAN_SIZE];

    private int shotsFired;

    private int hitCount;

    private int shipsSunk;

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
     * OKAY
     * Adds emptyOcean (a subclass of Ship) to the Ocean
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
    public void placeAllShipsRandomly() {

        Random rand = new Random();

        int row;
        int column;
        boolean horizontal;

        //place battleships
        for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
            Ship battleship = new Battleship();
            row = rand.nextInt(6) + 4;
            column = rand.nextInt(6) + 4;
            horizontal = rand.nextInt(2) != 0;
            while (!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(6) + 4;
                column = rand.nextInt(6) + 4;
                horizontal = rand.nextInt(2) != 0;
            }
            battleship.placeShipAt(row, column, horizontal, this);
        }

        //place cruisers
        for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
            Ship cruiser = new Cruiser();
            row = rand.nextInt(7) + 3;
            column = rand.nextInt(7) + 3;
            horizontal = rand.nextInt(2) != 0;
            while (!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(7) + 3;
                column = rand.nextInt(7) + 3;
                horizontal = rand.nextInt(2) != 0;
            }
            cruiser.placeShipAt(row, column, horizontal, this);
        }

        //place destroyers
        for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
            Ship destroyer = new Destroyer();
            row = rand.nextInt(8) + 2;
            column = rand.nextInt(8) + 2;
            horizontal = rand.nextInt(2) != 0;
            while (!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(8) + 2;
                column = rand.nextInt(8) + 2;
                horizontal = rand.nextInt(2) != 0;
            }
            destroyer.placeShipAt(row, column, horizontal, this);
        }

        //place submarines
        for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
            Ship submarine = new Submarine();
            row = rand.nextInt(9) + 1;
            column = rand.nextInt(9) + 1;
            horizontal = rand.nextInt(2) != 0;
            while (!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(9) + 1;
                column = rand.nextInt(9) + 1;
                horizontal = rand.nextInt(2) != 0;
            }
            submarine.placeShipAt(row, column, horizontal, this);
        }


    }

    /**
     * Determines whether there os currently a ship on a particular grid location.
     * Function in support of random ship placement and hit detection of ships
     *
     * @return whether the grid location is empty.
     */
    public boolean isOccupied(int row, int column) {
        Ship[][] shipArray = this.getShipArray();

        return !("empty".equals(shipArray[row][column].getShipType()));
    }

    /**
     * Method for shooting at a ship.
     * flags if shot is taken out of game space
     * Adds a hit counter to a ship if a ship is hit and not sunk.
     * If a ship is sunk the isSunk method is called.
     *
     * @return returnVal (whether a ship was hit)
     */
    public boolean shootAt(int row, int column) {

        boolean returnVal = false;

        //row or col out of bounds
        if ((row < 0 || row >= Ocean.OCEAN_SIZE) ||
                (column < 0 || column >= Ocean.OCEAN_SIZE)) {
            return returnVal;
        }

        //get location of ship
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
    public int getShotsFired() {
        return this.shotsFired;
    }

    /**
     * Hold the number of hits a ship has taken.
     */
    public int getHitCount() {
        return this.hitCount;
    }

    /**
     * holds the list of ships sunk.
     *
     * @return ships sunk.
     */
    public int getShipsSunk() {
        return this.shipsSunk;
    }

    //check if game is over (all ships sunk)

    /**
     * Determines if the game is over by checking to see if all of the ships have been sunk.
     *
     * @return boolean of whether ships sunk is greater than or equal to the number of ocean grid locations.
     */
    boolean isGameOver() {
        return this.getShipsSunk() >= Ocean.OCEAN_SIZE;
    }

    //return ship array

    /**
     * Prints the remaining ships.
     *
     * @return an array of the remaining ships.
     */
    Ship[][] getShipArray() {
        return this.ships;
    }

    void print() {
      System.out.print("  ");

      //print column numbers
      for (int i = 0; i < this.ships.length-1; i++) {
          System.out.print(i + " ");
      }

      System.out.println();

      //print row numbers
      Ship ship;
      for (int i = 0; i < this.ships.length-1; i++) {
          System.out.print(i + " ");

          //print ship values
          for (int j = 0; j < this.ships[i].length; j++) {
              ship = this.ships[i][j];

              //if ship has been sunken or if location has ben shot at and ht or nothing found
              if (ship.isSunk() || ship.getLocationHit(i,j)) {
                  System.out.print(ship + " ");
              }
              else {
                  System.out.print("." + " ");
              }
          }
          System.out.println();
      }
    }

    
	public void debugPrint() {
	    	
	    	Ship[][] shipArray = this.getShipArray();
	    	
	    	
	    	for (int i = 0; i <= 10; i++) {
				if (i == 0) {
					System.out.print("  ");
				} else if (i == 1) {
					System.out.print(0 + "\t");
				} else {
					System.out.print(i-1 + "\t");
				}
				for (int j = 0; j < 10; j++) {
					if (i == 0) {
						System.out.print(j + "\t");
					} else {
						System.out.print(shipArray[i][j].getShipType() + " ");
					}
					
					
				}
				System.out.println(' ');
			} 
    }
}

