package battleship;

public class Battleship extends Ship {

	
    public Battleship(int length) {
    	
    	super(length);
    	
        this.length = 4;
    }

    public String getShipType() {
        return "Battleship";
    }

}
