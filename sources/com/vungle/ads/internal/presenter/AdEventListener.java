package com.vungle.ads.internal.presenter;

import com.facebook.react.uimanager.ViewProps;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class AdEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AdEventListener";
    private boolean adRewarded;
    private Placement placement;
    private final AdPlayCallback playAdCallback;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AdEventListener(AdPlayCallback adPlayCallback, Placement placement2) {
        this.playAdCallback = adPlayCallback;
        this.placement = placement2;
    }

    public final void onError(VungleError vungleError, String str) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        AdPlayCallback adPlayCallback = this.playAdCallback;
        if (adPlayCallback != null) {
            adPlayCallback.onFailure(vungleError);
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "AdEventListener#PlayAdCallback " + str, vungleError);
        }
    }

    public final void onNext(String str, String str2, String str3) {
        AdPlayCallback adPlayCallback;
        AdPlayCallback adPlayCallback2;
        AdPlayCallback adPlayCallback3;
        AdPlayCallback adPlayCallback4;
        Intrinsics.f(str, "s");
        Logger.Companion companion = Logger.Companion;
        companion.d(TAG, "s=" + str + ", value=" + str2 + ", id=" + str3);
        switch (str.hashCode()) {
            case -1912374177:
                if (str.equals(MRAIDPresenter.SUCCESSFUL_VIEW)) {
                    Placement placement2 = this.placement;
                    boolean z2 = false;
                    if (placement2 != null && placement2.isRewardedVideo()) {
                        z2 = true;
                    }
                    if (z2 && !this.adRewarded) {
                        this.adRewarded = true;
                        AdPlayCallback adPlayCallback5 = this.playAdCallback;
                        if (adPlayCallback5 != null) {
                            adPlayCallback5.onAdRewarded(str3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case -1627831289:
                if (str.equals("adViewed") && (adPlayCallback = this.playAdCallback) != null) {
                    adPlayCallback.onAdImpression(str3);
                    return;
                }
                return;
            case 100571:
                if (str.equals(ViewProps.END) && (adPlayCallback2 = this.playAdCallback) != null) {
                    adPlayCallback2.onAdEnd(str3);
                    return;
                }
                return;
            case 3417674:
                if (str.equals(MRAIDPresenter.OPEN)) {
                    if (Intrinsics.a(str2, "adClick")) {
                        AdPlayCallback adPlayCallback6 = this.playAdCallback;
                        if (adPlayCallback6 != null) {
                            adPlayCallback6.onAdClick(str3);
                            return;
                        }
                        return;
                    } else if (Intrinsics.a(str2, "adLeftApplication") && (adPlayCallback3 = this.playAdCallback) != null) {
                        adPlayCallback3.onAdLeftApplication(str3);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 109757538:
                if (str.equals(ViewProps.START) && (adPlayCallback4 = this.playAdCallback) != null) {
                    adPlayCallback4.onAdStart(str3);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
