package com.vungle.ads.internal.load;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.MraidJsError;
import com.vungle.ads.internal.load.MraidJsLoader;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;

public final class BaseAdLoader$handleAdMetaData$3 implements MraidJsLoader.DownloadResultListener {
    final /* synthetic */ BaseAdLoader this$0;

    BaseAdLoader$handleAdMetaData$3(BaseAdLoader baseAdLoader) {
        this.this$0 = baseAdLoader;
    }

    public void onDownloadResult(int i2) {
        if (i2 == 10 || i2 == 13) {
            if (i2 == 10) {
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk$SDKMetric.SDKMetricType.MRAID_DOWNLOAD_JS_RETRY_SUCCESS, 0, this.this$0.getLogEntry$vungle_ads_release(), (String) null, 10, (Object) null);
            }
            this.this$0.downloadAssets();
            return;
        }
        AdLoaderCallback access$getAdLoaderCallback$p = this.this$0.adLoaderCallback;
        if (access$getAdLoaderCallback$p != null) {
            access$getAdLoaderCallback$p.onFailure(new MraidJsError(Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR, "Failed to download mraid.js."));
        }
    }
}
