package com.webler.school.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static String  keyFromDate(String str) {
        return str.substring(0, 4) +" "+ str.substring(6, 8);
    }

    public static Double round(Double db) {
        BigDecimal bd = BigDecimal.valueOf(db);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        return (double)bd.doubleValue();
    }
}
