package battleship;

import java.util.Scanner;

import java.util.Random;

public class BattleshipGame {
	
	
	public static void main(String[] args) {
		Ocean ocean = new Ocean();
<<<<<<< HEAD
		
=======

>>>>>>> a0d43c30af7168fbbdb559041ddf133b917b1c41
		ocean.print();
		
		System.out.println();
		
		ocean.placeAllShipsRandomly();
		
		ocean.debugPrint();
	
//		
//		ocean.placeAllShipsRandomly();
//
//		Scanner scanner = new Scanner(System.in);
//
//		while (!ocean.isGameOver()) {
//
		
		
//			ocean.print();
//
//			System.out.print("Enter row,column: ");
//			
//			String rowColPair = scanner.nextLine();
//			
//			String[] rowColPairArray = rowColPair.split(",");
//
//			String rowStr = rowColPairArray[0].trim();
//			String colStr = rowColPairArray[1].trim();
//
//			try {
//				int row = Integer.parseInt(rowStr);
//				int column = Integer.parseInt(colStr);
//
//				//fire a shot
//				boolean shootSuccess = ocean.shootAt(row, column);
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
////				e.printStackTrace();
//				
//				//prints custom error message from withdraw message
//				System.out.println(e.getMessage());
//			} 
//		}
		
		
		
		
<<<<<<< HEAD
	}
}
=======
		

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
>>>>>>> a0d43c30af7168fbbdb559041ddf133b917b1c41
