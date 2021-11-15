package com.ozerov.tictactoe;

public class View {
    private static final String DRAW = "Draw! There are no free cells left.";
    private static final String GAME_OVER = "Game over.";
    private static final String IS_WIN = " is win !!!";
    private static final String MADE_A_MOVE = " made a move.";
    private static final String MAKES_THE_FIRST_MOVIE = " makes the first move.";
    private static final String PLAYER = "Player ";
    private static final String PLAYS = " plays ";
    private static final String POINT = ". ";
    private static final String SELECTED_POSITION_IS_TAKEN = "The selected position is taken. " +
            "Please specify a different position.";
    private static final String VS = " vs ";

    public void printGameFieldAndPositions(char[][] gameField, char[][] gameFieldPositions) {
        System.out.println("-----------------------");
        System.out.println("Positions:   Game Field:");
        for (int i = 0; i < gameField[0].length; i++) {
            System.out.print("  ");
            for (int j = 0; j < gameFieldPositions.length; j++) {
                System.out.print(gameFieldPositions[i][j]);
            }
            System.out.print("         ");
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    public void printTitleOfGame(Player playerOne, Player playerTwo) {
        System.out.println(playerOne.getName() + VS + playerTwo.getName());
    }

    public void printPlayerNamePlaysPlayerSign(Player player) {
        System.out.print(player.getName() + PLAYS + player.getSign() + POINT);
    }

    public void printPlayerMakesTheFirstMovie(Player playerOne, Player playerTwo, boolean isPlayerOneGoFirst) {
        System.out.println(isPlayerOneGoFirst ? playerOne.getName() + MAKES_THE_FIRST_MOVIE
                : playerTwo.getName() + MAKES_THE_FIRST_MOVIE);
    }

    public void printGameOver() {
        System.out.println(GAME_OVER);
    }

    public void printPlayerIsWin(Player player) {
        System.out.println(PLAYER + player.getName() + IS_WIN);
    }

    public void printDraw() {
        System.out.println(DRAW);
    }

    public void printSelectedPositionIsTaken() {
        System.out.println(SELECTED_POSITION_IS_TAKEN);
    }

    public void printPlayerMadeAMove(Player player) {
        System.out.println(PLAYER + player.getName() + MADE_A_MOVE);
    }

    public void printText(String text) {
        System.out.print(text);
    }
}
