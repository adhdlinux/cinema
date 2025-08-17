package com.vungle.ads.internal.bidding;

import android.content.Context;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.GzipEncodeError;
import com.vungle.ads.JsonEncodeError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.RtbRequest;
import com.vungle.ads.internal.model.RtbToken;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.InputOutputUtils;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

public final class BidTokenEncoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BidTokenEncoder";
    public static final int TOKEN_VERSION = 6;
    private SingleValueMetric bidTokenRequestedMetric = new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.BID_TOKEN_REQUESTED);
    private final Context context;
    private long enterBackgroundTime;
    private final Json json = JsonKt.b((Json) null, BidTokenEncoder$json$1.INSTANCE, 1, (Object) null);
    private int ordinalView;

    public static final class BiddingTokenInfo {
        private final String bidToken;
        private final String errorMessage;

        public BiddingTokenInfo(String str, String str2) {
            Intrinsics.f(str, "bidToken");
            Intrinsics.f(str2, "errorMessage");
            this.bidToken = str;
            this.errorMessage = str2;
        }

        public static /* synthetic */ BiddingTokenInfo copy$default(BiddingTokenInfo biddingTokenInfo, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = biddingTokenInfo.bidToken;
            }
            if ((i2 & 2) != 0) {
                str2 = biddingTokenInfo.errorMessage;
            }
            return biddingTokenInfo.copy(str, str2);
        }

        public final String component1() {
            return this.bidToken;
        }

        public final String component2() {
            return this.errorMessage;
        }

        public final BiddingTokenInfo copy(String str, String str2) {
            Intrinsics.f(str, "bidToken");
            Intrinsics.f(str2, "errorMessage");
            return new BiddingTokenInfo(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BiddingTokenInfo)) {
                return false;
            }
            BiddingTokenInfo biddingTokenInfo = (BiddingTokenInfo) obj;
            return Intrinsics.a(this.bidToken, biddingTokenInfo.bidToken) && Intrinsics.a(this.errorMessage, biddingTokenInfo.errorMessage);
        }

        public final String getBidToken() {
            return this.bidToken;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return (this.bidToken.hashCode() * 31) + this.errorMessage.hashCode();
        }

        public String toString() {
            return "BiddingTokenInfo(bidToken=" + this.bidToken + ", errorMessage=" + this.errorMessage + ')';
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BidTokenEncoder(Context context2) {
        Intrinsics.f(context2, "context");
        this.context = context2;
        ActivityManager.Companion.addLifecycleListener(new ActivityManager.LifeCycleCallback(this) {
            final /* synthetic */ BidTokenEncoder this$0;

            {
                this.this$0 = r1;
            }

            public void onBackground() {
                this.this$0.onPause$vungle_ads_release();
            }

            public void onForeground() {
                this.this$0.onResume$vungle_ads_release();
            }
        });
    }

    /* renamed from: constructV6Token$lambda-0  reason: not valid java name */
    private static final VungleApiClient m171constructV6Token$lambda0(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    private final BiddingTokenInfo generateBidToken() {
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.bidTokenRequestedMetric, (LogEntry) null, (String) null, 6, (Object) null);
        try {
            String constructV6Token$vungle_ads_release = constructV6Token$vungle_ads_release();
            Logger.Companion companion = Logger.Companion;
            companion.d(TAG, "BidToken: " + constructV6Token$vungle_ads_release);
            try {
                String str = "6:" + InputOutputUtils.INSTANCE.convertForSending(constructV6Token$vungle_ads_release);
                companion.d(TAG, "After conversion: " + str);
                return new BiddingTokenInfo(str, "");
            } catch (Exception e2) {
                String str2 = "Fail to gzip token data. " + e2.getLocalizedMessage();
                new GzipEncodeError(str2).logErrorNoReturnValue$vungle_ads_release();
                return new BiddingTokenInfo("", str2);
            }
        } catch (Exception e3) {
            String str3 = "Failed to encode TokenParameters. " + e3.getLocalizedMessage();
            new JsonEncodeError(str3).logErrorNoReturnValue$vungle_ads_release();
            return new BiddingTokenInfo("", str3);
        }
    }

    public static /* synthetic */ void getEnterBackgroundTime$vungle_ads_release$annotations() {
    }

    private static /* synthetic */ void getJson$annotations() {
    }

    public static /* synthetic */ void getOrdinalView$vungle_ads_release$annotations() {
    }

    public final String constructV6Token$vungle_ads_release() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        VungleApiClient r02 = m171constructV6Token$lambda0(LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new BidTokenEncoder$constructV6Token$$inlined$inject$1(this.context)));
        ConfigManager configManager = ConfigManager.INSTANCE;
        CommonRequestBody requestBody = r02.requestBody(!configManager.signalsDisabled(), configManager.fpdEnabled());
        RtbToken rtbToken = new RtbToken(requestBody.getDevice(), requestBody.getUser(), requestBody.getExt(), new RtbRequest(VungleHeader.INSTANCE.getHeaderUa()), this.ordinalView);
        Json json2 = this.json;
        KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(RtbToken.class));
        Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return json2.c(b2, rtbToken);
    }

    public final BiddingTokenInfo encode() {
        this.ordinalView++;
        return generateBidToken();
    }

    public final long getEnterBackgroundTime$vungle_ads_release() {
        return this.enterBackgroundTime;
    }

    public final int getOrdinalView$vungle_ads_release() {
        return this.ordinalView;
    }

    public final void onPause$vungle_ads_release() {
        Logger.Companion.d(TAG, "BidTokenEncoder#onBackground()");
        this.enterBackgroundTime = System.currentTimeMillis();
    }

    public final void onResume$vungle_ads_release() {
        Logger.Companion.d(TAG, "BidTokenEncoder#onForeground()");
        if (System.currentTimeMillis() > this.enterBackgroundTime + ConfigManager.INSTANCE.getSessionTimeout()) {
            this.ordinalView = 0;
            this.enterBackgroundTime = 0;
        }
    }

    public final void setEnterBackgroundTime$vungle_ads_release(long j2) {
        this.enterBackgroundTime = j2;
    }

    public final void setOrdinalView$vungle_ads_release(int i2) {
        this.ordinalView = i2;
    }
}
