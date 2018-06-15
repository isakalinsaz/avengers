package org.game.avengers.domain.model.creature;

import java.io.Serializable;
import java.util.Arrays;

public enum Race implements Serializable {
    HUMAN(1), AWOKEN(2), EXO(3), UNKNOWN(4);

    private final int id;

    Race(final int id) {
        this.id = id;
    }

    public int getValue() {
        return this.id;
    }

    public static Race fromId(final int id) throws Exception {
        return Arrays.stream(values()).filter(o -> o.id == id).findFirst().orElseThrow(() -> new Exception("Invalid parameter"));
    }

}
