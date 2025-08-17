package com.google.android.exoplayer2.audio;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;

public final class MpegAudioUtil {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f23830a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f23831b = {44100, 48000, 32000};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f23832c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f23833d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f23834e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f23835f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f23836g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class Header {

        /* renamed from: a  reason: collision with root package name */
        public int f23837a;

        /* renamed from: b  reason: collision with root package name */
        public String f23838b;

        /* renamed from: c  reason: collision with root package name */
        public int f23839c;

        /* renamed from: d  reason: collision with root package name */
        public int f23840d;

        /* renamed from: e  reason: collision with root package name */
        public int f23841e;

        /* renamed from: f  reason: collision with root package name */
        public int f23842f;

        /* renamed from: g  reason: collision with root package name */
        public int f23843g;

        public boolean a(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            if (!MpegAudioUtil.l(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
                return false;
            }
            this.f23837a = i3;
            this.f23838b = MpegAudioUtil.f23830a[3 - i4];
            int i9 = MpegAudioUtil.f23831b[i6];
            this.f23840d = i9;
            int i10 = 2;
            if (i3 == 2) {
                this.f23840d = i9 / 2;
            } else if (i3 == 0) {
                this.f23840d = i9 / 4;
            }
            int i11 = (i2 >>> 9) & 1;
            this.f23843g = MpegAudioUtil.k(i3, i4);
            if (i4 == 3) {
                if (i3 == 3) {
                    i8 = MpegAudioUtil.f23832c[i5 - 1];
                } else {
                    i8 = MpegAudioUtil.f23833d[i5 - 1];
                }
                this.f23842f = i8;
                this.f23839c = (((i8 * 12) / this.f23840d) + i11) * 4;
            } else {
                int i12 = 144;
                if (i3 == 3) {
                    if (i4 == 2) {
                        i7 = MpegAudioUtil.f23834e[i5 - 1];
                    } else {
                        i7 = MpegAudioUtil.f23835f[i5 - 1];
                    }
                    this.f23842f = i7;
                    this.f23839c = ((i7 * 144) / this.f23840d) + i11;
                } else {
                    int i13 = MpegAudioUtil.f23836g[i5 - 1];
                    this.f23842f = i13;
                    if (i4 == 1) {
                        i12 = 72;
                    }
                    this.f23839c = ((i12 * i13) / this.f23840d) + i11;
                }
            }
            if (((i2 >> 6) & 3) == 3) {
                i10 = 1;
            }
            this.f23841e = i10;
            return true;
        }
    }

    private MpegAudioUtil() {
    }

    public static int j(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!l(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i9 = f23831b[i6];
        if (i3 == 2) {
            i9 /= 2;
        } else if (i3 == 0) {
            i9 /= 4;
        }
        int i10 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            if (i3 == 3) {
                i8 = f23832c[i5 - 1];
            } else {
                i8 = f23833d[i5 - 1];
            }
            return (((i8 * 12) / i9) + i10) * 4;
        }
        if (i3 != 3) {
            i7 = f23836g[i5 - 1];
        } else if (i4 == 2) {
            i7 = f23834e[i5 - 1];
        } else {
            i7 = f23835f[i5 - 1];
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

    /* access modifiers changed from: private */
    public static int k(int i2, int i3) {
        if (i3 == 1) {
            return i2 == 3 ? 1152 : 576;
        }
        if (i3 == 2) {
            return 1152;
        }
        if (i3 == 3) {
            return BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: private */
    public static boolean l(int i2) {
        return (i2 & -2097152) == -2097152;
    }

    public static int m(int i2) {
        int i3;
        int i4;
        if (!l(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0) {
            return -1;
        }
        int i5 = (i2 >>> 12) & 15;
        int i6 = (i2 >>> 10) & 3;
        if (i5 == 0 || i5 == 15 || i6 == 3) {
            return -1;
        }
        return k(i3, i4);
    }
}
