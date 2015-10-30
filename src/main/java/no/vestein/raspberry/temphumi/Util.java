package no.vestein.raspberry.temphumi;

import java.util.Random;

/**
 * Utility class. Static.
 */
public class Util {

    private Util() {}

    private static Random rand = new Random();

    public static int randInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static int randInt(int max) {
        return randInt(0, max);
    }

}