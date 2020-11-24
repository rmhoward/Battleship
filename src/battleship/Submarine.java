package battleship;

public class Submarine extends Ship {
	
	private static final int shipLength = 1;
	
    public Submarine() {
    	
    	super(shipLength);

    }

    @Override
    public String getShipType() {
        return "Submarine";
    }
}
