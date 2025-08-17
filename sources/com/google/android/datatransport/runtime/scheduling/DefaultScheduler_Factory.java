package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f22615a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f22616b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f22617c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EventStore> f22618d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f22619e;

    public DefaultScheduler_Factory(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f22615a = provider;
        this.f22616b = provider2;
        this.f22617c = provider3;
        this.f22618d = provider4;
        this.f22619e = provider5;
    }

    public static DefaultScheduler_Factory a(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultScheduler c(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    /* renamed from: b */
    public DefaultScheduler get() {
        return c(this.f22615a.get(), this.f22616b.get(), this.f22617c.get(), this.f22618d.get(), this.f22619e.get());
    }
}
