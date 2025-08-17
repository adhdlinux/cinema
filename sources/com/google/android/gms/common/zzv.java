package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzv extends zzx {
    private final Callable zze;

    /* synthetic */ zzv(Callable callable, zzu zzu) {
        super(false, 1, 5, (String) null, (Throwable) null, (zzw) null);
        this.zze = callable;
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
