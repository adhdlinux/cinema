package com.unity3d.services.core.di;

import com.google.android.gms.ads.RequestConfiguration;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

public final class IServiceComponentKt$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ String $named;
    final /* synthetic */ IServiceComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IServiceComponentKt$inject$1(IServiceComponent iServiceComponent, String str) {
        super(0);
        this.$this_inject = iServiceComponent;
        this.$named = str;
    }

    public final T invoke() {
        IServiceComponent iServiceComponent = this.$this_inject;
        String str = this.$named;
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return registry.getService(str, Reflection.b(Object.class));
    }
}
