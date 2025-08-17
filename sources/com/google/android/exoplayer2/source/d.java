package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26135b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f26136c;

    public /* synthetic */ d(Class cls, DataSource.Factory factory) {
        this.f26135b = cls;
        this.f26136c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.k(this.f26135b, this.f26136c);
    }
}
