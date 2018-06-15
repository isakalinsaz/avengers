package org.game.avengers.domain.model.player;

import org.game.avengers.domain.model.creature.Attribute;
import org.game.avengers.domain.model.creature.Gender;
import org.game.avengers.domain.model.creature.Location;
import org.game.avengers.domain.model.creature.Race;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvengerTest {

    private Avenger avenger;

    @Before
    public void setUp() {
        avenger = new Avenger(Race.HUMAN, "HULK", Gender.MALE, new Attribute(100, 4, 3, 3, 2, 1.0), new Location(10, 10), 5);
    }

    @Test
    public void shouldWarriorBeAliveWhenCreated() {
        //then
        assertEquals("HULK", avenger.getName());
        assertEquals(true, avenger.isAlive());
    }

    @Test
    public void shouldLevelBeDefaultWhenAvengerCreated() {
        //then
        assertEquals(1, avenger.getLevel());

    }
}
