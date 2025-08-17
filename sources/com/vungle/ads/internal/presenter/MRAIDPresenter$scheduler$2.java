package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.util.HandlerScheduler;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MRAIDPresenter$scheduler$2 extends Lambda implements Function0<HandlerScheduler> {
    public static final MRAIDPresenter$scheduler$2 INSTANCE = new MRAIDPresenter$scheduler$2();

    MRAIDPresenter$scheduler$2() {
        super(0);
    }

    public final HandlerScheduler invoke() {
        return new HandlerScheduler();
    }
}
