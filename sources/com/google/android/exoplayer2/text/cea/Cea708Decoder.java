package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Cea708Decoder extends CeaDecoder {

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f27310g = new ParsableByteArray();

    /* renamed from: h  reason: collision with root package name */
    private final ParsableBitArray f27311h = new ParsableBitArray();

    /* renamed from: i  reason: collision with root package name */
    private int f27312i = -1;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f27313j;

    /* renamed from: k  reason: collision with root package name */
    private final int f27314k;

    /* renamed from: l  reason: collision with root package name */
    private final CueInfoBuilder[] f27315l;

    /* renamed from: m  reason: collision with root package name */
    private CueInfoBuilder f27316m;

    /* renamed from: n  reason: collision with root package name */
    private List<Cue> f27317n;

    /* renamed from: o  reason: collision with root package name */
    private List<Cue> f27318o;

    /* renamed from: p  reason: collision with root package name */
    private DtvCcPacket f27319p;

    /* renamed from: q  reason: collision with root package name */
    private int f27320q;

    private static final class Cea708CueInfo {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<Cea708CueInfo> f27321c = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Cue f27322a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27323b;

        public Cea708CueInfo(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z2, int i5, int i6) {
            Cue.Builder n2 = new Cue.Builder().o(charSequence).p(alignment).h(f2, i2).i(i3).k(f3).l(i4).n(f4);
            if (z2) {
                n2.s(i5);
            }
            this.f27322a = n2.a();
            this.f27323b = i6;
        }
    }

    private static final class CueInfoBuilder {
        private static final int[] A = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] B = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] C = {false, false, false, true, true, true, false};
        private static final int[] D;
        private static final int[] E = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] F = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] G;

        /* renamed from: w  reason: collision with root package name */
        public static final int f27324w = h(2, 2, 2, 0);

        /* renamed from: x  reason: collision with root package name */
        public static final int f27325x;

        /* renamed from: y  reason: collision with root package name */
        public static final int f27326y;

        /* renamed from: z  reason: collision with root package name */
        private static final int[] f27327z = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: a  reason: collision with root package name */
        private final List<SpannableString> f27328a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final SpannableStringBuilder f27329b = new SpannableStringBuilder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f27330c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27331d;

        /* renamed from: e  reason: collision with root package name */
        private int f27332e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27333f;

        /* renamed from: g  reason: collision with root package name */
        private int f27334g;

        /* renamed from: h  reason: collision with root package name */
        private int f27335h;

        /* renamed from: i  reason: collision with root package name */
        private int f27336i;

        /* renamed from: j  reason: collision with root package name */
        private int f27337j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f27338k;

        /* renamed from: l  reason: collision with root package name */
        private int f27339l;

        /* renamed from: m  reason: collision with root package name */
        private int f27340m;

        /* renamed from: n  reason: collision with root package name */
        private int f27341n;

        /* renamed from: o  reason: collision with root package name */
        private int f27342o;

        /* renamed from: p  reason: collision with root package name */
        private int f27343p;

        /* renamed from: q  reason: collision with root package name */
        private int f27344q;

        /* renamed from: r  reason: collision with root package name */
        private int f27345r;

        /* renamed from: s  reason: collision with root package name */
        private int f27346s;

        /* renamed from: t  reason: collision with root package name */
        private int f27347t;

        /* renamed from: u  reason: collision with root package name */
        private int f27348u;

        /* renamed from: v  reason: collision with root package name */
        private int f27349v;

        static {
            int h2 = h(0, 0, 0, 0);
            f27325x = h2;
            int h3 = h(0, 0, 0, 3);
            f27326y = h3;
            D = new int[]{h2, h3, h2, h2, h3, h2, h2};
            G = new int[]{h2, h2, h2, h2, h2, h3, h3};
        }

        public CueInfoBuilder() {
            l();
        }

        public static int g(int i2, int i3, int i4) {
            return h(i2, i3, i4, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.Assertions.c(r4, r0, r1)
                com.google.android.exoplayer2.util.Assertions.c(r5, r0, r1)
                com.google.android.exoplayer2.util.Assertions.c(r6, r0, r1)
                com.google.android.exoplayer2.util.Assertions.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = 0
                goto L_0x0023
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0023
            L_0x0021:
                r7 = 255(0xff, float:3.57E-43)
            L_0x0023:
                if (r4 <= r1) goto L_0x0028
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r5 <= r1) goto L_0x002e
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002f
            L_0x002e:
                r5 = 0
            L_0x002f:
                if (r6 <= r1) goto L_0x0033
                r0 = 255(0xff, float:3.57E-43)
            L_0x0033:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.h(int, int, int, int):int");
        }

        public void a(char c2) {
            if (c2 == 10) {
                this.f27328a.add(d());
                this.f27329b.clear();
                if (this.f27343p != -1) {
                    this.f27343p = 0;
                }
                if (this.f27344q != -1) {
                    this.f27344q = 0;
                }
                if (this.f27345r != -1) {
                    this.f27345r = 0;
                }
                if (this.f27347t != -1) {
                    this.f27347t = 0;
                }
                while (true) {
                    if ((this.f27338k && this.f27328a.size() >= this.f27337j) || this.f27328a.size() >= 15) {
                        this.f27328a.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.f27329b.append(c2);
            }
        }

        public void b() {
            int length = this.f27329b.length();
            if (length > 0) {
                this.f27329b.delete(length - 1, length);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.text.cea.Cea708Decoder.Cea708CueInfo c() {
            /*
                r15 = this;
                boolean r0 = r15.j()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = 0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.f27328a
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.f27328a
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.d()
                r2.append(r1)
                int r1 = r15.f27339l
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005e
                if (r1 == r5) goto L_0x005b
                if (r1 == r3) goto L_0x0058
                if (r1 != r4) goto L_0x003f
                goto L_0x005e
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unexpected justification value: "
                r1.append(r2)
                int r2 = r15.f27339l
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0060
            L_0x005b:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0060
            L_0x005e:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0060:
                r6 = r1
                boolean r1 = r15.f27333f
                if (r1 == 0) goto L_0x0070
                int r1 = r15.f27335h
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.f27334g
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007d
            L_0x0070:
                int r1 = r15.f27335h
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.f27334g
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007d:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.f27336i
                int r8 = r1 / 3
                if (r8 != 0) goto L_0x0093
                r8 = 0
                goto L_0x009a
            L_0x0093:
                int r8 = r1 / 3
                if (r8 != r5) goto L_0x0099
                r8 = 1
                goto L_0x009a
            L_0x0099:
                r8 = 2
            L_0x009a:
                int r9 = r1 % 3
                if (r9 != 0) goto L_0x00a0
                r9 = 0
                goto L_0x00a6
            L_0x00a0:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x00a5
                r9 = 1
                goto L_0x00a6
            L_0x00a5:
                r9 = 2
            L_0x00a6:
                int r1 = r15.f27342o
                int r3 = f27325x
                if (r1 == r3) goto L_0x00ad
                r0 = 1
            L_0x00ad:
                com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo r13 = new com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo
                r5 = 0
                r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                int r12 = r15.f27342o
                int r14 = r15.f27332e
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r11
                r10 = r0
                r11 = r12
                r12 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.CueInfoBuilder.c():com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f27329b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f27343p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f27343p, length, 33);
                }
                if (this.f27344q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f27344q, length, 33);
                }
                if (this.f27345r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f27346s), this.f27345r, length, 33);
                }
                if (this.f27347t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f27348u), this.f27347t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f27328a.clear();
            this.f27329b.clear();
            this.f27343p = -1;
            this.f27344q = -1;
            this.f27345r = -1;
            this.f27347t = -1;
            this.f27349v = 0;
        }

        public void f(boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            boolean z6 = z3;
            int i10 = i8;
            int i11 = i9;
            this.f27330c = true;
            this.f27331d = z2;
            this.f27338k = z6;
            this.f27332e = i2;
            this.f27333f = z5;
            this.f27334g = i3;
            this.f27335h = i4;
            this.f27336i = i7;
            int i12 = i5 + 1;
            if (this.f27337j != i12) {
                this.f27337j = i12;
                while (true) {
                    if ((!z6 || this.f27328a.size() < this.f27337j) && this.f27328a.size() < 15) {
                        break;
                    }
                    this.f27328a.remove(0);
                }
            }
            if (!(i10 == 0 || this.f27340m == i10)) {
                this.f27340m = i10;
                int i13 = i10 - 1;
                q(D[i13], f27326y, C[i13], 0, A[i13], B[i13], f27327z[i13]);
            }
            if (i11 != 0 && this.f27341n != i11) {
                this.f27341n = i11;
                int i14 = i11 - 1;
                m(0, 1, 1, false, false, F[i14], E[i14]);
                n(f27324w, G[i14], f27325x);
            }
        }

        public boolean i() {
            return this.f27330c;
        }

        public boolean j() {
            return !i() || (this.f27328a.isEmpty() && this.f27329b.length() == 0);
        }

        public boolean k() {
            return this.f27331d;
        }

        public void l() {
            e();
            this.f27330c = false;
            this.f27331d = false;
            this.f27332e = 4;
            this.f27333f = false;
            this.f27334g = 0;
            this.f27335h = 0;
            this.f27336i = 0;
            this.f27337j = 15;
            this.f27338k = true;
            this.f27339l = 0;
            this.f27340m = 0;
            this.f27341n = 0;
            int i2 = f27325x;
            this.f27342o = i2;
            this.f27346s = f27324w;
            this.f27348u = i2;
        }

        public void m(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            if (this.f27343p != -1) {
                if (!z2) {
                    this.f27329b.setSpan(new StyleSpan(2), this.f27343p, this.f27329b.length(), 33);
                    this.f27343p = -1;
                }
            } else if (z2) {
                this.f27343p = this.f27329b.length();
            }
            if (this.f27344q != -1) {
                if (!z3) {
                    this.f27329b.setSpan(new UnderlineSpan(), this.f27344q, this.f27329b.length(), 33);
                    this.f27344q = -1;
                }
            } else if (z3) {
                this.f27344q = this.f27329b.length();
            }
        }

        public void n(int i2, int i3, int i4) {
            if (!(this.f27345r == -1 || this.f27346s == i2)) {
                this.f27329b.setSpan(new ForegroundColorSpan(this.f27346s), this.f27345r, this.f27329b.length(), 33);
            }
            if (i2 != f27324w) {
                this.f27345r = this.f27329b.length();
                this.f27346s = i2;
            }
            if (!(this.f27347t == -1 || this.f27348u == i3)) {
                this.f27329b.setSpan(new BackgroundColorSpan(this.f27348u), this.f27347t, this.f27329b.length(), 33);
            }
            if (i3 != f27325x) {
                this.f27347t = this.f27329b.length();
                this.f27348u = i3;
            }
        }

        public void o(int i2, int i3) {
            if (this.f27349v != i2) {
                a(10);
            }
            this.f27349v = i2;
        }

        public void p(boolean z2) {
            this.f27331d = z2;
        }

        public void q(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            this.f27342o = i2;
            this.f27339l = i7;
        }
    }

    private static final class DtvCcPacket {

        /* renamed from: a  reason: collision with root package name */
        public final int f27350a;

        /* renamed from: b  reason: collision with root package name */
        public final int f27351b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f27352c;

        /* renamed from: d  reason: collision with root package name */
        int f27353d = 0;

        public DtvCcPacket(int i2, int i3) {
            this.f27350a = i2;
            this.f27351b = i3;
            this.f27352c = new byte[((i3 * 2) - 1)];
        }
    }

    public Cea708Decoder(int i2, List<byte[]> list) {
        boolean z2 = true;
        this.f27314k = i2 == -1 ? 1 : i2;
        this.f27313j = (list == null || !CodecSpecificDataUtil.i(list)) ? false : z2;
        this.f27315l = new CueInfoBuilder[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f27315l[i3] = new CueInfoBuilder();
        }
        this.f27316m = this.f27315l[0];
    }

    private void A() {
        int h2 = CueInfoBuilder.h(this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2));
        int h3 = CueInfoBuilder.h(this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2));
        this.f27311h.r(2);
        this.f27316m.n(h2, h3, CueInfoBuilder.g(this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2)));
    }

    private void B() {
        this.f27311h.r(4);
        int h2 = this.f27311h.h(4);
        this.f27311h.r(2);
        this.f27316m.o(h2, this.f27311h.h(6));
    }

    private void C() {
        int h2 = CueInfoBuilder.h(this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2));
        int h3 = this.f27311h.h(2);
        int g2 = CueInfoBuilder.g(this.f27311h.h(2), this.f27311h.h(2), this.f27311h.h(2));
        if (this.f27311h.g()) {
            h3 |= 4;
        }
        boolean g3 = this.f27311h.g();
        int h4 = this.f27311h.h(2);
        int h5 = this.f27311h.h(2);
        int h6 = this.f27311h.h(2);
        this.f27311h.r(8);
        this.f27316m.q(h2, g2, g3, h3, h4, h5, h6);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    private void D() {
        DtvCcPacket dtvCcPacket = this.f27319p;
        if (dtvCcPacket.f27353d != (dtvCcPacket.f27351b * 2) - 1) {
            Log.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f27319p.f27351b * 2) - 1) + ", but current index is " + this.f27319p.f27353d + " (sequence number " + this.f27319p.f27350a + ");");
        }
        ParsableBitArray parsableBitArray = this.f27311h;
        DtvCcPacket dtvCcPacket2 = this.f27319p;
        parsableBitArray.o(dtvCcPacket2.f27352c, dtvCcPacket2.f27353d);
        boolean z2 = false;
        while (true) {
            if (this.f27311h.b() <= 0) {
                break;
            }
            int h2 = this.f27311h.h(3);
            int h3 = this.f27311h.h(5);
            if (h2 == 7) {
                this.f27311h.r(2);
                h2 = this.f27311h.h(6);
                if (h2 < 7) {
                    Log.i("Cea708Decoder", "Invalid extended service number: " + h2);
                }
            }
            if (h3 == 0) {
                if (h2 != 0) {
                    Log.i("Cea708Decoder", "serviceNumber is non-zero (" + h2 + ") when blockSize is 0");
                }
            } else if (h2 != this.f27314k) {
                this.f27311h.s(h3);
            } else {
                int e2 = this.f27311h.e() + (h3 * 8);
                while (this.f27311h.e() < e2) {
                    int h4 = this.f27311h.h(8);
                    if (h4 == 16) {
                        int h5 = this.f27311h.h(8);
                        if (h5 <= 31) {
                            s(h5);
                        } else if (h5 <= 127) {
                            x(h5);
                        } else if (h5 <= 159) {
                            t(h5);
                        } else if (h5 <= 255) {
                            y(h5);
                        } else {
                            Log.i("Cea708Decoder", "Invalid extended command: " + h5);
                        }
                    } else if (h4 <= 31) {
                        q(h4);
                    } else if (h4 <= 127) {
                        v(h4);
                    } else if (h4 <= 159) {
                        r(h4);
                    } else if (h4 <= 255) {
                        w(h4);
                    } else {
                        Log.i("Cea708Decoder", "Invalid base command: " + h4);
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            this.f27317n = p();
        }
    }

    private void E() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f27315l[i2].l();
        }
    }

    private void o() {
        if (this.f27319p != null) {
            D();
            this.f27319p = null;
        }
    }

    private List<Cue> p() {
        Cea708CueInfo c2;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f27315l[i2].j() && this.f27315l[i2].k() && (c2 = this.f27315l[i2].c()) != null) {
                arrayList.add(c2);
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.f27321c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(((Cea708CueInfo) arrayList.get(i3)).f27322a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void q(int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 == 3) {
            this.f27317n = p();
        } else if (i2 != 8) {
            switch (i2) {
                case 12:
                    E();
                    return;
                case 13:
                    this.f27316m.a(10);
                    return;
                case 14:
                    return;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        Log.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i2);
                        this.f27311h.r(8);
                        return;
                    } else if (i2 < 24 || i2 > 31) {
                        Log.i("Cea708Decoder", "Invalid C0 command: " + i2);
                        return;
                    } else {
                        Log.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i2);
                        this.f27311h.r(16);
                        return;
                    }
            }
        } else {
            this.f27316m.b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        if (r4.f27311h.g() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        r4.f27315l[8 - r2].l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r4.f27311h.g() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r4.f27315l[8 - r2].p(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d9, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r4.f27311h.g() == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r4.f27315l[8 - r2].e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0106, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x0109;
                case 129: goto L_0x0109;
                case 130: goto L_0x0109;
                case 131: goto L_0x0109;
                case 132: goto L_0x0109;
                case 133: goto L_0x0109;
                case 134: goto L_0x0109;
                case 135: goto L_0x0109;
                case 136: goto L_0x00f3;
                case 137: goto L_0x00dc;
                case 138: goto L_0x00c5;
                case 139: goto L_0x00a9;
                case 140: goto L_0x0093;
                case 141: goto L_0x008c;
                case 142: goto L_0x0117;
                case 143: goto L_0x0087;
                case 144: goto L_0x0073;
                case 145: goto L_0x005d;
                case 146: goto L_0x0049;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0033;
                case 152: goto L_0x0020;
                case 153: goto L_0x0020;
                case 154: goto L_0x0020;
                case 155: goto L_0x0020;
                case 156: goto L_0x0020;
                case 157: goto L_0x0020;
                case 158: goto L_0x0020;
                case 159: goto L_0x0020;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid C1 command: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Cea708Decoder"
            com.google.android.exoplayer2.util.Log.i(r0, r5)
            goto L_0x0117
        L_0x0020:
            int r5 = r5 + -152
            r4.u(r5)
            int r0 = r4.f27320q
            if (r0 == r5) goto L_0x0117
            r4.f27320q = r5
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f27315l
            r5 = r0[r5]
            r4.f27316m = r5
            goto L_0x0117
        L_0x0033:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f27316m
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0044
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            r0 = 32
            r5.r(r0)
            goto L_0x0117
        L_0x0044:
            r4.C()
            goto L_0x0117
        L_0x0049:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f27316m
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0058
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            r5.r(r0)
            goto L_0x0117
        L_0x0058:
            r4.B()
            goto L_0x0117
        L_0x005d:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f27316m
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x006e
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            r0 = 24
            r5.r(r0)
            goto L_0x0117
        L_0x006e:
            r4.A()
            goto L_0x0117
        L_0x0073:
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f27316m
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0082
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            r5.r(r0)
            goto L_0x0117
        L_0x0082:
            r4.z()
            goto L_0x0117
        L_0x0087:
            r4.E()
            goto L_0x0117
        L_0x008c:
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            r5.r(r1)
            goto L_0x0117
        L_0x0093:
            if (r2 > r1) goto L_0x0117
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x00a6
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f27315l
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.l()
        L_0x00a6:
            int r2 = r2 + 1
            goto L_0x0093
        L_0x00a9:
            r5 = 1
        L_0x00aa:
            if (r5 > r1) goto L_0x0117
            com.google.android.exoplayer2.util.ParsableBitArray r0 = r4.f27311h
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00c2
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f27315l
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.k()
            r3 = r3 ^ r2
            r0.p(r3)
        L_0x00c2:
            int r5 = r5 + 1
            goto L_0x00aa
        L_0x00c5:
            if (r2 > r1) goto L_0x0117
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x00d9
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f27315l
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.p(r0)
        L_0x00d9:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00dc:
            r5 = 1
        L_0x00dd:
            if (r5 > r1) goto L_0x0117
            com.google.android.exoplayer2.util.ParsableBitArray r0 = r4.f27311h
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00f0
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f27315l
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.p(r2)
        L_0x00f0:
            int r5 = r5 + 1
            goto L_0x00dd
        L_0x00f3:
            if (r2 > r1) goto L_0x0117
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r4.f27311h
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0106
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f27315l
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.e()
        L_0x0106:
            int r2 = r2 + 1
            goto L_0x00f3
        L_0x0109:
            int r5 = r5 + -128
            int r0 = r4.f27320q
            if (r0 == r5) goto L_0x0117
            r4.f27320q = r5
            com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f27315l
            r5 = r0[r5]
            r4.f27316m = r5
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea708Decoder.r(int):void");
    }

    private void s(int i2) {
        if (i2 > 7) {
            if (i2 <= 15) {
                this.f27311h.r(8);
            } else if (i2 <= 23) {
                this.f27311h.r(16);
            } else if (i2 <= 31) {
                this.f27311h.r(24);
            }
        }
    }

    private void t(int i2) {
        if (i2 <= 135) {
            this.f27311h.r(32);
        } else if (i2 <= 143) {
            this.f27311h.r(40);
        } else if (i2 <= 159) {
            this.f27311h.r(2);
            this.f27311h.r(this.f27311h.h(6) * 8);
        }
    }

    private void u(int i2) {
        CueInfoBuilder cueInfoBuilder = this.f27315l[i2];
        this.f27311h.r(2);
        boolean g2 = this.f27311h.g();
        boolean g3 = this.f27311h.g();
        boolean g4 = this.f27311h.g();
        int h2 = this.f27311h.h(3);
        boolean g5 = this.f27311h.g();
        int h3 = this.f27311h.h(7);
        int h4 = this.f27311h.h(8);
        int h5 = this.f27311h.h(4);
        int h6 = this.f27311h.h(4);
        this.f27311h.r(2);
        int h7 = this.f27311h.h(6);
        this.f27311h.r(2);
        cueInfoBuilder.f(g2, g3, g4, h2, g5, h3, h4, h6, h7, h5, this.f27311h.h(3), this.f27311h.h(3));
    }

    private void v(int i2) {
        if (i2 == 127) {
            this.f27316m.a(9835);
        } else {
            this.f27316m.a((char) (i2 & JfifUtil.MARKER_FIRST_BYTE));
        }
    }

    private void w(int i2) {
        this.f27316m.a((char) (i2 & JfifUtil.MARKER_FIRST_BYTE));
    }

    private void x(int i2) {
        if (i2 == 32) {
            this.f27316m.a(' ');
        } else if (i2 == 33) {
            this.f27316m.a(160);
        } else if (i2 == 37) {
            this.f27316m.a(8230);
        } else if (i2 == 42) {
            this.f27316m.a(352);
        } else if (i2 == 44) {
            this.f27316m.a(338);
        } else if (i2 == 63) {
            this.f27316m.a(376);
        } else if (i2 == 57) {
            this.f27316m.a(8482);
        } else if (i2 == 58) {
            this.f27316m.a(353);
        } else if (i2 == 60) {
            this.f27316m.a(339);
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    this.f27316m.a(9608);
                    return;
                case 49:
                    this.f27316m.a(8216);
                    return;
                case 50:
                    this.f27316m.a(8217);
                    return;
                case 51:
                    this.f27316m.a(8220);
                    return;
                case 52:
                    this.f27316m.a(8221);
                    return;
                case 53:
                    this.f27316m.a(8226);
                    return;
                default:
                    switch (i2) {
                        case 118:
                            this.f27316m.a(8539);
                            return;
                        case 119:
                            this.f27316m.a(8540);
                            return;
                        case 120:
                            this.f27316m.a(8541);
                            return;
                        case 121:
                            this.f27316m.a(8542);
                            return;
                        case 122:
                            this.f27316m.a(9474);
                            return;
                        case 123:
                            this.f27316m.a(9488);
                            return;
                        case 124:
                            this.f27316m.a(9492);
                            return;
                        case 125:
                            this.f27316m.a(9472);
                            return;
                        case 126:
                            this.f27316m.a(9496);
                            return;
                        case 127:
                            this.f27316m.a(9484);
                            return;
                        default:
                            Log.i("Cea708Decoder", "Invalid G2 character: " + i2);
                            return;
                    }
            }
        } else {
            this.f27316m.a(8480);
        }
    }

    private void y(int i2) {
        if (i2 == 160) {
            this.f27316m.a(13252);
            return;
        }
        Log.i("Cea708Decoder", "Invalid G3 character: " + i2);
        this.f27316m.a('_');
    }

    private void z() {
        this.f27316m.m(this.f27311h.h(4), this.f27311h.h(2), this.f27311h.h(2), this.f27311h.g(), this.f27311h.g(), this.f27311h.h(3), this.f27311h.h(3));
    }

    public /* bridge */ /* synthetic */ void b(long j2) {
        super.b(j2);
    }

    /* access modifiers changed from: protected */
    public Subtitle e() {
        List<Cue> list = this.f27317n;
        this.f27318o = list;
        return new CeaSubtitle((List) Assertions.e(list));
    }

    /* access modifiers changed from: protected */
    public void f(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(subtitleInputBuffer.f23961d);
        this.f27310g.S(byteBuffer.array(), byteBuffer.limit());
        while (this.f27310g.a() >= 3) {
            int H = this.f27310g.H() & 7;
            int i2 = H & 3;
            boolean z3 = false;
            if ((H & 4) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            byte H2 = (byte) this.f27310g.H();
            byte H3 = (byte) this.f27310g.H();
            if ((i2 == 2 || i2 == 3) && z2) {
                if (i2 == 3) {
                    o();
                    int i3 = (H2 & 192) >> 6;
                    int i4 = this.f27312i;
                    if (!(i4 == -1 || i3 == (i4 + 1) % 4)) {
                        E();
                        Log.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f27312i + " current=" + i3);
                    }
                    this.f27312i = i3;
                    byte b2 = H2 & 63;
                    if (b2 == 0) {
                        b2 = 64;
                    }
                    DtvCcPacket dtvCcPacket = new DtvCcPacket(i3, b2);
                    this.f27319p = dtvCcPacket;
                    byte[] bArr = dtvCcPacket.f27352c;
                    int i5 = dtvCcPacket.f27353d;
                    dtvCcPacket.f27353d = i5 + 1;
                    bArr[i5] = H3;
                } else {
                    if (i2 == 2) {
                        z3 = true;
                    }
                    Assertions.a(z3);
                    DtvCcPacket dtvCcPacket2 = this.f27319p;
                    if (dtvCcPacket2 == null) {
                        Log.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = dtvCcPacket2.f27352c;
                        int i6 = dtvCcPacket2.f27353d;
                        int i7 = i6 + 1;
                        bArr2[i6] = H2;
                        dtvCcPacket2.f27353d = i7 + 1;
                        bArr2[i7] = H3;
                    }
                }
                DtvCcPacket dtvCcPacket3 = this.f27319p;
                if (dtvCcPacket3.f27353d == (dtvCcPacket3.f27351b * 2) - 1) {
                    o();
                }
            }
        }
    }

    public void flush() {
        super.flush();
        this.f27317n = null;
        this.f27318o = null;
        this.f27320q = 0;
        this.f27316m = this.f27315l[0];
        E();
        this.f27319p = null;
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer g() throws SubtitleDecoderException {
        return super.d();
    }

    public /* bridge */ /* synthetic */ SubtitleOutputBuffer h() throws SubtitleDecoderException {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return this.f27317n != this.f27318o;
    }

    public /* bridge */ /* synthetic */ void l(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.c(subtitleInputBuffer);
    }

    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }
}
