package k;

import android.net.Uri;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.f;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class b implements ExtractorsFactory {
    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return f.a(this, uri, map);
    }

    public final Extractor[] c() {
        return FlacExtractor.l();
    }

    public /* synthetic */ ExtractorsFactory d(boolean z2) {
        return f.b(this, z2);
    }
}
