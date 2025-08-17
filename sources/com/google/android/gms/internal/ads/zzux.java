package com.google.android.gms.internal.ads;

final class zzux implements zzxj {
    public long zza;
    public long zzb;
    public zzxi zzc;
    public zzux zzd;

    public zzux(long j2, int i2) {
        zze(j2, 65536);
    }

    public final int zza(long j2) {
        long j3 = j2 - this.zza;
        int i2 = this.zzc.zzb;
        return (int) j3;
    }

    public final zzux zzb() {
        this.zzc = null;
        zzux zzux = this.zzd;
        this.zzd = null;
        return zzux;
    }

    public final zzxi zzc() {
        zzxi zzxi = this.zzc;
        zzxi.getClass();
        return zzxi;
    }

    public final zzxj zzd() {
        zzux zzux = this.zzd;
        if (zzux == null || zzux.zzc == null) {
            return null;
        }
        return zzux;
    }

    public final void zze(long j2, int i2) {
        zzdy.zzf(this.zzc == null);
        this.zza = j2;
        this.zzb = j2 + 65536;
    }
}
