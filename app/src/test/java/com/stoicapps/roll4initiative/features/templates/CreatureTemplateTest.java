package com.stoicapps.roll4initiative.features.templates;

import com.stoicapps.roll4initiative.shared.RandomizedValue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreatureTemplateTest {
    @Test
    public void creatureTemplate_equalsChecksIds() {
        CreatureTemplate template = new CreatureTemplate();
        template.setId(1);

        CreatureTemplate other = new CreatureTemplate();
        other.setId(1);

        assertTrue(template.equals(other));
    }

    @Test
    public void creatureTemplate_noIdsChecksOtherValues() {
        CreatureTemplate template = new CreatureTemplate("Joe", RandomizedValue.fromString("1d20"),
                RandomizedValue.fromString("10"));
        CreatureTemplate other = new CreatureTemplate("Joe", RandomizedValue.fromString("1d20"),
                RandomizedValue.fromString("10"));

        assertTrue(template.equals(other));
    }
}