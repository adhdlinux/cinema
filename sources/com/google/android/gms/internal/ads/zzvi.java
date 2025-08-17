package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

public final class zzvi {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzvi(int i2) {
        this(0, new Random());
    }

    public final int zza() {
        int[] iArr = this.zzb;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final int zzb() {
        int[] iArr = this.zzb;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int zzc() {
        return this.zzb.length;
    }

    public final int zzd(int i2) {
        int i3 = this.zzc[i2] + 1;
        int[] iArr = this.zzb;
        if (i3 < iArr.length) {
            return iArr[i3];
        }
        return -1;
    }

    public final int zze(int i2) {
        int i3 = this.zzc[i2] - 1;
        if (i3 >= 0) {
            return this.zzb[i3];
        }
        return -1;
    }

    public final zzvi zzf() {
        return new zzvi(0, new Random(this.zza.nextLong()));
    }

    public final zzvi zzg(int i2, int i3) {
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            iArr[i5] = this.zza.nextInt(this.zzb.length + 1);
            int i6 = i5 + 1;
            int nextInt = this.zza.nextInt(i6);
            iArr2[i5] = iArr2[nextInt];
            iArr2[nextInt] = i5;
            i5 = i6;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[(this.zzb.length + i3)];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr4 = this.zzb;
            if (i4 >= iArr4.length + i3) {
                return new zzvi(iArr3, new Random(this.zza.nextLong()));
            }
            if (i7 >= i3 || i8 != iArr[i7]) {
                int i9 = i8 + 1;
                int i10 = iArr4[i8];
                iArr3[i4] = i10;
                if (i10 >= 0) {
                    iArr3[i4] = i10 + i3;
                }
                i8 = i9;
            } else {
                iArr3[i4] = iArr2[i7];
                i7++;
            }
            i4++;
        }
    }

    public final zzvi zzh(int i2, int i3) {
        int[] iArr = new int[(this.zzb.length - i3)];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.zzb;
            if (i4 >= iArr2.length) {
                return new zzvi(iArr, new Random(this.zza.nextLong()));
            }
            int i6 = iArr2[i4];
            if (i6 < 0 || i6 >= i3) {
                int i7 = i4 - i5;
                if (i6 >= 0) {
                    i6 -= i3;
                }
                iArr[i7] = i6;
            } else {
                i5++;
            }
            i4++;
        }
    }

    private zzvi(int i2, Random random) {
        this(new int[0], random);
    }

    private zzvi(int[] iArr, Random random) {
        this.zzb = iArr;
        this.zza = random;
        this.zzc = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzc[iArr[i2]] = i2;
        }
    }
}
