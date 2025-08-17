package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

public abstract class DualValueMetric extends Metric {
    private Long valueFirst;
    private Long valueSecond;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DualValueMetric(Sdk$SDKMetric.SDKMetricType sDKMetricType) {
        super(sDKMetricType);
        Intrinsics.f(sDKMetricType, "metricType");
    }

    public final Long getValueFirst() {
        return this.valueFirst;
    }

    public final Long getValueSecond() {
        return this.valueSecond;
    }

    public final void setValueFirst(Long l2) {
        this.valueFirst = l2;
    }

    public final void setValueSecond(Long l2) {
        this.valueSecond = l2;
    }
}
