package org.game.avengers.helper.utility;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public final class MathOperationTest {

    @Test
    public void shouldGenerateRand1toSpecifiedBound() {
        //given, when
        int actualNumber = MathOperation.rand1toSpecifiedBound(10);

        //then
        assertTrue(actualNumber < 11);
    }

    @Test
    public void shouldGenerateRand1to2() {
        //given, when
        int actualNumber = MathOperation.rand1to2();

        //then
        assertTrue(actualNumber < 3);
    }
}
