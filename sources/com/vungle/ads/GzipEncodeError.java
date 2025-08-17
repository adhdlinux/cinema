package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class GzipEncodeError extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GzipEncodeError(String str) {
        super(Sdk$SDKError.Reason.GZIP_ENCODE_ERROR, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "msg");
    }
}
