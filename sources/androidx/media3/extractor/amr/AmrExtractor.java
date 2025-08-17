package androidx.media3.extractor.amr;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import j.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AmrExtractor implements Extractor {

    /* renamed from: p  reason: collision with root package name */
    public static final ExtractorsFactory f8118p = new a();

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f8119q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f8120r;

    /* renamed from: s  reason: collision with root package name */
    private static final byte[] f8121s = Util.t0("#!AMR\n");

    /* renamed from: t  reason: collision with root package name */
    private static final byte[] f8122t = Util.t0("#!AMR-WB\n");

    /* renamed from: u  reason: collision with root package name */
    private static final int f8123u;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f8124a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8125b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8126c;

    /* renamed from: d  reason: collision with root package name */
    private long f8127d;

    /* renamed from: e  reason: collision with root package name */
    private int f8128e;

    /* renamed from: f  reason: collision with root package name */
    private int f8129f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8130g;

    /* renamed from: h  reason: collision with root package name */
    private long f8131h;

    /* renamed from: i  reason: collision with root package name */
    private int f8132i;

    /* renamed from: j  reason: collision with root package name */
    private int f8133j;

    /* renamed from: k  reason: collision with root package name */
    private long f8134k;

    /* renamed from: l  reason: collision with root package name */
    private ExtractorOutput f8135l;

    /* renamed from: m  reason: collision with root package name */
    private TrackOutput f8136m;

    /* renamed from: n  reason: collision with root package name */
    private SeekMap f8137n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8138o;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f8120r = iArr;
        f8123u = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void d() {
        Assertions.j(this.f8136m);
        Util.i(this.f8135l);
    }

    private static int e(int i2, long j2) {
        return (int) (((((long) i2) * 8) * 1000000) / j2);
    }

    private SeekMap f(long j2, boolean z2) {
        return new ConstantBitrateSeekMap(j2, this.f8131h, e(this.f8132i, 20000), this.f8132i, z2);
    }

    private int h(int i2) throws ParserException {
        String str;
        if (!m(i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal AMR ");
            if (this.f8126c) {
                str = "WB";
            } else {
                str = "NB";
            }
            sb.append(str);
            sb.append(" frame type ");
            sb.append(i2);
            throw ParserException.a(sb.toString(), (Throwable) null);
        } else if (this.f8126c) {
            return f8120r[i2];
        } else {
            return f8119q[i2];
        }
    }

    private boolean l(int i2) {
        return !this.f8126c && (i2 < 12 || i2 > 14);
    }

    private boolean m(int i2) {
        return i2 >= 0 && i2 <= 15 && (n(i2) || l(i2));
    }

    private boolean n(int i2) {
        return this.f8126c && (i2 < 10 || i2 > 13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] o() {
        return new Extractor[]{new AmrExtractor()};
    }

    @RequiresNonNull({"trackOutput"})
    private void p() {
        String str;
        int i2;
        if (!this.f8138o) {
            this.f8138o = true;
            boolean z2 = this.f8126c;
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
            this.f8136m.c(new Format.Builder().o0(str).f0(f8123u).N(1).p0(i2).K());
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private void q(long j2, int i2) {
        int i3;
        boolean z2;
        if (!this.f8130g) {
            int i4 = this.f8125b;
            if ((i4 & 1) == 0 || j2 == -1 || !((i3 = this.f8132i) == -1 || i3 == this.f8128e)) {
                SeekMap.Unseekable unseekable = new SeekMap.Unseekable(-9223372036854775807L);
                this.f8137n = unseekable;
                this.f8135l.r(unseekable);
                this.f8130g = true;
            } else if (this.f8133j >= 20 || i2 == -1) {
                if ((i4 & 2) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                SeekMap f2 = f(j2, z2);
                this.f8137n = f2;
                this.f8135l.r(f2);
                this.f8130g = true;
            }
        }
    }

    private static boolean r(ExtractorInput extractorInput, byte[] bArr) throws IOException {
        extractorInput.e();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.m(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int s(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        extractorInput.m(this.f8124a, 0, 1);
        byte b2 = this.f8124a[0];
        if ((b2 & 131) <= 0) {
            return h((b2 >> 3) & 15);
        }
        throw ParserException.a("Invalid padding bits for frame header " + b2, (Throwable) null);
    }

    private boolean t(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = f8121s;
        if (r(extractorInput, bArr)) {
            this.f8126c = false;
            extractorInput.k(bArr.length);
            return true;
        }
        byte[] bArr2 = f8122t;
        if (!r(extractorInput, bArr2)) {
            return false;
        }
        this.f8126c = true;
        extractorInput.k(bArr2.length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private int u(ExtractorInput extractorInput) throws IOException {
        if (this.f8129f == 0) {
            try {
                int s2 = s(extractorInput);
                this.f8128e = s2;
                this.f8129f = s2;
                if (this.f8132i == -1) {
                    this.f8131h = extractorInput.getPosition();
                    this.f8132i = this.f8128e;
                }
                if (this.f8132i == this.f8128e) {
                    this.f8133j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int d2 = this.f8136m.d(extractorInput, this.f8129f, true);
        if (d2 == -1) {
            return -1;
        }
        int i2 = this.f8129f - d2;
        this.f8129f = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f8136m.f(this.f8134k + this.f8127d, 1, this.f8128e, 0, (TrackOutput.CryptoData) null);
        this.f8127d += 20000;
        return 0;
    }

    public void a(long j2, long j3) {
        this.f8127d = 0;
        this.f8128e = 0;
        this.f8129f = 0;
        if (j2 != 0) {
            SeekMap seekMap = this.f8137n;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.f8134k = ((ConstantBitrateSeekMap) seekMap).c(j2);
                return;
            }
        }
        this.f8134k = 0;
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8135l = extractorOutput;
        this.f8136m = extractorOutput.d(0, 1);
        extractorOutput.m();
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return t(extractorInput);
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        d();
        if (extractorInput.getPosition() != 0 || t(extractorInput)) {
            p();
            int u2 = u(extractorInput);
            q(extractorInput.getLength(), u2);
            return u2;
        }
        throw ParserException.a("Could not find AMR header.", (Throwable) null);
    }

    public void release() {
    }

    public AmrExtractor(int i2) {
        this.f8125b = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f8124a = new byte[1];
        this.f8132i = -1;
    }
}
