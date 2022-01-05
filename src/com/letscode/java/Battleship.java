package com.letscode.java;

public class Battleship extends Validation {

    public void play() {
        boolean restartFlag = false;
        //do {

            System.out.println("INSTRUÇÕES\n" +
                    "- O jogador deve posicionaor 10 submarinos que ocupam apenas uma coordenada.\n" +
                    "- A coordenada deve ser inserida a partir das letras indicadas na primeira coluna\n " +
                    "com os númeors indicados na primeira linha com o seguinte formato: LetraNúmero (Ex.: A9)");

            Player player = new Player(true);
            Player cpu = new Player(false);

            boolean playerTurn = true;
            do {
                if (playerTurn) {
                    System.out.println("\nPlayer Turn:");
                    player.printPlayerBoard();
                    playTurn(player, cpu, inputValidator(player.getPlayerBoard()));
                } else {
                    System.out.println("\nCpu Turn:");
                    cpu.printPlayerBoard();
                    playTurn(cpu, player, inputValidator(cpu.getPlayerBoard()));
                }
                playerTurn = !playerTurn;
            } while (player.getShips() > 0 && cpu.getShips() > 0);


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
