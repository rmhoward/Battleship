/*
  Written by: Rachael Howard (82772985), Benjamin Thanyawatpokin (52147828),
  and Christian Pearson (86344425)
  Sources: Recitation, office hours, and Piazza posts.
 */

package battleship;

import java.util.Random;

/**
 * The Ocean class represents the game board for Battleship
 * Ocean holds the variables for the game including the ocean size, number of battleships, number of cruisers, number of destroyers, and number of submarines.
 * Zeros out constructors.
 */
public class Ocean {

    //static vars to set the size of the ocean (rows and columms) and the number of ships to be placed of each type
    static final int OCEAN_SIZE = 10;
    static final int NUM_BATTLESHIPS = 1;
    static final int NUM_CRUISERS = 2;
    static final int NUM_DESTROYERS = 3;
    static final int NUM_SUBMARINES = 4;


    /**
     * Used to quickly determine which ship is in any given location
     */
    private final Ship[][] ships = new Ship[Ocean.OCEAN_SIZE][Ocean.OCEAN_SIZE];


    /**
     * The total number of shots fired by the user
     */
    private int shotsFired;


    /**The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, every hit is
     * counted, even though additional “hits” don’t do the user any good.
     */
    private int hitCount;


    /**
     * The number of ships sunk (10 ships in all)
     */
    private int shipsSunk;


    /**
     * Creates and empty ocean using the helper method populateEmptyOcean(). Also intializes the varables shotsFired,
     * hitCount, and shipsSunk
     */
    public Ocean() {
        this.populateEmptyOcean();
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
    }


    /**
     * Randomly places all ships in the Ocean/GameBoard, with the larger ships being placed first.
     */
    public void placeAllShipsRandomly() {

        Random rand = new Random();

        int row;
        int column;
        boolean horizontal;

        //place battleships
        //For the total number of Battleships
        for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
            //Create a new battleship
            Ship battleship = new Battleship();
            //Randomly select any row number from 0-5 and add 4. This allows the battleship to be placed in the top row
            row = rand.nextInt(6) + 4;
            //Randomly select any column from 0-9
            column = rand.nextInt(10);
            //Randomly make a selection if it should be horizontal or not
            horizontal = rand.nextInt(2) != 0;
            //If the ship is NOT okay to be placed (if it is overlapping another ship, has something adjacent to it, etc.)
            while (!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
                //redo all of the above steps. Continue this until you find a place that is allowable
                row = rand.nextInt(6) + 4;
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) != 0;
            }
            //Place the battleship
            battleship.placeShipAt(row, column, horizontal, this);
        }

        //place cruisers
        //For the total number of cruisers
        for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
            //Create a new battleship
            Ship cruiser = new Cruiser();
            //Randomly select any row number from 0-6 and add 3. This allows the cruiser to be placed in the top row
            row = rand.nextInt(7) + 3;
            //Randomly select any column from 0-9
            column = rand.nextInt(10);
            //Randomly make a selection if it should be horizontal or not
            horizontal = rand.nextInt(2) != 0;
            //IF the ship is NOT okay to be placed (if it is overlapping another ship, has something adjacent to it, etc.)
            while (!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
                //redo all of the above steps. Continue this until you find a place that is allowable
                row = rand.nextInt(7) + 3;
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) != 0;
            }
            //Place the cruiser
            cruiser.placeShipAt(row, column, horizontal, this);
        }

        //place destroyers
        //For the total number of destroyers
        for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
            //Create a new destroyer
            Ship destroyer = new Destroyer();
            //Randomly select any row number from 0-7 and add 2. This allows the destroyer to be placed in the top row
            row = rand.nextInt(8) + 2;
            //Randomly select any column from 0-9
            column = rand.nextInt(10);
            //Randomly make a selection if it should be horizontal or not
            horizontal = rand.nextInt(2) != 0;
            //If the ship is NOT okay to be placed (if it is overlapping another ship, has something adjacent to it, etc.)
            while (!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
                //redo all of the above steps. Continue this until you find a place that is allowable
                row = rand.nextInt(8) + 2;
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) != 0;
            }
            //Place the destroyer
            destroyer.placeShipAt(row, column, horizontal, this);
        }

        //place submarines
        //For the total number of submarines
        for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
            //Create a new submarine
            Ship submarine = new Submarine();
            //Randomly select any row number from 0-8 and add 1. This allows the submarine to be placed in the top row
            row = rand.nextInt(9) + 1;
            //Randomly select any column from 0-9
            column = rand.nextInt(10);
            //Randomly make a selection if it should be horizontal or not
            horizontal = rand.nextInt(2) != 0;
            //If the ship is NOT okay to be placed (if it is overlapping another ship, has something adjacent to it, etc.)
            while (!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
                //redo all of the above steps. Continue this until you find a place that is allowable
                row = rand.nextInt(9) + 1;
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) != 0;
            }
//          //Place the submarine
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


    /**
     * Hold the shots fired by a player.
     * @return Number of shots fired
     */
    public int getShotsFired() {
        return this.shotsFired;
    }


    /**
     * Hold the number of hits a ship has taken.
     * @return Number of hits
     */
    public int getHitCount() {
        return this.hitCount;
    }


    /**
     * Holds the list of ships sunk.
     * @return Number of ships sunk.
     */
    public int getShipsSunk() {
        return this.shipsSunk;
    }


    /**
     * Determines if the game is over by checking to see if all of the ships have been sunk.
     * @return boolean of whether ships sunk is greater than or equal to the number of ocean grid locations.
     */
    boolean isGameOver() {
        return this.getShipsSunk() >= Ocean.OCEAN_SIZE;
    }


    /**
     * Prints the remaining ships.
     * @return an array of the remaining ships.
     */
     Ship[][] getShipArray() {
        return this.ships;
    }


    /**
     * Prints the Ocean. To aid the user, row numbers should be displayed along the left edge of the array, and
     * column numbers should be displayed along the top. Use ‘x’ to indicate a location that you have fired upon
     * and hit a (real) ship. Use ‘-’ to indicate a location that you have fired upon and found nothing there.
     * Use ‘s’ to indicate a location containing a sunken ship.
     */
    void print() {
        System.out.print("  ");

        //print column numbers
        for (int i = 0; i < this.ships.length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        //print row numbers
        Ship ship;
        for (int i = 0; i < this.ships.length; i++) {
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


    /**
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

}

