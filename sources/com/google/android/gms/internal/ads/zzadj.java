package com.google.android.gms.internal.ads;

final class zzadj extends zzabk {
    private final long zza;

    public zzadj(zzaax zzaax, long j2) {
        super(zzaax);
        boolean z2;
        if (zzaax.zzf() >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        this.zza = j2;
    }

    public final long zzd() {
        return super.zzd() - this.zza;
    }

    public final long zze() {
        return super.zze() - this.zza;
    }

    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
