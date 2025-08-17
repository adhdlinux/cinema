package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

final class zzahn {
    private final zzaho zza = new zzaho();
    private final zzfa zzb = new zzfa(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzahn() {
    }

    private final int zzf(int i2) {
        int i3;
        int i4 = 0;
        this.zzd = 0;
        do {
            int i5 = this.zzd;
            int i6 = i2 + i5;
            zzaho zzaho = this.zza;
            if (i6 >= zzaho.zzc) {
                break;
            }
            int[] iArr = zzaho.zzf;
            this.zzd = i5 + 1;
            i3 = iArr[i6];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public final zzfa zza() {
        return this.zzb;
    }

    public final zzaho zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzC(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfa zzfa = this.zzb;
        if (zzfa.zzH().length != 65025) {
            zzfa.zzD(Arrays.copyOf(zzfa.zzH(), Math.max(65025, zzfa.zzd())), this.zzb.zzd());
        }
    }

    public final boolean zze(zzaax zzaax) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzC(0);
        }
        while (true) {
            boolean z2 = true;
            if (this.zze) {
                return true;
            }
            int i2 = this.zzc;
            if (i2 < 0) {
                if (!this.zza.zzc(zzaax, -1) || !this.zza.zzb(zzaax, true)) {
                    return false;
                }
                zzaho zzaho = this.zza;
                int i3 = zzaho.zzd;
                if ((zzaho.zza & 1) == 1 && this.zzb.zzd() == 0) {
                    i3 += zzf(0);
                    i2 = this.zzd;
                } else {
                    i2 = 0;
                }
                if (!zzaba.zze(zzaax, i3)) {
                    return false;
                }
                this.zzc = i2;
            }
            int zzf = zzf(i2);
            int i4 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzfa zzfa = this.zzb;
                zzfa.zzz(zzfa.zzd() + zzf);
                zzfa zzfa2 = this.zzb;
                if (!zzaba.zzd(zzaax, zzfa2.zzH(), zzfa2.zzd(), zzf)) {
                    return false;
                }
                zzfa zzfa3 = this.zzb;
                zzfa3.zzE(zzfa3.zzd() + zzf);
                if (this.zza.zzf[i4 - 1] == 255) {
                    z2 = false;
                }
                this.zze = z2;
            }
            if (i4 == this.zza.zzc) {
                i4 = -1;
            }
            this.zzc = i4;
        }
        return false;
    }
}
