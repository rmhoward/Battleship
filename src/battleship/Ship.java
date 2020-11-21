package battleship;

public abstract class Ship {

	//instance vars
	
    private int bowRow;

    private int bowColumn;
    
    private int length;

    private boolean horizontal;

    private boolean[] hit
      
    //abstract methods
    
    public abstract String getShipType();   
    
    
    //public methods
    
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    }

    public boolean shootAt(int row, int column) {
    }

    public boolean isSunk() {
    }
    
    public boolean isHorizontal() {
    }
    
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	
        int shipLength = this.getLength();
        
        Ship[][] shipArrray = ocean.getShipArray();

        if (horizontal) {
            int stern = column - (shipLength - 1);
            if (stern < 0) {
                return false;
            }

            if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
                if (!this.isEmpty(shipArray[row][column+1])) {
                    return false;
                }
            } if ((row - 1) >= 0) {
            	return true;
            	}
        } 
      } 


    //constructors
    
    public Ship(int length) {
    	this.length = length;

    	//set hit tracker to size 4
    	this.hit = new boolean[4];
    }

    
    //getters/setters
    
    public int getLength() {
    	return length;
    }
    
    public int getBowRow() {
    	return bowRow;
    }

    public int getBowColumn() {
    	return bowColumn;
    }
    

    public boolean[] getHit() {
    	return hit;
    }

    public void setBowRow(int row) {
    	this.bowRow = row;
    }

    public void setBowColumn(int column) {
    	this.bowColumn = column;
    }

    public void setHorizontal(boolean horizontal) {
    	this.horizontal = horizontal;
    }
    
    
    //override methods
    
    @Override
    public String toString() {
    	return null;
    }


}
