package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Cea708Decoder extends CeaDecoder {

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f8847h = new ParsableByteArray();

    /* renamed from: i  reason: collision with root package name */
    private final ParsableBitArray f8848i = new ParsableBitArray();

    /* renamed from: j  reason: collision with root package name */
    private int f8849j = -1;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f8850k;

    /* renamed from: l  reason: collision with root package name */
    private final int f8851l;

    /* renamed from: m  reason: collision with root package name */
    private final CueInfoBuilder[] f8852m;

    /* renamed from: n  reason: collision with root package name */
    private CueInfoBuilder f8853n;

    /* renamed from: o  reason: collision with root package name */
    private List<Cue> f8854o;

    /* renamed from: p  reason: collision with root package name */
    private List<Cue> f8855p;

    /* renamed from: q  reason: collision with root package name */
    private DtvCcPacket f8856q;

    /* renamed from: r  reason: collision with root package name */
    private int f8857r;

    private static final class Cea708CueInfo {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<Cea708CueInfo> f8858c = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Cue f8859a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8860b;

        public Cea708CueInfo(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z2, int i5, int i6) {
            Cue.Builder n2 = new Cue.Builder().o(charSequence).p(alignment).h(f2, i2).i(i3).k(f3).l(i4).n(f4);
            if (z2) {
                n2.s(i5);
            }
            this.f8859a = n2.a();
            this.f8860b = i6;
        }
    }

    private static final class CueInfoBuilder {
        private static final int[] A = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] B = {false, false, false, true, true, true, false};
        private static final int[] C;
        private static final int[] D = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] E = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] F;

        /* renamed from: v  reason: collision with root package name */
        public static final int f8861v = h(2, 2, 2, 0);

        /* renamed from: w  reason: collision with root package name */
        public static final int f8862w;

        /* renamed from: x  reason: collision with root package name */
        public static final int f8863x;

        /* renamed from: y  reason: collision with root package name */
        private static final int[] f8864y = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: z  reason: collision with root package name */
        private static final int[] f8865z = {0, 0, 0, 0, 0, 0, 2};

        /* renamed from: a  reason: collision with root package name */
        private final List<SpannableString> f8866a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final SpannableStringBuilder f8867b = new SpannableStringBuilder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f8868c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8869d;

        /* renamed from: e  reason: collision with root package name */
        private int f8870e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f8871f;

        /* renamed from: g  reason: collision with root package name */
        private int f8872g;

        /* renamed from: h  reason: collision with root package name */
        private int f8873h;

        /* renamed from: i  reason: collision with root package name */
        private int f8874i;

        /* renamed from: j  reason: collision with root package name */
        private int f8875j;

        /* renamed from: k  reason: collision with root package name */
        private int f8876k;

        /* renamed from: l  reason: collision with root package name */
        private int f8877l;

        /* renamed from: m  reason: collision with root package name */
        private int f8878m;

        /* renamed from: n  reason: collision with root package name */
        private int f8879n;

        /* renamed from: o  reason: collision with root package name */
        private int f8880o;

        /* renamed from: p  reason: collision with root package name */
        private int f8881p;

        /* renamed from: q  reason: collision with root package name */
        private int f8882q;

        /* renamed from: r  reason: collision with root package name */
        private int f8883r;

        /* renamed from: s  reason: collision with root package name */
        private int f8884s;

        /* renamed from: t  reason: collision with root package name */
        private int f8885t;

        /* renamed from: u  reason: collision with root package name */
        private int f8886u;

        static {
            int h2 = h(0, 0, 0, 0);
            f8862w = h2;
            int h3 = h(0, 0, 0, 3);
            f8863x = h3;
            C = new int[]{h2, h3, h2, h2, h3, h2, h2};
            F = new int[]{h2, h2, h2, h2, h2, h3, h3};
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
                androidx.media3.common.util.Assertions.c(r4, r0, r1)
                androidx.media3.common.util.Assertions.c(r5, r0, r1)
                androidx.media3.common.util.Assertions.c(r6, r0, r1)
                androidx.media3.common.util.Assertions.c(r7, r0, r1)
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.CueInfoBuilder.h(int, int, int, int):int");
        }

        public void a(char c2) {
            if (c2 == 10) {
                this.f8866a.add(d());
                this.f8867b.clear();
                if (this.f8880o != -1) {
                    this.f8880o = 0;
                }
                if (this.f8881p != -1) {
                    this.f8881p = 0;
                }
                if (this.f8882q != -1) {
                    this.f8882q = 0;
                }
                if (this.f8884s != -1) {
                    this.f8884s = 0;
                }
                while (true) {
                    if (this.f8866a.size() >= this.f8875j || this.f8866a.size() >= 15) {
                        this.f8866a.remove(0);
                    } else {
                        this.f8886u = this.f8866a.size();
                        return;
                    }
                }
            } else {
                this.f8867b.append(c2);
            }
        }

        public void b() {
            int length = this.f8867b.length();
            if (length > 0) {
                this.f8867b.delete(length - 1, length);
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
        public androidx.media3.extractor.text.cea.Cea708Decoder.Cea708CueInfo c() {
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
                java.util.List<android.text.SpannableString> r3 = r15.f8866a
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.f8866a
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
                int r1 = r15.f8876k
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
                int r2 = r15.f8876k
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
                boolean r1 = r15.f8871f
                if (r1 == 0) goto L_0x0070
                int r1 = r15.f8873h
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.f8872g
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007d
            L_0x0070:
                int r1 = r15.f8873h
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.f8872g
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
                int r1 = r15.f8874i
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
                int r1 = r15.f8879n
                int r3 = f8862w
                if (r1 == r3) goto L_0x00ad
                r0 = 1
            L_0x00ad:
                androidx.media3.extractor.text.cea.Cea708Decoder$Cea708CueInfo r13 = new androidx.media3.extractor.text.cea.Cea708Decoder$Cea708CueInfo
                r5 = 0
                r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                int r12 = r15.f8879n
                int r14 = r15.f8870e
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.CueInfoBuilder.c():androidx.media3.extractor.text.cea.Cea708Decoder$Cea708CueInfo");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f8867b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f8880o != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f8880o, length, 33);
                }
                if (this.f8881p != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f8881p, length, 33);
                }
                if (this.f8882q != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f8883r), this.f8882q, length, 33);
                }
                if (this.f8884s != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f8885t), this.f8884s, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f8866a.clear();
            this.f8867b.clear();
            this.f8880o = -1;
            this.f8881p = -1;
            this.f8882q = -1;
            this.f8884s = -1;
            this.f8886u = 0;
        }

        public void f(boolean z2, int i2, boolean z3, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i7;
            int i10 = i8;
            this.f8868c = true;
            this.f8869d = z2;
            this.f8870e = i2;
            this.f8871f = z3;
            this.f8872g = i3;
            this.f8873h = i4;
            this.f8874i = i6;
            int i11 = i5 + 1;
            if (this.f8875j != i11) {
                this.f8875j = i11;
                while (true) {
                    if (this.f8866a.size() < this.f8875j && this.f8866a.size() < 15) {
                        break;
                    }
                    this.f8866a.remove(0);
                }
            }
            if (!(i9 == 0 || this.f8877l == i9)) {
                this.f8877l = i9;
                int i12 = i9 - 1;
                q(C[i12], f8863x, B[i12], 0, f8865z[i12], A[i12], f8864y[i12]);
            }
            if (i10 != 0 && this.f8878m != i10) {
                this.f8878m = i10;
                int i13 = i10 - 1;
                m(0, 1, 1, false, false, E[i13], D[i13]);
                n(f8861v, F[i13], f8862w);
            }
        }

        public boolean i() {
            return this.f8868c;
        }

        public boolean j() {
            return !i() || (this.f8866a.isEmpty() && this.f8867b.length() == 0);
        }

        public boolean k() {
            return this.f8869d;
        }

        public void l() {
            e();
            this.f8868c = false;
            this.f8869d = false;
            this.f8870e = 4;
            this.f8871f = false;
            this.f8872g = 0;
            this.f8873h = 0;
            this.f8874i = 0;
            this.f8875j = 15;
            this.f8876k = 0;
            this.f8877l = 0;
            this.f8878m = 0;
            int i2 = f8862w;
            this.f8879n = i2;
            this.f8883r = f8861v;
            this.f8885t = i2;
        }

        public void m(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            if (this.f8880o != -1) {
                if (!z2) {
                    this.f8867b.setSpan(new StyleSpan(2), this.f8880o, this.f8867b.length(), 33);
                    this.f8880o = -1;
                }
            } else if (z2) {
                this.f8880o = this.f8867b.length();
            }
            if (this.f8881p != -1) {
                if (!z3) {
                    this.f8867b.setSpan(new UnderlineSpan(), this.f8881p, this.f8867b.length(), 33);
                    this.f8881p = -1;
                }
            } else if (z3) {
                this.f8881p = this.f8867b.length();
            }
        }

        public void n(int i2, int i3, int i4) {
            if (!(this.f8882q == -1 || this.f8883r == i2)) {
                this.f8867b.setSpan(new ForegroundColorSpan(this.f8883r), this.f8882q, this.f8867b.length(), 33);
            }
            if (i2 != f8861v) {
                this.f8882q = this.f8867b.length();
                this.f8883r = i2;
            }
            if (!(this.f8884s == -1 || this.f8885t == i3)) {
                this.f8867b.setSpan(new BackgroundColorSpan(this.f8885t), this.f8884s, this.f8867b.length(), 33);
            }
            if (i3 != f8862w) {
                this.f8884s = this.f8867b.length();
                this.f8885t = i3;
            }
        }

        public void o(int i2, int i3) {
            if (this.f8886u != i2) {
                a(10);
            }
            this.f8886u = i2;
        }

        public void p(boolean z2) {
            this.f8869d = z2;
        }

        public void q(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            this.f8879n = i2;
            this.f8876k = i7;
        }
    }

    private static final class DtvCcPacket {

        /* renamed from: a  reason: collision with root package name */
        public final int f8887a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8888b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f8889c;

        /* renamed from: d  reason: collision with root package name */
        int f8890d = 0;

        public DtvCcPacket(int i2, int i3) {
            this.f8887a = i2;
            this.f8888b = i3;
            this.f8889c = new byte[((i3 * 2) - 1)];
        }
    }

    public Cea708Decoder(int i2, List<byte[]> list) {
        boolean z2 = true;
        this.f8851l = i2 == -1 ? 1 : i2;
        this.f8850k = (list == null || !CodecSpecificDataUtil.f(list)) ? false : z2;
        this.f8852m = new CueInfoBuilder[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f8852m[i3] = new CueInfoBuilder();
        }
        this.f8853n = this.f8852m[0];
    }

    private void A(int i2) {
        if (i2 == 160) {
            this.f8853n.a(13252);
            return;
        }
        Log.h("Cea708Decoder", "Invalid G3 character: " + i2);
        this.f8853n.a('_');
    }

    private void B() {
        this.f8853n.m(this.f8848i.h(4), this.f8848i.h(2), this.f8848i.h(2), this.f8848i.g(), this.f8848i.g(), this.f8848i.h(3), this.f8848i.h(3));
    }

    private void C() {
        int h2 = CueInfoBuilder.h(this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2));
        int h3 = CueInfoBuilder.h(this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2));
        this.f8848i.r(2);
        this.f8853n.n(h2, h3, CueInfoBuilder.g(this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2)));
    }

    private void D() {
        this.f8848i.r(4);
        int h2 = this.f8848i.h(4);
        this.f8848i.r(2);
        this.f8853n.o(h2, this.f8848i.h(6));
    }

    private void E() {
        int h2 = CueInfoBuilder.h(this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2));
        int h3 = this.f8848i.h(2);
        int g2 = CueInfoBuilder.g(this.f8848i.h(2), this.f8848i.h(2), this.f8848i.h(2));
        if (this.f8848i.g()) {
            h3 |= 4;
        }
        boolean g3 = this.f8848i.g();
        int h4 = this.f8848i.h(2);
        int h5 = this.f8848i.h(2);
        int h6 = this.f8848i.h(2);
        this.f8848i.r(8);
        this.f8853n.q(h2, g2, g3, h3, h4, h5, h6);
    }

    @RequiresNonNull({"currentDtvCcPacket"})
    private void F() {
        DtvCcPacket dtvCcPacket = this.f8856q;
        if (dtvCcPacket.f8890d != (dtvCcPacket.f8888b * 2) - 1) {
            Log.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f8856q.f8888b * 2) - 1) + ", but current index is " + this.f8856q.f8890d + " (sequence number " + this.f8856q.f8887a + ");");
        }
        ParsableBitArray parsableBitArray = this.f8848i;
        DtvCcPacket dtvCcPacket2 = this.f8856q;
        parsableBitArray.o(dtvCcPacket2.f8889c, dtvCcPacket2.f8890d);
        boolean z2 = false;
        while (true) {
            if (this.f8848i.b() <= 0) {
                break;
            }
            int h2 = this.f8848i.h(3);
            int h3 = this.f8848i.h(5);
            if (h2 == 7) {
                this.f8848i.r(2);
                h2 = this.f8848i.h(6);
                if (h2 < 7) {
                    Log.h("Cea708Decoder", "Invalid extended service number: " + h2);
                }
            }
            if (h3 == 0) {
                if (h2 != 0) {
                    Log.h("Cea708Decoder", "serviceNumber is non-zero (" + h2 + ") when blockSize is 0");
                }
            } else if (h2 != this.f8851l) {
                this.f8848i.s(h3);
            } else {
                int e2 = this.f8848i.e() + (h3 * 8);
                while (this.f8848i.e() < e2) {
                    int h4 = this.f8848i.h(8);
                    if (h4 == 16) {
                        int h5 = this.f8848i.h(8);
                        if (h5 <= 31) {
                            u(h5);
                        } else if (h5 <= 127) {
                            z(h5);
                        } else if (h5 <= 159) {
                            v(h5);
                        } else if (h5 <= 255) {
                            A(h5);
                        } else {
                            Log.h("Cea708Decoder", "Invalid extended command: " + h5);
                        }
                    } else if (h4 <= 31) {
                        s(h4);
                    } else if (h4 <= 127) {
                        x(h4);
                    } else if (h4 <= 159) {
                        t(h4);
                    } else if (h4 <= 255) {
                        y(h4);
                    } else {
                        Log.h("Cea708Decoder", "Invalid base command: " + h4);
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            this.f8854o = r();
        }
    }

    private void G() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f8852m[i2].l();
        }
    }

    private void q() {
        if (this.f8856q != null) {
            F();
            this.f8856q = null;
        }
    }

    private List<Cue> r() {
        Cea708CueInfo c2;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f8852m[i2].j() && this.f8852m[i2].k() && (c2 = this.f8852m[i2].c()) != null) {
                arrayList.add(c2);
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.f8858c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(((Cea708CueInfo) arrayList.get(i3)).f8859a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void s(int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 == 3) {
            this.f8854o = r();
        } else if (i2 != 8) {
            switch (i2) {
                case 12:
                    G();
                    return;
                case 13:
                    this.f8853n.a(10);
                    return;
                case 14:
                    return;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        Log.h("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i2);
                        this.f8848i.r(8);
                        return;
                    } else if (i2 < 24 || i2 > 31) {
                        Log.h("Cea708Decoder", "Invalid C0 command: " + i2);
                        return;
                    } else {
                        Log.h("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i2);
                        this.f8848i.r(16);
                        return;
                    }
            }
        } else {
            this.f8853n.b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        if (r4.f8848i.g() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        r4.f8852m[8 - r2].l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r4.f8848i.g() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r4.f8852m[8 - r2].p(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d9, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r4.f8848i.g() == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r4.f8852m[8 - r2].e();
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
    private void t(int r5) {
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
            androidx.media3.common.util.Log.h(r0, r5)
            goto L_0x0117
        L_0x0020:
            int r5 = r5 + -152
            r4.w(r5)
            int r0 = r4.f8857r
            if (r0 == r5) goto L_0x0117
            r4.f8857r = r5
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f8852m
            r5 = r0[r5]
            r4.f8853n = r5
            goto L_0x0117
        L_0x0033:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f8853n
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0044
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            r0 = 32
            r5.r(r0)
            goto L_0x0117
        L_0x0044:
            r4.E()
            goto L_0x0117
        L_0x0049:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f8853n
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0058
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            r5.r(r0)
            goto L_0x0117
        L_0x0058:
            r4.D()
            goto L_0x0117
        L_0x005d:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f8853n
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x006e
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            r0 = 24
            r5.r(r0)
            goto L_0x0117
        L_0x006e:
            r4.C()
            goto L_0x0117
        L_0x0073:
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder r5 = r4.f8853n
            boolean r5 = r5.i()
            if (r5 != 0) goto L_0x0082
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            r5.r(r0)
            goto L_0x0117
        L_0x0082:
            r4.B()
            goto L_0x0117
        L_0x0087:
            r4.G()
            goto L_0x0117
        L_0x008c:
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            r5.r(r1)
            goto L_0x0117
        L_0x0093:
            if (r2 > r1) goto L_0x0117
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x00a6
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f8852m
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
            androidx.media3.common.util.ParsableBitArray r0 = r4.f8848i
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00c2
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f8852m
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
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x00d9
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f8852m
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
            androidx.media3.common.util.ParsableBitArray r0 = r4.f8848i
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x00f0
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f8852m
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.p(r2)
        L_0x00f0:
            int r5 = r5 + 1
            goto L_0x00dd
        L_0x00f3:
            if (r2 > r1) goto L_0x0117
            androidx.media3.common.util.ParsableBitArray r5 = r4.f8848i
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0106
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r5 = r4.f8852m
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.e()
        L_0x0106:
            int r2 = r2 + 1
            goto L_0x00f3
        L_0x0109:
            int r5 = r5 + -128
            int r0 = r4.f8857r
            if (r0 == r5) goto L_0x0117
            r4.f8857r = r5
            androidx.media3.extractor.text.cea.Cea708Decoder$CueInfoBuilder[] r0 = r4.f8852m
            r5 = r0[r5]
            r4.f8853n = r5
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.t(int):void");
    }

    private void u(int i2) {
        if (i2 > 7) {
            if (i2 <= 15) {
                this.f8848i.r(8);
            } else if (i2 <= 23) {
                this.f8848i.r(16);
            } else if (i2 <= 31) {
                this.f8848i.r(24);
            }
        }
    }

    private void v(int i2) {
        if (i2 <= 135) {
            this.f8848i.r(32);
        } else if (i2 <= 143) {
            this.f8848i.r(40);
        } else if (i2 <= 159) {
            this.f8848i.r(2);
            this.f8848i.r(this.f8848i.h(6) * 8);
        }
    }

    private void w(int i2) {
        CueInfoBuilder cueInfoBuilder = this.f8852m[i2];
        this.f8848i.r(2);
        boolean g2 = this.f8848i.g();
        this.f8848i.r(2);
        int h2 = this.f8848i.h(3);
        boolean g3 = this.f8848i.g();
        int h3 = this.f8848i.h(7);
        int h4 = this.f8848i.h(8);
        int h5 = this.f8848i.h(4);
        int h6 = this.f8848i.h(4);
        this.f8848i.r(2);
        this.f8848i.r(6);
        this.f8848i.r(2);
        cueInfoBuilder.f(g2, h2, g3, h3, h4, h6, h5, this.f8848i.h(3), this.f8848i.h(3));
    }

    private void x(int i2) {
        if (i2 == 127) {
            this.f8853n.a(9835);
        } else {
            this.f8853n.a((char) (i2 & JfifUtil.MARKER_FIRST_BYTE));
        }
    }

    private void y(int i2) {
        this.f8853n.a((char) (i2 & JfifUtil.MARKER_FIRST_BYTE));
    }

    private void z(int i2) {
        if (i2 == 32) {
            this.f8853n.a(' ');
        } else if (i2 == 33) {
            this.f8853n.a(160);
        } else if (i2 == 37) {
            this.f8853n.a(8230);
        } else if (i2 == 42) {
            this.f8853n.a(352);
        } else if (i2 == 44) {
            this.f8853n.a(338);
        } else if (i2 == 63) {
            this.f8853n.a(376);
        } else if (i2 == 57) {
            this.f8853n.a(8482);
        } else if (i2 == 58) {
            this.f8853n.a(353);
        } else if (i2 == 60) {
            this.f8853n.a(339);
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    this.f8853n.a(9608);
                    return;
                case 49:
                    this.f8853n.a(8216);
                    return;
                case 50:
                    this.f8853n.a(8217);
                    return;
                case 51:
                    this.f8853n.a(8220);
                    return;
                case 52:
                    this.f8853n.a(8221);
                    return;
                case 53:
                    this.f8853n.a(8226);
                    return;
                default:
                    switch (i2) {
                        case 118:
                            this.f8853n.a(8539);
                            return;
                        case 119:
                            this.f8853n.a(8540);
                            return;
                        case 120:
                            this.f8853n.a(8541);
                            return;
                        case 121:
                            this.f8853n.a(8542);
                            return;
                        case 122:
                            this.f8853n.a(9474);
                            return;
                        case 123:
                            this.f8853n.a(9488);
                            return;
                        case 124:
                            this.f8853n.a(9492);
                            return;
                        case 125:
                            this.f8853n.a(9472);
                            return;
                        case 126:
                            this.f8853n.a(9496);
                            return;
                        case 127:
                            this.f8853n.a(9484);
                            return;
                        default:
                            Log.h("Cea708Decoder", "Invalid G2 character: " + i2);
                            return;
                    }
            }
        } else {
            this.f8853n.a(8480);
        }
    }

    public /* bridge */ /* synthetic */ void b(long j2) {
        super.b(j2);
    }

    public void flush() {
        super.flush();
        this.f8854o = null;
        this.f8855p = null;
        this.f8857r = 0;
        this.f8853n = this.f8852m[0];
        G();
        this.f8856q = null;
    }

    /* access modifiers changed from: protected */
    public Subtitle g() {
        List<Cue> list = this.f8854o;
        this.f8855p = list;
        return new CeaSubtitle((List) Assertions.f(list));
    }

    public String getName() {
        return "Cea708Decoder";
    }

    /* access modifiers changed from: protected */
    public void h(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(subtitleInputBuffer.f5067d);
        this.f8847h.S(byteBuffer.array(), byteBuffer.limit());
        while (this.f8847h.a() >= 3) {
            int H = this.f8847h.H() & 7;
            int i2 = H & 3;
            boolean z3 = false;
            if ((H & 4) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            byte H2 = (byte) this.f8847h.H();
            byte H3 = (byte) this.f8847h.H();
            if ((i2 == 2 || i2 == 3) && z2) {
                if (i2 == 3) {
                    q();
                    int i3 = (H2 & 192) >> 6;
                    int i4 = this.f8849j;
                    if (!(i4 == -1 || i3 == (i4 + 1) % 4)) {
                        G();
                        Log.h("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f8849j + " current=" + i3);
                    }
                    this.f8849j = i3;
                    byte b2 = H2 & 63;
                    if (b2 == 0) {
                        b2 = 64;
                    }
                    DtvCcPacket dtvCcPacket = new DtvCcPacket(i3, b2);
                    this.f8856q = dtvCcPacket;
                    byte[] bArr = dtvCcPacket.f8889c;
                    int i5 = dtvCcPacket.f8890d;
                    dtvCcPacket.f8890d = i5 + 1;
                    bArr[i5] = H3;
                } else {
                    if (i2 == 2) {
                        z3 = true;
                    }
                    Assertions.a(z3);
                    DtvCcPacket dtvCcPacket2 = this.f8856q;
                    if (dtvCcPacket2 == null) {
                        Log.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = dtvCcPacket2.f8889c;
                        int i6 = dtvCcPacket2.f8890d;
                        int i7 = i6 + 1;
                        bArr2[i6] = H2;
                        dtvCcPacket2.f8890d = i7 + 1;
                        bArr2[i7] = H3;
                    }
                }
                DtvCcPacket dtvCcPacket3 = this.f8856q;
                if (dtvCcPacket3.f8890d == (dtvCcPacket3.f8888b * 2) - 1) {
                    q();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer i() throws SubtitleDecoderException {
        return super.d();
    }

    public /* bridge */ /* synthetic */ SubtitleOutputBuffer j() throws SubtitleDecoderException {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public boolean m() {
        return this.f8854o != this.f8855p;
    }

    public /* bridge */ /* synthetic */ void n(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.c(subtitleInputBuffer);
    }

    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }
}
