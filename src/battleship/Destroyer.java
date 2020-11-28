package battleship;

/**
 * Creates the Cruiser class which is an extenion of the Ship class
 */
public class Destroyer extends Ship {

	/**
	 * The shipLength is derived from the ship class. 
	 * Destroyer has a shipLength of 2.
	 * The bow will always face the right of the gameboard.
	 */
	private static final int shipLength = 2;
	
    /**
     * @param the length of the Destroyer
     * @return the Submarine length
     */
    public Destroyer(int length) {
    	
    	super(shipLength);

    }

    /**
     * Overrides the ship method to return "Destroyer"
     */
    @Override
    public String getShipType() {
        return "Destroyer";
    }
}

