package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private Format f9445a;

    /* renamed from: b  reason: collision with root package name */
    private TimestampAdjuster f9446b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f9447c;

    public PassthroughSectionPayloadReader(String str) {
        this.f9445a = new Format.Builder().o0(str).K();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void a() {
        Assertions.j(this.f9446b);
        Util.i(this.f9447c);
    }

    public void b(ParsableByteArray parsableByteArray) {
        a();
        long e2 = this.f9446b.e();
        long f2 = this.f9446b.f();
        if (e2 != -9223372036854775807L && f2 != -9223372036854775807L) {
            Format format = this.f9445a;
            if (f2 != format.f4020s) {
                Format K = format.a().s0(f2).K();
                this.f9445a = K;
                this.f9447c.c(K);
            }
            int a2 = parsableByteArray.a();
            this.f9447c.b(parsableByteArray, a2);
            this.f9447c.f(e2, 1, a2, 0, (TrackOutput.CryptoData) null);
        }
    }

    public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f9446b = timestampAdjuster;
        trackIdGenerator.a();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f9447c = d2;
        d2.c(this.f9445a);
    }
}
