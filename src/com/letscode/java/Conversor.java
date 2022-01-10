package com.letscode.java;

public class Conversor {

    public static int coordinatesToIndex(char value) {

        switch (value) {
            case '0': case 'a':
                return 1;
            case '1': case 'b':
                return 2;
            case '2': case 'c':
                return 3;
            case '3': case 'd':
                return 4;
            case '4': case 'e':
                return 5;
            case '5': case 'f':
                return 6;
            case '6': case 'g':
                return 7;
            case '7': case 'h':
                return 8;
            case '8': case 'i':
                return 9;
            case '9': case 'j':
                return 10;
            default:
                return -1;
        }
    }
}
