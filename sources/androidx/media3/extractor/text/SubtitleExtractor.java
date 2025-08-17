package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubtitleExtractor implements Extractor {

    /* renamed from: a  reason: collision with root package name */
    private final SubtitleParser f8782a;

    /* renamed from: b  reason: collision with root package name */
    private final CueEncoder f8783b = new CueEncoder();

    /* renamed from: c  reason: collision with root package name */
    private final Format f8784c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Sample> f8785d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f8786e = new ParsableByteArray();

    /* renamed from: f  reason: collision with root package name */
    private byte[] f8787f = Util.f4719f;

    /* renamed from: g  reason: collision with root package name */
    private TrackOutput f8788g;

    /* renamed from: h  reason: collision with root package name */
    private int f8789h;

    /* renamed from: i  reason: collision with root package name */
    private int f8790i;

    /* renamed from: j  reason: collision with root package name */
    private long[] f8791j;

    /* renamed from: k  reason: collision with root package name */
    private long f8792k;

    private static class Sample implements Comparable<Sample> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f8793b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f8794c;

        /* renamed from: c */
        public int compareTo(Sample sample) {
            return Long.compare(this.f8793b, sample.f8793b);
        }

        private Sample(long j2, byte[] bArr) {
            this.f8793b = j2;
            this.f8794c = bArr;
        }
    }

    public SubtitleExtractor(SubtitleParser subtitleParser, Format format) {
        this.f8782a = subtitleParser;
        this.f8784c = format.a().o0("application/x-media3-cues").O(format.f4015n).S(subtitleParser.c()).K();
        this.f8785d = new ArrayList();
        this.f8790i = 0;
        this.f8791j = Util.f4720g;
        this.f8792k = -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(CuesWithTiming cuesWithTiming) {
        Sample sample = new Sample(cuesWithTiming.f8774b, this.f8783b.a(cuesWithTiming.f8773a, cuesWithTiming.f8775c));
        this.f8785d.add(sample);
        long j2 = this.f8792k;
        if (j2 == -9223372036854775807L || cuesWithTiming.f8774b >= j2) {
            m(sample);
        }
    }

    private void e() throws IOException {
        SubtitleParser.OutputOptions outputOptions;
        try {
            long j2 = this.f8792k;
            if (j2 != -9223372036854775807L) {
                outputOptions = SubtitleParser.OutputOptions.c(j2);
            } else {
                outputOptions = SubtitleParser.OutputOptions.b();
            }
            this.f8782a.a(this.f8787f, 0, this.f8789h, outputOptions, new d(this));
            Collections.sort(this.f8785d);
            this.f8791j = new long[this.f8785d.size()];
            for (int i2 = 0; i2 < this.f8785d.size(); i2++) {
                this.f8791j[i2] = this.f8785d.get(i2).f8793b;
            }
            this.f8787f = Util.f4719f;
        } catch (RuntimeException e2) {
            throw ParserException.a("SubtitleParser failed.", e2);
        }
    }

    private boolean f(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.f8787f;
        if (bArr.length == this.f8789h) {
            this.f8787f = Arrays.copyOf(bArr, bArr.length + 1024);
        }
        byte[] bArr2 = this.f8787f;
        int i2 = this.f8789h;
        int read = extractorInput.read(bArr2, i2, bArr2.length - i2);
        if (read != -1) {
            this.f8789h += read;
        }
        long length = extractorInput.getLength();
        if ((length == -1 || ((long) this.f8789h) != length) && read != -1) {
            return false;
        }
        return true;
    }

    private boolean h(ExtractorInput extractorInput) throws IOException {
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

    private void l() {
        int i2;
        long j2 = this.f8792k;
        if (j2 == -9223372036854775807L) {
            i2 = 0;
        } else {
            i2 = Util.h(this.f8791j, j2, true, true);
        }
        while (i2 < this.f8785d.size()) {
            m(this.f8785d.get(i2));
            i2++;
        }
    }

    private void m(Sample sample) {
        Assertions.j(this.f8788g);
        int length = sample.f8794c.length;
        this.f8786e.R(sample.f8794c);
        this.f8788g.b(this.f8786e, length);
        this.f8788g.f(sample.f8793b, 1, length, 0, (TrackOutput.CryptoData) null);
    }

    public void a(long j2, long j3) {
        boolean z2;
        int i2 = this.f8790i;
        if (i2 == 0 || i2 == 5) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.h(z2);
        this.f8792k = j3;
        if (this.f8790i == 2) {
            this.f8790i = 1;
        }
        if (this.f8790i == 4) {
            this.f8790i = 3;
        }
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        boolean z2;
        if (this.f8790i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        TrackOutput d2 = extractorOutput.d(0, 3);
        this.f8788g = d2;
        d2.c(this.f8784c);
        extractorOutput.m();
        extractorOutput.r(new IndexSeekMap(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.f8790i = 1;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        return true;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        int i2;
        int i3 = this.f8790i;
        if (i3 == 0 || i3 == 5) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.h(z2);
        if (this.f8790i == 1) {
            if (extractorInput.getLength() != -1) {
                i2 = Ints.d(extractorInput.getLength());
            } else {
                i2 = 1024;
            }
            if (i2 > this.f8787f.length) {
                this.f8787f = new byte[i2];
            }
            this.f8789h = 0;
            this.f8790i = 2;
        }
        if (this.f8790i == 2 && f(extractorInput)) {
            e();
            this.f8790i = 4;
        }
        if (this.f8790i == 3 && h(extractorInput)) {
            l();
            this.f8790i = 4;
        }
        if (this.f8790i == 4) {
            return -1;
        }
        return 0;
    }

    public void release() {
        if (this.f8790i != 5) {
            this.f8782a.reset();
            this.f8790i = 5;
        }
    }
}
