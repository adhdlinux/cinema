package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

final class zzdv extends zzdx {
    final /* synthetic */ zzee zza;
    private int zzb = 0;
    private final int zzc;

    zzdv(zzee zzee) {
        this.zza = zzee;
        this.zzc = zzee.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i2 = this.zzb;
        if (i2 < this.zzc) {
            this.zzb = i2 + 1;
            return this.zza.zzb(i2);
        }
        throw new NoSuchElementException();
    }
}
