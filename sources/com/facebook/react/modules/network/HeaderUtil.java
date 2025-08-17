package com.facebook.react.modules.network;

public class HeaderUtil {
    public static String stripHeaderName(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= ' ' || charAt >= 127) {
                z2 = true;
            } else {
                sb.append(charAt);
            }
        }
        if (z2) {
            return sb.toString();
        }
        return str;
    }

    public static String stripHeaderValue(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt <= 31 || charAt >= 127) && charAt != 9) {
                z2 = true;
            } else {
                sb.append(charAt);
            }
        }
        if (z2) {
            return sb.toString();
        }
        return str;
    }
}
