package battleship;

public class Battleship extends Ship {

	private static final int shipLength = 4;
	
    public Battleship(int length) {
    	
    	super(shipLength);
    }

    @Override
    public String getShipType() {
        return "Battleship";
    }

}
