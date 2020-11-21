package battleship;

public class Destroyer extends Ship {

	private static final int shipLength = 2;
	
    public Destroyer(int length) {
    	
    	super(shipLength);

    }

    @Override
    public String getShipType() {
        return "Destroyer";
    }
}

