package org.game.avengers.domain.model.game;

import org.game.avengers.constant.GlobalConstant;
import org.game.avengers.domain.model.creature.Attribute;
import org.game.avengers.domain.model.creature.Gender;
import org.game.avengers.domain.model.creature.Location;
import org.game.avengers.domain.model.creature.Race;
import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.map.AbstractMap;
import org.game.avengers.domain.model.map.TitanMap;
import org.game.avengers.domain.model.player.Avenger;
import org.game.avengers.helper.utility.FileOperation;
import org.game.avengers.helper.utility.GameConsole;
import org.game.avengers.helper.utility.GameSound;
import org.game.avengers.helper.utility.MathOperation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.game.avengers.constant.GlobalConstant.*;

public class Game {

    int[][] occupiedLocation = new int[NUMBER_OF_ENEMY + 1][2];

    public GameSound sound = new GameSound();

    Scanner scanner = new Scanner(System.in);

    public Avenger createNewPlayer() throws Exception {

        Race race = selectPlayerRace();

        Gender gender = SelectCharacterGender();

        GameConsole.printEnterYourCharacterName();
        String name = scanner.next().toUpperCase();

        Attribute attribute = Attribute.loadCharacterAttribute(race, gender);

        int x = MathOperation.rand1toSpecifiedBound(WIDTH - 2);
        int y = MathOperation.rand1toSpecifiedBound(HEIGHT - 2);
        occupiedLocation[0][0] = x;
        occupiedLocation[0][1] = y;

        Location location = new Location(x, y);
        Avenger avenger = new Avenger(race, name, gender, attribute, location, MathOperation.rand1to10());

        System.out.println(avenger.toString());
        return avenger;
    }

    public List<Warrior> createEnemies() throws Exception {

        List<Warrior> warriors = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_ENEMY; i++) {
            Race race = generateRandomRaceForEnemy();

            Gender gender = generateRandomGenderForEnemy();

            String name = generateRandomNameForEnemy(gender).toUpperCase();

            Attribute attribute = Attribute.loadCharacterAttribute(race, gender);

            int x, y;
            do {
                x = MathOperation.rand1toSpecifiedBound(WIDTH - 2);
                y = MathOperation.rand1toSpecifiedBound(HEIGHT - 2);
            } while (isLocationOccupied(x, y));

            occupiedLocation[i + 1][0] = x;
            occupiedLocation[i + 1][1] = y;

            Location location = new Location(x, y);
            Warrior warrior = new Warrior(race, name, gender, attribute, location);

            System.out.println(warrior.toString());
            warriors.add(warrior);
        }

        return warriors;
    }

    public void play(final Avenger avenger, final List<Warrior> warriors, final AbstractMap abstractMap) throws InterruptedException {
        AbstractMap map;

        if (abstractMap == null) {
            map = new TitanMap(HEIGHT, WIDTH, avenger, warriors);
        } else {
            map = abstractMap;
        }

        System.out.print("Enter direction (w:north, a:west, s:south, d:east) or press 'q' for quite game : ");
        String command = scanner.nextLine();
        while (!command.equals(KEY_QUIT)) {

            if (command.equals(KEY_NORTH)) {
                map.getMapExplorer().exploreNorth();
            } else if (command.equals(KEY_SOUTH)) {
                map.getMapExplorer().exploreSouth();
            } else if (command.equals(KEY_EAST)) {
                map.getMapExplorer().exploreEast();
            } else if (command.equals(KEY_WEST)) {
                map.getMapExplorer().exploreWest();
            }

            Warrior warrior = checkIfWarriorExist(avenger, warriors);
            if (warrior != null) {
                GameConsole.printIfWarriorExistInTheCell();
                int option = scanner.nextInt();
                if (GlobalConstant.FIGHT == option) {
                    fight(avenger, warrior);
                } else {
                    continue;
                }
            }

            if (avenger.isAlive()) {
                System.out.println("Location: " + avenger.getLocation().getX() + "," + avenger.getLocation().getY() + " - Level: " + avenger.getLevel() + " -  Defeat: " + avenger.getDefeatAmount() + " - Health: " + avenger.getAttribute().getHealth());
                map.draw();
                System.out.print("Enter direction (w:north, a:west, s:south, d:east) or press 'q' for quite game : ");
                command = scanner.next();
            } else {
                System.out.println("GAME OVER...");
                break;
            }
        }

        quitOrSaveGame(map, avenger, command);
    }

    public void quitOrSaveGame(final AbstractMap map, final Avenger avenger, String command) {
        try {
            if (avenger.isAlive() && KEY_QUIT.equals(command)) {

                GameConsole.printPressYToSaveGame();
                command = scanner.next();

                if (command.equals(KEY_SAVE)) {
                    FileOperation.writeObjectToFile(map);
                } else {
                    FileOperation.clearFileContent();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fight(final Avenger avenger, final Warrior warrior) {
        GameConsole.printStartFight(avenger, warrior);
        int option = MathOperation.rand1to2();
        if (option == 1) {
            System.out.println("You will start the first attack!!!");
        } else {
            System.out.println("Enemy will start the first attack");
        }

        boolean isPlayerTurn = option == 1 ? true : false;

        while (avenger.isAlive() && warrior.isAlive()) {
            doAttack(avenger, warrior, isPlayerTurn);
            isPlayerTurn = !isPlayerTurn;
        }
    }

    public void doAttack(final Avenger avenger, final Warrior warrior, boolean isPlayerTurn) {
        double possibilityOfHitEnemy = MathOperation.generateRandPrecision();
        if (isPlayerTurn) {

            if (possibilityOfHitEnemy < avenger.getAttribute().getPrecision()) {
                warrior.getAttribute().decreaseHealth(avenger.getAttribute().getDamageRatio());
            } else {
                System.out.println("You hit " + avenger.getAttribute().getDamageRatio() + " point but You missed the Attack!!!");
            }
        } else {
            if (possibilityOfHitEnemy < warrior.getAttribute().getPrecision()) {
                avenger.getAttribute().decreaseHealth(warrior.getAttribute().getDamageRatio());
                avenger.getAttribute().applyHealingPower(avenger.getHealingPower());
            } else {
                System.out.println(warrior.getName().toUpperCase() + " hit " + warrior.getAttribute().getDamageRatio() + " point but " + warrior.getName().toUpperCase() + " missed the Attack!!!");
            }
        }

        if (!warrior.isAlive()) {
            avenger.increaseDefeatAmount();
            System.out.println("Enemy (" + warrior.getName().toUpperCase() + ") is down!!!  Your Health remained " + avenger.getAttribute().getHealth());
        }

        if (!avenger.isAlive()) {
            System.out.println("You are killed by " + warrior.getName() + "!!!");
        }
    }

    private Warrior checkIfWarriorExist(final Avenger avenger, final List<Warrior> warriors) {
        for (Warrior warrior : warriors) {
            if (warrior.isAlive() && avenger.getLocation().getX() == warrior.getLocation().getX() && avenger.getLocation().getY() == warrior.getLocation().getY()) {
                return warrior;
            }
        }
        return null;
    }

    private Race selectPlayerRace() throws Exception {
        GameConsole.printSelectPlayerRace();
        int raceOption = scanner.nextInt();
        return Race.fromId(raceOption);
    }

    private Race generateRandomRaceForEnemy() throws Exception {
        return Race.fromId(MathOperation.rand1to3());
    }

    private Gender generateRandomGenderForEnemy() throws Exception {
        return Gender.fromId(MathOperation.rand1to2());
    }

    private String generateRandomNameForEnemy(final Gender gender) throws Exception {
        if (Gender.MALE == gender) {
            return GlobalConstant.maleCharacterName[MathOperation.rand0to5()];
        } else {
            return GlobalConstant.femaleCharacterName[MathOperation.rand0to5()];
        }
    }

    private Gender SelectCharacterGender() throws Exception {
        GameConsole.printSelectYourCharacterGender();
        int genderOption = scanner.nextInt();
        return Gender.fromId(genderOption);
    }

    private boolean isLocationOccupied(final int x, final int y) {
        for (int i = 0; i < NUMBER_OF_ENEMY + 1; i++) {
            if ((occupiedLocation[i][0] == x) && (occupiedLocation[i][1] == y)) {
                return true;
            }
        }
        return false;
    }
}
