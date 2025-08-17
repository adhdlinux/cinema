package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class ParsingLoadable<T> implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final long f7552a;

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f7553b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7554c;

    /* renamed from: d  reason: collision with root package name */
    private final StatsDataSource f7555d;

    /* renamed from: e  reason: collision with root package name */
    private final Parser<? extends T> f7556e;

    /* renamed from: f  reason: collision with root package name */
    private volatile T f7557f;

    public interface Parser<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i2, Parser<? extends T> parser) {
        this(dataSource, new DataSpec.Builder().i(uri).b(1).a(), i2, parser);
    }

    public final void a() throws IOException {
        this.f7555d.r();
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f7555d, this.f7553b);
        try {
            dataSourceInputStream.f();
            this.f7557f = this.f7556e.a((Uri) Assertions.f(this.f7555d.b()), dataSourceInputStream);
        } finally {
            Util.m(dataSourceInputStream);
        }
    }

    public final void b() {
    }

    public long c() {
        return this.f7555d.o();
    }

    public Map<String, List<String>> d() {
        return this.f7555d.q();
    }

    public final T e() {
        return this.f7557f;
    }

    public Uri f() {
        return this.f7555d.p();
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i2, Parser<? extends T> parser) {
        this.f7555d = new StatsDataSource(dataSource);
        this.f7553b = dataSpec;
        this.f7554c = i2;
        this.f7556e = parser;
        this.f7552a = LoadEventInfo.a();
    }
}
