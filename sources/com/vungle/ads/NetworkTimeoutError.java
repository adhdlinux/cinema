package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class NetworkTimeoutError extends VungleError {
    public NetworkTimeoutError() {
        super(Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT, "Ads: Network Timeout", (DefaultConstructorMarker) null);
    }
}
