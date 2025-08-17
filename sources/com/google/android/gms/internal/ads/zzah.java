package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

public final class zzah {
    private final SparseBooleanArray zza;

    /* synthetic */ zzah(SparseBooleanArray sparseBooleanArray, zzag zzag) {
        this.zza = sparseBooleanArray;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzah = (zzah) obj;
        if (zzfj.zza >= 24) {
            return this.zza.equals(zzah.zza);
        }
        if (this.zza.size() != zzah.zza.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            if (zza(i2) != zzah.zza(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (zzfj.zza >= 24) {
            return this.zza.hashCode();
        }
        int size = this.zza.size();
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            size = (size * 31) + zza(i2);
        }
        return size;
    }

    public final int zza(int i2) {
        zzdy.zza(i2, 0, this.zza.size());
        return this.zza.keyAt(i2);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i2) {
        return this.zza.get(i2);
    }
}
