package com.google.android.exoplayer2.extractor.ogg;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.e;
import java.util.Map;

public final /* synthetic */ class a implements ExtractorsFactory {
    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return e.a(this, uri, map);
    }

    public final Extractor[] c() {
        return OggExtractor.d();
    }
}
