package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.omsdk.OMTracker;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class BannerView$special$$inlined$inject$2 extends Lambda implements Function0<OMTracker.Factory> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerView$special$$inlined$inject$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.OMTracker$Factory, java.lang.Object] */
    public final OMTracker.Factory invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(OMTracker.Factory.class);
    }
}
