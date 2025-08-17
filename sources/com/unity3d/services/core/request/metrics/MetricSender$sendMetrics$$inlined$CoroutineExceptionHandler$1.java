package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import java.util.List;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

public final class MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ List $metrics$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, List list) {
        super(key);
        this.$metrics$inlined = list;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        DeviceLog.debug("Metric " + this.$metrics$inlined + " failed to send with error: " + th);
    }
}
