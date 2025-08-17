package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.omsdk.OMInjector;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$6 extends ServiceLocator.Creator<OMInjector> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$6(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public OMInjector create() {
        return new OMInjector(this.this$0.ctx);
    }
}
