package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zzvw implements zzxa {
    protected final zzcy zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzam[] zzd;
    private int zze;

    public zzvw(zzcy zzcy, int[] iArr, int i2) {
        boolean z2;
        int length = iArr.length;
        if (length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        zzcy.getClass();
        this.zza = zzcy;
        this.zzb = length;
        this.zzd = new zzam[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.zzd[i3] = zzcy.zzb(iArr[i3]);
        }
        Arrays.sort(this.zzd, zzvv.zza);
        this.zzc = new int[this.zzb];
        for (int i4 = 0; i4 < this.zzb; i4++) {
            this.zzc[i4] = zzcy.zza(this.zzd[i4]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzvw zzvw = (zzvw) obj;
            if (this.zza != zzvw.zza || !Arrays.equals(this.zzc, zzvw.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zze;
        if (i2 != 0) {
            return i2;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = identityHashCode;
        return identityHashCode;
    }

    public final int zza(int i2) {
        return this.zzc[0];
    }

    public final int zzb(int i2) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            if (this.zzc[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final int zzc() {
        return this.zzc.length;
    }

    public final zzam zzd(int i2) {
        return this.zzd[i2];
    }

    public final zzcy zze() {
        return this.zza;
    }
}
