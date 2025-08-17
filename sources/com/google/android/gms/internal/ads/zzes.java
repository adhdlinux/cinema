package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzes {
    private int zza;
    private long[] zzb;

    public zzes() {
        this(32);
    }

    public zzes(int i2) {
        this.zzb = new long[32];
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb(int i2) {
        if (i2 >= 0 && i2 < this.zza) {
            return this.zzb[i2];
        }
        int i3 = this.zza;
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + i3);
    }

    public final void zzc(long j2) {
        int i2 = this.zza;
        long[] jArr = this.zzb;
        if (i2 == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i2 + i2);
        }
        long[] jArr2 = this.zzb;
        int i3 = this.zza;
        this.zza = i3 + 1;
        jArr2[i3] = j2;
    }
}
