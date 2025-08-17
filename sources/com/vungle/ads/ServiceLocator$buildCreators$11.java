package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$11 extends ServiceLocator.Creator<PathProvider> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$11(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public PathProvider create() {
        return new PathProvider(this.this$0.ctx);
    }
}
