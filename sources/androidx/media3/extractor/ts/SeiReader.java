package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

public final class SeiReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f9496a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f9497b;

    public SeiReader(List<Format> list) {
        this.f9496a = list;
        this.f9497b = new TrackOutput[list.size()];
    }

    public void a(long j2, ParsableByteArray parsableByteArray) {
        CeaUtil.a(j2, parsableByteArray, this.f9497b);
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z2;
        for (int i2 = 0; i2 < this.f9497b.length; i2++) {
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = this.f9496a.get(i2);
            String str = format.f4015n;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "Invalid closed caption MIME type provided: " + str);
            String str2 = format.f4002a;
            if (str2 == null) {
                str2 = trackIdGenerator.b();
            }
            d2.c(new Format.Builder().a0(str2).o0(str).q0(format.f4006e).e0(format.f4005d).L(format.G).b0(format.f4018q).K());
            this.f9497b[i2] = d2;
        }
    }
}
