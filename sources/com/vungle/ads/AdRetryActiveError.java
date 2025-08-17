package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AdRetryActiveError extends VungleError {
    public AdRetryActiveError() {
        super(Sdk$SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER, "Ads: Server Retry Error active", (DefaultConstructorMarker) null);
    }
}
