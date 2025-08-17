package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzaim {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;
    private int zzf;

    public zzaim(int i2) {
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
        this.zzf = 0;
    }

    public final boolean zzc(int i2, int i3) {
        int i4 = this.zzf;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i2 == 179 || i2 == 181) {
                            this.zza -= i3;
                            this.zze = false;
                            return true;
                        }
                    } else if ((i2 & 240) != 32) {
                        zzer.zzf("H263Reader", "Unexpected start code value");
                        zzb();
                    } else {
                        this.zzb = this.zza;
                        this.zzf = 4;
                    }
                } else if (i2 > 31) {
                    zzer.zzf("H263Reader", "Unexpected start code value");
                    zzb();
                } else {
                    this.zzf = 3;
                }
            } else if (i2 != 181) {
                zzer.zzf("H263Reader", "Unexpected start code value");
                zzb();
            } else {
                this.zzf = 2;
            }
        } else if (i2 == 176) {
            this.zzf = 1;
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
