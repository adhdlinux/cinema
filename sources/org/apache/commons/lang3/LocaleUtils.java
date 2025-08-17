package org.apache.commons.lang3;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LocaleUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, List<Locale>> f41413a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<String, List<Locale>> f41414b = new ConcurrentHashMap();

    private static boolean a(String str) {
        return StringUtils.e(str) && str.length() == 2;
    }

    private static boolean b(String str) {
        return StringUtils.d(str) && (str.length() == 2 || str.length() == 3);
    }

    private static boolean c(String str) {
        return StringUtils.g(str) && str.length() == 3;
    }

    private static Locale d(String str) {
        if (b(str)) {
            return new Locale(str);
        }
        String[] split = str.split("_", -1);
        String str2 = split[0];
        if (split.length == 2) {
            String str3 = split[1];
            if ((b(str2) && a(str3)) || c(str3)) {
                return new Locale(str2, str3);
            }
        } else if (split.length == 3) {
            String str4 = split[1];
            String str5 = split[2];
            if (b(str2) && ((str4.length() == 0 || a(str4) || c(str4)) && str5.length() > 0)) {
                return new Locale(str2, str4, str5);
            }
        }
        throw new IllegalArgumentException("Invalid locale format: " + str);
    }

    public static Locale e(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new Locale("", "");
        }
        if (!str.contains("#")) {
            int length = str.length();
            if (length < 2) {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            } else if (str.charAt(0) != '_') {
                return d(str);
            } else {
                if (length >= 3) {
                    char charAt = str.charAt(1);
                    char charAt2 = str.charAt(2);
                    if (!Character.isUpperCase(charAt) || !Character.isUpperCase(charAt2)) {
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    } else if (length == 3) {
                        return new Locale("", str.substring(1, 3));
                    } else {
                        if (length < 5) {
                            throw new IllegalArgumentException("Invalid locale format: " + str);
                        } else if (str.charAt(3) == '_') {
                            return new Locale("", str.substring(1, 3), str.substring(4));
                        } else {
                            throw new IllegalArgumentException("Invalid locale format: " + str);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
    }
}
