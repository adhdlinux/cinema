package com.vungle.ads;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.VungleInitializer;
import com.vungle.ads.internal.VungleInternal;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.util.ActivityManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class VungleAds {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "VungleAds";
    public static final FirstPartyData firstPartyData = new FirstPartyData();
    /* access modifiers changed from: private */
    public static VungleInitializer initializer = new VungleInitializer();
    /* access modifiers changed from: private */
    public static VungleInternal vungleInternal = new VungleInternal();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void deInit(Context context) {
            Intrinsics.f(context, "context");
            VungleAds.initializer.deInit$vungle_ads_release();
            ActivityManager.Companion.deInit(context);
        }

        public final String getBiddingToken(Context context) {
            Intrinsics.f(context, "context");
            return VungleAds.vungleInternal.getAvailableBidTokens(context);
        }

        public final String getSdkVersion() {
            return VungleAds.vungleInternal.getSdkVersion();
        }

        public final void init(Context context, String str, InitializationListener initializationListener) {
            Intrinsics.f(context, "context");
            Intrinsics.f(str, "appId");
            Intrinsics.f(initializationListener, "callback");
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            VungleInitializer access$getInitializer$cp = VungleAds.initializer;
            Intrinsics.e(context, "appContext");
            access$getInitializer$cp.init(str, context, initializationListener);
        }

        public final boolean isInitialized() {
            return VungleAds.initializer.isInitialized();
        }

        public final boolean isInline(String str) {
            Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
            Placement placement = ConfigManager.INSTANCE.getPlacement(str);
            if (placement != null) {
                return placement.isInline();
            }
            return false;
        }

        public final void setIntegrationName(WrapperFramework wrapperFramework, String str) {
            Intrinsics.f(wrapperFramework, "wrapperFramework");
            Intrinsics.f(str, "wrapperFrameworkVersion");
            VungleAds.initializer.setIntegrationName(wrapperFramework, str);
        }

        public final void getBiddingToken(Context context, BidTokenCallback bidTokenCallback) {
            Intrinsics.f(context, "context");
            Intrinsics.f(bidTokenCallback, "callback");
            VungleAds.vungleInternal.getAvailableBidTokensAsync(context, bidTokenCallback);
        }
    }

    @Keep
    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        max,
        none
    }

    public static final void deInit(Context context) {
        Companion.deInit(context);
    }

    public static final String getBiddingToken(Context context) {
        return Companion.getBiddingToken(context);
    }

    public static final void getBiddingToken(Context context, BidTokenCallback bidTokenCallback) {
        Companion.getBiddingToken(context, bidTokenCallback);
    }

    public static final String getSdkVersion() {
        return Companion.getSdkVersion();
    }

    public static final void init(Context context, String str, InitializationListener initializationListener) {
        Companion.init(context, str, initializationListener);
    }

    public static final boolean isInitialized() {
        return Companion.isInitialized();
    }

    public static final boolean isInline(String str) {
        return Companion.isInline(str);
    }

    public static final void setIntegrationName(WrapperFramework wrapperFramework, String str) {
        Companion.setIntegrationName(wrapperFramework, str);
    }
}
