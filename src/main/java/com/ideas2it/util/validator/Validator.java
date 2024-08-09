package com.ideas2it.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Used to check whether the details initialised are in
 * the expected form
 * </p>
 *
 * @author Deolin Jaffens
 */

public class Validator {

    /**
     * <p>
     * Checks whether the number is a true phone number
     * </p>
     *
     * @param number - gets the number initialised
     */

    public static boolean isValidNumber(long number) {
        String numberToString = String.valueOf(number);
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(numberToString);
        return matcher.matches();
    }

    /**
     * <p>
     * Checks whether the given name is true
     * </p>
     *
     * @param name - gets the name that is initialised
     */

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * <p>
     * Checks whether the given gender is true
     * </p>
     *
     * @param gender - get the gender that is initialized
     */

    public static boolean isValidGender(char gender) {
        String genderToString = String.valueOf(gender);
        Pattern pattern = Pattern.compile("[mfMF]");
        Matcher matcher = pattern.matcher(genderToString);
        return matcher.matches();
    }
}   