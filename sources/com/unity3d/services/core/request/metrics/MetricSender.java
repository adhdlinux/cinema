package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public class MetricSender extends MetricSenderBase implements IServiceComponent {
    /* access modifiers changed from: private */
    public final MetricCommonTags commonTags;
    private final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    private final String metricEndPoint;
    /* access modifiers changed from: private */
    public final String metricSampleRate;
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    public final String sessionToken;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetricSender(Configuration configuration, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        Intrinsics.f(configuration, "configuration");
        Intrinsics.f(initializationStatusReader, "initializationStatusReader");
        MetricCommonTags metricCommonTags = new MetricCommonTags();
        metricCommonTags.updateWithConfig(configuration);
        this.commonTags = metricCommonTags;
        this.metricSampleRate = String.valueOf(MathKt__MathJVMKt.a(configuration.getMetricSampleRate()));
        this.sessionToken = configuration.getSessionToken();
        ServiceProvider serviceProvider = ServiceProvider.INSTANCE;
        ISDKDispatchers iSDKDispatchers = (ISDKDispatchers) serviceProvider.getRegistry().getService("", Reflection.b(ISDKDispatchers.class));
        this.dispatchers = iSDKDispatchers;
        this.httpClient = (HttpClient) serviceProvider.getRegistry().getService("", Reflection.b(HttpClient.class));
        this.scope = CoroutineScopeKt.a(iSDKDispatchers.getIo());
        this.metricEndPoint = configuration.getMetricsUrl();
    }

    public boolean areMetricsEnabledForCurrentSession() {
        return true;
    }

    public String getMetricEndPoint() {
        return this.metricEndPoint;
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
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
            DeviceLog.debug("Metric event not sent due to being null or empty: " + str);
            return;
        }
        sendMetrics(CollectionsKt__CollectionsJVMKt.b(new Metric(str, str2, map)));
    }

    public void sendMetric(Metric metric) {
        Intrinsics.f(metric, "metric");
        sendMetrics(CollectionsKt__CollectionsJVMKt.b(metric));
    }

    public void sendMetrics(List<Metric> list) {
        boolean z2;
        Intrinsics.f(list, "metrics");
        if (list.isEmpty()) {
            DeviceLog.debug("Metrics event not send due to being empty");
            return;
        }
        String metricEndPoint2 = getMetricEndPoint();
        if (metricEndPoint2 == null || StringsKt__StringsJVMKt.v(metricEndPoint2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            DeviceLog.debug("Metrics: " + list + " was not sent to null or empty endpoint: " + getMetricEndPoint());
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.b(this.scope, new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.D0, list), (CoroutineStart) null, new MetricSender$sendMetrics$1(this, list, (Continuation<? super MetricSender$sendMetrics$1>) null), 2, (Object) null);
    }

    public final void shutdown() {
        this.commonTags.shutdown();
    }
}
