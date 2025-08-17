package com.unity3d.services.core.request.metrics;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public interface SDKMetricsSender {

    public static final class DefaultImpls {
        public static void sendEvent(SDKMetricsSender sDKMetricsSender, String str) {
            Intrinsics.f(str, "event");
            sendEvent$default(sDKMetricsSender, str, (String) null, (Map) null, 4, (Object) null);
        }

        public static /* synthetic */ void sendEvent$default(SDKMetricsSender sDKMetricsSender, String str, String str2, Map map, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str2 = null;
                }
                if ((i2 & 4) != 0) {
                    map = MapsKt__MapsKt.g();
                }
                sDKMetricsSender.sendEvent(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
    }

    boolean areMetricsEnabledForCurrentSession();

    String getMetricEndPoint();

    void sendEvent(String str);

    void sendEvent(String str, String str2, Map<String, String> map);

    void sendMetric(Metric metric);

    void sendMetricWithInitState(Metric metric);

    void sendMetrics(List<Metric> list);
}
