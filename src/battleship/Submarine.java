package battleship;

/**
 * Creates the Submarine class which is an an extension form the Ship class
 */
public class Submarine extends battleship.Ship {

    /**
     * The shipLength is derived from the ship class.
     * Submarine has a shipLength of 1.
     * The bow will always face the right of the gameboard.
     */
    private static final int shipLength = 1;


    /**
     * @param the length of the Submarine
     * @return the Submarine length
     */
    public Submarine() {

        super(shipLength);

    }

    /**
     * Overrides the ship method to return "Submarine"
     */
    @Override
    public String getShipType() {
        return "Submarine";
    }
}
