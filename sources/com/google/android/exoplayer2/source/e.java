package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f26375c;

    public /* synthetic */ e(Class cls, DataSource.Factory factory) {
        this.f26374b = cls;
        this.f26375c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.k(this.f26374b, this.f26375c);
    }
}
