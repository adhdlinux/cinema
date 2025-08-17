package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.a.a;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends com.applovin.impl.mediation.debugger.ui.a implements a.C0014a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a  reason: collision with root package name */
    private b f14765a;

    /* renamed from: b  reason: collision with root package name */
    private m f14766b;

    /* renamed from: c  reason: collision with root package name */
    private MaxAdView f14767c;

    /* renamed from: d  reason: collision with root package name */
    private MaxAdView f14768d;

    /* renamed from: e  reason: collision with root package name */
    private MaxInterstitialAd f14769e;

    /* renamed from: f  reason: collision with root package name */
    private MaxRewardedInterstitialAd f14770f;

    /* renamed from: g  reason: collision with root package name */
    private MaxRewardedAd f14771g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MaxAd f14772h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public MaxNativeAdLoader f14773i;

    /* renamed from: j  reason: collision with root package name */
    private String f14774j;

    /* renamed from: k  reason: collision with root package name */
    private AdControlButton f14775k;

    /* renamed from: l  reason: collision with root package name */
    private AdControlButton f14776l;

    /* renamed from: m  reason: collision with root package name */
    private AdControlButton f14777m;

    /* renamed from: n  reason: collision with root package name */
    private AdControlButton f14778n;

    /* renamed from: o  reason: collision with root package name */
    private AdControlButton f14779o;

    /* renamed from: p  reason: collision with root package name */
    private AdControlButton f14780p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Button f14781q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public Button f14782r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public FrameLayout f14783s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public FrameLayout f14784t;

    /* renamed from: u  reason: collision with root package name */
    private Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> f14785u;

    private AdControlButton a(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.f14775k;
        }
        if (str.equals("test_mode_mrec")) {
            return this.f14776l;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.f14777m;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.f14778n;
        }
        if (str.equals(this.f14774j)) {
            return this.f14779o;
        }
        if (str.equals("test_mode_native")) {
            return this.f14780p;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    private void a() {
        String str;
        MaxAdFormat maxAdFormat;
        boolean isTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (isTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.f14765a.p().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f14766b.Y(), this);
            this.f14767c = maxAdView;
            maxAdView.setListener(this);
            frameLayout.addView(this.f14767c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
            this.f14775k = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f14775k.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    private void a(MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        this.f14766b.J().a(this.f14765a.h());
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.f14767c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.f14768d;
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f14769e.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f14770f.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f14771g.loadAd();
            return;
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f14773i.loadAd();
            return;
        } else {
            return;
        }
        maxAdView.loadAd();
    }

    private void b() {
        this.f14783s = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        List<MaxAdFormat> p2 = this.f14765a.p();
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        if (p2.contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", maxAdFormat, this.f14766b.Y(), this);
            this.f14768d = maxAdView;
            maxAdView.setListener(this);
            this.f14783s.addView(this.f14768d, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
            this.f14776l = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f14776l.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.mrec_control_view).setVisibility(8);
        this.f14783s.setVisibility(8);
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f14769e.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f14770f.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f14771g.showAd();
        }
    }

    private void c() {
        List<MaxAdFormat> p2 = this.f14765a.p();
        MaxAdFormat maxAdFormat = MaxAdFormat.INTERSTITIAL;
        if (p2.contains(maxAdFormat)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f14766b.Y(), this);
            this.f14769e = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
            this.f14777m = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f14777m.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.interstitial_control_view).setVisibility(8);
    }

    private void d() {
        List<MaxAdFormat> p2 = this.f14765a.p();
        MaxAdFormat maxAdFormat = MaxAdFormat.REWARDED;
        if (p2.contains(maxAdFormat)) {
            String str = "test_mode_rewarded_" + this.f14765a.h();
            this.f14774j = str;
            MaxRewardedAd instance = MaxRewardedAd.getInstance(str, this.f14766b.Y(), this);
            this.f14771g = instance;
            instance.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
            this.f14779o = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f14779o.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.rewarded_control_view).setVisibility(8);
    }

    private void e() {
        this.f14784t = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (this.f14765a.q()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.f14766b.Y(), this);
            this.f14773i = maxNativeAdLoader;
            maxNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdClicked(MaxAd maxAd) {
                    a.this.onAdClicked(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (a.this.f14772h != null) {
                        a.this.f14773i.destroy(a.this.f14772h);
                    }
                    MaxAd unused = a.this.f14772h = maxAd;
                    a.this.f14784t.removeAllViews();
                    a.this.f14784t.addView(maxNativeAdView);
                    a.this.onAdLoaded(maxAd);
                }
            });
            this.f14773i.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
            this.f14780p = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f14780p.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(R.id.native_control_view).setVisibility(8);
        this.f14784t.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.f14766b;
    }

    public void initialize(b bVar) {
        this.f14765a = bVar;
        this.f14766b = bVar.v();
    }

    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        a(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
        Utils.showAlert("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), this);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        Utils.showToast("onAdDisplayed", maxAd, this);
    }

    public void onAdExpanded(MaxAd maxAd) {
        Utils.showToast("onAdExpanded", maxAd, this);
    }

    public void onAdHidden(MaxAd maxAd) {
        Utils.showToast("onAdHidden", maxAd, this);
    }

    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.f14767c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.f14768d;
        } else {
            if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.f14769e.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
                this.f14770f.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.f14771g.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.NATIVE == maxAdFormat) {
                this.f14773i.setLocalExtraParameter("amazon_ad_error", adError);
            }
            a(maxAdFormat);
        }
        maxAdView.setLocalExtraParameter("amazon_ad_error", adError);
        a(maxAdFormat);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton a2 = a(str);
        a2.setControlState(AdControlButton.b.LOAD);
        Utils.showAlert("", "Failed to load " + a2.getFormat().getLabel() + " with error code: " + maxError.getCode(), this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        a(maxAd.getAdUnitId()).setControlState((maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) ? AdControlButton.b.LOAD : AdControlButton.b.SHOW);
    }

    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.f14767c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.f14768d;
        } else {
            if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.f14769e.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
                this.f14770f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.f14771g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            } else if (MaxAdFormat.NATIVE == maxAdFormat) {
                this.f14773i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
            }
            a(maxAdFormat);
        }
        maxAdView.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        a(maxAdFormat);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> map = this.f14785u;
            if (map == null || map.get(format) == null) {
                a(format);
            } else {
                this.f14785u.get(format).a();
            }
        } else if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(bVar);
            b(format);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f14765a == null) {
            v.i("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f14765a.i() + " Test Ads");
        a();
        b();
        c();
        d();
        e();
        findViewById(R.id.rewarded_interstitial_control_view).setVisibility(8);
        this.f14781q = (Button) findViewById(R.id.show_mrec_button);
        this.f14782r = (Button) findViewById(R.id.show_native_button);
        if (!this.f14765a.q() || !this.f14765a.p().contains(MaxAdFormat.MREC)) {
            this.f14781q.setVisibility(8);
            this.f14782r.setVisibility(8);
        } else {
            this.f14784t.setVisibility(8);
            this.f14781q.setBackgroundColor(-1);
            this.f14782r.setBackgroundColor(-3355444);
            this.f14781q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.f14783s.setVisibility(0);
                    a.this.f14784t.setVisibility(8);
                    a.this.f14781q.setBackgroundColor(-1);
                    a.this.f14782r.setBackgroundColor(-3355444);
                }
            });
            this.f14782r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.f14784t.setVisibility(0);
                    a.this.f14783s.setVisibility(8);
                    a.this.f14782r.setBackgroundColor(-1);
                    a.this.f14781q.setBackgroundColor(-3355444);
                }
            });
        }
        if (StringUtils.isValidString(this.f14765a.y()) && this.f14765a.z() != null && this.f14765a.z().size() > 0) {
            AdRegistration.getInstance(this.f14765a.y(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            HashMap hashMap = new HashMap(this.f14765a.z().size());
            for (MaxAdFormat next : this.f14765a.z().keySet()) {
                hashMap.put(next, new com.applovin.impl.mediation.debugger.a.a(this.f14765a.z().get(next), next, (a.C0014a) this));
            }
            this.f14785u = hashMap;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            v.c("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        this.f14766b.J().a((String) null);
        MaxAdView maxAdView = this.f14767c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f14768d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f14769e;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f14771g;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f14773i;
        if (maxNativeAdLoader != null && (maxAd = this.f14772h) != null) {
            maxNativeAdLoader.destroy(maxAd);
        }
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoCompleted", maxAd, this);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoStarted", maxAd, this);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        Utils.showToast("onUserRewarded", maxAd, this);
    }
}
