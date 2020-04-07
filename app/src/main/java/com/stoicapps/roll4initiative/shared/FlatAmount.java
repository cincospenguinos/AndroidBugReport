package com.stoicapps.roll4initiative.shared;

public class FlatAmount extends RandomizedValue {
    private int amount;

    public FlatAmount(int _amount) {
        amount = _amount;
    }

    @Override
    int roll() {
        return amount;
    }
}
