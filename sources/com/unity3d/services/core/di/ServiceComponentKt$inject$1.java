package com.unity3d.services.core.di;

import com.google.android.gms.ads.RequestConfiguration;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

public final class ServiceComponentKt$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ String $named;
    final /* synthetic */ ServiceComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceComponentKt$inject$1(ServiceComponent serviceComponent, String str) {
        super(0);
        this.$this_inject = serviceComponent;
        this.$named = str;
    }

    public final T invoke() {
        ServiceComponent serviceComponent = this.$this_inject;
        String str = this.$named;
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return registry.getService(str, Reflection.b(Object.class));
    }
}
