package m0;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import java.util.Map;

public final /* synthetic */ class b implements ExtractorsFactory {
    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return e.a(this, uri, map);
    }

    public final Extractor[] c() {
        return Mp4Extractor.s();
    }
}
