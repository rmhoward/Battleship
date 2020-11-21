package battleship;

public class Cruiser extends Ship {
	
	private static final int shipLength = 3;

    public Cruiser(int length) {
    	
    	super(shipLength);

    }

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}


