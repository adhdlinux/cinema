package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

public final class zzabg {
    public static zzbz zza(zzaax zzaax, boolean z2) throws IOException {
        zzaek zzaek;
        if (z2) {
            zzaek = null;
        } else {
            zzaek = zzaem.zza;
        }
        zzbz zza = new zzabn().zza(zzaax, zzaek);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }

    public static zzabi zzb(zzfa zzfa) {
        zzfa.zzG(1);
        int zzm = zzfa.zzm();
        long zzc = (long) zzfa.zzc();
        long j2 = (long) zzm;
        int i2 = zzm / 18;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            long zzr = zzfa.zzr();
            if (zzr == -1) {
                jArr = Arrays.copyOf(jArr, i3);
                jArr2 = Arrays.copyOf(jArr2, i3);
                break;
            }
            jArr[i3] = zzr;
            jArr2[i3] = zzfa.zzr();
            zzfa.zzG(2);
            i3++;
        }
        zzfa.zzG((int) ((zzc + j2) - ((long) zzfa.zzc())));
        return new zzabi(jArr, jArr2);
    }
}
