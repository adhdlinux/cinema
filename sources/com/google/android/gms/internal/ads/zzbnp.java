package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbnp {
    private static zzbnp zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzbnp() {
    }

    public static zzbnp zza() {
        if (zza == null) {
            zza = new zzbnp();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbno(this, context, str));
        thread.start();
        return thread;
    }
}
