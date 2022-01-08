package com.letscode.java;

import java.util.Random;

public class Player {

    public String name = "Player";
    private Board board;
    private int ships = 5;

    public Player(boolean player) {
        if (!player){ this.name = "Computer";}
        this.board = new Board(player);
    }

    public void printPlayerBoard() {
        this.board.printBoard();
    }

    public char[][] getPlayerBoard() {
        return this.board.getBoard();
    }

    public char getPlayerBoardCoordinate(int[] coordinate) {
        return this.board.getCoordinate(coordinate);
    }

    public void setPlayerBoard(int[] coordinate, char marking) {
        this.board.updateBoard(coordinate, marking);
    }

    public int getShips() {
        return ships;
    }

    public void loseAShip() {
        this.ships = this.ships - 1;
    }

    public int[] cpuMove () {
        Random rand = new Random();
        int upperbound = 10;
        int[] coordinate = new int[2];
        coordinate[0] = rand.nextInt(upperbound) + 1;
        coordinate[1] = rand.nextInt(upperbound) + 1;
        System.out.printf("coordinate = %d , %d ", coordinate[0], coordinate[1]);
        return coordinate;
    }
}
