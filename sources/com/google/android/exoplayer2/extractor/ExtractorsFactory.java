package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.List;
import java.util.Map;

public interface ExtractorsFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ExtractorsFactory f24203a = new d();

    Extractor[] b(Uri uri, Map<String, List<String>> map);

    Extractor[] c();
}
