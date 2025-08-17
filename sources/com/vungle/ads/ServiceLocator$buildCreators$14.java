package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.signals.SignalManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$14 extends ServiceLocator.Creator<SignalManager> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$14(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public SignalManager create() {
        return new SignalManager(this.this$0.ctx);
    }
}
