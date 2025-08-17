package com.vungle.ads.internal.network;

import androidx.core.util.Consumer;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.UserAgentError;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;

public final class VungleApiClient$initUserAgentLazy$1 implements Consumer<String> {
    final /* synthetic */ TimeIntervalMetric $uaMetric;
    final /* synthetic */ VungleApiClient this$0;

    VungleApiClient$initUserAgentLazy$1(TimeIntervalMetric timeIntervalMetric, VungleApiClient vungleApiClient) {
        this.$uaMetric = timeIntervalMetric;
        this.this$0 = vungleApiClient;
    }

    public void accept(String str) {
        if (str == null) {
            Logger.Companion.e("VungleApiClient", "Cannot Get UserAgent. Setting Default Device UserAgent");
            new UserAgentError().logErrorNoReturnValue$vungle_ads_release();
            return;
        }
        this.$uaMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.$uaMetric, (LogEntry) null, (String) null, 6, (Object) null);
        this.this$0.uaString = str;
    }
}
