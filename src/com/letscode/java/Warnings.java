package com.letscode.java;

public class Warnings {

    public static final String INVALID_INPUT_EXCEPTION_MESSAGE = "Formato de entrada de dados inválida. Favor inserir novamente no formato: LetraNumero (Ex.: H5): ";
    public static final String REPEATED_INPUT_EXCEPTION_MESSAGE = "Posição já inserida, insira nova coordenada: " ;

    public static void getInvalidInputExceptionMessage() {
        System.out.print(INVALID_INPUT_EXCEPTION_MESSAGE);
    }

    public static void getRepeatedInputExceptionMessage() {
        System.out.print(REPEATED_INPUT_EXCEPTION_MESSAGE);
    }

}
