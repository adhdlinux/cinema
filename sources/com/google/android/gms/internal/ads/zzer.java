package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class zzer {
    private static final Object zza = new Object();
    private static final zzeq zzb = zzeq.zza;

    @Pure
    public static String zza(String str, Throwable th) {
        String str2;
        if (th != null) {
            synchronized (zza) {
                Throwable th2 = th;
                while (true) {
                    if (th2 == null) {
                        str2 = Log.getStackTraceString(th).trim().replace("\t", "    ");
                        break;
                    } else if (th2 instanceof UnknownHostException) {
                        str2 = "UnknownHostException (no network)";
                        break;
                    } else {
                        th2 = th2.getCause();
                    }
                }
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String replace = str2.replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\n  ");
        return str + "\n  " + replace + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
    }

    @Pure
    public static void zzb(String str, String str2) {
        synchronized (zza) {
            Log.d(str, zza(str2, (Throwable) null));
        }
    }

    @Pure
    public static void zzc(String str, String str2) {
        synchronized (zza) {
            Log.e(str, zza(str2, (Throwable) null));
        }
    }

    @Pure
    public static void zzd(String str, String str2, Throwable th) {
        synchronized (zza) {
            Log.e(str, zza(str2, th));
        }
    }

    @Pure
    public static void zze(String str, String str2) {
        synchronized (zza) {
            Log.i(str, zza(str2, (Throwable) null));
        }
    }

    @Pure
    public static void zzf(String str, String str2) {
        synchronized (zza) {
            Log.w(str, zza(str2, (Throwable) null));
        }
    }

    @Pure
    public static void zzg(String str, String str2, Throwable th) {
        synchronized (zza) {
            Log.w(str, zza(str2, th));
        }
    }
}
