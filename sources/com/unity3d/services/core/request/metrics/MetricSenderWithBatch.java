package com.unity3d.services.core.request.metrics;

import android.text.TextUtils;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

public final class MetricSenderWithBatch extends MetricSenderBase {
    private SDKMetricsSender _original;
    private final LinkedBlockingQueue<Metric> _queue = new LinkedBlockingQueue<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetricSenderWithBatch(SDKMetricsSender sDKMetricsSender, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        Intrinsics.f(sDKMetricsSender, "_original");
        Intrinsics.f(initializationStatusReader, "initializationStatusReader");
        this._original = sDKMetricsSender;
    }

    public boolean areMetricsEnabledForCurrentSession() {
        return this._original.areMetricsEnabledForCurrentSession();
    }

    public String getMetricEndPoint() {
        return this._original.getMetricEndPoint();
    }

    public void sendEvent(String str, String str2, Map<String, String> map) {
        boolean z2;
        Intrinsics.f(str, "event");
        Intrinsics.f(map, "tags");
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            DeviceLog.debug("Metric event not sent due to being empty: " + str);
            return;
        }
        sendMetrics(CollectionsKt__CollectionsJVMKt.b(new Metric(str, str2, map)));
    }

    public void sendMetric(Metric metric) {
        Intrinsics.f(metric, "metric");
        sendMetrics(CollectionsKt__CollectionsJVMKt.b(metric));
    }

    public synchronized void sendMetrics(List<Metric> list) {
        Intrinsics.f(list, "metrics");
        this._queue.addAll(list);
        if (!TextUtils.isEmpty(this._original.getMetricEndPoint()) && this._queue.size() > 0) {
            ArrayList arrayList = new ArrayList();
            this._queue.drainTo(arrayList);
            this._original.sendMetrics(arrayList);
        }
    }

    public final void sendQueueIfNeeded() {
        sendMetrics(CollectionsKt__CollectionsKt.f());
    }

    public final void updateOriginal(SDKMetricsSender sDKMetricsSender) {
        Intrinsics.f(sDKMetricsSender, "metrics");
        this._original = sDKMetricsSender;
    }
}
