package com.google.android.gms.internal.ads;

public final class zzr {
    private int zza;
    private int zzb;
    private int zzc;
    private byte[] zzd;

    public zzr() {
        this.zza = -1;
        this.zzb = -1;
        this.zzc = -1;
    }

    /* synthetic */ zzr(zzs zzs, zzq zzq) {
        this.zza = zzs.zzd;
        this.zzb = zzs.zze;
        this.zzc = zzs.zzf;
        this.zzd = zzs.zzg;
    }

    public final zzr zza(int i2) {
        this.zzb = 1;
        return this;
    }

    public final zzr zzb(int i2) {
        this.zza = 1;
        return this;
    }

    public final zzr zzc(int i2) {
        this.zzc = i2;
        return this;
    }

    public final zzs zzd() {
        return new zzs(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
