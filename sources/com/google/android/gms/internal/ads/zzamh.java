package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class zzamh {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e2) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzalw.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzalw.zzc(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static zzakt zzb(zzalg zzalg) {
        long j2;
        long j3;
        long j4;
        boolean z2;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        zzalg zzalg2 = zzalg;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzalg2.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        if (str != null) {
            j2 = zza(str);
        } else {
            j2 = 0;
        }
        String str2 = (String) map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z2 = false;
            j4 = 0;
            j3 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j4 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z2 = true;
                }
                i2++;
            }
            i2 = 1;
        } else {
            z2 = false;
            j4 = 0;
            j3 = 0;
        }
        String str3 = (String) map.get("Expires");
        if (str3 != null) {
            j5 = zza(str3);
        } else {
            j5 = 0;
        }
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j6 = zza(str4);
        } else {
            j6 = 0;
        }
        String str5 = (String) map.get("ETag");
        if (i2 != 0) {
            j8 = currentTimeMillis + (j3 * 1000);
            if (z2) {
                j9 = j8;
            } else {
                Long.signum(j4);
                j9 = (j4 * 1000) + j8;
            }
            j7 = j9;
        } else {
            j7 = 0;
            if (j2 <= 0 || j5 < j2) {
                j8 = 0;
            } else {
                j8 = currentTimeMillis + (j5 - j2);
                j7 = j8;
            }
        }
        zzakt zzakt = new zzakt();
        zzakt.zza = zzalg2.zzb;
        zzakt.zzb = str5;
        zzakt.zzf = j8;
        zzakt.zze = j7;
        zzakt.zzc = j2;
        zzakt.zzd = j6;
        zzakt.zzg = map;
        zzakt.zzh = zzalg2.zzd;
        return zzakt;
    }

    static String zzc(long j2) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j2));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
