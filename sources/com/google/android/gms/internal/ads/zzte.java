package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

final class zzte implements zzge {
    private final zzge zza;
    private final int zzb;
    private final zztd zzc;
    private final byte[] zzd;
    private int zze;

    public zzte(zzge zzge, int i2, zztd zztd) {
        zzdy.zzd(i2 > 0);
        this.zza = zzge;
        this.zzb = i2;
        this.zzc = zztd;
        this.zzd = new byte[1];
        this.zze = i2;
    }

    public final int zza(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.zze;
        if (i4 == 0) {
            int i5 = 0;
            if (this.zza.zza(this.zzd, 0, 1) != -1) {
                int i6 = (this.zzd[0] & 255) << 4;
                if (i6 != 0) {
                    byte[] bArr2 = new byte[i6];
                    int i7 = i6;
                    while (i7 > 0) {
                        int zza2 = this.zza.zza(bArr2, i5, i7);
                        if (zza2 != -1) {
                            i5 += zza2;
                            i7 -= zza2;
                        }
                    }
                    while (i6 > 0) {
                        int i8 = i6 - 1;
                        if (bArr2[i8] != 0) {
                            break;
                        }
                        i6 = i8;
                    }
                    if (i6 > 0) {
                        this.zzc.zza(new zzfa(bArr2, i6));
                    }
                }
                i4 = this.zzb;
                this.zze = i4;
            }
            return -1;
        }
        int zza3 = this.zza.zza(bArr, i2, Math.min(i4, i3));
        if (zza3 != -1) {
            this.zze -= zza3;
        }
        return zza3;
    }

    public final long zzb(zzgj zzgj) {
        throw new UnsupportedOperationException();
    }

    public final Uri zzc() {
        return this.zza.zzc();
    }

    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    public final Map zze() {
        return this.zza.zze();
    }

    public final void zzf(zzhg zzhg) {
        zzhg.getClass();
        this.zza.zzf(zzhg);
    }
}
