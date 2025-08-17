package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AssetRequestError extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssetRequestError(String str) {
        super(Sdk$SDKError.Reason.ASSET_REQUEST_ERROR, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "msg");
    }
}
