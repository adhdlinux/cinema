package com.google.android.gms.internal.ads;

final class zzgsr {
    static /* bridge */ /* synthetic */ void zza(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
        if (zzg(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || zzg(b4) || zzg(b5)) {
            throw zzgpy.zzd();
        }
        byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i2] = (char) ((b6 >>> 10) + 55232);
        cArr[i2 + 1] = (char) ((b6 & 1023) + 56320);
    }

    static /* bridge */ /* synthetic */ void zzb(byte b2, byte b3, byte b4, char[] cArr, int i2) {
        if (!zzg(b3)) {
            if (b2 == -32) {
                if (b3 >= -96) {
                    b2 = -32;
                }
            }
            if (b2 == -19) {
                if (b3 < -96) {
                    b2 = -19;
                }
            }
            if (!zzg(b4)) {
                cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
                return;
            }
        }
        throw zzgpy.zzd();
    }

    static /* bridge */ /* synthetic */ void zzc(byte b2, byte b3, char[] cArr, int i2) {
        if (b2 < -62 || zzg(b3)) {
            throw zzgpy.zzd();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    static /* bridge */ /* synthetic */ boolean zzd(byte b2) {
        return b2 >= 0;
    }

    static /* bridge */ /* synthetic */ boolean zze(byte b2) {
        return b2 < -16;
    }

    static /* bridge */ /* synthetic */ boolean zzf(byte b2) {
        return b2 < -32;
    }

    private static boolean zzg(byte b2) {
        return b2 > -65;
    }
}
