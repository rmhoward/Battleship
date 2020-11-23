package battleship;

public class Battleship extends Ship {

	/**
	 * The shiplength is derived from the ship class. 
	 * Battleship has a shipLengh of 4.
	 */
	private static final int shipLength = 4;
	
    public Battleship(int length) {
    	
    	super(shipLength);
    }

    @Override
    public String getShipType() {
        return "Battleship";
    }

}
