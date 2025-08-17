package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class WorkInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f22660a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f22661b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkScheduler f22662c;

    /* renamed from: d  reason: collision with root package name */
    private final SynchronizationGuard f22663d;

    @Inject
    WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f22660a = executor;
        this.f22661b = eventStore;
        this.f22662c = workScheduler;
        this.f22663d = synchronizationGuard;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d() {
        for (TransportContext a2 : this.f22661b.o()) {
            this.f22662c.a(a2, 1);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f22663d.f(new o(this));
    }

    public void c() {
        this.f22660a.execute(new n(this));
    }
}
