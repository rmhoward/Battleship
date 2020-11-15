package battleship;

public class Cruiser extends Ship {

    public Cruiser(int length) {
    	
    	super(length);
    	
        this.length = 3;
    }

    public String getShipType() {
        return "Cruiser";
    }
}


