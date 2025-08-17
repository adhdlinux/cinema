package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

public final class zzacb {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzacb(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final int zza() {
        return (this.zzc * 8) + this.zzd;
    }

    public final int zzb(int i2) {
        int i3 = this.zzc;
        int i4 = i3 + 1;
        int min = Math.min(i2, 8 - this.zzd);
        int i5 = ((this.zza[i3] & 255) >> this.zzd) & (JfifUtil.MARKER_FIRST_BYTE >> (8 - min));
        while (min < i2) {
            i5 |= (this.zza[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        zzc(i2);
        return i6;
    }

    public final void zzc(int i2) {
        int i3;
        int i4 = i2 / 8;
        int i5 = this.zzc + i4;
        this.zzc = i5;
        int i6 = this.zzd + (i2 - (i4 * 8));
        this.zzd = i6;
        if (i6 > 7) {
            i5++;
            this.zzc = i5;
            i6 -= 8;
            this.zzd = i6;
        }
        boolean z2 = false;
        if (i5 >= 0 && (i5 < (i3 = this.zzb) || (i5 == i3 && i6 == 0))) {
            z2 = true;
        }
        zzdy.zzf(z2);
    }

    public final boolean zzd() {
        zzc(1);
        if (1 != (((this.zza[this.zzc] & 255) >> this.zzd) & 1)) {
            return false;
        }
        return true;
    }
}
