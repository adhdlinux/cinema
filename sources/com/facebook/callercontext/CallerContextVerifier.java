package com.facebook.callercontext;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface CallerContextVerifier {
    void verifyCallerContext(Object obj, boolean z2);
}
