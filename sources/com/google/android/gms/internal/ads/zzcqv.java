package com.google.android.gms.internal.ads;

public final class zzcqv {
    private final zzcxv zza;
    private final zzdac zzb;

    public zzcqv(zzcxv zzcxv, zzdac zzdac) {
        this.zza = zzcxv;
        this.zzb = zzdac;
    }

    public final zzcxv zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzdac zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzdcm zzc() {
        zzdac zzdac = this.zzb;
        if (zzdac != null) {
            return new zzdcm(zzdac, zzcae.zzf);
        }
        return new zzdcm(new zzcqu(this), zzcae.zzf);
    }
}
