package org.game.avengers.domain.model.map;

import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.player.Avenger;

import java.io.Serializable;
import java.util.List;

import static org.game.avengers.constant.GlobalConstant.*;

public abstract class AbstractMap implements Serializable {

    private Avenger avenger;
    private List<Warrior> warriors;
    private MapExplorer mapExplorer;

    public AbstractMap(final int height, final int width, final Avenger avenger, final List<Warrior> warriors) {
        this.avenger = avenger;
        this.warriors = warriors;
        this.mapExplorer = new MapExplorer(height, width, avenger, warriors);
    }

    abstract String getMapInformation();

    public MapExplorer getMapExplorer() {
        return mapExplorer;
    }

    public List<Warrior> getWarriors() {
        return warriors;
    }

    public Avenger getAvenger() {
        return avenger;
    }

    public void draw() {

        int[][] map = this.mapExplorer.getCurrentMap();

        for (int height = 0; height < map.length; height++) {

            for (int width = 0; width < map[height].length; width++) {

                if (map[height][width] == EXPLORED) {

                    drawExploredField(width, height);

                } else if (avenger.getLocation().getX() == width && avenger.getLocation().getY() == height) {

                    drawAvengerLocation();

                } else {

                    drawUnexploredField();
                }
            }
            System.out.println();
        }
    }

    private void drawExploredField(int x, int y) {
        if (avenger.getLocation().getX() == x && avenger.getLocation().getY() == y) {
            System.out.print(ANSI_BLUE + AVENGER_SIGN + ANSI_RESET);
        } else {
            drawWarriorsLocation(x, y);
        }
    }

    private void drawWarriorsLocation(int x, int y) {
        boolean isWarriorExist = false;
        Warrior selectedWarrior = null;
        for (Warrior warrior : warriors) {
            if (warrior.getLocation().getX() == x && warrior.getLocation().getY() == y) {
                isWarriorExist = true;
                selectedWarrior = warrior;
                break;
            }
        }

        if (isWarriorExist) {
            if (selectedWarrior.isAlive()) {
                System.out.print(ANSI_BLUE + WARRIOR_SIGN + ANSI_RESET);
            } else {
                System.out.print(ANSI_BLUE + DEAD_WARRIOR_SIGN + ANSI_RESET);
            }

        } else {
            System.out.print(ANSI_RED + EXPLORED_FIELD_SIGN + ANSI_RESET);
        }
    }

    private void drawAvengerLocation() {
        System.out.print(ANSI_BLUE + AVENGER_SIGN + ANSI_RESET);
    }

    private void drawUnexploredField() {
        System.out.print(ANSI_YELLOW + UNEXPLORED_FIELD_SIGN + ANSI_RESET);
    }
}
