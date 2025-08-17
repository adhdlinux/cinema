package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private Format f25024a;

    /* renamed from: b  reason: collision with root package name */
    private TimestampAdjuster f25025b;

    /* renamed from: c  reason: collision with root package name */
    private TrackOutput f25026c;

    public PassthroughSectionPayloadReader(String str) {
        this.f25024a = new Format.Builder().g0(str).G();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void a() {
        Assertions.i(this.f25025b);
        Util.j(this.f25026c);
    }

    public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f25025b = timestampAdjuster;
        trackIdGenerator.a();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f25026c = d2;
        d2.d(this.f25024a);
    }

    public void c(ParsableByteArray parsableByteArray) {
        a();
        long d2 = this.f25025b.d();
        long e2 = this.f25025b.e();
        if (d2 != -9223372036854775807L && e2 != -9223372036854775807L) {
            Format format = this.f25024a;
            if (e2 != format.f23075q) {
                Format G = format.b().k0(e2).G();
                this.f25024a = G;
                this.f25026c.d(G);
            }
            int a2 = parsableByteArray.a();
            this.f25026c.c(parsableByteArray, a2);
            this.f25026c.e(d2, 1, a2, 0, (TrackOutput.CryptoData) null);
        }
    }
}
