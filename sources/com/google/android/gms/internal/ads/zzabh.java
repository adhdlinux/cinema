package com.google.android.gms.internal.ads;

public final class zzabh implements zzabv {
    private final zzabj zza;
    private final long zzb;

    public zzabh(zzabj zzabj, long j2) {
        this.zza = zzabj;
        this.zzb = j2;
    }

    private final zzabw zza(long j2, long j3) {
        return new zzabw((j2 * 1000000) / ((long) this.zza.zze), this.zzb + j3);
    }

    public final long zze() {
        return this.zza.zza();
    }

    public final zzabt zzg(long j2) {
        long j3;
        zzdy.zzb(this.zza.zzk);
        zzabj zzabj = this.zza;
        zzabi zzabi = zzabj.zzk;
        long[] jArr = zzabi.zza;
        long[] jArr2 = zzabi.zzb;
        int zzc = zzfj.zzc(jArr, zzabj.zzb(j2), true, false);
        long j4 = 0;
        if (zzc == -1) {
            j3 = 0;
        } else {
            j3 = jArr[zzc];
        }
        if (zzc != -1) {
            j4 = jArr2[zzc];
        }
        zzabw zza2 = zza(j3, j4);
        if (zza2.zzb == j2 || zzc == jArr.length - 1) {
            return new zzabt(zza2, zza2);
        }
        int i2 = zzc + 1;
        return new zzabt(zza2, zza(jArr[i2], jArr2[i2]));
    }

    public final boolean zzh() {
        return true;
    }
}
