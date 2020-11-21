package battleship;

public class EmptySea extends Ship {
	
    public EmptySea() {
    	super(1);
    }

    //overrides shootAt if nothing was hit
    @Override
    public boolean shootAt(int row, int column) {

        //call shootAt from Ship to populate hit array if they shoot at empty sea
        super.shootAt(row,column);

        return false;
    }

    //overrides isSunk if nothing is sunk
    @Override
    public boolean isSunk() {
        return false;
    }


    //getters/setters
    @Override
    public String getShipType() {
        return "empty";
    }


    //overrides toString() to print a dash
    @Override
    public String toString() {
        return "-";
    }
}
