package com.unity3d.services;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.Map;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

public final class SDKErrorHandler implements CoroutineExceptionHandler {
    private final ISDKDispatchers dispatchers;
    private final CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.D0;
    private final SDKMetricsSender sdkMetricsSender;

    public SDKErrorHandler(ISDKDispatchers iSDKDispatchers, SDKMetricsSender sDKMetricsSender) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        Intrinsics.f(sDKMetricsSender, "sdkMetricsSender");
        this.dispatchers = iSDKDispatchers;
        this.sdkMetricsSender = sDKMetricsSender;
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }

    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineExceptionHandler.DefaultImpls.a(this, r2, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key2) {
        return CoroutineExceptionHandler.DefaultImpls.b(this, key2);
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        String str;
        Intrinsics.f(coroutineContext, "context");
        Intrinsics.f(th, "exception");
        String fileName = th.getStackTrace()[0].getFileName();
        Intrinsics.e(fileName, "exception.stackTrace[0].fileName");
        int lineNumber = th.getStackTrace()[0].getLineNumber();
        if (th instanceof NullPointerException) {
            str = "native_exception_npe";
        } else if (th instanceof OutOfMemoryError) {
            str = "native_exception_oom";
        } else if (th instanceof IllegalStateException) {
            str = "native_exception_ise";
        } else if (th instanceof RuntimeException) {
            str = "native_exception_re";
        } else if (th instanceof SecurityException) {
            str = "native_exception_se";
        } else {
            str = "native_exception";
        }
        String str2 = str;
        sendMetric(new Metric(str2, '{' + fileName + "}_" + lineNumber, (Map) null, 4, (DefaultConstructorMarker) null));
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key2) {
        return CoroutineExceptionHandler.DefaultImpls.c(this, key2);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.DefaultImpls.d(this, coroutineContext);
    }

    public CoroutineExceptionHandler.Key getKey() {
        return this.key;
    }
}
