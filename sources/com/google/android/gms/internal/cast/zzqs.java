package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzpy;

final class zzqs extends zzpy.zzi implements Runnable {
    private final Runnable zzb;

    public zzqs(Runnable runnable) {
        runnable.getClass();
        this.zzb = runnable;
    }

    public final void run() {
        try {
            this.zzb.run();
        } catch (Error | RuntimeException e2) {
            zzl(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public final String zze() {
        String obj = this.zzb.toString();
        return "task=[" + obj + "]";
    }
}
