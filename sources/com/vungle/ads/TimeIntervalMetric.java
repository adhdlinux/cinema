package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

public class TimeIntervalMetric extends DualValueMetric {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType sDKMetricType) {
        super(sDKMetricType);
        Intrinsics.f(sDKMetricType, "metricType");
    }

    private final long calculateIntervalDuration() {
        long j2;
        long currentTime = getCurrentTime();
        Long valueSecond = getValueSecond();
        if (valueSecond != null) {
            j2 = valueSecond.longValue();
        } else {
            j2 = currentTime;
        }
        Long valueFirst = getValueFirst();
        if (valueFirst != null) {
            currentTime = valueFirst.longValue();
        }
        return j2 - currentTime;
    }

    private final long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public long getValue() {
        return calculateIntervalDuration();
    }

    public void markEnd() {
        setValueSecond(Long.valueOf(getCurrentTime()));
    }

    public void markStart() {
        setValueFirst(Long.valueOf(getCurrentTime()));
    }
}
