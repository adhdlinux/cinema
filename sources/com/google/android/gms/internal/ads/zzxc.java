package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzxc {
    private final String[] zza;
    private final int[] zzb;
    private final zzvn[] zzc;
    private final int[] zzd;
    private final int[][][] zze;
    private final zzvn zzf;

    zzxc(String[] strArr, int[] iArr, zzvn[] zzvnArr, int[] iArr2, int[][][] iArr3, zzvn zzvn) {
        this.zza = strArr;
        this.zzb = iArr;
        this.zzc = zzvnArr;
        this.zze = iArr3;
        this.zzd = iArr2;
        this.zzf = zzvn;
    }

    public final int zza(int i2, int i3, boolean z2) {
        int i4 = this.zzc[i2].zzb(i3).zzb;
        int[] iArr = new int[1];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 <= 0; i7++) {
            if ((this.zze[i2][i3][i7] & 7) == 4) {
                iArr[i6] = i7;
                i6++;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, i6);
        String str = null;
        boolean z3 = false;
        int i8 = 0;
        int i9 = 16;
        while (i5 < copyOf.length) {
            String str2 = this.zzc[i2].zzb(i3).zzb(copyOf[i5]).zzm;
            int i10 = i8 + 1;
            if (i8 == 0) {
                str = str2;
            } else {
                z3 |= !zzfj.zzC(str, str2);
            }
            i9 = Math.min(i9, this.zze[i2][i3][i5] & 24);
            i5++;
            i8 = i10;
        }
        if (z3) {
            return Math.min(i9, this.zzd[i2]);
        }
        return i9;
    }

    public final int zzb(int i2, int i3, int i4) {
        return this.zze[i2][i3][i4];
    }

    public final int zzc(int i2) {
        return this.zzb[i2];
    }

    public final zzvn zzd(int i2) {
        return this.zzc[i2];
    }

    public final zzvn zze() {
        return this.zzf;
    }
}
