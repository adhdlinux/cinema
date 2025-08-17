package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.protobuf.CodedOutputStream;

final class MpeghUtil {

    public static class MhasPacketHeader {

        /* renamed from: a  reason: collision with root package name */
        public int f9433a;

        /* renamed from: b  reason: collision with root package name */
        public long f9434b;

        /* renamed from: c  reason: collision with root package name */
        public int f9435c;
    }

    public static class Mpegh3daConfig {

        /* renamed from: a  reason: collision with root package name */
        public final int f9436a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9437b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9438c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f9439d;

        private Mpegh3daConfig(int i2, int i3, int i4, byte[] bArr) {
            this.f9436a = i2;
            this.f9437b = i3;
            this.f9438c = i4;
            this.f9439d = bArr;
        }
    }

    private MpeghUtil() {
    }

    private static int a(int i2) throws ParserException {
        if (i2 == 0) {
            return 768;
        }
        if (i2 == 1) {
            return 1024;
        }
        if (i2 == 2 || i2 == 3) {
            return 2048;
        }
        if (i2 == 4) {
            return CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
        throw ParserException.d("Unsupported coreSbrFrameLengthIndex " + i2);
    }

    private static double b(int i2) throws ParserException {
        switch (i2) {
            case 14700:
            case 16000:
                return 3.0d;
            case 22050:
            case 24000:
                return 2.0d;
            case 29400:
            case 32000:
            case 58800:
            case 64000:
                return 1.5d;
            case 44100:
            case 48000:
            case 88200:
            case 96000:
                return 1.0d;
            default:
                throw ParserException.d("Unsupported sampling rate " + i2);
        }
    }

    private static int c(int i2) throws ParserException {
        switch (i2) {
            case 0:
                return 96000;
            case 1:
                return 88200;
            case 2:
                return 64000;
            case 3:
                return 48000;
            case 4:
                return 44100;
            case 5:
                return 32000;
            case 6:
                return 24000;
            case 7:
                return 22050;
            case 8:
                return 16000;
            case 9:
                return 12000;
            case 10:
                return 11025;
            case 11:
                return 8000;
            case 12:
                return 7350;
            case 15:
                return 57600;
            case 16:
                return 51200;
            case 17:
                return 40000;
            case 18:
                return 38400;
            case 19:
                return 34150;
            case 20:
                return 28800;
            case 21:
                return 25600;
            case 22:
                return 20000;
            case 23:
                return 19200;
            case 24:
                return 17075;
            case 25:
                return 14400;
            case 26:
                return 12800;
            case 27:
                return 9600;
            default:
                throw ParserException.d("Unsupported sampling rate index " + i2);
        }
    }

    private static int d(int i2) throws ParserException {
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        int i3 = 2;
        if (i2 != 2) {
            i3 = 3;
            if (i2 != 3) {
                if (i2 == 4) {
                    return 1;
                }
                throw ParserException.d("Unsupported coreSbrFrameLengthIndex " + i2);
            }
        }
        return i3;
    }

    public static boolean e(int i2) {
        return (i2 & 16777215) == 12583333;
    }

    public static int f(ParsableBitArray parsableBitArray) {
        if (!parsableBitArray.g()) {
            return 0;
        }
        parsableBitArray.r(2);
        return parsableBitArray.h(13);
    }

    public static boolean g(ParsableBitArray parsableBitArray, MhasPacketHeader mhasPacketHeader) throws ParserException {
        parsableBitArray.d();
        int k2 = k(parsableBitArray, 3, 8, 8);
        mhasPacketHeader.f9433a = k2;
        if (k2 == -1) {
            return false;
        }
        long l2 = l(parsableBitArray, 2, 8, 32);
        mhasPacketHeader.f9434b = l2;
        if (l2 == -1) {
            return false;
        }
        if (l2 <= 16) {
            if (l2 == 0) {
                int i2 = mhasPacketHeader.f9433a;
                if (i2 == 1) {
                    throw ParserException.a("Mpegh3daConfig packet with invalid packet label 0", (Throwable) null);
                } else if (i2 == 2) {
                    throw ParserException.a("Mpegh3daFrame packet with invalid packet label 0", (Throwable) null);
                } else if (i2 == 17) {
                    throw ParserException.a("AudioTruncation packet with invalid packet label 0", (Throwable) null);
                }
            }
            int k3 = k(parsableBitArray, 11, 24, 24);
            mhasPacketHeader.f9435c = k3;
            if (k3 != -1) {
                return true;
            }
            return false;
        }
        throw ParserException.d("Contains sub-stream with an invalid packet label " + mhasPacketHeader.f9434b);
    }

    public static Mpegh3daConfig h(ParsableBitArray parsableBitArray) throws ParserException {
        int i2;
        int h2 = parsableBitArray.h(8);
        int h3 = parsableBitArray.h(5);
        if (h3 == 31) {
            i2 = parsableBitArray.h(24);
        } else {
            i2 = c(h3);
        }
        int h4 = parsableBitArray.h(3);
        int a2 = a(h4);
        int d2 = d(h4);
        parsableBitArray.r(2);
        p(parsableBitArray);
        m(parsableBitArray, j(parsableBitArray), d2);
        byte[] bArr = null;
        if (parsableBitArray.g()) {
            int k2 = k(parsableBitArray, 2, 4, 8) + 1;
            for (int i3 = 0; i3 < k2; i3++) {
                int k3 = k(parsableBitArray, 4, 8, 16);
                int k4 = k(parsableBitArray, 4, 8, 16);
                if (k3 == 7) {
                    int h5 = parsableBitArray.h(4) + 1;
                    parsableBitArray.r(4);
                    byte[] bArr2 = new byte[h5];
                    for (int i4 = 0; i4 < h5; i4++) {
                        bArr2[i4] = (byte) parsableBitArray.h(8);
                    }
                    bArr = bArr2;
                } else {
                    parsableBitArray.r(k4 * 8);
                }
            }
        }
        byte[] bArr3 = bArr;
        double b2 = b(i2);
        return new Mpegh3daConfig(h2, (int) (((double) i2) * b2), (int) (((double) a2) * b2), bArr3);
    }

    private static boolean i(ParsableBitArray parsableBitArray) {
        parsableBitArray.r(3);
        boolean g2 = parsableBitArray.g();
        if (g2) {
            parsableBitArray.r(13);
        }
        return g2;
    }

    private static int j(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(5);
        int i2 = 0;
        for (int i3 = 0; i3 < h2 + 1; i3++) {
            int h3 = parsableBitArray.h(3);
            i2 += k(parsableBitArray, 5, 8, 16) + 1;
            if ((h3 == 0 || h3 == 2) && parsableBitArray.g()) {
                p(parsableBitArray);
            }
        }
        return i2;
    }

    private static int k(ParsableBitArray parsableBitArray, int i2, int i3, int i4) {
        boolean z2;
        if (Math.max(Math.max(i2, i3), i4) <= 31) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        int i5 = (1 << i2) - 1;
        int i6 = (1 << i3) - 1;
        IntMath.a(IntMath.a(i5, i6), 1 << i4);
        if (parsableBitArray.b() < i2) {
            return -1;
        }
        int h2 = parsableBitArray.h(i2);
        if (h2 != i5) {
            return h2;
        }
        if (parsableBitArray.b() < i3) {
            return -1;
        }
        int h3 = parsableBitArray.h(i3);
        int i7 = h2 + h3;
        if (h3 != i6) {
            return i7;
        }
        if (parsableBitArray.b() < i4) {
            return -1;
        }
        return i7 + parsableBitArray.h(i4);
    }

    private static long l(ParsableBitArray parsableBitArray, int i2, int i3, int i4) {
        boolean z2;
        if (Math.max(Math.max(i2, i3), i4) <= 63) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        long j2 = (1 << i2) - 1;
        long j3 = (1 << i3) - 1;
        LongMath.a(LongMath.a(j2, j3), 1 << i4);
        if (parsableBitArray.b() < i2) {
            return -1;
        }
        long j4 = parsableBitArray.j(i2);
        if (j4 != j2) {
            return j4;
        }
        if (parsableBitArray.b() < i3) {
            return -1;
        }
        long j5 = parsableBitArray.j(i3);
        long j6 = j4 + j5;
        if (j5 != j3) {
            return j6;
        }
        if (parsableBitArray.b() < i4) {
            return -1;
        }
        return j6 + parsableBitArray.j(i4);
    }

    private static void m(ParsableBitArray parsableBitArray, int i2, int i3) {
        int i4;
        int k2 = k(parsableBitArray, 4, 8, 16) + 1;
        parsableBitArray.q();
        for (int i5 = 0; i5 < k2; i5++) {
            int h2 = parsableBitArray.h(2);
            if (h2 == 0) {
                i(parsableBitArray);
                if (i3 > 0) {
                    o(parsableBitArray);
                }
            } else if (h2 == 1) {
                if (i(parsableBitArray)) {
                    parsableBitArray.q();
                }
                if (i3 > 0) {
                    o(parsableBitArray);
                    i4 = parsableBitArray.h(2);
                } else {
                    i4 = 0;
                }
                if (i4 > 0) {
                    parsableBitArray.r(6);
                    int h3 = parsableBitArray.h(2);
                    parsableBitArray.r(4);
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(5);
                    }
                    if (i4 == 2 || i4 == 3) {
                        parsableBitArray.r(6);
                    }
                    if (h3 == 2) {
                        parsableBitArray.q();
                    }
                }
                int floor = ((int) Math.floor(Math.log((double) (i2 - 1)) / Math.log(2.0d))) + 1;
                int h4 = parsableBitArray.h(2);
                if (h4 > 0 && parsableBitArray.g()) {
                    parsableBitArray.r(floor);
                }
                if (parsableBitArray.g()) {
                    parsableBitArray.r(floor);
                }
                if (i3 == 0 && h4 == 0) {
                    parsableBitArray.q();
                }
            } else if (h2 == 3) {
                k(parsableBitArray, 4, 8, 16);
                int k3 = k(parsableBitArray, 4, 8, 16);
                if (parsableBitArray.g()) {
                    k(parsableBitArray, 8, 16, 0);
                }
                parsableBitArray.q();
                if (k3 > 0) {
                    parsableBitArray.r(k3 * 8);
                }
            }
        }
    }

    private static void n(ParsableBitArray parsableBitArray, int i2) {
        int i3;
        int i4;
        int i5;
        boolean g2 = parsableBitArray.g();
        int i6 = 5;
        if (g2) {
            i3 = 1;
        } else {
            i3 = 5;
        }
        if (g2) {
            i6 = 7;
        }
        if (g2) {
            i4 = 8;
        } else {
            i4 = 6;
        }
        int i7 = 0;
        while (i7 < i2) {
            if (parsableBitArray.g()) {
                parsableBitArray.r(7);
                i5 = 0;
            } else {
                if (parsableBitArray.h(2) == 3 && parsableBitArray.h(i6) * i3 != 0) {
                    parsableBitArray.q();
                }
                i5 = parsableBitArray.h(i4) * i3;
                if (!(i5 == 0 || i5 == 180)) {
                    parsableBitArray.q();
                }
                parsableBitArray.q();
            }
            if (!(i5 == 0 || i5 == 180 || !parsableBitArray.g())) {
                i7++;
            }
            i7++;
        }
    }

    private static void o(ParsableBitArray parsableBitArray) {
        parsableBitArray.r(3);
        parsableBitArray.r(8);
        boolean g2 = parsableBitArray.g();
        boolean g3 = parsableBitArray.g();
        if (g2) {
            parsableBitArray.r(5);
        }
        if (g3) {
            parsableBitArray.r(6);
        }
    }

    private static void p(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(2);
        if (h2 == 0) {
            parsableBitArray.r(6);
            return;
        }
        int k2 = k(parsableBitArray, 5, 8, 16) + 1;
        if (h2 == 1) {
            parsableBitArray.r(k2 * 7);
        } else if (h2 == 2) {
            n(parsableBitArray, k2);
        }
    }
}
