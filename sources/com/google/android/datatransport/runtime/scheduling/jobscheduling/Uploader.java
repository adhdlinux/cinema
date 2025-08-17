package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22642a;

    /* renamed from: b  reason: collision with root package name */
    private final BackendRegistry f22643b;

    /* renamed from: c  reason: collision with root package name */
    private final EventStore f22644c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkScheduler f22645d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f22646e;

    /* renamed from: f  reason: collision with root package name */
    private final SynchronizationGuard f22647f;

    /* renamed from: g  reason: collision with root package name */
    private final Clock f22648g;

    /* renamed from: h  reason: collision with root package name */
    private final Clock f22649h;

    /* renamed from: i  reason: collision with root package name */
    private final ClientHealthMetricsStore f22650i;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f22642a = context;
        this.f22643b = backendRegistry;
        this.f22644c = eventStore;
        this.f22645d = workScheduler;
        this.f22646e = executor;
        this.f22647f = synchronizationGuard;
        this.f22648g = clock;
        this.f22649h = clock2;
        this.f22650i = clientHealthMetricsStore;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean l(TransportContext transportContext) {
        return Boolean.valueOf(this.f22644c.K(transportContext));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Iterable m(TransportContext transportContext) {
        return this.f22644c.T(transportContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, TransportContext transportContext, long j2) {
        this.f22644c.M(iterable);
        this.f22644c.m(transportContext, this.f22648g.a() + j2);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f22644c.b(iterable);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f22650i.a();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f22650i.k((long) ((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(TransportContext transportContext, long j2) {
        this.f22644c.m(transportContext, this.f22648g.a() + j2);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(TransportContext transportContext, int i2) {
        this.f22645d.a(transportContext, i2 + 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.f22645d.a(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void t(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.f22647f     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.f22644c     // Catch:{ SynchronizationException -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.e r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.e     // Catch:{ SynchronizationException -> 0x0026 }
            r2.<init>(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.f(r2)     // Catch:{ SynchronizationException -> 0x0026 }
            boolean r0 = r3.k()     // Catch:{ SynchronizationException -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.f22647f     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.f r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.f     // Catch:{ SynchronizationException -> 0x0026 }
            r1.<init>(r3, r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.f(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.u(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.f22645d     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.a(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.t(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    public EventInternal j(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.f22647f;
        ClientHealthMetricsStore clientHealthMetricsStore = this.f22650i;
        Objects.requireNonNull(clientHealthMetricsStore);
        return transportBackend.a(EventInternal.a().i(this.f22648g.a()).k(this.f22649h.a()).j("GDT_CLIENT_METRICS").h(new EncodedPayload(Encoding.b("proto"), ((ClientMetrics) synchronizationGuard.f(new d(clientHealthMetricsStore))).f())).d());
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f22642a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void u(TransportContext transportContext, int i2) {
        BackendResponse backendResponse;
        TransportBackend transportBackend = this.f22643b.get(transportContext.b());
        long j2 = 0;
        while (true) {
            long j3 = j2;
            while (((Boolean) this.f22647f.f(new g(this, transportContext))).booleanValue()) {
                Iterable<PersistedEvent> iterable = (Iterable) this.f22647f.f(new h(this, transportContext));
                if (iterable.iterator().hasNext()) {
                    if (transportBackend == null) {
                        Logging.a("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                        backendResponse = BackendResponse.a();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (PersistedEvent b2 : iterable) {
                            arrayList.add(b2.b());
                        }
                        if (transportContext.e()) {
                            arrayList.add(j(transportBackend));
                        }
                        backendResponse = transportBackend.b(BackendRequest.a().b(arrayList).c(transportContext.c()).a());
                    }
                    if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                        this.f22647f.f(new i(this, iterable, transportContext, j3));
                        this.f22645d.b(transportContext, i2 + 1, true);
                        return;
                    }
                    this.f22647f.f(new j(this, iterable));
                    if (backendResponse.c() == BackendResponse.Status.OK) {
                        j2 = Math.max(j3, backendResponse.b());
                        if (transportContext.e()) {
                            this.f22647f.f(new k(this));
                        }
                    } else if (backendResponse.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                        HashMap hashMap = new HashMap();
                        for (PersistedEvent b3 : iterable) {
                            String j4 = b3.b().j();
                            if (!hashMap.containsKey(j4)) {
                                hashMap.put(j4, 1);
                            } else {
                                hashMap.put(j4, Integer.valueOf(((Integer) hashMap.get(j4)).intValue() + 1));
                            }
                        }
                        this.f22647f.f(new l(this, hashMap));
                    }
                } else {
                    return;
                }
            }
            this.f22647f.f(new m(this, transportContext, j3));
            return;
        }
    }

    public void v(TransportContext transportContext, int i2, Runnable runnable) {
        this.f22646e.execute(new c(this, transportContext, i2, runnable));
    }
}
