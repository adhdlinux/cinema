package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f22553a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f22554b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Clock> f22555c;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f22553a = provider;
        this.f22554b = provider2;
        this.f22555c = provider3;
    }

    public static CreationContextFactory_Factory a(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static CreationContextFactory c(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    /* renamed from: b */
    public CreationContextFactory get() {
        return c(this.f22553a.get(), this.f22554b.get(), this.f22555c.get());
    }
}
