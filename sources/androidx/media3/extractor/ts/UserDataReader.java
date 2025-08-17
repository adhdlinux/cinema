package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

final class UserDataReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f9553a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f9554b;

    public UserDataReader(List<Format> list) {
        this.f9553a = list;
        this.f9554b = new TrackOutput[list.size()];
    }

    public void a(long j2, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() >= 9) {
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            int H = parsableByteArray.H();
            if (q2 == 434 && q3 == 1195456820 && H == 3) {
                CeaUtil.b(j2, parsableByteArray, this.f9554b);
            }
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z2;
        for (int i2 = 0; i2 < this.f9554b.length; i2++) {
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = this.f9553a.get(i2);
            String str = format.f4015n;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "Invalid closed caption MIME type provided: " + str);
            d2.c(new Format.Builder().a0(trackIdGenerator.b()).o0(str).q0(format.f4006e).e0(format.f4005d).L(format.G).b0(format.f4018q).K());
            this.f9554b[i2] = d2;
        }
    }
}
