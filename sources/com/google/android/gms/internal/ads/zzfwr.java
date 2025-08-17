package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfuq;

final class zzfwr extends zzfuq.zzi implements Runnable {
    private final Runnable zza;

    public zzfwr(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Error | RuntimeException e2) {
            zze(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        String obj = this.zza.toString();
        return "task=[" + obj + "]";
    }
}
