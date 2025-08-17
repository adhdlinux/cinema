package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.internal.model.Placement;
import kotlin.jvm.internal.Intrinsics;

public final class InterstitialAdInternal extends FullscreenAdInternal {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterstitialAdInternal(Context context) {
        super(context);
        Intrinsics.f(context, "context");
    }

    public boolean isValidAdTypeForPlacement(Placement placement) {
        Intrinsics.f(placement, "placement");
        if (placement.isInterstitial() || placement.isAppOpen()) {
            return true;
        }
        return false;
    }
}
