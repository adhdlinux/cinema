package androidx.media3.exoplayer.source.chunk;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import java.util.List;
import java.util.Map;

public abstract class Chunk implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final long f7217a = LoadEventInfo.a();

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f7218b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7219c;

    /* renamed from: d  reason: collision with root package name */
    public final Format f7220d;

    /* renamed from: e  reason: collision with root package name */
    public final int f7221e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f7222f;

    /* renamed from: g  reason: collision with root package name */
    public final long f7223g;

    /* renamed from: h  reason: collision with root package name */
    public final long f7224h;

    /* renamed from: i  reason: collision with root package name */
    protected final StatsDataSource f7225i;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, Object obj, long j2, long j3) {
        this.f7225i = new StatsDataSource(dataSource);
        this.f7218b = (DataSpec) Assertions.f(dataSpec);
        this.f7219c = i2;
        this.f7220d = format;
        this.f7221e = i3;
        this.f7222f = obj;
        this.f7223g = j2;
        this.f7224h = j3;
    }

    public final long c() {
        return this.f7225i.o();
    }

    public final long d() {
        return this.f7224h - this.f7223g;
    }

    public final Map<String, List<String>> e() {
        return this.f7225i.q();
    }

    public final Uri f() {
        return this.f7225i.p();
    }
}
