package org.game.avengers.constant;

public final class GlobalConstant {

    private GlobalConstant() {
    }

    // default zero values show unexplored fields on the map
    public static int EXPLORED = 1;
    public static int WARRIOR = 2;

    public static int FIGHT = 1;
    public static int RUN = 2;

    public static int REQUIRED_AMOUNT_TO_LEVEL_UP = 3;

    public static String AVENGER_SIGN = "A  ";
    public static String WARRIOR_SIGN = "W  ";
    public static String DEAD_WARRIOR_SIGN = "X  ";

    public static String EXPLORED_FIELD_SIGN = ".  ";
    public static String UNEXPLORED_FIELD_SIGN = "#  ";

    public static final int WIDTH = 30;
    public static final int HEIGHT = 20;

    public static String KEY_SAVE = "y";
    public static String KEY_QUIT = "q";
    public static String KEY_NORTH = "w";
    public static String KEY_SOUTH = "s";
    public static String KEY_WEST = "a";
    public static String KEY_EAST = "d";


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static String GAME_SOUND_PATH = "/sound/the-avengers.wav";

    public static final int NUMBER_OF_ENEMY = 15;

    public static String[] maleCharacterName = {"Tauren", "Tolvir", "Qiraji", "Moarg", "Murloc"};
    public static String[] femaleCharacterName = {"Jamllie", "Eriuita", "Danzina", "Maralyn", "Rosmara"};
}
