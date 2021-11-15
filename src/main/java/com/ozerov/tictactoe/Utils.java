package com.ozerov.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final String MESSAGE_ENTER_CORRECT_NUMBER = "Enter correct number.";
    private static final String NEW_LINE = "\n";
    private static final View view = new View();

    public static int readInt(String welcomeMessage, int minValue, int maxValue) {
        int choiceNumber;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(welcomeMessage);
            while (!scanner.hasNextInt()) {
                view.printText(MESSAGE_ENTER_CORRECT_NUMBER + NEW_LINE + welcomeMessage);
                scanner.next();
            }
            choiceNumber = scanner.nextInt();
        } while (!Validator.isValidNumber(choiceNumber, minValue, maxValue));
        return choiceNumber;
    }

    public static String readString(String welcomeMessage) {
        Scanner scanner = new Scanner(System.in);
        view.printText(welcomeMessage);
        while (!scanner.hasNextLine()) {
            scanner.next();
        }
        return scanner.nextLine().trim();
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static int getRandomInt(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }
}
