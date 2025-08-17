package com.google.android.gms.internal.auth;

import java.util.Arrays;

public final class zzgz {
    private static final zzgz zza = new zzgz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgz() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgz(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z2;
    }

    public static zzgz zza() {
        return zza;
    }

    static zzgz zzb(zzgz zzgz, zzgz zzgz2) {
        int i2 = zzgz.zzb + zzgz2.zzb;
        int[] copyOf = Arrays.copyOf(zzgz.zzc, i2);
        System.arraycopy(zzgz2.zzc, 0, copyOf, zzgz.zzb, zzgz2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgz.zzd, i2);
        System.arraycopy(zzgz2.zzd, 0, copyOf2, zzgz.zzb, zzgz2.zzb);
        return new zzgz(i2, copyOf, copyOf2, true);
    }

    static zzgz zzc() {
        return new zzgz(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgz = (zzgz) obj;
        int i2 = this.zzb;
        if (i2 == zzgz.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgz.zzc;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgz.zzd;
                    int i4 = this.zzb;
                    int i5 = 0;
                    while (i5 < i4) {
                        if (objArr[i5].equals(objArr2[i5])) {
                            i5++;
                        }
                    }
                    return true;
                } else if (iArr[i3] != iArr2[i3]) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.zzc;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void zzd() {
        this.zze = false;
    }

    /* access modifiers changed from: package-private */
    public final void zze(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzfy.zzb(sb, i2, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i2, Object obj) {
        int i3;
        if (this.zze) {
            int i4 = this.zzb;
            int[] iArr = this.zzc;
            if (i4 == iArr.length) {
                if (i4 < 4) {
                    i3 = 8;
                } else {
                    i3 = i4 >> 1;
                }
                int i5 = i4 + i3;
                this.zzc = Arrays.copyOf(iArr, i5);
                this.zzd = Arrays.copyOf(this.zzd, i5);
            }
            int[] iArr2 = this.zzc;
            int i6 = this.zzb;
            iArr2[i6] = i2;
            this.zzd[i6] = obj;
            this.zzb = i6 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
