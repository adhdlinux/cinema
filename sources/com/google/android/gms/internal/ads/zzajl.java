package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzajl implements zzaah {
    private final zzfh zza;
    private final zzfa zzb = new zzfa();
    private final int zzc;

    public zzajl(int i2, zzfh zzfh, int i3) {
        this.zzc = i2;
        this.zza = zzfh;
    }

    public final zzaag zza(zzaax zzaax, long j2) throws IOException {
        int zza2;
        int i2;
        long j3;
        long zzf = zzaax.zzf();
        int min = (int) Math.min(112800, zzaax.zzd() - zzf);
        this.zzb.zzC(min);
        ((zzaam) zzaax).zzm(this.zzb.zzH(), 0, min, false);
        zzfa zzfa = this.zzb;
        int zzd = zzfa.zzd();
        long j4 = -1;
        long j5 = -9223372036854775807L;
        long j6 = -1;
        while (zzfa.zza() >= 188 && (i2 = zza2 + 188) <= zzd) {
            long zzb2 = zzajx.zzb(zzfa, (zza2 = zzajx.zza(zzfa.zzH(), zzfa.zzc(), zzd)), this.zzc);
            if (zzb2 != -9223372036854775807L) {
                long zzb3 = this.zza.zzb(zzb2);
                if (zzb3 > j2) {
                    if (j5 == -9223372036854775807L) {
                        return zzaag.zzd(zzb3, zzf);
                    }
                    j3 = zzf + j6;
                } else if (100000 + zzb3 > j2) {
                    j3 = zzf + ((long) zza2);
                } else {
                    j6 = (long) zza2;
                    j5 = zzb3;
                }
                return zzaag.zze(j3);
            }
            zzfa.zzF(i2);
            j4 = (long) i2;
        }
        if (j5 != -9223372036854775807L) {
            return zzaag.zzf(j5, zzf + j4);
        }
        return zzaag.zza;
    }

    public final void zzb() {
        zzfa zzfa = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfa.zzD(bArr, 0);
    }
}
