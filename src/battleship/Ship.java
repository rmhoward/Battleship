/*
  Written by: Rachael Howard (82772985), Benjamin Thanyawatpokin (52147828),
  and Christian Pearson ()
  Sources: Recitation, office hours, and Piazza posts.
 */

package battleship;

/**
 * The Ship class is comprised of objects generated for the player to interact with on the Gameboar
 * All of the ships and the EmptySea are subclasses of Ship
 */
public abstract class Ship {


    /**
     * BowRow is the x-axis location of the Ship instance's bow
     */
    private int bowRow;


    /**
     * BowColumn is the y-axis location of the Ship instance's bow
     */
    private int bowColumn;


    /**
     * length is the number of locations the ship takes up.
     */
    private final int length;

    /**
     * Determines if the ship is placed horizontally or verticially.
     */
    private boolean horizontal;


    /**
     * Array of hits on a particular instance of a ship
     */
    private final boolean[] hit;


    /**
     * This constructor sets the length property of the particular ship and initializes
     * the hit array
     * @param length
     */
    public Ship(int length) {
        this.length = length;

        //set hit tracker to an array of size 4.
        this.hit = new boolean[4];
    }


    /**
     * Returns length of ship
     * @return length
     */
    public int getLength() {
        return this.length;
    }


    /**
     * Returns row # of bow
     * @return bowRow
     */
    public int getBowRow() {
        return this.bowRow;
    }


    /**
     * Returns column # of bow
     * @return bowColumn
     */
    public int getBowColumn() {
        return this.bowColumn;
    }


    /**
     * Returns the hit array
     * @return hit
     */
    public boolean[] getHit() {
        return hit;
    }


    /**
     * Returns whether or not ship is horizontal
     * @return true if horizontal, otherwise false
     */
    public boolean isHorizontal() {
        return this.horizontal;
    }


    /**
     * Sets row # of bow
     */
    public void setBowRow(int row) {
        this.bowRow = row;
    }


    /**
     * Returns column # of bow
     */
    public void setBowColumn(int column) {
        this.bowColumn = column;
    }


    /**
     * Sets the value of the instance variable horizontal
     * @param horizontal
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }


    /**
     * Provides the string of an instance of the ship.
     */
    public abstract String getShipType();


    /**
     * Based on the given row, column, and orientation, returns true if it is okay to put a ship of this length
     * with its bow in this location; false otherwise. The ship must not overlap another ship, or touch another
     * ship (vertically, horizontally, or diagonally), and it must not ”stick out” beyond the array. Does not
     * actually change either the ship or the Ocean -it just says if it is legal to do so.
     * @return true if it can place a ship legally and false if it cannot
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        int shipLength = this.getLength();
        Ship[][] shipArray = ocean.getShipArray();

        if (horizontal) {
            int stern = column - (shipLength-1);

            if (stern < 0) {
                return false;
            }

            //check around ship for adjacent ships
            for (int i = column; i >= stern; i--) {

                //check if another ship in same location
                if (!this.isEmpty(shipArray[row][i])) {
                    return false;
                }

                //if bow
                if (i == column) {
                    //adjacent to right
                    if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                        if (!this.isEmpty(shipArray[row][column+1])) {
                            return false;
                        }
                    }
                    //top
                    if ((row - 1) >= 0) {

                        //adjacent top right
                        if ((i + 1) <= (Ocean.OCEAN_SIZE -1)) {
                            if (!this.isEmpty(shipArray[row-1][i+1])) {
                                return false;
                            }
                        }

                        //adjacent top
                        if (!this.isEmpty(shipArray[row-1][i])) {
                            return false;
                        }
                    }

                    //bottom
                    if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {

                        //adjacent bottom right
                        if ((i + 1) <= (Ocean.OCEAN_SIZE -1)) {
                            if (!this.isEmpty(shipArray[row+1][i+1])) {
                                return false;
                            }
                        }

                        //adjacent bottom
                        if (!this.isEmpty(shipArray[row+1][i])) {
                            return false;
                        }
                    }
                }
                //if stern
                if (i == stern) {

                    //stern check
                    if (!this.isEmpty(shipArray[row][stern])) {
                        return false;
                    }

                    //adjacent left
                    if ((i-1) >= 0) {
                        if(!this.isEmpty(shipArray[row][i-1])) {
                            return false;
                        }
                    }

                    //top
                    if ((row-1) >= 0) {

                        //adjacent top left
                        if ((i-1) >= 0) {
                            if (!this.isEmpty(shipArray[row-1][i-1])) {
                                return false;
                            }
                        }

                        //adjacent top
                        if (!this.isEmpty(shipArray[row-1][i])) {
                            return false;
                        }
                    }

                    //bottom
                    if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {

                        //adjacent bottom left
                        if ((i - 1) >= 0) {
                            if (!this.isEmpty(shipArray[row+1][i-1])) {
                                return false;
                            }
                        }

                        //adjacent bottom
                        if (!this.isEmpty(shipArray[row+1][i])) {
                            return false;
                        }
                    }
                }
                //all other locations
                if ((i < column) && (i > stern)) {

                    //adjacent top
                    if ((row - 1) >= 0) {
                        if (!this.isEmpty(shipArray[row-1][i])) {
                            return false;
                        }
                    }
                    //adjacent bottom
                    if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                        if (!this.isEmpty(shipArray[row+1][i])) {
                            return false;
                        }
                    }
                }
            }
        } else {
            int stern = row - (shipLength-1);

            if (stern < 0) {
                return false;
            }

            //check around ship for adjacent ships
            for (int i = row; i >= stern; i--) {

                //check if another ship in same location
                if (!this.isEmpty(shipArray[i][column])) {
                    return false;
                }

                //if bow
                if (i == row) {
                    //adjacent bottom
                    if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                        if (!this.isEmpty(shipArray[row+1][column])) {
                            return false;
                        }
                    }
                    //top
                    if ((column - 1) >= 0) {

                        //adjacent bottom left
                        if ((i + 1) <= (Ocean.OCEAN_SIZE -1)) {
                            if (!this.isEmpty(shipArray[i+1][column-1])) {
                                return false;
                            }
                        }

                        //adjacent left
                        if (!this.isEmpty(shipArray[i][column-1])) {
                            return false;
                        }
                    }
                    //
                    if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {

                        //adjacent bottom right
                        if ((i + 1) <= (Ocean.OCEAN_SIZE -1)) {
                            if (!this.isEmpty(shipArray[i+1][column+1])) {
                                return false;
                            }
                        }

                        //adjacent bottom
                        if (!this.isEmpty(shipArray[i][column+1])) {
                            return false;
                        }
                    }
                }
                //if stern
                if (i == stern) {

                    //stern check
                    if (!this.isEmpty(shipArray[stern][column])) {
                        return false;
                    }

                    //adjacent top
                    if ((i-1) >= 0) {
                        if(!this.isEmpty(shipArray[i-1][column])) {
                            return false;
                        }
                    }

                    //left
                    if ((column-1) >= 0) {

                        //adjacent top left
                        if ((i-1) >= 1) {
                            if (!this.isEmpty(shipArray[i-1][column-1])) {
                                return false;
                            }
                        }

                        //adjacent left
                        if (!this.isEmpty(shipArray[i][column-1])) {
                            return false;
                        }
                    }

                    //right
                    if ((column+1) <= (Ocean.OCEAN_SIZE - 1)) {

                        //adjacent top right
                        if ((i - 1) >= 1) {
                            if (!this.isEmpty(shipArray[i-1][column+1])) {
                                return false;
                            }
                        }

                        //adjacent right
                        if (!this.isEmpty(shipArray[i][column+1])) {
                            return false;
                        }
                    }
                }
                //all other locations
                if ((i < row) && (i > stern)) {

                    //adjacent left
                    if ((column - 1) >= 0) {
                        if (!this.isEmpty(shipArray[i][column-1])) {
                            return false;
                        }
                    }
                    //adjacent right
                    if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                        if (!this.isEmpty(shipArray[i][column+1])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * “Puts” the ship in the ocean. This involves giving values to the bowRow, bowColumn, and
     * horizontal instance variables in the ship, and it also involves putting a reference to the
     * ship in each of 1 or more locations (upto4) in the ships array in the Ocean object.
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.setBowRow(row);
        this.setBowColumn(column);
        this.setHorizontal(horizontal);

        int shipLength = this.getLength();
        if (this.isHorizontal()) {
            int stern = column - (shipLength - 1);
            for (int i = column; i >= stern; i--) {
                ocean.getShipArray()[row][i] = this;
            }
        } else if (!this.isHorizontal()) {
            int stern = row - (shipLength - 1);
            for (int i = row; i >= stern; i--) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }


    /**
     * If a part of the ship occupies the given row and column, and the ship hasn’t been sunk, mark that part of the
     * ship as “hit” (in the hit array, index 0 indicates the bow)
     * @param row location to shoot at
     * @param column location to shoot at
     * @return true if hit, false if not
     */
    public boolean shootAt(int row, int column) {
        if (!this.isSunk()) {
            int shipSpaceCount = 0;
            if (this.isHorizontal()) {
                int stern = this.getBowColumn() - (this.getLength()-1);
                if (row == this.getBowRow()) {
                    for (int i = this.getBowColumn(); i >= stern; i--) {
                        if (column == i) {
                            shipSpaceCount = this.getBowColumn() - i;
                            this.getHit()[shipSpaceCount] = true;
                            return true;
                        }
                    }
                }
            } else if (!this.isHorizontal()) {
                int stern = this.getBowRow() - (this.getLength() - 1);
                if (column == this.getBowColumn()) {
                    for (int i = this.getBowRow(); i >= stern; i--) {
                        if (row == i) {
                            shipSpaceCount = this.getBowRow() - i;
                            this.getHit()[shipSpaceCount] = true;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    /**
     * Checks to see if all parts of a ship are hit
     * @return true if all parts have been hit, false otherwise
     */
    public boolean isSunk() {
        for (int i = 0; i <= this.getLength() - 1; i++) {
            if (!this.getHit()[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Overrides toString()
     * @return s if ship is sunk, x if ship is hit
     */
    @Override
    public String toString() {
        String shipCharacter = "";
        if (this.isSunk()) {
            shipCharacter = "s";
        }
        else {
            shipCharacter = "x";
        }
        return shipCharacter;
    }


    /**
     * Checks to see if there is a ship in the given location
     * @param ship
     * @return "empty" for the given ship if nothing is there
     */
    private boolean isEmpty(Ship ship) {
        return "empty".equals(ship.getShipType());
    }


    /**
     * Gets the precise location (row and column) of where the ship was hit. Used
     * to print an X if it is hit or an S if it is hit and sunk with said hit
     * @param row
     * @param column
     * @return the precise location of where the ship was hit.
     */
    boolean getLocationHit (int row, int column) {
          int shipSpaceCount = 0;
          if (this.isHorizontal()) {
               shipSpaceCount = this.getBowColumn() - column;
               return this.getHit()[shipSpaceCount];
          } else if (!this.isHorizontal()) {
               shipSpaceCount = this.getBowRow() - row;
               return this.getHit()[shipSpaceCount];
          }
          return false;
    }

}