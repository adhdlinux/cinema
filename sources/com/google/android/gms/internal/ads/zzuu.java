package com.google.android.gms.internal.ads;

public final class zzuu implements zzua {
    private final zzgd zzc;
    private int zzd = 1048576;
    private final zzut zze;
    private final zzxt zzf;
    private final zzql zzg;

    public zzuu(zzgd zzgd, zzut zzut) {
        zzql zzql = new zzql();
        zzxt zzxt = new zzxt();
        this.zzc = zzgd;
        this.zze = zzut;
        this.zzg = zzql;
        this.zzf = zzxt;
    }

    public final zzuu zza(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzuw zzb(zzbp zzbp) {
        zzbp.zzd.getClass();
        return new zzuw(zzbp, this.zzc, this.zze, zzqu.zza, this.zzf, this.zzd, (zzuv) null);
    }
}
