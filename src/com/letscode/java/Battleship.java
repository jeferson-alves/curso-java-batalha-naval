package com.letscode.java;

public class Battleship {
    public static void play() {
        System.out.println("INSTRUÇÕES\n" +
                "- O jogador deve posicionaor 10 submarinos que ocupam apenas uma coordenada.\n" +
                "- A coordenada deve ser inserida a partir das letras indicadas na primeira coluna\n " +
                "com os númeors indicados na primeira linha com o seguinte formato: LetraNúmero (Ex.: A9)");

        Player player1 = new Player(true);
        Player cpu = new Player(false);
        cpu.getBoard();
    }
}
