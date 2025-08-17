package androidx.media3.exoplayer.hls;

import androidx.media3.datasource.DataSource;

public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f6293a;

    public DefaultHlsDataSourceFactory(DataSource.Factory factory) {
        this.f6293a = factory;
    }

    public DataSource a(int i2) {
        return this.f6293a.a();
    }
}
