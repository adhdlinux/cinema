package com.google.android.gms.internal.ads;

import android.os.StrictMode;

public final class zzbbr {
    /* JADX INFO: finally extract failed */
    public static Object zza(zzfpx zzfpx) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            Object zza = zzfpx.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }
}
