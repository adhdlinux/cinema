package com.vungle.ads.internal.load;

import com.vungle.ads.APIFailedStatusCodeError;
import com.vungle.ads.AdResponseEmptyError;
import com.vungle.ads.AdRetryError;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

public final class DefaultAdLoader$fetchAdMetadata$1 implements Callback<AdPayload> {
    final /* synthetic */ Placement $placement;
    final /* synthetic */ DefaultAdLoader this$0;

    DefaultAdLoader$fetchAdMetadata$1(DefaultAdLoader defaultAdLoader, Placement placement) {
        this.this$0 = defaultAdLoader;
        this.$placement = placement;
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m182onFailure$lambda1(DefaultAdLoader defaultAdLoader, Throwable th) {
        Intrinsics.f(defaultAdLoader, "this$0");
        defaultAdLoader.onAdLoadFailed(defaultAdLoader.retrofitToVungleError(th).setLogEntry$vungle_ads_release(defaultAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
    }

    /* access modifiers changed from: private */
    /* renamed from: onResponse$lambda-0  reason: not valid java name */
    public static final void m183onResponse$lambda0(DefaultAdLoader defaultAdLoader, Placement placement, Response response) {
        AdPayload adPayload;
        Intrinsics.f(defaultAdLoader, "this$0");
        Intrinsics.f(placement, "$placement");
        if (defaultAdLoader.getVungleApiClient().getRetryAfterHeaderValue(placement.getReferenceId()) > 0) {
            defaultAdLoader.onAdLoadFailed(new AdRetryError().setLogEntry$vungle_ads_release(defaultAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            return;
        }
        boolean z2 = false;
        if (response != null && !response.isSuccessful()) {
            z2 = true;
        }
        if (z2) {
            defaultAdLoader.onAdLoadFailed(new APIFailedStatusCodeError("ads API: " + response.code()).setLogEntry$vungle_ads_release(defaultAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            return;
        }
        AdPayload.AdUnit adUnit = null;
        if (response != null) {
            adPayload = (AdPayload) response.body();
        } else {
            adPayload = null;
        }
        if (adPayload != null) {
            adUnit = adPayload.adUnit();
        }
        if (adUnit == null) {
            defaultAdLoader.onAdLoadFailed(new AdResponseEmptyError("Ad response is empty").setLogEntry$vungle_ads_release(defaultAdLoader.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        } else {
            defaultAdLoader.handleAdMetaData$vungle_ads_release(adPayload, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.CONFIG_LOADED_FROM_AD_LOAD));
        }
    }

    public void onFailure(Call<AdPayload> call, Throwable th) {
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new e(this.this$0, th));
    }

    public void onResponse(Call<AdPayload> call, Response<AdPayload> response) {
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new d(this.this$0, this.$placement, response));
    }
}
