package androidx.media3.exoplayer.hls;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;

public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: f  reason: collision with root package name */
    private static final PositionHolder f6287f = new PositionHolder();

    /* renamed from: a  reason: collision with root package name */
    final Extractor f6288a;

    /* renamed from: b  reason: collision with root package name */
    private final Format f6289b;

    /* renamed from: c  reason: collision with root package name */
    private final TimestampAdjuster f6290c;

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser.Factory f6291d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6292e;

    BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z2) {
        this.f6288a = extractor;
        this.f6289b = format;
        this.f6290c = timestampAdjuster;
        this.f6291d = factory;
        this.f6292e = z2;
    }

    public boolean a(ExtractorInput extractorInput) throws IOException {
        return this.f6288a.k(extractorInput, f6287f) == 0;
    }

    public void b() {
        this.f6288a.a(0, 0);
    }

    public boolean d() {
        Extractor c2 = this.f6288a.c();
        if ((c2 instanceof TsExtractor) || (c2 instanceof FragmentedMp4Extractor)) {
            return true;
        }
        return false;
    }

    public void g(ExtractorOutput extractorOutput) {
        this.f6288a.g(extractorOutput);
    }

    public boolean h() {
        Extractor c2 = this.f6288a.c();
        if ((c2 instanceof AdtsExtractor) || (c2 instanceof Ac3Extractor) || (c2 instanceof Ac4Extractor) || (c2 instanceof Mp3Extractor)) {
            return true;
        }
        return false;
    }

    public HlsMediaChunkExtractor i() {
        Extractor mp3Extractor;
        boolean z2 = true;
        Assertions.h(!d());
        if (this.f6288a.c() != this.f6288a) {
            z2 = false;
        }
        Assertions.i(z2, "Can't recreate wrapped extractors. Outer type: " + this.f6288a.getClass());
        Extractor extractor = this.f6288a;
        if (extractor instanceof WebvttExtractor) {
            mp3Extractor = new WebvttExtractor(this.f6289b.f4005d, this.f6290c, this.f6291d, this.f6292e);
        } else if (extractor instanceof AdtsExtractor) {
            mp3Extractor = new AdtsExtractor();
        } else if (extractor instanceof Ac3Extractor) {
            mp3Extractor = new Ac3Extractor();
        } else if (extractor instanceof Ac4Extractor) {
            mp3Extractor = new Ac4Extractor();
        } else if (extractor instanceof Mp3Extractor) {
            mp3Extractor = new Mp3Extractor();
        } else {
            throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f6288a.getClass().getSimpleName());
        }
        return new BundledHlsMediaChunkExtractor(mp3Extractor, this.f6289b, this.f6290c, this.f6291d, this.f6292e);
    }
}
