package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.mediation.a.h;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Handler f14812a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final m f14813b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v f14814c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f14815d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final f f14816e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f14817f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public MaxAdapter f14818g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f14819h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public com.applovin.impl.mediation.a.a f14820i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public View f14821j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public MaxNativeAd f14822k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public MaxNativeAdView f14823l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final a f14824m = new a();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public MaxAdapterResponseParameters f14825n;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicBoolean f14826o = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final AtomicBoolean f14827p = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final AtomicBoolean f14828q = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private final boolean f14829r;

    private class a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxNativeAdAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public MediationServiceImpl.a f14887b;

        private a() {
        }

        /* access modifiers changed from: private */
        public void a(MediationServiceImpl.a aVar) {
            if (aVar != null) {
                this.f14887b = aVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        private void a(String str, final Bundle bundle) {
            g.this.f14828q.set(true);
            a(str, (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    if (g.this.f14827p.compareAndSet(false, true)) {
                        a.this.f14887b.a(g.this.f14820i, bundle);
                    }
                }
            });
        }

        private void a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            g.this.f14812a.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e2) {
                        MaxAdListener maxAdListener = maxAdListener;
                        String name = maxAdListener != null ? maxAdListener.getClass().getName() : null;
                        if (v.a()) {
                            v.c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + name, e2);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void a(String str, final MaxError maxError) {
            a(str, (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    if (g.this.f14827p.compareAndSet(false, true)) {
                        a.this.f14887b.onAdLoadFailed(g.this.f14819h, maxError);
                    }
                }
            });
        }

        private void b(String str, final Bundle bundle) {
            if (g.this.f14820i.s().compareAndSet(false, true)) {
                a(str, (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                    public void run() {
                        a.this.f14887b.b(g.this.f14820i, bundle);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void b(String str, final MaxError maxError) {
            a(str, (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onAdDisplayFailed(g.this.f14820i, maxError);
                }
            });
        }

        public void onAdViewAdClicked() {
            onAdViewAdClicked((Bundle) null);
        }

        public void onAdViewAdClicked(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.d(g.this.f14820i, bundle);
                }
            });
        }

        public void onAdViewAdCollapsed() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onAdCollapsed(g.this.f14820i);
                }
            });
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": adview ad failed to display with error: " + maxAdapterError);
            }
            b("onAdViewAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed((Bundle) null);
        }

        public void onAdViewAdDisplayed(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": adview ad displayed with extra info: " + bundle);
            }
            b("onAdViewAdDisplayed", bundle);
        }

        public void onAdViewAdExpanded() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onAdExpanded(g.this.f14820i);
                }
            });
        }

        public void onAdViewAdHidden() {
            onAdViewAdHidden((Bundle) null);
        }

        public void onAdViewAdHidden(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": adview ad hidden with extra info: " + bundle);
            }
            a("onAdViewAdHidden", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.c(g.this.f14820i, bundle);
                }
            });
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, (Bundle) null);
        }

        public void onAdViewAdLoaded(View view, Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": adview ad loaded with extra info: " + bundle);
            }
            View unused = g.this.f14821j = view;
            a("onAdViewAdLoaded", bundle);
        }

        public void onInterstitialAdClicked() {
            onInterstitialAdClicked((Bundle) null);
        }

        public void onInterstitialAdClicked(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.d(g.this.f14820i, bundle);
                }
            });
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            b("onInterstitialAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed((Bundle) null);
        }

        public void onInterstitialAdDisplayed(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": interstitial ad displayed with extra info: " + bundle);
            }
            b("onInterstitialAdDisplayed", bundle);
        }

        public void onInterstitialAdHidden() {
            onInterstitialAdHidden((Bundle) null);
        }

        public void onInterstitialAdHidden(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": interstitial ad hidden with extra info " + bundle);
            }
            a("onInterstitialAdHidden", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.c(g.this.f14820i, bundle);
                }
            });
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded((Bundle) null);
        }

        public void onInterstitialAdLoaded(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": interstitial ad loaded with extra info: " + bundle);
            }
            a("onInterstitialAdLoaded", bundle);
        }

        public void onNativeAdClicked() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": native ad clicked");
            }
            a("onNativeAdClicked", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onAdClicked(g.this.f14820i);
                }
            });
        }

        public void onNativeAdDisplayed(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": native ad displayed with extra info: " + bundle);
            }
            b("onNativeAdDisplayed", bundle);
        }

        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": native ad loaded with extra info: " + bundle);
            }
            MaxNativeAd unused = g.this.f14822k = maxNativeAd;
            a("onNativeAdLoaded", bundle);
        }

        public void onRewardedAdClicked() {
            onRewardedAdClicked((Bundle) null);
        }

        public void onRewardedAdClicked(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.d(g.this.f14820i, bundle);
                }
            });
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            b("onRewardedAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed((Bundle) null);
        }

        public void onRewardedAdDisplayed(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad displayed with extra info: " + bundle);
            }
            b("onRewardedAdDisplayed", bundle);
        }

        public void onRewardedAdHidden() {
            onRewardedAdHidden((Bundle) null);
        }

        public void onRewardedAdHidden(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad hidden with extra info: " + bundle);
            }
            a("onRewardedAdHidden", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.c(g.this.f14820i, bundle);
                }
            });
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdLoaded() {
            onRewardedAdLoaded((Bundle) null);
        }

        public void onRewardedAdLoaded(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad loaded with extra info: " + bundle);
            }
            a("onRewardedAdLoaded", bundle);
        }

        public void onRewardedAdVideoCompleted() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded video completed");
            }
            a("onRewardedAdVideoCompleted", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onRewardedVideoCompleted(g.this.f14820i);
                }
            });
        }

        public void onRewardedAdVideoStarted() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded video started");
            }
            a("onRewardedAdVideoStarted", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onRewardedVideoStarted(g.this.f14820i);
                }
            });
        }

        public void onRewardedInterstitialAdClicked() {
            onRewardedInterstitialAdClicked((Bundle) null);
        }

        public void onRewardedInterstitialAdClicked(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial ad clicked with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdClicked", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.d(g.this.f14820i, bundle);
                }
            });
        }

        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            }
            b("onRewardedInterstitialAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed((Bundle) null);
        }

        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            }
            b("onRewardedInterstitialAdDisplayed", bundle);
        }

        public void onRewardedInterstitialAdHidden() {
            onRewardedInterstitialAdHidden((Bundle) null);
        }

        public void onRewardedInterstitialAdHidden(final Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial ad hidden with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdHidden", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.c(g.this.f14820i, bundle);
                }
            });
        }

        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.d("MediationAdapterWrapper", g.this.f14817f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded((Bundle) null);
        }

        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdLoaded", bundle);
        }

        public void onRewardedInterstitialAdVideoCompleted() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial completed");
            }
            a("onRewardedInterstitialAdVideoCompleted", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onRewardedVideoCompleted(g.this.f14820i);
                }
            });
        }

        public void onRewardedInterstitialAdVideoStarted() {
            if (v.a()) {
                v c2 = g.this.f14814c;
                c2.c("MediationAdapterWrapper", g.this.f14817f + ": rewarded interstitial started");
            }
            a("onRewardedInterstitialAdVideoStarted", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                public void run() {
                    a.this.f14887b.onRewardedVideoStarted(g.this.f14820i);
                }
            });
        }

        public void onUserRewarded(final MaxReward maxReward) {
            if (g.this.f14820i instanceof com.applovin.impl.mediation.a.c) {
                final com.applovin.impl.mediation.a.c cVar = (com.applovin.impl.mediation.a.c) g.this.f14820i;
                if (cVar.H().compareAndSet(false, true)) {
                    if (v.a()) {
                        v c2 = g.this.f14814c;
                        c2.c("MediationAdapterWrapper", g.this.f14817f + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", (MaxAdListener) this.f14887b, (Runnable) new Runnable() {
                        public void run() {
                            a.this.f14887b.onUserRewarded(cVar, maxReward);
                        }
                    });
                }
            }
        }
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final h f14926a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final MaxSignalCollectionListener f14927b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final AtomicBoolean f14928c = new AtomicBoolean();

        b(h hVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.f14926a = hVar;
            this.f14927b = maxSignalCollectionListener;
        }
    }

    private class c extends com.applovin.impl.sdk.e.a {
        private c() {
            super("TaskTimeoutMediatedAd", g.this.f14813b);
        }

        private void a(com.applovin.impl.mediation.a.a aVar) {
            if (aVar != null) {
                this.f15333b.H().a(aVar);
            }
        }

        public void run() {
            if (g.this.f14827p.get()) {
                return;
            }
            if (g.this.f14820i.k()) {
                if (v.a()) {
                    a(g.this.f14817f + " is timing out, considering JS Tag ad loaded: " + g.this.f14820i);
                }
                a(g.this.f14820i);
                return;
            }
            if (v.a()) {
                d(g.this.f14817f + " is timing out " + g.this.f14820i + "...");
            }
            a(g.this.f14820i);
            g.this.f14824m.a(e(), (MaxError) new MaxErrorImpl(-5101, "Adapter timed out"));
        }
    }

    private class d extends com.applovin.impl.sdk.e.a {

        /* renamed from: c  reason: collision with root package name */
        private final b f14931c;

        private d(b bVar) {
            super("TaskTimeoutSignalCollection", g.this.f14813b);
            this.f14931c = bVar;
        }

        public void run() {
            if (!this.f14931c.f14928c.get()) {
                if (v.a()) {
                    d(g.this.f14817f + " is timing out " + this.f14931c.f14926a + "...");
                }
                g gVar = g.this;
                gVar.b("The adapter (" + g.this.f14817f + ") timed out", this.f14931c);
            }
        }
    }

    g(f fVar, MaxAdapter maxAdapter, boolean z2, m mVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (mVar != null) {
            this.f14815d = fVar.L();
            this.f14818g = maxAdapter;
            this.f14813b = mVar;
            this.f14814c = mVar.A();
            this.f14816e = fVar;
            this.f14817f = maxAdapter.getClass().getSimpleName();
            this.f14829r = z2;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    private void a(final Runnable runnable, final com.applovin.impl.mediation.a.a aVar) {
        a("show_ad", (Runnable) new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    String str = "Failed to start displaying ad" + aVar + " : " + th;
                    if (v.a()) {
                        v.i("MediationAdapterWrapper", str);
                    }
                    g.this.f14824m.b("show_ad", (MaxError) new MaxErrorImpl(-1, str));
                    g.this.a("show_ad");
                    g.this.f14813b.C().a(g.this.f14816e.K(), "show_ad", g.this.f14820i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (v.a()) {
            v vVar = this.f14814c;
            vVar.c("MediationAdapterWrapper", "Marking " + this.f14817f + " as disabled due to: " + str);
        }
        this.f14826o.set(false);
    }

    /* access modifiers changed from: private */
    public void a(String str, b bVar) {
        if (bVar.f14928c.compareAndSet(false, true) && bVar.f14927b != null) {
            bVar.f14927b.onSignalCollected(str);
        }
    }

    private void a(final String str, final Runnable runnable) {
        AnonymousClass8 r02 = new Runnable() {
            public void run() {
                try {
                    if (v.a()) {
                        v c2 = g.this.f14814c;
                        c2.b("MediationAdapterWrapper", g.this.f14817f + ": running " + str + "...");
                    }
                    runnable.run();
                    if (v.a()) {
                        v c3 = g.this.f14814c;
                        c3.b("MediationAdapterWrapper", g.this.f14817f + ": finished " + str + "");
                    }
                } catch (Throwable th) {
                    if (v.a()) {
                        v.c("MediationAdapterWrapper", "Unable to run adapter operation " + str + ", marking " + g.this.f14817f + " as disabled", th);
                    }
                    g gVar = g.this;
                    gVar.a("fail_" + str);
                    if (!str.equals("destroy")) {
                        g.this.f14813b.C().a(g.this.f14816e.K(), str, g.this.f14820i);
                    }
                }
            }
        };
        if (this.f14816e.S()) {
            this.f14812a.post(r02);
        } else {
            r02.run();
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, b bVar) {
        if (bVar.f14928c.compareAndSet(false, true) && bVar.f14927b != null) {
            bVar.f14927b.onSignalCollectionFailed(str);
        }
    }

    private boolean b(com.applovin.impl.mediation.a.a aVar, Activity activity) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (aVar.g() == null) {
            if (v.a()) {
                v.i("MediationAdapterWrapper", "Adapter has been garbage collected");
            }
            this.f14824m.b("ad_show", (MaxError) new MaxErrorImpl(-1, "Adapter has been garbage collected"));
            return false;
        } else if (aVar.g() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (!this.f14826o.get()) {
            String str = "Mediation adapter '" + this.f14817f + "' is disabled. Showing ads with this adapter is disabled.";
            if (v.a()) {
                v.i("MediationAdapterWrapper", str);
            }
            this.f14824m.b("ad_show", (MaxError) new MaxErrorImpl(-1, str));
            return false;
        } else if (g()) {
            return true;
        } else {
            throw new IllegalStateException("Mediation adapter '" + this.f14817f + "' does not have an ad loaded. Please load an ad first");
        }
    }

    public View a() {
        return this.f14821j;
    }

    public void a(com.applovin.impl.mediation.a.a aVar, final Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) g.this.f14818g).showInterstitialAd(g.this.f14825n, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) g.this.f14818g).showRewardedAd(g.this.f14825n, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) g.this.f14818g).showRewardedInterstitialAd(g.this.f14825n, activity, g.this.f14824m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    public void a(com.applovin.impl.mediation.a.a aVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdViewAdapter) g.this.f14818g).showInterstitialAd(g.this.f14825n, viewGroup, lifecycle, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdViewAdapter) g.this.f14818g).showRewardedAd(g.this.f14825n, viewGroup, lifecycle, activity, g.this.f14824m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, final Runnable runnable) {
        a(MobileAdsBridgeBase.initializeMethodName, (Runnable) new Runnable() {
            public void run() {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                if (v.a()) {
                    v c2 = g.this.f14814c;
                    c2.b("MediationAdapterWrapper", "Initializing " + g.this.f14817f + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + g.this.f14816e.S());
                }
                g.this.f14818g.initialize(maxAdapterInitializationParameters, activity, new MaxAdapter.OnCompletionListener() {
                    public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                AnonymousClass1 r2 = AnonymousClass1.this;
                                g.this.f14813b.D().a(g.this.f14816e, elapsedRealtime - elapsedRealtime, initializationStatus, str);
                                Runnable runnable = runnable;
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }, g.this.f14816e.X());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, h hVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!this.f14826o.get()) {
            if (v.a()) {
                v.i("MediationAdapterWrapper", "Mediation adapter '" + this.f14817f + "' is disabled. Signal collection ads with this adapter is disabled.");
            }
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.f14817f + ") is disabled");
        } else {
            final b bVar = new b(hVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.f14818g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters2 = maxAdapterSignalCollectionParameters;
                final Activity activity2 = activity;
                final h hVar2 = hVar;
                a("collect_signal", (Runnable) new Runnable() {
                    public void run() {
                        try {
                            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters2, activity2, new MaxSignalCollectionListener() {
                                public void onSignalCollected(String str) {
                                    AnonymousClass6 r02 = AnonymousClass6.this;
                                    g.this.a(str, bVar);
                                }

                                public void onSignalCollectionFailed(String str) {
                                    AnonymousClass6 r02 = AnonymousClass6.this;
                                    g.this.b(str, bVar);
                                }
                            });
                        } catch (Throwable th) {
                            g gVar = g.this;
                            gVar.b("Failed signal collection for " + g.this.f14815d + " due to exception: " + th, bVar);
                            g.this.a("collect_signal");
                            g.this.f14813b.C().a(g.this.f14816e.K(), "collect_signal", g.this.f14820i);
                        }
                        if (bVar.f14928c.get()) {
                            return;
                        }
                        if (hVar2.W() == 0) {
                            if (v.a()) {
                                v c2 = g.this.f14814c;
                                c2.b("MediationAdapterWrapper", "Failing signal collection " + hVar2 + " since it has 0 timeout");
                            }
                            g gVar2 = g.this;
                            gVar2.b("The adapter (" + g.this.f14817f + ") has 0 timeout", bVar);
                            return;
                        }
                        int i2 = (hVar2.W() > 0 ? 1 : (hVar2.W() == 0 ? 0 : -1));
                        boolean a2 = v.a();
                        if (i2 > 0) {
                            if (a2) {
                                v c3 = g.this.f14814c;
                                c3.b("MediationAdapterWrapper", "Setting timeout " + hVar2.W() + "ms. for " + hVar2);
                            }
                            g.this.f14813b.S().a((com.applovin.impl.sdk.e.a) new d(bVar), o.a.MEDIATION_TIMEOUT, hVar2.W());
                        } else if (a2) {
                            v c4 = g.this.f14814c;
                            c4.b("MediationAdapterWrapper", "Negative timeout set for " + hVar2 + ", not scheduling a timeout");
                        }
                    }
                });
                return;
            }
            b("The adapter (" + this.f14817f + ") does not support signal collection", bVar);
        }
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f14823l = maxNativeAdView;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, com.applovin.impl.mediation.a.a aVar) {
        this.f14819h = str;
        this.f14820i = aVar;
    }

    public void a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final com.applovin.impl.mediation.a.a aVar, final Activity activity, MediationServiceImpl.a aVar2) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.f14826o.get()) {
            String str2 = "Mediation adapter '" + this.f14817f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
            if (v.a()) {
                v.i("MediationAdapterWrapper", str2);
            }
            aVar2.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
        } else {
            this.f14825n = maxAdapterResponseParameters;
            this.f14824m.a(aVar2);
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) g.this.f14818g).loadInterstitialAd(maxAdapterResponseParameters, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) g.this.f14818g).loadRewardedAd(maxAdapterResponseParameters, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) g.this.f14818g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.NATIVE) {
                runnable = new Runnable() {
                    public void run() {
                        ((MediationAdapterBase) g.this.f14818g).loadNativeAd(maxAdapterResponseParameters, activity, g.this.f14824m);
                    }
                };
            } else if (aVar.getFormat().isAdViewAd()) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxAdViewAdapter) g.this.f14818g).loadAdViewAd(maxAdapterResponseParameters, aVar.getFormat(), activity, g.this.f14824m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a("load_ad", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        String str = "Failed start loading " + aVar + " : " + th;
                        if (v.a()) {
                            v.i("MediationAdapterWrapper", str);
                        }
                        g.this.f14824m.a("load_ad", (MaxError) new MaxErrorImpl(-1, str));
                        g.this.a("load_ad");
                        g.this.f14813b.C().a(g.this.f14816e.K(), "load_ad", g.this.f14820i);
                    }
                    if (!g.this.f14827p.get()) {
                        long W = g.this.f14816e.W();
                        if (W > 0) {
                            if (v.a()) {
                                g.this.f14814c.b("MediationAdapterWrapper", "Setting timeout " + W + "ms. for " + aVar);
                            }
                            g.this.f14813b.S().a((com.applovin.impl.sdk.e.a) new c(), o.a.MEDIATION_TIMEOUT, W);
                        } else if (v.a()) {
                            g.this.f14814c.b("MediationAdapterWrapper", "Negative timeout set for " + aVar + ", not scheduling a timeout");
                        }
                    }
                }
            });
        }
    }

    public MaxNativeAd b() {
        return this.f14822k;
    }

    public MaxNativeAdView c() {
        return this.f14823l;
    }

    public String d() {
        return this.f14815d;
    }

    public MediationServiceImpl.a e() {
        return this.f14824m.f14887b;
    }

    public boolean f() {
        return this.f14826o.get();
    }

    public boolean g() {
        return this.f14827p.get() && this.f14828q.get();
    }

    public String h() {
        MaxAdapter maxAdapter = this.f14818g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            if (v.a()) {
                v.c("MediationAdapterWrapper", "Unable to get adapter's SDK version, marking " + this + " as disabled", th);
            }
            a("sdk_version");
            this.f14813b.C().a(this.f14816e.K(), "sdk_version", this.f14820i);
            return null;
        }
    }

    public String i() {
        MaxAdapter maxAdapter = this.f14818g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            if (v.a()) {
                v.c("MediationAdapterWrapper", "Unable to get adapter version, marking " + this + " as disabled", th);
            }
            a("adapter_version");
            this.f14813b.C().a(this.f14816e.K(), "adapter_version", this.f14820i);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (!this.f14829r) {
            a("destroy", (Runnable) new Runnable() {
                public void run() {
                    g.this.a("destroy");
                    g.this.f14818g.onDestroy();
                    MaxAdapter unused = g.this.f14818g = null;
                    View unused2 = g.this.f14821j = null;
                    MaxNativeAd unused3 = g.this.f14822k = null;
                    MaxNativeAdView unused4 = g.this.f14823l = null;
                }
            });
        }
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f14817f + "'" + '}';
    }
}
