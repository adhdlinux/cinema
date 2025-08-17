package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class DownloadErrorBody {
    private final String message;
    private final int remaining;
    private final int requests;
    private final String reset_time;
    private final String reset_time_utc;

    public DownloadErrorBody(String str, int i2, int i3, String str2, String str3) {
        Intrinsics.f(str, "message");
        Intrinsics.f(str2, "reset_time");
        Intrinsics.f(str3, "reset_time_utc");
        this.message = str;
        this.remaining = i2;
        this.requests = i3;
        this.reset_time = str2;
        this.reset_time_utc = str3;
    }

    public static /* synthetic */ DownloadErrorBody copy$default(DownloadErrorBody downloadErrorBody, String str, int i2, int i3, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = downloadErrorBody.message;
        }
        if ((i4 & 2) != 0) {
            i2 = downloadErrorBody.remaining;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = downloadErrorBody.requests;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str2 = downloadErrorBody.reset_time;
        }
        String str4 = str2;
        if ((i4 & 16) != 0) {
            str3 = downloadErrorBody.reset_time_utc;
        }
        return downloadErrorBody.copy(str, i5, i6, str4, str3);
    }

    public final String component1() {
        return this.message;
    }

    public final int component2() {
        return this.remaining;
    }

    public final int component3() {
        return this.requests;
    }

    public final String component4() {
        return this.reset_time;
    }

    public final String component5() {
        return this.reset_time_utc;
    }

    public final DownloadErrorBody copy(String str, int i2, int i3, String str2, String str3) {
        Intrinsics.f(str, "message");
        Intrinsics.f(str2, "reset_time");
        Intrinsics.f(str3, "reset_time_utc");
        return new DownloadErrorBody(str, i2, i3, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadErrorBody)) {
            return false;
        }
        DownloadErrorBody downloadErrorBody = (DownloadErrorBody) obj;
        return Intrinsics.a(this.message, downloadErrorBody.message) && this.remaining == downloadErrorBody.remaining && this.requests == downloadErrorBody.requests && Intrinsics.a(this.reset_time, downloadErrorBody.reset_time) && Intrinsics.a(this.reset_time_utc, downloadErrorBody.reset_time_utc);
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getRemaining() {
        return this.remaining;
    }

    public final int getRequests() {
        return this.requests;
    }

    public final String getReset_time() {
        return this.reset_time;
    }

    public final String getReset_time_utc() {
        return this.reset_time_utc;
    }

    public int hashCode() {
        return (((((((this.message.hashCode() * 31) + this.remaining) * 31) + this.requests) * 31) + this.reset_time.hashCode()) * 31) + this.reset_time_utc.hashCode();
    }

    public String toString() {
        return "DownloadErrorBody(message=" + this.message + ", remaining=" + this.remaining + ", requests=" + this.requests + ", reset_time=" + this.reset_time + ", reset_time_utc=" + this.reset_time_utc + ')';
    }
}
