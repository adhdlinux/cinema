package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.startapp.y1;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H265Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final SeiReader f24953a;

    /* renamed from: b  reason: collision with root package name */
    private String f24954b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f24955c;

    /* renamed from: d  reason: collision with root package name */
    private SampleReader f24956d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24957e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f24958f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final NalUnitTargetBuffer f24959g = new NalUnitTargetBuffer(32, 128);

    /* renamed from: h  reason: collision with root package name */
    private final NalUnitTargetBuffer f24960h = new NalUnitTargetBuffer(33, 128);

    /* renamed from: i  reason: collision with root package name */
    private final NalUnitTargetBuffer f24961i = new NalUnitTargetBuffer(34, 128);

    /* renamed from: j  reason: collision with root package name */
    private final NalUnitTargetBuffer f24962j = new NalUnitTargetBuffer(39, 128);

    /* renamed from: k  reason: collision with root package name */
    private final NalUnitTargetBuffer f24963k = new NalUnitTargetBuffer(40, 128);

    /* renamed from: l  reason: collision with root package name */
    private long f24964l;

    /* renamed from: m  reason: collision with root package name */
    private long f24965m = -9223372036854775807L;

    /* renamed from: n  reason: collision with root package name */
    private final ParsableByteArray f24966n = new ParsableByteArray();

    private static final class SampleReader {

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f24967a;

        /* renamed from: b  reason: collision with root package name */
        private long f24968b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f24969c;

        /* renamed from: d  reason: collision with root package name */
        private int f24970d;

        /* renamed from: e  reason: collision with root package name */
        private long f24971e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f24972f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f24973g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f24974h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f24975i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f24976j;

        /* renamed from: k  reason: collision with root package name */
        private long f24977k;

        /* renamed from: l  reason: collision with root package name */
        private long f24978l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f24979m;

        public SampleReader(TrackOutput trackOutput) {
            this.f24967a = trackOutput;
        }

        private static boolean b(int i2) {
            return (32 <= i2 && i2 <= 35) || i2 == 39;
        }

        private static boolean c(int i2) {
            return i2 < 32 || i2 == 40;
        }

        private void d(int i2) {
            long j2 = this.f24978l;
            if (j2 != -9223372036854775807L) {
                boolean z2 = this.f24979m;
                this.f24967a.e(j2, z2 ? 1 : 0, (int) (this.f24968b - this.f24977k), i2, (TrackOutput.CryptoData) null);
            }
        }

        public void a(long j2, int i2, boolean z2) {
            if (this.f24976j && this.f24973g) {
                this.f24979m = this.f24969c;
                this.f24976j = false;
            } else if (this.f24974h || this.f24973g) {
                if (z2 && this.f24975i) {
                    d(i2 + ((int) (j2 - this.f24968b)));
                }
                this.f24977k = this.f24968b;
                this.f24978l = this.f24971e;
                this.f24979m = this.f24969c;
                this.f24975i = true;
            }
        }

        public void e(byte[] bArr, int i2, int i3) {
            boolean z2;
            if (this.f24972f) {
                int i4 = this.f24970d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    if ((bArr[i5] & y1.f36938c) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f24973g = z2;
                    this.f24972f = false;
                    return;
                }
                this.f24970d = i4 + (i3 - i2);
            }
        }

        public void f() {
            this.f24972f = false;
            this.f24973g = false;
            this.f24974h = false;
            this.f24975i = false;
            this.f24976j = false;
        }

        public void g(long j2, int i2, int i3, long j3, boolean z2) {
            boolean z3;
            boolean z4 = false;
            this.f24973g = false;
            this.f24974h = false;
            this.f24971e = j3;
            this.f24970d = 0;
            this.f24968b = j2;
            if (!c(i3)) {
                if (this.f24975i && !this.f24976j) {
                    if (z2) {
                        d(i2);
                    }
                    this.f24975i = false;
                }
                if (b(i3)) {
                    this.f24974h = !this.f24976j;
                    this.f24976j = true;
                }
            }
            if (i3 < 16 || i3 > 21) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f24969c = z3;
            if (z3 || i3 <= 9) {
                z4 = true;
            }
            this.f24972f = z4;
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.f24953a = seiReader;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void b() {
        Assertions.i(this.f24955c);
        Util.j(this.f24956d);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j2, int i2, int i3, long j3) {
        this.f24956d.a(j2, i2, this.f24957e);
        if (!this.f24957e) {
            this.f24959g.b(i3);
            this.f24960h.b(i3);
            this.f24961i.b(i3);
            if (this.f24959g.c() && this.f24960h.c() && this.f24961i.c()) {
                this.f24955c.d(i(this.f24954b, this.f24959g, this.f24960h, this.f24961i));
                this.f24957e = true;
            }
        }
        if (this.f24962j.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f24962j;
            this.f24966n.S(this.f24962j.f25022d, NalUnitUtil.q(nalUnitTargetBuffer.f25022d, nalUnitTargetBuffer.f25023e));
            this.f24966n.V(5);
            this.f24953a.a(j3, this.f24966n);
        }
        if (this.f24963k.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f24963k;
            this.f24966n.S(this.f24963k.f25022d, NalUnitUtil.q(nalUnitTargetBuffer2.f25022d, nalUnitTargetBuffer2.f25023e));
            this.f24966n.V(5);
            this.f24953a.a(j3, this.f24966n);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i2, int i3) {
        this.f24956d.e(bArr, i2, i3);
        if (!this.f24957e) {
            this.f24959g.a(bArr, i2, i3);
            this.f24960h.a(bArr, i2, i3);
            this.f24961i.a(bArr, i2, i3);
        }
        this.f24962j.a(bArr, i2, i3);
        this.f24963k.a(bArr, i2, i3);
    }

    private static Format i(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i2 = nalUnitTargetBuffer.f25023e;
        byte[] bArr = new byte[(nalUnitTargetBuffer2.f25023e + i2 + nalUnitTargetBuffer3.f25023e)];
        System.arraycopy(nalUnitTargetBuffer.f25022d, 0, bArr, 0, i2);
        System.arraycopy(nalUnitTargetBuffer2.f25022d, 0, bArr, nalUnitTargetBuffer.f25023e, nalUnitTargetBuffer2.f25023e);
        System.arraycopy(nalUnitTargetBuffer3.f25022d, 0, bArr, nalUnitTargetBuffer.f25023e + nalUnitTargetBuffer2.f25023e, nalUnitTargetBuffer3.f25023e);
        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(nalUnitTargetBuffer2.f25022d, 3, nalUnitTargetBuffer2.f25023e);
        return new Format.Builder().U(str).g0(MimeTypes.VIDEO_H265).K(CodecSpecificDataUtil.c(h2.f28720a, h2.f28721b, h2.f28722c, h2.f28723d, h2.f28724e, h2.f28725f)).n0(h2.f28727h).S(h2.f28728i).c0(h2.f28729j).V(Collections.singletonList(bArr)).G();
    }

    @RequiresNonNull({"sampleReader"})
    private void j(long j2, int i2, int i3, long j3) {
        this.f24956d.g(j2, i2, i3, j3, this.f24957e);
        if (!this.f24957e) {
            this.f24959g.e(i3);
            this.f24960h.e(i3);
            this.f24961i.e(i3);
        }
        this.f24962j.e(i3);
        this.f24963k.e(i3);
    }

    public void a() {
        this.f24964l = 0;
        this.f24965m = -9223372036854775807L;
        NalUnitUtil.a(this.f24958f);
        this.f24959g.d();
        this.f24960h.d();
        this.f24961i.d();
        this.f24962j.d();
        this.f24963k.d();
        SampleReader sampleReader = this.f24956d;
        if (sampleReader != null) {
            sampleReader.f();
        }
    }

    public void c(ParsableByteArray parsableByteArray) {
        int i2;
        b();
        while (parsableByteArray.a() > 0) {
            int f2 = parsableByteArray.f();
            int g2 = parsableByteArray.g();
            byte[] e2 = parsableByteArray.e();
            this.f24964l += (long) parsableByteArray.a();
            this.f24955c.c(parsableByteArray, parsableByteArray.a());
            while (true) {
                if (f2 < g2) {
                    int c2 = NalUnitUtil.c(e2, f2, g2, this.f24958f);
                    if (c2 == g2) {
                        h(e2, f2, g2);
                        return;
                    }
                    int e3 = NalUnitUtil.e(e2, c2);
                    int i3 = c2 - f2;
                    if (i3 > 0) {
                        h(e2, f2, c2);
                    }
                    int i4 = g2 - c2;
                    long j2 = this.f24964l - ((long) i4);
                    if (i3 < 0) {
                        i2 = -i3;
                    } else {
                        i2 = 0;
                    }
                    long j3 = j2;
                    int i5 = i4;
                    g(j3, i5, i2, this.f24965m);
                    j(j3, i5, e3, this.f24965m);
                    f2 = c2 + 3;
                }
            }
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24965m = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24954b = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f24955c = d2;
        this.f24956d = new SampleReader(d2);
        this.f24953a.b(extractorOutput, trackIdGenerator);
    }

    public void f() {
    }
}
