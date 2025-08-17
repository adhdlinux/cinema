package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class AacUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f23631a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f23632b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public final int f23633a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23634b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23635c;

        private Config(int i2, int i3, String str) {
            this.f23633a = i2;
            this.f23634b = i3;
            this.f23635c = str;
        }
    }

    private AacUtil() {
    }

    public static byte[] a(int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (true) {
            int[] iArr = f23631a;
            if (i5 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i5]) {
                i6 = i5;
            }
            i5++;
        }
        int i7 = -1;
        while (true) {
            int[] iArr2 = f23632b;
            if (i4 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i4]) {
                i7 = i4;
            }
            i4++;
        }
        if (i2 != -1 && i7 != -1) {
            return b(2, i6, i7);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
    }

    public static byte[] b(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    private static int c(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(5);
        if (h2 == 31) {
            return parsableBitArray.h(6) + 32;
        }
        return h2;
    }

    private static int d(ParsableBitArray parsableBitArray) throws ParserException {
        int h2 = parsableBitArray.h(4);
        if (h2 == 15) {
            if (parsableBitArray.b() >= 24) {
                return parsableBitArray.h(24);
            }
            throw ParserException.a("AAC header insufficient data", (Throwable) null);
        } else if (h2 < 13) {
            return f23631a[h2];
        } else {
            throw ParserException.a("AAC header wrong Sampling Frequency Index", (Throwable) null);
        }
    }

    public static Config e(ParsableBitArray parsableBitArray, boolean z2) throws ParserException {
        int c2 = c(parsableBitArray);
        int d2 = d(parsableBitArray);
        int h2 = parsableBitArray.h(4);
        String str = "mp4a.40." + c2;
        if (c2 == 5 || c2 == 29) {
            d2 = d(parsableBitArray);
            c2 = c(parsableBitArray);
            if (c2 == 22) {
                h2 = parsableBitArray.h(4);
            }
        }
        if (z2) {
            if (!(c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4 || c2 == 6 || c2 == 7 || c2 == 17)) {
                switch (c2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.e("Unsupported audio object type: " + c2);
                }
            }
            g(parsableBitArray, c2, h2);
            switch (c2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h3 = parsableBitArray.h(2);
                    if (h3 == 2 || h3 == 3) {
                        throw ParserException.e("Unsupported epConfig: " + h3);
                    }
            }
        }
        int i2 = f23632b[h2];
        if (i2 != -1) {
            return new Config(d2, i2, str);
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    public static Config f(byte[] bArr) throws ParserException {
        return e(new ParsableBitArray(bArr), false);
    }

    private static void g(ParsableBitArray parsableBitArray, int i2, int i3) {
        if (parsableBitArray.g()) {
            Log.i("AacUtil", "Unexpected frameLengthFlag = 1");
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
