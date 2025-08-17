package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.f;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class d implements ExtractorsFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultMediaSourceFactory f7274b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f7275c;

    public /* synthetic */ d(DefaultMediaSourceFactory defaultMediaSourceFactory, Format format) {
        this.f7274b = defaultMediaSourceFactory;
        this.f7275c = format;
    }

    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return f.a(this, uri, map);
    }

    public final Extractor[] c() {
        return this.f7274b.k(this.f7275c);
    }

    public /* synthetic */ ExtractorsFactory d(boolean z2) {
        return f.b(this, z2);
    }
}
