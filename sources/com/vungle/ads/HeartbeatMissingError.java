package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class HeartbeatMissingError extends VungleError {
    public HeartbeatMissingError() {
        super(Sdk$SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT, "Ad closed without receiving heartbeat", (DefaultConstructorMarker) null);
    }
}
