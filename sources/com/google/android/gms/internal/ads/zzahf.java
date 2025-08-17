package com.google.android.gms.internal.ads;

final class zzahf {
    public final zzahc zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzahf(zzahc zzahc, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        boolean z2;
        boolean z3;
        int length = iArr.length;
        int length2 = jArr2.length;
        boolean z4 = true;
        if (length == length2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        int length3 = jArr.length;
        if (length3 == length2) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        int length4 = iArr2.length;
        zzdy.zzd(length4 != length2 ? false : z4);
        this.zza = zzahc;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i2;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j2;
        this.zzb = length3;
        if (length4 > 0) {
            int i3 = length4 - 1;
            iArr2[i3] = iArr2[i3] | 536870912;
        }
    }

    public final int zza(long j2) {
        for (int zzc2 = zzfj.zzc(this.zzf, j2, true, false); zzc2 >= 0; zzc2--) {
            if ((this.zzg[zzc2] & 1) != 0) {
                return zzc2;
            }
        }
        return -1;
    }

    public final int zzb(long j2) {
        for (int zza2 = zzfj.zza(this.zzf, j2, true, false); zza2 < this.zzf.length; zza2++) {
            if ((this.zzg[zza2] & 1) != 0) {
                return zza2;
            }
        }
        return -1;
    }
}
