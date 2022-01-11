package com.letscode.java;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class Input {

    public static final String INPUT_PLAY_PATTERN = "[aA-jJ][0-9]";

    public int[] inputCoordinate (char[][] board, boolean isTurn) {
        Scanner input = new Scanner(System.in);
        int[] coordinates = new int[2];
        String coordinate;
        System.out.print("Insira posição: ");
        while (input.hasNext()) {
            try {
                coordinate = input.next(INPUT_PLAY_PATTERN).toLowerCase();
                coordinates[0] = Conversor.coordinatesToIndex(coordinate.charAt(0));
                coordinates[1] = Conversor.coordinatesToIndex(coordinate.charAt(1));
                if (this.validateCoordinate(coordinates, board, isTurn)) {
                    break;
                }
                else{
                    throw new RepeatedInput();
                }
            } catch (InputMismatchException e){
                Warnings.getInvalidInputExceptionMessage();
            } catch (RepeatedInput e) {
                Warnings.getRepeatedInputExceptionMessage();
            }
            input.nextLine();
        }
        return coordinates;
    }

    public static boolean validateCoordinate (int[] coordinate, char[][] board, boolean isTurn) {
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

    public int[] cpuMove () {
        Random rand = new Random();
        int upperbound = 10;
        int[] coordinate = new int[2];
        coordinate[0] = rand.nextInt(upperbound) + 1;
        coordinate[1] = rand.nextInt(upperbound) + 1;
//        System.out.printf("coordenada = %d , %d ", coordinate[0], coordinate[1]); // teste: imprimindo coordenadas que o cpu joga
        return coordinate;
    }
}
