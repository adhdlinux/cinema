package androidx.media3.extractor;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.Util;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public final class DtsUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f7998a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f7999b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f8000c = {64, 112, 128, JfifUtil.MARKER_SOFn, 224, UserVerificationMethods.USER_VERIFY_HANDPRINT, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, CodedOutputStream.DEFAULT_BUFFER_SIZE, 6144, 7680};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f8001d = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f8002e = {5, 8, 10, 12};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f8003f = {6, 9, 12, 15};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f8004g = {2, 4, 6, 8};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f8005h = {9, 11, 13, 16};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f8006i = {5, 8, 10, 12};

    public static final class DtsHeader {

        /* renamed from: a  reason: collision with root package name */
        public final String f8007a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8008b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8009c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8010d;

        /* renamed from: e  reason: collision with root package name */
        public final long f8011e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8012f;

        private DtsHeader(String str, int i2, int i3, int i4, long j2, int i5) {
            this.f8007a = str;
            this.f8009c = i2;
            this.f8008b = i3;
            this.f8010d = i4;
            this.f8011e = j2;
            this.f8012f = i5;
        }
    }

    private DtsUtil() {
    }

    private static void a(byte[] bArr, int i2) throws ParserException {
        int i3 = i2 - 2;
        if (((bArr[i2 - 1] & 255) | ((bArr[i3] << 8) & 65535)) != Util.v(bArr, 0, i3, 65535)) {
            throw ParserException.a("CRC check failed", (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(byte[] r7) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.DtsUtil.b(byte[]):int");
    }

    public static int c(int i2) {
        if (i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368) {
            return 1;
        }
        if (i2 == 1683496997 || i2 == 622876772) {
            return 2;
        }
        if (i2 == 1078008818 || i2 == -233094848) {
            return 3;
        }
        return (i2 == 1908687592 || i2 == -398277519) ? 4 : 0;
    }

    private static ParsableBitArray d(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 == Byte.MAX_VALUE || b2 == 100 || b2 == 64 || b2 == 113) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (e(copyOf)) {
            for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                byte b3 = copyOf[i2];
                int i3 = i2 + 1;
                copyOf[i2] = copyOf[i3];
                copyOf[i3] = b3;
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

    private static boolean e(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24;
    }

    public static int f(ByteBuffer byteBuffer) {
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
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

    public static int g(byte[] bArr) {
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

    public static Format h(byte[] bArr, String str, String str2, int i2, DrmInitData drmInitData) {
        int i3;
        int i4;
        ParsableBitArray d2 = d(bArr);
        d2.r(60);
        int i5 = f7998a[d2.h(6)];
        int i6 = f7999b[d2.h(4)];
        int h2 = d2.h(5);
        int[] iArr = f8000c;
        if (h2 >= iArr.length) {
            i3 = -1;
        } else {
            i3 = (iArr[h2] * 1000) / 2;
        }
        d2.r(10);
        if (d2.h(2) > 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        return new Format.Builder().a0(str).o0("audio/vnd.dts").M(i3).N(i5 + i4).p0(i6).U(drmInitData).e0(str2).m0(i2).K();
    }

    public static DtsHeader i(byte[] bArr) throws ParserException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2;
        int i7;
        ParsableBitArray d2 = d(bArr);
        d2.r(40);
        int h2 = d2.h(2);
        if (!d2.g()) {
            i3 = 16;
            i2 = 8;
        } else {
            i3 = 20;
            i2 = 12;
        }
        d2.r(i2);
        int h3 = d2.h(i3) + 1;
        boolean g2 = d2.g();
        int i8 = 0;
        if (g2) {
            i4 = d2.h(2);
            int h4 = (d2.h(3) + 1) * 512;
            if (d2.g()) {
                d2.r(36);
            }
            int h5 = d2.h(3) + 1;
            int h6 = d2.h(3) + 1;
            if (h5 == 1 && h6 == 1) {
                int i9 = h2 + 1;
                int h7 = d2.h(i9);
                for (int i10 = 0; i10 < i9; i10++) {
                    if (((h7 >> i10) & 1) == 1) {
                        d2.r(8);
                    }
                }
                if (d2.g()) {
                    d2.r(2);
                    int h8 = (d2.h(2) + 1) << 2;
                    int h9 = d2.h(2) + 1;
                    while (i8 < h9) {
                        d2.r(h8);
                        i8++;
                    }
                }
                i8 = h4;
            } else {
                throw ParserException.d("Multiple audio presentations or assets not supported");
            }
        } else {
            i4 = -1;
        }
        d2.r(i3);
        d2.r(12);
        if (g2) {
            if (d2.g()) {
                d2.r(4);
            }
            if (d2.g()) {
                d2.r(24);
            }
            if (d2.g()) {
                d2.s(d2.h(10) + 1);
            }
            d2.r(5);
            int i11 = f8001d[d2.h(4)];
            i6 = d2.h(8) + 1;
            i5 = i11;
        } else {
            i6 = -1;
            i5 = -2147483647;
        }
        if (g2) {
            if (i4 == 0) {
                i7 = 32000;
            } else if (i4 == 1) {
                i7 = 44100;
            } else if (i4 == 2) {
                i7 = 48000;
            } else {
                throw ParserException.a("Unsupported reference clock code in DTS HD header: " + i4, (Throwable) null);
            }
            j2 = Util.c1((long) i8, 1000000, (long) i7);
        } else {
            j2 = -9223372036854775807L;
        }
        return new DtsHeader("audio/vnd.dts.hd;profile=lbr", i6, i5, h3, j2, 0);
    }

    public static int j(byte[] bArr) {
        int i2;
        ParsableBitArray d2 = d(bArr);
        d2.r(42);
        if (d2.g()) {
            i2 = 12;
        } else {
            i2 = 8;
        }
        return d2.h(i2) + 1;
    }

    public static DtsHeader k(byte[] bArr, AtomicInteger atomicInteger) throws ParserException {
        int i2;
        long j2;
        int i3;
        int i4;
        int i5;
        ParsableBitArray d2 = d(bArr);
        int i6 = 0;
        if (d2.h(32) == 1078008818) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int m2 = m(d2, f8002e, true) + 1;
        if (i2 == 0) {
            j2 = -9223372036854775807L;
            i3 = -2147483647;
        } else if (d2.g()) {
            a(bArr, m2);
            int h2 = d2.h(2);
            if (h2 == 0) {
                i4 = 512;
            } else if (h2 == 1) {
                i4 = 480;
            } else if (h2 == 2) {
                i4 = BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
            } else {
                throw ParserException.a("Unsupported base duration index in DTS UHD header: " + h2, (Throwable) null);
            }
            int h3 = i4 * (d2.h(3) + 1);
            int h4 = d2.h(2);
            if (h4 == 0) {
                i5 = 32000;
            } else if (h4 == 1) {
                i5 = 44100;
            } else if (h4 == 2) {
                i5 = 48000;
            } else {
                throw ParserException.a("Unsupported clock rate index in DTS UHD header: " + h4, (Throwable) null);
            }
            if (d2.g()) {
                d2.r(36);
            }
            i3 = (1 << d2.h(2)) * i5;
            j2 = Util.c1((long) h3, 1000000, (long) i5);
        } else {
            throw ParserException.d("Only supports full channel mask-based audio presentation");
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            i7 += m(d2, f8003f, true);
        }
        if (i2 != 0) {
            atomicInteger.set(m(d2, f8004g, true));
        } else {
            AtomicInteger atomicInteger2 = atomicInteger;
        }
        if (atomicInteger.get() != 0) {
            i6 = m(d2, f8005h, true);
        }
        return new DtsHeader("audio/vnd.dts.uhd;profile=p2", 2, i3, m2 + i7 + i6, j2, 0);
    }

    public static int l(byte[] bArr) {
        ParsableBitArray d2 = d(bArr);
        d2.r(32);
        return m(d2, f8006i, true) + 1;
    }

    private static int m(ParsableBitArray parsableBitArray, int[] iArr, boolean z2) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 3 && parsableBitArray.g(); i4++) {
            i3++;
        }
        if (z2) {
            int i5 = 0;
            while (i2 < i3) {
                i5 += 1 << iArr[i2];
                i2++;
            }
            i2 = i5;
        }
        return i2 + parsableBitArray.h(iArr[i3]);
    }
}
