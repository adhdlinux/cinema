package com.unity3d.services;

import com.unity3d.services.core.di.IServiceComponent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

public final class UnityAdsSDK$special$$inlined$inject$default$1 extends Lambda implements Function0<CoroutineScope> {
    final /* synthetic */ String $named;
    final /* synthetic */ IServiceComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnityAdsSDK$special$$inlined$inject$default$1(IServiceComponent iServiceComponent, String str) {
        super(0);
        this.$this_inject = iServiceComponent;
        this.$named = str;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    public final CoroutineScope invoke() {
        IServiceComponent iServiceComponent = this.$this_inject;
        return iServiceComponent.getServiceProvider().getRegistry().getService(this.$named, Reflection.b(CoroutineScope.class));
    }
}
