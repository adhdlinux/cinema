package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

public abstract class Metric {
    private String meta;
    private Sdk$SDKMetric.SDKMetricType metricType;

    public Metric(Sdk$SDKMetric.SDKMetricType sDKMetricType) {
        Intrinsics.f(sDKMetricType, "metricType");
        this.metricType = sDKMetricType;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final Sdk$SDKMetric.SDKMetricType getMetricType() {
        return this.metricType;
    }

    public abstract long getValue();

    public final void setMeta(String str) {
        this.meta = str;
    }

    public final void setMetricType(Sdk$SDKMetric.SDKMetricType sDKMetricType) {
        Intrinsics.f(sDKMetricType, "<set-?>");
        this.metricType = sDKMetricType;
    }
}
