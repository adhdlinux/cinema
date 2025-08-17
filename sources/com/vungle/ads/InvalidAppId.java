package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class InvalidAppId extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidAppId(String str) {
        super(Sdk$SDKError.Reason.INVALID_APP_ID, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "msg");
    }
}
