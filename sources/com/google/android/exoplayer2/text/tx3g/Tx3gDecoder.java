package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f27559o = new ParsableByteArray();

    /* renamed from: p  reason: collision with root package name */
    private final boolean f27560p;

    /* renamed from: q  reason: collision with root package name */
    private final int f27561q;

    /* renamed from: r  reason: collision with root package name */
    private final int f27562r;

    /* renamed from: s  reason: collision with root package name */
    private final String f27563s;

    /* renamed from: t  reason: collision with root package name */
    private final float f27564t;

    /* renamed from: u  reason: collision with root package name */
    private final int f27565u;

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = "sans-serif";
        boolean z2 = false;
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f27561q = bArr[24];
            this.f27562r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f27563s = "Serif".equals(Util.E(bArr, 43, bArr.length - 43)) ? "serif" : str;
            int i2 = bArr[25] * 20;
            this.f27565u = i2;
            z2 = (bArr[0] & 32) != 0 ? true : z2;
            this.f27560p = z2;
            if (z2) {
                this.f27564t = Util.p(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i2), 0.0f, 0.95f);
            } else {
                this.f27564t = 0.85f;
            }
        } else {
            this.f27561q = 0;
            this.f27562r = -1;
            this.f27563s = str;
            this.f27560p = false;
            this.f27564t = 0.85f;
            this.f27565u = -1;
        }
    }

    private void B(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        boolean z2;
        if (parsableByteArray.a() >= 12) {
            z2 = true;
        } else {
            z2 = false;
        }
        C(z2);
        int N = parsableByteArray.N();
        int N2 = parsableByteArray.N();
        parsableByteArray.V(2);
        int H = parsableByteArray.H();
        parsableByteArray.V(1);
        int q2 = parsableByteArray.q();
        if (N2 > spannableStringBuilder.length()) {
            Log.i("Tx3gDecoder", "Truncating styl end (" + N2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            N2 = spannableStringBuilder.length();
        }
        if (N >= N2) {
            Log.i("Tx3gDecoder", "Ignoring styl with start (" + N + ") >= end (" + N2 + ").");
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i2 = N;
        int i3 = N2;
        E(spannableStringBuilder2, H, this.f27561q, i2, i3, 0);
        D(spannableStringBuilder2, q2, this.f27562r, i2, i3, 0);
    }

    private static void C(boolean z2) throws SubtitleDecoderException {
        if (!z2) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void D(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & JfifUtil.MARKER_FIRST_BYTE) << 24)), i4, i5, i6 | 33);
        }
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        boolean z2;
        boolean z3;
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z4 = true;
            if ((i2 & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i2 & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            if ((i2 & 4) == 0) {
                z4 = false;
            }
            if (z4) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (!z4 && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
            }
        }
    }

    private static void F(SpannableStringBuilder spannableStringBuilder, String str, int i2, int i3) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, 16711713);
        }
    }

    private static String G(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        boolean z2;
        if (parsableByteArray.a() >= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        C(z2);
        int N = parsableByteArray.N();
        if (N == 0) {
            return "";
        }
        int f2 = parsableByteArray.f();
        Charset P = parsableByteArray.P();
        int f3 = N - (parsableByteArray.f() - f2);
        if (P == null) {
            P = Charsets.UTF_8;
        }
        return parsableByteArray.F(f3, P);
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f27559o.S(bArr, i2);
        String G = G(this.f27559o);
        if (G.isEmpty()) {
            return Tx3gSubtitle.f27566c;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(G);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        E(spannableStringBuilder2, this.f27561q, 0, 0, spannableStringBuilder.length(), 16711680);
        D(spannableStringBuilder2, this.f27562r, -1, 0, spannableStringBuilder.length(), 16711680);
        F(spannableStringBuilder, this.f27563s, 0, spannableStringBuilder.length());
        float f2 = this.f27564t;
        while (this.f27559o.a() >= 8) {
            int f3 = this.f27559o.f();
            int q2 = this.f27559o.q();
            int q3 = this.f27559o.q();
            boolean z3 = true;
            if (q3 == 1937013100) {
                if (this.f27559o.a() < 2) {
                    z3 = false;
                }
                C(z3);
                int N = this.f27559o.N();
                for (int i3 = 0; i3 < N; i3++) {
                    B(this.f27559o, spannableStringBuilder);
                }
            } else if (q3 == 1952608120 && this.f27560p) {
                if (this.f27559o.a() < 2) {
                    z3 = false;
                }
                C(z3);
                f2 = Util.p(((float) this.f27559o.N()) / ((float) this.f27565u), 0.0f, 0.95f);
            }
            this.f27559o.U(f3 + q2);
        }
        return new Tx3gSubtitle(new Cue.Builder().o(spannableStringBuilder).h(f2, 0).i(0).a());
    }
}
