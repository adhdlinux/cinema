package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_EventClockFactory implements Factory<Clock> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TimeModule_EventClockFactory f22776a = new TimeModule_EventClockFactory();

        private InstanceHolder() {
        }
    }

    public static TimeModule_EventClockFactory a() {
        return InstanceHolder.f22776a;
    }

    public static Clock b() {
        return (Clock) Preconditions.c(TimeModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public Clock get() {
        return b();
    }
}
