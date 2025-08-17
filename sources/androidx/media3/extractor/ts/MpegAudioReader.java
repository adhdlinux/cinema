package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.protobuf.CodedOutputStream;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MpegAudioReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9399a;

    /* renamed from: b  reason: collision with root package name */
    private final MpegAudioUtil.Header f9400b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9401c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9402d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f9403e;

    /* renamed from: f  reason: collision with root package name */
    private String f9404f;

    /* renamed from: g  reason: collision with root package name */
    private int f9405g;

    /* renamed from: h  reason: collision with root package name */
    private int f9406h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9407i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9408j;

    /* renamed from: k  reason: collision with root package name */
    private long f9409k;

    /* renamed from: l  reason: collision with root package name */
    private int f9410l;

    /* renamed from: m  reason: collision with root package name */
    private long f9411m;

    public MpegAudioReader() {
        this((String) null, 0);
    }

    private void c(ParsableByteArray parsableByteArray) {
        boolean z2;
        boolean z3;
        byte[] e2 = parsableByteArray.e();
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2; f2++) {
            byte b2 = e2[f2];
            if ((b2 & 255) == 255) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!this.f9408j || (b2 & 224) != 224) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f9408j = z2;
            if (z3) {
                parsableByteArray.U(f2 + 1);
                this.f9408j = false;
                this.f9399a.e()[1] = e2[f2];
                this.f9406h = 2;
                this.f9405g = 1;
                return;
            }
        }
        parsableByteArray.U(g2);
    }

    @RequiresNonNull({"output"})
    private void g(ParsableByteArray parsableByteArray) {
        boolean z2;
        int min = Math.min(parsableByteArray.a(), this.f9410l - this.f9406h);
        this.f9403e.b(parsableByteArray, min);
        int i2 = this.f9406h + min;
        this.f9406h = i2;
        if (i2 >= this.f9410l) {
            if (this.f9411m != -9223372036854775807L) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            this.f9403e.f(this.f9411m, 1, this.f9410l, 0, (TrackOutput.CryptoData) null);
            this.f9411m += this.f9409k;
            this.f9406h = 0;
            this.f9405g = 0;
        }
    }

    @RequiresNonNull({"output"})
    private void h(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), 4 - this.f9406h);
        parsableByteArray.l(this.f9399a.e(), this.f9406h, min);
        int i2 = this.f9406h + min;
        this.f9406h = i2;
        if (i2 >= 4) {
            this.f9399a.U(0);
            if (!this.f9400b.a(this.f9399a.q())) {
                this.f9406h = 0;
                this.f9405g = 1;
                return;
            }
            MpegAudioUtil.Header header = this.f9400b;
            this.f9410l = header.f8064c;
            if (!this.f9407i) {
                this.f9409k = (((long) header.f8068g) * 1000000) / ((long) header.f8065d);
                this.f9403e.c(new Format.Builder().a0(this.f9404f).o0(this.f9400b.f8063b).f0(CodedOutputStream.DEFAULT_BUFFER_SIZE).N(this.f9400b.f8066e).p0(this.f9400b.f8065d).e0(this.f9401c).m0(this.f9402d).K());
                this.f9407i = true;
            }
            this.f9399a.U(0);
            this.f9403e.b(this.f9399a, 4);
            this.f9405g = 2;
        }
    }

    public void a() {
        this.f9405g = 0;
        this.f9406h = 0;
        this.f9408j = false;
        this.f9411m = -9223372036854775807L;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.j(this.f9403e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9405g;
            if (i2 == 0) {
                c(parsableByteArray);
            } else if (i2 == 1) {
                h(parsableByteArray);
            } else if (i2 == 2) {
                g(parsableByteArray);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9411m = j2;
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9404f = trackIdGenerator.b();
        this.f9403e = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public MpegAudioReader(String str, int i2) {
        this.f9405g = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f9399a = parsableByteArray;
        parsableByteArray.e()[0] = -1;
        this.f9400b = new MpegAudioUtil.Header();
        this.f9411m = -9223372036854775807L;
        this.f9401c = str;
        this.f9402d = i2;
    }
}
