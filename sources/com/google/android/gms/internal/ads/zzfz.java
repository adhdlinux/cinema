package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zzfz extends zzfy {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfz(byte[] bArr) {
        super(false);
        boolean z2 = false;
        zzdy.zzd(bArr.length > 0 ? true : z2);
        this.zza = bArr;
    }

    public final int zza(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.zzd;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(this.zza, this.zzc, bArr, i2, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzgj zzgj) throws IOException {
        this.zzb = zzgj.zza;
        zzi(zzgj);
        long j2 = zzgj.zzf;
        int length = this.zza.length;
        if (j2 <= ((long) length)) {
            int i2 = (int) j2;
            this.zzc = i2;
            int i3 = length - i2;
            this.zzd = i3;
            long j3 = zzgj.zzg;
            if (j3 != -1) {
                this.zzd = (int) Math.min((long) i3, j3);
            }
            this.zze = true;
            zzj(zzgj);
            long j4 = zzgj.zzg;
            if (j4 != -1) {
                return j4;
            }
            return (long) this.zzd;
        }
        throw new zzgf(2008);
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zzb = null;
    }
}
