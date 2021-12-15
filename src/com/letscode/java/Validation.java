package com.letscode.java;

import java.util.Scanner;

abstract class Validation {

    public static final String PATTERN = "[aA-jJ][0-9]";

    public static int[] inputValidator (char[][] board) {
        Scanner input = new Scanner(System.in);
        int[] coordinates = new int[2];
        String coordinate;
        System.out.print("Insira posição: ");
        while (input.hasNext()) {
            if (input.hasNext(PATTERN)) {
                coordinate = input.next(PATTERN).toLowerCase();
                coordinates[0] = Conversor.coordinatesToIndex(coordinate.charAt(0));
                coordinates[1] = Conversor.coordinatesToIndex(coordinate.charAt(1));
                if (replayValidator(coordinates, board)) {
                    break;
                }
                else{
                    System.out.print("Posição já ocupada, insira outra coordenada: ");
                }
            } else {
                System.out.println("Insira corretamente os dados no formato: LetraNumero (Ex.: H5) ");
                System.out.print("Insira posição: ");
            }
            input.nextLine();
        }
        return coordinates;
    }

    public static boolean replayValidator (int[] coordinate, char[][] board) {
        return board[coordinate[0]][coordinate[1]] == ' ';
    }
}
