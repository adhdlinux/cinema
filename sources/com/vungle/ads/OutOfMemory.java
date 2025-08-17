package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class OutOfMemory extends VungleError {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutOfMemory(String str) {
        super(Sdk$SDKError.Reason.OUT_OF_MEMORY, str, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "errorMessage");
    }
}
