package com.stoicapps.roll4initiative.features.templates;

import androidx.annotation.Nullable;

import com.stoicapps.roll4initiative.shared.RandomizedValue;
import com.stoicapps.roll4initiative.shared.storage.RandomizedValueConverter;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class CreatureTemplate {

    @Id
    private long id;

    private String name;

    @Convert(converter = RandomizedValueConverter.class, dbType = String.class)
    private RandomizedValue initiative;

    @Convert(converter = RandomizedValueConverter.class, dbType = String.class)
    private RandomizedValue hitPoints;

    public CreatureTemplate() {}

    public CreatureTemplate(String _name, RandomizedValue _initiative, RandomizedValue _hitPoints) {
        name = _name;
        initiative = _initiative;
        hitPoints = _hitPoints;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CreatureTemplate)) {
            return false;
        }

        CreatureTemplate other = (CreatureTemplate) obj;

        if (this.getId() != 0 && other.getId() != 0) {
            return this.getId() == other.getId();
        }

        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(initiative.toString())
                .append(hitPoints.toString())
                .build();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RandomizedValue getInitiative() {
        return initiative;
    }

    public void setInitiative(RandomizedValue initiative) {
        this.initiative = initiative;
    }

    public RandomizedValue getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(RandomizedValue hitPoints) {
        this.hitPoints = hitPoints;
    }
}
