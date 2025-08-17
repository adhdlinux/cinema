package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EventStoreModule_PackageNameFactory implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f22712a;

    public EventStoreModule_PackageNameFactory(Provider<Context> provider) {
        this.f22712a = provider;
    }

    public static EventStoreModule_PackageNameFactory a(Provider<Context> provider) {
        return new EventStoreModule_PackageNameFactory(provider);
    }

    public static String c(Context context) {
        return (String) Preconditions.c(EventStoreModule.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public String get() {
        return c(this.f22712a.get());
    }
}
