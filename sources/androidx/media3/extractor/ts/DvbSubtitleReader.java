package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<TsPayloadReader.DvbSubtitleInfo> f9240a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f9241b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9242c;

    /* renamed from: d  reason: collision with root package name */
    private int f9243d;

    /* renamed from: e  reason: collision with root package name */
    private int f9244e;

    /* renamed from: f  reason: collision with root package name */
    private long f9245f = -9223372036854775807L;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.f9240a = list;
        this.f9241b = new TrackOutput[list.size()];
    }

    private boolean c(ParsableByteArray parsableByteArray, int i2) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.H() != i2) {
            this.f9242c = false;
        }
        this.f9243d--;
        return this.f9242c;
    }

    public void a() {
        this.f9242c = false;
        this.f9245f = -9223372036854775807L;
    }

    public void b(ParsableByteArray parsableByteArray) {
        if (!this.f9242c) {
            return;
        }
        if (this.f9243d != 2 || c(parsableByteArray, 32)) {
            if (this.f9243d != 1 || c(parsableByteArray, 0)) {
                int f2 = parsableByteArray.f();
                int a2 = parsableByteArray.a();
                for (TrackOutput b2 : this.f9241b) {
                    parsableByteArray.U(f2);
                    b2.b(parsableByteArray, a2);
                }
                this.f9244e += a2;
            }
        }
    }

    public void d(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f9242c = true;
            this.f9245f = j2;
            this.f9244e = 0;
            this.f9243d = 2;
        }
    }

    public void e(boolean z2) {
        boolean z3;
        if (this.f9242c) {
            if (this.f9245f != -9223372036854775807L) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.h(z3);
            for (TrackOutput f2 : this.f9241b) {
                f2.f(this.f9245f, 1, this.f9244e, 0, (TrackOutput.CryptoData) null);
            }
            this.f9242c = false;
        }
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i2 = 0; i2 < this.f9241b.length; i2++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.f9240a.get(i2);
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            d2.c(new Format.Builder().a0(trackIdGenerator.b()).o0("application/dvbsubs").b0(Collections.singletonList(dvbSubtitleInfo.f9542c)).e0(dvbSubtitleInfo.f9540a).K());
            this.f9241b[i2] = d2;
        }
    }
}
