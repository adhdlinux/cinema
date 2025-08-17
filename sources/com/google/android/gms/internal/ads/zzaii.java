package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zzaii implements zzaij {
    private final List zza;
    private final zzabz[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = -9223372036854775807L;

    public zzaii(List list) {
        this.zza = list;
        this.zzb = new zzabz[list.size()];
    }

    private final boolean zzf(zzfa zzfa, int i2) {
        if (zzfa.zza() == 0) {
            return false;
        }
        if (zzfa.zzk() != i2) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzfa zzfa) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzfa, 32)) {
            if (this.zzd != 1 || zzf(zzfa, 0)) {
                int zzc2 = zzfa.zzc();
                int zza2 = zzfa.zza();
                for (zzabz zzq : this.zzb) {
                    zzfa.zzF(zzc2);
                    zzq.zzq(zzfa, zza2);
                }
                this.zze += zza2;
            }
        }
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        for (int i2 = 0; i2 < this.zzb.length; i2++) {
            zzajs zzajs = (zzajs) this.zza.get(i2);
            zzajv.zzc();
            zzabz zzv = zzaaz.zzv(zzajv.zza(), 3);
            zzak zzak = new zzak();
            zzak.zzH(zzajv.zzb());
            zzak.zzS("application/dvbsubs");
            zzak.zzI(Collections.singletonList(zzajs.zzb));
            zzak.zzK(zzajs.zza);
            zzv.zzk(zzak.zzY());
            this.zzb[i2] = zzv;
        }
    }

    public final void zzc() {
        if (this.zzc) {
            if (this.zzf != -9223372036854775807L) {
                for (zzabz zzs : this.zzb) {
                    zzs.zzs(this.zzf, 1, this.zze, 0, (zzaby) null);
                }
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.zzc = true;
            if (j2 != -9223372036854775807L) {
                this.zzf = j2;
            }
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }
}
