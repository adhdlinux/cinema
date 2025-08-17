package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class EventStoreConfig {

    /* renamed from: a  reason: collision with root package name */
    static final EventStoreConfig f22710a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();

    @AutoValue.Builder
    static abstract class Builder {
        Builder() {
        }

        /* access modifiers changed from: package-private */
        public abstract EventStoreConfig a();

        /* access modifiers changed from: package-private */
        public abstract Builder b(int i2);

        /* access modifiers changed from: package-private */
        public abstract Builder c(long j2);

        /* access modifiers changed from: package-private */
        public abstract Builder d(int i2);

        /* access modifiers changed from: package-private */
        public abstract Builder e(int i2);

        /* access modifiers changed from: package-private */
        public abstract Builder f(long j2);
    }

    EventStoreConfig() {
    }

    static Builder a() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    /* access modifiers changed from: package-private */
    public abstract int b();

    /* access modifiers changed from: package-private */
    public abstract long c();

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract long f();
}
