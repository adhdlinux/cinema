package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.executor.SDKExecutors;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$5 extends ServiceLocator.Creator<Executors> {
    ServiceLocator$buildCreators$5(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
    }

    public Executors create() {
        return new SDKExecutors();
    }
}
