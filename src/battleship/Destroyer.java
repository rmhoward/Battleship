package battleship;

public class Destroyer extends Ship {

	/**
	 * The shipLength is derived from the ship class. 
	 * Destroyer has a shipLength of 2.
	 * The bow will always face the right of the gameboard.
	 */
	private static final int shipLength = 2;
	
	/**
	 * The shipLength is derived from the ship class. 
	 * Cruiser has a shipLength of 3.
	 * The bow will always face the right of the gameboard.
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

