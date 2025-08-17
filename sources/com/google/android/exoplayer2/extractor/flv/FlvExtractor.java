package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import k0.a;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class FlvExtractor implements Extractor {

    /* renamed from: q  reason: collision with root package name */
    public static final ExtractorsFactory f24364q = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f24365a = new ParsableByteArray(4);

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24366b = new ParsableByteArray(9);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f24367c = new ParsableByteArray(11);

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f24368d = new ParsableByteArray();

    /* renamed from: e  reason: collision with root package name */
    private final ScriptTagPayloadReader f24369e = new ScriptTagPayloadReader();

    /* renamed from: f  reason: collision with root package name */
    private ExtractorOutput f24370f;

    /* renamed from: g  reason: collision with root package name */
    private int f24371g = 1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24372h;

    /* renamed from: i  reason: collision with root package name */
    private long f24373i;

    /* renamed from: j  reason: collision with root package name */
    private int f24374j;

    /* renamed from: k  reason: collision with root package name */
    private int f24375k;

    /* renamed from: l  reason: collision with root package name */
    private int f24376l;

    /* renamed from: m  reason: collision with root package name */
    private long f24377m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24378n;

    /* renamed from: o  reason: collision with root package name */
    private AudioTagPayloadReader f24379o;

    /* renamed from: p  reason: collision with root package name */
    private VideoTagPayloadReader f24380p;

    @RequiresNonNull({"extractorOutput"})
    private void d() {
        if (!this.f24378n) {
            this.f24370f.u(new SeekMap.Unseekable(-9223372036854775807L));
            this.f24378n = true;
        }
    }

    private long e() {
        if (this.f24372h) {
            return this.f24373i + this.f24377m;
        }
        if (this.f24369e.d() == -9223372036854775807L) {
            return 0;
        }
        return this.f24377m;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] f() {
        return new Extractor[]{new FlvExtractor()};
    }

    private ParsableByteArray h(ExtractorInput extractorInput) throws IOException {
        if (this.f24376l > this.f24368d.b()) {
            ParsableByteArray parsableByteArray = this.f24368d;
            parsableByteArray.S(new byte[Math.max(parsableByteArray.b() * 2, this.f24376l)], 0);
        } else {
            this.f24368d.U(0);
        }
        this.f24368d.T(this.f24376l);
        extractorInput.readFully(this.f24368d.e(), 0, this.f24376l);
        return this.f24368d;
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean j(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        boolean z3 = false;
        if (!extractorInput.f(this.f24366b.e(), 0, 9, true)) {
            return false;
        }
        this.f24366b.U(0);
        this.f24366b.V(4);
        int H = this.f24366b.H();
        if ((H & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((H & 1) != 0) {
            z3 = true;
        }
        if (z2 && this.f24379o == null) {
            this.f24379o = new AudioTagPayloadReader(this.f24370f.d(8, 1));
        }
        if (z3 && this.f24380p == null) {
            this.f24380p = new VideoTagPayloadReader(this.f24370f.d(9, 2));
        }
        this.f24370f.m();
        this.f24374j = (this.f24366b.q() - 9) + 4;
        this.f24371g = 2;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean k(com.google.android.exoplayer2.extractor.ExtractorInput r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.e()
            int r2 = r9.f24375k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L_0x0023
            com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader r3 = r9.f24379o
            if (r3 == 0) goto L_0x0023
            r9.d()
            com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader r2 = r9.f24379o
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
        L_0x0021:
            r0 = 1
            goto L_0x0075
        L_0x0023:
            r3 = 9
            if (r2 != r3) goto L_0x0039
            com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader r3 = r9.f24380p
            if (r3 == 0) goto L_0x0039
            r9.d()
            com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader r2 = r9.f24380p
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            goto L_0x0021
        L_0x0039:
            r3 = 18
            if (r2 != r3) goto L_0x006e
            boolean r2 = r9.f24378n
            if (r2 != 0) goto L_0x006e
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r2 = r9.f24369e
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r0 = r9.f24369e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            com.google.android.exoplayer2.extractor.ExtractorOutput r2 = r9.f24370f
            com.google.android.exoplayer2.extractor.IndexSeekMap r3 = new com.google.android.exoplayer2.extractor.IndexSeekMap
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r7 = r9.f24369e
            long[] r7 = r7.e()
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r8 = r9.f24369e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.u(r3)
            r9.f24378n = r6
            goto L_0x0021
        L_0x006e:
            int r0 = r9.f24376l
            r10.k(r0)
            r10 = 0
            r0 = 0
        L_0x0075:
            boolean r1 = r9.f24372h
            if (r1 != 0) goto L_0x008f
            if (r10 == 0) goto L_0x008f
            r9.f24372h = r6
            com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader r10 = r9.f24369e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x008b
            long r1 = r9.f24377m
            long r1 = -r1
            goto L_0x008d
        L_0x008b:
            r1 = 0
        L_0x008d:
            r9.f24373i = r1
        L_0x008f:
            r10 = 4
            r9.f24374j = r10
            r10 = 2
            r9.f24371g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.FlvExtractor.k(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    private boolean l(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.f(this.f24367c.e(), 0, 11, true)) {
            return false;
        }
        this.f24367c.U(0);
        this.f24375k = this.f24367c.H();
        this.f24376l = this.f24367c.K();
        this.f24377m = (long) this.f24367c.K();
        this.f24377m = (((long) (this.f24367c.H() << 24)) | this.f24377m) * 1000;
        this.f24367c.V(3);
        this.f24371g = 4;
        return true;
    }

    private void m(ExtractorInput extractorInput) throws IOException {
        extractorInput.k(this.f24374j);
        this.f24374j = 0;
        this.f24371g = 3;
    }

    public void a(long j2, long j3) {
        if (j2 == 0) {
            this.f24371g = 1;
            this.f24372h = false;
        } else {
            this.f24371g = 3;
        }
        this.f24374j = 0;
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f24370f = extractorOutput;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        extractorInput.m(this.f24365a.e(), 0, 3);
        this.f24365a.U(0);
        if (this.f24365a.K() != 4607062) {
            return false;
        }
        extractorInput.m(this.f24365a.e(), 0, 2);
        this.f24365a.U(0);
        if ((this.f24365a.N() & 250) != 0) {
            return false;
        }
        extractorInput.m(this.f24365a.e(), 0, 4);
        this.f24365a.U(0);
        int q2 = this.f24365a.q();
        extractorInput.e();
        extractorInput.h(q2);
        extractorInput.m(this.f24365a.e(), 0, 4);
        this.f24365a.U(0);
        if (this.f24365a.q() == 0) {
            return true;
        }
        return false;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.i(this.f24370f);
        while (true) {
            int i2 = this.f24371g;
            if (i2 != 1) {
                if (i2 == 2) {
                    m(extractorInput);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    } else if (k(extractorInput)) {
                        return 0;
                    }
                } else if (!l(extractorInput)) {
                    return -1;
                }
            } else if (!j(extractorInput)) {
                return -1;
            }
        }
    }

    public void release() {
    }
}
