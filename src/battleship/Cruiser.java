package battleship;

public class Cruiser extends Ship {
	
	/**
	 * The shipLength is derived from the ship class. 
	 * Cruiser has a shipLength of 3.
	 * The bow will always face the right of the gameboard.
	 */
	private static final int shipLength = 3;

    public Cruiser(int length) {
    	
    	super(shipLength);

    }

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}


