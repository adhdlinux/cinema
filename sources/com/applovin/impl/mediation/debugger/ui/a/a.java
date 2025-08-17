package com.applovin.impl.mediation.debugger.ui.a;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.a.a;
import com.applovin.impl.mediation.debugger.b.a.b;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.a.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
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
import java.util.List;

public class a extends com.applovin.impl.mediation.debugger.ui.a implements a.C0014a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a  reason: collision with root package name */
    private m f14565a;

    /* renamed from: b  reason: collision with root package name */
    private com.applovin.impl.mediation.debugger.b.a.a f14566b;

    /* renamed from: c  reason: collision with root package name */
    private b f14567c;

    /* renamed from: d  reason: collision with root package name */
    private b f14568d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MaxAdView f14569e;

    /* renamed from: f  reason: collision with root package name */
    private MaxInterstitialAd f14570f;

    /* renamed from: g  reason: collision with root package name */
    private MaxRewardedInterstitialAd f14571g;

    /* renamed from: h  reason: collision with root package name */
    private MaxRewardedAd f14572h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public MaxNativeAdView f14573i;

    /* renamed from: j  reason: collision with root package name */
    private MaxNativeAdLoader f14574j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public d f14575k;

    /* renamed from: l  reason: collision with root package name */
    private ListView f14576l;

    /* renamed from: m  reason: collision with root package name */
    private View f14577m;

    /* renamed from: n  reason: collision with root package name */
    private AdControlButton f14578n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f14579o;

    /* renamed from: p  reason: collision with root package name */
    private com.applovin.impl.mediation.debugger.a.a f14580p;

    private void a() {
        String a2 = this.f14566b.a();
        if (this.f14566b.d().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(a2, this.f14566b.d(), this.f14565a.Y(), this);
            this.f14569e = maxAdView;
            maxAdView.setListener(this);
        } else if (MaxAdFormat.INTERSTITIAL == this.f14566b.d()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(a2, this.f14565a.Y(), this);
            this.f14570f = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f14566b.d()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(a2, this.f14565a.Y(), this);
            this.f14571g = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED == this.f14566b.d()) {
            MaxRewardedAd instance = MaxRewardedAd.getInstance(a2, this.f14565a.Y(), this);
            this.f14572h = instance;
            instance.setListener(this);
        } else if (MaxAdFormat.NATIVE == this.f14566b.d()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(a2, this.f14565a.Y(), this);
            this.f14574j = maxNativeAdLoader;
            maxNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdClicked(MaxAd maxAd) {
                    a.this.onAdClicked(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    MaxNativeAdView unused = a.this.f14573i = maxNativeAdView;
                    a.this.onAdLoaded(maxAd);
                }
            });
            this.f14574j.setRevenueListener(this);
        }
    }

    private void a(final ViewGroup viewGroup, AppLovinSdkUtils.Size size, DialogInterface.OnShowListener onShowListener) {
        if (this.f14575k == null) {
            d dVar = new d(viewGroup, size, this);
            this.f14575k = dVar;
            dVar.setOnShowListener(onShowListener);
            this.f14575k.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    ViewGroup viewGroup = viewGroup;
                    if (viewGroup instanceof MaxAdView) {
                        ((MaxAdView) viewGroup).stopAutoRefresh();
                    }
                    d unused = a.this.f14575k = null;
                }
            });
            this.f14575k.show();
        }
    }

    private void a(MaxAdFormat maxAdFormat) {
        if (this.f14568d != null) {
            this.f14565a.J().a(this.f14568d.a().a());
            this.f14565a.J().a(true);
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f14569e.setPlacement("[Mediation Debugger Live Ad]");
            this.f14569e.loadAd();
        } else if (MaxAdFormat.INTERSTITIAL == this.f14566b.d()) {
            this.f14570f.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f14566b.d()) {
            this.f14571g.loadAd();
        } else if (MaxAdFormat.REWARDED == this.f14566b.d()) {
            this.f14572h.loadAd();
        } else if (MaxAdFormat.NATIVE == this.f14566b.d()) {
            this.f14574j.setPlacement("[Mediation Debugger Live Ad]");
            this.f14574j.loadAd();
        } else {
            Utils.showToast("Live ads currently unavailable for ad format", this);
        }
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            a(this.f14569e, maxAdFormat.getSize(), new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    a.this.f14569e.startAutoRefresh();
                }
            });
        } else if (MaxAdFormat.INTERSTITIAL == this.f14566b.d()) {
            this.f14570f.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f14566b.d()) {
            this.f14571g.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED == this.f14566b.d()) {
            this.f14572h.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.NATIVE == this.f14566b.d()) {
            a(this.f14573i, MaxAdFormat.MREC.getSize(), (DialogInterface.OnShowListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.f14565a;
    }

    public void initialize(final com.applovin.impl.mediation.debugger.b.a.a aVar, b bVar, final m mVar) {
        this.f14565a = mVar;
        this.f14566b = aVar;
        this.f14568d = bVar;
        b bVar2 = new b(aVar, bVar, this);
        this.f14567c = bVar2;
        bVar2.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, final c cVar) {
                if (cVar instanceof b.a) {
                    a.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, mVar.af(), new a.C0016a<MaxDebuggerAdUnitDetailActivity>() {
                        public void a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                            com.applovin.impl.mediation.debugger.b.a.b a2 = ((b.a) cVar).a();
                            AnonymousClass1 r12 = AnonymousClass1.this;
                            maxDebuggerAdUnitDetailActivity.initialize(aVar, a2, mVar);
                        }
                    });
                }
            }
        });
        a();
        List<com.applovin.impl.mediation.debugger.a.b> d2 = aVar.e().d();
        if (d2 != null && d2.size() > 0) {
            if (bVar == null || bVar.a().c().x()) {
                this.f14580p = new com.applovin.impl.mediation.debugger.a.a(d2, aVar.d(), (a.C0014a) this);
            }
        }
    }

    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.f14578n.setControlState(AdControlButton.b.LOAD);
        this.f14579o.setText("");
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
        if (maxAdFormat.isAdViewAd()) {
            this.f14569e.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f14570f.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f14571g.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f14572h.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f14574j.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        this.f14578n.setControlState(AdControlButton.b.LOAD);
        this.f14579o.setText("");
        if (204 == maxError.getCode()) {
            Utils.showAlert("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        Utils.showAlert("", "Failed to load with error code: " + maxError.getCode(), this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        TextView textView = this.f14579o;
        textView.setText(maxAd.getNetworkName() + " ad loaded");
        this.f14578n.setControlState(AdControlButton.b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            a(this.f14569e, maxAd.getFormat().getSize(), (DialogInterface.OnShowListener) null);
        } else if (MaxAdFormat.NATIVE == this.f14566b.d()) {
            a(this.f14573i, MaxAdFormat.MREC.getSize(), (DialogInterface.OnShowListener) null);
        }
    }

    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f14569e.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f14570f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f14571g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f14572h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f14574j.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    public void onClick(AdControlButton adControlButton) {
        if (this.f14565a.J().a()) {
            Utils.showAlert("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
            return;
        }
        MaxAdFormat d2 = this.f14566b.d();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            com.applovin.impl.mediation.debugger.a.a aVar = this.f14580p;
            if (aVar != null) {
                aVar.a();
            } else {
                a(d2);
            }
        } else if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            if (!d2.isAdViewAd() && d2 != MaxAdFormat.NATIVE) {
                adControlButton.setControlState(bVar);
            }
            b(d2);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f14567c.a());
        this.f14576l = (ListView) findViewById(R.id.listView);
        this.f14577m = findViewById(R.id.ad_presenter_view);
        this.f14578n = (AdControlButton) findViewById(R.id.ad_control_button);
        this.f14579o = (TextView) findViewById(R.id.status_textview);
        this.f14576l.setAdapter(this.f14567c);
        this.f14579o.setText(this.f14565a.J().a() ? "Not Supported while Test Mode is enabled" : "Tap to load an ad");
        this.f14579o.setTypeface(Typeface.DEFAULT_BOLD);
        this.f14578n.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer((float) 10, 0.0f, (float) -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f14577m.setBackground(layerDrawable);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f14568d != null) {
            this.f14565a.J().a((String) null);
            this.f14565a.J().a(false);
        }
        MaxAdView maxAdView = this.f14569e;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f14570f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f14572h;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
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
