package com.stoicapps.roll4initiative.shared;

import androidx.annotation.NonNull;

public class FlatAmount extends RandomizedValue {
    private int amount;

    public FlatAmount(int _amount) {
        amount = _amount;
    }

    @Override
    int roll() {
        return amount;
    }

    @NonNull
    @Override
    public String toString() {
        return Integer.toString(amount);
    }
}
