package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

final class zzrd extends zzrf {
    final /* synthetic */ zzrm zza;
    private int zzb = 0;
    private final int zzc;

    zzrd(zzrm zzrm) {
        this.zza = zzrm;
        this.zzc = zzrm.zzd();
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
