package androidx.media3.extractor.flv;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.util.List;
import l.a;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class FlvExtractor implements Extractor {

    /* renamed from: q  reason: collision with root package name */
    public static final ExtractorsFactory f8211q = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8212a = new ParsableByteArray(4);

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f8213b = new ParsableByteArray(9);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f8214c = new ParsableByteArray(11);

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f8215d = new ParsableByteArray();

    /* renamed from: e  reason: collision with root package name */
    private final ScriptTagPayloadReader f8216e = new ScriptTagPayloadReader();

    /* renamed from: f  reason: collision with root package name */
    private ExtractorOutput f8217f;

    /* renamed from: g  reason: collision with root package name */
    private int f8218g = 1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8219h;

    /* renamed from: i  reason: collision with root package name */
    private long f8220i;

    /* renamed from: j  reason: collision with root package name */
    private int f8221j;

    /* renamed from: k  reason: collision with root package name */
    private int f8222k;

    /* renamed from: l  reason: collision with root package name */
    private int f8223l;

    /* renamed from: m  reason: collision with root package name */
    private long f8224m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8225n;

    /* renamed from: o  reason: collision with root package name */
    private AudioTagPayloadReader f8226o;

    /* renamed from: p  reason: collision with root package name */
    private VideoTagPayloadReader f8227p;

    @RequiresNonNull({"extractorOutput"})
    private void d() {
        if (!this.f8225n) {
            this.f8217f.r(new SeekMap.Unseekable(-9223372036854775807L));
            this.f8225n = true;
        }
    }

    private long e() {
        if (this.f8219h) {
            return this.f8220i + this.f8224m;
        }
        if (this.f8216e.d() == -9223372036854775807L) {
            return 0;
        }
        return this.f8224m;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new FlvExtractor()};
    }

    private ParsableByteArray h(ExtractorInput extractorInput) throws IOException {
        if (this.f8223l > this.f8215d.b()) {
            ParsableByteArray parsableByteArray = this.f8215d;
            parsableByteArray.S(new byte[Math.max(parsableByteArray.b() * 2, this.f8223l)], 0);
        } else {
            this.f8215d.U(0);
        }
        this.f8215d.T(this.f8223l);
        extractorInput.readFully(this.f8215d.e(), 0, this.f8223l);
        return this.f8215d;
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean l(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        boolean z3 = false;
        if (!extractorInput.f(this.f8213b.e(), 0, 9, true)) {
            return false;
        }
        this.f8213b.U(0);
        this.f8213b.V(4);
        int H = this.f8213b.H();
        if ((H & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((H & 1) != 0) {
            z3 = true;
        }
        if (z2 && this.f8226o == null) {
            this.f8226o = new AudioTagPayloadReader(this.f8217f.d(8, 1));
        }
        if (z3 && this.f8227p == null) {
            this.f8227p = new VideoTagPayloadReader(this.f8217f.d(9, 2));
        }
        this.f8217f.m();
        this.f8221j = (this.f8213b.q() - 9) + 4;
        this.f8218g = 2;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m(androidx.media3.extractor.ExtractorInput r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.e()
            int r2 = r9.f8222k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L_0x0023
            androidx.media3.extractor.flv.AudioTagPayloadReader r3 = r9.f8226o
            if (r3 == 0) goto L_0x0023
            r9.d()
            androidx.media3.extractor.flv.AudioTagPayloadReader r2 = r9.f8226o
            androidx.media3.common.util.ParsableByteArray r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
        L_0x0021:
            r0 = 1
            goto L_0x0075
        L_0x0023:
            r3 = 9
            if (r2 != r3) goto L_0x0039
            androidx.media3.extractor.flv.VideoTagPayloadReader r3 = r9.f8227p
            if (r3 == 0) goto L_0x0039
            r9.d()
            androidx.media3.extractor.flv.VideoTagPayloadReader r2 = r9.f8227p
            androidx.media3.common.util.ParsableByteArray r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            goto L_0x0021
        L_0x0039:
            r3 = 18
            if (r2 != r3) goto L_0x006e
            boolean r2 = r9.f8225n
            if (r2 != 0) goto L_0x006e
            androidx.media3.extractor.flv.ScriptTagPayloadReader r2 = r9.f8216e
            androidx.media3.common.util.ParsableByteArray r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            androidx.media3.extractor.flv.ScriptTagPayloadReader r0 = r9.f8216e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            androidx.media3.extractor.ExtractorOutput r2 = r9.f8217f
            androidx.media3.extractor.IndexSeekMap r3 = new androidx.media3.extractor.IndexSeekMap
            androidx.media3.extractor.flv.ScriptTagPayloadReader r7 = r9.f8216e
            long[] r7 = r7.e()
            androidx.media3.extractor.flv.ScriptTagPayloadReader r8 = r9.f8216e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.r(r3)
            r9.f8225n = r6
            goto L_0x0021
        L_0x006e:
            int r0 = r9.f8223l
            r10.k(r0)
            r10 = 0
            r0 = 0
        L_0x0075:
            boolean r1 = r9.f8219h
            if (r1 != 0) goto L_0x008f
            if (r10 == 0) goto L_0x008f
            r9.f8219h = r6
            androidx.media3.extractor.flv.ScriptTagPayloadReader r10 = r9.f8216e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x008b
            long r1 = r9.f8224m
            long r1 = -r1
            goto L_0x008d
        L_0x008b:
            r1 = 0
        L_0x008d:
            r9.f8220i = r1
        L_0x008f:
            r10 = 4
            r9.f8221j = r10
            r10 = 2
            r9.f8218g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.flv.FlvExtractor.m(androidx.media3.extractor.ExtractorInput):boolean");
    }

    private boolean n(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.f(this.f8214c.e(), 0, 11, true)) {
            return false;
        }
        this.f8214c.U(0);
        this.f8222k = this.f8214c.H();
        this.f8223l = this.f8214c.K();
        this.f8224m = (long) this.f8214c.K();
        this.f8224m = (((long) (this.f8214c.H() << 24)) | this.f8224m) * 1000;
        this.f8214c.V(3);
        this.f8218g = 4;
        return true;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        extractorInput.k(this.f8221j);
        this.f8221j = 0;
        this.f8218g = 3;
    }

    public void a(long j2, long j3) {
        if (j2 == 0) {
            this.f8218g = 1;
            this.f8219h = false;
        } else {
            this.f8218g = 3;
        }
        this.f8221j = 0;
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f8217f = extractorOutput;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        extractorInput.m(this.f8212a.e(), 0, 3);
        this.f8212a.U(0);
        if (this.f8212a.K() != 4607062) {
            return false;
        }
        extractorInput.m(this.f8212a.e(), 0, 2);
        this.f8212a.U(0);
        if ((this.f8212a.N() & 250) != 0) {
            return false;
        }
        extractorInput.m(this.f8212a.e(), 0, 4);
        this.f8212a.U(0);
        int q2 = this.f8212a.q();
        extractorInput.e();
        extractorInput.h(q2);
        extractorInput.m(this.f8212a.e(), 0, 4);
        this.f8212a.U(0);
        if (this.f8212a.q() == 0) {
            return true;
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.j(this.f8217f);
        while (true) {
            int i2 = this.f8218g;
            if (i2 != 1) {
                if (i2 == 2) {
                    o(extractorInput);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    } else if (m(extractorInput)) {
                        return 0;
                    }
                } else if (!n(extractorInput)) {
                    return -1;
                }
            } else if (!l(extractorInput)) {
                return -1;
            }
        }
    }

    public void release() {
    }
}
