package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

final class zzcea implements zzge {
    private final zzge zza;
    private final long zzb;
    private final zzge zzc;
    private long zzd;
    private Uri zze;

    zzcea(zzge zzge, int i2, zzge zzge2) {
        this.zza = zzge;
        this.zzb = (long) i2;
        this.zzc = zzge2;
    }

    public final int zza(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        long j2 = this.zzd;
        long j3 = this.zzb;
        if (j2 < j3) {
            int zza2 = this.zza.zza(bArr, i2, (int) Math.min((long) i3, j3 - j2));
            long j4 = this.zzd + ((long) zza2);
            this.zzd = j4;
            i4 = zza2;
            j2 = j4;
        } else {
            i4 = 0;
        }
        if (j2 < this.zzb) {
            return i4;
        }
        int zza3 = this.zzc.zza(bArr, i2 + i4, i3 - i4);
        int i5 = i4 + zza3;
        this.zzd += (long) zza3;
        return i5;
    }

    public final long zzb(zzgj zzgj) throws IOException {
        zzgj zzgj2;
        long j2;
        long j3;
        long j4;
        zzgj zzgj3 = zzgj;
        this.zze = zzgj3.zza;
        long j5 = zzgj3.zzf;
        long j6 = this.zzb;
        zzgj zzgj4 = null;
        if (j5 >= j6) {
            zzgj2 = null;
        } else {
            long j7 = zzgj3.zzg;
            if (j7 != -1) {
                j4 = Math.min(j7, j6 - j5);
            } else {
                j4 = j6 - j5;
            }
            zzgj2 = new zzgj(zzgj3.zza, (byte[]) null, j5, j5, j4, (String) null, 0);
        }
        long j8 = zzgj3.zzg;
        if (j8 == -1 || zzgj3.zzf + j8 > this.zzb) {
            long max = Math.max(this.zzb, zzgj3.zzf);
            long j9 = zzgj3.zzg;
            if (j9 != -1) {
                j3 = Math.min(j9, (zzgj3.zzf + j9) - this.zzb);
            } else {
                j3 = -1;
            }
            zzgj4 = new zzgj(zzgj3.zza, (byte[]) null, max, max, j3, (String) null, 0);
        }
        long j10 = 0;
        if (zzgj2 != null) {
            j2 = this.zza.zzb(zzgj2);
        } else {
            j2 = 0;
        }
        if (zzgj4 != null) {
            j10 = this.zzc.zzb(zzgj4);
        }
        this.zzd = zzgj3.zzf;
        if (j2 == -1 || j10 == -1) {
            return -1;
        }
        return j2 + j10;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    public final Map zze() {
        return zzfsf.zzd();
    }

    public final void zzf(zzhg zzhg) {
    }
}
