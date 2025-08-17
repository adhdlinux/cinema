package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import i0.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AmrExtractor implements Extractor {

    /* renamed from: p  reason: collision with root package name */
    public static final ExtractorsFactory f24276p = new a();

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f24277q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f24278r;

    /* renamed from: s  reason: collision with root package name */
    private static final byte[] f24279s = Util.p0("#!AMR\n");

    /* renamed from: t  reason: collision with root package name */
    private static final byte[] f24280t = Util.p0("#!AMR-WB\n");

    /* renamed from: u  reason: collision with root package name */
    private static final int f24281u;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24282a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24283b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24284c;

    /* renamed from: d  reason: collision with root package name */
    private long f24285d;

    /* renamed from: e  reason: collision with root package name */
    private int f24286e;

    /* renamed from: f  reason: collision with root package name */
    private int f24287f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24288g;

    /* renamed from: h  reason: collision with root package name */
    private long f24289h;

    /* renamed from: i  reason: collision with root package name */
    private int f24290i;

    /* renamed from: j  reason: collision with root package name */
    private int f24291j;

    /* renamed from: k  reason: collision with root package name */
    private long f24292k;

    /* renamed from: l  reason: collision with root package name */
    private ExtractorOutput f24293l;

    /* renamed from: m  reason: collision with root package name */
    private TrackOutput f24294m;

    /* renamed from: n  reason: collision with root package name */
    private SeekMap f24295n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24296o;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f24278r = iArr;
        f24281u = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void d() {
        Assertions.i(this.f24294m);
        Util.j(this.f24293l);
    }

    private static int e(int i2, long j2) {
        return (int) (((((long) i2) * 8) * 1000000) / j2);
    }

    private SeekMap f(long j2, boolean z2) {
        return new ConstantBitrateSeekMap(j2, this.f24289h, e(this.f24290i, 20000), this.f24290i, z2);
    }

    private int h(int i2) throws ParserException {
        String str;
        if (!k(i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal AMR ");
            if (this.f24284c) {
                str = "WB";
            } else {
                str = "NB";
            }
            sb.append(str);
            sb.append(" frame type ");
            sb.append(i2);
            throw ParserException.a(sb.toString(), (Throwable) null);
        } else if (this.f24284c) {
            return f24278r[i2];
        } else {
            return f24277q[i2];
        }
    }

    private boolean j(int i2) {
        return !this.f24284c && (i2 < 12 || i2 > 14);
    }

    private boolean k(int i2) {
        return i2 >= 0 && i2 <= 15 && (l(i2) || j(i2));
    }

    private boolean l(int i2) {
        return this.f24284c && (i2 < 10 || i2 > 13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] m() {
        return new Extractor[]{new AmrExtractor()};
    }

    @RequiresNonNull({"trackOutput"})
    private void n() {
        String str;
        int i2;
        if (!this.f24296o) {
            this.f24296o = true;
            boolean z2 = this.f24284c;
            if (z2) {
                str = "audio/amr-wb";
            } else {
                str = "audio/3gpp";
            }
            if (z2) {
                i2 = 16000;
            } else {
                i2 = 8000;
            }
            this.f24294m.d(new Format.Builder().g0(str).Y(f24281u).J(1).h0(i2).G());
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private void o(long j2, int i2) {
        int i3;
        boolean z2;
        if (!this.f24288g) {
            int i4 = this.f24283b;
            if ((i4 & 1) == 0 || j2 == -1 || !((i3 = this.f24290i) == -1 || i3 == this.f24286e)) {
                SeekMap.Unseekable unseekable = new SeekMap.Unseekable(-9223372036854775807L);
                this.f24295n = unseekable;
                this.f24293l.u(unseekable);
                this.f24288g = true;
            } else if (this.f24291j >= 20 || i2 == -1) {
                if ((i4 & 2) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                SeekMap f2 = f(j2, z2);
                this.f24295n = f2;
                this.f24293l.u(f2);
                this.f24288g = true;
            }
        }
    }

    private static boolean p(ExtractorInput extractorInput, byte[] bArr) throws IOException {
        extractorInput.e();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.m(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int q(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        extractorInput.m(this.f24282a, 0, 1);
        byte b2 = this.f24282a[0];
        if ((b2 & 131) <= 0) {
            return h((b2 >> 3) & 15);
        }
        throw ParserException.a("Invalid padding bits for frame header " + b2, (Throwable) null);
    }

    private boolean r(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = f24279s;
        if (p(extractorInput, bArr)) {
            this.f24284c = false;
            extractorInput.k(bArr.length);
            return true;
        }
        byte[] bArr2 = f24280t;
        if (!p(extractorInput, bArr2)) {
            return false;
        }
        this.f24284c = true;
        extractorInput.k(bArr2.length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private int s(ExtractorInput extractorInput) throws IOException {
        if (this.f24287f == 0) {
            try {
                int q2 = q(extractorInput);
                this.f24286e = q2;
                this.f24287f = q2;
                if (this.f24290i == -1) {
                    this.f24289h = extractorInput.getPosition();
                    this.f24290i = this.f24286e;
                }
                if (this.f24290i == this.f24286e) {
                    this.f24291j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b2 = this.f24294m.b(extractorInput, this.f24287f, true);
        if (b2 == -1) {
            return -1;
        }
        int i2 = this.f24287f - b2;
        this.f24287f = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f24294m.e(this.f24292k + this.f24285d, 1, this.f24286e, 0, (TrackOutput.CryptoData) null);
        this.f24285d += 20000;
        return 0;
    }

    public void a(long j2, long j3) {
        this.f24285d = 0;
        this.f24286e = 0;
        this.f24287f = 0;
        if (j2 != 0) {
            SeekMap seekMap = this.f24295n;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.f24292k = ((ConstantBitrateSeekMap) seekMap).c(j2);
                return;
            }
        }
        this.f24292k = 0;
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24293l = extractorOutput;
        this.f24294m = extractorOutput.d(0, 1);
        extractorOutput.m();
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        return r(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        d();
        if (extractorInput.getPosition() != 0 || r(extractorInput)) {
            n();
            int s2 = s(extractorInput);
            o(extractorInput.getLength(), s2);
            return s2;
        }
        throw ParserException.a("Could not find AMR header.", (Throwable) null);
    }

    public void release() {
    }

    public AmrExtractor(int i2) {
        this.f24283b = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f24282a = new byte[1];
        this.f24290i = -1;
    }
}
