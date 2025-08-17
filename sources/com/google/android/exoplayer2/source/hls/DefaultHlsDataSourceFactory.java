package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.DataSource;

public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f26387a;

    public DefaultHlsDataSourceFactory(DataSource.Factory factory) {
        this.f26387a = factory;
    }

    public DataSource a(int i2) {
        return this.f26387a.a();
    }
}
