package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Locale;

public final class zzalw {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable(zza, 2);
    private static final String zzc = zzalw.class.getName();

    public static void zza(String str, Object... objArr) {
        Log.d(zza, zze(str, objArr));
    }

    public static void zzb(String str, Object... objArr) {
        Log.e(zza, zze(str, objArr));
    }

    public static void zzc(Throwable th, String str, Object... objArr) {
        Log.e(zza, zze(str, objArr), th);
    }

    public static void zzd(String str, Object... objArr) {
        if (zzb) {
            Log.v(zza, zze(str, objArr));
        }
    }

    private static String zze(String str, Object... objArr) {
        String str2;
        String format = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals(zzc)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, format});
    }
}
