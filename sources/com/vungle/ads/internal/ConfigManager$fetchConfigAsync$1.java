package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.APIFailedStatusCodeError;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.LogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ConfigManager$fetchConfigAsync$1 implements Callback<ConfigPayload> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TimeIntervalMetric $initRequestToResponseMetric;
    final /* synthetic */ Function1<Boolean, Unit> $onComplete;

    ConfigManager$fetchConfigAsync$1(TimeIntervalMetric timeIntervalMetric, Context context, Function1<? super Boolean, Unit> function1) {
        this.$initRequestToResponseMetric = timeIntervalMetric;
        this.$context = context;
        this.$onComplete = function1;
    }

    public void onFailure(Call<ConfigPayload> call, Throwable th) {
        String str;
        this.$initRequestToResponseMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.$initRequestToResponseMetric, (LogEntry) null, VungleApiClient.Companion.getBASE_URL$vungle_ads_release(), 2, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("Error while fetching config: ");
        if (th != null) {
            str = th.getMessage();
        } else {
            str = null;
        }
        sb.append(str);
        new NetworkUnreachable(sb.toString()).logErrorNoReturnValue$vungle_ads_release();
        this.$onComplete.invoke(Boolean.FALSE);
    }

    public void onResponse(Call<ConfigPayload> call, Response<ConfigPayload> response) {
        Integer num;
        this.$initRequestToResponseMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.$initRequestToResponseMetric, (LogEntry) null, VungleApiClient.Companion.getBASE_URL$vungle_ads_release(), 2, (Object) null);
        if (response == null || !response.isSuccessful() || response.body() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("config API: ");
            if (response != null) {
                num = Integer.valueOf(response.code());
            } else {
                num = null;
            }
            sb.append(num);
            new APIFailedStatusCodeError(sb.toString()).logErrorNoReturnValue$vungle_ads_release();
            return;
        }
        SingleValueMetric singleValueMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.CONFIG_LOADED_FROM_INIT);
        ConfigManager.INSTANCE.initWithConfig$vungle_ads_release(this.$context, response.body(), false, singleValueMetric);
        this.$onComplete.invoke(Boolean.TRUE);
    }
}
