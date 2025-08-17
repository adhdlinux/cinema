package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f22664a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f22665b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f22666c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f22667d;

    public WorkInitializer_Factory(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f22664a = provider;
        this.f22665b = provider2;
        this.f22666c = provider3;
        this.f22667d = provider4;
    }

    public static WorkInitializer_Factory a(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer c(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    /* renamed from: b */
    public WorkInitializer get() {
        return c(this.f22664a.get(), this.f22665b.get(), this.f22666c.get(), this.f22667d.get());
    }
}
