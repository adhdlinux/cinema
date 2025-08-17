package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzis extends zziu {
    final /* synthetic */ zzjb zza;
    private int zzb = 0;
    private final int zzc;

    zzis(zzjb zzjb) {
        this.zza = zzjb;
        this.zzc = zzjb.zzd();
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
