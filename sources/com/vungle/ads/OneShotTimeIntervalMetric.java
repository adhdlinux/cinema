package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

public final class OneShotTimeIntervalMetric extends TimeIntervalMetric {
    private boolean alreadyLogged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneShotTimeIntervalMetric(Sdk$SDKMetric.SDKMetricType sDKMetricType) {
        super(sDKMetricType);
        Intrinsics.f(sDKMetricType, "metricType");
    }

    public final boolean alreadyMetered$vungle_ads_release() {
        return (getValueFirst() == null || getValueSecond() == null) ? false : true;
    }

    public final boolean isLogged() {
        return this.alreadyLogged;
    }

    public void markEnd() {
        if (getValueSecond() == null) {
            super.markEnd();
        }
    }

    public final void markLogged() {
        this.alreadyLogged = true;
    }

    public void markStart() {
        if (getValueFirst() == null) {
            super.markStart();
        }
    }
}
