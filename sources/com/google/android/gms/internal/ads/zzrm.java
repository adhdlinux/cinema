package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzrm {
    private int zza = 0;
    private int zzb = -1;
    private int zzc = 0;
    private int[] zzd;
    private int zze;

    public zzrm() {
        int[] iArr = new int[16];
        this.zzd = iArr;
        this.zze = iArr.length - 1;
    }

    public final int zza() {
        int i2 = this.zzc;
        if (i2 != 0) {
            int[] iArr = this.zzd;
            int i3 = this.zza;
            int i4 = iArr[i3];
            this.zza = (i3 + 1) & this.zze;
            this.zzc = i2 - 1;
            return i4;
        }
        throw new NoSuchElementException();
    }

    public final void zzb(int i2) {
        int i3 = this.zzc;
        int[] iArr = this.zzd;
        int length = iArr.length;
        if (i3 == length) {
            int i4 = length + length;
            if (i4 >= 0) {
                int[] iArr2 = new int[i4];
                int i5 = this.zza;
                int i6 = length - i5;
                System.arraycopy(iArr, i5, iArr2, 0, i6);
                System.arraycopy(this.zzd, 0, iArr2, i6, i5);
                this.zza = 0;
                this.zzb = this.zzc - 1;
                this.zzd = iArr2;
                this.zze = iArr2.length - 1;
                iArr = iArr2;
            } else {
                throw new IllegalStateException();
            }
        }
        int i7 = (this.zzb + 1) & this.zze;
        this.zzb = i7;
        iArr[i7] = i2;
        this.zzc++;
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
    }

    public final boolean zzd() {
        return this.zzc == 0;
    }
}
