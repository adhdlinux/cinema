package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class MraidTemplateError extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MraidTemplateError(Sdk$SDKError.Reason reason, String str) {
        super(reason, str, (DefaultConstructorMarker) null);
        Intrinsics.f(reason, "loggableReason");
        Intrinsics.f(str, "message");
    }
}
