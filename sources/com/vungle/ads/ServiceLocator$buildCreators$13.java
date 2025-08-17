package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$13 extends ServiceLocator.Creator<ConcurrencyTimeoutProvider> {
    ServiceLocator$buildCreators$13(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
    }

    public ConcurrencyTimeoutProvider create() {
        return new ConcurrencyTimeoutProvider();
    }
}
