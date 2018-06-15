package org.game.avengers.domain.model.player;

import org.game.avengers.domain.model.creature.*;
import org.game.avengers.domain.model.creature.Character;

import static org.game.avengers.constant.GlobalConstant.REQUIRED_AMOUNT_TO_LEVEL_UP;

public class Avenger extends Character {

    private int healingPower;

    private int defeatAmount;

    public Avenger(final Race race, final String name, final Gender gender, final Attribute attribute, final Location location, final int healingPower) {
        super(race, name, gender, attribute, location);

        this.healingPower = healingPower;
    }

    public int getDefeatAmount() {
        return this.defeatAmount;
    }

    public int getHealingPower() {
        return this.healingPower;
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

    public int getLevel() {
        return (this.defeatAmount / REQUIRED_AMOUNT_TO_LEVEL_UP) + 1;
    }

    public boolean isAlive() {
        return this.attribute.getHealth() > 0 ? true : false;
    }

    public void increaseDefeatAmount() {
        ++defeatAmount;
    }

    @Override
    public String toString() {
        return "Avenger, " + name + " (" + race + "/" + gender + ")" +
                "\nhealingPower=" + healingPower +
                ", defeatAmount=" + defeatAmount +
                "\n" + attribute +
                "\n" + location;
    }
}
