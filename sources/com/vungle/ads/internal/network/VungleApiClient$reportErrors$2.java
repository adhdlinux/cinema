package com.vungle.ads.internal.network;

import com.vungle.ads.AnalyticsClient;

public final class VungleApiClient$reportErrors$2 implements Callback<Void> {
    final /* synthetic */ AnalyticsClient.RequestListener $requestListener;

    VungleApiClient$reportErrors$2(AnalyticsClient.RequestListener requestListener) {
        this.$requestListener = requestListener;
    }

    public void onFailure(Call<Void> call, Throwable th) {
        this.$requestListener.onFailure();
    }

    public void onResponse(Call<Void> call, Response<Void> response) {
        this.$requestListener.onSuccess();
    }
}
