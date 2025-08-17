package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.media3.common.StreamKey;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ParsingLoadable.Parser<? extends T> f6788a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f6789b;

    public FilteringManifestParser(ParsingLoadable.Parser<? extends T> parser, List<StreamKey> list) {
        this.f6788a = parser;
        this.f6789b = list;
    }

    /* renamed from: b */
    public T a(Uri uri, InputStream inputStream) throws IOException {
        T t2 = (FilterableManifest) this.f6788a.a(uri, inputStream);
        List<StreamKey> list = this.f6789b;
        if (list == null || list.isEmpty()) {
            return t2;
        }
        return (FilterableManifest) t2.a(this.f6789b);
    }
}
