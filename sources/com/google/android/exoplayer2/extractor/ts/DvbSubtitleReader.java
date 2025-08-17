package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<TsPayloadReader.DvbSubtitleInfo> f24850a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f24851b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24852c;

    /* renamed from: d  reason: collision with root package name */
    private int f24853d;

    /* renamed from: e  reason: collision with root package name */
    private int f24854e;

    /* renamed from: f  reason: collision with root package name */
    private long f24855f = -9223372036854775807L;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.f24850a = list;
        this.f24851b = new TrackOutput[list.size()];
    }

    private boolean b(ParsableByteArray parsableByteArray, int i2) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.H() != i2) {
            this.f24852c = false;
        }
        this.f24853d--;
        return this.f24852c;
    }

    public void a() {
        this.f24852c = false;
        this.f24855f = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        if (!this.f24852c) {
            return;
        }
        if (this.f24853d != 2 || b(parsableByteArray, 32)) {
            if (this.f24853d != 1 || b(parsableByteArray, 0)) {
                int f2 = parsableByteArray.f();
                int a2 = parsableByteArray.a();
                for (TrackOutput c2 : this.f24851b) {
                    parsableByteArray.U(f2);
                    c2.c(parsableByteArray, a2);
                }
                this.f24854e += a2;
            }
        }
    }

    public void d(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f24852c = true;
            if (j2 != -9223372036854775807L) {
                this.f24855f = j2;
            }
            this.f24854e = 0;
            this.f24853d = 2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i2 = 0; i2 < this.f24851b.length; i2++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.f24850a.get(i2);
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            d2.d(new Format.Builder().U(trackIdGenerator.b()).g0("application/dvbsubs").V(Collections.singletonList(dvbSubtitleInfo.f25119c)).X(dvbSubtitleInfo.f25117a).G());
            this.f24851b[i2] = d2;
        }
    }

    public void f() {
        if (this.f24852c) {
            if (this.f24855f != -9223372036854775807L) {
                for (TrackOutput e2 : this.f24851b) {
                    e2.e(this.f24855f, 1, this.f24854e, 0, (TrackOutput.CryptoData) null);
                }
            }
            this.f24852c = false;
        }
    }
}
