package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

public final class zzaf {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzaf zza(int i2) {
        zzdy.zzf(!this.zzb);
        this.zza.append(i2, true);
        return this;
    }

    public final zzah zzb() {
        zzdy.zzf(!this.zzb);
        this.zzb = true;
        return new zzah(this.zza, (zzag) null);
    }
}
