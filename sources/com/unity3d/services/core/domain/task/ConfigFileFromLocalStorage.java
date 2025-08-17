package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class ConfigFileFromLocalStorage extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    public static final class Params implements BaseParams {
    }

    public ConfigFileFromLocalStorage(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_config");
    }

    public Object doWork(Params params, Continuation<? super Configuration> continuation) {
        return BuildersKt.e(this.dispatchers.getIo(), new ConfigFileFromLocalStorage$doWork$2((Continuation<? super ConfigFileFromLocalStorage$doWork$2>) null), continuation);
    }
}
