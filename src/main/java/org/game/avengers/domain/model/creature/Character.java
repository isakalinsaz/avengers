package org.game.avengers.domain.model.creature;

import java.io.Serializable;

public class Character implements Serializable {

    protected Race race;
    protected String name;
    protected Gender gender;
    protected Attribute attribute;
    protected Location location;

    public Character(final Race race, final String name, final Gender gender, final Attribute attribute, final Location location) {
        this.race = race;
        this.name = name;
        this.gender = gender;
        this.attribute = attribute;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Character{" +
                "  race=" + race +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", attribute=" + attribute +
                ", location=" + location +
                '}';
    }
}
