package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.concurrent.Callable;

public final class zzcb {
    @Deprecated
    public static Object zza(Context context, Callable callable) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            Object call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            zzbzr.zzh("Unexpected exception.", th);
            zzbsw.zza(context).zzf(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }
}
