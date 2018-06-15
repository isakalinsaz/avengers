package org.game.avengers.helper.utility;

import java.util.Random;

public final class MathOperation {

    private MathOperation() {
    }

    static Random random = new Random();

    public static int rand1to2() {
        return random.nextInt(2) + 1;
    }

    public static int rand1to3() {
        return random.nextInt(3) + 1;
    }

    public static int rand0to5() {
        return random.nextInt(5) + 0;
    }

    public static int rand1toSpecifiedBound(final int bound) {
        return random.nextInt(bound) + 1;
    }

    public static int rand1to10() {
        return random.nextInt(10) + 1;
    }

    public static int rand1to100() {
        return random.nextInt(100) + 1;
    }

    public static double generateRandPrecision() {
        return (double) rand1to100() / 100;
    }
}
