package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TransportRuntime implements TransportInternal {

    /* renamed from: e  reason: collision with root package name */
    private static volatile TransportRuntimeComponent f22525e;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f22526a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f22527b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f22528c;

    /* renamed from: d  reason: collision with root package name */
    private final Uploader f22529d;

    @Inject
    TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f22526a = clock;
        this.f22527b = clock2;
        this.f22528c = scheduler;
        this.f22529d = uploader;
        workInitializer.c();
    }

    private EventInternal b(SendRequest sendRequest) {
        return EventInternal.a().i(this.f22526a.a()).k(this.f22527b.a()).j(sendRequest.g()).h(new EncodedPayload(sendRequest.b(), sendRequest.d())).g(sendRequest.c().a()).d();
    }

    public static TransportRuntime c() {
        TransportRuntimeComponent transportRuntimeComponent = f22525e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.f();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<Encoding> d(Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet(((EncodedDestination) destination).a());
        }
        return Collections.singleton(Encoding.b("proto"));
    }

    public static void f(Context context) {
        if (f22525e == null) {
            synchronized (TransportRuntime.class) {
                if (f22525e == null) {
                    f22525e = DaggerTransportRuntimeComponent.i().a(context).build();
                }
            }
        }
    }

    public void a(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f22528c.a(sendRequest.f().f(sendRequest.c().c()), b(sendRequest), transportScheduleCallback);
    }

    public Uploader e() {
        return this.f22529d;
    }

    public TransportFactory g(Destination destination) {
        return new TransportFactoryImpl(d(destination), TransportContext.a().b(destination.getName()).c(destination.getExtras()).a(), this);
    }
}
