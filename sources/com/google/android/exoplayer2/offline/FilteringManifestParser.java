package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ParsingLoadable.Parser<? extends T> f25599a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f25600b;

    public FilteringManifestParser(ParsingLoadable.Parser<? extends T> parser, List<StreamKey> list) {
        this.f25599a = parser;
        this.f25600b = list;
    }

    /* renamed from: b */
    public T a(Uri uri, InputStream inputStream) throws IOException {
        T t2 = (FilterableManifest) this.f25599a.a(uri, inputStream);
        List<StreamKey> list = this.f25600b;
        if (list == null || list.isEmpty()) {
            return t2;
        }
        return (FilterableManifest) t2.a(this.f25600b);
    }
}
