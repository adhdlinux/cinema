package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzhc {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(String str, String str2) {
        long j2 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                zzer.zzc("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j2;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j2;
        }
        try {
            String group = matcher.group(2);
            group.getClass();
            long parseLong = Long.parseLong(group);
            String group2 = matcher.group(1);
            group2.getClass();
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
            if (i2 < 0) {
                return parseLong2;
            }
            if (j2 == parseLong2) {
                return j2;
            }
            zzer.zzf("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j2, parseLong2);
        } catch (NumberFormatException unused2) {
            zzer.zzc("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j2;
        }
    }

    public static long zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }
}
