package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class f {
    static {
        ExtractorsFactory extractorsFactory = ExtractorsFactory.f8014a;
    }

    public static Extractor[] a(ExtractorsFactory extractorsFactory, Uri uri, Map map) {
        return extractorsFactory.c();
    }

    @Deprecated
    public static ExtractorsFactory b(ExtractorsFactory extractorsFactory, boolean z2) {
        return extractorsFactory;
    }

    public static ExtractorsFactory c(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
        return extractorsFactory;
    }

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[0];
    }
}
