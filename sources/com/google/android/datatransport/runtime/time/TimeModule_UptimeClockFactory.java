package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TimeModule_UptimeClockFactory f22777a = new TimeModule_UptimeClockFactory();

        private InstanceHolder() {
        }
    }

    public static TimeModule_UptimeClockFactory a() {
        return InstanceHolder.f22777a;
    }

    public static Clock c() {
        return (Clock) Preconditions.c(TimeModule.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public Clock get() {
        return c();
    }
}
