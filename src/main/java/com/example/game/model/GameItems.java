package com.example.game.model;

import java.util.Arrays;

public enum GameItems {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");
    final String value;

    GameItems(String value) {
        this.value = value;
    }

    public static GameItems getItem(String itemName) {
        return Arrays.stream(values()).filter(item -> item.value.equalsIgnoreCase(itemName)).findFirst().orElse(null);
    }

    public static GameItems getRandomItem() {
        return values()[(int) (Math.random() * values().length)];
    }
}
