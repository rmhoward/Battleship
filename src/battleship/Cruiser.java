/*
  Written by: Rachael Howard (82772985), Benjamin Thanyawatpokin (52147828),
  and Christian Pearson (86344425)
  Sources: Recitation, office hours, and Piazza posts.
 */

package battleship;

/**
 * Creates the Cruiser class which is an extenion of the Ship class
 */
public class Cruiser extends Ship {

    /**
     * The shipLength is derived from the ship class.
     * Cruiser has a shipLength of 3.
     * The bow will always face the right of the gameboard.
     */
    private static final int shipLength = 3;


    /**
     * @param the length of the Cruiser
     * @return the Submarine length
     */
    public Cruiser() {
        super(shipLength);
    }


    /**
     * Overrides the ship method to return "Cruiser"
     */
    @Override
    public String getShipType() {
        return "cruiser";
    }
}


