package org.game.avengers.domain.model.creature;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {

    @Test
    public void shouldReturnPlayerLocation() {
        // given when
        Location location = new Location(10, 10);

        //then
        assertEquals("Location: 10,10", location.toString());
    }

    @Test
    public void shouldIncreaseX() {
        // given
        Location location = new Location(10, 10);

        //when
        location.increaseX();

        //then
        assertEquals("Location: 11,10", location.toString());
    }

    @Test
    public void shouldIncreaseY() {
        // given
        Location location = new Location(10, 10);

        //when
        location.increaseY();

        //then
        assertEquals("Location: 10,11", location.toString());
    }

    @Test
    public void shouldDecreaseX() {
        // given
        Location location = new Location(10, 10);

        //when
        location.decreaseX();

        //then
        assertEquals("Location: 9,10", location.toString());
    }

    @Test
    public void shouldDecreaseY() {
        // given
        Location location = new Location(10, 10);

        //when
        location.decreaseY();

        //then
        assertEquals("Location: 10,9", location.toString());
    }

}
