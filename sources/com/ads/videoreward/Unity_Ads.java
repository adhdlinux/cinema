package com.ads.videoreward;

import android.app.Activity;
import com.ads.videoreward.AdsBase;
import com.movie.data.api.GlobalVariable;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Objects;
import timber.log.Timber;

public class Unity_Ads extends AdsBase implements IUnityAdsInitializationListener, IUnityAdsLoadListener, IUnityAdsShowListener {

    /* renamed from: f  reason: collision with root package name */
    private String f13610f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f13611g = MimeTypes.BASE_TYPE_VIDEO;

    /* renamed from: h  reason: collision with root package name */
    private String f13612h = "Android_Interstitial";

    /* renamed from: i  reason: collision with root package name */
    private String f13613i = "banner";

    public void f() {
        super.f();
        n(GlobalVariable.c().b().getAds().getUnity_ads().getEcmp());
        this.f13612h = GlobalVariable.c().b().getAds().getUnity_ads().getInterstitial_id();
        this.f13611g = GlobalVariable.c().b().getAds().getUnity_ads().getRewarded_id();
        this.f13613i = GlobalVariable.c().b().getAds().getUnity_ads().getBanner_id();
        this.f13610f = GlobalVariable.c().b().getAds().getUnity_ads().getGame_id();
        UnityAds.initialize(e(), this.f13610f, false, this);
    }

    public void onInitializationComplete() {
        Timber.c("onInitializationComplete", new Object[0]);
        UnityAds.load(this.f13612h, this);
    }

    public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        Timber.c("onInitializationFailed" + str, new Object[0]);
    }

    public void onUnityAdsAdLoaded(String str) {
        Timber.c("onUnityAdsAdLoaded = " + str, new Object[0]);
    }

    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        Timber.c("Unity Ads failed to load ad for " + str + " with error: [" + unityAdsLoadError + "] " + str2, new Object[0]);
        if (Objects.equals(str, this.f13612h)) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_LOAD);
        }
        if (Objects.equals(str, this.f13611g)) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_LOAD);
        }
        if (Objects.equals(str, this.f13613i)) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_LOAD);
        }
    }

    public void onUnityAdsShowClick(String str) {
    }

    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        unityAdsShowCompletionState.equals(UnityAds.UnityAdsShowCompletionState.COMPLETED);
    }

    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        Timber.c("Unity Ads failed to show ad for " + str + " with error: [" + unityAdsShowError + "] " + str2, new Object[0]);
        if (Objects.equals(str, this.f13612h)) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
        }
        if (Objects.equals(str, this.f13611g)) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.NOT_SHOW);
        }
        if (Objects.equals(str, this.f13613i)) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.NOT_SHOW);
        }
    }

    public void onUnityAdsShowStart(String str) {
        Timber.f("onUnityAdsShowStart: " + str, new Object[0]);
        if (Objects.equals(str, this.f13612h)) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
        }
        if (Objects.equals(str, this.f13611g)) {
            this.f13551e.b(this, AdsBase.AdBaseType.FULLSCREEN, AdsBase.AdsStatus.SHOWED);
        }
        if (Objects.equals(str, this.f13613i)) {
            this.f13551e.b(this, AdsBase.AdBaseType.BANNER, AdsBase.AdsStatus.SHOWED);
        }
    }

    public void p(Activity activity) {
        if (activity != null) {
            UnityAds.show(activity, this.f13612h, new UnityAdsShowOptions(), this);
        }
    }
}
