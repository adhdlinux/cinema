package com.vungle.ads;

import android.content.Context;
import com.google.android.gms.ads.RequestConfiguration;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class ServiceLocator$Companion$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceLocator$Companion$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final T invoke() {
        ServiceLocator instance = ServiceLocator.Companion.getInstance(this.$context);
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return instance.getService(Object.class);
    }
}
