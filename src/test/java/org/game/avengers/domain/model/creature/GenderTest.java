package org.game.avengers.domain.model.creature;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GenderTest {

    @Test
    public void shouldReturnMaleWhenEnter1() throws Exception {
        // given when
        Gender gender = Gender.fromId(1);

        //then
        assertTrue(gender == Gender.MALE);
    }

    @Test
    public void shouldReturnFemaleWhenEnter2() throws Exception {
        // given when
        Gender gender = Gender.fromId(2);

        //then
        assertTrue(gender == Gender.FEMALE);
    }

    @Test
    public void shouldReturnUnknownWhenEnter3() throws Exception {
        // given when
        Gender gender = Gender.fromId(3);

        //then
        assertTrue(gender == Gender.UNKNOWN);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenEnterDifferentNumber() throws Exception {
        // given when
        Gender.fromId(4);

    }
}
