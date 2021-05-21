package pt.test.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility classes related to numeric values.
 *
 */
public class NumericUtils {

    /**
     * Generates a random number between two values. The lower limit value is inclusive and
     * the upper limit is exclusive.
     *
     * @param lowerLimit
     * @param upperLimit
     * @return
     */
    public static int generateRandomNumber(int lowerLimit, int upperLimit) {

        if (upperLimit < lowerLimit) {
            return ThreadLocalRandom.current().nextInt(upperLimit, lowerLimit);
        }

        return ThreadLocalRandom.current().nextInt(lowerLimit, upperLimit);
    }

    /**
     * Generates a random number between two values and returns its value as a String.
     * The lower limit value is inclusive and the upper limit is exclusive.
     *
     * @param lowerLimit
     * @param upperLimit
     * @return
     */
    public static String generateRandomNumberAsString(int lowerLimit, int upperLimit) {
        return String.valueOf(generateRandomNumber(lowerLimit, upperLimit));
    }
}
