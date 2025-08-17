package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.util.Arrays;

public final class zzaat {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, JfifUtil.MARKER_SOFn, 224, UserVerificationMethods.USER_VERIFY_HANDPRINT, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, CodedOutputStream.DEFAULT_BUFFER_SIZE, 6144, 7680};

    public static zzam zza(byte[] bArr, String str, String str2, zzad zzad) {
        zzez zzez;
        int i2 = 0;
        int i3 = -1;
        if (bArr[0] == Byte.MAX_VALUE) {
            zzez = new zzez(bArr, bArr.length);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b2 = copyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i4 = 0; i4 < copyOf.length - 1; i4 += 2) {
                    byte b3 = copyOf[i4];
                    int i5 = i4 + 1;
                    copyOf[i4] = copyOf[i5];
                    copyOf[i5] = b3;
                }
            }
            int length = copyOf.length;
            zzez = new zzez(copyOf, length);
            if (copyOf[0] == 31) {
                zzez zzez2 = new zzez(copyOf, length);
                while (zzez2.zza() >= 16) {
                    zzez2.zzl(2);
                    zzez.zzf(zzez2.zzd(14), 14);
                }
            }
            zzez.zzi(copyOf, copyOf.length);
        }
        zzez.zzl(60);
        int i6 = zzb[zzez.zzd(6)];
        int i7 = zzc[zzez.zzd(4)];
        int zzd2 = zzez.zzd(5);
        if (zzd2 < 29) {
            i3 = (zzd[zzd2] * 1000) / 2;
        }
        zzez.zzl(10);
        if (zzez.zzd(2) > 0) {
            i2 = 1;
        }
        int i8 = i6 + i2;
        zzak zzak = new zzak();
        zzak.zzH(str);
        zzak.zzS("audio/vnd.dts");
        zzak.zzv(i3);
        zzak.zzw(i8);
        zzak.zzT(i7);
        zzak.zzB((zzad) null);
        zzak.zzK(str2);
        return zzak.zzY();
    }
}
