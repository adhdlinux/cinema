package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AdExpiredOnPlayError extends VungleError {
    public AdExpiredOnPlayError() {
        super(Sdk$SDKError.Reason.AD_EXPIRED_ON_PLAY, "Ad expired upon playback request", (DefaultConstructorMarker) null);
    }
}
