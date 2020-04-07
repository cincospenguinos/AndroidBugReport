package com.stoicapps.roll4initiative.shared.storage;

import com.stoicapps.roll4initiative.shared.RandomizedValue;

import io.objectbox.converter.PropertyConverter;

public class RandomizedValueConverter implements PropertyConverter<RandomizedValue, String> {

    @Override
    public RandomizedValue convertToEntityProperty(String databaseValue) {
        return RandomizedValue.fromString(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(RandomizedValue entityProperty) {
        return entityProperty.toString();
    }
}
