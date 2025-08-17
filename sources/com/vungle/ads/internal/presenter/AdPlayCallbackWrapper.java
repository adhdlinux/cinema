package com.vungle.ads.internal.presenter;

import com.vungle.ads.VungleError;
import kotlin.jvm.internal.Intrinsics;

public class AdPlayCallbackWrapper implements AdPlayCallback {
    private final AdPlayCallback adPlayCallback;

    public AdPlayCallbackWrapper(AdPlayCallback adPlayCallback2) {
        Intrinsics.f(adPlayCallback2, "adPlayCallback");
        this.adPlayCallback = adPlayCallback2;
    }

    public void onAdClick(String str) {
        this.adPlayCallback.onAdClick(str);
    }

    public void onAdEnd(String str) {
        this.adPlayCallback.onAdEnd(str);
    }

    public void onAdImpression(String str) {
        this.adPlayCallback.onAdImpression(str);
    }

    public void onAdLeftApplication(String str) {
        this.adPlayCallback.onAdLeftApplication(str);
    }

    public void onAdRewarded(String str) {
        this.adPlayCallback.onAdRewarded(str);
    }

    public void onAdStart(String str) {
        this.adPlayCallback.onAdStart(str);
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        this.adPlayCallback.onFailure(vungleError);
    }
}
