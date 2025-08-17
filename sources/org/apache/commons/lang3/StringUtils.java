package org.apache.commons.lang3;

public class StringUtils {
    public static String a(String str) {
        int length;
        int codePointAt;
        int titleCase;
        if (str == null || (length = str.length()) == 0 || (codePointAt = str.codePointAt(0)) == (titleCase = Character.toTitleCase(codePointAt))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = titleCase;
        int charCount = Character.charCount(codePointAt);
        int i2 = 1;
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i2] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static boolean b(CharSequence charSequence, char... cArr) {
        if (!f(charSequence) && !ArrayUtils.c(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i2 = length - 1;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                            return true;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean c(CharSequence charSequence, char... cArr) {
        if (!(charSequence == null || cArr == null)) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                            return false;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean d(CharSequence charSequence) {
        if (charSequence == null || f(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLowerCase(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(CharSequence charSequence) {
        if (charSequence == null || f(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isUpperCase(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean g(CharSequence charSequence) {
        if (f(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static String h(String str, String str2, String str3) {
        return i(str, str2, str3, -1);
    }

    public static String i(String str, String str2, String str3, int i2) {
        return j(str, str2, str3, i2, false);
    }

    private static String j(String str, String str2, String str3, int i2, boolean z2) {
        String str4;
        int i3;
        if (f(str) || f(str2) || str3 == null || i2 == 0) {
            return str;
        }
        if (z2) {
            str4 = str.toLowerCase();
            str2 = str2.toLowerCase();
        } else {
            str4 = str;
        }
        int i4 = 0;
        int indexOf = str4.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        if (i2 < 0) {
            i3 = 16;
        } else {
            i3 = 64;
            if (i2 <= 64) {
                i3 = i2;
            }
        }
        StringBuilder sb = new StringBuilder(str.length() + (length2 * i3));
        while (indexOf != -1) {
            sb.append(str.substring(i4, indexOf));
            sb.append(str3);
            i4 = indexOf + length;
            i2--;
            if (i2 == 0) {
                break;
            }
            indexOf = str4.indexOf(str2, i4);
        }
        sb.append(str.substring(i4));
        return sb.toString();
    }
}
