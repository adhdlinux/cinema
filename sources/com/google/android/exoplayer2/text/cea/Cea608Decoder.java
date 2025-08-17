package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea608Decoder extends CeaDecoder {
    /* access modifiers changed from: private */
    public static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, JfifUtil.MARKER_APP1, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 241, 9632};
    private static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, 201, 211, 218, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, JfifUtil.MARKER_SOFn, 194, 199, 200, 202, 203, 235, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 239, Sdk$SDKError.Reason.PLACEMENT_SLEEP_VALUE, 217, 249, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 171, 187};
    private static final int[] E = {195, 227, Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE, 204, 236, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, 242, Sdk$SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, Sdk$SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 246, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F;

    /* renamed from: y  reason: collision with root package name */
    private static final int[] f27279y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z  reason: collision with root package name */
    private static final int[] f27280z = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f27281g = new ParsableByteArray();

    /* renamed from: h  reason: collision with root package name */
    private final int f27282h;

    /* renamed from: i  reason: collision with root package name */
    private final int f27283i;

    /* renamed from: j  reason: collision with root package name */
    private final int f27284j;

    /* renamed from: k  reason: collision with root package name */
    private final long f27285k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<CueBuilder> f27286l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private CueBuilder f27287m = new CueBuilder(0, 4);

    /* renamed from: n  reason: collision with root package name */
    private List<Cue> f27288n;

    /* renamed from: o  reason: collision with root package name */
    private List<Cue> f27289o;

    /* renamed from: p  reason: collision with root package name */
    private int f27290p;

    /* renamed from: q  reason: collision with root package name */
    private int f27291q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f27292r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f27293s;

    /* renamed from: t  reason: collision with root package name */
    private byte f27294t;

    /* renamed from: u  reason: collision with root package name */
    private byte f27295u;

    /* renamed from: v  reason: collision with root package name */
    private int f27296v = 0;

    /* renamed from: w  reason: collision with root package name */
    private boolean f27297w;

    /* renamed from: x  reason: collision with root package name */
    private long f27298x;

    private static final class CueBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final List<CueStyle> f27299a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<SpannableString> f27300b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f27301c = new StringBuilder();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f27302d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f27303e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f27304f;

        /* renamed from: g  reason: collision with root package name */
        private int f27305g;

        /* renamed from: h  reason: collision with root package name */
        private int f27306h;

        private static class CueStyle {

            /* renamed from: a  reason: collision with root package name */
            public final int f27307a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f27308b;

            /* renamed from: c  reason: collision with root package name */
            public int f27309c;

            public CueStyle(int i2, boolean z2, int i3) {
                this.f27307a = i2;
                this.f27308b = z2;
                this.f27309c = i3;
            }
        }

        public CueBuilder(int i2, int i3) {
            j(i2);
            this.f27306h = i3;
        }

        private SpannableString h() {
            int i2;
            boolean z2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f27301c);
            int length = spannableStringBuilder.length();
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            boolean z3 = false;
            while (i3 < this.f27299a.size()) {
                CueStyle cueStyle = this.f27299a.get(i3);
                boolean z4 = cueStyle.f27308b;
                int i9 = cueStyle.f27307a;
                if (i9 != 8) {
                    if (i9 == 7) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i9 != 7) {
                        i8 = Cea608Decoder.A[i9];
                    }
                    z3 = z2;
                }
                int i10 = cueStyle.f27309c;
                i3++;
                if (i3 < this.f27299a.size()) {
                    i2 = this.f27299a.get(i3).f27309c;
                } else {
                    i2 = length;
                }
                if (i10 != i2) {
                    if (i4 != -1 && !z4) {
                        q(spannableStringBuilder, i4, i10);
                        i4 = -1;
                    } else if (i4 == -1 && z4) {
                        i4 = i10;
                    }
                    if (i5 != -1 && !z3) {
                        o(spannableStringBuilder, i5, i10);
                        i5 = -1;
                    } else if (i5 == -1 && z3) {
                        i5 = i10;
                    }
                    if (i8 != i7) {
                        n(spannableStringBuilder, i6, i10, i7);
                        i7 = i8;
                        i6 = i10;
                    }
                }
            }
            if (!(i4 == -1 || i4 == length)) {
                q(spannableStringBuilder, i4, length);
            }
            if (!(i5 == -1 || i5 == length)) {
                o(spannableStringBuilder, i5, length);
            }
            if (i6 != length) {
                n(spannableStringBuilder, i6, length, i7);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
            if (i4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
            }
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i2, i3, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }

        public void e(char c2) {
            if (this.f27301c.length() < 32) {
                this.f27301c.append(c2);
            }
        }

        public void f() {
            int length = this.f27301c.length();
            if (length > 0) {
                this.f27301c.delete(length - 1, length);
                int size = this.f27299a.size() - 1;
                while (size >= 0) {
                    CueStyle cueStyle = this.f27299a.get(size);
                    int i2 = cueStyle.f27309c;
                    if (i2 == length) {
                        cueStyle.f27309c = i2 - 1;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public Cue g(int i2) {
            float f2;
            int i3 = this.f27303e + this.f27304f;
            int i4 = 32 - i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f27300b.size(); i5++) {
                spannableStringBuilder.append(Util.g1(this.f27300b.get(i5), i4));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(Util.g1(h(), i4));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i4 - spannableStringBuilder.length();
            int i6 = i3 - length;
            if (i2 == Integer.MIN_VALUE) {
                if (this.f27305g == 2 && (Math.abs(i6) < 3 || length < 0)) {
                    i2 = 1;
                } else if (this.f27305g != 2 || i6 <= 0) {
                    i2 = 0;
                } else {
                    i2 = 2;
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = 32 - length;
                }
                f2 = ((((float) i3) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i7 = this.f27302d;
            if (i7 > 7) {
                i7 = (i7 - 15) - 2;
            } else if (this.f27305g == 1) {
                i7 -= this.f27306h - 1;
            }
            return new Cue.Builder().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h((float) i7, 1).k(f2).l(i2).a();
        }

        public boolean i() {
            if (!this.f27299a.isEmpty() || !this.f27300b.isEmpty() || this.f27301c.length() != 0) {
                return false;
            }
            return true;
        }

        public void j(int i2) {
            this.f27305g = i2;
            this.f27299a.clear();
            this.f27300b.clear();
            this.f27301c.setLength(0);
            this.f27302d = 15;
            this.f27303e = 0;
            this.f27304f = 0;
        }

        public void k() {
            this.f27300b.add(h());
            this.f27301c.setLength(0);
            this.f27299a.clear();
            int min = Math.min(this.f27306h, this.f27302d);
            while (this.f27300b.size() >= min) {
                this.f27300b.remove(0);
            }
        }

        public void l(int i2) {
            this.f27305g = i2;
        }

        public void m(int i2) {
            this.f27306h = i2;
        }

        public void p(int i2, boolean z2) {
            this.f27299a.add(new CueStyle(i2, z2, this.f27301c.length()));
        }
    }

    static {
        boolean[] zArr = new boolean[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        // fill-array-data instruction
        zArr[0] = 0;
        zArr[1] = 1;
        zArr[2] = 1;
        zArr[3] = 0;
        zArr[4] = 1;
        zArr[5] = 0;
        zArr[6] = 0;
        zArr[7] = 1;
        zArr[8] = 1;
        zArr[9] = 0;
        zArr[10] = 0;
        zArr[11] = 1;
        zArr[12] = 0;
        zArr[13] = 1;
        zArr[14] = 1;
        zArr[15] = 0;
        zArr[16] = 1;
        zArr[17] = 0;
        zArr[18] = 0;
        zArr[19] = 1;
        zArr[20] = 0;
        zArr[21] = 1;
        zArr[22] = 1;
        zArr[23] = 0;
        zArr[24] = 0;
        zArr[25] = 1;
        zArr[26] = 1;
        zArr[27] = 0;
        zArr[28] = 1;
        zArr[29] = 0;
        zArr[30] = 0;
        zArr[31] = 1;
        zArr[32] = 1;
        zArr[33] = 0;
        zArr[34] = 0;
        zArr[35] = 1;
        zArr[36] = 0;
        zArr[37] = 1;
        zArr[38] = 1;
        zArr[39] = 0;
        zArr[40] = 0;
        zArr[41] = 1;
        zArr[42] = 1;
        zArr[43] = 0;
        zArr[44] = 1;
        zArr[45] = 0;
        zArr[46] = 0;
        zArr[47] = 1;
        zArr[48] = 0;
        zArr[49] = 1;
        zArr[50] = 1;
        zArr[51] = 0;
        zArr[52] = 1;
        zArr[53] = 0;
        zArr[54] = 0;
        zArr[55] = 1;
        zArr[56] = 1;
        zArr[57] = 0;
        zArr[58] = 0;
        zArr[59] = 1;
        zArr[60] = 0;
        zArr[61] = 1;
        zArr[62] = 1;
        zArr[63] = 0;
        zArr[64] = 1;
        zArr[65] = 0;
        zArr[66] = 0;
        zArr[67] = 1;
        zArr[68] = 0;
        zArr[69] = 1;
        zArr[70] = 1;
        zArr[71] = 0;
        zArr[72] = 0;
        zArr[73] = 1;
        zArr[74] = 1;
        zArr[75] = 0;
        zArr[76] = 1;
        zArr[77] = 0;
        zArr[78] = 0;
        zArr[79] = 1;
        zArr[80] = 0;
        zArr[81] = 1;
        zArr[82] = 1;
        zArr[83] = 0;
        zArr[84] = 1;
        zArr[85] = 0;
        zArr[86] = 0;
        zArr[87] = 1;
        zArr[88] = 1;
        zArr[89] = 0;
        zArr[90] = 0;
        zArr[91] = 1;
        zArr[92] = 0;
        zArr[93] = 1;
        zArr[94] = 1;
        zArr[95] = 0;
        zArr[96] = 0;
        zArr[97] = 1;
        zArr[98] = 1;
        zArr[99] = 0;
        zArr[100] = 1;
        zArr[101] = 0;
        zArr[102] = 0;
        zArr[103] = 1;
        zArr[104] = 1;
        zArr[105] = 0;
        zArr[106] = 0;
        zArr[107] = 1;
        zArr[108] = 0;
        zArr[109] = 1;
        zArr[110] = 1;
        zArr[111] = 0;
        zArr[112] = 1;
        zArr[113] = 0;
        zArr[114] = 0;
        zArr[115] = 1;
        zArr[116] = 0;
        zArr[117] = 1;
        zArr[118] = 1;
        zArr[119] = 0;
        zArr[120] = 0;
        zArr[121] = 1;
        zArr[122] = 1;
        zArr[123] = 0;
        zArr[124] = 1;
        zArr[125] = 0;
        zArr[126] = 0;
        zArr[127] = 1;
        zArr[128] = 1;
        zArr[129] = 0;
        zArr[130] = 0;
        zArr[131] = 1;
        zArr[132] = 0;
        zArr[133] = 1;
        zArr[134] = 1;
        zArr[135] = 0;
        zArr[136] = 0;
        zArr[137] = 1;
        zArr[138] = 1;
        zArr[139] = 0;
        zArr[140] = 1;
        zArr[141] = 0;
        zArr[142] = 0;
        zArr[143] = 1;
        zArr[144] = 0;
        zArr[145] = 1;
        zArr[146] = 1;
        zArr[147] = 0;
        zArr[148] = 1;
        zArr[149] = 0;
        zArr[150] = 0;
        zArr[151] = 1;
        zArr[152] = 1;
        zArr[153] = 0;
        zArr[154] = 0;
        zArr[155] = 1;
        zArr[156] = 0;
        zArr[157] = 1;
        zArr[158] = 1;
        zArr[159] = 0;
        zArr[160] = 0;
        zArr[161] = 1;
        zArr[162] = 1;
        zArr[163] = 0;
        zArr[164] = 1;
        zArr[165] = 0;
        zArr[166] = 0;
        zArr[167] = 1;
        zArr[168] = 1;
        zArr[169] = 0;
        zArr[170] = 0;
        zArr[171] = 1;
        zArr[172] = 0;
        zArr[173] = 1;
        zArr[174] = 1;
        zArr[175] = 0;
        zArr[176] = 1;
        zArr[177] = 0;
        zArr[178] = 0;
        zArr[179] = 1;
        zArr[180] = 0;
        zArr[181] = 1;
        zArr[182] = 1;
        zArr[183] = 0;
        zArr[184] = 0;
        zArr[185] = 1;
        zArr[186] = 1;
        zArr[187] = 0;
        zArr[188] = 1;
        zArr[189] = 0;
        zArr[190] = 0;
        zArr[191] = 1;
        zArr[192] = 0;
        zArr[193] = 1;
        zArr[194] = 1;
        zArr[195] = 0;
        zArr[196] = 1;
        zArr[197] = 0;
        zArr[198] = 0;
        zArr[199] = 1;
        zArr[200] = 1;
        zArr[201] = 0;
        zArr[202] = 0;
        zArr[203] = 1;
        zArr[204] = 0;
        zArr[205] = 1;
        zArr[206] = 1;
        zArr[207] = 0;
        zArr[208] = 1;
        zArr[209] = 0;
        zArr[210] = 0;
        zArr[211] = 1;
        zArr[212] = 0;
        zArr[213] = 1;
        zArr[214] = 1;
        zArr[215] = 0;
        zArr[216] = 0;
        zArr[217] = 1;
        zArr[218] = 1;
        zArr[219] = 0;
        zArr[220] = 1;
        zArr[221] = 0;
        zArr[222] = 0;
        zArr[223] = 1;
        zArr[224] = 1;
        zArr[225] = 0;
        zArr[226] = 0;
        zArr[227] = 1;
        zArr[228] = 0;
        zArr[229] = 1;
        zArr[230] = 1;
        zArr[231] = 0;
        zArr[232] = 0;
        zArr[233] = 1;
        zArr[234] = 1;
        zArr[235] = 0;
        zArr[236] = 1;
        zArr[237] = 0;
        zArr[238] = 0;
        zArr[239] = 1;
        zArr[240] = 0;
        zArr[241] = 1;
        zArr[242] = 1;
        zArr[243] = 0;
        zArr[244] = 1;
        zArr[245] = 0;
        zArr[246] = 0;
        zArr[247] = 1;
        zArr[248] = 1;
        zArr[249] = 0;
        zArr[250] = 0;
        zArr[251] = 1;
        zArr[252] = 0;
        zArr[253] = 1;
        zArr[254] = 1;
        zArr[255] = 0;
        F = zArr;
    }

    public Cea608Decoder(String str, int i2, long j2) {
        long j3;
        int i3;
        if (j2 > 0) {
            j3 = j2 * 1000;
        } else {
            j3 = -9223372036854775807L;
        }
        this.f27285k = j3;
        if ("application/x-mp4-cea-608".equals(str)) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.f27282h = i3;
        if (i2 == 1) {
            this.f27284j = 0;
            this.f27283i = 0;
        } else if (i2 == 2) {
            this.f27284j = 1;
            this.f27283i = 0;
        } else if (i2 == 3) {
            this.f27284j = 0;
            this.f27283i = 1;
        } else if (i2 != 4) {
            Log.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f27284j = 0;
            this.f27283i = 0;
        } else {
            this.f27284j = 1;
            this.f27283i = 1;
        }
        M(0);
        L();
        this.f27297w = true;
        this.f27298x = -9223372036854775807L;
    }

    private static boolean A(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    private static boolean B(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean C(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    private static boolean D(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean E(byte b2) {
        return (b2 & 240) == 16;
    }

    private boolean F(boolean z2, byte b2, byte b3) {
        if (!z2 || !E(b2)) {
            this.f27293s = false;
        } else if (this.f27293s && this.f27294t == b2 && this.f27295u == b3) {
            this.f27293s = false;
            return true;
        } else {
            this.f27293s = true;
            this.f27294t = b2;
            this.f27295u = b3;
        }
        return false;
    }

    private static boolean G(byte b2) {
        return (b2 & 246) == 20;
    }

    private static boolean H(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    private static boolean I(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean J(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    private void K(byte b2, byte b3) {
        if (J(b2)) {
            this.f27297w = false;
        } else if (G(b2)) {
            if (!(b3 == 32 || b3 == 47)) {
                switch (b3) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b3) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.f27297w = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.f27297w = true;
        }
    }

    private void L() {
        this.f27287m.j(this.f27290p);
        this.f27286l.clear();
        this.f27286l.add(this.f27287m);
    }

    private void M(int i2) {
        int i3 = this.f27290p;
        if (i3 != i2) {
            this.f27290p = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.f27286l.size(); i4++) {
                    this.f27286l.get(i4).l(i2);
                }
                return;
            }
            L();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.f27288n = Collections.emptyList();
            }
        }
    }

    private void N(int i2) {
        this.f27291q = i2;
        this.f27287m.m(i2);
    }

    private boolean O() {
        if (this.f27285k == -9223372036854775807L || this.f27298x == -9223372036854775807L || j() - this.f27298x < this.f27285k) {
            return false;
        }
        return true;
    }

    private boolean P(byte b2) {
        if (z(b2)) {
            this.f27296v = q(b2);
        }
        if (this.f27296v == this.f27284j) {
            return true;
        }
        return false;
    }

    private static char p(byte b2) {
        return (char) B[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static int q(byte b2) {
        return (b2 >> 3) & 1;
    }

    private List<Cue> r() {
        int size = this.f27286l.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            Cue g2 = this.f27286l.get(i3).g(Integer.MIN_VALUE);
            arrayList.add(g2);
            if (g2 != null) {
                i2 = Math.min(i2, g2.f27210j);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            Cue cue = (Cue) arrayList.get(i4);
            if (cue != null) {
                if (cue.f27210j != i2) {
                    cue = (Cue) Assertions.e(this.f27286l.get(i4).g(i2));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    private static char s(byte b2) {
        return (char) D[b2 & 31];
    }

    private static char t(byte b2) {
        return (char) E[b2 & 31];
    }

    private static char u(byte b2, byte b3) {
        if ((b2 & 1) == 0) {
            return s(b3);
        }
        return t(b3);
    }

    private static char v(byte b2) {
        return (char) C[b2 & 15];
    }

    private void w(byte b2) {
        boolean z2;
        this.f27287m.e(' ');
        if ((b2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f27287m.p((b2 >> 1) & 7, z2);
    }

    private void x(byte b2) {
        if (b2 == 32) {
            M(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    M(1);
                    N(2);
                    return;
                case 38:
                    M(1);
                    N(3);
                    return;
                case 39:
                    M(1);
                    N(4);
                    return;
                default:
                    int i2 = this.f27290p;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.f27288n = Collections.emptyList();
                                    int i3 = this.f27290p;
                                    if (i3 == 1 || i3 == 3) {
                                        L();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i2 == 1 && !this.f27287m.i()) {
                                        this.f27287m.k();
                                        return;
                                    }
                                    return;
                                case 46:
                                    L();
                                    return;
                                case 47:
                                    this.f27288n = r();
                                    L();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.f27287m.f();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            M(3);
        }
    }

    private void y(byte b2, byte b3) {
        boolean z2;
        boolean z3;
        int i2;
        int i3 = f27279y[b2 & 7];
        boolean z4 = false;
        if ((b3 & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i3++;
        }
        if (i3 != this.f27287m.f27302d) {
            if (this.f27290p != 1 && !this.f27287m.i()) {
                CueBuilder cueBuilder = new CueBuilder(this.f27290p, this.f27291q);
                this.f27287m = cueBuilder;
                this.f27286l.add(cueBuilder);
            }
            int unused = this.f27287m.f27302d = i3;
        }
        if ((b3 & 16) == 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((b3 & 1) == 1) {
            z4 = true;
        }
        int i4 = (b3 >> 1) & 7;
        CueBuilder cueBuilder2 = this.f27287m;
        if (z3) {
            i2 = 8;
        } else {
            i2 = i4;
        }
        cueBuilder2.p(i2, z4);
        if (z3) {
            int unused2 = this.f27287m.f27303e = f27280z[i4];
        }
    }

    private static boolean z(byte b2) {
        return (b2 & 224) == 0;
    }

    public /* bridge */ /* synthetic */ void b(long j2) {
        super.b(j2);
    }

    /* access modifiers changed from: protected */
    public Subtitle e() {
        List<Cue> list = this.f27288n;
        this.f27289o = list;
        return new CeaSubtitle((List) Assertions.e(list));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0017 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(com.google.android.exoplayer2.text.SubtitleInputBuffer r10) {
        /*
            r9 = this;
            java.nio.ByteBuffer r10 = r10.f23961d
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.e(r10)
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r9.f27281g
            byte[] r1 = r10.array()
            int r10 = r10.limit()
            r0.S(r1, r10)
            r10 = 0
            r0 = 0
        L_0x0017:
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r9.f27281g
            int r1 = r1.a()
            int r2 = r9.f27282h
            r3 = 1
            if (r1 < r2) goto L_0x00f5
            r1 = 2
            if (r2 != r1) goto L_0x0027
            r1 = -4
            goto L_0x002d
        L_0x0027:
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r9.f27281g
            int r1 = r1.H()
        L_0x002d:
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r9.f27281g
            int r2 = r2.H()
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r9.f27281g
            int r4 = r4.H()
            r5 = r1 & 2
            if (r5 == 0) goto L_0x003e
            goto L_0x0017
        L_0x003e:
            r5 = r1 & 1
            int r6 = r9.f27283i
            if (r5 == r6) goto L_0x0045
            goto L_0x0017
        L_0x0045:
            r5 = r2 & 127(0x7f, float:1.78E-43)
            byte r5 = (byte) r5
            r6 = r4 & 127(0x7f, float:1.78E-43)
            byte r6 = (byte) r6
            if (r5 != 0) goto L_0x0050
            if (r6 != 0) goto L_0x0050
            goto L_0x0017
        L_0x0050:
            boolean r7 = r9.f27292r
            r1 = r1 & 4
            r8 = 4
            if (r1 != r8) goto L_0x0063
            boolean[] r1 = F
            boolean r2 = r1[r2]
            if (r2 == 0) goto L_0x0063
            boolean r1 = r1[r4]
            if (r1 == 0) goto L_0x0063
            r1 = 1
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            r9.f27292r = r1
            boolean r1 = r9.F(r1, r5, r6)
            if (r1 == 0) goto L_0x006d
            goto L_0x0017
        L_0x006d:
            boolean r1 = r9.f27292r
            if (r1 != 0) goto L_0x0078
            if (r7 == 0) goto L_0x0017
            r9.L()
        L_0x0076:
            r0 = 1
            goto L_0x0017
        L_0x0078:
            r9.K(r5, r6)
            boolean r1 = r9.f27297w
            if (r1 != 0) goto L_0x0080
            goto L_0x0017
        L_0x0080:
            boolean r1 = r9.P(r5)
            if (r1 != 0) goto L_0x0087
            goto L_0x0017
        L_0x0087:
            boolean r0 = z(r5)
            if (r0 == 0) goto L_0x00de
            boolean r0 = H(r5, r6)
            if (r0 == 0) goto L_0x009d
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r0 = r9.f27287m
            char r1 = v(r6)
            r0.e(r1)
            goto L_0x0076
        L_0x009d:
            boolean r0 = A(r5, r6)
            if (r0 == 0) goto L_0x00b2
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r0 = r9.f27287m
            r0.f()
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r0 = r9.f27287m
            char r1 = u(r5, r6)
            r0.e(r1)
            goto L_0x0076
        L_0x00b2:
            boolean r0 = B(r5, r6)
            if (r0 == 0) goto L_0x00bc
            r9.w(r6)
            goto L_0x0076
        L_0x00bc:
            boolean r0 = D(r5, r6)
            if (r0 == 0) goto L_0x00c6
            r9.y(r5, r6)
            goto L_0x0076
        L_0x00c6:
            boolean r0 = I(r5, r6)
            if (r0 == 0) goto L_0x00d4
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r0 = r9.f27287m
            int r6 = r6 + -32
            int unused = r0.f27304f = r6
            goto L_0x0076
        L_0x00d4:
            boolean r0 = C(r5, r6)
            if (r0 == 0) goto L_0x0076
            r9.x(r6)
            goto L_0x0076
        L_0x00de:
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r0 = r9.f27287m
            char r1 = p(r5)
            r0.e(r1)
            r0 = r6 & 224(0xe0, float:3.14E-43)
            if (r0 == 0) goto L_0x0076
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r0 = r9.f27287m
            char r1 = p(r6)
            r0.e(r1)
            goto L_0x0076
        L_0x00f5:
            if (r0 == 0) goto L_0x010a
            int r10 = r9.f27290p
            if (r10 == r3) goto L_0x00fe
            r0 = 3
            if (r10 != r0) goto L_0x010a
        L_0x00fe:
            java.util.List r10 = r9.r()
            r9.f27288n = r10
            long r0 = r9.j()
            r9.f27298x = r0
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea608Decoder.f(com.google.android.exoplayer2.text.SubtitleInputBuffer):void");
    }

    public void flush() {
        super.flush();
        this.f27288n = null;
        this.f27289o = null;
        M(0);
        N(4);
        L();
        this.f27292r = false;
        this.f27293s = false;
        this.f27294t = 0;
        this.f27295u = 0;
        this.f27296v = 0;
        this.f27297w = true;
        this.f27298x = -9223372036854775807L;
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer g() throws SubtitleDecoderException {
        return super.d();
    }

    /* renamed from: h */
    public SubtitleOutputBuffer a() throws SubtitleDecoderException {
        SubtitleOutputBuffer i2;
        SubtitleOutputBuffer h2 = super.a();
        if (h2 != null) {
            return h2;
        }
        if (!O() || (i2 = i()) == null) {
            return null;
        }
        this.f27288n = Collections.emptyList();
        this.f27298x = -9223372036854775807L;
        SubtitleOutputBuffer subtitleOutputBuffer = i2;
        subtitleOutputBuffer.q(j(), e(), Clock.MAX_TIME);
        return i2;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return this.f27288n != this.f27289o;
    }

    public /* bridge */ /* synthetic */ void l(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.c(subtitleInputBuffer);
    }

    public void release() {
    }
}
