package com.google.android.gms.internal.ads;

final class zzfmt extends zzfnm {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfmt() {
    }

    public final zzfnm zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfnm zzb(int i2) {
        this.zza = i2;
        this.zzc = 1;
        return this;
    }

    public final zzfnn zzc() {
        if (this.zzc == 1) {
            return new zzfmv(this.zza, this.zzb, (zzfmu) null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
