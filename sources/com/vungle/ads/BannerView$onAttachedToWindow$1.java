package com.vungle.ads;

import android.view.View;
import com.vungle.ads.internal.ImpressionTracker;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.Logger;

public final class BannerView$onAttachedToWindow$1 implements ImpressionTracker.ImpressionListener {
    final /* synthetic */ BannerView this$0;

    BannerView$onAttachedToWindow$1(BannerView bannerView) {
        this.this$0 = bannerView;
    }

    public void onImpression(View view) {
        Logger.Companion.d("BannerView", "ImpressionTracker checked the banner view become visible.");
        this.this$0.isOnImpressionCalled = true;
        this.this$0.checkHardwareAcceleration();
        MRAIDPresenter access$getPresenter$p = this.this$0.presenter;
        if (access$getPresenter$p != null) {
            access$getPresenter$p.start();
        }
    }

    public void onViewInvisible(View view) {
        if (!this.this$0.isInvisibleLogged.getAndSet(true)) {
            Logger.Companion.d("BannerView", "ImpressionTracker checked the banner view invisible on play.");
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.VIEW_NOT_VISIBLE_ON_PLAY), this.this$0.getAdvertisement().getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        }
    }
}
