package com.google.android.gms.internal.ads;

public class zzdtx extends Exception {
    private final int zza;

    public zzdtx(int i2) {
        this.zza = i2;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdtx(int i2, String str) {
        super(str);
        this.zza = i2;
    }

    public zzdtx(int i2, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
