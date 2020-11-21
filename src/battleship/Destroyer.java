package battleship;

public class Destroyer extends Ship {

    public Destroyer(int length) {
    	
    	super(length);
    	
        this.length = 2;
    }

    @Override
    public String getShipType() {
        return "Destroyer";
    }
}

