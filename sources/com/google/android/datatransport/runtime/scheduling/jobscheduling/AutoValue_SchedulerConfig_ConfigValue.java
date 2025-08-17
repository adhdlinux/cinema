package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final long f22627a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22628b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f22629c;

    static final class Builder extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f22630a;

        /* renamed from: b  reason: collision with root package name */
        private Long f22631b;

        /* renamed from: c  reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f22632c;

        Builder() {
        }

        public SchedulerConfig.ConfigValue a() {
            String str = "";
            if (this.f22630a == null) {
                str = str + " delta";
            }
            if (this.f22631b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f22632c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f22630a.longValue(), this.f22631b.longValue(), this.f22632c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SchedulerConfig.ConfigValue.Builder b(long j2) {
            this.f22630a = Long.valueOf(j2);
            return this;
        }

        public SchedulerConfig.ConfigValue.Builder c(Set<SchedulerConfig.Flag> set) {
            if (set != null) {
                this.f22632c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public SchedulerConfig.ConfigValue.Builder d(long j2) {
            this.f22631b = Long.valueOf(j2);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f22627a;
    }

    /* access modifiers changed from: package-private */
    public Set<SchedulerConfig.Flag> c() {
        return this.f22629c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.f22628b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.f22627a == configValue.b() && this.f22628b == configValue.d() && this.f22629c.equals(configValue.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f22627a;
        long j3 = this.f22628b;
        return this.f22629c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f22627a + ", maxAllowedDelay=" + this.f22628b + ", flags=" + this.f22629c + "}";
    }

    private AutoValue_SchedulerConfig_ConfigValue(long j2, long j3, Set<SchedulerConfig.Flag> set) {
        this.f22627a = j2;
        this.f22628b = j3;
        this.f22629c = set;
    }
}
