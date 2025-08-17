package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f22621a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f22622b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SchedulerConfig> f22623c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Clock> f22624d;

    public SchedulingModule_WorkSchedulerFactory(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.f22621a = provider;
        this.f22622b = provider2;
        this.f22623c = provider3;
        this.f22624d = provider4;
    }

    public static SchedulingModule_WorkSchedulerFactory a(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        return new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
    }

    public static WorkScheduler c(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.c(SchedulingModule.a(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public WorkScheduler get() {
        return c(this.f22621a.get(), this.f22622b.get(), this.f22623c.get(), this.f22624d.get());
    }
}
