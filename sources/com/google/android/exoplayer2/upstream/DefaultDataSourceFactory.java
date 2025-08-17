package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

@Deprecated
public final class DefaultDataSourceFactory implements DataSource.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28408a;

    /* renamed from: b  reason: collision with root package name */
    private final TransferListener f28409b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource.Factory f28410c;

    public DefaultDataSourceFactory(Context context, String str) {
        this(context, str, (TransferListener) null);
    }

    /* renamed from: b */
    public DefaultDataSource a() {
        DefaultDataSource defaultDataSource = new DefaultDataSource(this.f28408a, this.f28410c.a());
        TransferListener transferListener = this.f28409b;
        if (transferListener != null) {
            defaultDataSource.p(transferListener);
        }
        return defaultDataSource;
    }

    public DefaultDataSourceFactory(Context context, String str, TransferListener transferListener) {
        this(context, transferListener, (DataSource.Factory) new DefaultHttpDataSource.Factory().c(str));
    }

    public DefaultDataSourceFactory(Context context, TransferListener transferListener, DataSource.Factory factory) {
        this.f28408a = context.getApplicationContext();
        this.f28409b = transferListener;
        this.f28410c = factory;
    }
}
