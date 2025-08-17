package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class EventStoreModule_DbNameFactory implements Factory<String> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final EventStoreModule_DbNameFactory f22711a = new EventStoreModule_DbNameFactory();

        private InstanceHolder() {
        }
    }

    public static EventStoreModule_DbNameFactory a() {
        return InstanceHolder.f22711a;
    }

    public static String b() {
        return (String) Preconditions.c(EventStoreModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public String get() {
        return b();
    }
}
