package com.letscode.java;

import java.util.Random;

public class Battleship extends Input {
    public boolean inTest = true;

    public void play() {
        boolean restartFlag = false;
        //do {

            System.out.println("INSTRUÇÕES:\n" +
                    "- O jogador deve posicionaor 10 submarinos que ocupam apenas uma coordenada.\n" +
                    "- A coordenada deve ser inserida a partir das letras indicadas na primeira coluna\n " +
                    "com os númeors indicados na primeira linha com o seguinte formato: LetraNúmero (Ex.: A9)\n ");

            Player player = new Player(true);
            Player cpu = new Player(false);

            boolean isPlayerTurn = true;
            do {
                if (isPlayerTurn) {
                    System.out.println("\n\nPlayer Turn:");
                    player.printPlayerBoard();
                    System.out.print("Player, sua vez de atirar - ");
                    playTurn(player, cpu, takeInputCoordinate(player.getPlayerBoard()));
                    player.printPlayerBoard();
                } else {
                    System.out.println("\nCpu Turn:");
                    if (inTest) {
                        cpu.printPlayerBoard();
                        System.out.print("CPU, sua vez de atirar - ");
                        playTurn(cpu, player, takeInputCoordinate(cpu.getPlayerBoard()));
                        cpu.printPlayerBoard();
                    } else {
                        int [] coordinates = new int[2];
                        Random cpuAI = new Random();
                        do {
                            coordinates[0] = cpuAI.nextInt(10)+1;
                            coordinates[1] = cpuAI.nextInt(10)+1;
                        }while (!replayValidator(coordinates,cpu.getPlayerBoard()));
//                    playTurn(cpu, player, takeInputCoordinate(cpu.getPlayerBoard()));
                        playTurn(cpu, player, coordinates);
                        System.out.println("CPU atirou em (mostra para teste):"); // para teste
                        cpu.printPlayerBoard();
                    }
                }
                isPlayerTurn = !isPlayerTurn;
            } while (player.getShips() > 0 && cpu.getShips() > 0);

            if (player.getShips() > 0) {
                System.out.println("Parabéns, você venceu!");
            } else {
                System.out.println("Não foi dessa vez! CPU venceu!");
            }

        System.out.println("Fim de jogo...");
        //} while (!restartFlag);
    }

    public static void playTurn(Player turnPlayer, Player otherPlayer, int[] coordinates) {

        if (otherPlayer.getPlayerBoardCoordinate(coordinates) == ' ' || otherPlayer.getPlayerBoardCoordinate(coordinates) == '_' || otherPlayer.getPlayerBoardCoordinate(coordinates) == '*') {
            switch (turnPlayer.getPlayerBoardCoordinate(coordinates)) {
                case 'N':
                    turnPlayer.setPlayerBoard(coordinates, 'n');
                    break;
                case ' ':
                    turnPlayer.setPlayerBoard(coordinates, '_');
                    break;
            }
        } else {
            otherPlayer.loseAShip();
            switch (turnPlayer.getPlayerBoardCoordinate(coordinates)) {
                case 'N':
                    turnPlayer.setPlayerBoard(coordinates, 'X');
                    break;
                case ' ':
                    turnPlayer.setPlayerBoard(coordinates, '*');
                    break;
            }
        }
    }

    @Override
    boolean replayValidator(int[] coordinate, char[][] board) {
        return board[coordinate[0]][coordinate[1]] == ' ' || board[coordinate[0]][coordinate[1]] == 'N';
    }


}
