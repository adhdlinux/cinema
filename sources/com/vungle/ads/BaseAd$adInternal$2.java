package com.vungle.ads;

import com.vungle.ads.internal.AdInternal;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class BaseAd$adInternal$2 extends Lambda implements Function0<AdInternal> {
    final /* synthetic */ BaseAd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAd$adInternal$2(BaseAd baseAd) {
        super(0);
        this.this$0 = baseAd;
    }

    public final AdInternal invoke() {
        BaseAd baseAd = this.this$0;
        AdInternal constructAdInternal$vungle_ads_release = baseAd.constructAdInternal$vungle_ads_release(baseAd.getContext());
        constructAdInternal$vungle_ads_release.setLogEntry$vungle_ads_release(this.this$0.getLogEntry$vungle_ads_release());
        return constructAdInternal$vungle_ads_release;
    }
}
