package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final class zzasm implements Callable {
    private final zzart zza;
    private final zzanq zzb;

    public zzasm(zzart zzart, zzanq zzanq) {
        this.zza = zzart;
        this.zzb = zzanq;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzaon zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                zzanq zzanq = this.zzb;
                byte[] zzax = zzc.zzax();
                zzanq.zzak(zzax, 0, zzax.length, zzgoy.zza());
            }
            return null;
        } catch (zzgpy | NullPointerException unused) {
            return null;
        }
    }
}
