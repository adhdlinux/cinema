package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class MaxNativeAdLoaderImpl extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f14323a = new a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f14324b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f14325c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MaxNativeAdListener f14326d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, MaxNativeAdView> f14327e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Object f14328f = new Object();

    private class a implements a.C0011a {
        private a() {
        }

        /* access modifiers changed from: private */
        public void a(MaxNativeAdView maxNativeAdView) {
            d c2;
            b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker != null && (c2 = adViewTracker.c()) != null) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.b(maxNativeAdLoaderImpl.tag, "Destroying previous ad");
                MaxNativeAdLoaderImpl.this.destroy(c2);
            }
        }

        public void onAdClicked(MaxAd maxAd) {
            j.a(MaxNativeAdLoaderImpl.this.f14326d, maxAd, true);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdView unused = MaxNativeAdLoaderImpl.this.a(((MaxErrorImpl) maxError).getLoadTag());
            j.a(MaxNativeAdLoaderImpl.this.f14326d, str, maxError, true);
        }

        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl.logger.b(maxNativeAdLoaderImpl.tag, "Native ad loaded");
                    d dVar = (d) maxAd;
                    dVar.d(MaxNativeAdLoaderImpl.this.f14324b);
                    dVar.e(MaxNativeAdLoaderImpl.this.f14325c);
                    MaxNativeAdView a2 = MaxNativeAdLoaderImpl.this.a(dVar.a());
                    if (a2 == null) {
                        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl2 = MaxNativeAdLoaderImpl.this;
                        maxNativeAdLoaderImpl2.logger.b(maxNativeAdLoaderImpl2.tag, "No custom view provided, checking template");
                        String v2 = dVar.v();
                        if (StringUtils.isValidString(v2)) {
                            MaxNativeAdLoaderImpl maxNativeAdLoaderImpl3 = MaxNativeAdLoaderImpl.this;
                            v vVar = maxNativeAdLoaderImpl3.logger;
                            String str = maxNativeAdLoaderImpl3.tag;
                            vVar.b(str, "Using template: " + v2 + "...");
                            a2 = new MaxNativeAdView(v2, MaxNativeAdLoaderImpl.this.sdk.L());
                        }
                    }
                    if (a2 == null) {
                        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl4 = MaxNativeAdLoaderImpl.this;
                        maxNativeAdLoaderImpl4.logger.b(maxNativeAdLoaderImpl4.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                        j.a(MaxNativeAdLoaderImpl.this.f14326d, (MaxNativeAdView) null, maxAd, true);
                        return;
                    }
                    a.this.a(a2);
                    MaxNativeAdLoaderImpl.this.a(a2, dVar, dVar.getNativeAd());
                    j.a(MaxNativeAdLoaderImpl.this.f14326d, a2, maxAd, true);
                    MaxNativeAdLoaderImpl.this.a(a2);
                }
            });
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            j.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }
    }

    public MaxNativeAdLoaderImpl(String str, m mVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", mVar);
        if (v.a()) {
            v vVar = this.logger;
            String str2 = this.tag;
            vVar.b(str2, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    /* access modifiers changed from: private */
    public MaxNativeAdView a(String str) {
        MaxNativeAdView remove;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f14328f) {
            remove = this.f14327e.remove(str);
        }
        return remove;
    }

    /* access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView) {
        b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker != null) {
            if (g.c()) {
                if (!maxNativeAdView.isAttachedToWindow()) {
                    return;
                }
            } else if (maxNativeAdView.getParent() == null) {
                return;
            }
            adViewTracker.b();
        }
    }

    /* access modifiers changed from: private */
    public void a(final MaxNativeAdView maxNativeAdView, final d dVar, final MaxNativeAd maxNativeAd) {
        dVar.a(maxNativeAdView);
        a(dVar);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                maxNativeAdView.render(dVar, MaxNativeAdLoaderImpl.this.f14323a, MaxNativeAdLoaderImpl.this.sdk);
                maxNativeAd.setNativeAdView(maxNativeAdView);
                maxNativeAd.prepareViewForInteraction(maxNativeAdView);
            }
        });
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f14328f) {
                this.f14327e.put(str, maxNativeAdView);
            }
        }
    }

    public void destroy() {
        this.f14326d = null;
        super.destroy();
    }

    public void destroy(MaxAd maxAd) {
        if (maxAd instanceof d) {
            d dVar = (d) maxAd;
            if (!dVar.w()) {
                MaxNativeAdView u2 = dVar.u();
                if (u2 != null) {
                    b adViewTracker = u2.getAdViewTracker();
                    if (adViewTracker != null && maxAd.equals(adViewTracker.c())) {
                        u2.recycle();
                    }
                } else if (v.a()) {
                    v vVar = this.logger;
                    String str = this.tag;
                    vVar.b(str, "Destroy failed on native ad(" + dVar + "): native ad view not found");
                }
                this.sdk.E().destroyAd(dVar);
            } else if (v.a()) {
                v vVar2 = this.logger;
                String str2 = this.tag;
                vVar2.b(str2, "Native ad(" + dVar + ") has already been destroyed");
            }
        } else if (v.a()) {
            v vVar3 = this.logger;
            String str3 = this.tag;
            vVar3.b(str3, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    public String getPlacement() {
        return this.f14324b;
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        if (v.a()) {
            v vVar = this.logger;
            String str = this.tag;
            vVar.b(str, "Loading native ad for '" + this.adUnitId + "' and notifying " + this.f14323a + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.E().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.localExtraParameters, this.extraParameters, this.sdk.L(), this.f14323a);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof d)) {
            v.i(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        } else if (maxNativeAdView == null) {
            v.i(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        } else {
            d dVar = (d) maxAd;
            MaxNativeAd nativeAd = dVar.getNativeAd();
            if (nativeAd == null) {
                this.logger.e(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return false;
            }
            a(maxNativeAdView, dVar, nativeAd);
            a(maxNativeAdView);
            return true;
        }
    }

    public void setCustomData(String str) {
        Utils.maybeLogCustomDataSizeLimit(str, this.tag);
        this.f14325c = str;
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        if (v.a()) {
            v vVar = this.logger;
            String str = this.tag;
            vVar.b(str, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.f14326d = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.f14324b = str;
    }

    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + '\'' + ", nativeAdListener=" + this.f14326d + ", revenueListener=" + this.revenueListener + '}';
    }
}
