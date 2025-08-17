package com.chartboost.sdk.events;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class StartError implements CBError {
    private final Code code;
    private final Exception exception;

    public enum Code {
        INVALID_CREDENTIALS(0),
        NETWORK_FAILURE(1),
        SERVER_ERROR(2),
        INTERNAL(3);
        
        private final int errorCode;

        private Code(int i2) {
            this.errorCode = i2;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public StartError(Code code2, Exception exc) {
        Intrinsics.f(code2, "code");
        this.code = code2;
        this.exception = exc;
    }

    public final Code getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public String toString() {
        return "Chartboost StartError: " + this.code.name() + " with exception " + getException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StartError(Code code2, Exception exc, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(code2, (i2 & 2) != 0 ? null : exc);
    }
}
