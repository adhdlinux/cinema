package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzaie implements zzaaw {
    public static final zzabd zza = zzaid.zza;
    private final zzaif zzb;
    private final zzfa zzc;
    private final zzfa zzd;
    private final zzez zze;
    private zzaaz zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzaie() {
        this(0);
    }

    public final int zza(zzaax zzaax, zzabs zzabs) throws IOException {
        zzdy.zzb(this.zzf);
        int zza2 = zzaax.zza(this.zzc.zzH(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzN(new zzabu(-9223372036854775807L, 0));
            this.zzj = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzF(0);
        this.zzc.zzE(zza2);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final void zzb(zzaaz zzaaz) {
        this.zzf = zzaaz;
        this.zzb.zzb(zzaaz, new zzajv(Integer.MIN_VALUE, 0, 1));
        zzaaz.zzC();
    }

    public final void zzc(long j2, long j3) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j3;
    }

    public final boolean zzd(zzaax zzaax) throws IOException {
        int i2 = 0;
        while (true) {
            zzaam zzaam = (zzaam) zzaax;
            zzaam.zzm(this.zzd.zzH(), 0, 10, false);
            this.zzd.zzF(0);
            if (this.zzd.zzm() != 4801587) {
                break;
            }
            this.zzd.zzG(3);
            int zzj2 = this.zzd.zzj();
            i2 += zzj2 + 10;
            zzaam.zzl(zzj2, false);
        }
        zzaax.zzj();
        zzaam zzaam2 = (zzaam) zzaax;
        zzaam2.zzl(i2, false);
        if (this.zzh == -1) {
            this.zzh = (long) i2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        do {
            zzaam2.zzm(this.zzd.zzH(), 0, 2, false);
            this.zzd.zzF(0);
            if (!zzaif.zzf(this.zzd.zzo())) {
                i3++;
                zzaax.zzj();
                zzaam2.zzl(i3, false);
            } else {
                i4++;
                if (i4 >= 4 && i5 > 188) {
                    return true;
                }
                zzaam2.zzm(this.zzd.zzH(), 0, 4, false);
                this.zze.zzj(14);
                int zzd2 = this.zze.zzd(13);
                if (zzd2 <= 6) {
                    i3++;
                    zzaax.zzj();
                    zzaam2.zzl(i3, false);
                } else {
                    zzaam2.zzl(zzd2 - 6, false);
                    i5 += zzd2;
                }
            }
            i4 = 0;
            i5 = 0;
        } while (i3 - i2 < 8192);
        return false;
    }

    public zzaie(int i2) {
        this.zzb = new zzaif(true, (String) null);
        this.zzc = new zzfa(2048);
        this.zzh = -1;
        zzfa zzfa = new zzfa(10);
        this.zzd = zzfa;
        byte[] zzH = zzfa.zzH();
        this.zze = new zzez(zzH, zzH.length);
    }
}
