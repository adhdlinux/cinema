package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;

public class zzbzr {
    protected static final zzfpu zza = zzfpu.zzb(4000);

    static String zzd(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        return str + " @" + lineNumber;
    }

    public static void zze(String str) {
        if (!zzm(3)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.d(AdRequest.LOGTAG, str);
            return;
        }
        boolean z2 = true;
        for (String str2 : zza.zzd(str)) {
            if (z2) {
                Log.d(AdRequest.LOGTAG, str2);
            } else {
                Log.d("Ads-cont", str2);
            }
            z2 = false;
        }
    }

    public static void zzf(String str, Throwable th) {
        if (zzm(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzg(String str) {
        if (!zzm(6)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.e(AdRequest.LOGTAG, str);
            return;
        }
        boolean z2 = true;
        for (String str2 : zza.zzd(str)) {
            if (z2) {
                Log.e(AdRequest.LOGTAG, str2);
            } else {
                Log.e("Ads-cont", str2);
            }
            z2 = false;
        }
    }

    public static void zzh(String str, Throwable th) {
        if (zzm(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzi(String str) {
        if (!zzm(4)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.i(AdRequest.LOGTAG, str);
            return;
        }
        boolean z2 = true;
        for (String str2 : zza.zzd(str)) {
            if (z2) {
                Log.i(AdRequest.LOGTAG, str2);
            } else {
                Log.i("Ads-cont", str2);
            }
            z2 = false;
        }
    }

    public static void zzj(String str) {
        if (!zzm(5)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.w(AdRequest.LOGTAG, str);
            return;
        }
        boolean z2 = true;
        for (String str2 : zza.zzd(str)) {
            if (z2) {
                Log.w(AdRequest.LOGTAG, str2);
            } else {
                Log.w("Ads-cont", str2);
            }
            z2 = false;
        }
    }

    public static void zzk(String str, Throwable th) {
        if (zzm(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzl(String str, Throwable th) {
        if (!zzm(5)) {
            return;
        }
        if (th != null) {
            zzk(zzd(str), th);
        } else {
            zzj(zzd(str));
        }
    }

    public static boolean zzm(int i2) {
        if (i2 >= 5 || Log.isLoggable(AdRequest.LOGTAG, i2)) {
            return true;
        }
        return false;
    }
}
