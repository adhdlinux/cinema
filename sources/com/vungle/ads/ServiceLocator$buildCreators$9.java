package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.locale.LocaleInfo;
import com.vungle.ads.internal.locale.SystemLocaleInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ServiceLocator$buildCreators$9 extends ServiceLocator.Creator<LocaleInfo> {
    ServiceLocator$buildCreators$9(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
    }

    public LocaleInfo create() {
        return new SystemLocaleInfo();
    }
}
