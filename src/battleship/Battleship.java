//
package battleship;

/**
 * Creates the Battleship class which is an an extension form teh Ship class
 */
public class Battleship extends Ship {

	/**
	 *Permanently sets the length of Battleships in the game to 4. 
	 */
	private static final int shipLength = 4;
	
	/**
	 * The shipLength is derived from the ship class. 
	 * Battleship has a shipLength of 4.
	 * The bow will always face the right of the gameboard
	 */
    public Battleship(int length) {
    	
    	super(shipLength);
    }
    
    /**
     * Overrides the ship method to return "Battleship"
     */
    @Override
    public String getShipType() {
        return "Battleship";
    }

}
