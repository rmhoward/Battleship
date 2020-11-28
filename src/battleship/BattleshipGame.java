package battleship;

import java.util.Scanner;

import java.util.Random;

public class BattleshipGame {

    /**
     * Main function for Battleship game
     */
    public static void main(String[] args) {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        
        ocean.debugPrint();

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

            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }
        //Game over messages
        System.out.println("The game is over");
        System.out.println("Your score is " + ocean.getHitCount());
        System.out.println("You made " + ocean.getShotsFired() + "shots");
    }
}

