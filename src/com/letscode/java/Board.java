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

    public Board (boolean player, int numberOfShips) {
        if (player) {
            initialPlayerBoard(numberOfShips);
        } else {
            initialCpuBoard(numberOfShips);
        }
    }

    private void initialPlayerBoard(int numberOfShips) {
        int remainingShipCounter = numberOfShips;
        int [] coordinates;

        System.out.println("Olá Jogador, este é seu tabuleiro, escolha a posição dos seus navios: ");
        System.out.println();
        printBoard();

        while (remainingShipCounter > 0) {
            System.out.print("\n");
            System.out.printf("(%dº de %d navios) - ", numberOfShips-remainingShipCounter+1, numberOfShips);
            coordinates = inputCoordinate(this.board, false);
            this.updateBoard(coordinates,'N');
            remainingShipCounter--;
            printBoard();
        }
    }

    private void initialCpuBoard(int numberOfShips) {
        int remainingShipCounter = numberOfShips;
        int [] coordinates = new int[2];
        Random cpuAI = new Random();
        while (remainingShipCounter > 0){
            do {
                coordinates[0] = cpuAI.nextInt(10)+1;
                coordinates[1] = cpuAI.nextInt(10)+1;
            }while (!validateCoordinate(coordinates,this.board, false));
            this.updateBoard(coordinates,'N');
            remainingShipCounter--;
        }
        System.out.println("\n\nCPU também escolheu escolheu as posições, mas é segredo! Vamos jogar...");
//        System.out.println("\n\nCPU Board somente aparece para teste:"); //para teste
//        printBoard(); //para teste: tabuleiro do CPU no inicio do jogo
    }

    public void printBoard() {
        for (char[] row : this.board) {
            System.out.print("|");
            for (char column : row) {
                System.out.print(" " + column + " " + "|");
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

}
