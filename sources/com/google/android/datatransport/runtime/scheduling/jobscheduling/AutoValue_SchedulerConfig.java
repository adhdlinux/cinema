package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f22625a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.ConfigValue> f22626b;

    AutoValue_SchedulerConfig(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock != null) {
            this.f22625a = clock;
            if (map != null) {
                this.f22626b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public Clock e() {
        return this.f22625a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (!this.f22625a.equals(schedulerConfig.e()) || !this.f22626b.equals(schedulerConfig.h())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Map<Priority, SchedulerConfig.ConfigValue> h() {
        return this.f22626b;
    }

    public int hashCode() {
        return ((this.f22625a.hashCode() ^ 1000003) * 1000003) ^ this.f22626b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f22625a + ", values=" + this.f22626b + "}";
    }
}
