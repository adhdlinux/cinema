package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ConcurrentPlaybackUnsupported extends VungleError {
    public ConcurrentPlaybackUnsupported() {
        super(Sdk$SDKError.Reason.CONCURRENT_PLAYBACK_UNSUPPORTED, "Concurrent playback not supported", (DefaultConstructorMarker) null);
    }
}
