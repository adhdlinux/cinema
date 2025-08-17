package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;

final class zzaho {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[JfifUtil.MARKER_FIRST_BYTE];
    private final zzfa zzg = new zzfa((int) JfifUtil.MARKER_FIRST_BYTE);

    zzaho() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzaax zzaax, boolean z2) throws IOException {
        zza();
        this.zzg.zzC(27);
        if (zzaba.zzc(zzaax, this.zzg.zzH(), 0, 27, z2) && this.zzg.zzs() == 1332176723) {
            if (this.zzg.zzk() == 0) {
                this.zza = this.zzg.zzk();
                this.zzb = this.zzg.zzp();
                this.zzg.zzq();
                this.zzg.zzq();
                this.zzg.zzq();
                int zzk = this.zzg.zzk();
                this.zzc = zzk;
                this.zzd = zzk + 27;
                this.zzg.zzC(zzk);
                if (zzaba.zzc(zzaax, this.zzg.zzH(), 0, this.zzc, z2)) {
                    for (int i2 = 0; i2 < this.zzc; i2++) {
                        this.zzf[i2] = this.zzg.zzk();
                        this.zze += this.zzf[i2];
                    }
                    return true;
                }
            } else if (z2) {
                return false;
            } else {
                throw zzcd.zzc("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean zzc(zzaax zzaax, long j2) throws IOException {
        boolean z2;
        int i2;
        if (zzaax.zzf() == zzaax.zze()) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        this.zzg.zzC(4);
        while (true) {
            i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if ((i2 == 0 || zzaax.zzf() + 4 < j2) && zzaba.zzc(zzaax, this.zzg.zzH(), 0, 4, true)) {
                this.zzg.zzF(0);
                if (this.zzg.zzs() != 1332176723) {
                    ((zzaam) zzaax).zzo(1, false);
                } else {
                    zzaax.zzj();
                    return true;
                }
            }
        }
        do {
            if ((i2 != 0 && zzaax.zzf() >= j2) || zzaax.zzc(1) == -1) {
                return false;
            }
            break;
        } while (zzaax.zzc(1) == -1);
        return false;
    }
}
