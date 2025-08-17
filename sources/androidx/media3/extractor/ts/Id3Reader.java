package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

public final class Id3Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9371a = new ParsableByteArray(10);

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f9372b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9373c;

    /* renamed from: d  reason: collision with root package name */
    private long f9374d = -9223372036854775807L;

    /* renamed from: e  reason: collision with root package name */
    private int f9375e;

    /* renamed from: f  reason: collision with root package name */
    private int f9376f;

    public void a() {
        this.f9373c = false;
        this.f9374d = -9223372036854775807L;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.j(this.f9372b);
        if (this.f9373c) {
            int a2 = parsableByteArray.a();
            int i2 = this.f9376f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), this.f9371a.e(), this.f9376f, min);
                if (this.f9376f + min == 10) {
                    this.f9371a.U(0);
                    if (73 == this.f9371a.H() && 68 == this.f9371a.H() && 51 == this.f9371a.H()) {
                        this.f9371a.V(3);
                        this.f9375e = this.f9371a.G() + 10;
                    } else {
                        Log.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.f9373c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f9375e - this.f9376f);
            this.f9372b.b(parsableByteArray, min2);
            this.f9376f += min2;
        }
    }

    public void d(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f9373c = true;
            this.f9374d = j2;
            this.f9375e = 0;
            this.f9376f = 0;
        }
    }

    public void e(boolean z2) {
        int i2;
        boolean z3;
        Assertions.j(this.f9372b);
        if (this.f9373c && (i2 = this.f9375e) != 0 && this.f9376f == i2) {
            if (this.f9374d != -9223372036854775807L) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.h(z3);
            this.f9372b.f(this.f9374d, 1, this.f9375e, 0, (TrackOutput.CryptoData) null);
            this.f9373c = false;
        }
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f9372b = d2;
        d2.c(new Format.Builder().a0(trackIdGenerator.b()).o0("application/id3").K());
    }
}
