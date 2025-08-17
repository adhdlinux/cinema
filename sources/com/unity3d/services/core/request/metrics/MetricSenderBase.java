package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.properties.InitializationStatusReader;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

public abstract class MetricSenderBase implements SDKMetricsSender {
    private final InitializationStatusReader _initStatusReader;

    public MetricSenderBase(InitializationStatusReader initializationStatusReader) {
        Intrinsics.f(initializationStatusReader, "_initStatusReader");
        this._initStatusReader = initializationStatusReader;
    }

    public void sendEvent(String str) {
        SDKMetricsSender.DefaultImpls.sendEvent(this, str);
    }

    public void sendMetricWithInitState(Metric metric) {
        Intrinsics.f(metric, "metric");
        sendMetric(Metric.copy$default(metric, (String) null, (Object) null, MapsKt__MapsKt.o(metric.getTags(), MapsKt__MapsJVMKt.e(TuplesKt.a(AdOperationMetric.INIT_STATE, this._initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState())))), 3, (Object) null));
    }
}
