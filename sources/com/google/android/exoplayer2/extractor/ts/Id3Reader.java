package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Id3Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f24980a = new ParsableByteArray(10);

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f24981b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24982c;

    /* renamed from: d  reason: collision with root package name */
    private long f24983d = -9223372036854775807L;

    /* renamed from: e  reason: collision with root package name */
    private int f24984e;

    /* renamed from: f  reason: collision with root package name */
    private int f24985f;

    public void a() {
        this.f24982c = false;
        this.f24983d = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f24981b);
        if (this.f24982c) {
            int a2 = parsableByteArray.a();
            int i2 = this.f24985f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), this.f24980a.e(), this.f24985f, min);
                if (this.f24985f + min == 10) {
                    this.f24980a.U(0);
                    if (73 == this.f24980a.H() && 68 == this.f24980a.H() && 51 == this.f24980a.H()) {
                        this.f24980a.V(3);
                        this.f24984e = this.f24980a.G() + 10;
                    } else {
                        Log.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.f24982c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.f24984e - this.f24985f);
            this.f24981b.c(parsableByteArray, min2);
            this.f24985f += min2;
        }
    }

    public void d(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f24982c = true;
            if (j2 != -9223372036854775807L) {
                this.f24983d = j2;
            }
            this.f24984e = 0;
            this.f24985f = 0;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f24981b = d2;
        d2.d(new Format.Builder().U(trackIdGenerator.b()).g0("application/id3").G());
    }

    public void f() {
        int i2;
        Assertions.i(this.f24981b);
        if (this.f24982c && (i2 = this.f24984e) != 0 && this.f24985f == i2) {
            long j2 = this.f24983d;
            if (j2 != -9223372036854775807L) {
                this.f24981b.e(j2, 1, i2, 0, (TrackOutput.CryptoData) null);
            }
            this.f24982c = false;
        }
    }
}
