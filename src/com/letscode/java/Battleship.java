package com.letscode.java;

public class Battleship extends Input {

    public void play() {
//        boolean restartFlag = false;
        //do {

        showInformation();

        Player player = new Player(true);
        Player cpu = new Player(false);

        boolean playerTurn = true;

        System.out.println("\nCom os navios posicionados!\n" +
                "Vamos iniciar o jogo!");

        do {
            showScoreBoard(player, cpu);
            if (playerTurn) {
                System.out.println("\nPlayer Turn:");
                player.printPlayerBoard();
                playTurn(player, cpu, inputCoordinate(player.getPlayerBoard(), true));
            } else {
                System.out.println("\nCpu Turn:");
                cpu.printPlayerBoard();
                playTurn(cpu, player, cpuMove());
                System.out.println();
            }
            playerTurn = !playerTurn;
        } while (player.getShips() > 0 && cpu.getShips() > 0);

        winner(player, cpu);

        showHeadBoard(player);
        player.printPlayerBoard();

        showHeadBoard(cpu);
        cpu.printPlayerBoard();

        //} while (!restartFlag);
    }


    public static void playTurn(Player turnPlayer, Player otherPlayer, int[] coordinates) {

        if (otherPlayer.getPlayerBoardCoordinate(coordinates) == ' ' ||
                otherPlayer.getPlayerBoardCoordinate(coordinates) == '-' ||
                otherPlayer.getPlayerBoardCoordinate(coordinates) == '*'
        )
        {
            switch (turnPlayer.getPlayerBoardCoordinate(coordinates)) {
                case 'N':
                    turnPlayer.setPlayerBoard(coordinates, 'n');
                    break;
                case ' ':
                    turnPlayer.setPlayerBoard(coordinates, '-');
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

    public static void winner(Player player, Player cpu){
        if (player.getShips() > 0){
            System.out.println("Parabéns, Você venceu!");
        } else {
            System.out.println("Que pena, mas você perdeu!");
        }
    }

    public static void showInformation() {
        System.out.println("INSTRUÇÕES\n" +
                "- O jogador deve posicionaor 10 submarinos que ocupam apenas uma coordenada.\n" +
                "- A coordenada deve ser inserida a partir das letras indicadas na primeira coluna\n " +
                "com os númeors indicados na primeira linha com o seguinte formato: LetraNúmero (Ex.: A9)");
    }

    public static void showHeadBoard(Player player) {
        System.out.println("\n-----------------------");
        System.out.printf("------ %S -------\n", player.getName());
        System.out.println("-----------------------");
    }

    public static void showScoreBoard(Player player, Player cpu){
        System.out.println("--------------------------------");
        System.out.printf("------ Jogador=%d x CPU=%d -------\n", player.getShips(), cpu.getShips());
        System.out.println("--------------------------------");
    }

}
