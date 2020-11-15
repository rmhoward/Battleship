package battleship;

public class Submarine extends Ship {

    public Submarine(int length) {
    	super(length);
    	
        this.length = 1;
    }

    public String getShipType() {
        return "Submarine";
    }
}
