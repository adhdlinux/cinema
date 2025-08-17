package com.google.android.gms.internal.ads;

public final class zzaac implements zzabv {
    private final zzaaf zza;
    private final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final long zze;
    /* access modifiers changed from: private */
    public final long zzf;

    public zzaac(zzaaf zzaaf, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.zza = zzaaf;
        this.zzb = j2;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = j6;
        this.zzf = j7;
    }

    public final long zze() {
        return this.zzb;
    }

    public final long zzf(long j2) {
        return this.zza.zza(j2);
    }

    public final zzabt zzg(long j2) {
        zzabw zzabw = new zzabw(j2, zzaae.zzf(this.zza.zza(j2), 0, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzabt(zzabw, zzabw);
    }

    public final boolean zzh() {
        return true;
    }
}
