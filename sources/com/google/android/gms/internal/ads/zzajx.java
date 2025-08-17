package com.google.android.gms.internal.ads;

public final class zzajx {
    public static int zza(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static long zzb(zzfa zzfa, int i2, int i3) {
        zzfa.zzF(i2);
        if (zzfa.zza() < 5) {
            return -9223372036854775807L;
        }
        int zze = zzfa.zze();
        if ((8388608 & zze) != 0 || ((zze >> 8) & 8191) != i3 || (zze & 32) == 0 || zzfa.zzk() < 7 || zzfa.zza() < 7 || (zzfa.zzk() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzfa.zzB(bArr, 0, 6);
        long j2 = (long) bArr[4];
        long j3 = ((long) bArr[3]) & 255;
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | (j3 + j3) | ((j2 & 255) >> 7);
    }
}
