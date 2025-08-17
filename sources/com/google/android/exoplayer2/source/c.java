package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26049b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f26050c;

    public /* synthetic */ c(Class cls, DataSource.Factory factory) {
        this.f26049b = cls;
        this.f26050c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.k(this.f26049b, this.f26050c);
    }
}
