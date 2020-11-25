package battleship;

import java.util.Scanner;

import java.util.Random;

public class BattleshipGame {
	
	
	public static void main(String[] args) {
		Ocean ocean = new Ocean();
		
		ocean.print();
		
		
//		System.out.println(ocean.ships[1][1]);
		
		Battleship battleship = new Battleship();
		
		System.out.println(battleship.isHorizontal());
		
		Random rand = new Random();
		
		int random = rand.nextInt(11) + 1;
		
		System.out.println(random);
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
		
		int [][]array = new int[11][10];
		
		array[0][0] = 0;
		
		array[3][2] = 7;
		array[3][3] = 7;
		array[3][4] = 7;
		array[3][5] = 7;
		
		System.out.println();
		
		String s = "\n";
//		
//		for (int i = 0; i <= 10; i++) {
//			if (i == 0) {
//				System.out.print("  ");
//			} else if (i == 1) {
//				System.out.print(0 + " ");
//			} else {
//				System.out.print(i-1 + " ");
//			}
//			for (int j = 0; j < 10; j++) {
//				if (i == 0) {
//					System.out.print(j + " ");
//				} else {
//					System.out.print("-" + " ");
//				}
//				
//				
//			}
//			System.out.println(' ');
//		}
		
		
		
		
	}
}