package com.google.android.gms.internal.ads;

public final class zzdgx {
    private zzbeo zza;

    public zzdgx(zzdgj zzdgj) {
        this.zza = zzdgj;
    }

    public final synchronized zzbeo zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbeo zzbeo) {
        this.zza = zzbeo;
    }
}
