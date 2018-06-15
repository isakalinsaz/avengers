package org.game.avengers.domain.model.creature;

import java.io.Serializable;

public class Attribute implements Serializable {

    private double health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private double precision;

    public Attribute(final double health, final int strength, final int dexterity, final int intelligence, final int constitution, final double precision) {
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.precision = precision;
    }

    public double getPrecision() {
        return this.precision;
    }

    public double getDamageRatio() {
        return (strength * dexterity * intelligence) / constitution;
    }

    public static Attribute loadCharacterAttribute(final Race race, final Gender gender) {
        if (Race.HUMAN == race) {
            return loadHumanAttributes(gender);
        } else if (Race.AWOKEN == race) {
            return loadAwokenAttributes(gender);
        } else {
            return loadExoAttributes(gender);
        }
    }


    private static Attribute loadHumanAttributes(final Gender gender) {
        if (gender == Gender.MALE) {
            return new Attribute(100, 4, 3, 3, 3, 0.7);
        } else {
            return new Attribute(100, 3, 2, 3, 2, 0.8);
        }
    }

    private static Attribute loadAwokenAttributes(final Gender gender) {
        if (gender == Gender.MALE) {
            return new Attribute(100, 5, 1, 2, 3, 0.5);
        } else {
            return new Attribute(100, 4, 2, 2, 2, 0.45);
        }
    }

    private static Attribute loadExoAttributes(final Gender gender) {
        if (gender == Gender.MALE) {
            return new Attribute(100, 5, 4, 1, 2, 0.75);
        } else {
            return new Attribute(100, 5, 2, 1, 1, 0.90);
        }
    }

    public double getHealth() {
        return this.health;
    }

    public void decreaseHealth(final double damage) {
        health = health - damage;
    }

    public void applyHealingPower(final double healingPower) {
        health = health + healingPower;
    }

    @Override
    public String toString() {
        return "Attribute: " +
                "health=" + health +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", constitution=" + constitution +
                ", precision(%)=" + precision;
    }
}
