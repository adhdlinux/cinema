package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzaik {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;

    public zzaik(int i2) {
    }

    public final void zza(byte[] bArr, int i2, int i3) {
        if (this.zze) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i5 = this.zza + i4;
            if (length < i5) {
                this.zzc = Arrays.copyOf(bArr2, i5 + i5);
            }
            System.arraycopy(bArr, i2, this.zzc, this.zza, i4);
            this.zza += i4;
        }
    }

    public final void zzb() {
        this.zze = false;
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzc(int i2, int i3) {
        if (this.zze) {
            int i4 = this.zza - i3;
            this.zza = i4;
            if (this.zzb == 0 && i2 == 181) {
                this.zzb = i4;
            } else {
                this.zze = false;
                return true;
            }
        } else if (i2 == 179) {
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
