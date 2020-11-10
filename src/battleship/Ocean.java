package battleship;

public class Ocean {

    static final int OCEAN_SIZE = 10;

    private Ship[][]ships = new Ship[Ocean.OCEAN_SIZE][Ocean.OCEAN_SIZE];

    static final int NUM_BATTLESHIPS = 1;
    static final int NUM_CRUISERS = 2;
    static final int NUM_DESTROYERS = 3;
    static final int NUM_SUBMARINES = 4;

    private int shotsFired;

    private int hitCount;

    private int shipsSunk;

    public Ocean() {
        this.populateEmptyOcean();
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
    }

    //Create ocean with no shops
    private void populateEmptyOcean() {
        for (int i = 0; i < this.ships.length; i++) {
            for (int j = 0; j < this.ships[i].length; j++) {
                Ship ship = new EmptySea();
                ship.placeShipAt(i, j, true, this);
            }
        }
    }
    void placeAllShipsRandomly() {

        Random rand = new Random();
        int row;
        int column;

        //place battleships
        for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
            Ship battleship = new Battleship();
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            battleship.placeShipAt(row, column, horizontal, this);
        }

        //place cruisers
        for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
            Ship cruiser = new Cruiser();
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            cruiser.placeShipAt(row, column, horizontal, this);
        }

        //place destroyers
        for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
            Ship destroyer = new Destroyer();
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            destroyer.placeShipAt(row, column, horizontal, this);
        }

        //place submarines
        for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
            Ship submarine = new Submarine();
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            horizontal = rand.nextInt(2) == 0 ? false : true;
            while(!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
                row = rand.nextInt(10);
                column = rand.nextInt(10);
                horizontal = rand.nextInt(2) == 0 ? false : true;
            }
            submarine.placeShipAt(row, column, horizontal, this);
        }

    }

    boolean isOccupied(int row, int column) {
    }

    boolean shootAt(int row, int column) {
    }

    int getShotsFired() {
    }

    int getHitCount() {
    }

    int getShipsSunk() {
    }

    Ship[][] getShipArray() {
    }

    void print() {
    }

}
