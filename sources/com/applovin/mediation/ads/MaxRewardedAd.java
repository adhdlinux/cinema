package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd implements MaxFullscreenAdImpl.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, MaxRewardedAd> f15966a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f15967b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<Activity> f15968c = new WeakReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final MaxFullscreenAdImpl f15969d;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        this.f15969d = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.coreSdk);
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            updateActivity(activity);
            synchronized (f15967b) {
                Map<String, MaxRewardedAd> map = f15966a;
                MaxRewardedAd maxRewardedAd = map.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
                map.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void updateActivity(Activity activity) {
        a.logApiCall("MaxRewardedAd", "updateActivity(activity=" + activity + ")");
        if (activity != null) {
            f15968c = new WeakReference<>(activity);
        }
    }

    public void destroy() {
        this.f15969d.logApiCall("destroy()");
        synchronized (f15967b) {
            f15966a.remove(this.f15969d.getAdUnitId());
        }
        this.f15969d.destroy();
    }

    public Activity getActivity() {
        this.f15969d.logApiCall("getActivity()");
        return f15968c.get();
    }

    public String getAdUnitId() {
        return this.f15969d.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f15969d.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f15969d.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f15969d.logApiCall("loadAd()");
        this.f15969d.loadAd(getActivity());
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f15969d.setAdReviewListener(maxAdReviewListener);
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f15969d.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f15969d.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f15969d.setLocalExtraParameter(str, obj);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f15969d.setRevenueListener(maxAdRevenueListener);
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
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        Utils.maybeLogCustomDataSizeLimit(str2, "MaxRewardedAd");
        this.f15969d.showAd(str, str2, getActivity());
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f15969d;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f15969d.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }

    public String toString() {
        return "" + this.f15969d;
    }
}
