package com.letscode.java;

public class Player {
    private Board board;
    private int ships = 10;

    public Player(boolean player) {
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



}
