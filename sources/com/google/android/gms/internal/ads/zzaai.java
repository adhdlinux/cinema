package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzaai {
    protected final zzaac zza;
    protected final zzaah zzb;
    protected zzaae zzc;
    private final int zzd;

    protected zzaai(zzaaf zzaaf, zzaah zzaah, long j2, long j3, long j4, long j5, long j6, long j7, int i2) {
        this.zzb = zzaah;
        this.zzd = i2;
        this.zza = new zzaac(zzaaf, j2, 0, j4, j5, j6, j7);
    }

    protected static final int zzf(zzaax zzaax, long j2, zzabs zzabs) {
        if (j2 == zzaax.zzf()) {
            return 0;
        }
        zzabs.zza = j2;
        return 1;
    }

    protected static final boolean zzg(zzaax zzaax, long j2) throws IOException {
        long zzf = j2 - zzaax.zzf();
        if (zzf < 0 || zzf > 262144) {
            return false;
        }
        ((zzaam) zzaax).zzo((int) zzf, false);
        return true;
    }

    public final int zza(zzaax zzaax, zzabs zzabs) throws IOException {
        while (true) {
            zzaae zzaae = this.zzc;
            zzdy.zzb(zzaae);
            long zzb2 = zzaae.zzf;
            long zzc2 = zzaae.zzh;
            if (zzaae.zzg - zzb2 <= ((long) this.zzd)) {
                zzc(false, zzb2);
                return zzf(zzaax, zzb2, zzabs);
            } else if (!zzg(zzaax, zzc2)) {
                return zzf(zzaax, zzc2, zzabs);
            } else {
                zzaax.zzj();
                zzaag zza2 = this.zzb.zza(zzaax, zzaae.zzb);
                int zza3 = zza2.zzb;
                if (zza3 == -3) {
                    zzc(false, zzc2);
                    return zzf(zzaax, zzc2, zzabs);
                } else if (zza3 == -2) {
                    zzaae.zzh(zzaae, zza2.zzc, zza2.zzd);
                } else if (zza3 != -1) {
                    zzg(zzaax, zza2.zzd);
                    zzc(true, zza2.zzd);
                    return zzf(zzaax, zza2.zzd, zzabs);
                } else {
                    zzaae.zzg(zzaae, zza2.zzc, zza2.zzd);
                }
            }
        }
    }

    public final zzabv zzb() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzc(boolean z2, long j2) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j2) {
        long j3 = j2;
        zzaae zzaae = this.zzc;
        if (zzaae == null || zzaae.zza != j3) {
            long zzf = this.zza.zzf(j3);
            zzaac zzaac = this.zza;
            zzaae zzaae2 = r1;
            zzaae zzaae3 = new zzaae(j2, zzf, 0, zzaac.zzc, zzaac.zzd, zzaac.zze, zzaac.zzf);
            this.zzc = zzaae2;
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
