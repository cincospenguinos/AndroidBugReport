package com.stoicapps.roll4initiative.shared;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FlatAmount)) {
            return false;
        }

        FlatAmount other = (FlatAmount) obj;

        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
