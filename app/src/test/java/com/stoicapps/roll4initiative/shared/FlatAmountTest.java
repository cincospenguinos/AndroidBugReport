package com.stoicapps.roll4initiative.shared;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlatAmountTest {
    @Test
    public void rollWorks() {
        FlatAmount amount = new FlatAmount(12);
        assertEquals(12, amount.roll());
    }
}