package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzgnu extends zzgnw {
    final /* synthetic */ zzgoe zza;
    private int zzb = 0;
    private final int zzc;

    zzgnu(zzgoe zzgoe) {
        this.zza = zzgoe;
        this.zzc = zzgoe.zzd();
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
