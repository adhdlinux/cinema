package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class e implements ExtractorsFactory {
    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return f.a(this, uri, map);
    }

    public final Extractor[] c() {
        return f.d();
    }

    public /* synthetic */ ExtractorsFactory d(boolean z2) {
        return f.b(this, z2);
    }
}
