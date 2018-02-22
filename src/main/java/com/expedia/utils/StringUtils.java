package com.expedia.utils;

/**
 * <h1>String Utility</h1>
 * Several String helper methods
 *
 * @author Alaa Fandi waked75@gmail.com
 * @version 1.0
 */
public final class StringUtils {

    /**
     * Checks whether a given {@link String}
     * is null or empty String
     * @param str given String
     * @return whether string is null or empty
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().equals("") || str.trim().length() == 0;
    }
}
