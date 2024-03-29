/*
  Written by: Rachael Howard (82772985), Benjamin Thanyawatpokin (52147828),
  and Christian Pearson (86344425)
  Sources: Recitation, office hours, and Piazza posts.
 */

package battleship;

/**
 * Empty Sea is a class that is derived from Ship
 * EmptySea serves a "catch-all" ship filling in the spaces in the game board array where there is no ship.
 * The effect is every location in the array has a "ship". The ship will be an actual ship or a EmptySea.
 */
public class EmptySea extends Ship {

    /**
     * EmptySea hass a length of one.
     */
    public EmptySea() {
        super(1);
    }


    /**
     * Overrides shootAt method so any shot at a tile with Empty Sea returns false.
     * takes an int for the row of the grid location and a int for the column of the grid location.
     * @return false always to indicate that nothing was hit
     */
    @Override
    public boolean shootAt(int row, int column) {
        //call shootAt from Ship to populate hit array if they shoot at empty sea
        super.shootAt(row,column);
        return false;
    }


    /**
     * Overrides isSunk method so any shot at a tile with Empty Sea returns false.
     * takes an int for the row of the grid location and a int for the column of the grid location.
     * @return always false to indicate nothing was sunk
     */
    //overrides isSunk if nothing is sunk
    @Override
    public boolean isSunk() {
        return false;
    }


    /**
     * EmptySea returns a "-" on the game board which represents a grid location with no ship.
     */
    //overrides toString() to print a dash
    @Override
    public String toString() {
        return "-";
    }


    /**
     * EmptySea returns a " " when there is a call for a particular ship.
     */
    @Override
    public String getShipType() {
        return "empty";
    }

}

