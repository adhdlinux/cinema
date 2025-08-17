package com.vungle.ads;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.signals.SignaledAd;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

public abstract class BaseAd implements Ad {
    private final AdConfig adConfig;
    private final Lazy adInternal$delegate = LazyKt__LazyJVMKt.b(new BaseAd$adInternal$2(this));
    private BaseAdListener adListener;
    private final Context context;
    private String creativeId;
    private final TimeIntervalMetric displayToClickMetric;
    private String eventId;
    private final SingleValueMetric leaveApplicationMetric;
    private final LogEntry logEntry;
    private final String placementId;
    private final TimeIntervalMetric presentToDisplayMetric;
    private final TimeIntervalMetric requestToResponseMetric;
    private final TimeIntervalMetric responseToShowMetric;
    private final SingleValueMetric rewardedMetric;
    private final TimeIntervalMetric showToCloseMetric;
    private final TimeIntervalMetric showToFailMetric;
    private final Lazy signalManager$delegate;
    private SignaledAd signaledAd;

    public BaseAd(Context context2, String str, AdConfig adConfig2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
        Intrinsics.f(adConfig2, "adConfig");
        this.context = context2;
        this.placementId = str;
        this.adConfig = adConfig2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new BaseAd$special$$inlined$inject$1(context2));
        LogEntry logEntry2 = new LogEntry();
        logEntry2.setPlacementRefId$vungle_ads_release(str);
        this.logEntry = logEntry2;
        this.requestToResponseMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_REQUEST_TO_RESPONSE_DURATION_MS);
        this.responseToShowMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_RESPONSE_TO_SHOW_DURATION_MS);
        this.presentToDisplayMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_PRESENT_TO_DISPLAY_DURATION_MS);
        this.showToFailMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_FAIL_DURATION_MS);
        this.displayToClickMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_DISPLAY_TO_CLICK_DURATION_MS);
        this.leaveApplicationMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.AD_LEAVE_APPLICATION);
        this.rewardedMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER);
        this.showToCloseMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_CLOSE_DURATION_MS);
    }

    public static /* synthetic */ void getRequestToResponseMetric$vungle_ads_release$annotations() {
    }

    private final void onLoadEnd() {
        this.requestToResponseMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.requestToResponseMetric, this.logEntry, (String) null, 4, (Object) null);
        this.responseToShowMetric.markStart();
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadFailure$lambda-2  reason: not valid java name */
    public static final void m127onLoadFailure$lambda2(BaseAd baseAd, VungleError vungleError) {
        Intrinsics.f(baseAd, "this$0");
        Intrinsics.f(vungleError, "$vungleError");
        BaseAdListener baseAdListener = baseAd.adListener;
        if (baseAdListener != null) {
            baseAdListener.onAdFailedToLoad(baseAd, vungleError);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadSuccess$lambda-1  reason: not valid java name */
    public static final void m128onLoadSuccess$lambda1(BaseAd baseAd) {
        Intrinsics.f(baseAd, "this$0");
        BaseAdListener baseAdListener = baseAd.adListener;
        if (baseAdListener != null) {
            baseAdListener.onAdLoaded(baseAd);
        }
    }

    public Boolean canPlayAd() {
        boolean z2 = false;
        if (AdInternal.canPlayAd$default(getAdInternal$vungle_ads_release(), false, 1, (Object) null) == null) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }

    public abstract AdInternal constructAdInternal$vungle_ads_release(Context context2);

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final AdInternal getAdInternal$vungle_ads_release() {
        return (AdInternal) this.adInternal$delegate.getValue();
    }

    public final BaseAdListener getAdListener() {
        return this.adListener;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final TimeIntervalMetric getDisplayToClickMetric$vungle_ads_release() {
        return this.displayToClickMetric;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final SingleValueMetric getLeaveApplicationMetric$vungle_ads_release() {
        return this.leaveApplicationMetric;
    }

    public final LogEntry getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final TimeIntervalMetric getPresentToDisplayMetric$vungle_ads_release() {
        return this.presentToDisplayMetric;
    }

    public final TimeIntervalMetric getRequestToResponseMetric$vungle_ads_release() {
        return this.requestToResponseMetric;
    }

    public final TimeIntervalMetric getResponseToShowMetric$vungle_ads_release() {
        return this.responseToShowMetric;
    }

    public final SingleValueMetric getRewardedMetric$vungle_ads_release() {
        return this.rewardedMetric;
    }

    public final TimeIntervalMetric getShowToCloseMetric$vungle_ads_release() {
        return this.showToCloseMetric;
    }

    public final TimeIntervalMetric getShowToFailMetric$vungle_ads_release() {
        return this.showToFailMetric;
    }

    public final SignalManager getSignalManager$vungle_ads_release() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    public final SignaledAd getSignaledAd$vungle_ads_release() {
        return this.signaledAd;
    }

    public void load(String str) {
        this.requestToResponseMetric.markStart();
        getAdInternal$vungle_ads_release().loadAd(this.placementId, str, new BaseAd$load$1(this, str));
    }

    public void onAdLoaded$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.f(adPayload, "advertisement");
        adPayload.setAdConfig(this.adConfig);
        this.creativeId = adPayload.getCreativeId();
        String eventId2 = adPayload.eventId();
        this.eventId = eventId2;
        SignaledAd signaledAd2 = this.signaledAd;
        if (signaledAd2 != null) {
            signaledAd2.setEventId(eventId2);
        }
    }

    public void onLoadFailure$vungle_ads_release(BaseAd baseAd, VungleError vungleError) {
        Intrinsics.f(baseAd, "baseAd");
        Intrinsics.f(vungleError, "vungleError");
        ThreadUtil.INSTANCE.runOnUiThread(new l(this, vungleError));
        onLoadEnd();
    }

    public void onLoadSuccess$vungle_ads_release(BaseAd baseAd, String str) {
        Intrinsics.f(baseAd, "baseAd");
        ThreadUtil.INSTANCE.runOnUiThread(new m(this));
        onLoadEnd();
    }

    public final void setAdListener(BaseAdListener baseAdListener) {
        this.adListener = baseAdListener;
    }

    public final void setSignaledAd$vungle_ads_release(SignaledAd signaledAd2) {
        this.signaledAd = signaledAd2;
    }
}
