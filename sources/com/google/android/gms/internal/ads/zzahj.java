package com.google.android.gms.internal.ads;

final class zzahj implements zzahp {
    private final zzabj zza;
    private final zzabi zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzahj(zzabj zzabj, zzabi zzabi) {
        this.zza = zzabj;
        this.zzb = zzabi;
    }

    public final void zza(long j2) {
        this.zzc = j2;
    }

    public final long zzd(zzaax zzaax) {
        long j2 = this.zzd;
        if (j2 < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j2 + 2);
    }

    public final zzabv zze() {
        zzdy.zzf(this.zzc != -1);
        return new zzabh(this.zza, this.zzc);
    }

    public final void zzg(long j2) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfj.zzc(jArr, j2, true, true)];
    }
}
