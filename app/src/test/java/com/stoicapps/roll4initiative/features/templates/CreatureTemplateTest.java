package com.stoicapps.roll4initiative.features.templates;

import com.stoicapps.roll4initiative.shared.RandomizedValue;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.DebugFlags;

import static org.junit.Assert.*;

public class CreatureTemplateTest {

    private static final File TEST_DIRECTORY = new File("test-db");
    private BoxStore boxStore;

    @Before
    public void setup() {
        BoxStore.deleteAllFiles(TEST_DIRECTORY);

        boxStore = MyObjectBox.builder()
                .directory(TEST_DIRECTORY)
                .debugFlags(DebugFlags.LOG_QUERIES | DebugFlags.LOG_QUERY_PARAMETERS)
                .build();
    }

    @Test
    public void equals_ChecksIds() {
        CreatureTemplate template = new CreatureTemplate();
        template.setId(1);

        CreatureTemplate other = new CreatureTemplate();
        other.setId(1);

        assertTrue(template.equals(other));
    }

    @Test
    public void equals_noIdsChecksOtherValues() {
        CreatureTemplate template = new CreatureTemplate("Joe", RandomizedValue.fromString("1d20"),
                RandomizedValue.fromString("10"));
        CreatureTemplate other = new CreatureTemplate("Joe", RandomizedValue.fromString("1d20"),
                RandomizedValue.fromString("10"));

        assertTrue(template.equals(other));
    }

    @Test
    public void crudWorks() {
        Box<CreatureTemplate> box = boxStore.boxFor(CreatureTemplate.class);
        CreatureTemplate template = new CreatureTemplate("Joe", RandomizedValue.fromString("1d20"),
                RandomizedValue.fromString("10"));

        assertEquals(0, box.count());
        box.put(template);
        assertEquals(1, box.count());

        CreatureTemplate other = box.get(template.getId());
        assertTrue(template.hashCode() == other.hashCode());
    }
}