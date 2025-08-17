package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.platform.AndroidPlatform;
import com.vungle.ads.internal.platform.Platform;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$4 extends ServiceLocator.Creator<Platform> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$4(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public Platform create() {
        return new AndroidPlatform(this.this$0.ctx, ((Executors) this.this$0.getOrBuild(Executors.class)).getUaExecutor());
    }
}
