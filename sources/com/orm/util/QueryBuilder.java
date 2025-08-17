package com.orm.util;

public class QueryBuilder {
    public static String a(int i2) {
        if (i2 >= 1) {
            StringBuilder sb = new StringBuilder((i2 * 2) - 1);
            sb.append("?");
            for (int i3 = 1; i3 < i2; i3++) {
                sb.append(",?");
            }
            return sb.toString();
        }
        throw new RuntimeException("The number of arguments must be greater than or equal to 1.");
    }
}
