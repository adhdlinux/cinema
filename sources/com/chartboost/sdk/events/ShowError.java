package com.chartboost.sdk.events;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ShowError implements CBError {
    private final Code code;
    private final Exception exception;

    public enum Code {
        INTERNAL(0),
        SESSION_NOT_STARTED(7),
        AD_ALREADY_VISIBLE(8),
        INTERNET_UNAVAILABLE(25),
        PRESENTATION_FAILURE(33),
        NO_CACHED_AD(34),
        BANNER_DISABLED(36),
        BANNER_VIEW_IS_DETACHED(37);
        
        private final int errorCode;

        private Code(int i2) {
            this.errorCode = i2;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public ShowError(Code code2, Exception exc) {
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
        return "Chartboost ShowError: " + this.code.name() + " with exception " + getException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShowError(Code code2, Exception exc, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(code2, (i2 & 2) != 0 ? null : exc);
    }
}
