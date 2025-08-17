package com.utils;

public final class ImageUtils {
    private ImageUtils() {
        throw new AssertionError("No instances.");
    }

    public static String a(String str, int i2) {
        String str2;
        if (i2 <= 92) {
            str2 = "/w92";
        } else if (i2 <= 154) {
            str2 = "/w154";
        } else if (i2 <= 185) {
            str2 = "/w185";
        } else if (i2 <= 342) {
            str2 = "/w342";
        } else if (i2 <= 500) {
            str2 = "/w500";
        } else if (i2 <= 780) {
            str2 = "/w780";
        } else if (i2 <= 1920) {
            str2 = "/w1280";
        } else {
            str2 = "/original";
        }
        if (str != null && (str.contains("http://") || str.contains("https://"))) {
            return str;
        }
        return "http://image.tmdb.org/t/p" + str2 + str;
    }
}
