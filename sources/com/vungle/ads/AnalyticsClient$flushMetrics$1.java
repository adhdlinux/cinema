package com.vungle.ads;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;

public final class AnalyticsClient$flushMetrics$1 implements AnalyticsClient.RequestListener {
    final /* synthetic */ BlockingQueue<Sdk$SDKMetric.Builder> $currentSendingMetrics;

    AnalyticsClient$flushMetrics$1(BlockingQueue<Sdk$SDKMetric.Builder> blockingQueue) {
        this.$currentSendingMetrics = blockingQueue;
    }

    public void onFailure() {
        Logger.Companion companion = Logger.Companion;
        companion.d("AnalyticsClient", "Failed to send " + this.$currentSendingMetrics.size() + " metrics");
        AnalyticsClient.INSTANCE.getMetrics$vungle_ads_release().addAll(this.$currentSendingMetrics);
    }

    public void onSuccess() {
        Logger.Companion companion = Logger.Companion;
        companion.d("AnalyticsClient", "Sent " + this.$currentSendingMetrics.size() + " metrics");
    }
}
