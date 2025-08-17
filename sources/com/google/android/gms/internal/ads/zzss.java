package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzss implements zzvf {
    public final zzvf zza;
    final /* synthetic */ zzst zzb;
    private boolean zzc;

    public zzss(zzst zzst, zzvf zzvf) {
        this.zzb = zzst;
        this.zza = zzvf;
    }

    public final int zza(zzkj zzkj, zzhp zzhp, int i2) {
        if (this.zzb.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhp.zzc(4);
            return -4;
        }
        int zza2 = this.zza.zza(zzkj, zzhp, i2);
        if (zza2 == -5) {
            zzam zzam = zzkj.zza;
            zzam.getClass();
            int i3 = zzam.zzC;
            int i4 = 0;
            if (i3 == 0) {
                if (zzam.zzD != 0) {
                    i3 = 0;
                }
                return -5;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                i4 = zzam.zzD;
            }
            zzak zzb2 = zzam.zzb();
            zzb2.zzC(i3);
            zzb2.zzD(i4);
            zzkj.zza = zzb2.zzY();
            return -5;
        }
        zzst zzst = this.zzb;
        long j2 = zzst.zzb;
        if (j2 == Long.MIN_VALUE || ((zza2 != -4 || zzhp.zzd < j2) && (zza2 != -3 || zzst.zzb() != Long.MIN_VALUE || zzhp.zzc))) {
            return zza2;
        }
        zzhp.zzb();
        zzhp.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j2) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j2);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
