package com.vungle.ads.internal.model;

import com.google.android.gms.cast.MediaTrack;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ErrorInfo {
    private final String description;
    private final boolean errorIsTerminal;
    private final Sdk$SDKError.Reason reason;

    public ErrorInfo(Sdk$SDKError.Reason reason2, String str, boolean z2) {
        Intrinsics.f(reason2, "reason");
        Intrinsics.f(str, MediaTrack.ROLE_DESCRIPTION);
        this.reason = reason2;
        this.description = str;
        this.errorIsTerminal = z2;
    }

    public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, Sdk$SDKError.Reason reason2, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            reason2 = errorInfo.reason;
        }
        if ((i2 & 2) != 0) {
            str = errorInfo.description;
        }
        if ((i2 & 4) != 0) {
            z2 = errorInfo.errorIsTerminal;
        }
        return errorInfo.copy(reason2, str, z2);
    }

    public final Sdk$SDKError.Reason component1() {
        return this.reason;
    }

    public final String component2() {
        return this.description;
    }

    public final boolean component3() {
        return this.errorIsTerminal;
    }

    public final ErrorInfo copy(Sdk$SDKError.Reason reason2, String str, boolean z2) {
        Intrinsics.f(reason2, "reason");
        Intrinsics.f(str, MediaTrack.ROLE_DESCRIPTION);
        return new ErrorInfo(reason2, str, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) obj;
        return this.reason == errorInfo.reason && Intrinsics.a(this.description, errorInfo.description) && this.errorIsTerminal == errorInfo.errorIsTerminal;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }

    public final Sdk$SDKError.Reason getReason() {
        return this.reason;
    }

    public int hashCode() {
        int hashCode = ((this.reason.hashCode() * 31) + this.description.hashCode()) * 31;
        boolean z2 = this.errorIsTerminal;
        if (z2) {
            z2 = true;
        }
        return hashCode + (z2 ? 1 : 0);
    }

    public String toString() {
        return "ErrorInfo(reason=" + this.reason + ", description=" + this.description + ", errorIsTerminal=" + this.errorIsTerminal + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorInfo(Sdk$SDKError.Reason reason2, String str, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reason2, str, (i2 & 4) != 0 ? false : z2);
    }
}
