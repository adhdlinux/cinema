package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class e implements ExtractorsFactory {
    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return com.google.android.exoplayer2.extractor.e.a(this, uri, map);
    }

    public final Extractor[] c() {
        return TsExtractor.w();
    }
}
