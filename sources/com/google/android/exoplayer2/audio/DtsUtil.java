package com.google.android.exoplayer2.audio;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class DtsUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f23825a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f23826b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f23827c = {64, 112, 128, JfifUtil.MARKER_SOFn, 224, UserVerificationMethods.USER_VERIFY_HANDPRINT, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, CodedOutputStream.DEFAULT_BUFFER_SIZE, 6144, 7680};

    private DtsUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(byte[] r7) {
        /*
            r0 = 0
            byte r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L_0x004a
            r2 = -1
            if (r1 == r2) goto L_0x0032
            r2 = 31
            if (r1 == r2) goto L_0x0021
            r1 = 5
            byte r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r4]
            goto L_0x0058
        L_0x0021:
            byte r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            byte r7 = r7[r1]
            goto L_0x0042
        L_0x0032:
            byte r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            byte r7 = r7[r1]
        L_0x0042:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L_0x005d
        L_0x004a:
            byte r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r3]
        L_0x0058:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L_0x005d:
            if (r0 == 0) goto L_0x0063
            int r7 = r7 * 16
            int r7 = r7 / 14
        L_0x0063:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DtsUtil.a(byte[]):int");
    }

    private static ParsableBitArray b(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(copyOf)) {
            for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                byte b2 = copyOf[i2];
                int i3 = i2 + 1;
                copyOf[i2] = copyOf[i3];
                copyOf[i3] = b2;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(copyOf);
            while (parsableBitArray2.b() >= 16) {
                parsableBitArray2.r(2);
                parsableBitArray.f(parsableBitArray2.h(14), 14);
            }
        }
        parsableBitArray.n(copyOf);
        return parsableBitArray;
    }

    private static boolean c(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1;
    }

    public static boolean d(int i2) {
        return i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368;
    }

    public static int e(ByteBuffer byteBuffer) {
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int position = byteBuffer.position();
        byte b5 = byteBuffer.get(position);
        if (b5 != -2) {
            if (b5 == -1) {
                i2 = (byteBuffer.get(position + 4) & 7) << 4;
                b4 = byteBuffer.get(position + 7);
            } else if (b5 != 31) {
                i3 = (byteBuffer.get(position + 4) & 1) << 6;
                b3 = byteBuffer.get(position + 5);
            } else {
                i2 = (byteBuffer.get(position + 5) & 7) << 4;
                b4 = byteBuffer.get(position + 6);
            }
            b2 = b4 & 60;
            return (((b2 >> 2) | i2) + 1) * 32;
        }
        i3 = (byteBuffer.get(position + 5) & 1) << 6;
        b3 = byteBuffer.get(position + 4);
        b2 = b3 & 252;
        return (((b2 >> 2) | i2) + 1) * 32;
    }

    public static int f(byte[] bArr) {
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        byte b5 = bArr[0];
        if (b5 != -2) {
            if (b5 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b4 = bArr[7];
            } else if (b5 != 31) {
                i3 = (bArr[4] & 1) << 6;
                b3 = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b4 = bArr[6];
            }
            b2 = b4 & 60;
            return (((b2 >> 2) | i2) + 1) * 32;
        }
        i3 = (bArr[5] & 1) << 6;
        b3 = bArr[4];
        b2 = b3 & 252;
        return (((b2 >> 2) | i2) + 1) * 32;
    }

    public static Format g(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i2;
        int i3;
        ParsableBitArray b2 = b(bArr);
        b2.r(60);
        int i4 = f23825a[b2.h(6)];
        int i5 = f23826b[b2.h(4)];
        int h2 = b2.h(5);
        int[] iArr = f23827c;
        if (h2 >= iArr.length) {
            i2 = -1;
        } else {
            i2 = (iArr[h2] * 1000) / 2;
        }
        b2.r(10);
        if (b2.h(2) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return new Format.Builder().U(str).g0("audio/vnd.dts").I(i2).J(i4 + i3).h0(i5).O(drmInitData).X(str2).G();
    }
}
