package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.SimpleSubtitleDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;

final class DelegatingSubtitleDecoder extends SimpleSubtitleDecoder {

    /* renamed from: p  reason: collision with root package name */
    private final SubtitleParser f7322p;

    public DelegatingSubtitleDecoder(String str, SubtitleParser subtitleParser) {
        super(str);
        this.f7322p = subtitleParser;
    }

    /* access modifiers changed from: protected */
    public Subtitle B(byte[] bArr, int i2, boolean z2) {
        if (z2) {
            this.f7322p.reset();
        }
        return this.f7322p.b(bArr, 0, i2);
    }
}
