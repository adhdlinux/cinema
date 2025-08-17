package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MaxInterstitialAd implements MaxFullscreenAdImpl.a {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<Activity> f15964a = new WeakReference<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private final MaxFullscreenAdImpl f15965b;

    public MaxInterstitialAd(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxInterstitialAd(String str, AppLovinSdk appLovinSdk, Activity activity) {
        a.logApiCall("MaxInterstitialAd", "MaxInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            f15964a = new WeakReference<>(activity);
            this.f15965b = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", appLovinSdk.coreSdk);
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public void destroy() {
        this.f15965b.logApiCall("destroy()");
        this.f15965b.destroy();
    }

    public Activity getActivity() {
        this.f15965b.logApiCall("getActivity()");
        return f15964a.get();
    }

    public String getAdUnitId() {
        return this.f15965b.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f15965b.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f15965b.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f15965b.logApiCall("loadAd()");
        this.f15965b.loadAd(getActivity());
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f15965b.setAdReviewListener(maxAdReviewListener);
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f15965b.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f15965b.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f15965b.setLocalExtraParameter(str, obj);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f15965b.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd((String) null, viewGroup, lifecycle);
    }

    public void showAd(String str) {
        showAd(str, (String) null);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(str, (String) null, viewGroup, lifecycle);
    }

    public void showAd(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        Utils.maybeLogCustomDataSizeLimit(str2, "MaxInterstitialAd");
        this.f15965b.showAd(str, str2, getActivity());
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15965b;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f15965b.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }

    public String toString() {
        return "" + this.f15965b;
    }
}
