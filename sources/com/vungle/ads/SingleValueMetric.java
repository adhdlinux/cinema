package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

public final class SingleValueMetric extends Metric {
    private Long value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleValueMetric(Sdk$SDKMetric.SDKMetricType sDKMetricType) {
        super(sDKMetricType);
        Intrinsics.f(sDKMetricType, "metricType");
    }

    public final void addValue(long j2) {
        Long l2 = this.value;
        this.value = Long.valueOf((l2 != null ? l2.longValue() : 0) + j2);
    }

    /* renamed from: getValue  reason: collision with other method in class */
    public final Long m136getValue() {
        return this.value;
    }

    public final void markTime() {
        this.value = Long.valueOf(System.currentTimeMillis());
    }

    public final void setValue(Long l2) {
        this.value = l2;
    }

    public long getValue() {
        Long l2 = this.value;
        if (l2 != null) {
            return l2.longValue();
        }
        return 0;
    }
}
