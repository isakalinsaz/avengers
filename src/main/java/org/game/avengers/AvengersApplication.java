package org.game.avengers;

import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.game.Game;
import org.game.avengers.domain.model.map.AbstractMap;
import org.game.avengers.domain.model.player.Avenger;
import org.game.avengers.helper.utility.FileOperation;
import org.game.avengers.helper.utility.GameConsole;

import java.util.List;
import java.util.Scanner;

public final class AvengersApplication {


    private AvengersApplication() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to The Avengers Infinity War Game!");

        Game game = new Game();
        game.sound.play();

        AbstractMap abstractMap = checkIfGameResumed();
        if (abstractMap != null) {
            Scanner scanner = new Scanner(System.in);

            GameConsole.printNewOrLoadGame();
            int command = scanner.nextInt();

            if (command == 1) {
                FileOperation.clearFileContent();
                Avenger avenger = game.createNewPlayer();
                List<Warrior> warriors = game.createEnemies();
                game.play(avenger, warriors, null);
            } else {
                game.play(abstractMap.getAvenger(), abstractMap.getWarriors(), abstractMap);
            }
        } else {
            Avenger avenger = game.createNewPlayer();
            List<Warrior> warriors = game.createEnemies();
            game.play(avenger, warriors, abstractMap);
        }

        game.sound.stop();
        System.out.println("Avengers game engine has been stopped.");
    }

    private static AbstractMap checkIfGameResumed() {

        return FileOperation.readObjectFromFile();

    }

}
