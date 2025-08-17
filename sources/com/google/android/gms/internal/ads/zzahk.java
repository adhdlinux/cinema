package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzahk extends zzahu {
    private zzabj zza;
    private zzahj zzb;

    zzahk() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfa zzfa) {
        if (!zzd(zzfa.zzH())) {
            return -1;
        }
        int i2 = (zzfa.zzH()[2] & 255) >> 4;
        if (i2 != 6) {
            if (i2 == 7) {
                i2 = 7;
            }
            int zza2 = zzabf.zza(zzfa, i2);
            zzfa.zzF(0);
            return (long) zza2;
        }
        zzfa.zzG(4);
        zzfa.zzu();
        int zza22 = zzabf.zza(zzfa, i2);
        zzfa.zzF(0);
        return (long) zza22;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z2) {
        super.zzb(z2);
        if (z2) {
            this.zza = null;
            this.zzb = null;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfa zzfa, long j2, zzahr zzahr) {
        byte[] zzH = zzfa.zzH();
        zzabj zzabj = this.zza;
        if (zzabj == null) {
            zzabj zzabj2 = new zzabj(zzH, 17);
            this.zza = zzabj2;
            zzahr.zza = zzabj2.zzc(Arrays.copyOfRange(zzH, 9, zzfa.zzd()), (zzbz) null);
            return true;
        } else if ((zzH[0] & Byte.MAX_VALUE) == 3) {
            zzabi zzb2 = zzabg.zzb(zzfa);
            zzabj zzf = zzabj.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzahj(zzf, zzb2);
            return true;
        } else if (!zzd(zzH)) {
            return true;
        } else {
            zzahj zzahj = this.zzb;
            if (zzahj != null) {
                zzahj.zza(j2);
                zzahr.zzb = this.zzb;
            }
            zzahr.zza.getClass();
            return false;
        }
    }
}
