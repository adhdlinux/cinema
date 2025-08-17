package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultMediaSourceFactory.DelegateFactoryLoader f26377b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f26378c;

    public /* synthetic */ g(DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
        this.f26377b = delegateFactoryLoader;
        this.f26378c = factory;
    }

    public final Object get() {
        return this.f26377b.k(this.f26378c);
    }
}
