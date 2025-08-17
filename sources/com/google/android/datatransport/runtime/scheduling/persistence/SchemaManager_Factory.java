package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f22738a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<String> f22739b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Integer> f22740c;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f22738a = provider;
        this.f22739b = provider2;
        this.f22740c = provider3;
    }

    public static SchemaManager_Factory a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new SchemaManager_Factory(provider, provider2, provider3);
    }

    public static SchemaManager c(Context context, String str, int i2) {
        return new SchemaManager(context, str, i2);
    }

    /* renamed from: b */
    public SchemaManager get() {
        return c(this.f22738a.get(), this.f22739b.get(), this.f22740c.get().intValue());
    }
}
