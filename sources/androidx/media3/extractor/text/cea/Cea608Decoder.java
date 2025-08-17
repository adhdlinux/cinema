package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea608Decoder extends CeaDecoder {
    private static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    /* access modifiers changed from: private */
    public static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, JfifUtil.MARKER_APP1, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 241, 9632};
    private static final int[] D = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] E = {193, 201, 211, 218, Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, JfifUtil.MARKER_SOFn, 194, 199, 200, 202, 203, 235, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 239, Sdk$SDKError.Reason.PLACEMENT_SLEEP_VALUE, 217, 249, Sdk$SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 171, 187};
    private static final int[] F = {195, 227, Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE, 204, 236, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, 242, Sdk$SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, Sdk$SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 246, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] G;

    /* renamed from: z  reason: collision with root package name */
    private static final int[] f8817z = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f8818h = new ParsableByteArray();

    /* renamed from: i  reason: collision with root package name */
    private final int f8819i;

    /* renamed from: j  reason: collision with root package name */
    private final int f8820j;

    /* renamed from: k  reason: collision with root package name */
    private final int f8821k;

    /* renamed from: l  reason: collision with root package name */
    private final long f8822l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList<CueBuilder> f8823m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    private CueBuilder f8824n = new CueBuilder(0, 4);

    /* renamed from: o  reason: collision with root package name */
    private List<Cue> f8825o;

    /* renamed from: p  reason: collision with root package name */
    private List<Cue> f8826p;

    /* renamed from: q  reason: collision with root package name */
    private int f8827q;

    /* renamed from: r  reason: collision with root package name */
    private int f8828r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8829s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8830t;

    /* renamed from: u  reason: collision with root package name */
    private byte f8831u;

    /* renamed from: v  reason: collision with root package name */
    private byte f8832v;

    /* renamed from: w  reason: collision with root package name */
    private int f8833w = 0;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8834x;

    /* renamed from: y  reason: collision with root package name */
    private long f8835y;

    private static final class CueBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final List<CueStyle> f8836a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<SpannableString> f8837b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f8838c = new StringBuilder();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f8839d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f8840e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f8841f;

        /* renamed from: g  reason: collision with root package name */
        private int f8842g;

        /* renamed from: h  reason: collision with root package name */
        private int f8843h;

        private static class CueStyle {

            /* renamed from: a  reason: collision with root package name */
            public final int f8844a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f8845b;

            /* renamed from: c  reason: collision with root package name */
            public int f8846c;

            public CueStyle(int i2, boolean z2, int i3) {
                this.f8844a = i2;
                this.f8845b = z2;
                this.f8846c = i3;
            }
        }

        public CueBuilder(int i2, int i3) {
            j(i2);
            this.f8843h = i3;
        }

        private SpannableString h() {
            int i2;
            boolean z2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f8838c);
            int length = spannableStringBuilder.length();
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            boolean z3 = false;
            while (i3 < this.f8836a.size()) {
                CueStyle cueStyle = this.f8836a.get(i3);
                boolean z4 = cueStyle.f8845b;
                int i9 = cueStyle.f8844a;
                if (i9 != 8) {
                    if (i9 == 7) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i9 != 7) {
                        i8 = Cea608Decoder.B[i9];
                    }
                    z3 = z2;
                }
                int i10 = cueStyle.f8846c;
                i3++;
                if (i3 < this.f8836a.size()) {
                    i2 = this.f8836a.get(i3).f8846c;
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
            if (this.f8838c.length() < 32) {
                this.f8838c.append(c2);
            }
        }

        public void f() {
            int length = this.f8838c.length();
            if (length > 0) {
                this.f8838c.delete(length - 1, length);
                int size = this.f8836a.size() - 1;
                while (size >= 0) {
                    CueStyle cueStyle = this.f8836a.get(size);
                    int i2 = cueStyle.f8846c;
                    if (i2 == length) {
                        cueStyle.f8846c = i2 - 1;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public Cue g(int i2) {
            float f2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.f8837b.size(); i3++) {
                spannableStringBuilder.append(this.f8837b.get(i3));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i4 = this.f8840e + this.f8841f;
            int length = (32 - i4) - spannableStringBuilder.length();
            int i5 = i4 - length;
            if (i2 == Integer.MIN_VALUE) {
                if (this.f8842g == 2 && (Math.abs(i5) < 3 || length < 0)) {
                    i2 = 1;
                } else if (this.f8842g != 2 || i5 <= 0) {
                    i2 = 0;
                } else {
                    i2 = 2;
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i4 = 32 - length;
                }
                f2 = ((((float) i4) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i6 = this.f8839d;
            if (i6 > 7) {
                i6 = (i6 - 15) - 2;
            } else if (this.f8842g == 1) {
                i6 -= this.f8843h - 1;
            }
            return new Cue.Builder().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h((float) i6, 1).k(f2).l(i2).a();
        }

        public boolean i() {
            if (!this.f8836a.isEmpty() || !this.f8837b.isEmpty() || this.f8838c.length() != 0) {
                return false;
            }
            return true;
        }

        public void j(int i2) {
            this.f8842g = i2;
            this.f8836a.clear();
            this.f8837b.clear();
            this.f8838c.setLength(0);
            this.f8839d = 15;
            this.f8840e = 0;
            this.f8841f = 0;
        }

        public void k() {
            this.f8837b.add(h());
            this.f8838c.setLength(0);
            this.f8836a.clear();
            int min = Math.min(this.f8843h, this.f8839d);
            while (this.f8837b.size() >= min) {
                this.f8837b.remove(0);
            }
        }

        public void l(int i2) {
            this.f8842g = i2;
        }

        public void m(int i2) {
            this.f8843h = i2;
        }

        public void p(int i2, boolean z2) {
            this.f8836a.add(new CueStyle(i2, z2, this.f8838c.length()));
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
        G = zArr;
    }

    public Cea608Decoder(String str, int i2, long j2) {
        int i3;
        boolean z2;
        if (j2 != -9223372036854775807L) {
            if (j2 >= 16000) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f8822l = j2 * 1000;
        } else {
            this.f8822l = -9223372036854775807L;
        }
        if ("application/x-mp4-cea-608".equals(str)) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.f8819i = i3;
        if (i2 == 1) {
            this.f8821k = 0;
            this.f8820j = 0;
        } else if (i2 == 2) {
            this.f8821k = 1;
            this.f8820j = 0;
        } else if (i2 == 3) {
            this.f8821k = 0;
            this.f8820j = 1;
        } else if (i2 != 4) {
            Log.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f8821k = 0;
            this.f8820j = 0;
        } else {
            this.f8821k = 1;
            this.f8820j = 1;
        }
        O(0);
        N();
        this.f8834x = true;
        this.f8835y = -9223372036854775807L;
    }

    private void A(byte b2, byte b3) {
        boolean z2;
        boolean z3;
        int i2;
        int i3 = f8817z[b2 & 7];
        boolean z4 = false;
        if ((b3 & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i3++;
        }
        if (i3 != this.f8824n.f8839d) {
            if (this.f8827q != 1 && !this.f8824n.i()) {
                CueBuilder cueBuilder = new CueBuilder(this.f8827q, this.f8828r);
                this.f8824n = cueBuilder;
                this.f8823m.add(cueBuilder);
            }
            int unused = this.f8824n.f8839d = i3;
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
        CueBuilder cueBuilder2 = this.f8824n;
        if (z3) {
            i2 = 8;
        } else {
            i2 = i4;
        }
        cueBuilder2.p(i2, z4);
        if (z3) {
            int unused2 = this.f8824n.f8840e = A[i4];
        }
    }

    private static boolean B(byte b2) {
        return (b2 & 224) == 0;
    }

    private static boolean C(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    private static boolean D(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean E(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    private static boolean F(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean G(byte b2) {
        return (b2 & 240) == 16;
    }

    private boolean H(boolean z2, byte b2, byte b3) {
        if (!z2 || !G(b2)) {
            this.f8830t = false;
        } else if (this.f8830t && this.f8831u == b2 && this.f8832v == b3) {
            this.f8830t = false;
            return true;
        } else {
            this.f8830t = true;
            this.f8831u = b2;
            this.f8832v = b3;
        }
        return false;
    }

    private static boolean I(byte b2) {
        return (b2 & 246) == 20;
    }

    private static boolean J(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    private static boolean K(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean L(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    private void M(byte b2, byte b3) {
        if (L(b2)) {
            this.f8834x = false;
        } else if (I(b2)) {
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
                                this.f8834x = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.f8834x = true;
        }
    }

    private void N() {
        this.f8824n.j(this.f8827q);
        this.f8823m.clear();
        this.f8823m.add(this.f8824n);
    }

    private void O(int i2) {
        int i3 = this.f8827q;
        if (i3 != i2) {
            this.f8827q = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.f8823m.size(); i4++) {
                    this.f8823m.get(i4).l(i2);
                }
                return;
            }
            N();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.f8825o = Collections.emptyList();
            }
        }
    }

    private void P(int i2) {
        this.f8828r = i2;
        this.f8824n.m(i2);
    }

    private boolean Q() {
        if (this.f8822l == -9223372036854775807L || this.f8835y == -9223372036854775807L || l() - this.f8835y < this.f8822l) {
            return false;
        }
        return true;
    }

    private boolean R(byte b2) {
        if (B(b2)) {
            this.f8833w = s(b2);
        }
        if (this.f8833w == this.f8821k) {
            return true;
        }
        return false;
    }

    private static char r(byte b2) {
        return (char) C[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static int s(byte b2) {
        return (b2 >> 3) & 1;
    }

    private List<Cue> t() {
        int size = this.f8823m.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            Cue g2 = this.f8823m.get(i3).g(Integer.MIN_VALUE);
            arrayList.add(g2);
            if (g2 != null) {
                i2 = Math.min(i2, g2.f4566i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            Cue cue = (Cue) arrayList.get(i4);
            if (cue != null) {
                if (cue.f4566i != i2) {
                    cue = (Cue) Assertions.f(this.f8823m.get(i4).g(i2));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    private static char u(byte b2) {
        return (char) E[b2 & 31];
    }

    private static char v(byte b2) {
        return (char) F[b2 & 31];
    }

    private static char w(byte b2, byte b3) {
        if ((b2 & 1) == 0) {
            return u(b3);
        }
        return v(b3);
    }

    private static char x(byte b2) {
        return (char) D[b2 & 15];
    }

    private void y(byte b2) {
        boolean z2;
        this.f8824n.e(' ');
        if ((b2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f8824n.p((b2 >> 1) & 7, z2);
    }

    private void z(byte b2) {
        if (b2 == 32) {
            O(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    O(1);
                    P(2);
                    return;
                case 38:
                    O(1);
                    P(3);
                    return;
                case 39:
                    O(1);
                    P(4);
                    return;
                default:
                    int i2 = this.f8827q;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.f8825o = Collections.emptyList();
                                    int i3 = this.f8827q;
                                    if (i3 == 1 || i3 == 3) {
                                        N();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i2 == 1 && !this.f8824n.i()) {
                                        this.f8824n.k();
                                        return;
                                    }
                                    return;
                                case 46:
                                    N();
                                    return;
                                case 47:
                                    this.f8825o = t();
                                    N();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.f8824n.f();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            O(3);
        }
    }

    public /* bridge */ /* synthetic */ void b(long j2) {
        super.b(j2);
    }

    public void flush() {
        super.flush();
        this.f8825o = null;
        this.f8826p = null;
        O(0);
        P(4);
        N();
        this.f8829s = false;
        this.f8830t = false;
        this.f8831u = 0;
        this.f8832v = 0;
        this.f8833w = 0;
        this.f8834x = true;
        this.f8835y = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public Subtitle g() {
        List<Cue> list = this.f8825o;
        this.f8826p = list;
        return new CeaSubtitle((List) Assertions.f(list));
    }

    public String getName() {
        return "Cea608Decoder";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0017 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(androidx.media3.extractor.text.SubtitleInputBuffer r10) {
        /*
            r9 = this;
            java.nio.ByteBuffer r10 = r10.f5067d
            java.lang.Object r10 = androidx.media3.common.util.Assertions.f(r10)
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            androidx.media3.common.util.ParsableByteArray r0 = r9.f8818h
            byte[] r1 = r10.array()
            int r10 = r10.limit()
            r0.S(r1, r10)
            r10 = 0
            r0 = 0
        L_0x0017:
            androidx.media3.common.util.ParsableByteArray r1 = r9.f8818h
            int r1 = r1.a()
            int r2 = r9.f8819i
            r3 = 1
            if (r1 < r2) goto L_0x00f5
            r1 = 2
            if (r2 != r1) goto L_0x0027
            r1 = -4
            goto L_0x002d
        L_0x0027:
            androidx.media3.common.util.ParsableByteArray r1 = r9.f8818h
            int r1 = r1.H()
        L_0x002d:
            androidx.media3.common.util.ParsableByteArray r2 = r9.f8818h
            int r2 = r2.H()
            androidx.media3.common.util.ParsableByteArray r4 = r9.f8818h
            int r4 = r4.H()
            r5 = r1 & 2
            if (r5 == 0) goto L_0x003e
            goto L_0x0017
        L_0x003e:
            r5 = r1 & 1
            int r6 = r9.f8820j
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
            boolean r7 = r9.f8829s
            r1 = r1 & 4
            r8 = 4
            if (r1 != r8) goto L_0x0063
            boolean[] r1 = G
            boolean r2 = r1[r2]
            if (r2 == 0) goto L_0x0063
            boolean r1 = r1[r4]
            if (r1 == 0) goto L_0x0063
            r1 = 1
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            r9.f8829s = r1
            boolean r1 = r9.H(r1, r5, r6)
            if (r1 == 0) goto L_0x006d
            goto L_0x0017
        L_0x006d:
            boolean r1 = r9.f8829s
            if (r1 != 0) goto L_0x0078
            if (r7 == 0) goto L_0x0017
            r9.N()
        L_0x0076:
            r0 = 1
            goto L_0x0017
        L_0x0078:
            r9.M(r5, r6)
            boolean r1 = r9.f8834x
            if (r1 != 0) goto L_0x0080
            goto L_0x0017
        L_0x0080:
            boolean r1 = r9.R(r5)
            if (r1 != 0) goto L_0x0087
            goto L_0x0017
        L_0x0087:
            boolean r0 = B(r5)
            if (r0 == 0) goto L_0x00de
            boolean r0 = J(r5, r6)
            if (r0 == 0) goto L_0x009d
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.f8824n
            char r1 = x(r6)
            r0.e(r1)
            goto L_0x0076
        L_0x009d:
            boolean r0 = C(r5, r6)
            if (r0 == 0) goto L_0x00b2
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.f8824n
            r0.f()
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.f8824n
            char r1 = w(r5, r6)
            r0.e(r1)
            goto L_0x0076
        L_0x00b2:
            boolean r0 = D(r5, r6)
            if (r0 == 0) goto L_0x00bc
            r9.y(r6)
            goto L_0x0076
        L_0x00bc:
            boolean r0 = F(r5, r6)
            if (r0 == 0) goto L_0x00c6
            r9.A(r5, r6)
            goto L_0x0076
        L_0x00c6:
            boolean r0 = K(r5, r6)
            if (r0 == 0) goto L_0x00d4
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.f8824n
            int r6 = r6 + -32
            int unused = r0.f8841f = r6
            goto L_0x0076
        L_0x00d4:
            boolean r0 = E(r5, r6)
            if (r0 == 0) goto L_0x0076
            r9.z(r6)
            goto L_0x0076
        L_0x00de:
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.f8824n
            char r1 = r(r5)
            r0.e(r1)
            r0 = r6 & 224(0xe0, float:3.14E-43)
            if (r0 == 0) goto L_0x0076
            androidx.media3.extractor.text.cea.Cea608Decoder$CueBuilder r0 = r9.f8824n
            char r1 = r(r6)
            r0.e(r1)
            goto L_0x0076
        L_0x00f5:
            if (r0 == 0) goto L_0x010a
            int r10 = r9.f8827q
            if (r10 == r3) goto L_0x00fe
            r0 = 3
            if (r10 != r0) goto L_0x010a
        L_0x00fe:
            java.util.List r10 = r9.t()
            r9.f8825o = r10
            long r0 = r9.l()
            r9.f8835y = r0
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea608Decoder.h(androidx.media3.extractor.text.SubtitleInputBuffer):void");
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer i() throws SubtitleDecoderException {
        return super.d();
    }

    /* renamed from: j */
    public SubtitleOutputBuffer a() throws SubtitleDecoderException {
        SubtitleOutputBuffer k2;
        SubtitleOutputBuffer j2 = super.a();
        if (j2 != null) {
            return j2;
        }
        if (!Q() || (k2 = k()) == null) {
            return null;
        }
        this.f8825o = Collections.emptyList();
        this.f8835y = -9223372036854775807L;
        SubtitleOutputBuffer subtitleOutputBuffer = k2;
        subtitleOutputBuffer.e(l(), g(), Clock.MAX_TIME);
        return k2;
    }

    /* access modifiers changed from: protected */
    public boolean m() {
        return this.f8825o != this.f8826p;
    }

    public /* bridge */ /* synthetic */ void n(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.c(subtitleInputBuffer);
    }

    public void release() {
    }
}
