package com.vungle.ads;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;

public final class AnalyticsClient$flushErrors$1 implements AnalyticsClient.RequestListener {
    final /* synthetic */ BlockingQueue<Sdk$SDKError.Builder> $currentSendingErrors;

    AnalyticsClient$flushErrors$1(BlockingQueue<Sdk$SDKError.Builder> blockingQueue) {
        this.$currentSendingErrors = blockingQueue;
    }

    public void onFailure() {
        Logger.Companion companion = Logger.Companion;
        companion.d("AnalyticsClient", "Failed to send " + this.$currentSendingErrors.size() + " errors");
        AnalyticsClient.INSTANCE.getErrors$vungle_ads_release().addAll(this.$currentSendingErrors);
    }

    public void onSuccess() {
        Logger.Companion companion = Logger.Companion;
        companion.d("AnalyticsClient", "Sent " + this.$currentSendingErrors.size() + " errors");
    }
}
