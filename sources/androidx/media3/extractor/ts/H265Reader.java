package androidx.media3.extractor.ts;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.startapp.y1;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H265Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final SeiReader f9344a;

    /* renamed from: b  reason: collision with root package name */
    private String f9345b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f9346c;

    /* renamed from: d  reason: collision with root package name */
    private SampleReader f9347d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9348e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f9349f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final NalUnitTargetBuffer f9350g = new NalUnitTargetBuffer(32, 128);

    /* renamed from: h  reason: collision with root package name */
    private final NalUnitTargetBuffer f9351h = new NalUnitTargetBuffer(33, 128);

    /* renamed from: i  reason: collision with root package name */
    private final NalUnitTargetBuffer f9352i = new NalUnitTargetBuffer(34, 128);

    /* renamed from: j  reason: collision with root package name */
    private final NalUnitTargetBuffer f9353j = new NalUnitTargetBuffer(39, 128);

    /* renamed from: k  reason: collision with root package name */
    private final NalUnitTargetBuffer f9354k = new NalUnitTargetBuffer(40, 128);

    /* renamed from: l  reason: collision with root package name */
    private long f9355l;

    /* renamed from: m  reason: collision with root package name */
    private long f9356m = -9223372036854775807L;

    /* renamed from: n  reason: collision with root package name */
    private final ParsableByteArray f9357n = new ParsableByteArray();

    private static final class SampleReader {

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f9358a;

        /* renamed from: b  reason: collision with root package name */
        private long f9359b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9360c;

        /* renamed from: d  reason: collision with root package name */
        private int f9361d;

        /* renamed from: e  reason: collision with root package name */
        private long f9362e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9363f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f9364g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f9365h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f9366i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f9367j;

        /* renamed from: k  reason: collision with root package name */
        private long f9368k;

        /* renamed from: l  reason: collision with root package name */
        private long f9369l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f9370m;

        public SampleReader(TrackOutput trackOutput) {
            this.f9358a = trackOutput;
        }

        private static boolean c(int i2) {
            return (32 <= i2 && i2 <= 35) || i2 == 39;
        }

        private static boolean d(int i2) {
            return i2 < 32 || i2 == 40;
        }

        private void e(int i2) {
            long j2 = this.f9369l;
            if (j2 != -9223372036854775807L) {
                boolean z2 = this.f9370m;
                this.f9358a.f(j2, z2 ? 1 : 0, (int) (this.f9359b - this.f9368k), i2, (TrackOutput.CryptoData) null);
            }
        }

        public void a(long j2) {
            this.f9370m = this.f9360c;
            e((int) (j2 - this.f9359b));
            this.f9368k = this.f9359b;
            this.f9359b = j2;
            e(0);
            this.f9366i = false;
        }

        public void b(long j2, int i2, boolean z2) {
            if (this.f9367j && this.f9364g) {
                this.f9370m = this.f9360c;
                this.f9367j = false;
            } else if (this.f9365h || this.f9364g) {
                if (z2 && this.f9366i) {
                    e(i2 + ((int) (j2 - this.f9359b)));
                }
                this.f9368k = this.f9359b;
                this.f9369l = this.f9362e;
                this.f9370m = this.f9360c;
                this.f9366i = true;
            }
        }

        public void f(byte[] bArr, int i2, int i3) {
            boolean z2;
            if (this.f9363f) {
                int i4 = this.f9361d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    if ((bArr[i5] & y1.f36938c) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f9364g = z2;
                    this.f9363f = false;
                    return;
                }
                this.f9361d = i4 + (i3 - i2);
            }
        }

        public void g() {
            this.f9363f = false;
            this.f9364g = false;
            this.f9365h = false;
            this.f9366i = false;
            this.f9367j = false;
        }

        public void h(long j2, int i2, int i3, long j3, boolean z2) {
            boolean z3;
            boolean z4 = false;
            this.f9364g = false;
            this.f9365h = false;
            this.f9362e = j3;
            this.f9361d = 0;
            this.f9359b = j2;
            if (!d(i3)) {
                if (this.f9366i && !this.f9367j) {
                    if (z2) {
                        e(i2);
                    }
                    this.f9366i = false;
                }
                if (c(i3)) {
                    this.f9365h = !this.f9367j;
                    this.f9367j = true;
                }
            }
            if (i3 < 16 || i3 > 21) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f9360c = z3;
            if (z3 || i3 <= 9) {
                z4 = true;
            }
            this.f9363f = z4;
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.f9344a = seiReader;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void c() {
        Assertions.j(this.f9346c);
        Util.i(this.f9347d);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j2, int i2, int i3, long j3) {
        this.f9347d.b(j2, i2, this.f9348e);
        if (!this.f9348e) {
            this.f9350g.b(i3);
            this.f9351h.b(i3);
            this.f9352i.b(i3);
            if (this.f9350g.c() && this.f9351h.c() && this.f9352i.c()) {
                this.f9346c.c(i(this.f9345b, this.f9350g, this.f9351h, this.f9352i));
                this.f9348e = true;
            }
        }
        if (this.f9353j.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f9353j;
            this.f9357n.S(this.f9353j.f9443d, NalUnitUtil.r(nalUnitTargetBuffer.f9443d, nalUnitTargetBuffer.f9444e));
            this.f9357n.V(5);
            this.f9344a.a(j3, this.f9357n);
        }
        if (this.f9354k.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f9354k;
            this.f9357n.S(this.f9354k.f9443d, NalUnitUtil.r(nalUnitTargetBuffer2.f9443d, nalUnitTargetBuffer2.f9444e));
            this.f9357n.V(5);
            this.f9344a.a(j3, this.f9357n);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i2, int i3) {
        this.f9347d.f(bArr, i2, i3);
        if (!this.f9348e) {
            this.f9350g.a(bArr, i2, i3);
            this.f9351h.a(bArr, i2, i3);
            this.f9352i.a(bArr, i2, i3);
        }
        this.f9353j.a(bArr, i2, i3);
        this.f9354k.a(bArr, i2, i3);
    }

    private static Format i(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i2 = nalUnitTargetBuffer.f9444e;
        byte[] bArr = new byte[(nalUnitTargetBuffer2.f9444e + i2 + nalUnitTargetBuffer3.f9444e)];
        System.arraycopy(nalUnitTargetBuffer.f9443d, 0, bArr, 0, i2);
        System.arraycopy(nalUnitTargetBuffer2.f9443d, 0, bArr, nalUnitTargetBuffer.f9444e, nalUnitTargetBuffer2.f9444e);
        System.arraycopy(nalUnitTargetBuffer3.f9443d, 0, bArr, nalUnitTargetBuffer.f9444e + nalUnitTargetBuffer2.f9444e, nalUnitTargetBuffer3.f9444e);
        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(nalUnitTargetBuffer2.f9443d, 3, nalUnitTargetBuffer2.f9444e);
        return new Format.Builder().a0(str).o0(MimeTypes.VIDEO_H265).O(CodecSpecificDataUtil.c(h2.f4752a, h2.f4753b, h2.f4754c, h2.f4755d, h2.f4759h, h2.f4760i)).v0(h2.f4762k).Y(h2.f4763l).P(new ColorInfo.Builder().d(h2.f4766o).c(h2.f4767p).e(h2.f4768q).g(h2.f4757f + 8).b(h2.f4758g + 8).a()).k0(h2.f4764m).g0(h2.f4765n).b0(Collections.singletonList(bArr)).K();
    }

    @RequiresNonNull({"sampleReader"})
    private void j(long j2, int i2, int i3, long j3) {
        this.f9347d.h(j2, i2, i3, j3, this.f9348e);
        if (!this.f9348e) {
            this.f9350g.e(i3);
            this.f9351h.e(i3);
            this.f9352i.e(i3);
        }
        this.f9353j.e(i3);
        this.f9354k.e(i3);
    }

    public void a() {
        this.f9355l = 0;
        this.f9356m = -9223372036854775807L;
        NalUnitUtil.a(this.f9349f);
        this.f9350g.d();
        this.f9351h.d();
        this.f9352i.d();
        this.f9353j.d();
        this.f9354k.d();
        SampleReader sampleReader = this.f9347d;
        if (sampleReader != null) {
            sampleReader.g();
        }
    }

    public void b(ParsableByteArray parsableByteArray) {
        int i2;
        c();
        while (parsableByteArray.a() > 0) {
            int f2 = parsableByteArray.f();
            int g2 = parsableByteArray.g();
            byte[] e2 = parsableByteArray.e();
            this.f9355l += (long) parsableByteArray.a();
            this.f9346c.b(parsableByteArray, parsableByteArray.a());
            while (true) {
                if (f2 < g2) {
                    int c2 = NalUnitUtil.c(e2, f2, g2, this.f9349f);
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
                    long j2 = this.f9355l - ((long) i4);
                    if (i3 < 0) {
                        i2 = -i3;
                    } else {
                        i2 = 0;
                    }
                    long j3 = j2;
                    int i5 = i4;
                    g(j3, i5, i2, this.f9356m);
                    j(j3, i5, e3, this.f9356m);
                    f2 = c2 + 3;
                }
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9356m = j2;
    }

    public void e(boolean z2) {
        c();
        if (z2) {
            this.f9347d.a(this.f9355l);
        }
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9345b = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f9346c = d2;
        this.f9347d = new SampleReader(d2);
        this.f9344a.b(extractorOutput, trackIdGenerator);
    }
}
