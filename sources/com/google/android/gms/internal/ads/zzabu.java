package com.google.android.gms.internal.ads;

public class zzabu implements zzabv {
    private final long zza;
    private final zzabt zzb;

    public zzabu(long j2, long j3) {
        this.zza = j2;
        zzabw zzabw = j3 == 0 ? zzabw.zza : new zzabw(0, j3);
        this.zzb = new zzabt(zzabw, zzabw);
    }

    public final long zze() {
        return this.zza;
    }

    public final zzabt zzg(long j2) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }
}
