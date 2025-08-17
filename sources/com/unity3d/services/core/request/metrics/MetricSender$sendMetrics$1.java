package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.BodyType;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@DebugMetadata(c = "com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1", f = "MetricSender.kt", l = {69}, m = "invokeSuspend")
final class MetricSender$sendMetrics$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Metric> $metrics;
    int label;
    final /* synthetic */ MetricSender this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MetricSender$sendMetrics$1(MetricSender metricSender, List<Metric> list, Continuation<? super MetricSender$sendMetrics$1> continuation) {
        super(2, continuation);
        this.this$0 = metricSender;
        this.$metrics = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MetricSender$sendMetrics$1(this.this$0, this.$metrics, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MetricSender$sendMetrics$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        boolean z2 = true;
        if (i2 == 0) {
            ResultKt.b(obj);
            String jSONObject = new JSONObject(new MetricsContainer(this.this$0.metricSampleRate, this.this$0.commonTags, this.$metrics, this.this$0.sessionToken).toMap()).toString();
            Intrinsics.e(jSONObject, "JSONObject(container.toMap()).toString()");
            String metricEndPoint = this.this$0.getMetricEndPoint();
            if (metricEndPoint == null) {
                metricEndPoint = "";
            }
            HttpRequest httpRequest = new HttpRequest(metricEndPoint, (String) null, RequestType.POST, jSONObject, (Map) null, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, 8178, (DefaultConstructorMarker) null);
            HttpClient access$getHttpClient$p = this.this$0.httpClient;
            this.label = 1;
            obj2 = access$getHttpClient$p.execute(httpRequest, this);
            if (obj2 == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpResponse httpResponse = (HttpResponse) obj2;
        if (httpResponse.getStatusCode() / 100 != 2) {
            z2 = false;
        }
        if (z2) {
            DeviceLog.debug("Metric " + this.$metrics + " sent to " + this.this$0.getMetricEndPoint());
        } else {
            DeviceLog.debug("Metric " + this.$metrics + " failed to send with response code: " + httpResponse.getStatusCode());
        }
        return Unit.f40298a;
    }
}
