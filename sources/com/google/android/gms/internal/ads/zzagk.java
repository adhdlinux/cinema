package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

final class zzagk implements zzagh {
    private final zzfa zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzagk(zzagd zzagd) {
        zzfa zzfa = zzagd.zza;
        this.zza = zzfa;
        zzfa.zzF(12);
        this.zzc = zzfa.zzn() & JfifUtil.MARKER_FIRST_BYTE;
        this.zzb = zzfa.zzn();
    }

    public final int zza() {
        return -1;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i2 = this.zzc;
        if (i2 == 8) {
            return this.zza.zzk();
        }
        if (i2 == 16) {
            return this.zza.zzo();
        }
        int i3 = this.zzd;
        this.zzd = i3 + 1;
        if (i3 % 2 != 0) {
            return this.zze & 15;
        }
        int zzk = this.zza.zzk();
        this.zze = zzk;
        return (zzk & 240) >> 4;
    }
}
