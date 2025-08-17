package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.LogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class VungleError extends Exception {
    private final int code;
    private final String errorMessage;
    private LogEntry logEntry;
    private final Sdk$SDKError.Reason loggableReason;

    private VungleError(Sdk$SDKError.Reason reason, String str) {
        super(str);
        this.loggableReason = reason;
        this.errorMessage = str;
        this.code = reason.getNumber();
    }

    public /* synthetic */ VungleError(Sdk$SDKError.Reason reason, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(reason, str);
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.a(cls2, cls)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.vungle.ads.VungleError");
        VungleError vungleError = (VungleError) obj;
        if (this.loggableReason == vungleError.loggableReason && Intrinsics.a(this.errorMessage, vungleError.errorMessage) && Intrinsics.a(this.logEntry, vungleError.logEntry)) {
            return true;
        }
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public String getLocalizedMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        int i2;
        int hashCode = ((this.loggableReason.hashCode() * 31) + this.errorMessage.hashCode()) * 31;
        LogEntry logEntry2 = this.logEntry;
        if (logEntry2 != null) {
            i2 = logEntry2.hashCode();
        } else {
            i2 = 0;
        }
        return hashCode + i2;
    }

    public final VungleError logError$vungle_ads_release() {
        logErrorNoReturnValue$vungle_ads_release();
        return this;
    }

    public final void logErrorNoReturnValue$vungle_ads_release() {
        AnalyticsClient.INSTANCE.logError$vungle_ads_release(this.loggableReason, this.errorMessage, this.logEntry);
    }

    public final VungleError setLogEntry$vungle_ads_release(LogEntry logEntry2) {
        this.logEntry = logEntry2;
        return this;
    }
}
