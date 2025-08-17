package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;

public final class AacUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f7893a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f7894b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public final int f7895a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7896b;

        /* renamed from: c  reason: collision with root package name */
        public final String f7897c;

        private Config(int i2, int i3, String str) {
            this.f7895a = i2;
            this.f7896b = i3;
            this.f7897c = str;
        }
    }

    private AacUtil() {
    }

    public static byte[] a(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    private static int b(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(5);
        if (h2 == 31) {
            return parsableBitArray.h(6) + 32;
        }
        return h2;
    }

    private static int c(ParsableBitArray parsableBitArray) throws ParserException {
        int h2 = parsableBitArray.h(4);
        if (h2 == 15) {
            if (parsableBitArray.b() >= 24) {
                return parsableBitArray.h(24);
            }
            throw ParserException.a("AAC header insufficient data", (Throwable) null);
        } else if (h2 < 13) {
            return f7893a[h2];
        } else {
            throw ParserException.a("AAC header wrong Sampling Frequency Index", (Throwable) null);
        }
    }

    public static Config d(ParsableBitArray parsableBitArray, boolean z2) throws ParserException {
        int b2 = b(parsableBitArray);
        int c2 = c(parsableBitArray);
        int h2 = parsableBitArray.h(4);
        String str = "mp4a.40." + b2;
        if (b2 == 5 || b2 == 29) {
            c2 = c(parsableBitArray);
            b2 = b(parsableBitArray);
            if (b2 == 22) {
                h2 = parsableBitArray.h(4);
            }
        }
        if (z2) {
            if (!(b2 == 1 || b2 == 2 || b2 == 3 || b2 == 4 || b2 == 6 || b2 == 7 || b2 == 17)) {
                switch (b2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.d("Unsupported audio object type: " + b2);
                }
            }
            f(parsableBitArray, b2, h2);
            switch (b2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h3 = parsableBitArray.h(2);
                    if (h3 == 2 || h3 == 3) {
                        throw ParserException.d("Unsupported epConfig: " + h3);
                    }
            }
        }
        int i2 = f7894b[h2];
        if (i2 != -1) {
            return new Config(c2, i2, str);
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    public static Config e(byte[] bArr) throws ParserException {
        return d(new ParsableBitArray(bArr), false);
    }

    private static void f(ParsableBitArray parsableBitArray, int i2, int i3) {
        if (parsableBitArray.g()) {
            Log.h("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(14);
        }
        boolean g2 = parsableBitArray.g();
        if (i3 != 0) {
            if (i2 == 6 || i2 == 20) {
                parsableBitArray.r(3);
            }
            if (g2) {
                if (i2 == 22) {
                    parsableBitArray.r(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    parsableBitArray.r(3);
                }
                parsableBitArray.r(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
