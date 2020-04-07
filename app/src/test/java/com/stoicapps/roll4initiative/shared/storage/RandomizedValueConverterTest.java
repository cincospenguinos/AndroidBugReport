package com.stoicapps.roll4initiative.shared.storage;

import com.stoicapps.roll4initiative.shared.RandomizedValue;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedValueConverterTest {

    private RandomizedValueConverter converter = new RandomizedValueConverter();

    @Test
    public void conversionWorks_DiceRoll() {
        RandomizedValue value = RandomizedValue.fromString("1d6");
        String dbValue = converter.convertToDatabaseValue(value);
        assertNotNull(dbValue);

        RandomizedValue convertedValue = converter.convertToEntityProperty(dbValue);
        assertTrue(value.equals(convertedValue));
    }

    @Test
    public void conversionWorks_FlatAmount() {
        RandomizedValue value = RandomizedValue.fromString("6");
        String dbValue = converter.convertToDatabaseValue(value);
        assertNotNull(dbValue);

        RandomizedValue convertedValue = converter.convertToEntityProperty(dbValue);
        assertTrue(value.equals(convertedValue));
    }
}