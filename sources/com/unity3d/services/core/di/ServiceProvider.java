package com.unity3d.services.core.di;

import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.LegacyHttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;

public final class ServiceProvider implements IServiceProvider {
    public static final ServiceProvider INSTANCE;
    public static final String NAMED_SDK = "sdk";
    private static final IServicesRegistry serviceRegistry;

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    private ServiceProvider() {
    }

    /* access modifiers changed from: private */
    public final HttpClient provideHttpClient(ISDKDispatchers iSDKDispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage) {
        IExperiments experiments;
        ServiceProvider$provideHttpClient$config$1 serviceProvider$provideHttpClient$config$1 = new ServiceProvider$provideHttpClient$config$1(configFileFromLocalStorage, (Continuation<? super ServiceProvider$provideHttpClient$config$1>) null);
        boolean z2 = true;
        Configuration configuration = (Configuration) BuildersKt__BuildersKt.b((CoroutineContext) null, serviceProvider$provideHttpClient$config$1, 1, (Object) null);
        if (configuration == null || (experiments = configuration.getExperiments()) == null || !experiments.isOkHttpEnabled()) {
            z2 = false;
        }
        if (z2) {
            return new OkHttp3Client(iSDKDispatchers, new OkHttpClient());
        }
        return new LegacyHttpClient(iSDKDispatchers);
    }

    /* access modifiers changed from: private */
    public final ISDKDispatchers provideSDKDispatchers() {
        return new SDKDispatchers();
    }

    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler provideSDKErrorHandler(ISDKDispatchers iSDKDispatchers, SDKMetricsSender sDKMetricsSender) {
        return new SDKErrorHandler(iSDKDispatchers, sDKMetricsSender);
    }

    /* access modifiers changed from: private */
    public final SDKMetricsSender provideSDKMetricSender() {
        SDKMetricsSender instance = SDKMetrics.getInstance();
        Intrinsics.e(instance, "getInstance()");
        return instance;
    }

    /* access modifiers changed from: private */
    public final CoroutineScope provideSDKScope(ISDKDispatchers iSDKDispatchers, CoroutineExceptionHandler coroutineExceptionHandler) {
        return CoroutineScopeKt.a(iSDKDispatchers.getDefault().plus(SupervisorKt.b((Job) null, 1, (Object) null)).plus(coroutineExceptionHandler));
    }

    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(ServiceProvider$initialize$1.INSTANCE);
    }
}
