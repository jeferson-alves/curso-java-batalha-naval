package com.letscode.java;

import java.util.Random;
import java.util.Scanner;

public abstract class Input {
    public static final String INPUT_PLAY_PATTERN = "[aA-jJ][0-9]";
    public static final String INPUT_RESTART_PATTERN = "[sSnN]";

    public int[] takeInputCoordinate (char[][] board) {
        Scanner input = new Scanner(System.in);
        int[] coordinates = new int[2];
        String coordinate;
        System.out.printf("Insira uma posição: ");
        while (input.hasNext()) {
            if (input.hasNext(INPUT_PLAY_PATTERN)) {
                coordinate = input.next(INPUT_PLAY_PATTERN).toLowerCase();
                coordinates[0] = Conversor.coordinatesToIndex(coordinate.charAt(0));
                coordinates[1] = Conversor.coordinatesToIndex(coordinate.charAt(1));
                if (this.replayValidator(coordinates, board)) {
                    break;
                }
                else{
                    System.out.printf("Posição inválida, insira uma nova posição: ");
                }
            } else {
                System.out.println("Insira corretamente os dados no formato: LetraNumero (Ex.: H5) ");
                System.out.printf("Insira uma posição: ");
            }
            input.nextLine();
        }
        return coordinates;
    }




    abstract boolean replayValidator (int[] coordinate, char[][] board);
}
