package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f22561a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CreationContextFactory> f22562b;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        this.f22561a = provider;
        this.f22562b = provider2;
    }

    public static MetadataBackendRegistry_Factory a(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    public static MetadataBackendRegistry c(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    /* renamed from: b */
    public MetadataBackendRegistry get() {
        return c(this.f22561a.get(), this.f22562b.get());
    }
}
