package com.ozerov.tictactoe;

public class Game {
    private static final char SPACE = ' ';
    private static final char VERTICAL = '┃';
    private static final char HORIZONTAL = '━';
    private static final char CROSSHAIR = '╋';
    private static final String COMPUTER = "Computer";
    private static final String ENTER_POSITION = ", enter your position for ";
    private static final String TRIPLE_GREATER_THAN = " >>> ";
    public static char[][] gameField;
    public static char[][] positions;

    public void startGame(Player playerOne, Player playerTwo, boolean isPlayerOneGoFirst) {
        int movePosition;
        Player currentPlayer;
        int count = (isPlayerOneGoFirst) ? 0 : 1;
        View view = new View();

        initializationPositionsAndBlankGameField();
        view.printGameFieldAndPositions(gameField, positions);

        while (true) {
            currentPlayer = (count % 2 == 0) ? playerOne : playerTwo;
            movePosition = makeAGameMove(currentPlayer);

            if (isAWinningMove(movePosition)) {
                view.printPlayerIsWin(currentPlayer);
                break;
            }
            if (count >= 8 && isFieldFull()) {
                view.printDraw();
                break;
            }
            count++;
        }
    }

    private int makeAGameMove(Player player) {
        int column;
        int count = 0;
        int positionMinValue = 1;
        int positionMaxValue = 9;
        int position;
        int row;
        boolean isPositionNotCorrect = true;
        View view = new View();

        do {
            if (count > 0 && !isPlayerComputer(player)) {
                view.printSelectedPositionIsTaken();
            }

            position = isPlayerComputer(player) ? Utils.getRandomInt(positionMinValue, positionMaxValue)
                    : Utils.readInt(player.getName() + ENTER_POSITION +
                    player.getSign() + TRIPLE_GREATER_THAN, positionMinValue, positionMaxValue);
            row = getRow(position);
            column = getColumn(position);

            if (isFieldEmpty(row, column)) {
                isPositionNotCorrect = false;
            }
            count++;

        } while (isPositionNotCorrect);

        view.printPlayerMadeAMove(player);
        gameField[row][column] = player.getSign();
        view.printGameFieldAndPositions(gameField, positions);

        return position;
    }

    private boolean isPlayerComputer(Player player) {
        return COMPUTER.equals(player.getName());
    }

    private int getRow(int position) {
        return ((position - 1) / 3) * 2;
    }

    private int getColumn(int position) {
        return ((position - 1) % 3) * 2;
    }

    private boolean isFieldEmpty(int row, int column) {
        return (SPACE == gameField[row][column]);
    }

    private boolean isFieldFull() {
        boolean result = true;
        for (char[] chars : gameField) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (chars[j] == SPACE) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isAWinningMove(int position) {
        int row = getRow(position);
        int column = getColumn(position);
        boolean result = isTheRowFull(row) | isTheColumnFull(column);

        switch (position) {
            case 1:
            case 9:
                result = result | isTheFirstDiagonalFull();
                break;
            case 3:
            case 7:
                result = result | isTheSecondDiagonalFull();
                break;
            case 5:
                result = result | isTheFirstDiagonalFull() | isTheSecondDiagonalFull();
                break;
        }
        return result;
    }

    private boolean isTheRowFull(int row) {
        return ((gameField[row][0] == gameField[row][2]) && (gameField[row][0] == (gameField[row][4])));
    }

    private boolean isTheColumnFull(int column) {
        return ((gameField[0][column] == gameField[2][column]) && (gameField[0][column] == (gameField[4][column])));
    }

    private boolean isTheFirstDiagonalFull() {
        return ((gameField[0][0] == gameField[2][2]) && (gameField[0][0] == (gameField[4][4])));
    }

    private boolean isTheSecondDiagonalFull() {
        return ((gameField[0][4] == gameField[2][2]) && (gameField[0][4] == (gameField[4][0])));
    }

    private void initializationPositionsAndBlankGameField() {
        positions = initializePositions();
        gameField = initializeGameField();
    }

    private char[][] initializeGameField() {
        return new char[][]{{SPACE, VERTICAL, SPACE, VERTICAL, SPACE},
                {HORIZONTAL, CROSSHAIR, HORIZONTAL, CROSSHAIR, HORIZONTAL},
                {SPACE, VERTICAL, SPACE, VERTICAL, SPACE},
                {HORIZONTAL, CROSSHAIR, HORIZONTAL, CROSSHAIR, HORIZONTAL},
                {SPACE, VERTICAL, SPACE, VERTICAL, SPACE}};
    }

    private char[][] initializePositions() {
        char numberOfPosition = 49;
        return new char[][]{{numberOfPosition++, VERTICAL, numberOfPosition++, VERTICAL, numberOfPosition++},
                {HORIZONTAL, CROSSHAIR, HORIZONTAL, CROSSHAIR, HORIZONTAL},
                {numberOfPosition++, VERTICAL, numberOfPosition++, VERTICAL, numberOfPosition++},
                {HORIZONTAL, CROSSHAIR, HORIZONTAL, CROSSHAIR, HORIZONTAL},
                {numberOfPosition++, VERTICAL, numberOfPosition++, VERTICAL, numberOfPosition}};
    }
}
