package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.SDKExecutors;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class AdInternal$loadAd$$inlined$inject$2 extends Lambda implements Function0<SDKExecutors> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdInternal$loadAd$$inlined$inject$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.SDKExecutors, java.lang.Object] */
    public final SDKExecutors invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(SDKExecutors.class);
    }
}
