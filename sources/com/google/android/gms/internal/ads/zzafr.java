package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzafr {
    private static final long[] zza = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzb(int i2) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = ((zza[i3] & ((long) i2)) > 0 ? 1 : ((zza[i3] & ((long) i2)) == 0 ? 0 : -1));
            i3++;
            if (i4 != 0) {
                return i3;
            }
        }
        return -1;
    }

    public static long zzc(byte[] bArr, int i2, boolean z2) {
        long j2 = ((long) bArr[0]) & 255;
        if (z2) {
            j2 &= ~zza[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzd(zzaax zzaax, boolean z2, boolean z3, int i2) throws IOException {
        if (this.zzc == 0) {
            if (!zzaax.zzn(this.zzb, 0, 1, z2)) {
                return -1;
            }
            int zzb2 = zzb(this.zzb[0] & 255);
            this.zzd = zzb2;
            if (zzb2 != -1) {
                this.zzc = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.zzd;
        if (i3 > i2) {
            this.zzc = 0;
            return -2;
        }
        if (i3 != 1) {
            ((zzaam) zzaax).zzn(this.zzb, 1, i3 - 1, false);
        }
        this.zzc = 0;
        return zzc(this.zzb, this.zzd, z3);
    }

    public final void zze() {
        this.zzc = 0;
        this.zzd = 0;
    }
}
