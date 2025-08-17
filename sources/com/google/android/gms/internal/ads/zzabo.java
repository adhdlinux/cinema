package com.google.android.gms.internal.ads;

public final class zzabo implements zzabv {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzabo(long[] jArr, long[] jArr2, long j2) {
        boolean z2;
        boolean z3;
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length == length2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        if (length2 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzd = z3;
        if (!z3 || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i2 = length2 + 1;
            long[] jArr3 = new long[i2];
            this.zza = jArr3;
            long[] jArr4 = new long[i2];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.zzc = j2;
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzabt zzg(long j2) {
        if (!this.zzd) {
            zzabw zzabw = zzabw.zza;
            return new zzabt(zzabw, zzabw);
        }
        int zzc2 = zzfj.zzc(this.zzb, j2, true, true);
        zzabw zzabw2 = new zzabw(this.zzb[zzc2], this.zza[zzc2]);
        if (zzabw2.zzb != j2) {
            long[] jArr = this.zzb;
            if (zzc2 != jArr.length - 1) {
                int i2 = zzc2 + 1;
                return new zzabt(zzabw2, new zzabw(jArr[i2], this.zza[i2]));
            }
        }
        return new zzabt(zzabw2, zzabw2);
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
