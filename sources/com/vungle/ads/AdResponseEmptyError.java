package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AdResponseEmptyError extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdResponseEmptyError(String str) {
        super(Sdk$SDKError.Reason.AD_RESPONSE_EMPTY, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "message");
    }
}
