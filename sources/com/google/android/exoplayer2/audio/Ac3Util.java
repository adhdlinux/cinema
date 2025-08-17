package com.google.android.exoplayer2.audio;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;

public final class Ac3Util {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f23636a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f23637b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f23638c = {24000, 22050, 16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f23639d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f23640e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, UserVerificationMethods.USER_VERIFY_HANDPRINT, Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f23641f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f23642a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23643b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23644c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23645d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23646e;

        /* renamed from: f  reason: collision with root package name */
        public final int f23647f;

        /* renamed from: g  reason: collision with root package name */
        public final int f23648g;

        private SyncFrameInfo(String str, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f23642a = str;
            this.f23643b = i2;
            this.f23645d = i3;
            this.f23644c = i4;
            this.f23646e = i5;
            this.f23647f = i6;
            this.f23648g = i7;
        }
    }

    private Ac3Util() {
    }

    private static int a(int i2, int i3, int i4) {
        return (i2 * i3) / (i4 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i2 = position; i2 <= limit; i2++) {
            if ((Util.I(byteBuffer, i2 + 4) & -2) == -126718022) {
                return i2 - position;
            }
        }
        return -1;
    }

    private static int c(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = f23637b;
        if (i2 >= iArr.length || i3 < 0) {
            return -1;
        }
        int[] iArr2 = f23641f;
        if (i4 >= iArr2.length) {
            return -1;
        }
        int i5 = iArr[i2];
        if (i5 == 44100) {
            return (iArr2[i4] + (i3 % 2)) * 2;
        }
        int i6 = f23640e[i4];
        if (i5 == 32000) {
            return i6 * 6;
        }
        return i6 * 4;
    }

    public static Format d(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m(parsableByteArray);
        int i2 = f23637b[parsableBitArray.h(2)];
        parsableBitArray.r(8);
        int i3 = f23639d[parsableBitArray.h(3)];
        if (parsableBitArray.h(1) != 0) {
            i3++;
        }
        int i4 = f23640e[parsableBitArray.h(5)] * 1000;
        parsableBitArray.c();
        parsableByteArray.U(parsableBitArray.d());
        return new Format.Builder().U(str).g0("audio/ac3").J(i3).h0(i2).O(drmInitData).X(str2).I(i4).b0(i4).G();
    }

    public static int e(ByteBuffer byteBuffer) {
        boolean z2;
        int i2 = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return f23636a[i2] * UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }

    public static SyncFrameInfo f(ParsableBitArray parsableBitArray) {
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str;
        String str2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str3;
        int i13;
        int i14;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int e2 = parsableBitArray.e();
        parsableBitArray2.r(40);
        if (parsableBitArray2.h(5) > 10) {
            z2 = true;
        } else {
            z2 = false;
        }
        parsableBitArray2.p(e2);
        int i15 = -1;
        if (z2) {
            parsableBitArray2.r(16);
            int h2 = parsableBitArray2.h(2);
            if (h2 == 0) {
                i15 = 0;
            } else if (h2 == 1) {
                i15 = 1;
            } else if (h2 == 2) {
                i15 = 2;
            }
            parsableBitArray2.r(3);
            int h3 = (parsableBitArray2.h(11) + 1) * 2;
            int h4 = parsableBitArray2.h(2);
            if (h4 == 3) {
                i11 = f23638c[parsableBitArray2.h(2)];
                i10 = 3;
                i9 = 6;
            } else {
                int h5 = parsableBitArray2.h(2);
                int i16 = f23636a[h5];
                i10 = h5;
                i11 = f23637b[h4];
                i9 = i16;
            }
            int i17 = i9 * UserVerificationMethods.USER_VERIFY_HANDPRINT;
            int a2 = a(h3, i11, i9);
            int h6 = parsableBitArray2.h(3);
            boolean g2 = parsableBitArray.g();
            int i18 = f23639d[h6] + (g2 ? 1 : 0);
            parsableBitArray2.r(10);
            if (parsableBitArray.g()) {
                parsableBitArray2.r(8);
            }
            if (h6 == 0) {
                parsableBitArray2.r(5);
                if (parsableBitArray.g()) {
                    parsableBitArray2.r(8);
                }
            }
            if (i15 == 1 && parsableBitArray.g()) {
                parsableBitArray2.r(16);
            }
            if (parsableBitArray.g()) {
                if (h6 > 2) {
                    parsableBitArray2.r(2);
                }
                if ((h6 & 1) == 0 || h6 <= 2) {
                    i13 = 6;
                } else {
                    i13 = 6;
                    parsableBitArray2.r(6);
                }
                if ((h6 & 4) != 0) {
                    parsableBitArray2.r(i13);
                }
                if (g2 && parsableBitArray.g()) {
                    parsableBitArray2.r(5);
                }
                if (i15 == 0) {
                    if (parsableBitArray.g()) {
                        i14 = 6;
                        parsableBitArray2.r(6);
                    } else {
                        i14 = 6;
                    }
                    if (h6 == 0 && parsableBitArray.g()) {
                        parsableBitArray2.r(i14);
                    }
                    if (parsableBitArray.g()) {
                        parsableBitArray2.r(i14);
                    }
                    int h7 = parsableBitArray2.h(2);
                    if (h7 == 1) {
                        parsableBitArray2.r(5);
                    } else if (h7 == 2) {
                        parsableBitArray2.r(12);
                    } else if (h7 == 3) {
                        int h8 = parsableBitArray2.h(5);
                        if (parsableBitArray.g()) {
                            parsableBitArray2.r(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(4);
                            }
                            if (parsableBitArray.g()) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.r(4);
                                }
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.r(4);
                                }
                            }
                        }
                        if (parsableBitArray.g()) {
                            parsableBitArray2.r(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray2.r(7);
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.r(8);
                                }
                            }
                        }
                        parsableBitArray2.r((h8 + 2) * 8);
                        parsableBitArray.c();
                    }
                    if (h6 < 2) {
                        if (parsableBitArray.g()) {
                            parsableBitArray2.r(14);
                        }
                        if (h6 == 0 && parsableBitArray.g()) {
                            parsableBitArray2.r(14);
                        }
                    }
                    if (parsableBitArray.g()) {
                        if (i10 == 0) {
                            parsableBitArray2.r(5);
                        } else {
                            for (int i19 = 0; i19 < i9; i19++) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.g()) {
                parsableBitArray2.r(5);
                if (h6 == 2) {
                    parsableBitArray2.r(4);
                }
                if (h6 >= 6) {
                    parsableBitArray2.r(2);
                }
                if (parsableBitArray.g()) {
                    parsableBitArray2.r(8);
                }
                if (h6 == 0 && parsableBitArray.g()) {
                    parsableBitArray2.r(8);
                }
                if (h4 < 3) {
                    parsableBitArray.q();
                }
            }
            if (i15 == 0 && i10 != 3) {
                parsableBitArray.q();
            }
            if (i15 != 2 || (i10 != 3 && !parsableBitArray.g())) {
                i12 = 6;
            } else {
                i12 = 6;
                parsableBitArray2.r(6);
            }
            if (parsableBitArray.g() && parsableBitArray2.h(i12) == 1 && parsableBitArray2.h(8) == 1) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
            str = str3;
            i7 = i15;
            i3 = i17;
            i4 = h3;
            i5 = i11;
            i2 = a2;
            i6 = i18;
        } else {
            parsableBitArray2.r(32);
            int h9 = parsableBitArray2.h(2);
            if (h9 == 3) {
                str2 = null;
            } else {
                str2 = "audio/ac3";
            }
            int h10 = parsableBitArray2.h(6);
            int i20 = f23640e[h10 / 2] * 1000;
            int c2 = c(h9, h10);
            parsableBitArray2.r(8);
            int h11 = parsableBitArray2.h(3);
            if (!((h11 & 1) == 0 || h11 == 1)) {
                parsableBitArray2.r(2);
            }
            if ((h11 & 4) != 0) {
                parsableBitArray2.r(2);
            }
            if (h11 == 2) {
                parsableBitArray2.r(2);
            }
            int[] iArr = f23637b;
            if (h9 < iArr.length) {
                i8 = iArr[h9];
            } else {
                i8 = -1;
            }
            str = str2;
            i2 = i20;
            i4 = c2;
            i5 = i8;
            i6 = f23639d[h11] + (parsableBitArray.g() ? 1 : 0);
            i7 = -1;
            i3 = 1536;
        }
        return new SyncFrameInfo(str, i7, i6, i5, i4, i3, i2);
    }

    public static int g(byte[] bArr) {
        boolean z2;
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return c((b2 & 192) >> 6, b2 & 63);
    }

    public static Format h(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        String str3;
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m(parsableByteArray);
        int h2 = parsableBitArray.h(13) * 1000;
        parsableBitArray.r(3);
        int i2 = f23637b[parsableBitArray.h(2)];
        parsableBitArray.r(10);
        int i3 = f23639d[parsableBitArray.h(3)];
        if (parsableBitArray.h(1) != 0) {
            i3++;
        }
        parsableBitArray.r(3);
        int h3 = parsableBitArray.h(4);
        parsableBitArray.r(1);
        if (h3 > 0) {
            parsableBitArray.s(6);
            if (parsableBitArray.h(1) != 0) {
                i3 += 2;
            }
            parsableBitArray.r(1);
        }
        if (parsableBitArray.b() > 7) {
            parsableBitArray.r(7);
            if (parsableBitArray.h(1) != 0) {
                str3 = "audio/eac3-joc";
                parsableBitArray.c();
                parsableByteArray.U(parsableBitArray.d());
                return new Format.Builder().U(str).g0(str3).J(i3).h0(i2).O(drmInitData).X(str2).b0(h2).G();
            }
        }
        str3 = "audio/eac3";
        parsableBitArray.c();
        parsableByteArray.U(parsableBitArray.d());
        return new Format.Builder().U(str).g0(str3).J(i3).h0(i2).O(drmInitData).X(str2).b0(h2).G();
    }

    public static int i(ByteBuffer byteBuffer, int i2) {
        boolean z2;
        int i3;
        if ((byteBuffer.get(byteBuffer.position() + i2 + 7) & 255) == 187) {
            z2 = true;
        } else {
            z2 = false;
        }
        int position = byteBuffer.position() + i2;
        if (z2) {
            i3 = 9;
        } else {
            i3 = 8;
        }
        return 40 << ((byteBuffer.get(position + i3) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        char c2;
        boolean z2 = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                if ((b2 & 255) == 187) {
                    z2 = true;
                }
                if (z2) {
                    c2 = 9;
                } else {
                    c2 = 8;
                }
                return 40 << ((bArr[c2] >> 4) & 7);
            }
        }
        return 0;
    }
}
