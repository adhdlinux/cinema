package com.google.android.gms.internal.ads;

public final class zzfv {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public zzfv(byte[] bArr, int i2, int i3) {
        this.zza = bArr;
        this.zzc = i2;
        this.zzb = i3;
        zzh();
    }

    private final int zzg() {
        int i2 = 0;
        int i3 = 0;
        while (!zzf()) {
            i3++;
        }
        int i4 = 1 << i3;
        if (i3 > 0) {
            i2 = zza(i3);
        }
        return (i4 - 1) + i2;
    }

    private final void zzh() {
        int i2;
        int i3 = this.zzc;
        boolean z2 = false;
        if (i3 >= 0 && (i3 < (i2 = this.zzb) || (i3 == i2 && this.zzd == 0))) {
            z2 = true;
        }
        zzdy.zzf(z2);
    }

    private final boolean zzi(int i2) {
        if (i2 < 2 || i2 >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 + -1] == 0;
    }

    public final int zza(int i2) {
        int i3;
        int i4;
        this.zzd += i2;
        int i5 = 0;
        while (true) {
            i3 = this.zzd;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            int i6 = i3 - 8;
            this.zzd = i6;
            byte[] bArr = this.zza;
            int i7 = this.zzc;
            i5 |= (bArr[i7] & 255) << i6;
            if (true != zzi(i7 + 1)) {
                i4 = 1;
            }
            this.zzc = i7 + i4;
        }
        byte[] bArr2 = this.zza;
        int i8 = this.zzc;
        int i9 = i5 | ((bArr2[i8] & 255) >> (8 - i3));
        int i10 = 32 - i2;
        if (i3 == 8) {
            this.zzd = 0;
            if (true != zzi(i8 + 1)) {
                i4 = 1;
            }
            this.zzc = i8 + i4;
        }
        int i11 = (-1 >>> i10) & i9;
        zzh();
        return i11;
    }

    public final int zzb() {
        int zzg = zzg();
        int i2 = zzg % 2;
        int i3 = 1;
        int i4 = zzg + 1;
        if (i2 == 0) {
            i3 = -1;
        }
        return i3 * (i4 / 2);
    }

    public final int zzc() {
        return zzg();
    }

    public final void zzd() {
        int i2 = 1;
        int i3 = this.zzd + 1;
        this.zzd = i3;
        if (i3 == 8) {
            this.zzd = 0;
            int i4 = this.zzc;
            if (true == zzi(i4 + 1)) {
                i2 = 2;
            }
            this.zzc = i4 + i2;
        }
        zzh();
    }

    public final void zze(int i2) {
        int i3 = this.zzc;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.zzc = i5;
        int i6 = this.zzd + (i2 - (i4 * 8));
        this.zzd = i6;
        if (i6 > 7) {
            this.zzc = i5 + 1;
            this.zzd = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.zzc) {
                zzh();
                return;
            } else if (zzi(i3)) {
                this.zzc++;
                i3 += 2;
            }
        }
    }

    public final boolean zzf() {
        byte b2 = this.zza[this.zzc] & (128 >> this.zzd);
        zzd();
        if (b2 != 0) {
            return true;
        }
        return false;
    }
}
