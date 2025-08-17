package com.vungle.ads.internal;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.Intrinsics;

public final class AdInternal$play$callbackWrapper$1 extends AdPlayCallbackWrapper {
    final /* synthetic */ AdInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdInternal$play$callbackWrapper$1(AdPlayCallback adPlayCallback, AdInternal adInternal) {
        super(adPlayCallback);
        this.this$0 = adInternal;
    }

    public void onAdEnd(String str) {
        this.this$0.setAdState(AdInternal.AdState.FINISHED);
        super.onAdEnd(str);
    }

    public void onAdStart(String str) {
        this.this$0.setAdState(AdInternal.AdState.PLAYING);
        this.this$0.getValidationToPresentMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getValidationToPresentMetric$vungle_ads_release(), this.this$0.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        super.onAdStart(str);
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        this.this$0.setAdState(AdInternal.AdState.ERROR);
        super.onFailure(vungleError);
    }
}
