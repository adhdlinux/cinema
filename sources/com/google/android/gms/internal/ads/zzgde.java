package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzgde {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        long zzb = zzb(bArr3, 0, 0);
        long zzb2 = zzb(bArr3, 3, 2) & 67108611;
        long zzb3 = zzb(bArr3, 6, 4) & 67092735;
        long zzb4 = zzb(bArr3, 9, 6) & 66076671;
        long zzb5 = zzb(bArr3, 12, 8) & 1048575;
        int i2 = 17;
        byte[] bArr5 = new byte[17];
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        int i3 = 0;
        while (true) {
            int length = bArr4.length;
            if (i3 < length) {
                int min = Math.min(16, length - i3);
                System.arraycopy(bArr4, i3, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i2, (byte) 0);
                }
                long j7 = zzb5 * 5;
                long j8 = zzb4 * 5;
                long j9 = zzb3 * 5;
                long zzb6 = j6 + zzb(bArr5, 0, 0);
                long zzb7 = j3 + zzb(bArr5, 3, 2);
                long zzb8 = j2 + zzb(bArr5, 6, 4);
                long zzb9 = j4 + zzb(bArr5, 9, 6);
                long zzb10 = j5 + (zzb(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
                long j10 = zzb7 * zzb;
                long j11 = zzb7 * zzb2;
                long j12 = zzb7 * zzb3;
                long j13 = zzb9 * zzb;
                long j14 = zzb7 * zzb4;
                long j15 = zzb10 * zzb;
                long j16 = (zzb6 * zzb) + (zzb7 * j7) + (zzb8 * j8) + (zzb9 * j9) + (zzb2 * 5 * zzb10);
                long j17 = (zzb6 * zzb2) + j10 + (zzb8 * j7) + (zzb9 * j8) + (j9 * zzb10) + (j16 >> 26);
                long j18 = (zzb6 * zzb3) + j11 + (zzb8 * zzb) + (zzb9 * j7) + (j8 * zzb10) + (j17 >> 26);
                long j19 = (zzb6 * zzb4) + j12 + (zzb8 * zzb2) + j13 + (zzb10 * j7) + (j18 >> 26);
                long j20 = (zzb6 * zzb5) + j14 + (zzb8 * zzb3) + (zzb9 * zzb2) + j15 + (j19 >> 26);
                long j21 = (j16 & 67108863) + ((j20 >> 26) * 5);
                j3 = (j17 & 67108863) + (j21 >> 26);
                i3 += 16;
                j2 = j18 & 67108863;
                j4 = j19 & 67108863;
                j5 = j20 & 67108863;
                i2 = 17;
                j6 = j21 & 67108863;
            } else {
                long j22 = j2 + (j3 >> 26);
                long j23 = j22 & 67108863;
                long j24 = j4 + (j22 >> 26);
                long j25 = j24 & 67108863;
                long j26 = j5 + (j24 >> 26);
                long j27 = j26 & 67108863;
                long j28 = j6 + ((j26 >> 26) * 5);
                long j29 = j28 & 67108863;
                long j30 = j29 + 5;
                long j31 = (j3 & 67108863) + (j28 >> 26);
                long j32 = j31 + (j30 >> 26);
                long j33 = (j32 >> 26) + j23;
                long j34 = j25 + (j33 >> 26);
                long j35 = (j27 + (j34 >> 26)) - 67108864;
                long j36 = j35 >> 63;
                long j37 = ~j36;
                long j38 = (j31 & j36) | (j32 & 67108863 & j37);
                long j39 = (j23 & j36) | (j33 & 67108863 & j37);
                long j40 = (j25 & j36) | (j34 & 67108863 & j37);
                long j41 = (j27 & j36) | (j35 & j37);
                long zzc = (((j36 & j29) | (j30 & 67108863 & j37) | (j38 << 26)) & 4294967295L) + zzc(bArr3, 16);
                long zzc2 = (((j38 >> 6) | (j39 << 20)) & 4294967295L) + zzc(bArr3, 20);
                long zzc3 = (((j39 >> 12) | (j40 << 14)) & 4294967295L) + zzc(bArr3, 24);
                long zzc4 = (((j40 >> 18) | (j41 << 8)) & 4294967295L) + zzc(bArr3, 28);
                byte[] bArr6 = new byte[16];
                zzd(bArr6, zzc & 4294967295L, 0);
                long j42 = zzc2 + (zzc >> 32);
                zzd(bArr6, j42 & 4294967295L, 4);
                long j43 = zzc3 + (j42 >> 32);
                zzd(bArr6, j43 & 4294967295L, 8);
                zzd(bArr6, (zzc4 + (j43 >> 32)) & 4294967295L, 12);
                return bArr6;
            }
        }
    }

    private static long zzb(byte[] bArr, int i2, int i3) {
        return (zzc(bArr, i2) >> i3) & 67108863;
    }

    private static long zzc(byte[] bArr, int i2) {
        int i3 = (bArr[i2 + 1] & 255) << 8;
        return ((long) (((bArr[i2 + 3] & 255) << 24) | i3 | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i2 + i3] = (byte) ((int) (255 & j2));
            j2 >>= 8;
        }
    }
}
