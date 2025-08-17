package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class NoSpaceError extends VungleError {
    public NoSpaceError() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoSpaceError(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "No space left on device" : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoSpaceError(String str) {
        super(Sdk$SDKError.Reason.ASSET_FAILED_INSUFFICIENT_SPACE, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "msg");
    }
}
