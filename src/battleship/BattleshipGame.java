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

        //Welcome messages and rules
        System.out.println("WELCOME TO BATTLESHIP!");
        System.out.println("Instructions: The computer (your nemesis) has placed 10 ships randomly on a 10x10 ocean. ");
        System.out.println("There are 4 Submarines (length 1), 3 Destroyers (length 2), 2 Cruisers (length 3) and ");
        System.out.println("1 Battleship (length 4). Aim your cannon at a space on the ocean and try to sink all of");
        System.out.println("the ships. Your final score is how many shots you took to win the game.");
        System.out.println(" ");


        //for debugging
        ocean.debugPrint();

        Scanner scanner = new Scanner(System.in);

        while (!ocean.isGameOver()) {

            ocean.print();

            System.out.print("Enter row, column: ");

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
        scanner.close();

        //Game over messages
        System.out.println(" ");
        System.out.println("The game is over.");
        System.out.println("You fired " + ocean.getShotsFired() + " shots.");
    }
}

