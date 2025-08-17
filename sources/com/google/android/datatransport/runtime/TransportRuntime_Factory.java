package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f22530a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f22531b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Scheduler> f22532c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Uploader> f22533d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<WorkInitializer> f22534e;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.f22530a = provider;
        this.f22531b = provider2;
        this.f22532c = provider3;
        this.f22533d = provider4;
        this.f22534e = provider5;
    }

    public static TransportRuntime_Factory a(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime c(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    /* renamed from: b */
    public TransportRuntime get() {
        return c(this.f22530a.get(), this.f22531b.get(), this.f22532c.get(), this.f22533d.get(), this.f22534e.get());
    }
}
