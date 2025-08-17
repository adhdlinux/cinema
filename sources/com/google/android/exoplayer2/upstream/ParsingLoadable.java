package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class ParsingLoadable<T> implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final long f28482a;

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f28483b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28484c;

    /* renamed from: d  reason: collision with root package name */
    private final StatsDataSource f28485d;

    /* renamed from: e  reason: collision with root package name */
    private final Parser<? extends T> f28486e;

    /* renamed from: f  reason: collision with root package name */
    private volatile T f28487f;

    public interface Parser<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i2, Parser<? extends T> parser) {
        this(dataSource, new DataSpec.Builder().i(uri).b(1).a(), i2, parser);
    }

    public static <T> T g(DataSource dataSource, Parser<? extends T> parser, DataSpec dataSpec, int i2) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, dataSpec, i2, parser);
        parsingLoadable.a();
        return Assertions.e(parsingLoadable.e());
    }

    public final void a() throws IOException {
        this.f28485d.u();
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f28485d, this.f28483b);
        try {
            dataSourceInputStream.f();
            this.f28487f = this.f28486e.a((Uri) Assertions.e(this.f28485d.b()), dataSourceInputStream);
        } finally {
            Util.n(dataSourceInputStream);
        }
    }

    public final void b() {
    }

    public long c() {
        return this.f28485d.q();
    }

    public Map<String, List<String>> d() {
        return this.f28485d.t();
    }

    public final T e() {
        return this.f28487f;
    }

    public Uri f() {
        return this.f28485d.s();
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i2, Parser<? extends T> parser) {
        this.f28485d = new StatsDataSource(dataSource);
        this.f28483b = dataSpec;
        this.f28484c = i2;
        this.f28486e = parser;
        this.f28482a = LoadEventInfo.a();
    }
}
