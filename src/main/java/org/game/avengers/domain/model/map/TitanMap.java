package org.game.avengers.domain.model.map;

import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.player.Avenger;

import java.util.List;


public class TitanMap extends AbstractMap {

    private final Avenger avenger;
    private final List<Warrior> warriors;

    public TitanMap(final int height, final int width, final Avenger avenger, final List<Warrior> warriors) {
        super(height, width, avenger, warriors);
        this.avenger = avenger;
        this.warriors = warriors;
    }

    @Override
    public String getMapInformation() {
        return "Titan Planet";
    }
}
