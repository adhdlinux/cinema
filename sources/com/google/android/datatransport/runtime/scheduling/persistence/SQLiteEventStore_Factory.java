package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f22723a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f22724b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStoreConfig> f22725c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SchemaManager> f22726d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<String> f22727e;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        this.f22723a = provider;
        this.f22724b = provider2;
        this.f22725c = provider3;
        this.f22726d = provider4;
        this.f22727e = provider5;
    }

    public static SQLiteEventStore_Factory a(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SQLiteEventStore c(Clock clock, Clock clock2, Object obj, Object obj2, Lazy<String> lazy) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, lazy);
    }

    /* renamed from: b */
    public SQLiteEventStore get() {
        return c(this.f22723a.get(), this.f22724b.get(), this.f22725c.get(), this.f22726d.get(), DoubleCheck.a(this.f22727e));
    }
}
