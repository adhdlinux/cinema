package com.google.android.gms.internal.ads;

final class zzfmw extends zzfnp {
    private String zza;
    private String zzb;

    zzfmw() {
    }

    public final zzfnp zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfnp zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzfnq zzc() {
        return new zzfmy(this.zza, this.zzb, (zzfmx) null);
    }
}
