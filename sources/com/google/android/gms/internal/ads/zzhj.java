package com.google.android.gms.internal.ads;

public class zzhj {
    private int zza;

    public final void zza(int i2) {
        this.zza = i2 | this.zza;
    }

    public void zzb() {
        this.zza = 0;
    }

    public final void zzc(int i2) {
        this.zza = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean zzd(int i2) {
        return (this.zza & i2) == i2;
    }

    public final boolean zze() {
        return zzd(268435456);
    }

    public final boolean zzf() {
        return zzd(Integer.MIN_VALUE);
    }

    public final boolean zzg() {
        return zzd(4);
    }

    public final boolean zzh() {
        return zzd(1);
    }

    public final boolean zzi() {
        return zzd(536870912);
    }
}
