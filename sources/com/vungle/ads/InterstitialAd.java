package com.vungle.ads;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.internal.InterstitialAdInternal;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class InterstitialAd extends BaseFullscreenAd {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterstitialAd(Context context, String str, AdConfig adConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i2 & 4) != 0 ? new AdConfig() : adConfig);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterstitialAd(Context context, String str, AdConfig adConfig) {
        super(context, str, adConfig);
        Intrinsics.f(context, "context");
        Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
        Intrinsics.f(adConfig, "adConfig");
    }

    public InterstitialAdInternal constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.f(context, "context");
        return new InterstitialAdInternal(context);
    }
}
