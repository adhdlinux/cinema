package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzacv implements zzaah {
    private final zzabj zza;
    private final int zzb;
    private final zzabe zzc = new zzabe();

    /* synthetic */ zzacv(zzabj zzabj, int i2, zzacu zzacu) {
        this.zza = zzabj;
        this.zzb = i2;
    }

    private final long zzc(zzaax zzaax) throws IOException {
        zzaax zzaax2 = zzaax;
        while (zzaax.zze() < zzaax.zzd() - 6) {
            zzabj zzabj = this.zza;
            int i2 = this.zzb;
            zzabe zzabe = this.zzc;
            long zze = zzaax.zze();
            byte[] bArr = new byte[2];
            zzaam zzaam = (zzaam) zzaax2;
            zzaam.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i2) {
                zzaax.zzj();
                zzaam.zzl((int) (zze - zzaax.zzf()), false);
            } else {
                zzfa zzfa = new zzfa(16);
                System.arraycopy(bArr, 0, zzfa.zzH(), 0, 2);
                zzfa.zzE(zzaba.zza(zzaax2, zzfa.zzH(), 2, 14));
                zzaax.zzj();
                zzaam.zzl((int) (zze - zzaax.zzf()), false);
                if (zzabf.zzc(zzfa, zzabj, i2, zzabe)) {
                    break;
                }
            }
            zzaam.zzl(1, false);
        }
        if (zzaax.zze() < zzaax.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzaam) zzaax2).zzl((int) (zzaax.zzd() - zzaax.zze()), false);
        return this.zza.zzj;
    }

    public final zzaag zza(zzaax zzaax, long j2) throws IOException {
        long zzf = zzaax.zzf();
        long zzc2 = zzc(zzaax);
        long zze = zzaax.zze();
        ((zzaam) zzaax).zzl(Math.max(6, this.zza.zzc), false);
        int i2 = (zzc2 > j2 ? 1 : (zzc2 == j2 ? 0 : -1));
        long zzc3 = zzc(zzaax);
        long zze2 = zzaax.zze();
        if (i2 <= 0 && zzc3 > j2) {
            return zzaag.zze(zze);
        }
        if (zzc3 <= j2) {
            return zzaag.zzf(zzc3, zze2);
        }
        return zzaag.zzd(zzc2, zzf);
    }

    public final /* synthetic */ void zzb() {
    }
}
