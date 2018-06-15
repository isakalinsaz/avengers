package org.game.avengers.helper.utility;

import org.game.avengers.domain.model.creature.Gender;
import org.game.avengers.domain.model.creature.Race;
import org.game.avengers.domain.model.enemy.Warrior;
import org.game.avengers.domain.model.player.Avenger;

public final class GameConsole {

    private GameConsole() {
    }

    public static void printSelectPlayerRace() {
        System.out.println("1- " + Race.HUMAN.toString());
        System.out.println("2- " + Race.AWOKEN.toString());
        System.out.println("3- " + Race.EXO.toString());
        System.out.print("Select your character race (1, 2 or 3) :");
    }

    public static void printEnterYourCharacterName() {
        System.out.print("Enter your character name :");
    }

    public static void printSelectYourCharacterGender() {
        System.out.println("1- " + Gender.MALE.toString());
        System.out.println("2- " + Gender.FEMALE.toString());
        System.out.print("Select your character gender (1 or 2) :");
    }

    public static void printNewOrLoadGame() {
        System.out.println("1- NEW GAME");
        System.out.println("2- LOAD GAME");
        System.out.println("Chose your option (1 or 2) :");
    }

    public static void printIfWarriorExistInTheCell() {
        System.out.println("\nThere is a Warrior, What would you like to do?");
        System.out.println("1- Fight");
        System.out.println("2- Run");
        System.out.println("Chose your option (1 or 2) :");
    }

    public static void printPressYToSaveGame() {
        System.out.println("\nWould you like to save the game? Please press 'y' to save the game?");
    }

    public static void printStartFight(final Avenger avenger, final Warrior warrior) {
        System.out.println(avenger.getName() + "\tVS\t" + warrior.getName());
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ->");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" Fight!!!");

    }
}
