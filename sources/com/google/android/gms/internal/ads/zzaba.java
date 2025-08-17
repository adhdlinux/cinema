package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

public final class zzaba {
    public static int zza(zzaax zzaax, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i3) {
            int zzb = zzaax.zzb(bArr, i2 + i4, i3 - i4);
            if (zzb == -1) {
                break;
            }
            i4 += zzb;
        }
        return i4;
    }

    @Pure
    public static void zzb(boolean z2, String str) throws zzcd {
        if (!z2) {
            throw zzcd.zza(str, (Throwable) null);
        }
    }

    public static boolean zzc(zzaax zzaax, byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        try {
            return zzaax.zzm(bArr, 0, i3, z2);
        } catch (EOFException e2) {
            if (z2) {
                return false;
            }
            throw e2;
        }
    }

    public static boolean zzd(zzaax zzaax, byte[] bArr, int i2, int i3) throws IOException {
        try {
            ((zzaam) zzaax).zzn(bArr, i2, i3, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzaax zzaax, int i2) throws IOException {
        try {
            ((zzaam) zzaax).zzo(i2, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
