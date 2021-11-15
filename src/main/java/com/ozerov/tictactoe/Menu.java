package com.ozerov.tictactoe;

public class Menu {
    private static final String COMPUTER_PLAYER_NAME = "Computer";
    private static final String ENTER_NAME_OF_FIRST_PLAYER = "Enter the name of the first player >>> ";
    private static final String ENTER_NAME_OF_SECOND_PLAYER = "Enter the name of the second player >>> ";
    private static final String ENTER_PLAYER_NAME = "Enter player name >>> ";
    private static final String MESSAGE_REPEAT_GAME = "Do you want to play a rematch? 1 - Yes, 0 - No >>> ";
    private static final String MESSAGE_START_NEW_GAME = "Do you want start new game? 1 - Yes, 0 - No >>> ";
    private static final String MESSAGE_SELECT_GAME_MODE = "Select the game mode: " +
            "1 - Player1 vs Player2, 2 - Player vs Computer, 0 - Exit >>> ";
    private static final char O = 'O';
    private static final char X = 'X';

    public void mainMenu() {
        boolean startNewGame = true;
        View view = new View();

        while (startNewGame) {
            int selectorYesNoMinValue = 0;
            int selectorYesNoMaxValue = 1;
            int selectorGameModeMinValue = 0;
            int selectorGameModeMaxValue = 2;
            int selectGameMode = Utils.readInt(MESSAGE_SELECT_GAME_MODE,
                    selectorGameModeMinValue, selectorGameModeMaxValue);

            if (selectGameMode == 0) {
                break;
            } else {

                boolean isDualUserMode = (selectGameMode == 1);
                Player playerOne = (isDualUserMode) ? createPlayer(ENTER_NAME_OF_FIRST_PLAYER)
                        : createPlayer(ENTER_PLAYER_NAME);
                Player playerTwo = (isDualUserMode) ? createPlayer(ENTER_NAME_OF_SECOND_PLAYER)
                        : new Player(COMPUTER_PLAYER_NAME);

                view.printTitleOfGame(playerOne, playerTwo);
                setRandomlyFirstPlayerSign(playerOne);
                view.printPlayerNamePlaysPlayerSign(playerOne);
                setSecondPlayerSign(playerOne, playerTwo);
                view.printPlayerNamePlaysPlayerSign(playerTwo);

                boolean isPlayerOneGoFirst = getRandomOrderOfPlayers();
                view.printPlayerMakesTheFirstMovie(playerOne, playerTwo, isPlayerOneGoFirst);

                boolean repeatCurrentGame = true;
                Game game = new Game();
                while (repeatCurrentGame) {
                    game.startGame(playerOne, playerTwo, isPlayerOneGoFirst);
                    repeatCurrentGame = (Utils.readInt(MESSAGE_REPEAT_GAME,
                            selectorYesNoMinValue, selectorYesNoMaxValue) == 1);
                }
            }
            startNewGame = (Utils.readInt(MESSAGE_START_NEW_GAME,
                    selectorYesNoMinValue, selectorYesNoMaxValue) == 1);
        }
        view.printGameOver();
    }

    private boolean getRandomOrderOfPlayers() {
        return Utils.getRandomBoolean();
    }

    private Player createPlayer(String name) {
        return new Player(Utils.readString(name));
    }

    private void setRandomlyFirstPlayerSign(Player playerOne) {
        playerOne.setSign((Utils.getRandomBoolean()) ? X : O);
    }

    private void setSecondPlayerSign(Player playerOne, Player playerTwo) {
        playerTwo.setSign((playerOne.getSign() == X) ? O : X);
    }
}
