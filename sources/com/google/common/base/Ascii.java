package com.google.common.base;

public final class Ascii {
    private Ascii() {
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int b2;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            char charAt2 = charSequence2.charAt(i2);
            if (charAt != charAt2 && ((b2 = b(charAt)) >= 26 || b2 != b(charAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int b(char c2) {
        return (char) ((c2 | ' ') - 'a');
    }

    public static boolean c(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean d(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static String e(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (d(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (d(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static String f(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (c(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (c(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }
}
