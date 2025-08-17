package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzcgf {
    private static final Pattern zza = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zza(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = zza.matcher(str);
        int i2 = 0;
        if (matcher.find()) {
            int end = matcher.end();
            sb.append(str.substring(0, end));
            while (i2 <= 0) {
                String str2 = strArr[i2];
                if (str2 != null) {
                    sb.append(str2);
                }
                i2++;
            }
            sb.append(str.substring(end));
        } else {
            if (!zzb.matcher(str).find()) {
                while (i2 <= 0) {
                    String str3 = strArr[i2];
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    i2++;
                }
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
