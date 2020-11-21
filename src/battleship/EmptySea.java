package battleship;

public class EmptySea extends Ship {

	private int length;
	
	
    public EmptySea() {
    	super(length);
    }

    @Override
    boolean shootAt(int row, int column) {
    }

    @Override
    boolean isSunk() {
    }



    //getters/setters
    
    @Override
    public String getShipType() {
    	return this.getShipType();
    }

    @Override
    public String toString() {
    	return "Empty Sea";
    }
}
