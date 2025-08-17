package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.util.ViewUtility;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

public final class BannerAdInternal extends AdInternal {
    private final VungleAdSize adSize;
    private VungleAdSize updatedAdSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerAdInternal(Context context, VungleAdSize vungleAdSize) {
        super(context);
        Intrinsics.f(context, "context");
        Intrinsics.f(vungleAdSize, "adSize");
        this.adSize = vungleAdSize;
    }

    public void adLoadedAndUpdateConfigure$vungle_ads_release(AdPayload adPayload) {
        int i2;
        int i3;
        Intrinsics.f(adPayload, "advertisement");
        super.adLoadedAndUpdateConfigure$vungle_ads_release(adPayload);
        if (this.adSize.isAdaptiveWidth$vungle_ads_release() || this.adSize.isAdaptiveHeight$vungle_ads_release()) {
            Pair<Integer, Integer> deviceWidthAndHeightWithOrientation = ViewUtility.INSTANCE.getDeviceWidthAndHeightWithOrientation(getContext(), 0);
            int intValue = deviceWidthAndHeightWithOrientation.a().intValue();
            int intValue2 = deviceWidthAndHeightWithOrientation.b().intValue();
            if (this.adSize.isAdaptiveWidth$vungle_ads_release()) {
                i2 = adPayload.adWidth();
            } else {
                i2 = this.adSize.getWidth();
            }
            if (this.adSize.isAdaptiveHeight$vungle_ads_release()) {
                i3 = adPayload.adHeight();
            } else {
                i3 = this.adSize.getHeight();
            }
            int min = Math.min(intValue, i2);
            int min2 = Math.min(intValue2, i3);
            if (this.adSize.isAdaptiveHeight$vungle_ads_release() && this.adSize.getHeight() > 0) {
                min2 = Math.min(this.adSize.getHeight(), min2);
            }
            this.updatedAdSize = new VungleAdSize(min, min2);
        }
    }

    public VungleAdSize getAdSizeForAdRequest() {
        return this.adSize;
    }

    public final VungleAdSize getUpdatedAdSize$vungle_ads_release() {
        return this.updatedAdSize;
    }

    public boolean isValidAdSize(VungleAdSize vungleAdSize) {
        if (vungleAdSize != null) {
            return vungleAdSize.isValidSize$vungle_ads_release();
        }
        return false;
    }

    public boolean isValidAdTypeForPlacement(Placement placement) {
        Intrinsics.f(placement, "placement");
        if (placement.isBanner() || placement.isMREC() || placement.isInline()) {
            return true;
        }
        return false;
    }

    public final void setUpdatedAdSize$vungle_ads_release(VungleAdSize vungleAdSize) {
        this.updatedAdSize = vungleAdSize;
    }

    public final AdPlayCallbackWrapper wrapCallback$vungle_ads_release(AdPlayCallback adPlayCallback) {
        Intrinsics.f(adPlayCallback, "adPlayCallback");
        return new BannerAdInternal$wrapCallback$1(adPlayCallback, this);
    }
}
