package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class Uploader_Factory implements Factory<Uploader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f22651a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f22652b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStore> f22653c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WorkScheduler> f22654d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f22655e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f22656f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Clock> f22657g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Clock> f22658h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<ClientHealthMetricsStore> f22659i;

    public Uploader_Factory(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        this.f22651a = provider;
        this.f22652b = provider2;
        this.f22653c = provider3;
        this.f22654d = provider4;
        this.f22655e = provider5;
        this.f22656f = provider6;
        this.f22657g = provider7;
        this.f22658h = provider8;
        this.f22659i = provider9;
    }

    public static Uploader_Factory a(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Uploader c(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    /* renamed from: b */
    public Uploader get() {
        return c(this.f22651a.get(), this.f22652b.get(), this.f22653c.get(), this.f22654d.get(), this.f22655e.get(), this.f22656f.get(), this.f22657g.get(), this.f22658h.get(), this.f22659i.get());
    }
}
