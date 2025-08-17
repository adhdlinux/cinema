package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfwb {
    private final boolean zza;
    private final zzfsc zzb;

    /* synthetic */ zzfwb(boolean z2, zzfsc zzfsc, zzfwa zzfwa) {
        this.zza = z2;
        this.zzb = zzfsc;
    }

    public final zzfwm zza(Callable callable, Executor executor) {
        return new zzfvp(this.zzb, this.zza, executor, callable);
    }
}
