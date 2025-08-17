package com.google.android.gms.internal.ads;

public final class zzaiv implements zzaij {
    private final zzfa zza = new zzfa(10);
    private zzabz zzb;
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;
    private int zzf;

    public final void zza(zzfa zzfa) {
        zzdy.zzb(this.zzb);
        if (this.zzc) {
            int zza2 = zzfa.zza();
            int i2 = this.zzf;
            if (i2 < 10) {
                int min = Math.min(zza2, 10 - i2);
                System.arraycopy(zzfa.zzH(), zzfa.zzc(), this.zza.zzH(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzF(0);
                    if (this.zza.zzk() == 73 && this.zza.zzk() == 68 && this.zza.zzk() == 51) {
                        this.zza.zzG(3);
                        this.zze = this.zza.zzj() + 10;
                    } else {
                        zzer.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zza2, this.zze - this.zzf);
            this.zzb.zzq(zzfa, min2);
            this.zzf += min2;
        }
    }

    public final void zzb(zzaaz zzaaz, zzajv zzajv) {
        zzajv.zzc();
        zzabz zzv = zzaaz.zzv(zzajv.zza(), 5);
        this.zzb = zzv;
        zzak zzak = new zzak();
        zzak.zzH(zzajv.zzb());
        zzak.zzS("application/id3");
        zzv.zzk(zzak.zzY());
    }

    public final void zzc() {
        int i2;
        zzdy.zzb(this.zzb);
        if (this.zzc && (i2 = this.zze) != 0 && this.zzf == i2) {
            long j2 = this.zzd;
            if (j2 != -9223372036854775807L) {
                this.zzb.zzs(j2, 1, i2, 0, (zzaby) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.zzc = true;
            if (j2 != -9223372036854775807L) {
                this.zzd = j2;
            }
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }
}
