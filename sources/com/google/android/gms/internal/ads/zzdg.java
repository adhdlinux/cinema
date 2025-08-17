package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdg {
    public static final zzn zza = zzdf.zza;
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(3, 36);
    private static final String zzf = Integer.toString(4, 36);
    public final int zzb = 1;
    private final zzcy zzg;
    private final int[] zzh;
    private final boolean[] zzi;

    public zzdg(zzcy zzcy, boolean z2, int[] iArr, boolean[] zArr) {
        int i2 = zzcy.zzb;
        this.zzg = zzcy;
        this.zzh = (int[]) iArr.clone();
        this.zzi = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdg.class == obj.getClass()) {
            zzdg zzdg = (zzdg) obj;
            if (!this.zzg.equals(zzdg.zzg) || !Arrays.equals(this.zzh, zzdg.zzh) || !Arrays.equals(this.zzi, zzdg.zzi)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.zzg.hashCode() * 961) + Arrays.hashCode(this.zzh)) * 31) + Arrays.hashCode(this.zzi);
    }

    public final int zza() {
        return this.zzg.zzd;
    }

    public final zzam zzb(int i2) {
        return this.zzg.zzb(i2);
    }

    public final boolean zzc() {
        for (boolean z2 : this.zzi) {
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(int i2) {
        return this.zzi[i2];
    }
}
