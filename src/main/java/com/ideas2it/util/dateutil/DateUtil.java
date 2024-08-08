package com.ideas2it.util.dateutil;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    public static String calculateAge(LocalDate startDate) {
        return Period.between(startDate, LocalDate.now()).getYears() + " Years " + Period.between(startDate,LocalDate.now()).getMonths() +" Months";
    }
}
