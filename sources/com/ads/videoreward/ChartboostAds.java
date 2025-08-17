package com.ads.videoreward;

import android.app.Activity;
import android.content.Intent;
import com.ads.videoreward.AdsBase;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ClickEvent;
import com.chartboost.sdk.events.DismissEvent;
import com.chartboost.sdk.events.ImpressionEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.events.StartError;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.AppConfig;
import com.original.tase.utils.DeviceUtils;
import com.unity3d.services.core.properties.ClientProperties;
import timber.log.Timber;
import w.a;

public class ChartboostAds extends AdsBase {

    /* renamed from: f  reason: collision with root package name */
    private final String f13590f = "ChartboostSample";

    /* renamed from: g  reason: collision with root package name */
    AppConfig.AdsBean.ChartBoostBean f13591g = null;

    /* renamed from: h  reason: collision with root package name */
    Interstitial f13592h = null;

    /* access modifiers changed from: private */
    public static /* synthetic */ void s(StartError startError) {
    }

    public void f() {
        super.f();
        if (DeviceUtils.b()) {
            this.f13591g = GlobalVariable.c().b().getAds().getChartBoost_amz();
        } else {
            this.f13591g = GlobalVariable.c().b().getAds().getChartBoost();
        }
        n(this.f13591g.getEcmp());
        Chartboost.startWithAppId(ClientProperties.getApplicationContext(), this.f13591g.getApp_id(), this.f13591g.getSignature(), new a());
        Interstitial interstitial = this.f13592h;
        if (interstitial == null || !interstitial.isCached()) {
            Interstitial interstitial2 = new Interstitial("intertisial_1", new InterstitialCallback() {
                public void onAdClicked(ClickEvent clickEvent, ClickError clickError) {
                }

                public void onAdDismiss(DismissEvent dismissEvent) {
                }

                public void onAdLoaded(CacheEvent cacheEvent, CacheError cacheError) {
                    if (cacheError == null) {
                        Timber.f("ChartboostInterstitial onAdLoaded", new Object[0]);
                        ChartboostAds.this.f13592h.cache();
                    }
                }

                public void onAdRequestedToShow(ShowEvent showEvent) {
                }

                public void onAdShown(ShowEvent showEvent, ShowError showError) {
                }

                public void onImpressionRecorded(ImpressionEvent impressionEvent) {
                }
            }, (Mediation) null);
            this.f13592h = interstitial2;
            interstitial2.cache();
        }
    }

    public void g(int i2, int i3, Intent intent) {
        super.g(i2, i3, intent);
    }

    public void p(Activity activity) {
        Interstitial interstitial = this.f13592h;
        if (interstitial == null || !interstitial.isCached()) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
            return;
        }
        this.f13592h.show();
        this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
    }
}
