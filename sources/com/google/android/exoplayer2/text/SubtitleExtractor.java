package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public class SubtitleExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final SubtitleDecoder f27253a;

    /* renamed from: b  reason: collision with root package name */
    private final CueEncoder f27254b = new CueEncoder();

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f27255c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private final Format f27256d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Long> f27257e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ParsableByteArray> f27258f;

    /* renamed from: g  reason: collision with root package name */
    private ExtractorOutput f27259g;

    /* renamed from: h  reason: collision with root package name */
    private TrackOutput f27260h;

    /* renamed from: i  reason: collision with root package name */
    private int f27261i;

    /* renamed from: j  reason: collision with root package name */
    private int f27262j;

    /* renamed from: k  reason: collision with root package name */
    private long f27263k;

    public SubtitleExtractor(SubtitleDecoder subtitleDecoder, Format format) {
        this.f27253a = subtitleDecoder;
        this.f27256d = format.b().g0("text/x-exoplayer-cues").K(format.f23071m).G();
        this.f27257e = new ArrayList();
        this.f27258f = new ArrayList();
        this.f27262j = 0;
        this.f27263k = -9223372036854775807L;
    }

    private void b() throws IOException {
        try {
            SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) this.f27253a.d();
            while (subtitleInputBuffer == null) {
                Thread.sleep(5);
                subtitleInputBuffer = (SubtitleInputBuffer) this.f27253a.d();
            }
            subtitleInputBuffer.q(this.f27261i);
            subtitleInputBuffer.f23961d.put(this.f27255c.e(), 0, this.f27261i);
            subtitleInputBuffer.f23961d.limit(this.f27261i);
            this.f27253a.c(subtitleInputBuffer);
            SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) this.f27253a.a();
            while (subtitleOutputBuffer == null) {
                Thread.sleep(5);
                subtitleOutputBuffer = (SubtitleOutputBuffer) this.f27253a.a();
            }
            for (int i2 = 0; i2 < subtitleOutputBuffer.d(); i2++) {
                byte[] a2 = this.f27254b.a(subtitleOutputBuffer.b(subtitleOutputBuffer.c(i2)));
                this.f27257e.add(Long.valueOf(subtitleOutputBuffer.c(i2)));
                this.f27258f.add(new ParsableByteArray(a2));
            }
            subtitleOutputBuffer.p();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        } catch (SubtitleDecoderException e2) {
            throw ParserException.a("SubtitleDecoder failed.", e2);
        }
    }

    private boolean d(ExtractorInput extractorInput) throws IOException {
        int b2 = this.f27255c.b();
        int i2 = this.f27261i;
        if (b2 == i2) {
            this.f27255c.c(i2 + 1024);
        }
        int read = extractorInput.read(this.f27255c.e(), this.f27261i, this.f27255c.b() - this.f27261i);
        if (read != -1) {
            this.f27261i += read;
        }
        long length = extractorInput.getLength();
        if ((length == -1 || ((long) this.f27261i) != length) && read != -1) {
            return false;
        }
        return true;
    }

    private boolean e(ExtractorInput extractorInput) throws IOException {
        int i2;
        if (extractorInput.getLength() != -1) {
            i2 = Ints.d(extractorInput.getLength());
        } else {
            i2 = 1024;
        }
        if (extractorInput.a(i2) == -1) {
            return true;
        }
        return false;
    }

    private void f() {
        boolean z2;
        int i2;
        Assertions.i(this.f27260h);
        if (this.f27257e.size() == this.f27258f.size()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        long j2 = this.f27263k;
        if (j2 == -9223372036854775807L) {
            i2 = 0;
        } else {
            i2 = Util.g(this.f27257e, Long.valueOf(j2), true, true);
        }
        while (i2 < this.f27258f.size()) {
            ParsableByteArray parsableByteArray = this.f27258f.get(i2);
            parsableByteArray.U(0);
            int length = parsableByteArray.e().length;
            this.f27260h.c(parsableByteArray, length);
            this.f27260h.e(this.f27257e.get(i2).longValue(), 1, length, 0, (TrackOutput.CryptoData) null);
            i2++;
        }
    }

    public void a(long j2, long j3) {
        boolean z2;
        int i2 = this.f27262j;
        if (i2 == 0 || i2 == 5) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.g(z2);
        this.f27263k = j3;
        if (this.f27262j == 2) {
            this.f27262j = 1;
        }
        if (this.f27262j == 4) {
            this.f27262j = 3;
        }
    }

    public void c(ExtractorOutput extractorOutput) {
        boolean z2;
        if (this.f27262j == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f27259g = extractorOutput;
        this.f27260h = extractorOutput.d(0, 3);
        this.f27259g.m();
        this.f27259g.u(new IndexSeekMap(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.f27260h.d(this.f27256d);
        this.f27262j = 1;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        return true;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        int i2;
        int i3 = this.f27262j;
        if (i3 == 0 || i3 == 5) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.g(z2);
        if (this.f27262j == 1) {
            ParsableByteArray parsableByteArray = this.f27255c;
            if (extractorInput.getLength() != -1) {
                i2 = Ints.d(extractorInput.getLength());
            } else {
                i2 = 1024;
            }
            parsableByteArray.Q(i2);
            this.f27261i = 0;
            this.f27262j = 2;
        }
        if (this.f27262j == 2 && d(extractorInput)) {
            b();
            f();
            this.f27262j = 4;
        }
        if (this.f27262j == 3 && e(extractorInput)) {
            f();
            this.f27262j = 4;
        }
        if (this.f27262j == 4) {
            return -1;
        }
        return 0;
    }

    public void release() {
        if (this.f27262j != 5) {
            this.f27253a.release();
            this.f27262j = 5;
        }
    }
}
