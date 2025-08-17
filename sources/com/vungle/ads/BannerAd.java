package com.vungle.ads;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.BannerAdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.jvm.internal.Intrinsics;

public final class BannerAd extends BaseAd {
    private final AdPlayCallbackWrapper adPlayCallback;
    private final VungleAdSize adSize;
    private BannerView bannerView;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BannerAdSize.values().length];
            iArr[BannerAdSize.BANNER.ordinal()] = 1;
            iArr[BannerAdSize.BANNER_SHORT.ordinal()] = 2;
            iArr[BannerAdSize.BANNER_LEADERBOARD.ordinal()] = 3;
            iArr[BannerAdSize.VUNGLE_MREC.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BannerAd(Context context, String str, VungleAdSize vungleAdSize, AdConfig adConfig) {
        super(context, str, adConfig);
        this.adSize = vungleAdSize;
        AdInternal adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        Intrinsics.d(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        this.adPlayCallback = ((BannerAdInternal) adInternal$vungle_ads_release).wrapCallback$vungle_ads_release(new BannerAd$adPlayCallback$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: getBannerView$lambda-1  reason: not valid java name */
    public static final void m117getBannerView$lambda1(BannerAd bannerAd, VungleError vungleError) {
        Intrinsics.f(bannerAd, "this$0");
        BaseAdListener adListener = bannerAd.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(bannerAd, vungleError);
        }
    }

    public final void finishAd() {
        BannerView bannerView2 = this.bannerView;
        if (bannerView2 != null) {
            bannerView2.finishAdInternal(true);
        }
    }

    public final VungleAdSize getAdViewSize() {
        AdInternal adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        Intrinsics.d(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        VungleAdSize updatedAdSize$vungle_ads_release = ((BannerAdInternal) adInternal$vungle_ads_release).getUpdatedAdSize$vungle_ads_release();
        return updatedAdSize$vungle_ads_release == null ? this.adSize : updatedAdSize$vungle_ads_release;
    }

    public final BannerView getBannerView() {
        Placement placement;
        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.PLAY_AD_API), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        BannerView bannerView2 = this.bannerView;
        if (bannerView2 != null) {
            return bannerView2;
        }
        getAdInternal$vungle_ads_release().getShowToValidationMetric$vungle_ads_release().markStart();
        VungleError canPlayAd = getAdInternal$vungle_ads_release().canPlayAd(true);
        if (canPlayAd != null) {
            if (getAdInternal$vungle_ads_release().isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                getAdInternal$vungle_ads_release().setAdState(AdInternal.AdState.ERROR);
            }
            ThreadUtil.INSTANCE.runOnUiThread(new e(this, canPlayAd));
            return null;
        }
        AdPayload advertisement = getAdInternal$vungle_ads_release().getAdvertisement();
        if (advertisement == null || (placement = getAdInternal$vungle_ads_release().getPlacement()) == null) {
            return null;
        }
        getAdInternal$vungle_ads_release().cancelDownload$vungle_ads_release();
        try {
            this.bannerView = new BannerView(getContext(), placement, advertisement, getAdViewSize(), getAdConfig(), this.adPlayCallback, getAdInternal$vungle_ads_release().getBidPayload());
            getResponseToShowMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, getResponseToShowMetric$vungle_ads_release(), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            getAdInternal$vungle_ads_release().getShowToValidationMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, getAdInternal$vungle_ads_release().getShowToValidationMetric$vungle_ads_release(), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release().markStart();
            return this.bannerView;
        } catch (InstantiationException e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e("BannerAd", "Can not create banner view: " + e2.getMessage(), e2);
            getResponseToShowMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric$vungle_ads_release(), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            return null;
        } catch (Throwable th) {
            getResponseToShowMetric$vungle_ads_release().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric$vungle_ads_release(), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            throw th;
        }
    }

    public BannerAdInternal constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.f(context, "context");
        return new BannerAdInternal(context, this.adSize);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BannerAd(Context context, String str, VungleAdSize vungleAdSize) {
        this(context, str, vungleAdSize, new AdConfig());
        Intrinsics.f(context, "context");
        Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
        Intrinsics.f(vungleAdSize, "adSize");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BannerAd(android.content.Context r2, java.lang.String r3, com.vungle.ads.BannerAdSize r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "placementId"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "adSize"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            com.vungle.ads.VungleAdSize$Companion r0 = com.vungle.ads.VungleAdSize.Companion
            int[] r0 = com.vungle.ads.BannerAd.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r0[r4]
            r0 = 1
            if (r4 == r0) goto L_0x0034
            r0 = 2
            if (r4 == r0) goto L_0x0031
            r0 = 3
            if (r4 == r0) goto L_0x002e
            r0 = 4
            if (r4 != r0) goto L_0x0028
            com.vungle.ads.VungleAdSize r4 = com.vungle.ads.VungleAdSize.MREC
            goto L_0x0036
        L_0x0028:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
            r2.<init>()
            throw r2
        L_0x002e:
            com.vungle.ads.VungleAdSize r4 = com.vungle.ads.VungleAdSize.BANNER_LEADERBOARD
            goto L_0x0036
        L_0x0031:
            com.vungle.ads.VungleAdSize r4 = com.vungle.ads.VungleAdSize.BANNER_SHORT
            goto L_0x0036
        L_0x0034:
            com.vungle.ads.VungleAdSize r4 = com.vungle.ads.VungleAdSize.BANNER
        L_0x0036:
            com.vungle.ads.AdConfig r0 = new com.vungle.ads.AdConfig
            r0.<init>()
            r1.<init>(r2, r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.BannerAd.<init>(android.content.Context, java.lang.String, com.vungle.ads.BannerAdSize):void");
    }
}
