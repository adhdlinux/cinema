package com.unity3d.services.core.extensions;

import kotlin.jvm.internal.Intrinsics;

public final class AbortRetryException extends Exception {
    private final String reason;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbortRetryException(String str) {
        super(str);
        Intrinsics.f(str, "reason");
        this.reason = str;
    }
}
