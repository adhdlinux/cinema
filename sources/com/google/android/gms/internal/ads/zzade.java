package com.google.android.gms.internal.ads;

abstract class zzade {
    protected final zzabz zza;

    protected zzade(zzabz zzabz) {
        this.zza = zzabz;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzfa zzfa) throws zzcd;

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzfa zzfa, long j2) throws zzcd;

    public final boolean zzf(zzfa zzfa, long j2) throws zzcd {
        return zza(zzfa) && zzb(zzfa, j2);
    }
}
