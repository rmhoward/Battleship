package battleship;

public class BattleshipGame {
	
	
	public static void main(String[] args) {
		Ocean ocean = new Ocean;
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
				int row = Integer.parseInt(rowStr);
				int column = Integer.parseInt(colStr);

				//fire a shot
				boolean shootSuccess = ocean.shootAt(row, column);

			}
		}
	}
	
	
	
	
}

