package com.ozerov.tictactoe;

public class Validator {
    public static boolean isValidNumber(int number, int minValue, int maxValue) {
        return (minValue <= number && number <= maxValue);
    }
}
