package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzafq {
    private final zzfa zza = new zzfa(8);
    private int zzb;

    private final long zzb(zzaax zzaax) throws IOException {
        zzaam zzaam = (zzaam) zzaax;
        int i2 = 0;
        zzaam.zzm(this.zza.zzH(), 0, 1, false);
        byte b2 = this.zza.zzH()[0] & 255;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((b2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = b2 & (~i3);
        zzaam.zzm(this.zza.zzH(), 1, i4, false);
        while (i2 < i4) {
            i2++;
            i5 = (this.zza.zzH()[i2] & 255) + (i5 << 8);
        }
        this.zzb += i4 + 1;
        return (long) i5;
    }

    public final boolean zza(zzaax zzaax) throws IOException {
        long zzb2;
        int i2;
        long zzd = zzaax.zzd();
        long j2 = 1024;
        int i3 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        if (i3 != 0 && zzd <= 1024) {
            j2 = zzd;
        }
        zzaam zzaam = (zzaam) zzaax;
        zzaam.zzm(this.zza.zzH(), 0, 4, false);
        long zzs = this.zza.zzs();
        this.zzb = 4;
        while (zzs != 440786851) {
            int i4 = (int) j2;
            int i5 = this.zzb + 1;
            this.zzb = i5;
            if (i5 == i4) {
                return false;
            }
            zzaam.zzm(this.zza.zzH(), 0, 1, false);
            zzs = ((zzs << 8) & -256) | ((long) (this.zza.zzH()[0] & 255));
        }
        long zzb3 = zzb(zzaax);
        long j3 = (long) this.zzb;
        if (zzb3 != Long.MIN_VALUE && (i3 == 0 || j3 + zzb3 < zzd)) {
            while (true) {
                int i6 = (((long) this.zzb) > (j3 + zzb3) ? 1 : (((long) this.zzb) == (j3 + zzb3) ? 0 : -1));
                if (i6 < 0) {
                    if (zzb(zzaax) == Long.MIN_VALUE || zzb2 < 0) {
                        return false;
                    }
                    if (i2 != 0) {
                        int zzb4 = (int) (zzb2 = zzb(zzaax));
                        zzaam.zzl(zzb4, false);
                        this.zzb += zzb4;
                    }
                } else if (i6 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
