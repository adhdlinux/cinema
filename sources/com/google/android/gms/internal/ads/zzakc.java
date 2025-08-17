package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzakc implements zzakb {
    private final zzaaz zza;
    private final zzabz zzb;
    private final zzake zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzakc(zzaaz zzaaz, zzabz zzabz, zzake zzake, String str, int i2) throws zzcd {
        this.zza = zzaaz;
        this.zzb = zzabz;
        this.zzc = zzake;
        int i3 = zzake.zzb * zzake.zze;
        int i4 = zzake.zzd;
        int i5 = i3 / 8;
        if (i4 == i5) {
            int i6 = zzake.zzc * i5;
            int i7 = i6 * 8;
            int max = Math.max(i5, i6 / 10);
            this.zze = max;
            zzak zzak = new zzak();
            zzak.zzS(str);
            zzak.zzv(i7);
            zzak.zzO(i7);
            zzak.zzL(max);
            zzak.zzw(zzake.zzb);
            zzak.zzT(zzake.zzc);
            zzak.zzN(i2);
            this.zzd = zzak.zzY();
            return;
        }
        throw zzcd.zza("Expected block size: " + i5 + "; got: " + i4, (Throwable) null);
    }

    public final void zza(int i2, long j2) {
        this.zza.zzN(new zzakh(this.zzc, 1, (long) i2, j2));
        this.zzb.zzk(this.zzd);
    }

    public final void zzb(long j2) {
        this.zzf = j2;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzaax zzaax, long j2) throws IOException {
        int i2;
        int i3;
        int i4;
        long j3 = j2;
        while (true) {
            i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
            if (i2 <= 0 || (i3 = this.zzg) >= (i4 = this.zze)) {
                zzake zzake = this.zzc;
                int i5 = zzake.zzd;
                int i6 = this.zzg / i5;
            } else {
                int zza2 = zzabx.zza(this.zzb, zzaax, (int) Math.min((long) (i4 - i3), j3), true);
                if (zza2 == -1) {
                    j3 = 0;
                } else {
                    this.zzg += zza2;
                    j3 -= (long) zza2;
                }
            }
        }
        zzake zzake2 = this.zzc;
        int i52 = zzake2.zzd;
        int i62 = this.zzg / i52;
        if (i62 > 0) {
            int i7 = i62 * i52;
            int i8 = this.zzg - i7;
            this.zzb.zzs(this.zzf + zzfj.zzp(this.zzh, 1000000, (long) zzake2.zzc), 1, i7, i8, (zzaby) null);
            this.zzh += (long) i62;
            this.zzg = i8;
        }
        if (i2 <= 0) {
            return true;
        }
        return false;
    }
}
