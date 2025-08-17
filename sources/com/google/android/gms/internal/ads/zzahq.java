package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class zzahq extends zzahu {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzahq() {
    }

    public static boolean zzd(zzfa zzfa) {
        return zzk(zzfa, zza);
    }

    private static boolean zzk(zzfa zzfa, byte[] bArr) {
        if (zzfa.zza() < 8) {
            return false;
        }
        int zzc2 = zzfa.zzc();
        byte[] bArr2 = new byte[8];
        zzfa.zzB(bArr2, 0, 8);
        zzfa.zzF(zzc2);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfa zzfa) {
        return zzg(zzabr.zzc(zzfa.zzH()));
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z2) {
        super.zzb(z2);
        if (z2) {
            this.zzc = false;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfa zzfa, long j2, zzahr zzahr) throws zzcd {
        if (zzk(zzfa, zza)) {
            byte[] copyOf = Arrays.copyOf(zzfa.zzH(), zzfa.zzd());
            byte b2 = copyOf[9] & 255;
            List zzd = zzabr.zzd(copyOf);
            if (zzahr.zza != null) {
                return true;
            }
            zzak zzak = new zzak();
            zzak.zzS("audio/opus");
            zzak.zzw(b2);
            zzak.zzT(48000);
            zzak.zzI(zzd);
            zzahr.zza = zzak.zzY();
            return true;
        } else if (zzk(zzfa, zzb)) {
            zzdy.zzb(zzahr.zza);
            if (this.zzc) {
                return true;
            }
            this.zzc = true;
            zzfa.zzG(8);
            zzbz zzb2 = zzacf.zzb(zzfsc.zzk(zzacf.zzc(zzfa, false, false).zzb));
            if (zzb2 == null) {
                return true;
            }
            zzak zzb3 = zzahr.zza.zzb();
            zzb3.zzM(zzb2.zzd(zzahr.zza.zzk));
            zzahr.zza = zzb3.zzY();
            return true;
        } else {
            zzdy.zzb(zzahr.zza);
            return false;
        }
    }
}
