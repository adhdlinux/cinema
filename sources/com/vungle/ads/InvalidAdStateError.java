package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class InvalidAdStateError extends VungleError {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InvalidAdStateError(Sdk$SDKError.Reason reason, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reason, (i2 & 2) != 0 ? "Ad state is invalid" : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidAdStateError(Sdk$SDKError.Reason reason, String str) {
        super(reason, str, (DefaultConstructorMarker) null);
        Intrinsics.f(reason, "loggableReason");
        Intrinsics.f(str, "errorMessage");
    }
}
