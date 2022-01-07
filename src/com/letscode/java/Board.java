package com.letscode.java;

import java.util.Random;

public class Board extends Input {

    private char[][] board = {
            {' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'},
            {'A', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'C', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'D', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'E', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'F', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'J', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    };

    public Board (boolean player) {
        printInitialBoard(player);
    }

    private void printInitialBoard(boolean player) {
        int shipCounter = 10;
        int [] coordinates = new int[2];
        Random cpuAI = new Random();
        while (shipCounter > 0){
            if (player){
                printBoard();
                coordinates = inputCoordinate(this.board);
            }
            else {
                do {
                    coordinates[0] = cpuAI.nextInt(10)+1;
                    coordinates[1] = cpuAI.nextInt(10)+1;
                }while (!validateCoordinate(coordinates,this.board));
            }
            this.updateBoard(coordinates,'N');
            shipCounter--;
        }
    }

    public void printBoard() {
        System.out.println();
        for (char[] row : this.board) {
            System.out.print("|");
            for (char column : row) {
                System.out.print(column + "|");
            }
            System.out.println();
        }
    }

    public void updateBoard(int[] position, char marking) {
        this.board[position[0]][position[1]] = marking;
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCoordinate(int[] coordinate) {
        return this.board[coordinate[0]][coordinate[1]];
    }

    @Override
    boolean validateCoordinate(int[] coordinate, char[][] board) {
        return board[coordinate[0]][coordinate[1]] == ' ';
    }
}
