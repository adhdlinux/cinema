package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* renamed from: b  reason: collision with root package name */
    private final long f22697b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22698c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22699d;

    /* renamed from: e  reason: collision with root package name */
    private final long f22700e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22701f;

    static final class Builder extends EventStoreConfig.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f22702a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f22703b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f22704c;

        /* renamed from: d  reason: collision with root package name */
        private Long f22705d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f22706e;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig a() {
            String str = "";
            if (this.f22702a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f22703b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f22704c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f22705d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f22706e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.f22702a.longValue(), this.f22703b.intValue(), this.f22704c.intValue(), this.f22705d.longValue(), this.f22706e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder b(int i2) {
            this.f22704c = Integer.valueOf(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder c(long j2) {
            this.f22705d = Long.valueOf(j2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder d(int i2) {
            this.f22703b = Integer.valueOf(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder e(int i2) {
            this.f22706e = Integer.valueOf(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public EventStoreConfig.Builder f(long j2) {
            this.f22702a = Long.valueOf(j2);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f22699d;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f22700e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f22698c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f22701f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        if (this.f22697b == eventStoreConfig.f() && this.f22698c == eventStoreConfig.d() && this.f22699d == eventStoreConfig.b() && this.f22700e == eventStoreConfig.c() && this.f22701f == eventStoreConfig.e()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f22697b;
    }

    public int hashCode() {
        long j2 = this.f22697b;
        long j3 = this.f22700e;
        return this.f22701f ^ ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f22698c) * 1000003) ^ this.f22699d) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f22697b + ", loadBatchSize=" + this.f22698c + ", criticalSectionEnterTimeoutMs=" + this.f22699d + ", eventCleanUpAge=" + this.f22700e + ", maxBlobByteSizePerRow=" + this.f22701f + "}";
    }

    private AutoValue_EventStoreConfig(long j2, int i2, int i3, long j3, int i4) {
        this.f22697b = j2;
        this.f22698c = i2;
        this.f22699d = i3;
        this.f22700e = j3;
        this.f22701f = i4;
    }
}
