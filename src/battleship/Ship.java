package battleship;

import java.util.Arrays;

/**
 * The Ship class is comprised of objects generated for the player to interact with on the Gameboar
 * All of the ships and the EmptySea are subclasses of Ship
 */
public abstract class Ship {

    //instance vars

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
     * Determins if the ship is placed horizontally or verticially. 
     */
    private boolean horizontal;

    /**
     * Array of hits on a particular instance of a ship
     */

    private final boolean[] hit;

    //shows if ship has been hit at any point
    private final boolean isHit = false;


    //show if a ship is in a given location
    private boolean isEmpty(Ship ship) {
        return "empty".equals(ship.getShipType());
    }

    //abstract methods


    /**
     * Provides the string of an instance of the ship. 
     */
    public abstract String getShipType();


    //public methods


    // THIS ISN'T RIGHT, BUT I CAN'T FIGURE IT OUT RIGHT NOW, PLEASE REVISE.
    /**
     * Places an instance of the ship on the gameboard
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
     * Mark ship as hit if they are in the given row and column of the hit array, as long as they are not sunk
     * @param row location to shoot at
     * @param column location to shoot at
     * @return hit or not
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
     * Returns whether or not ship is horizontal
     * @return true if horizontal, otherwise false
     */
    public boolean isHorizontal() {
        return this.horizontal;
    }


            /**
             * Checks to see if all parts of a ship are hit
             * @return true if sunk
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
             * Checks if there is sufficient room to place a ship at a particular location.
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
                            //TODO FIX EVERYTHING BELOW HERE
                            if ((row - 1) >= 0) {
                                if (!this.isEmpty(shipArray[row-1][i])) {
                                    return false;
                                }
                            }
                            //adjacent right
                            if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                                if (!this.isEmpty(shipArray[i][column + 1])) {
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
                            //adjacent to right
                            if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                                if (!this.isEmpty(shipArray[row+1][column])) {
                                    return false;
                                }
                            }
                            //top
                            if ((column - 1) >= 0) {

                                //adjacent top right
                                if ((i + 1) <= (Ocean.OCEAN_SIZE -1)) {
                                    if (!this.isEmpty(shipArray[i+1][column-1])) {
                                        return false;
                                    }
                                }

                                //adjacent top
                                if (!this.isEmpty(shipArray[i][column-1])) {
                                    return false;
                                }
                            }
                            //bottom
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

                            //adjacent top
                            if ((i-1) >= 0) {
                                if(!this.isEmpty(shipArray[row][i-1])) {
                                    return false;
                                }
                            }

                            //left
                            if ((row-1) >= 0) {

                                //adjacent top left
                                if ((i-1) >= 0) {
                                    if (!this.isEmpty(shipArray[row-1][i-1])) {
                                        return false;
                                    }
                                }

                                //adjacent left
                                if (!this.isEmpty(shipArray[row-1][i])) {
                                    return false;
                                }
                            }

                            //right
                            if ((row+1) <= (Ocean.OCEAN_SIZE - 1)) {

                                //adjacent top right
                                if ((i - 1) >= 0) {
                                    if (!this.isEmpty(shipArray[row+1][i-1])) {
                                        return false;
                                    }
                                }

                                //adjacent right
                                if (!this.isEmpty(shipArray[row+1][i])) {
                                    return false;
                                }
                            }
                        }
                        //all other locations
                        if ((i < column) && (i > stern)) {

                            //adjacent left
                            if ((row - 1) >= 0) {
                                if (!this.isEmpty(shipArray[row-1][i])) {
                                    return false;
                                }
                            }
                            //adjacent right
                            if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                                if (!this.isEmpty(shipArray[row+1][i])) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                return true;
            }

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
            //constructors

    public Ship(int length) {
                this.length = length;

                //set hit tracker to size 4
                this.hit = new boolean[4];
            }


            //getters/setters

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



            public boolean[] getHit() {
                return hit;
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


            public void setHorizontal(boolean horizontal) {
                this.horizontal = horizontal;
            }




            //override methods

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
        }