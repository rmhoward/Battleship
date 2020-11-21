package battleship;

public class Cruiser extends Ship {

    public Cruiser(int length) {
    	
    	super(length);
    	
        this.length = 3;
    }

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}


