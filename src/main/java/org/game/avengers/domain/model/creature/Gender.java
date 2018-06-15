package org.game.avengers.domain.model.creature;

import java.io.Serializable;
import java.util.Arrays;

public enum Gender implements Serializable {
    MALE(1), FEMALE(2), UNKNOWN(3);

    private final int id;

    Gender(final int id) {
        this.id = id;
    }

    public int getValue() {
        return this.id;
    }

    public static Gender fromId(final int id) throws Exception {
        return Arrays.stream(values()).filter(o -> o.id == id).findFirst().orElseThrow(() -> new Exception("Invalid parameter"));
    }
}
