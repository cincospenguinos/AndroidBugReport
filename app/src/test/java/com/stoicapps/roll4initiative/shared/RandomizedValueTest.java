package com.stoicapps.roll4initiative.shared;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedValueTest {

    @Test
    public void fromString_stringifyingWorks() {
        // NOTE: This test checks to make sure the parsing is done correctly--not that the proper
        // class returns everything right. This was mostly to make the test easier and more
        // integration-heavy over unit-heavy
        assertTrue(RandomizedValue.fromString("7").toString().equals("7"));
        assertTrue(RandomizedValue.fromString("1d6+1").toString().equals("1d6+1"));
        assertTrue(RandomizedValue.fromString("1d20-3").toString().equals("1d20-3"));
        assertTrue(RandomizedValue.fromString("2d4").toString().equals("2d4"));
    }

    @Test
    public void fromString_givesDiceRoll() {
        RandomizedValue diceRoll = RandomizedValue.fromString("1d8+3");
        assertTrue(diceRoll instanceof DiceRoll);
    }

    @Test
    public void fromString_givesFlatAmount() {
        RandomizedValue flatAmont = RandomizedValue.fromString("1");
        assertTrue(flatAmont instanceof FlatAmount);
    }
}