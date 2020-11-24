package battleship;

import java.util.Scanner;

public class BattleshipGame {
	
	/**
	 * Main function for Battleship game
	 */
	public static void main(String[] args) {
		Ocean ocean = new Ocean();
		
		ocean.placeAllShipsRandomly();

		Scanner scanner = new Scanner(System.in);

		while (!ocean.isGameOver()) {

			ocean.print();

			System.out.print("Enter row,column: ");
			
			String rowColPair = scanner.nextLine();
			
			String[] rowColPairArray = rowColPair.split(",");

			String rowStr = rowColPairArray[0].trim();
			String colStr = rowColPairArray[1].trim();

			try {
				/**
				 * Value representing the row ("x" axis) of the gameboard
				 */
				int row = Integer.parseInt(rowStr);
				
				/**
				 * Value representing the column ("y" axis) of the gameboard
				 */
				int column = Integer.parseInt(colStr);

				//fire a shot
				/**
				 * Boolean determining whethrt the ship has successfully hit. 
				 */
				boolean shootSuccess = ocean.shootAt(row, column);

			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				
				//prints custom error message from withdraw message
				System.out.println(e.getMessage());
			} 
		}
	}
	
}

