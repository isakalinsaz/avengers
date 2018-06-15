package org.game.avengers.domain.model.creature;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RaceTest {

    @Test
    public void shouldReturnHumanWhenEnter1() throws Exception {
        // given when
        Race race = Race.fromId(1);

        //then
        assertTrue(race == Race.HUMAN);
    }

    @Test
    public void shouldReturnAwokenWhenEnter2() throws Exception {
        // given when
        Race race = Race.fromId(2);

        //then
        assertTrue(race == Race.AWOKEN);
    }

    @Test
    public void shouldReturnExoWhenEnter3() throws Exception {
        // given when
        Race race = Race.fromId(3);

        //then
        assertTrue(race == Race.EXO);
    }

    @Test
    public void shouldReturnUnknownWhenEnter4() throws Exception {
        // given when
        Race race = Race.fromId(4);

        //then
        assertTrue(race == Race.UNKNOWN);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenEnterDifferentNumber() throws Exception {
        // given when
        Gender.fromId(5);

    }
}
