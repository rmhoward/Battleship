package battleship;

public abstract class Ship {

	//instance vars
	
    private int bowRow;

    private int bowColumn;
    
    private int length;

    private boolean horizontal;

    private boolean[] hit;
      
    //abstract methods
    
    public abstract String getShipType();   
    
    
    //public methods
    
    
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	
    	int shipLength = this.length;
    	
    	Ship[][] shipArray = ocean.getShipArray();
    	
    	this.bowRow = row;
		this.bowColumn = column;
		
		//if horizontal, put point at row/column, then column -1 for length of ship
    		
    	if (horizontal == true) {
    		for (int i = 0; i < shipLength; i++) {
        		shipArray[row][column - i] = this;
        		
        		//I'm not sure where to put it yet, but this marks it as horizontal, which carries over from ocean.
        		this.horizontal = true;
        	};
    	} else {
    		for (int i = 0; i < shipLength ; i++) {
        		shipArray[row - i][column] = this;
        		this.horizontal = false;
        	};
    	}
    }
<<<<<<< HEAD
    
    public boolean finalPlacement(int row, int column, boolean horizontal, Ocean ocean) {
    	
        //initializes boolean for checking grid suitability checking
        boolean noneOffGrid = false;
        
        //initialize boolean for checking location in relation to other  ships
        boolean locationOkay = false;
        	
        noneOffGrid = this.checkOffGrid(row, column, horizontal, ocean);
        	
        if (noneOffGrid == true) {
        	locationOkay = this.okToPlaceShipAt(row, column, horizontal, ocean);
        		
        	if (locationOkay == true) {
        		this.placeShipAt(row, column, horizontal, ocean);
        		return true; 
        	}
        }
        return false;
    }  
    
=======

>>>>>>> a0d43c30af7168fbbdb559041ddf133b917b1c41
	/**
	 * Mark ship as hit if they are in the given row and column of the hit array, as long as they are not sunk
	 * @param row location to shoot at
	 * @param column location to shoot at
	 * @return
	 */
    public boolean shootAt(int row, int column) {
    	if (!this.isSunk()) {
    		int shipSpaceCount = 0;
    		if (this.isHorizontal()) {
    			int stern = this.getBowColumn() - (this.getLength()-1);
    			if (row == this.getBowRow()) {
    				for (int i = this.getBowColumn(); i >= stern; i--) {
    					if (column == i) {
    						shipSpaceCount = this.getBowColumn() - i;
    						this.getHit()[shipSpaceCount] = true;
    						return true;
						}
					}
				}
			} else if (!this.isHorizontal()) {
				int stern = this.getBowRow() - (this.getLength() - 1);
				if (column == this.getBowColumn()) {
					for (int i = this.getBowRow(); i >= stern; i--) {
						if (row == i) {
							shipSpaceCount = this.getBowRow() - i;
							this.getHit()[shipSpaceCount] = true;
							return true;
						}
					}
				}
			}
		}
    	return false;
    }

	/**
	 * Checks to see if all parts of a ship are hit
	 * @return true if sunk
	 */
	public boolean isSunk() {
		for (int i = 0; i <= this.getLength() - 1; i++) {
			if (!this.getHit()[i]) {
				return false;
			}
		}
    	return true;
    }


    public boolean isHorizontal() {
    	if (this.horizontal == true) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
    //HELPER METHOD TO CHECK IF IN GRID (tries to place in the grid, if a error is thrown OR the number , it will return false)
    public boolean checkOffGrid(int row, int column, boolean horizontal, Ocean ocean) {
    	
    	int shipLength = this.getLength();
        
//        try {
        	if (row ==  0 || column == 0) {
        		return false;
        	} else if (horizontal) {
        		for (int i =  0; i <= shipLength; i++) {
        			column -= 1;
        			if (column == 0) {
        				return false;
        			} 
        		}
        	} else {
        		for (int i =  0; i <= shipLength; i++) {
        			row -= 1;
        			if (row == 0) {
        				return false;
        			} 
        		}
        	}
//        } catch (Exception e) {
//        	return false;
//        }
    	return true;
    }
    
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	
        int shipLength = this.getLength();
        
        // CHECK THIS:
        // UPDATE 11/26 - I added a try/catch, but it's still  not working. Getting errors. Will correctly format when this is working
        // on end points (first and final points) runs isOccupied() in this order: Current point, one in front/behind, diagonal1, diagonal2, below, above
        // on mid points runs isOccupied in this order: current point, below, above
        if (horizontal == true) {
        	
        	for (int i = 0; i <= shipLength; i++) {
//        		try {
        		if (i == 0) {
        			if (ocean.isOccupied(row, column) || ocean.isOccupied(row, column + 1) || ocean.isOccupied(row - 1, column + 1) || ocean.isOccupied(row + 1, column + 1)|| ocean.isOccupied(row + 1, column) || ocean.isOccupied(row - 1, column)) {
        				return false;
        			} 
        		} else if (i == shipLength) {
        			if (ocean.isOccupied(row, column - shipLength + 1) || ocean.isOccupied(row, column - shipLength) || ocean.isOccupied(row + 1, column - shipLength) || ocean.isOccupied(row - 1, column - shipLength) ||  ocean.isOccupied(row + 1, column - shipLength + 1) || ocean.isOccupied(row - 1, column - shipLength + 1)) {
        				return false;
        			}
        		} else {
        			if (ocean.isOccupied(row, column - i) || ocean.isOccupied(row + 1, column - i) || ocean.isOccupied(row - 1, column - i)) {
        				System.out.println(row);
        				System.out.println(column);
        				return false;
        			}
        		}
//        	} catch (Exception e)  {
//        		return false;
//        	}
        	}
        
        	// Vertical implementation.
        	// on end points runs isOccupied() in following order: Current point, one above/below, diagonal1, diagonal2, right, left
        	// on mid points runs isOccupied in this order: current point, right, left
        } else {
        	
        	for (int i = 0; i <= shipLength; i++) {
//        		try {
        		if (i == 0) {
        			if (ocean.isOccupied(row, column) || ocean.isOccupied(row + 1, column) || ocean.isOccupied(row + 1, column - 1) || ocean.isOccupied(row + 1, column + 1)|| ocean.isOccupied(row, column + 1) || ocean.isOccupied(row, column - 1)) {
        				return false;
        			} 
        		} else if (i == shipLength) {
        			if (ocean.isOccupied(row - shipLength + 1, column) || ocean.isOccupied(row - shipLength, column) ||  ocean.isOccupied(row  - shipLength, column + 1) || ocean.isOccupied(row  - shipLength, column - 1) ||  ocean.isOccupied(row  - shipLength + 1, column + 1) || ocean.isOccupied(row - shipLength + 1, column - 1)) {
        				return false;
        			}
        		} else {
        			if (ocean.isOccupied(row - i, column) || ocean.isOccupied(row - i, column + 1) || ocean.isOccupied(row - i, column - 1)) {
        				return false;
        			}
        		}
//        	} catch (Exception e) {
//        		return false;
//        	}
        }
        }
        
        return true;
//
//        if (horizontal) {
//            int stern = column - (shipLength - 1);
//            if (stern < 0) {
//                return false;
//            }
//
//            if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
//                if (!"empty".equals(shipArray[row][column+1].getShipType())) {
//                    return false;
//                }
//            } if ((row - 1) >= 0) {
//            	return true;
//            	}
//        }
//		return false; 
      } 


    //constructors
    
    public Ship(int length) {
    	this.length = length;

    	//set hit tracker to size 4
    	this.hit = new boolean[4];
    }

    
    //getters/setters

	/**
	 * Returns length of ship
	 * @return length
	 */
	public int getLength() {
    	return this.length;
    }

	/**
	 * Returns row # of bow
	 * @return bowRow
	 */
	public int getBowRow() {
    	return this.bowRow;
    }

	/**
	 * Returns column # of bow
	 * @return bowColumn
	 */
    public int getBowColumn() {
		return this.bowColumn;
    }


    public boolean[] getHit() {
    	return hit;
    }

	/**
	 * Sets row # of bow
	 * @return row number to set row
	 */
    public void setBowRow(int row) {
    	this.bowRow = row;
    }

	/**
	 * Returns column # of bow
	 * @return column number to set column
	 */
    public void setBowColumn(int column) {
    	this.bowColumn = column;
    }


	public void setHorizontal(boolean horizontal) {
    	this.horizontal = horizontal;
    }


	/**
	 * Returns whether or not ship is horizontal
	 * @param true if horizontal, otherwise false
	 */
//    public boolean isHorizontal() {
//    	return this.horizontal;
//	}
    
    //override methods

	/**
	 * Overrides toString()
	 * @return s if ship is sunk, x if ship is hit
	 */
	@Override
    public String toString() {
		String shipCharacter = "";
		if (this.isSunk()) {
			shipCharacter = "s";
		} else {
			shipCharacter = "x";
		}
    	return shipCharacter;
    }


}
