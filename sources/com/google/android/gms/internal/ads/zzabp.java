package com.google.android.gms.internal.ads;

public final class zzabp {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final boolean zza(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!zzabq.zzm(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        this.zza = i3;
        this.zzb = zzabq.zza[3 - i4];
        int i9 = zzabq.zzb[i6];
        this.zzd = i9;
        int i10 = 2;
        if (i3 == 2) {
            i9 /= 2;
            this.zzd = i9;
        } else if (i3 == 0) {
            i9 /= 4;
            this.zzd = i9;
        }
        int i11 = (i2 >>> 9) & 1;
        this.zzg = zzabq.zzl(i3, i4);
        if (i4 == 3) {
            if (i3 == 3) {
                i8 = zzabq.zzc[i5 - 1];
            } else {
                i8 = zzabq.zzd[i5 - 1];
            }
            this.zzf = i8;
            this.zzc = (((i8 * 12) / i9) + i11) * 4;
        } else {
            int i12 = 144;
            if (i3 == 3) {
                if (i4 == 2) {
                    i7 = zzabq.zze[i5 - 1];
                } else {
                    i7 = zzabq.zzf[i5 - 1];
                }
                this.zzf = i7;
                this.zzc = ((i7 * 144) / i9) + i11;
            } else {
                int i13 = zzabq.zzg[i5 - 1];
                this.zzf = i13;
                if (i4 == 1) {
                    i12 = 72;
                }
                this.zzc = ((i12 * i13) / i9) + i11;
            }
        }
        if (((i2 >> 6) & 3) == 3) {
            i10 = 1;
        }
        this.zze = i10;
        return true;
    }
}
