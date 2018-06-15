package org.game.avengers.domain.model.game;

import org.game.avengers.domain.model.creature.Attribute;
import org.game.avengers.domain.model.creature.Gender;
import org.game.avengers.domain.model.creature.Location;
import org.game.avengers.domain.model.creature.Race;
import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.player.Avenger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Avenger avenger;
    private List<Warrior> warriors;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        avenger = new Avenger(Race.HUMAN, "HULK", Gender.MALE, new Attribute(100, 4, 3, 3, 2, 1.0), new Location(10, 10), 5);
        warriors = game.createEnemies();
    }

    @Test
    public void shouldAvengerBeAliveWhenAttack() {
        //given,when
        game.doAttack(avenger, warriors.get(0), true);

        //then
        assertEquals(true, avenger.isAlive());
        assertEquals(82.0, warriors.get(0).getAttribute().getHealth(), 0.0f);
    }

    @Test
    public void shouldWarriorBeAliveWhenAttack() {
        //given
        Warrior warrior = new Warrior(Race.HUMAN, "TUREAN", Gender.MALE, new Attribute(100, 3, 3, 2, 2, 1.0), new Location(10, 11));

        //when
        game.doAttack(avenger, warrior, false);

        //then
        assertEquals(true, warrior.isAlive());
    }
}
