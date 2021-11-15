package com.ozerov.tictactoe;

import java.util.Objects;

public class Player {
    private final String name;
    private char sign;

    public Player(String name) {
        this.name = name;
        this.sign = ' ';
    }

    public String getName() {
        return name;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return sign == player.sign && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sign);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sign=" + sign +
                '}';
    }
}