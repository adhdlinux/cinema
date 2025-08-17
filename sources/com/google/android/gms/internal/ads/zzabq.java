package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;

public final class zzabq {
    /* access modifiers changed from: private */
    public static final String[] zza = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    /* access modifiers changed from: private */
    public static final int[] zzb = {44100, 48000, 32000};
    /* access modifiers changed from: private */
    public static final int[] zzc = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    /* access modifiers changed from: private */
    public static final int[] zzd = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    /* access modifiers changed from: private */
    public static final int[] zze = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    /* access modifiers changed from: private */
    public static final int[] zzf = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    /* access modifiers changed from: private */
    public static final int[] zzg = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int zzb(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!zzm(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i9 = zzb[i6];
        if (i3 == 2) {
            i9 /= 2;
        } else if (i3 == 0) {
            i9 /= 4;
        }
        int i10 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            if (i3 == 3) {
                i8 = zzc[i5 - 1];
            } else {
                i8 = zzd[i5 - 1];
            }
            return (((i8 * 12) / i9) + i10) * 4;
        }
        if (i3 != 3) {
            i7 = zzg[i5 - 1];
        } else if (i4 == 2) {
            i7 = zze[i5 - 1];
        } else {
            i7 = zzf[i5 - 1];
        }
        int i11 = 144;
        if (i3 == 3) {
            return ((i7 * 144) / i9) + i10;
        }
        if (i4 == 1) {
            i11 = 72;
        }
        return ((i11 * i7) / i9) + i10;
    }

    public static int zzc(int i2) {
        int i3;
        int i4;
        if (!zzm(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0) {
            return -1;
        }
        int i5 = i2 >>> 12;
        int i6 = (i2 >>> 10) & 3;
        int i7 = i5 & 15;
        if (i7 == 0 || i7 == 15 || i6 == 3) {
            return -1;
        }
        return zzl(i3, i4);
    }

    /* access modifiers changed from: private */
    public static int zzl(int i2, int i3) {
        if (i3 == 1) {
            return i2 == 3 ? 1152 : 576;
        }
        if (i3 != 2) {
            return BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        }
        return 1152;
    }

    /* access modifiers changed from: private */
    public static boolean zzm(int i2) {
        return (i2 & -2097152) == -2097152;
    }
}
