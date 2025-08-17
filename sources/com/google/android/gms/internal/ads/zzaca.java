package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzaca {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzabz zzabz, zzaby zzaby) {
        if (this.zzc > 0) {
            zzabz.zzs(this.zzd, this.zze, this.zzf, this.zzg, zzaby);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzabz zzabz, long j2, int i2, int i3, int i4, zzaby zzaby) {
        if (this.zzg > i3 + i4) {
            throw new IllegalStateException("TrueHD chunk samples must be contiguous in the sample queue.");
        } else if (this.zzb) {
            int i5 = this.zzc;
            int i6 = i5 + 1;
            this.zzc = i6;
            if (i5 == 0) {
                this.zzd = j2;
                this.zze = i2;
                this.zzf = 0;
            }
            this.zzf += i3;
            this.zzg = i4;
            if (i6 >= 16) {
                zza(zzabz, zzaby);
            }
        }
    }

    public final void zzd(zzaax zzaax) throws IOException {
        if (!this.zzb) {
            zzaax.zzh(this.zza, 0, 10);
            zzaax.zzj();
            byte[] bArr = this.zza;
            int i2 = zzzx.zza;
            if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
                this.zzb = true;
            }
        }
    }
}
