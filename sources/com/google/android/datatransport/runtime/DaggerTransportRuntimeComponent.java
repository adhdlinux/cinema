package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {

    /* renamed from: b  reason: collision with root package name */
    private Provider<Executor> f22497b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<Context> f22498c;

    /* renamed from: d  reason: collision with root package name */
    private Provider f22499d;

    /* renamed from: e  reason: collision with root package name */
    private Provider f22500e;

    /* renamed from: f  reason: collision with root package name */
    private Provider f22501f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<String> f22502g;

    /* renamed from: h  reason: collision with root package name */
    private Provider<SQLiteEventStore> f22503h;

    /* renamed from: i  reason: collision with root package name */
    private Provider<SchedulerConfig> f22504i;

    /* renamed from: j  reason: collision with root package name */
    private Provider<WorkScheduler> f22505j;

    /* renamed from: k  reason: collision with root package name */
    private Provider<DefaultScheduler> f22506k;

    /* renamed from: l  reason: collision with root package name */
    private Provider<Uploader> f22507l;

    /* renamed from: m  reason: collision with root package name */
    private Provider<WorkInitializer> f22508m;

    /* renamed from: n  reason: collision with root package name */
    private Provider<TransportRuntime> f22509n;

    private static final class Builder implements TransportRuntimeComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f22510a;

        private Builder() {
        }

        /* renamed from: b */
        public Builder a(Context context) {
            this.f22510a = (Context) Preconditions.b(context);
            return this;
        }

        public TransportRuntimeComponent build() {
            Preconditions.a(this.f22510a, Context.class);
            return new DaggerTransportRuntimeComponent(this.f22510a);
        }
    }

    public static TransportRuntimeComponent.Builder i() {
        return new Builder();
    }

    private void k(Context context) {
        this.f22497b = DoubleCheck.b(ExecutionModule_ExecutorFactory.a());
        Factory a2 = InstanceFactory.a(context);
        this.f22498c = a2;
        CreationContextFactory_Factory a3 = CreationContextFactory_Factory.a(a2, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a());
        this.f22499d = a3;
        this.f22500e = DoubleCheck.b(MetadataBackendRegistry_Factory.a(this.f22498c, a3));
        this.f22501f = SchemaManager_Factory.a(this.f22498c, EventStoreModule_DbNameFactory.a(), EventStoreModule_SchemaVersionFactory.a());
        this.f22502g = EventStoreModule_PackageNameFactory.a(this.f22498c);
        this.f22503h = DoubleCheck.b(SQLiteEventStore_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), EventStoreModule_StoreConfigFactory.a(), this.f22501f, this.f22502g));
        SchedulingConfigModule_ConfigFactory b2 = SchedulingConfigModule_ConfigFactory.b(TimeModule_EventClockFactory.a());
        this.f22504i = b2;
        SchedulingModule_WorkSchedulerFactory a4 = SchedulingModule_WorkSchedulerFactory.a(this.f22498c, this.f22503h, b2, TimeModule_UptimeClockFactory.a());
        this.f22505j = a4;
        Provider<Executor> provider = this.f22497b;
        Provider provider2 = this.f22500e;
        Provider<SQLiteEventStore> provider3 = this.f22503h;
        this.f22506k = DefaultScheduler_Factory.a(provider, provider2, a4, provider3, provider3);
        Provider<Context> provider4 = this.f22498c;
        Provider provider5 = this.f22500e;
        Provider<SQLiteEventStore> provider6 = this.f22503h;
        this.f22507l = Uploader_Factory.a(provider4, provider5, provider6, this.f22505j, this.f22497b, provider6, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.f22503h);
        Provider<Executor> provider7 = this.f22497b;
        Provider<SQLiteEventStore> provider8 = this.f22503h;
        this.f22508m = WorkInitializer_Factory.a(provider7, provider8, this.f22505j, provider8);
        this.f22509n = DoubleCheck.b(TransportRuntime_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.f22506k, this.f22507l, this.f22508m));
    }

    /* access modifiers changed from: package-private */
    public EventStore a() {
        return this.f22503h.get();
    }

    /* access modifiers changed from: package-private */
    public TransportRuntime f() {
        return this.f22509n.get();
    }

    private DaggerTransportRuntimeComponent(Context context) {
        k(context);
    }
}
