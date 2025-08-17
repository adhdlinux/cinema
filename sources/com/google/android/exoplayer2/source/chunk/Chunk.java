package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import java.util.Map;

public abstract class Chunk implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final long f26078a = LoadEventInfo.a();

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f26079b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26080c;

    /* renamed from: d  reason: collision with root package name */
    public final Format f26081d;

    /* renamed from: e  reason: collision with root package name */
    public final int f26082e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f26083f;

    /* renamed from: g  reason: collision with root package name */
    public final long f26084g;

    /* renamed from: h  reason: collision with root package name */
    public final long f26085h;

    /* renamed from: i  reason: collision with root package name */
    protected final StatsDataSource f26086i;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, Object obj, long j2, long j3) {
        this.f26086i = new StatsDataSource(dataSource);
        this.f26079b = (DataSpec) Assertions.e(dataSpec);
        this.f26080c = i2;
        this.f26081d = format;
        this.f26082e = i3;
        this.f26083f = obj;
        this.f26084g = j2;
        this.f26085h = j3;
    }

    public final long c() {
        return this.f26086i.q();
    }

    public final long d() {
        return this.f26085h - this.f26084g;
    }

    public final Map<String, List<String>> e() {
        return this.f26086i.t();
    }

    public final Uri f() {
        return this.f26086i.s();
    }
}
