package org.game.avengers.domain.model.enemy;

import org.game.avengers.domain.model.creature.Attribute;
import org.game.avengers.domain.model.creature.Gender;
import org.game.avengers.domain.model.creature.Location;
import org.game.avengers.domain.model.creature.Race;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarriorTest {

    private Warrior warrior;

    @Before
    public void setUp() {
        warrior = new Warrior(Race.HUMAN, "TUREAN", Gender.MALE, new Attribute(100, 3, 3, 2, 2, 1.0), new Location(10, 11));
    }

    @Test
    public void shouldWarriorBeAliveWhenCreated() {
        //then
        assertEquals("TUREAN", warrior.getName());
        assertEquals(true, warrior.isAlive());

    }
}
