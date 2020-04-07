package com.stoicapps.roll4initiative.shared;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DiceRollTest {
    @Test
    public void rollWorks() {
        DiceRoll.setSeed(20160718);
        DiceRoll diceRoll = new DiceRoll(1, 20, 1);
        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            int value = diceRoll.roll();

            assertTrue(value >= 2);
            assertTrue(value <= 21);
            values.add(value);
        }

        assertEquals(20, values.size());
    }
}