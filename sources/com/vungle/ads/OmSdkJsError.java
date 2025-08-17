package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class OmSdkJsError extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OmSdkJsError(Sdk$SDKError.Reason reason, String str) {
        super(reason, str, (DefaultConstructorMarker) null);
        Intrinsics.f(reason, "reason");
        Intrinsics.f(str, "errorMessage");
    }
}
