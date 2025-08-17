package com.unity3d.services;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class UnityAdsSDK implements IServiceComponent {
    public static final UnityAdsSDK INSTANCE;
    private static final Lazy initializeSDK$delegate;
    private static final Lazy sdkScope$delegate;

    static {
        UnityAdsSDK unityAdsSDK = new UnityAdsSDK();
        INSTANCE = unityAdsSDK;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        sdkScope$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new UnityAdsSDK$special$$inlined$inject$default$1(unityAdsSDK, ServiceProvider.NAMED_SDK));
        initializeSDK$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new UnityAdsSDK$special$$inlined$inject$default$2(unityAdsSDK, ""));
    }

    private UnityAdsSDK() {
    }

    /* access modifiers changed from: private */
    public final InitializeSDK getInitializeSDK() {
        return (InitializeSDK) initializeSDK$delegate.getValue();
    }

    private final CoroutineScope getSdkScope() {
        return (CoroutineScope) sdkScope$delegate.getValue();
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public final Job initialize() {
        return BuildersKt__Builders_commonKt.b(getSdkScope(), (CoroutineContext) null, (CoroutineStart) null, new UnityAdsSDK$initialize$1((Continuation<? super UnityAdsSDK$initialize$1>) null), 3, (Object) null);
    }
}
