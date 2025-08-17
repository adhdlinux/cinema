package com.google.android.exoplayer2.audio;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

public final class Ac4Util {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f23649a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    public static final class SyncFrameInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f23650a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23651b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23652c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23653d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23654e;

        private SyncFrameInfo(int i2, int i3, int i4, int i5, int i6) {
            this.f23650a = i2;
            this.f23652c = i3;
            this.f23651b = i4;
            this.f23653d = i5;
            this.f23654e = i6;
        }
    }

    private Ac4Util() {
    }

    public static void a(int i2, ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(7);
        byte[] e2 = parsableByteArray.e();
        e2[0] = -84;
        e2[1] = 64;
        e2[2] = -1;
        e2[3] = -1;
        e2[4] = (byte) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
        e2[5] = (byte) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        e2[6] = (byte) (i2 & JfifUtil.MARKER_FIRST_BYTE);
    }

    public static Format b(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i2;
        parsableByteArray.V(1);
        if (((parsableByteArray.H() & 32) >> 5) == 1) {
            i2 = 48000;
        } else {
            i2 = 44100;
        }
        return new Format.Builder().U(str).g0("audio/ac4").J(2).h0(i2).O(drmInitData).X(str2).G();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new ParsableBitArray(bArr)).f23654e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r11 != 11) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r11 != 11) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008e, code lost:
        if (r11 != 8) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo d(com.google.android.exoplayer2.util.ParsableBitArray r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = 4
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L_0x002f
            int r4 = f(r11, r0)
            int r1 = r1 + r4
        L_0x002f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L_0x0045
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L_0x0045
            r11.r(r0)
        L_0x0045:
            boolean r4 = r11.g()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r7 = 44100(0xac44, float:6.1797E-41)
            if (r4 == 0) goto L_0x0055
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0058
        L_0x0055:
            r9 = 44100(0xac44, float:6.1797E-41)
        L_0x0058:
            int r11 = r11.h(r3)
            if (r9 != r7) goto L_0x0067
            r4 = 13
            if (r11 != r4) goto L_0x0067
            int[] r0 = f23649a
            r11 = r0[r11]
            goto L_0x0097
        L_0x0067:
            if (r9 != r6) goto L_0x0096
            int[] r4 = f23649a
            int r6 = r4.length
            if (r11 >= r6) goto L_0x0096
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L_0x008c
            r7 = 11
            if (r1 == r0) goto L_0x0087
            if (r1 == r2) goto L_0x008c
            if (r1 == r3) goto L_0x0080
            goto L_0x0091
        L_0x0080:
            if (r11 == r2) goto L_0x0093
            if (r11 == r6) goto L_0x0093
            if (r11 != r7) goto L_0x0091
            goto L_0x0093
        L_0x0087:
            if (r11 == r6) goto L_0x0093
            if (r11 != r7) goto L_0x0091
            goto L_0x0093
        L_0x008c:
            if (r11 == r2) goto L_0x0093
            if (r11 != r6) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r11 = r4
            goto L_0x0097
        L_0x0093:
            int r4 = r4 + 1
            goto L_0x0091
        L_0x0096:
            r11 = 0
        L_0x0097:
            com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo r0 = new com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.Ac4Util.d(com.google.android.exoplayer2.util.ParsableBitArray):com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo");
    }

    public static int e(byte[] bArr, int i2) {
        int i3 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        byte b2 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (b2 == 65535) {
            b2 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i3 = 4;
        }
        if (i2 == 44097) {
            i3 += 2;
        }
        return b2 + i3;
    }

    private static int f(ParsableBitArray parsableBitArray, int i2) {
        int i3 = 0;
        while (true) {
            int h2 = i3 + parsableBitArray.h(i2);
            if (!parsableBitArray.g()) {
                return h2;
            }
            i3 = (h2 + 1) << i2;
        }
    }
}
