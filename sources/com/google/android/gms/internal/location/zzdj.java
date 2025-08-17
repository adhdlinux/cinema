package com.google.android.gms.internal.location;

import com.facebook.common.time.Clock;
import com.vungle.ads.internal.signals.SignalManager;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class zzdj {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc = new StringBuilder(33);

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
    }

    public static String zza(long j2) {
        String sb;
        StringBuilder sb2 = zzc;
        synchronized (sb2) {
            sb2.setLength(0);
            zzb(j2, sb2);
            sb = sb2.toString();
        }
        return sb;
    }

    public static void zzb(long j2, StringBuilder sb) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z2 = false;
        if (i2 < 0) {
            sb.append("-");
            if (j2 != Long.MIN_VALUE) {
                j2 = -j2;
            } else {
                j2 = Clock.MAX_TIME;
                z2 = true;
            }
        }
        if (j2 >= SignalManager.TWENTY_FOUR_HOURS_MILLIS) {
            sb.append(j2 / SignalManager.TWENTY_FOUR_HOURS_MILLIS);
            sb.append("d");
            j2 %= SignalManager.TWENTY_FOUR_HOURS_MILLIS;
        }
        if (true == z2) {
            j2 = 25975808;
        }
        if (j2 >= 3600000) {
            sb.append(j2 / 3600000);
            sb.append("h");
            j2 %= 3600000;
        }
        if (j2 >= 60000) {
            sb.append(j2 / 60000);
            sb.append("m");
            j2 %= 60000;
        }
        if (j2 >= 1000) {
            sb.append(j2 / 1000);
            sb.append("s");
            j2 %= 1000;
        }
        if (j2 > 0) {
            sb.append(j2);
            sb.append("ms");
        }
    }
}
