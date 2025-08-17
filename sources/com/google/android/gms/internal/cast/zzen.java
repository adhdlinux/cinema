package com.google.android.gms.internal.cast;

public final class zzen {
    public static String zza(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (zzb(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (zzb(c2)) {
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

    public static boolean zzb(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }
}
