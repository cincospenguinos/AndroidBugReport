package com.stoicapps.roll4initiative.shared;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @NonNull
    @Override
    public String toString() {
        String str = rolls + "d" + faces;

        if (modifier < 0) {
            return str + modifier;
        }

        if (modifier > 0) {
            return str + "+" + modifier;
        }

        return str;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DiceRoll)) {
            return false;
        }

        DiceRoll other = (DiceRoll) obj;

        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(rolls)
                .append(faces)
                .append(modifier)
                .build();
    }

    public static void setSeed(long seed) {
        random.setSeed(seed);
    }
}
