package com.letscode.java;

public class Battleship extends Input {

    public void play() {

        showInformation();
        int numberOfShips = 10;

        Player player = new Player(true, numberOfShips);
        Player cpu = new Player(false, numberOfShips);

        boolean playerTurn = true;

        System.out.println("\nCom os navios posicionados!\n" +
                "Vamos iniciar o jogo!");

        do {

            if (playerTurn) {
                System.out.println("\nTurno do jogador:");
                player.printPlayerBoard();
                playTurn(player, cpu, inputCoordinate(player.getPlayerBoard(), true));

            } else {
                System.out.println("\nCPU jogou...");
                playTurn(cpu, player, cpuMove());
//                playTurn(cpu, player, inputCoordinate(cpu.getPlayerBoard(), true)); // teste: entrada de coordenada manual para CPU
//                cpu.printPlayerBoard(); // teste: para verificar o tabuleiro do CPU

            }
            playerTurn = !playerTurn;
            showScoreBoard(player, cpu);

        } while (player.getShips() > 0 && cpu.getShips() > 0);

        winner(player, cpu);

        showHeadBoard(player);
        player.printPlayerBoard();

        showHeadBoard(cpu);
        cpu.printPlayerBoard();

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
            System.out.println("Parabéns, você venceu!");
        } else {
            System.out.println("Que pena, você perdeu!");
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
        System.out.printf("%S\n", player.getName());
        System.out.println("-----------------------");
    }

    public static void showScoreBoard(Player player, Player cpu){
        System.out.println("\n====================================================");
        System.out.println("Placar:");
        System.out.println("-------------Navios-------------");
        System.out.printf("------ Jogador=%d x CPU=%d -------\n", player.getShips(), cpu.getShips());
        System.out.println("--------------------------------");
        System.out.println("\n====================================================");
    }

}
