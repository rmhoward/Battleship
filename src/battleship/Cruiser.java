package battleship;

/**
 * Creates the Cruiser class which is an extenion
 */
public class Cruiser extends Ship {
	
	/**
	 * Permanently sets the length of Cruisers in the game to 3.
	 */
	private static final int shipLength = 3;

	/**
	 * The shipLength is derived from the ship class. 
	 * Cruiser has a shipLength of 3.
	 * The bow will always face the right of the gameboard.
	 */

    public Cruiser(int length) {
    	
    	super(shipLength);

    }

    /**
     * Overrides the ship method to return "Cruiser"
     */
    @Override
    public String getShipType() {
        return "Cruiser";
    }
}


