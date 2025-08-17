package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class SdkAlreadyInitialized extends VungleError {
    public SdkAlreadyInitialized() {
        super(Sdk$SDKError.Reason.ALREADY_INITIALIZED, "Config: Vungle SDK is already initialized", (DefaultConstructorMarker) null);
    }
}
