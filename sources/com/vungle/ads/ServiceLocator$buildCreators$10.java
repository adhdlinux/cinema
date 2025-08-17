package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$10 extends ServiceLocator.Creator<BidTokenEncoder> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$10(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public BidTokenEncoder create() {
        return new BidTokenEncoder(this.this$0.ctx);
    }
}
