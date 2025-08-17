package com.google.android.gms.internal.ads;

import android.util.SparseArray;

public final class zzlu {
    private final zzah zza;
    private final SparseArray zzb;

    public zzlu(zzah zzah, SparseArray sparseArray) {
        this.zza = zzah;
        SparseArray sparseArray2 = new SparseArray(zzah.zzb());
        for (int i2 = 0; i2 < zzah.zzb(); i2++) {
            int zza2 = zzah.zza(i2);
            zzlt zzlt = (zzlt) sparseArray.get(zza2);
            zzlt.getClass();
            sparseArray2.append(zza2, zzlt);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i2) {
        return this.zza.zza(i2);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzlt zzc(int i2) {
        zzlt zzlt = (zzlt) this.zzb.get(i2);
        zzlt.getClass();
        return zzlt;
    }

    public final boolean zzd(int i2) {
        return this.zza.zzc(i2);
    }
}
