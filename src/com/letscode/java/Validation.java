package com.letscode.java;

import java.util.Scanner;

abstract class Validation {

    public static final String INPUT_PLAY_PATTERN = "[aA-jJ][0-9]";
    public static final String INPUT_RESTART_PATTERN = "[sSnN]";

    public static int[] inputValidator (char[][] board, boolean isTurn) {
        Scanner input = new Scanner(System.in);
        int[] coordinates = new int[2];
        String coordinate;
        System.out.print("Insira posição: ");
        while (input.hasNext()) {
            if (input.hasNext(INPUT_PLAY_PATTERN)) {
                coordinate = input.next(INPUT_PLAY_PATTERN).toLowerCase();
                coordinates[0] = Conversor.coordinatesToIndex(coordinate.charAt(0));
                coordinates[1] = Conversor.coordinatesToIndex(coordinate.charAt(1));
                if (replayValidator(coordinates, board, isTurn)) {
                    break;
                }
                else{
                    System.out.print("Posição inválida, insira outra coordenada: ");
                }
            } else {
                System.out.println("Insira corretamente os dados no formato: LetraNumero (Ex.: H5) ");
                System.out.print("Insira posição: ");
            }
            input.nextLine();
        }
        return coordinates;
    }

    public static boolean replayValidator (int[] coordinate, char[][] board, boolean isTurn) {
        if (isTurn) {
            switch (board[coordinate[0]][coordinate[1]]) {
                case '-': case '*': case 'n': case 'X':
                    return false;
                default:
                    return true;
            }
        } else {
            return board[coordinate[0]][coordinate[1]] == ' ';
        }

    }
}
