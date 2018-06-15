package org.game.avengers.domain.model.map;

import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.player.Avenger;

import java.io.Serializable;
import java.util.List;

import static org.game.avengers.constant.GlobalConstant.*;

public class MapExplorer implements Serializable {

    private final int width;
    private final int height;
    private final int[][] map;
    private final Avenger avenger;
    private final List<Warrior> warriors;

    public MapExplorer(final int height, final int width, final Avenger avenger, final List<Warrior> warriors) {
        this.width = width;
        this.height = height;
        this.avenger = avenger;
        this.warriors = warriors;
        this.map = new int[height][width];
        this.putWarriorsOnMap();
    }

    public void exploreNorth() {
        if (avenger.getLocation().getY() >= 2) {
            updateMap(KEY_NORTH);
            avenger.getLocation().decreaseY();
        }
    }

    public void exploreSouth() {
        if (avenger.getLocation().getY() < height - 2) {
            updateMap(KEY_SOUTH);
            avenger.getLocation().increaseY();
        }
    }

    public void exploreWest() {
        if (avenger.getLocation().getX() >= 2) {
            updateMap(KEY_WEST);
            avenger.getLocation().decreaseX();
        }
    }

    public void exploreEast() {
        if (avenger.getLocation().getX() < width - 2) {
            updateMap(KEY_EAST);
            avenger.getLocation().increaseX();
        }
    }

    private void putWarriorsOnMap() {
        for (Warrior warrior : warriors) {
            this.map[warrior.getLocation().getY()][warrior.getLocation().getX()] = WARRIOR;
        }
    }

    private void updateMap(String direction) {
        if (direction.equals(KEY_NORTH)) {

            this.map[avenger.getLocation().getY() - 1][avenger.getLocation().getX()] = EXPLORED;
            this.map[avenger.getLocation().getY() - 2][avenger.getLocation().getX()] = EXPLORED;
            this.map[avenger.getLocation().getY() - 1][avenger.getLocation().getX() - 1] = EXPLORED;
            this.map[avenger.getLocation().getY() - 1][avenger.getLocation().getX() + 1] = EXPLORED;

        } else if (direction.equals(KEY_SOUTH)) {

            this.map[avenger.getLocation().getY() + 1][avenger.getLocation().getX()] = EXPLORED;
            this.map[avenger.getLocation().getY() + 2][avenger.getLocation().getX()] = EXPLORED;
            this.map[avenger.getLocation().getY() + 1][avenger.getLocation().getX() - 1] = EXPLORED;
            this.map[avenger.getLocation().getY() + 1][avenger.getLocation().getX() + 1] = EXPLORED;

        } else if (direction.equals(KEY_WEST)) {

            this.map[avenger.getLocation().getY()][avenger.getLocation().getX() - 1] = EXPLORED;
            this.map[avenger.getLocation().getY()][avenger.getLocation().getX() - 2] = EXPLORED;
            this.map[avenger.getLocation().getY() - 1][avenger.getLocation().getX() - 1] = EXPLORED;
            this.map[avenger.getLocation().getY() + 1][avenger.getLocation().getX() - 1] = EXPLORED;

        } else if (direction.equals(KEY_EAST)) {

            this.map[avenger.getLocation().getY()][avenger.getLocation().getX() + 1] = EXPLORED;
            this.map[avenger.getLocation().getY()][avenger.getLocation().getX() + 2] = EXPLORED;
            this.map[avenger.getLocation().getY() - 1][avenger.getLocation().getX() + 1] = EXPLORED;
            this.map[avenger.getLocation().getY() + 1][avenger.getLocation().getX() + 1] = EXPLORED;
        }
        this.map[avenger.getLocation().getY()][avenger.getLocation().getX()] = EXPLORED;
    }

    public int[][] getCurrentMap() {
        return this.map;
    }
}
