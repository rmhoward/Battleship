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
    
    
    // Update from  11/24: I think I fixed it. Please check when you have the chance
    // Previous code has been left in but commented out - Ben
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	
    	int shipLength = this.length;
    	
    	Ship[][] shipArray = ocean.getShipArray();
    	
    	this.bowRow = row;
		this.bowColumn = column;
		
		//if horizontal,  put point at row/column, then column -1 for length of ship
    	if (horizontal) {
    		
    		this.horizontal = true;
    		
    		if (horizontal) {
    			for (int i = 0; i < shipLength ; i++) {
        			shipArray[row][column - i]  = this;
        		};
    		} else {
    			for (int i = 0; i < shipLength ; i++) {
        			shipArray[row - i][column]  = this;
        		};
    		}
    		
    		
    	}
//    		for (int i = 0; i < shipLength; i++) {
//    			if (shipLength == 1) {
//    				shipArray[row][column - i] = new Submarine();
//    			} else if (shipLength == 2) {
//    				shipArray[row][column - i] = new Destroyer();
//    			} else if (shipLength == 3) {
//    				shipArray[row][column - i] = new Cruiser();
//    			} else  {
//    				shipArray[row][column - i] = new Battleship();
//    			}
//    		}
//    	
//    	//if vertical, put points, then -1 to row for length of ship	
//    	} else {
//    		this.horizontal = false;
//    		for (int i = 0; i < shipLength; i++) {
//    			if (shipLength == 1) {
//    				shipArray[row][column - i] = new Submarine();
//    			} else if (shipLength == 2) {
//    				shipArray[row][column - i] = new Destroyer();
//    			} else if (shipLength == 3) {
//    				shipArray[row][column - i] = new Cruiser();
//    			} else  {
//    				shipArray[row][column - i] = new Battleship();
//    			}
//    		}
//    	}
    	
    	
    	
    }

    public boolean shootAt(int row, int column) {
    	return true;
    }

    public boolean isSunk() {
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
        
        try {
        	if (row ==  0 || column == 0) {
        		return false;
        	} else if (horizontal) {
        		for (int i =  0; i < shipLength; i++) {
        			column -= 1;
        			if (column == 0) {
        				return false;
        			} 
        		}
        	} else {
        		for (int i =  0; i < shipLength; i++) {
        			row -= 1;
        			if (row == 0) {
        				return false;
        			} 
        		}
        	}
        } catch (Exception e) {
        	return false;
        }
    	return true;
    }
    
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
    	
        int shipLength = this.getLength();
        
        // CHECK THIS:
        // on end points (first and final points) runs isOccupied() in this order: Current point, one in front/behind, diagonal1, diagonal2, below, above
        // on mid points runs isOccupied in this order: current point, below, above
        if (horizontal) {
        	for (int i = 0; i >= shipLength; i++) {
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
        				return false;
        			}
        		}
        	}
        
        	// Vertical implementation.
        	// on end points runs isOccupied() in following order: Current point, one above/below, diagonal1, diagonal2, right, left
        	// on mid points runs isOccupied in this order: current point, right, left
        } else {
        	for (int i = 0; i >= shipLength; i++) {
        		if (i == 0) {
        			if (ocean.isOccupied(row, column) || ocean.isOccupied(row + 1, column) || ocean.isOccupied(row + 1, column - 1) || ocean.isOccupied(row + 1, column + 1)|| ocean.isOccupied(row, column + 1) || ocean.isOccupied(row, column - 1)) {
        				return false;
        			} 
        		} else if (i == shipLength) {
        			if (ocean.isOccupied(row  - shipLength + 1, column) || ocean.isOccupied(row  - shipLength, column) ||  ocean.isOccupied(row  - shipLength, column + 1) || ocean.isOccupied(row  - shipLength, column - 1) ||  ocean.isOccupied(row  - shipLength + 1, column + 1) || ocean.isOccupied(row - shipLength + 1, column - 1)) {
        				return false;
        			}
        		} else {
        			if (ocean.isOccupied(row - i, column) || ocean.isOccupied(row -i, column + 1) || ocean.isOccupied(row - i, column - 1)) {
        				return false;
        			}
        		}
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
