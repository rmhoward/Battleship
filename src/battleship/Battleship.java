/*
  Written by: Rachael Howard (82772985), Benjamin Thanyawatpokin (52147828),
  and Christian Pearson (86344425)
  Sources: Recitation, office hours, and Piazza posts.
 */

package battleship;

/**
 * Creates the Battleship class which is an an extension form the Ship class
 */
public class Battleship extends Ship {


    /**
     * The shipLength is derived from the ship class.
     * Battleship has a shipLength of 4.
     * The bow will always face the right of the gameboard.
     */
    private static final int shipLength = 4;


    /**
     * @param the length of the Submarine
     * @return the Submarine length
     */
    public Battleship() {
        super(shipLength);
    }


    /**
     * Overrides the ship method to return "Battleship"
     */
    @Override
    public String getShipType() {
        return "battleship";
    }

}
