package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.e;
import java.util.Map;

public final /* synthetic */ class b implements ExtractorsFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f26048b;

    public /* synthetic */ b(Format format) {
        this.f26048b = format;
    }

    public /* synthetic */ Extractor[] b(Uri uri, Map map) {
        return e.a(this, uri, map);
    }

    public final Extractor[] c() {
        return DefaultMediaSourceFactory.g(this.f26048b);
    }
}
