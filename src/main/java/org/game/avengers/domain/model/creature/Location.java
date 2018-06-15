package org.game.avengers.domain.model.creature;

import java.io.Serializable;

public class Location implements Serializable {

    private int x;
    private int y;

    public Location(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void increaseX() {
        ++x;
    }

    public void increaseY() {
        ++y;
    }

    public void decreaseX() {
        --x;
    }

    public void decreaseY() {
        --y;
    }

    @Override
    public String toString() {
        return "Location: " + x + "," + y;
    }
}
