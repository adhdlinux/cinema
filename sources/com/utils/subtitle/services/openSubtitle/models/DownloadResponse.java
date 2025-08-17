package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class DownloadResponse {
    private final String file_name;
    private String languageCode;
    private final String link;
    private final String message;
    private final int remaining;
    private final int requests;
    private final String reset_time;
    private final String reset_time_utc;

    public DownloadResponse(String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6) {
        Intrinsics.f(str, "file_name");
        Intrinsics.f(str2, "link");
        Intrinsics.f(str3, "message");
        Intrinsics.f(str4, "reset_time");
        Intrinsics.f(str5, "reset_time_utc");
        Intrinsics.f(str6, "languageCode");
        this.file_name = str;
        this.link = str2;
        this.message = str3;
        this.remaining = i2;
        this.requests = i3;
        this.reset_time = str4;
        this.reset_time_utc = str5;
        this.languageCode = str6;
    }

    public static /* synthetic */ DownloadResponse copy$default(DownloadResponse downloadResponse, String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, int i4, Object obj) {
        DownloadResponse downloadResponse2 = downloadResponse;
        int i5 = i4;
        return downloadResponse.copy((i5 & 1) != 0 ? downloadResponse2.file_name : str, (i5 & 2) != 0 ? downloadResponse2.link : str2, (i5 & 4) != 0 ? downloadResponse2.message : str3, (i5 & 8) != 0 ? downloadResponse2.remaining : i2, (i5 & 16) != 0 ? downloadResponse2.requests : i3, (i5 & 32) != 0 ? downloadResponse2.reset_time : str4, (i5 & 64) != 0 ? downloadResponse2.reset_time_utc : str5, (i5 & 128) != 0 ? downloadResponse2.languageCode : str6);
    }

    public final String component1() {
        return this.file_name;
    }

    public final String component2() {
        return this.link;
    }

    public final String component3() {
        return this.message;
    }

    public final int component4() {
        return this.remaining;
    }

    public final int component5() {
        return this.requests;
    }

    public final String component6() {
        return this.reset_time;
    }

    public final String component7() {
        return this.reset_time_utc;
    }

    public final String component8() {
        return this.languageCode;
    }

    public final DownloadResponse copy(String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6) {
        Intrinsics.f(str, "file_name");
        Intrinsics.f(str2, "link");
        Intrinsics.f(str3, "message");
        String str7 = str4;
        Intrinsics.f(str7, "reset_time");
        String str8 = str5;
        Intrinsics.f(str8, "reset_time_utc");
        String str9 = str6;
        Intrinsics.f(str9, "languageCode");
        return new DownloadResponse(str, str2, str3, i2, i3, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadResponse)) {
            return false;
        }
        DownloadResponse downloadResponse = (DownloadResponse) obj;
        return Intrinsics.a(this.file_name, downloadResponse.file_name) && Intrinsics.a(this.link, downloadResponse.link) && Intrinsics.a(this.message, downloadResponse.message) && this.remaining == downloadResponse.remaining && this.requests == downloadResponse.requests && Intrinsics.a(this.reset_time, downloadResponse.reset_time) && Intrinsics.a(this.reset_time_utc, downloadResponse.reset_time_utc) && Intrinsics.a(this.languageCode, downloadResponse.languageCode);
    }

    public final String getFile_name() {
        return this.file_name;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final String getLink() {
        return this.link;
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
        return (((((((((((((this.file_name.hashCode() * 31) + this.link.hashCode()) * 31) + this.message.hashCode()) * 31) + this.remaining) * 31) + this.requests) * 31) + this.reset_time.hashCode()) * 31) + this.reset_time_utc.hashCode()) * 31) + this.languageCode.hashCode();
    }

    public final void setLanguageCode(String str) {
        Intrinsics.f(str, "<set-?>");
        this.languageCode = str;
    }

    public String toString() {
        return "DownloadResponse(file_name=" + this.file_name + ", link=" + this.link + ", message=" + this.message + ", remaining=" + this.remaining + ", requests=" + this.requests + ", reset_time=" + this.reset_time + ", reset_time_utc=" + this.reset_time_utc + ", languageCode=" + this.languageCode + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadResponse(String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i2, i3, str4, str5, (i4 & 128) != 0 ? "en" : str6);
    }
}
