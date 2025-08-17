package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.omsdk.OMTracker;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$7 extends ServiceLocator.Creator<OMTracker.Factory> {
    ServiceLocator$buildCreators$7(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
    }

    public OMTracker.Factory create() {
        return new OMTracker.Factory();
    }
}
