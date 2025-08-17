package androidx.media3.extractor.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gParser implements SubtitleParser {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9089a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9090b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9091c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9092d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9093e;

    /* renamed from: f  reason: collision with root package name */
    private final float f9094f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9095g;

    public Tx3gParser(List<byte[]> list) {
        String str = "sans-serif";
        boolean z2 = false;
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f9091c = bArr[24];
            this.f9092d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f9093e = "Serif".equals(Util.I(bArr, 43, bArr.length - 43)) ? "serif" : str;
            int i2 = bArr[25] * 20;
            this.f9095g = i2;
            z2 = (bArr[0] & 32) != 0 ? true : z2;
            this.f9090b = z2;
            if (z2) {
                this.f9094f = Util.o(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i2), 0.0f, 0.95f);
            } else {
                this.f9094f = 0.85f;
            }
        } else {
            this.f9091c = 0;
            this.f9092d = -1;
            this.f9093e = str;
            this.f9090b = false;
            this.f9094f = 0.85f;
            this.f9095g = -1;
        }
    }

    private void d(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) {
        boolean z2;
        if (parsableByteArray.a() >= 12) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        int N = parsableByteArray.N();
        int N2 = parsableByteArray.N();
        parsableByteArray.V(2);
        int H = parsableByteArray.H();
        parsableByteArray.V(1);
        int q2 = parsableByteArray.q();
        if (N2 > spannableStringBuilder.length()) {
            Log.h("Tx3gParser", "Truncating styl end (" + N2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            N2 = spannableStringBuilder.length();
        }
        if (N >= N2) {
            Log.h("Tx3gParser", "Ignoring styl with start (" + N + ") >= end (" + N2 + ").");
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i2 = N;
        int i3 = N2;
        f(spannableStringBuilder2, H, this.f9091c, i2, i3, 0);
        e(spannableStringBuilder2, q2, this.f9092d, i2, i3, 0);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & JfifUtil.MARKER_FIRST_BYTE) << 24)), i4, i5, i6 | 33);
        }
    }

    private static void f(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
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

    private static void g(SpannableStringBuilder spannableStringBuilder, String str, int i2, int i3) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, 16711713);
        }
    }

    private static String h(ParsableByteArray parsableByteArray) {
        boolean z2;
        if (parsableByteArray.a() >= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
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

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        int i4 = i2;
        Consumer<CuesWithTiming> consumer2 = consumer;
        this.f9089a.S(bArr, i4 + i3);
        this.f9089a.U(i4);
        String h2 = h(this.f9089a);
        if (h2.isEmpty()) {
            consumer2.accept(new CuesWithTiming(ImmutableList.r(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(h2);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        f(spannableStringBuilder2, this.f9091c, 0, 0, spannableStringBuilder.length(), 16711680);
        e(spannableStringBuilder2, this.f9092d, -1, 0, spannableStringBuilder.length(), 16711680);
        g(spannableStringBuilder, this.f9093e, 0, spannableStringBuilder.length());
        float f2 = this.f9094f;
        while (this.f9089a.a() >= 8) {
            int f3 = this.f9089a.f();
            int q2 = this.f9089a.q();
            int q3 = this.f9089a.q();
            boolean z2 = true;
            if (q3 == 1937013100) {
                if (this.f9089a.a() < 2) {
                    z2 = false;
                }
                Assertions.a(z2);
                int N = this.f9089a.N();
                for (int i5 = 0; i5 < N; i5++) {
                    d(this.f9089a, spannableStringBuilder);
                }
            } else if (q3 == 1952608120 && this.f9090b) {
                if (this.f9089a.a() < 2) {
                    z2 = false;
                }
                Assertions.a(z2);
                f2 = Util.o(((float) this.f9089a.N()) / ((float) this.f9095g), 0.0f, 0.95f);
            }
            this.f9089a.U(f3 + q2);
        }
        consumer2.accept(new CuesWithTiming(ImmutableList.s(new Cue.Builder().o(spannableStringBuilder).h(f2, 0).i(0).a()), -9223372036854775807L, -9223372036854775807L));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return f.a(this, bArr, i2, i3);
    }

    public int c() {
        return 2;
    }

    public /* synthetic */ void reset() {
        f.b(this);
    }
}
