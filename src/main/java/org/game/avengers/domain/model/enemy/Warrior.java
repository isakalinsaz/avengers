package org.game.avengers.domain.model.enemy;

import org.game.avengers.domain.model.creature.*;
import org.game.avengers.domain.model.creature.Character;

public class Warrior extends Character {

    public Warrior(final Race race, final String name, final Gender gender, final Attribute attribute, final Location location) {
        super(race, name, gender, attribute, location);
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public String getName() {
        return this.name;
    }

    public Location getLocation() {
        return this.location;
    }

    public boolean isAlive() {
        return this.attribute.getHealth() > 0 ? true : false;
    }
}
