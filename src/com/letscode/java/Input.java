package com.letscode.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input {

    public static final String INPUT_PLAY_PATTERN = "[aA-jJ][0-9]";
    public static final String INPUT_RESTART_PATTERN = "[sSnN]";

    public int[] inputCoordinate (char[][] board) {
        Scanner input = new Scanner(System.in);
        int[] coordinates = new int[2];
        String coordinate;
        System.out.print("Insira posição: ");
        while (input.hasNext()) {
            try {
                coordinate = input.next(INPUT_PLAY_PATTERN).toLowerCase();
                coordinates[0] = Conversor.coordinatesToIndex(coordinate.charAt(0));
                coordinates[1] = Conversor.coordinatesToIndex(coordinate.charAt(1));
                if (this.validateCoordinate(coordinates, board)) {
                    break;
                }
                else{
                    System.out.print("Posição já inserida, insira outra coordenada: ");
                }
            } catch (InputMismatchException e){
                System.out.println("Insira corretamente os dados no formato: LetraNumero (Ex.: H5) ");
                System.out.print("Insira posição: ");
            }
            input.nextLine();
        }
        return coordinates;
    }

    abstract boolean validateCoordinate (int[] coordinate, char[][] board);
}
