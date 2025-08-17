package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;
import java.util.Map;

public interface ExtractorsFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ExtractorsFactory f8014a = new e();

    ExtractorsFactory a(SubtitleParser.Factory factory);

    Extractor[] b(Uri uri, Map<String, List<String>> map);

    Extractor[] c();

    @Deprecated
    ExtractorsFactory d(boolean z2);
}
