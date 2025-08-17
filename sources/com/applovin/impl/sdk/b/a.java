package com.applovin.impl.sdk.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.e.aa;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final m f15140a;

    /* renamed from: b  reason: collision with root package name */
    protected final AppLovinAdServiceImpl f15141b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AppLovinAd f15142c;

    /* renamed from: d  reason: collision with root package name */
    private String f15143d;

    /* renamed from: e  reason: collision with root package name */
    private SoftReference<AppLovinAdLoadListener> f15144e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f15145f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private volatile String f15146g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f15147h = false;

    /* renamed from: com.applovin.impl.sdk.b.a$a  reason: collision with other inner class name */
    private class C0020a implements AppLovinAdLoadListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final AppLovinAdLoadListener f15150b;

        C0020a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f15150b = appLovinAdLoadListener;
        }

        public void adReceived(final AppLovinAd appLovinAd) {
            AppLovinAd unused = a.this.f15142c = appLovinAd;
            if (this.f15150b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C0020a.this.f15150b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            if (v.a()) {
                                v.c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                            }
                        }
                    }
                });
            }
        }

        public void failedToReceiveAd(final int i2) {
            if (this.f15150b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C0020a.this.f15150b.failedToReceiveAd(i2);
                        } catch (Throwable th) {
                            if (v.a()) {
                                v.c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                            }
                        }
                    }
                });
            }
        }
    }

    private class b implements g, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

        /* renamed from: b  reason: collision with root package name */
        private final AppLovinAdDisplayListener f15156b;

        /* renamed from: c  reason: collision with root package name */
        private final AppLovinAdClickListener f15157c;

        /* renamed from: d  reason: collision with root package name */
        private final AppLovinAdVideoPlaybackListener f15158d;

        /* renamed from: e  reason: collision with root package name */
        private final AppLovinAdRewardListener f15159e;

        private b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f15156b = appLovinAdDisplayListener;
            this.f15157c = appLovinAdClickListener;
            this.f15158d = appLovinAdVideoPlaybackListener;
            this.f15159e = appLovinAdRewardListener;
        }

        private void a(e eVar) {
            int i2;
            String str;
            String a2 = a.this.d();
            if (!StringUtils.isValidString(a2) || !a.this.f15147h) {
                if (v.a()) {
                    v A = a.this.f15140a.A();
                    A.e("IncentivizedAdController", "Invalid reward state - result: " + a2 + " and wasFullyEngaged: " + a.this.f15147h);
                    a.this.f15140a.A().b("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                eVar.aF();
                if (a.this.f15147h) {
                    if (v.a()) {
                        a.this.f15140a.A().e("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    }
                    str = "network_timeout";
                    i2 = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                } else {
                    if (v.a()) {
                        a.this.f15140a.A().e("IncentivizedAdController", "User close the ad prematurely");
                    }
                    str = "user_closed_video";
                    i2 = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                }
                eVar.a(c.a(str));
                if (v.a()) {
                    a.this.f15140a.A().b("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                j.a(this.f15159e, (AppLovinAd) eVar, i2);
            }
            a.this.a((AppLovinAd) eVar);
            if (v.a()) {
                a.this.f15140a.A().b("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            j.b(this.f15156b, (AppLovinAd) eVar);
            if (!eVar.ag().getAndSet(true)) {
                if (v.a()) {
                    a.this.f15140a.A().b("IncentivizedAdController", "Scheduling report rewarded ad...");
                }
                a.this.f15140a.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.e.v(eVar, a.this.f15140a), o.a.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            j.a(this.f15157c, appLovinAd);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            j.a(this.f15156b, appLovinAd);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof f) {
                appLovinAd = ((f) appLovinAd).a();
            }
            if (appLovinAd instanceof e) {
                a((e) appLovinAd);
            } else if (v.a()) {
                v A = a.this.f15140a.A();
                A.e("IncentivizedAdController", "Something is terribly wrong. Received `adHidden` callback for invalid ad of type: " + appLovinAd);
            }
        }

        public void onAdDisplayFailed(String str) {
            j.a(this.f15156b, str);
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.a("quota_exceeded");
            j.b(this.f15159e, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.a("rejected");
            j.c(this.f15159e, appLovinAd, map);
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            a.this.a("accepted");
            j.a(this.f15159e, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i2) {
            a.this.a("network_timeout");
            j.a(this.f15159e, appLovinAd, i2);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            j.a(this.f15158d, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d2, boolean z2) {
            j.a(this.f15158d, appLovinAd, d2, z2);
            boolean unused = a.this.f15147h = z2;
        }
    }

    public a(String str, AppLovinSdk appLovinSdk) {
        this.f15140a = appLovinSdk.coreSdk;
        this.f15141b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f15143d = str;
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdImpl.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdImpl.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdImpl, this.f15140a);
            if (maybeRetrieveNonDummyAd == null) {
                a(appLovinAdImpl, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
                return;
            }
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f15140a.Y(), context);
            b bVar = new b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            create.showAndRender(maybeRetrieveNonDummyAd);
            if (maybeRetrieveNonDummyAd instanceof e) {
                a((e) maybeRetrieveNonDummyAd, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        if (v.a()) {
            v A = this.f15140a.A();
            A.e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdImpl.getType() + " in an Incentivized Ad interstitial.");
        }
        a(appLovinAdImpl, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
        AppLovinAdDisplayListener appLovinAdDisplayListener2 = appLovinAdDisplayListener;
        if (appLovinAdImpl.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdImpl.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdImpl, this.f15140a);
            if (maybeRetrieveNonDummyAd == null) {
                a(appLovinAdImpl, appLovinAdVideoPlaybackListener2, appLovinAdDisplayListener2);
                return;
            }
            Context context2 = context;
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f15140a.Y(), context);
            b bVar = new b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            ViewGroup viewGroup2 = viewGroup;
            Lifecycle lifecycle2 = lifecycle;
            create.showAndRender(maybeRetrieveNonDummyAd, viewGroup, lifecycle);
            if (maybeRetrieveNonDummyAd instanceof e) {
                a((e) maybeRetrieveNonDummyAd, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        if (v.a()) {
            v A = this.f15140a.A();
            A.e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdImpl.getType() + " in an Incentivized Ad interstitial.");
        }
        a(appLovinAdImpl, appLovinAdVideoPlaybackListener2, appLovinAdDisplayListener2);
    }

    private void a(e eVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f15140a.S().a((com.applovin.impl.sdk.e.a) new aa(eVar, appLovinAdRewardListener, this.f15140a), o.a.REWARD);
    }

    /* access modifiers changed from: private */
    public void a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f15142c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof f) {
                if (appLovinAd != ((f) appLovinAd2).a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.f15142c = null;
        }
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.f15142c;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        if (v.a()) {
            v.i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        }
        c();
    }

    private void a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f15140a.T().a(com.applovin.impl.sdk.d.f.f15311j);
        j.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        j.b(appLovinAdDisplayListener, appLovinAd);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f15145f) {
            this.f15146g = str;
        }
    }

    private void b(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.f15142c;
        }
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        if (v.a()) {
            v.i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        }
        c();
    }

    private void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f15141b.loadNextIncentivizedAd(this.f15143d, appLovinAdLoadListener);
    }

    private void c() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.f15144e;
        if (softReference != null && (appLovinAdLoadListener = softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* access modifiers changed from: private */
    public String d() {
        String str;
        synchronized (this.f15145f) {
            str = this.f15146g;
        }
        return str;
    }

    private AppLovinAdRewardListener e() {
        return new AppLovinAdRewardListener() {
            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                if (v.a()) {
                    v A = a.this.f15140a.A();
                    A.e("IncentivizedAdController", "User over quota: " + map);
                }
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                if (v.a()) {
                    v A = a.this.f15140a.A();
                    A.e("IncentivizedAdController", "Reward rejected: " + map);
                }
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                if (v.a()) {
                    v A = a.this.f15140a.A();
                    A.b("IncentivizedAdController", "Reward validated: " + map);
                }
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i2) {
                if (v.a()) {
                    v A = a.this.f15140a.A();
                    A.e("IncentivizedAdController", "Reward validation failed: " + i2);
                }
            }
        };
    }

    public void a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = e();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        b(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? e() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        if (v.a()) {
            this.f15140a.A().b("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.f15144e = new SoftReference<>(appLovinAdLoadListener);
        if (a()) {
            if (v.a()) {
                v.i("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            }
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f15142c);
                return;
            }
            return;
        }
        b((AppLovinAdLoadListener) new C0020a(appLovinAdLoadListener));
    }

    public boolean a() {
        return this.f15142c != null;
    }

    public String b() {
        return this.f15143d;
    }
}
