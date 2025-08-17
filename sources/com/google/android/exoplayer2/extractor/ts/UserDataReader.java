package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

final class UserDataReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f25129a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f25130b;

    public UserDataReader(List<Format> list) {
        this.f25129a = list;
        this.f25130b = new TrackOutput[list.size()];
    }

    public void a(long j2, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() >= 9) {
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            int H = parsableByteArray.H();
            if (q2 == 434 && q3 == 1195456820 && H == 3) {
                CeaUtil.b(j2, parsableByteArray, this.f25130b);
            }
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        boolean z2;
        for (int i2 = 0; i2 < this.f25130b.length; i2++) {
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = this.f25129a.get(i2);
            String str = format.f23071m;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "Invalid closed caption mime type provided: " + str);
            d2.d(new Format.Builder().U(trackIdGenerator.b()).g0(str).i0(format.f23063e).X(format.f23062d).H(format.E).V(format.f23073o).G());
            this.f25130b[i2] = d2;
        }
    }
}
