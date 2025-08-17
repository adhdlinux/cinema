package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.e;
import java.util.Map;

public final /* synthetic */ class c implements ExtractorsFactory {
    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return e.a(this, uri, map);
    }

    public final Extractor[] c() {
        return AdtsExtractor.h();
    }
}
