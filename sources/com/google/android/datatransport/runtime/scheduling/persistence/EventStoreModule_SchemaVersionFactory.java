package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_SchemaVersionFactory f22713a = new EventStoreModule_SchemaVersionFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_SchemaVersionFactory a() {
        return InstanceHolder.f22713a;
    }

    public static int c() {
        return EventStoreModule.c();
    }

    /* renamed from: b */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
