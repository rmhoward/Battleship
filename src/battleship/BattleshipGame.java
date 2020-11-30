package battleship;

import java.util.Scanner;

import java.util.Random;

public class BattleshipGame {

    /**
     * Main function for Battleship game
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        boolean gameLoop = true;
        
        while (gameLoop == true) { 
        	
            Ocean ocean = new Ocean();
            
            ocean.placeAllShipsRandomly();

            //Welcome messages and rules
            System.out.println("WELCOME TO BATTLESHIP!");
            System.out.println("Instructions: The computer (your nemesis) has placed 10 ships randomly on a 10x10 ocean. ");
            System.out.println("There are 4 Submarines (length 1), 3 Destroyers (length 2), 2 Cruisers (length 3) and ");
            System.out.println("1 Battleship (length 4). Aim your cannon at a space on the ocean and try to sink all of");
            System.out.println("the ships. Your final score is how many shots you took to win the game.");
            System.out.println(" ");


            //for debugging
            ocean.debugPrint();
            
	        while (!ocean.isGameOver()) {
	
	            ocean.print();
	            
	            boolean shootCheck = true;
	            
	            while (shootCheck == true) {
	            	
		            try {
		            
		            System.out.print("Cannons Loaded! Enter row, column: ");
		            
		
		            String rowColPair = scanner.nextLine();
		
		            String[] rowColPairArray = rowColPair.split(",");
		
		            String rowStr = rowColPairArray[0].trim();
		            String colStr = rowColPairArray[1].trim();
		
		            
		                int row = Integer.parseInt(rowStr);
		                int column = Integer.parseInt(colStr);
		
		                //fire a shot
		                boolean shootSuccess = ocean.shootAt(row, column);
		
		                if (shootSuccess) {
		                    System.out.println("hit");
		
		                    //get location of ships
		                    Ship[][] shipArray = ocean.getShipArray();
		                    Ship ship = shipArray[row][column];
		
		                    if (ship.isSunk()) {
		                        System.out.println("You just sunk a ship - "+ship.getShipType());
		                        System.out.println("You have sunk "+ ocean.getShipsSunk() + " ships");
		                    }
		                } else {
		                    System.out.println("miss");
		                }
		                
		                shootCheck = false;
		                break;
		
		            } catch (Exception e) {
		            	System.out.println("Enter a valid location or correctly format it.");
		            	shootCheck = true;
		            }
	            }
	        }
	        
	        //Game over messages
	        System.out.println(" ");
	        System.out.println("The game is over.");
	        System.out.println("You fired " + ocean.getShotsFired() + " shots.");
	        
	        System.out.println("Do you want to play again? Y/N");
	        
	        boolean gameLoopCheck = false;
	        
	        while (gameLoopCheck == false) {
	        	try {
			        String again = scanner.nextLine();
			        again = again.toLowerCase();
			        if (again.startsWith("n") == true) {
			        	gameLoop = false;
			        	gameLoopCheck = true;
			        } else if (again.startsWith("y") == true) {
			        	gameLoop = true;
			        	gameLoopCheck = true;
			        } else {
			        	System.out.println("Enter a message that begins with Y or N. Pretty please.");
			        }
	        	} catch (Exception e) {
	        		System.out.println("Please enter a valid string");
	        	}
	        }
        }
        System.out.println("Thank you so much for playing!");
        scanner.close();
    }
}


