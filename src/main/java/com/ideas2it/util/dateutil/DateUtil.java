package com.ideas2it.util.dateutil;

import java.time.LocalDate;
import java.time.Period;

/**
 * <p>
 * Contains functions which are related to date operations
 * </p>
 *
 * @author Deolin Jaffens
 */
public class DateUtil {

    /**
     * <p>
     * Calculates the age by finding the difference in birth date to the current
     * date
     * </p>
     *
     * @param birthDate - date in which a specific person is born
     * @return age in years and months
     */

    public static String calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() + " Years " + Period.between(birthDate, LocalDate.now()).getMonths() + " Months";
    }
}
