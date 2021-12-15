package com.letscode.java;

public class Player {
    private Board board;

    public Player(boolean player) {
        this.board = new Board(player);
    }

    public void getBoard() {
        this.board.printBoard();
    }
}
