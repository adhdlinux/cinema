package com.google.android.gms.internal.ads;

final class zzyj {
    private zzyi zza = new zzyi();
    private zzyi zzb = new zzyi();
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;

    public final float zza() {
        if (this.zza.zzf()) {
            return (float) (1.0E9d / ((double) this.zza.zza()));
        }
        return -1.0f;
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        if (this.zza.zzf()) {
            return this.zza.zza();
        }
        return -9223372036854775807L;
    }

    public final long zzd() {
        if (this.zza.zzf()) {
            return this.zza.zzb();
        }
        return -9223372036854775807L;
    }

    public final void zze(long j2) {
        this.zza.zzc(j2);
        int i2 = 0;
        if (this.zza.zzf()) {
            this.zzc = false;
        } else if (this.zzd != -9223372036854775807L) {
            if (!this.zzc || this.zzb.zze()) {
                this.zzb.zzd();
                this.zzb.zzc(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzc(j2);
        }
        if (this.zzc && this.zzb.zzf()) {
            zzyi zzyi = this.zza;
            this.zza = this.zzb;
            this.zzb = zzyi;
            this.zzc = false;
        }
        this.zzd = j2;
        if (!this.zza.zzf()) {
            i2 = this.zze + 1;
        }
        this.zze = i2;
    }

    public final void zzf() {
        this.zza.zzd();
        this.zzb.zzd();
        this.zzc = false;
        this.zzd = -9223372036854775807L;
        this.zze = 0;
    }

    public final boolean zzg() {
        return this.zza.zzf();
    }
}
