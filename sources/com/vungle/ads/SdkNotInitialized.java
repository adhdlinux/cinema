package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class SdkNotInitialized extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SdkNotInitialized(String str) {
        super(Sdk$SDKError.Reason.SDK_NOT_INITIALIZED, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "message");
    }
}
