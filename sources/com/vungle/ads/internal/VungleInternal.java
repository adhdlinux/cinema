package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BidTokenCallback;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAds;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.executor.FutureResult;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import com.vungle.ads.internal.util.LogEntry;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

public final class VungleInternal {
    /* renamed from: getAvailableBidTokens$lambda-0  reason: not valid java name */
    private static final ConcurrencyTimeoutProvider m164getAvailableBidTokens$lambda0(Lazy<ConcurrencyTimeoutProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: getAvailableBidTokens$lambda-1  reason: not valid java name */
    private static final SDKExecutors m165getAvailableBidTokens$lambda1(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: getAvailableBidTokens$lambda-2  reason: not valid java name */
    private static final BidTokenEncoder m166getAvailableBidTokens$lambda2(Lazy<BidTokenEncoder> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getAvailableBidTokens$lambda-3  reason: not valid java name */
    public static final String m167getAvailableBidTokens$lambda3(Lazy lazy) {
        Intrinsics.f(lazy, "$bidTokenEncoder$delegate");
        return m166getAvailableBidTokens$lambda2(lazy).encode().getBidToken();
    }

    /* renamed from: getAvailableBidTokensAsync$lambda-4  reason: not valid java name */
    private static final BidTokenEncoder m168getAvailableBidTokensAsync$lambda4(Lazy<BidTokenEncoder> lazy) {
        return lazy.getValue();
    }

    /* renamed from: getAvailableBidTokensAsync$lambda-5  reason: not valid java name */
    private static final SDKExecutors m169getAvailableBidTokensAsync$lambda5(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getAvailableBidTokensAsync$lambda-6  reason: not valid java name */
    public static final void m170getAvailableBidTokensAsync$lambda6(BidTokenCallback bidTokenCallback, Lazy lazy) {
        boolean z2;
        Intrinsics.f(bidTokenCallback, "$callback");
        Intrinsics.f(lazy, "$bidTokenEncoder$delegate");
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        timeIntervalMetric.markStart();
        BidTokenEncoder.BiddingTokenInfo encode = m168getAvailableBidTokensAsync$lambda4(lazy).encode();
        timeIntervalMetric.markEnd();
        if (encode.getBidToken().length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            bidTokenCallback.onBidTokenCollected(encode.getBidToken());
        } else {
            timeIntervalMetric.setMetricType(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            timeIntervalMetric.setMeta(encode.getErrorMessage());
            bidTokenCallback.onBidTokenError(encode.getErrorMessage());
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, (LogEntry) null, (String) null, 6, (Object) null);
    }

    public final String getAvailableBidTokens(Context context) {
        boolean z2;
        Intrinsics.f(context, "context");
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        timeIntervalMetric.markStart();
        if (!VungleAds.Companion.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.e(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        Lazy a2 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInternal$getAvailableBidTokens$$inlined$inject$1(context));
        String str = (String) new FutureResult(m165getAvailableBidTokens$lambda1(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInternal$getAvailableBidTokens$$inlined$inject$2(context))).getApiExecutor().submit(new g(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInternal$getAvailableBidTokens$$inlined$inject$3(context))))).get(m164getAvailableBidTokens$lambda0(a2).getTimeout(), TimeUnit.MILLISECONDS);
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            timeIntervalMetric.setMetricType(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            timeIntervalMetric.setMeta("Bid token is null or empty");
        }
        timeIntervalMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, (LogEntry) null, (String) null, 6, (Object) null);
        return str;
    }

    public final void getAvailableBidTokensAsync(Context context, BidTokenCallback bidTokenCallback) {
        Intrinsics.f(context, "context");
        Intrinsics.f(bidTokenCallback, "callback");
        if (!VungleAds.Companion.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.e(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        m169getAvailableBidTokensAsync$lambda5(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInternal$getAvailableBidTokensAsync$$inlined$inject$2(context))).getApiExecutor().execute(new f(bidTokenCallback, LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInternal$getAvailableBidTokensAsync$$inlined$inject$1(context))));
    }

    public final String getSdkVersion() {
        return "7.4.3";
    }
}
