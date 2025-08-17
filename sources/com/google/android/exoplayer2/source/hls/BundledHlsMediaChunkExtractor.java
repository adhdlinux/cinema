package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;

public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: d  reason: collision with root package name */
    private static final PositionHolder f26383d = new PositionHolder();

    /* renamed from: a  reason: collision with root package name */
    final Extractor f26384a;

    /* renamed from: b  reason: collision with root package name */
    private final Format f26385b;

    /* renamed from: c  reason: collision with root package name */
    private final TimestampAdjuster f26386c;

    public BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster) {
        this.f26384a = extractor;
        this.f26385b = format;
        this.f26386c = timestampAdjuster;
    }

    public boolean a(ExtractorInput extractorInput) throws IOException {
        return this.f26384a.i(extractorInput, f26383d) == 0;
    }

    public void b() {
        this.f26384a.a(0, 0);
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f26384a.c(extractorOutput);
    }

    public boolean d() {
        Extractor extractor = this.f26384a;
        return (extractor instanceof TsExtractor) || (extractor instanceof FragmentedMp4Extractor);
    }

    public boolean h() {
        Extractor extractor = this.f26384a;
        return (extractor instanceof AdtsExtractor) || (extractor instanceof Ac3Extractor) || (extractor instanceof Ac4Extractor) || (extractor instanceof Mp3Extractor);
    }

    public HlsMediaChunkExtractor i() {
        Extractor extractor;
        Assertions.g(!d());
        Extractor extractor2 = this.f26384a;
        if (extractor2 instanceof WebvttExtractor) {
            extractor = new WebvttExtractor(this.f26385b.f23062d, this.f26386c);
        } else if (extractor2 instanceof AdtsExtractor) {
            extractor = new AdtsExtractor();
        } else if (extractor2 instanceof Ac3Extractor) {
            extractor = new Ac3Extractor();
        } else if (extractor2 instanceof Ac4Extractor) {
            extractor = new Ac4Extractor();
        } else if (extractor2 instanceof Mp3Extractor) {
            extractor = new Mp3Extractor();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f26384a.getClass().getSimpleName());
        }
        return new BundledHlsMediaChunkExtractor(extractor, this.f26385b, this.f26386c);
    }
}
