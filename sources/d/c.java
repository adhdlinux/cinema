package d;

import android.net.Uri;
import androidx.media3.datasource.cache.ContentMetadata;

public final /* synthetic */ class c {
    public static long a(ContentMetadata contentMetadata) {
        return contentMetadata.a("exo_len", -1);
    }

    public static Uri b(ContentMetadata contentMetadata) {
        String b2 = contentMetadata.b("exo_redir", (String) null);
        if (b2 == null) {
            return null;
        }
        return Uri.parse(b2);
    }
}
