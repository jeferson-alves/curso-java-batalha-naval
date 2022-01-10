package com.letscode.java;

import java.util.Random;

public class Player {

    public String name = "Jogador";
    private Board board;
    private int numberOfShips = 2;

    public Player(boolean player) {
        if (!player){ this.name = "Computador";}
        this.board = new Board(player, this.numberOfShips);
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
        return numberOfShips;
    }

    public void loseAShip() {
        this.numberOfShips = this.numberOfShips - 1;
    }

    public String getName(){ return this.name; }

}