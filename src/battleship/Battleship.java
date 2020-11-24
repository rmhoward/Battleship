//
package battleship;

public class Battleship extends Ship {

	/**
	 * The shipLength is derived from the ship class. 
	 * Battleship has a shipLength of 4.
	 * The bow will always face the right of the gameboard
	 */
	private static final int shipLength = 4;
	
    public Battleship() {
    	
    	super(shipLength);
    }

    @Override
    public String getShipType() {
        return "Battleship";
    }

}
