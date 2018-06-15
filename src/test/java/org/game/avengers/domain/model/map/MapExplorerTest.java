package org.game.avengers.domain.model.map;

import org.game.avengers.domain.model.creature.Attribute;
import org.game.avengers.domain.model.creature.Gender;
import org.game.avengers.domain.model.creature.Location;
import org.game.avengers.domain.model.creature.Race;
import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.game.Game;
import org.game.avengers.domain.model.player.Avenger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.game.avengers.constant.GlobalConstant.HEIGHT;
import static org.game.avengers.constant.GlobalConstant.WIDTH;
import static org.junit.Assert.assertTrue;

public class MapExplorerTest {

    private Game game;
    private Avenger avenger;
    private List<Warrior> warriors;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        avenger = new Avenger(Race.HUMAN, "HULK", Gender.MALE, new Attribute(100, 4, 3, 3, 2, 0.9), new Location(10, 10), 5);
        warriors = game.createEnemies();
    }

    @Test
    public void shouldMoveNorthWhenPressKeyNorth() {
        // given
        MapExplorer explorer = new MapExplorer(HEIGHT, WIDTH, avenger, warriors);

        //when
        explorer.exploreNorth();

        //then
        assertTrue(avenger.getLocation().getY() == 9);
        assertTrue(avenger.getLocation().getX() == 10);
    }

    @Test
    public void shouldMoveSouthWhenPressKeySouth() {
        // given
        MapExplorer explorer = new MapExplorer(HEIGHT, WIDTH, avenger, warriors);

        //when
        explorer.exploreSouth();

        //then
        assertTrue(avenger.getLocation().getY() == 11);
        assertTrue(avenger.getLocation().getX() == 10);
    }

    @Test
    public void shouldMoveWestWhenPressKeyWest() {
        // given
        MapExplorer explorer = new MapExplorer(HEIGHT, WIDTH, avenger, warriors);

        //when
        explorer.exploreWest();

        //then
        assertTrue(avenger.getLocation().getY() == 10);
        assertTrue(avenger.getLocation().getX() == 9);
    }

    @Test
    public void shouldMoveEastWhenPressKeyEast() {
        // given
        MapExplorer explorer = new MapExplorer(HEIGHT, WIDTH, avenger, warriors);

        //when
        explorer.exploreEast();

        //then
        assertTrue(avenger.getLocation().getY() == 10);
        assertTrue(avenger.getLocation().getX() == 11);
    }
}
