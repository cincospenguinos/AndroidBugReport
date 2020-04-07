package com.stoicapps.roll4initiative.shared;

import java.util.Random;

public class DiceRoll extends RandomizedValue {
    private int rolls;
    private int faces;
    private int modifier;

    private static Random random = new Random();

    public DiceRoll(int _rolls, int _faces, int _modifier) {
        rolls = _rolls;
        faces = _faces;
        modifier = _modifier;
    }

    @Override
    int roll() {
        int value = 0;

        for (int trials = 1; trials <= rolls; trials++) {
            value += random.nextInt(faces) + 1;
        }

        return value + modifier;
    }

    public static void setSeed(long seed) {
        random.setSeed(seed);
    }
}
