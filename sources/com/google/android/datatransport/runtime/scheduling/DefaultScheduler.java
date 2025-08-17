package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import g0.a;
import g0.b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

public class DefaultScheduler implements Scheduler {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f22609f = Logger.getLogger(TransportRuntime.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final WorkScheduler f22610a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f22611b;

    /* renamed from: c  reason: collision with root package name */
    private final BackendRegistry f22612c;

    /* renamed from: d  reason: collision with root package name */
    private final EventStore f22613d;

    /* renamed from: e  reason: collision with root package name */
    private final SynchronizationGuard f22614e;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f22611b = executor;
        this.f22612c = backendRegistry;
        this.f22610a = workScheduler;
        this.f22613d = eventStore;
        this.f22614e = synchronizationGuard;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d(TransportContext transportContext, EventInternal eventInternal) {
        this.f22613d.g0(transportContext, eventInternal);
        this.f22610a.a(transportContext, 1);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = this.f22612c.get(transportContext.b());
            if (transportBackend == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{transportContext.b()});
                f22609f.warning(format);
                transportScheduleCallback.a(new IllegalArgumentException(format));
                return;
            }
            this.f22614e.f(new b(this, transportContext, transportBackend.a(eventInternal)));
            transportScheduleCallback.a((Exception) null);
        } catch (Exception e2) {
            Logger logger = f22609f;
            logger.warning("Error scheduling event " + e2.getMessage());
            transportScheduleCallback.a(e2);
        }
    }

    public void a(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f22611b.execute(new a(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
