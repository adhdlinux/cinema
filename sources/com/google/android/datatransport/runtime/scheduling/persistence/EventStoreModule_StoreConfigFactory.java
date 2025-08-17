package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_StoreConfigFactory f22714a = new EventStoreModule_StoreConfigFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_StoreConfigFactory a() {
        return InstanceHolder.f22714a;
    }

    public static EventStoreConfig c() {
        return (EventStoreConfig) Preconditions.c(EventStoreModule.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public EventStoreConfig get() {
        return c();
    }
}
